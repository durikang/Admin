package com.global.customer.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.utils.ScriptUtil;
import com.global.action.Action;
import com.global.action.View;
import com.global.customer.model.CustomerDAO;
import com.global.customer.model.CustomerDTO;

public class UpdateOkCustomerAction implements Action {

	@Override
	public View execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		CustomerDAO dao = CustomerDAO.getInstance();
    	int num = Integer.parseInt(request.getParameter("num"));

		
    	String name = request.getParameter("name");
    	String pwd = request.getParameter("pwd");
    	String job = request.getParameter("job");
    	String addr = request.getParameter("addr");
    	
    	CustomerDTO member = new CustomerDTO();
    	
    	member.setUserNo(num);
    	member.setName(name);
    	member.setPassword(pwd);
    	member.setJob(job);
    	member.setLocation(addr);
    	
    	int check = dao.updateStudent(member,num);
    	
		if (check > 0) {
			ScriptUtil.sendScript(response, "고객 정보 변경 성공!!", "detail.do?no="+ num + "';");
		} else {
			ScriptUtil.sendScript(response, "고객 정보 변경 실패!!!", null);
		}
		
		return null;
	}

}
