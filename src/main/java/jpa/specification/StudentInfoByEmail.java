package jpa.specification;

import jpa.entity.Student;
import jpa.entity.Student_;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class StudentInfoByEmail implements Specification<Student> {
    private String email;

    public StudentInfoByEmail(String email) {
        this.email = email;
    }

    @Override
    public Predicate toPredicate(Root<Student> studentRoot, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.equal(studentRoot.get(Student_.email), email);
    }
}
