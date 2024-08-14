package com.global.board.dto;

import java.sql.Date;

public class BoardDTO {
    private int boardId;
    private int userNo;
    private int categoryId;
    private String title;
    private String content;
    private Date createdAt;
    private Date updatedAt;
    private char isDeleted;

    public BoardDTO() {}

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        return "BoardDTO{" +
                "boardId=" + boardId +
                ", userNo=" + userNo +
                ", categoryId=" + categoryId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", isDeleted=" + isDeleted +
                '}';
    }
}