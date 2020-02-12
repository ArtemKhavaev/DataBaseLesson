package jpa.tst;

import jpa.entity.TextMessage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.GregorianCalendar;

public class TstMessage {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("ormLesson");
        EntityManager manager = factory.createEntityManager();


        manager.getTransaction().begin();

        // получение
        TextMessage textMessage = new TextMessage();
        textMessage.setAuthor("author");
        textMessage.setText("some text");
        textMessage.setSent(new GregorianCalendar());

        manager.persist(textMessage);

        manager.getTransaction().commit();

        // получение сообщения
        TextMessage messageFromDB = manager.find(TextMessage.class, 1);
        System.out.println(messageFromDB);

        manager.close();
        factory.close();

    }
}