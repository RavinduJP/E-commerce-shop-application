package com.ecommerce.EcommerceApp.controllers;

import com.ecommerce.EcommerceApp.entities.Category;
import com.ecommerce.EcommerceApp.services.CategoryService;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/update/{categoryId}")
    public String updateCategory(@PathVariable("categoryId") int categoryId,
                                                      @RequestBody Category category) {
        System.out.println("category id" + categoryId);
//        if (!categoryService.findById(categoryId)) {
//            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category does not exists"), HttpStatus.NOT_FOUND);
//        }
        String updated = categoryService.editCategory(category);
        return updated;
//        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "category has been updated"), HttpStatus.OK);
    }
}
