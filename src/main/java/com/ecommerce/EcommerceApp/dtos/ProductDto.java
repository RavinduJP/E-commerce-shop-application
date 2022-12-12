package com.ecommerce.EcommerceApp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    //this id is optional
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private String imageURL;

    @NotNull
    private double price;

    @NotNull
    private String description;

    @NotNull
    private Integer categoryId;
}
