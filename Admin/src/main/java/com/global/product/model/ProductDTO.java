package com.global.product.model;

import java.sql.Date;

//ProductDTO.java
public class ProductDTO {
 private int productId;
 private String categoryId;
 private String name;
 private String description;
 private int price;
 private int stockQuantity;
 private Date createdAt;
 private Date updatedAt;
 private char isDeleted;

 public ProductDTO() {}

 public int getProductId() {
     return productId;
 }

 public void setProductId(int productId) {
     this.productId = productId;
 }

 public String getCategoryId() {
     return categoryId;
 }

 public void setCategoryId(String categoryId) {
     this.categoryId = categoryId;
 }

 public String getName() {
     return name;
 }

 public void setName(String name) {
     this.name = name;
 }

 public String getDescription() {
     return description;
 }

 public void setDescription(String description) {
     this.description = description;
 }

 public int getPrice() {
     return price;
 }

 public void setPrice(int price) {
     this.price = price;
 }

 public int getStockQuantity() {
     return stockQuantity;
 }

 public void setStockQuantity(int stockQuantity) {
     this.stockQuantity = stockQuantity;
 }

 public Date getCreatedAt() {
     return createdAt;
 }

 public void setCreatedAt(Date createdAt) {
     this.createdAt = createdAt;
 }

 public Date getUpdatedAt() {
     return updatedAt;
 }

 public void setUpdatedAt(Date updatedAt) {
     this.updatedAt = updatedAt;
 }

 public char getIsDeleted() {
     return isDeleted;
 }

 public void setIsDeleted(char isDeleted) {
     this.isDeleted = isDeleted;
 }

 @Override
 public String toString() {
     return "ProductDTO{" +
             "productId=" + productId +
             ", categoryId=" + categoryId +
             ", name='" + name + '\'' +
             ", description='" + description + '\'' +
             ", price=" + price +
             ", stockQuantity=" + stockQuantity +
             ", createdAt=" + createdAt +
             ", updatedAt=" + updatedAt +
             ", isDeleted=" + isDeleted +
             '}';
 }
}