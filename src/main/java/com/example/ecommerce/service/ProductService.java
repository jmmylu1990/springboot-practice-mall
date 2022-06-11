package com.example.ecommerce.service;

import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.model.Product;

public interface ProductService {

    Product getProductById(Integer productId);
    Integer createProduct(ProductDto productDto);

}
