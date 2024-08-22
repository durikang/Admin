package com.global.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.global.customer.model.CustomerDTO;

public class RegisterOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		CustomerDTO dto = new CustomerDTO();
		//전달 값 뽑아서 저장하기
		String userId = request.getParameter("userID");
		String pwd = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String age = request.getParameter("age");
		String job = request.getParameter("job");
		String location = request.getParameter("location");
		
		return null;
	}
	

}
