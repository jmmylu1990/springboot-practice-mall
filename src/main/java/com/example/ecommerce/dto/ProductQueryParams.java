package com.example.ecommerce.dto;

import com.example.ecommerce.constant.ProductCategory;
import com.example.ecommerce.service.ProductService;

import java.io.Serializable;

public class ProductQueryParams implements Serializable {
    private ProductCategory category;
    private String search;

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
