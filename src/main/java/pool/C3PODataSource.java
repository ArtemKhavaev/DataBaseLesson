
package pool;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class C3PODataSource {
    private static ComboPooledDataSource cpds = new ComboPooledDataSource();

    static {
        try {
            cpds.setDriverClass("org.postgresql.Driver"); // Class.forName("org.postgresql.Driver");
            cpds.setJdbcUrl("jdbc:postgresql://localhost:5432/ARR"); // строка подключения к бд
            cpds.setUser("Art"); // логин пользователя от бд
            cpds.setPassword("Artem1981@"); // пароль пользователя от бд

            cpds.setInitialPoolSize(4); // default 3
            cpds.setMinPoolSize(2); // default 1
            cpds.setMaxPoolSize(8); // default 10
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return cpds.getConnection(); // возвращает соединение из пула
    }
}
