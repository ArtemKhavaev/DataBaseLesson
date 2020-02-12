package jpa.specification;

import jpa.entity.Group;
import jpa.entity.Group_;
import jpa.entity.Student;

import javax.persistence.criteria.*;

public class GroupWithoutStudent implements Specification<Group> {
    @Override
    public Predicate toPredicate (Root <Group> groupRoot, CriteriaBuilder criteriaBuilder) {
        // группы в которых нет студентов
        //"SELECT * FROM group LEFT JOIN student ON.." + "WHERE student.id IS NULL"

        Join<Group, Student> groupStudent = groupRoot.join(Group_.students, JoinType.LEFT);
        return criteriaBuilder.isNull(groupStudent.get("id"));
    }


}
