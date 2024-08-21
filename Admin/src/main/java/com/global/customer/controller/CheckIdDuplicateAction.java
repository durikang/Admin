package com.global.customer.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.global.action.Action;
import com.global.action.View;
import com.global.customer.model.CustomerDAO;

public class CheckIdDuplicateAction implements Action {

	  @Override
	    public View execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
	        
		  
		  String memId = request.getParameter("memId");
	        boolean isDuplicate = CustomerDAO.getInstance().checkDuplicateId(memId);
	        
	        // JSON 응답 설정
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        
	        // JSON 응답 생성
	        JSONObject jsonResponse = new JSONObject();
	        jsonResponse.put("isDuplicate", isDuplicate);
	        
	        // 클라이언트에 JSON 응답 전송
	        PrintWriter out = response.getWriter();
	        out.print(jsonResponse.toString());
	        out.flush();
	        
	        return null; // JSON 응답을 반환하지 않음
	    }

}
