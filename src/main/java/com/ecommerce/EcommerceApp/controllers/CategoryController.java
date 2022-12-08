package com.ecommerce.EcommerceApp.controllers;

import com.ecommerce.EcommerceApp.entities.Category;
import com.ecommerce.EcommerceApp.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public String createCategory(@RequestBody Category category) {
        categoryService.saveCategory(category);
        return "success";
    }

    @GetMapping("/view")
    public List<Category> categoryList() {
        return categoryService.findAllCategories();
    }
}
