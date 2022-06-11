package com.example.ecommerce.service;

import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.model.Product;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface ProductService {

    Product getProductById(Integer productId);
    Integer createProduct(ProductDto productDto);
    void updateProduct(Integer productId, ProductDto productDto);

}
