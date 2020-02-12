package dao;

import java.util.List;

public interface Dao <T, PK> {
    // T тип данных
    // PK тип данных первичного ключа

    List<T> getAll();// получение всех записей из БД
    T getByPK(PK primaryKey);// получение записей из БД по первичному ключу
    boolean deleteByPK(PK primaryKey);// удаление по первичному ключу
    T update(T entity);//обновление данных в базе
    T add(T entity);// добавление данных в базу

}
