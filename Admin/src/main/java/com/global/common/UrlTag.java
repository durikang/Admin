package com.global.common;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class UrlTag extends SimpleTagSupport {
	private String path;
	
	public void setPath(String path) {
		this.path = path;
	}
	
	@Override
	public void doTag() throws JspException, IOException{
		JspWriter out = getJspContext().getOut();
		String contextPath = ((javax.servlet.http.HttpServletRequest) getJspContext().getAttribute("request")).getContextPath();
		String url = contextPath + "/views/main.jsp?url=" + path;
		out.print(url);
	}
}
