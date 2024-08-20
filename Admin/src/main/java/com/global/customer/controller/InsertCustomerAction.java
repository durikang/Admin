package com.global.customer.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.global.action.Action;
import com.global.action.View;
import com.global.customer.model.CustomerDAO;
import com.global.customer.model.CustomerDTO;

public class InsertCustomerAction implements Action {

	@Override
	public View execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String id = request.getParameter("memId").trim();
		String name = request.getParameter("memName").trim();
		String pwd = request.getParameter("pwd").trim();
		int age = Integer.parseInt(request.getParameter("age").trim());
		String job = request.getParameter("job").trim();
		String addr = request.getParameter("addr").trim();
		
		CustomerDTO insertMember = new CustomerDTO();
		insertMember.setUserId(id);
		insertMember.setName(name);
		insertMember.setPassword(pwd);
		insertMember.setAge(age);
		insertMember.setJob(job);
		insertMember.setLocation(addr);
		
		int check = CustomerDAO.getInstance().insertMember(insertMember);
		
		PrintWriter out = response.getWriter();
		
		if(check>0) {
			out.println("<script>");
			out.println("alert('고객 정보 변경 성공!!!')");
			out.println("location.href='mlist.go'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('고객 정보 변경 실패!!!')");
			out.println("history.go(-1)");
			out.println("</script>");
		}
		
		
        return null;
	}

}
