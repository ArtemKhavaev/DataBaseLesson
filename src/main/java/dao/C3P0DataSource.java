package dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0DataSource {
    private static ComboPooledDataSource cpds = new ComboPooledDataSource();
    static{
        try {
            cpds.setDriverClass("org.postgresql.Driver");//аналог Class.forName();
            cpds.setJdbcUrl("jdbc:postgresql://localhost:5432/ARR");// строка подключения к бд
            cpds.setUser("Art"); // логин
            cpds.setPassword("Artem1981@");// пароль

            cpds.setInitialPoolSize(4);// задать количество соединений (3 default)
            cpds.setMinPoolSize(2);// минимальное значение соединений (1 по умолчанию)
            cpds.setMaxPoolSize(8);// максимальное кол-во соединений (10 по умолчанию)

        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

    }
    public static Connection getConnection() throws SQLException {
        return cpds.getConnection();// возвращает соединение из пула

    }
}
