package com.global.cart.dto;

import java.sql.Date;

public class CartDTO {
    private int cartId;
    private int userNo;
    private Date createdAt;

    public CartDTO() {}

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "CartDTO{" +
                "cartId=" + cartId +
                ", userNo=" + userNo +
                ", createdAt=" + createdAt +
                '}';
    }
}