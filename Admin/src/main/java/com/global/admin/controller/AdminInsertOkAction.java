package com.global.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.global.action.Action;
import com.global.action.View;
import com.global.admin.model.AdminDAO;
import com.global.admin.model.AdminDTO;

public class AdminInsertOkAction implements Action {

	@Override
	public View execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("adminId");
		String pwd = request.getParameter("adminPwd");
		String name = request.getParameter("adminName");
		String email = request.getParameter("emailId") + "@" + request.getParameter("emailDomain");
		String role = request.getParameter("adminRole");
		
		AdminDTO admin = new AdminDTO();
		admin.setUserId(id);
		admin.setPassword(pwd);
		admin.setName(name);
		admin.setEmail(email);
		admin.setRoleCode(role);
		
		int check = AdminDAO.getInstance().insertAdmin(admin);
		PrintWriter out = response.getWriter();
		
		if(check>0) {
			out.println("<script>");
			out.println("alert('관리자 역활 등록 성공!!!')");
			out.println("location.href='main.go';");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('관리자 역활 등록 실패!!!!')");
			out.println("history.go(-1)");
			out.println("</script>");
		}
		
		return null;
	}

}
