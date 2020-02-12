package jpa.specification;

import jpa.entity.Contact;
import jpa.entity.Student;
import jpa.entity.Student_;

import javax.persistence.criteria.*;

public class StudentWithoutContact implements Specification<Student> {
    @Override
    public Predicate toPredicate(Root<Student> studentRoot, CriteriaBuilder criteriaBuilder) {
        //"SELECT * FROM student LEFT JOIN contact ON..." + "WHERE student.id IS NULL"
        Join<Student, Contact> studentContact = studentRoot.join(Student_.contact, JoinType.LEFT);
        return criteriaBuilder.isNull(studentContact.get("id"));
    }
}
