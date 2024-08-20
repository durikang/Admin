package com.global.customer.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.global.action.Action;
import com.global.action.View;
import com.global.customer.model.CustomerDAO;
import com.global.customer.model.CustomerDTO;

public class DetailCustomerAction implements Action {

	@Override
	public View execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		CustomerDAO dao = CustomerDAO.getInstance();
		int num = Integer.parseInt(request.getParameter("no"));
    	String status = request.getParameter("status") == null ? "" : request.getParameter("status");
    	int currentPage = request.getParameter("currentPage") == null ? 0 : Integer.parseInt(request.getParameter("currentPage"));
    	
    	System.out.println(num);
    	System.out.println(status);
    	System.out.println(currentPage);
    	
    	CustomerDTO mem = dao.selectMember(num);
    	
    	
    	request.setAttribute("status", status);
    	request.setAttribute("currentPage", currentPage);
    	
    	request.setAttribute("mem", mem);
    	request.setAttribute("url", "/views/member/customerDetail.jsp");
    	
		return new View("main.go");
	}

}
