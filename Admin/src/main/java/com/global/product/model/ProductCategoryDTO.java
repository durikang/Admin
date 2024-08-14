package com.global.product.model;

public class ProductCategoryDTO {
    private int categoryId;
    private String name;
    private String description;

    public ProductCategoryDTO() {}

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
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

    @Override
    public String toString() {
        return "ProductCategoryDTO{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}