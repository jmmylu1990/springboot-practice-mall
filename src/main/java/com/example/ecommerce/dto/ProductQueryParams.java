package com.example.ecommerce.dto;

import com.example.ecommerce.constant.ProductCategory;
import com.example.ecommerce.service.ProductService;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;

public class ProductQueryParams implements Serializable {
    private ProductCategory category;
    private String search;
    private String orderBy;
    private String sort;
    private Integer limit;
    private Integer offset;

    @Override
    public String toString() {
        return "ProductQueryParams{" +
                "category=" + category +
                ", search='" + search + '\'' +
                ", orderBy='" + orderBy + '\'' +
                ", sort='" + sort + '\'' +
                ", limit=" + limit +
                ", offset=" + offset +
                '}';
    }

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

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}
