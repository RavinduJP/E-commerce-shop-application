package com.ecommerce.EcommerceApp.services;

import com.ecommerce.EcommerceApp.entities.Category;

import java.util.List;

public interface CategoryService {

    Category saveCategory(Category category);

    List<Category> findAllCategories();
}
