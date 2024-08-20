package com.global.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class View {
	private boolean isRedirect; // true

	private String viewPath;

	public View() {
		
	}
	
	
	
	public String getViewPath() {
		return viewPath;
	}



	public void setViewPath(String viewPath) {
		this.viewPath = viewPath;
	}



	public View(String viewPath) {

		if(viewPath.endsWith(".jsp")) {
			this.viewPath = viewPath;
		}else {
			this.viewPath = viewPath;
		}
		this.isRedirect = false; // 기본값 설정 (필요에 따라 조정)
	}
	
	public boolean isRedirect() {
		return isRedirect;
	}

	// 체이닝을 위해 View 객체를 반환
	public View setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
		return this;
	}

	public View render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (this.isRedirect) { // true일 경우 redirect
			response.sendRedirect(this.viewPath);
		} else { // false일 경우 forwarding
			request.getRequestDispatcher(viewPath).forward(request, response);
		}
		return this;
	}
}
