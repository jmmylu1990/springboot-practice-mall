package com.example.ecommerce.dao;

import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.model.Product;

public interface ProductDao {
    Product getProductById(Integer productId);
    Integer createProduct(ProductDto productDto);
}
