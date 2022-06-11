package com.example.ecommerce.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

public @Data class Product implements Serializable {

    private Integer productId;
    private String productName;
    private String category;
    private String imageUrl;
    private Integer price;
    private Integer stock;
    private String description;
    private Date createdDate;
    private Date lastModifiedDate;

}
