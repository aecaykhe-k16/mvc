package com.example.demo.repository;

import java.util.List;

public interface GenericRepo<T, ID> {
    T create(T t);

    T getOne(ID id);

    T update(T t);

    boolean delete(ID id);

    List<T> getAll();


}
