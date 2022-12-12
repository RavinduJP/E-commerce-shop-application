package com.ecommerce.EcommerceApp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private String imageURL;

    @NotNull
    private double price;

    @NotNull
    private String description;

    //Many to one relationship
    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;
}
