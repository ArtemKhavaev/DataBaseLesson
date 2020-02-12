package jpa.repository;

import jpa.specification.Specification;

import java.util.List;

public interface Repository<T, PK> {
    void add(T t); // добавление
    void update(T t); // обновление
    void delete(PK pk); // удаление по первичному ключу
    T getByPk(PK pk); // получение по первичному ключу
    List<T> getAll(); // получение всех записей

    List<T> getBySpecification(Specification specification);


}