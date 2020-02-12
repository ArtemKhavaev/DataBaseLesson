package jpa.specification;

import jpa.entity.Group_;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class GroupByDuration implements Specification {
    private int duration;

    public GroupByDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public Predicate toPredicate(Root groupRoot, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.greaterThanOrEqualTo(groupRoot.get(Group_.duration), duration);
    }
}
