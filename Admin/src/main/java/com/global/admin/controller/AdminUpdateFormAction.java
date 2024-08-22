package com.global.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.global.action.Action;
import com.global.action.View;
import com.global.admin.model.AdminDAO;
import com.global.admin.model.AdminDTO;
import com.global.admin.model.AdminRoleDTO;

public class AdminUpdateFormAction implements Action {

	@Override
	public View execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		String status = request.getParameter("status") == null ? "" : request.getParameter("status");
    	int currentPage = request.getParameter("currentPage") == null ? 0 : Integer.parseInt(request.getParameter("currentPage"));
    	
    	AdminDAO dao = AdminDAO.getInstance();
    	
    	AdminDTO ad = dao.getAdminInfo(no);
    	List<AdminRoleDTO> roll = dao.getAdminRoleList();
    	
    	request.setAttribute("status", status);
    	request.setAttribute("currentPage", currentPage);
    	
    	request.setAttribute("list", roll);
    	request.setAttribute("info", ad);
    	
		return new View("main.go").setUrl("/views/admin/adminUpdateForm.jsp");
	}

}
