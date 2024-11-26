package com.ncd.storeapplication.service;

import com.ncd.storeapplication.entity.Categories;
import com.ncd.storeapplication.generic.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService extends IService<Categories,Integer> {
    Page<Categories> findAllPage(Pageable pageable);

}
