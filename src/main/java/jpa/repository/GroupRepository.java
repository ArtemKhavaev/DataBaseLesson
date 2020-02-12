package jpa.repository;

import jpa.entity.Group;
import jpa.entity.Group_;
import jpa.entity.Student;
import jpa.specification.Specification;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

public class GroupRepository implements Repository<Group, Integer> {
    private EntityManager manager;

    public GroupRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void add(Group group) {
        manager.persist(group); // добавление записи в таблицу
    }

    @Override
    public void update(Group group) {
        manager.merge(group); // обновление существующей записи
    }

    @Override
    public void delete(Integer integer) {
        manager.getTransaction().begin();
        Group group = getByPk(integer);
        manager.remove(group); // удаление объекта
        manager.getTransaction().commit();
    }

    @Override
    public Group getByPk(Integer integer) {
        // получение записи по первичному ключу
        return manager.find(Group.class, integer);
    }

    @Override
    public List<Group> getAll() {
        /*1. named queries*/
        /*TypedQuery<Group> query =
                manager.createNamedQuery("Group.getAll", Group.class);
        List<Group> groups = query.getResultList();*/

        /*2. JPQL */
        /*Query query = manager.createQuery("SELECT g FROM Group g");
        List<Group> groups = (List<Group>) query.getResultList();*/

        /*3. Criteria API*/
        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<Group> criteriaQuery =
                criteriaBuilder.createQuery(Group.class);
        Root<Group> root = criteriaQuery.from(Group.class); // from Group
        criteriaQuery.select(root);

        TypedQuery<Group> typedQuery = manager.createQuery(criteriaQuery);
        List<Group> groups = typedQuery.getResultList();

        return groups;
    }

    public Group getGroupByName(String groupName){
        /*1. named query*/
       /* TypedQuery<Group> query =
                manager.createNamedQuery("Group.findByNAme", Group.class);
        query.setParameter("groupName", groupName);
        Group group = query.getSingleResult();*/

        /*2. JPQL */
       /* TypedQuery<Group> query = manager.createQuery(
             "SELECT g FROM Group g WHERE g.groupName = :groupName",
               Group.class);
        query.setParameter("groupName", groupName);
        Group group = query.getSingleResult();*/

        /*Criteria API*/
        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<Group> criteriaQuery =
                criteriaBuilder.createQuery(Group.class);
        // блок from
        Root<Group> root = criteriaQuery.from(Group.class);
        // блок where
        Predicate condition =
                criteriaBuilder.equal(root.get(Group_.groupName), groupName);

        criteriaQuery.select(root).where(condition);

        TypedQuery<Group> query = manager.createQuery(criteriaQuery);
        Group group = query.getSingleResult();

        return group;
    }

    // количество студентов в группе
    public long studentsCount(String groupName){
        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery =
                criteriaBuilder.createQuery(Long.class);

        Root<Group> root = criteriaQuery.from(Group.class);

        Join<Group, Student> groupStudent = root.join(Group_.students);

        Predicate condition =
                criteriaBuilder.equal(root.get(Group_.groupName), groupName);

        criteriaQuery.select(criteriaBuilder.count(groupStudent))
                .where(condition)
                .groupBy(root.get("id")); // Group_.id

        return manager.createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    public List<Group> getBySpecification(Specification specification) {

        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<Group> criteriaQuery = criteriaBuilder.createQuery(Group.class);
        Root<Group> root = criteriaQuery.from(Group.class);
        Predicate condition = specification.toPredicate(root, criteriaBuilder);
        criteriaQuery.where(condition);
        return manager.createQuery(criteriaQuery).getResultList();

    }
}