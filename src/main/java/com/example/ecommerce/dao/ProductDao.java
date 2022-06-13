package com.example.ecommerce.dao;

import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.model.Product;

import java.util.List;

public interface ProductDao {
    Product getProductById(Integer productId);
    Integer createProduct(ProductDto productDto);
    void updateProduct(Integer productId, ProductDto productDto);
    void deleteProductById(Integer productId);
    List<Product> getProducts();
}
