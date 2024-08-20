package com.global.customer.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.global.action.Action;
import com.global.action.View;
import com.global.customer.model.CustomerDAO;

public class DeleteCustomerAction implements Action {

	@Override
	public View execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int num = Integer.parseInt(request.getParameter("no"));
    	int check = CustomerDAO.getInstance().deleteStudent(num);
    	String status = request.getParameter("status"); // 체크박스에서 선택한 상태
        String sort = request.getParameter("sort"); // 정렬 옵션
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
    	
    	PrintWriter out = response.getWriter();
    	
		if(check>0) {
			out.println("<script>");
			out.println("alert('고객 삭제 성공!!!')");
			out.println("location.href='mlist.go?currentPage="+currentPage+"&sort="+sort+"&status="+status+"'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('고객 삭제 실패!!!')");
			out.println("history.go(-1)");
			out.println("</script>");
		}
		return null;
	}

}
