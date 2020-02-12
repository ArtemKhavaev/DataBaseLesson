package jpa.specification;

import jpa.entity.Group;
import jpa.entity.Group_;
import jpa.entity.Student;

import javax.persistence.criteria.*;

public class GroupByAge implements Specification<Group> {
    private int age;

    public GroupByAge(int age) {
        this.age = age;
    }

    @Override
    public Predicate toPredicate(Root<Group> groupRoot, CriteriaBuilder criteriaBuilder) {
        Join<Group, Student> groupStudent = groupRoot.join(Group_.students, JoinType.LEFT);
        return criteriaBuilder.lessThan(groupStudent.get(Student), age);
    }
}
