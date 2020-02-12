package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class BookDao implements Dao<Book, Integer> {



    @Override
    public List<Book> getAll() {
        String selectAll = "SELECT * FROM book;";
        try(Statement st = C3P0DataSource.getConnection().createStatement()) {
            ResultSet resultSet = st.executeQuery(selectAll);
            while (resultSet.next()){
                String title = resultSet.getString("title");
                int pageCount = resultSet.getInt("pageCount");
                System.out.println("title = "+ title);
                System.out.println("pageCount = "+ pageCount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public Book getByPK(Integer primaryKey) {
        return null;
    }

    @Override
    public boolean deleteByPK(Integer primaryKey) {
        return false;
    }

    @Override
    public Book update(Book entity) {
        return null;
    }

    @Override
    public Book add(Book entity) {
        return null;
    }
}
