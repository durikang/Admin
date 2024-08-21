package com.global.customer.model;

import java.io.Serializable;
import java.util.Date;

public class CustomerDTO implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -6167361693119646260L;
	private int no;
	private int userNo;
	private String userId;
    private String password;
    private String name;
    private String email;
    private int age;
    private String job;
    private String location;
    private char isDeleted;
    private Date createdAt;     // 회원 등록일
    private Date updatedAt;     // 회원 정보 수정일
    private int mileage;       // 회원 마일리지

    // 기본 생성자
    public CustomerDTO() {
    }

    // 모든 필드를 포함한 생성자
    public CustomerDTO(int userNo, String userId, String password, String name, String email, 
                       int age, String job, String location, char isDeleted, 
                       Date createdAt, Date updatedAt, int mileage) {
        this.userNo = userNo;
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.email = email;
        this.age = age;
        this.job = job;
        this.location = location;
        this.isDeleted = isDeleted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.mileage = mileage;
    }

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}
	
	/* 비밀번호 암호화 */
	public String getMaskedPwd() {
		if(this.password != null && !password.isEmpty()) {
			return "*".repeat(this.password.length());
		}
		return "";
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public char getIsDeleted() {
		return isDeleted;
	}
	
	public String getStatus() {
		return String.valueOf(this.isDeleted);
	}

	public void setIsDeleted(char isDeleted) {
		this.isDeleted = isDeleted;
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

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CustomerDTO [userNo=" + userNo + ", userId=" + userId + ", password=" + password + ", name=" + name
				+ ", email=" + email + ", age=" + age + ", job=" + job + ", location=" + location + ", isDeleted="
				+ isDeleted + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", mileage=" + mileage + "]";
	}
    
    
    
}