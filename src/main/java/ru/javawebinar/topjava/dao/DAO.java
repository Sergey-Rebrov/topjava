package ru.javawebinar.topjava.dao;


import java.util.List;

/**
 * Created by Sergey on 10.12.2016.
 */
public interface DAO<T> {
    public void add(T t);

    public void update(T t);

    public void remove(int id);

    public T getByID(int  id);

    public List<T> list();
}
