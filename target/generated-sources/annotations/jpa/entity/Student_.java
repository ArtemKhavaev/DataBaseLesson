package jpa.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.entity.Contact;
import jpa.entity.Group;

@Generated(value="EclipseLink-2.7.5.v20191016-rNA", date="2020-02-08T08:21:37")
@StaticMetamodel(Student.class)
public class Student_ extends BaseIdentify_ {

    public static volatile SingularAttribute<Student, Contact> contact;
    public static volatile ListAttribute<Student, Group> groups;
    public static volatile SingularAttribute<Student, String> email;

}