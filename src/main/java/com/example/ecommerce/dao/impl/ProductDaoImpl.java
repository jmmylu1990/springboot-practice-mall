package com.example.ecommerce.dao.impl;

import com.example.ecommerce.dao.ProductDao;
import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.rowmapper.ProductRowMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Product getProductById(Integer productId) {
        String sql = "SELECT * FROM product WHERE product_id = :productId";
        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());
        if (productList.size() > 0) {
            return productList.get(0);
        } else {
            return null;
        }

    }

    @Override
    public Integer createProduct(ProductDto productDto) {

        String sql = "INSERT INTO product(product_name,category,image_url,price,stock, " +
                "description, created_date, last_modified_date) " +
                "VALUES (:productName, :category, :imageUrl, :price, :stock, :description, " +
                ":createdDate, :lastModifiedDate) ";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("productName", productDto.getProductName());
        map.put("category", productDto.getCategory().toString());
        map.put("imageUrl", productDto.getImageUrl());
        map.put("price", productDto.getPrice());
        map.put("stock", productDto.getStock());
        map.put("description", productDto.getDescription());
        Date now = new Date();
        map.put("createdDate", now);
        map.put("lastModifiedDate", now);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);
        int productId = keyHolder.getKey().intValue();
        return productId;
    }

    @Override
    public void updateProduct(Integer productId, ProductDto productDto) {

        String sql = "UPDATE product SET product_name =:productName, category=:category, " +
                "image_url = :imageUrl, price=:price, stock=:stock, d" +
                "escription=:description, last_modified_date=:lastModifiedDate " +
                "WHERE product_id=:productId";
        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);
        map.put("productName", productDto.getProductName());
        map.put("category", productDto.getCategory().toString());
        map.put("imageUrl", productDto.getImageUrl());
        map.put("price", productDto.getPrice());
        map.put("stock", productDto.getStock());
        map.put("description", productDto.getDescription());
        map.put("lastModifiedDate", new Date());
        namedParameterJdbcTemplate.update(sql, map);
    }
}
