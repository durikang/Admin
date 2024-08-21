package com.global.admin.model;


public class AdminDTO {
    private int adminId;    // 관리자 번호
    private String userId;     // 관리자 아이디
    private String password;   // 관리자 비밀번호
    private String name;       // 관리자 이름
    private String email;      // 관리자 이메일 주소
    private String roleCode;   // 역할 코드
    private char isDeleted;    // 관리자 계정 삭제 여부 ('Y', 'N')

    public AdminDTO() {
	}
    
    // Constructor
    public AdminDTO(int adminId, String userId, String password, String name, String email, String roleCode, char isDeleted) {
        this.adminId = adminId;
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.email = email;
        this.roleCode = roleCode;
        this.isDeleted = isDeleted;
    }

    // Getters and Setters
    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

	/* 비밀번호 암호화 */
	public String getMaskedPwd() {
		if(this.password != null && !password.isEmpty()) {
			return "*".repeat(this.password.length());
		}
		return "";
	}
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public char getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(char isDeleted) {
        this.isDeleted = isDeleted;
    }
}
