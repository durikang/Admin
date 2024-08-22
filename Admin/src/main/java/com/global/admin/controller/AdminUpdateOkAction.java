package com.global.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.global.action.Action;
import com.global.action.View;
import com.global.admin.model.AdminDAO;
import com.global.admin.model.AdminDTO;

public class AdminUpdateOkAction implements Action {

	@Override
	public View execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int no = Integer.parseInt(request.getParameter("num"));
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String role = request.getParameter("role");
		String memberStatus = request.getParameter("memberStatus");
		
		AdminDTO admin = new AdminDTO();
		admin.setAdminId(no);
		admin.setPassword(pwd);
		admin.setEmail(email);
		admin.setRoleCode(role);
		admin.setIsDeleted(memberStatus.charAt(0));
		
		int check = AdminDAO.getInstance().updateAdmin(admin);
		
		
		PrintWriter out = response.getWriter();
		
		if(check>0) {
			out.println("<script>");
			out.println("alert('관리자 변경 성공!!!')");
			out.println("location.href='adminList.li';");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('관리자 변경 실패!!!!')");
			out.println("history.go(-1)");
			out.println("</script>");
		}
		
		
		return null;
	}

}
