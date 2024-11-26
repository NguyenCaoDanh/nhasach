package com.ncd.storeapplication.repository;

import com.ncd.storeapplication.entity.Categories;
import com.ncd.storeapplication.generic.IRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends IRepository<Categories,Integer> {
    Page<Categories> findAll(Pageable pageable);
}
