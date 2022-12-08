package com.ecommerce.EcommerceApp.services.impl;

import com.ecommerce.EcommerceApp.entities.Category;
import com.ecommerce.EcommerceApp.repositories.CategoryRepository;
import com.ecommerce.EcommerceApp.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public String editCategory(Category updateCategory) {
        if (categoryRepository.existsById(updateCategory.getId())) {
            Category category = categoryRepository.getById(updateCategory.getId());
            category.setCategoryName(updateCategory.getCategoryName());
            category.setDescription(updateCategory.getDescription());
            category.setImageUrl(updateCategory.getImageUrl());
            categoryRepository.save(category);

            return String.valueOf(HttpStatus.OK);
        } else
            return String.valueOf(HttpStatus.NOT_FOUND);
    }


}
