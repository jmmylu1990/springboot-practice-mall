package com.example.ecommerce.service.impl;

import com.example.ecommerce.constant.ProductCategory;
import com.example.ecommerce.dao.ProductDao;
import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductDto productDto) {

        return productDao.createProduct(productDto);
    }

    @Override
    public void updateProduct(Integer productId, ProductDto productDto) {
        productDao.updateProduct(productId, productDto);
    }

    @Override
    public void deleteProductById(Integer productId) {
        productDao.deleteProductById(productId);
    }


    @Override
    public List<Product> getProducts(ProductCategory category,String search) {
        return  productDao.getProducts(category,search);
    }
}
