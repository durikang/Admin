package com.global.admin.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.global.action.Action;
import com.global.action.View;
import com.global.admin.model.AdminDAO;
import com.global.admin.model.AdminDTO;

public class AdminDetailFormAction implements Action {

	@Override
	public View execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		String status = request.getParameter("status") == null ? "" : request.getParameter("status");
    	int currentPage = request.getParameter("currentPage") == null ? 0 : Integer.parseInt(request.getParameter("currentPage"));
    	
    	AdminDTO ad = AdminDAO.getInstance().getAdminInfo(no);
    	
    	request.setAttribute("status", status);
    	request.setAttribute("currentPage", currentPage);
    	
    	request.setAttribute("info", ad);
    	
		return new View("main.go").setUrl("/views/admin/adminDetail.jsp");
	}

}
