package com.ncd.storeapplication.generic;

import com.ncd.storeapplication.entity.Categories;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public interface IService<T, ID> {
    void save(T t);

    void delete(ID id);

    Iterator<T> findAll();

    T findOne(ID id);

}
