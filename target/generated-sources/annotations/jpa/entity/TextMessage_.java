package jpa.entity;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.5.v20191016-rNA", date="2020-02-08T08:21:37")
@StaticMetamodel(TextMessage.class)
public class TextMessage_ extends BaseIdentify_ {

    public static volatile SingularAttribute<TextMessage, String> author;
    public static volatile SingularAttribute<TextMessage, String> text;
    public static volatile SingularAttribute<TextMessage, Calendar> sent;

}