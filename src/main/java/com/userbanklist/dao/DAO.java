package com.userbanklist.dao;

import com.userbanklist.User;

import java.util.List;

public interface DAO<T> {

    void add(T t);

    List<T> getAll();

    T getById(int id);

    void update(T t);

    void delete(T t);
}
