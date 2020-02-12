package base;//package base;



import java.sql.*;

public class JDBCLesson {
    static String conStr = "jdbc:postgresql://localhost:5432/ARR";
    static String login = "Art";
    static String pwd = "Artem1981@";

    public static void main(String[] args) {
        try {
            createTable();
            insertIntoBook("Книга", 45);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTable() throws ClassNotFoundException, SQLException {
        String create = "CREATE TABLE IF NOT EXISTS book(" +
                "id SERIAL PRIMARY KEY," +
                "title VARCHAR(50) NOT NULL," +
                "pageCount INTEGER NOT NULL);";
        // регистрация драйвера
        Class.forName("org.postgresql.Driver");
        try (Connection connection = DriverManager.getConnection(conStr, login, pwd)){
            try (Statement statement = connection.createStatement()){
                int result = statement.executeUpdate(create);
                System.out.println(result);
            }
        }
    }

    public static void insertIntoBook(String title, int pageCount) throws ClassNotFoundException, SQLException {
        String insert = "INSERT INTO book (title, pageCount) VALUES (?, ?);";
        String delete = "DELETE * FROM book WHERE id = ?;";
        Class.forName("org.postgresql.Driver");
        try (Connection connection =
                     DriverManager.getConnection(conStr, login, pwd)) {
            try(PreparedStatement ps = connection.prepareStatement(insert)){
                ps.setString(1, title);
                ps.setInt(2, pageCount);
                int result = ps.executeUpdate();
//                int result = ps.execute();
                System.out.println(result);
            }
        }
    }

    public static void getAllBooks() throws ClassNotFoundException, SQLException {
        String selectAll = "SELECT * FROM book;";

        Class.forName("org.postgresql.Driver");
        try (Connection connection =
                     DriverManager.getConnection(conStr, login, pwd)){
            try(Statement statement = connection.createStatement()){
                ResultSet resultSet = statement.executeQuery(selectAll);
                while (resultSet.next()){
                    String title = resultSet.getString("title");
                    int pageCount = resultSet.getInt("pageCount");
                    System.out.println("title = " + title);
                    System.out.println("pageCount = " + pageCount);
                }
            }
        }

    }

}
