package com.global.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.utils.ScriptUtil;
import com.global.action.Action;
import com.global.action.View;
import com.global.admin.model.AdminDAO;

public class AdminDeleteOkAction implements Action {

	@Override
	public View execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		int check = AdminDAO.getInstance().deleteAdmin(no);
		
		if (check > 0) {
			ScriptUtil.sendScript(response, "관리자 삭제 성공!!!", "adminList.li?currentPage=" + currentPage);
		} else {
			ScriptUtil.sendScript(response, "관리자 삭제 실패!!!!", null);
		}

		
		return null;
	}

}
