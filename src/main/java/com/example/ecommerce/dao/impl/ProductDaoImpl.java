package com.example.ecommerce.dao.impl;

import com.example.ecommerce.dao.ProductDao;
import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.dto.ProductQueryParams;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

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

    @Override
    public void deleteProductById(Integer productId) {
        String sql = "DELETE FROM product WHERE product_id =:productId";
        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);
        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public List<Product> getProducts(ProductQueryParams productQueryParams) {

        String sql = "SELECT product_id,product_name,category,image_url,price,stock," +
                "description, created_date, last_modified_date FROM product WHERE 1=1";
        Map<String, Object> map = new HashMap<>();

        //查詢條件
         sql = addFilteringSql(sql,map,productQueryParams);
        //排序
        sql = sql + " ORDER BY " + productQueryParams.getOrderBy() + " " + productQueryParams.getSort();
        //分頁
        sql = sql + " LIMIT :limit OFFSET :offset";
        map.put("limit",productQueryParams.getLimit());
        map.put("offset",productQueryParams.getOffset());

        return namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());
    }

    @Override
    public Integer countProduct(ProductQueryParams productQueryParams) {
        String sql = "SELECT count(*) FROM product WHERE 1=1";
        Map<String,Object> map = new HashMap<String,Object>();
         sql = addFilteringSql(sql,map,productQueryParams);
        return namedParameterJdbcTemplate.queryForObject(sql, map, Integer.class);
    }

    private String addFilteringSql(String sql,Map<String,Object> map, ProductQueryParams productQueryParams){
        //查詢條件
        if (productQueryParams.getCategory() != null) {
            sql = sql + " AND category = :category";
            map.put("category", productQueryParams.getCategory().name());
        }
        if (productQueryParams.getSearch() != null) {
            sql = sql + " AND product_name LIKE :search";
            map.put("search", "%" + productQueryParams.getSearch() + "%");
        }

        return sql;
    }
}
