package com.global.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.utils.ScriptUtil;
import com.global.action.Action;
import com.global.action.View;
import com.global.admin.model.AdminDAO;
import com.global.admin.model.AdminDTO;

public class AdminInsertOkAction implements Action {

	@Override
	public View execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("adminId").trim();
		String pwd = request.getParameter("adminPwd").trim();
		String name = request.getParameter("adminName").trim();
		System.out.println("name " + name);
		String email = request.getParameter("emailId").trim() + "@" + request.getParameter("emailDomain").trim();
		String role = request.getParameter("role").trim();

		AdminDTO admin = new AdminDTO();
		admin.setUserId(id);
		admin.setPassword(pwd);
		admin.setName(name);
		admin.setEmail(email);
		admin.setRoleCode(role);

		int check = AdminDAO.getInstance().insertAdmin(admin);

		if (check > 0) {
			ScriptUtil.sendScript(response, "관리자 역활 등록 성공!!!", "main.go");
		} else {
			ScriptUtil.sendScript(response, "관리자 역활 등록 실패!!!!", null);
		}

		return null;
	}

}
