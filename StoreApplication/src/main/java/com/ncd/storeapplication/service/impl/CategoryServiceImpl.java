package com.ncd.storeapplication.service.impl;

import com.ncd.storeapplication.entity.Categories;
import com.ncd.storeapplication.repository.CategoriesRepository;
import com.ncd.storeapplication.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoriesRepository categoriesRepository;

    @Override
    public void save(Categories categories) {
        try {
            categoriesRepository.save(categories);
        } catch (Exception e) {
            throw new RuntimeException("Error while saving category: " + e.getMessage());
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            categoriesRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error while deleting category: " + e.getMessage());
        }
    }

    @Override
    public Iterator<Categories> findAll() {
        return null;
    }



    @Override
    public Categories findOne(Integer id) {
        return categoriesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
    }

    @Override
    public Page<Categories> findAllPage(Pageable pageable) { return categoriesRepository.findAll(pageable);
    }
}

