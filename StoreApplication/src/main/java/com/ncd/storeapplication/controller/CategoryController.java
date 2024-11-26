package com.ncd.storeapplication.controller;

import com.ncd.storeapplication.DTO.RequestResponse;
import com.ncd.storeapplication.entity.Categories;
import com.ncd.storeapplication.exception.ErrorHandler;
import com.ncd.storeapplication.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Helper method to create a standardized response
    private RequestResponse createResponse(String message, Object data) {
        return new RequestResponse(LocalDateTime.now().toString(), message, data);
    }

    // Thêm Category
    @PostMapping("/add")
    public ResponseEntity<?> addCategory(@RequestBody Categories categories) {
        try {
            categoryService.save(categories);
            return ResponseEntity.ok(createResponse("Category added successfully!", categories));
        } catch (Exception e) {
            throw new ErrorHandler(HttpStatus.BAD_REQUEST, "Failed to add category: " + e.getMessage());
        }
    }

    // Xóa Category
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Integer id) {
        try {
            Categories category = categoryService.findOne(id);
            if (category == null) {
                throw new ErrorHandler(HttpStatus.NOT_FOUND, "Category not found with ID: " + id);
            }
            categoryService.delete(id);
            return ResponseEntity.ok(createResponse("Category deleted successfully!", category));
        } catch (Exception e) {
            throw new ErrorHandler(HttpStatus.NOT_FOUND, "Failed to delete category: " + e.getMessage());
        }
    }



    // Lấy Một Category theo ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Integer id) {
        try {
            Categories category = categoryService.findOne(id);
            if (category == null) {
                throw new ErrorHandler(HttpStatus.NOT_FOUND, "Category not found with ID: " + id);
            }
            return ResponseEntity.ok(createResponse("Category retrieved successfully!", category));
        } catch (Exception e) {
            throw new ErrorHandler(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected error: " + e.getMessage());
        }
    }

    // Cập Nhật Category
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Integer id, @RequestBody Categories updatedCategory) {
        try {
            // Tìm category theo ID
            Categories existingCategory = categoryService.findOne(id);
            if (existingCategory == null) {
                throw new ErrorHandler(HttpStatus.NOT_FOUND, "Category not found with ID: " + id);
            }

            // Cập nhật thông tin
            existingCategory.setCategoryName(updatedCategory.getCategoryName());
            categoryService.save(existingCategory);

            return ResponseEntity.ok(createResponse("Category updated successfully!", existingCategory));
        } catch (Exception e) {
            throw new ErrorHandler(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to update category: " + e.getMessage());
        }
    }
    @GetMapping("/all")
    public ResponseEntity<?> findAllCategories(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            Pageable pageable = PageRequest.of(page, size);
            Page<Categories> categoriesPage = categoryService.findAllPage(pageable);

            return ResponseEntity.ok(createResponse("Categories retrieved successfully!", categoriesPage));
        } catch (Exception e) {
            throw new ErrorHandler(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to retrieve categories: " + e.getMessage());
        }
    }
}
