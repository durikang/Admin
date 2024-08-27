package com.global.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.utils.PageUtils;
import com.global.action.Action;
import com.global.action.View;
import com.global.admin.model.AdminDAO;
import com.global.admin.model.AdminRoleDTO;
import com.global.customer.model.PageInfo;

public class AdminRoleListAction implements Action {

	@Override
	public View execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		AdminDAO dao = AdminDAO.getInstance();
		
		int listCount = dao.getAdminRoleListCount();
        int currentPage = 1; // 기본적으로 페이지는 1로 설정
        int boardLimit = 10; // 한 페이지에 보여질 게시글 최대 수
        int pageLimit = 10; // 한 페이지 하단에 보여질 페이지 수
        
        // 현재 페이지
        if (request.getParameter("currentPage") != null) {
            currentPage = Integer.parseInt(request.getParameter("currentPage"));
        }

        PageInfo pi = PageUtils.getPageInfo(currentPage, listCount, boardLimit, pageLimit);
		
        List<AdminRoleDTO> list = dao.getAdminRoleList(currentPage,boardLimit);
        
        int count = dao.getAdminRoleListCount();
        
        request.setAttribute("count", count);
        request.setAttribute("list", list);
        request.setAttribute("pi", pi);
        request.setAttribute("address", "adminRoleList.li");
        
		return new View("main.go").setUrl("/views/admin/adminRoleList.jsp");
	}

}
