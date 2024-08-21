package com.global.admin.model;

public class AdminRoleDTO {
	private int rnum;
    private String roleCode;   // 역할 코드
    private String roleName;   // 역할 이름

    public AdminRoleDTO() {
	}
    // Constructor
    public AdminRoleDTO(String roleCode, String roleName) {
        this.roleCode = roleCode;
        this.roleName = roleName;
    }
    

	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	// Getters and Setters
    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}

