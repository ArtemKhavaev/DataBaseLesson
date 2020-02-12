package jpa.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.entity.Student;

@Generated(value="EclipseLink-2.7.5.v20191016-rNA", date="2020-02-08T08:21:37")
@StaticMetamodel(Group.class)
public class Group_ extends BaseIdentify_ {

    public static volatile SingularAttribute<Group, Integer> duration;
    public static volatile SingularAttribute<Group, String> groupName;
    public static volatile SingularAttribute<Group, Integer> price;
    public static volatile ListAttribute<Group, Student> students;

}