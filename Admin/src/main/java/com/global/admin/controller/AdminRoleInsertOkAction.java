package com.global.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.utils.ScriptUtil;
import com.global.action.Action;
import com.global.action.View;
import com.global.admin.model.AdminDAO;
import com.global.admin.model.AdminRoleDTO;

public class AdminRoleInsertOkAction implements Action{

	@Override
	public View execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String code = request.getParameter("roleCode");
		String name = request.getParameter("adminName");
		
		AdminRoleDTO dto = new AdminRoleDTO();
		dto.setRoleCode(code);
		dto.setRoleName(name);
		
		int check = AdminDAO.getInstance().insertAdminRole(dto);
		
		if (check > 0) {
			ScriptUtil.sendScript(response, "관리자 역활 등록 성공!!!", "main.go");
		} else {
			ScriptUtil.sendScript(response, "관리자 역활 등록 실패!!!!", null);
		}
		
		
		return null;
	}

}
