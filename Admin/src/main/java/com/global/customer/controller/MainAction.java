package com.global.customer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.global.action.Action;
import com.global.action.View;

public class MainAction implements Action {

	@Override
	public View execute(HttpServletRequest request, HttpServletResponse response) {
		
		return new View("views/main.jsp");
	}

}
