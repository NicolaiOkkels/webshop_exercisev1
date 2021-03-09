package com.example.demo.Repository;

import com.example.demo.Model.Product;

import java.util.List;

public interface ICrudRepository<T> {
    void create(T t);
    List<T> readAll();
    T getProduct(long id);
    void update(T t);
    void delete(long id);
}
