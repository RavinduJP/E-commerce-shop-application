package com.ecommerce.EcommerceApp.controllers;

import com.ecommerce.EcommerceApp.common.ApiResponse;
import com.ecommerce.EcommerceApp.dtos.ProductDto;
import com.ecommerce.EcommerceApp.entities.Category;
import com.ecommerce.EcommerceApp.repositories.CategoryRepository;
import com.ecommerce.EcommerceApp.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryRepository categoryRepository;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> createProduct(@RequestBody ProductDto productDto) {
        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
        if (!optionalCategory.isPresent()) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false,"category does not exists"),
                    HttpStatus.BAD_REQUEST);
        } else {
            productService.createProduct(productDto, optionalCategory.get());
            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "product has been added"),
                    HttpStatus.CREATED);
        }
    }

    //api for get all products
    @GetMapping("/AllProducts")
    public  ResponseEntity<List<ProductDto>> getProduct() {
       List<ProductDto> products = productService.getAllProducts();
       return new ResponseEntity<>(products, HttpStatus.OK);
    }

    //api for edit product
    @PostMapping("/update/{productId}")
    public ResponseEntity<ApiResponse> createProduct(@PathVariable("productId") Integer productId,
                                                     @RequestBody ProductDto productDto) throws Exception {
        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
        if (!optionalCategory.isPresent()) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false,"category does not exists"),
                    HttpStatus.BAD_REQUEST);
        } else {
            productService.updateProduct(productDto, productId);
            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "product has been updated"),
                    HttpStatus.OK);
        }
    }
}
