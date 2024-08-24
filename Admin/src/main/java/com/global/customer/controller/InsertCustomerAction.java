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
		
		if (check > 0) {
			ScriptUtil.sendScript(response, "고객 정보 입력 성공!!", "customerList.li");
		} else {
			ScriptUtil.sendScript(response, "고객 정보 입력 실패!!!", null);
		}
		
        return null;
	}

}
