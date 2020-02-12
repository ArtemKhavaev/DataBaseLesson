package jpa.tst;

import jpa.entity.Contact;
import jpa.entity.Group;
import jpa.entity.Student;
import jpa.repository.GroupRepository;
import jpa.repository.StudentRepository;
import jpa.specification.StudentWithoutContact;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TstRepository {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("ormLesson");
        EntityManager manager = factory.createEntityManager();

        GroupRepository groupRepository = new GroupRepository(manager);
        StudentRepository studentRepository = new StudentRepository(manager);

        Group jjd = new Group("JJD", 3, 20000);
        Group python = new Group("Python", 2, 15000);
        Group nodeJS = new Group("Node JS", 3, 15000);
        Group web = new Group("Web Developer", 4, 25000);

        manager.getTransaction().begin();
        groupRepository.add(jjd);
        groupRepository.add(python);
        groupRepository.add(nodeJS);
        groupRepository.add(web);
        manager.getTransaction().commit();

        Student ivan = new Student("ivan@mail.ru");
        Student oleg = new Student("oleg@mail.ru");
        Student misha = new Student("misha@mail.ru");

        Contact ivanContact = new Contact("Ivan", 16);
        Contact olegContact = new Contact("Oleg", 27);

        ivanContact.setStudent(ivan);
        olegContact.setStudent(oleg);

        ivan.setContact(ivanContact);
        oleg.setContact(olegContact);

        manager.getTransaction().begin();
        studentRepository.add(ivan);
        studentRepository.add(oleg);
        studentRepository.add(misha);
        manager.getTransaction().commit();

        ivan.getGroups().add(jjd);
        ivan.getGroups().add(python);
        oleg.getGroups().add(python);
        oleg.getGroups().add(nodeJS);
        misha.getGroups().add(jjd);

        jjd.getStudents().add(ivan);
        jjd.getStudents().add(misha);
        python.getStudents().add(ivan);
        python.getStudents().add(oleg);
        nodeJS.getStudents().add(oleg);

        manager.getTransaction().begin();
        studentRepository.update(ivan);
        studentRepository.update(oleg);
        studentRepository.update(misha);
        manager.getTransaction().commit();


        System.out.println("получение всех групп");
        List<Group> groupList = groupRepository.getAll();
        for (Group group: groupList){
            System.out.println(group.getGroupName());
        }

        Group groupByName = groupRepository.getGroupByName("JJD");
        System.out.println("groupByName: " + groupByName.getDuration());

        System.out.println(groupRepository.studentsCount("JJD"));

        System.out.println("Студенты без контактной информации");
        List<Student> nullContacts = studentRepository.getBySpecification(new StudentWithoutContact());
        for (Student student: nullContacts) {
            System.out.println(student.getEmail());
        }

        manager.close();
        factory.close();
    }
}