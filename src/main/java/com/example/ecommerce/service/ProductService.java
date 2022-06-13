package com.example.ecommerce.service;

import com.example.ecommerce.constant.ProductCategory;
import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.dto.ProductQueryParams;
import com.example.ecommerce.model.Product;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface ProductService {

    Product getProductById(Integer productId);
    Integer createProduct(ProductDto productDto);
    void updateProduct(Integer productId, ProductDto productDto);
    void deleteProductById(Integer productId);
//    List<Product> getProducts(ProductCategory category,String search);
List<Product> getProducts(ProductQueryParams productQueryParams);

}
