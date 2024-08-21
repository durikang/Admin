package com.global.admin.model;

public class AdminRollDTO {
    private String rollCode;     // 역할 코드
    private String rollName;     // 역할 이름
    private Long adminId;        // 관리자의 ID

    // 기본 생성자
    public AdminRollDTO() {
    }

    // 모든 필드를 포함하는 생성자
    public AdminRollDTO(String rollCode, String rollName, Long adminId) {
        this.rollCode = rollCode;
        this.rollName = rollName;
        this.adminId = adminId;
    }

    // getter 및 setter 메서드
    public String getRollCode() {
        return rollCode;
    }

    public void setRollCode(String rollCode) {
        this.rollCode = rollCode;
    }

    public String getRollName() {
        return rollName;
    }

    public void setRollName(String rollName) {
        this.rollName = rollName;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

}
