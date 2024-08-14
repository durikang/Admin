package com.global.customer.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.global.action.Action;
import com.global.customer.model.CustomerDAO;
import com.global.customer.model.CustomerDTO;

public class UpdateCustomerAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
        String status = request.getParameter("status"); // 체크박스에서 선택한 상태
        String sort = request.getParameter("sort"); // 정렬 옵션
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        
		CustomerDAO dao = CustomerDAO.getInstance();
		
		CustomerDTO member = dao.selectMember(no);
		
		request.setAttribute("member", member);
		
		/*
		 * request.getRequestDispatcher("views/member/memberUpdate.jsp").forward(
		 * request, response);
		 */
		request.setAttribute("status", status);
		request.setAttribute("sort", sort);
		request.setAttribute("currentPage", currentPage);
		
		request.setAttribute("url", "/views/member/customerUpdate.jsp");
		return "main.go";
	}

}
