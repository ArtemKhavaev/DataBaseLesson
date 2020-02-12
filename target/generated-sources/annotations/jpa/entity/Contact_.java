package jpa.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.entity.Student;

@Generated(value="EclipseLink-2.7.5.v20191016-rNA", date="2020-02-08T08:21:37")
@StaticMetamodel(Contact.class)
public class Contact_ extends BaseIdentify_ {

    public static volatile SingularAttribute<Contact, Student> student;
    public static volatile SingularAttribute<Contact, String> name;
    public static volatile SingularAttribute<Contact, Integer> age;

}