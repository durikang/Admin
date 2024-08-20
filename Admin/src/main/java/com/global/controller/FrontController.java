package com.global.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.global.action.Action;
import com.global.customer.controller.CheckIdDuplicateAction;
import com.global.customer.controller.DeleteCustomerAction;
import com.global.customer.controller.DetailCustomerAction;
import com.global.customer.controller.InsertCustomerAction;
import com.global.customer.controller.ListCustomerAction;
import com.global.customer.controller.MainAction;
import com.global.customer.controller.UpdateCustomerAction;
import com.global.customer.controller.UpdateOkCustomerAction;

public class FrontController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1934459167346141964L;

	private Map<String,Action> controllerMap  = new HashMap<>();
	
	public FrontController() {
		/*
		   main
		*/		
		controllerMap.put("main.go", new MainAction());
		/*
		 * customer
		*/
		controllerMap.put("mlist.go", new ListCustomerAction());
		controllerMap.put("checkIdDuplicate.go", new CheckIdDuplicateAction());
		controllerMap.put("insertCustomer.do", new InsertCustomerAction());
		controllerMap.put("detail.do", new DetailCustomerAction());
		controllerMap.put("update.do", new UpdateCustomerAction());
		controllerMap.put("updateOk.do", new UpdateOkCustomerAction());
		controllerMap.put("delete.do", new DeleteCustomerAction());
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 처리 작업 진행
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		

		//  getRequestURI() : "/프로젝트명/파일명(*.do)" 라는 문자열을 반환해 주는 메서드.
		String uri = request.getRequestURI();
		/* System.out.println("uri >>>>>" + uri); */
		System.out.println("uri >>>>>" + uri);
		// getContextPath() : 현재 프로젝트명을 문자열로 반환해주는 메소드
		String path = request.getContextPath();
		/* System.out.println("Path >>>>" + path); */
		
		String command = uri.substring(path.length()+1);
		/* System.out.println("command >>>" + command); */
		
		Action action = controllerMap.get(command);
		
		if(action == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		String view = action.execute(request, response);
		if(view != null) {
			request.getRequestDispatcher(view).forward(request, response);
		}
	}
	
	
}
