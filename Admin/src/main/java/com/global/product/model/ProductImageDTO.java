package com.global.product.model;

//ProductImageDTO.java
public class ProductImageDTO {
 private String imageId;
 private int productId;
 private String imageUrl;
 private String description;

 public ProductImageDTO() {}

 public String getImageId() {
     return imageId;
 }

 public void setImageId(String imageId) {
     this.imageId = imageId;
 }

 public int getProductId() {
     return productId;
 }

 public void setProductId(int productId) {
     this.productId = productId;
 }

 public String getImageUrl() {
     return imageUrl;
 }

 public void setImageUrl(String imageUrl) {
     this.imageUrl = imageUrl;
 }

 public String getDescription() {
     return description;
 }

 public void setDescription(String description) {
     this.description = description;
 }

 @Override
 public String toString() {
     return "ProductImageDTO{" +
             "imageId=" + imageId +
             ", productId=" + productId +
             ", imageUrl='" + imageUrl + '\'' +
             ", description='" + description + '\'' +
             '}';
 }
}