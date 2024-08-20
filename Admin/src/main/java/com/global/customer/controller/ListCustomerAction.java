package com.global.customer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.global.action.Action;
import com.global.action.View;
import com.global.customer.model.CustomerDAO;
import com.global.customer.model.CustomerDTO;
import com.global.customer.model.PageInfo;

public class ListCustomerAction implements Action {

    @Override
    public View execute(HttpServletRequest request, HttpServletResponse response) {
        CustomerDAO dao = CustomerDAO.getInstance();
        
        String status = request.getParameter("status"); // 체크박스에서 선택한 상태
        String sort = request.getParameter("sort"); // 정렬 옵션
        int listCount; // 조건에 따른 회원 수

        // 현재 페이지
        int currentPage = 1;
        if (request.getParameter("currentPage") != null) {
            currentPage = Integer.parseInt(request.getParameter("currentPage"));
        }
        
        // 한 페이지에 보여질 게시글 최대 수
        int boardLimit = 10;
        
        // 페이지 하단에 보여질 페이지 수
        int pageLimit = 10;
        
        List<CustomerDTO> list;

        if ("N".equals(status)) {
            // 탈퇴 회원만 선택된 경우
            listCount = dao.getMemberCount('N');
            list = dao.selectList(currentPage, boardLimit, 'N', sort);
        } else if ("Y".equals(status)) {
            // 회원만 선택된 경우
            listCount = dao.getMemberCount('Y');
            list = dao.selectList(currentPage, boardLimit, 'Y', sort);
        } else {
            // 모든 회원을 표시하는 경우
            listCount = dao.getMemberCount();
            list = dao.selectList(currentPage, boardLimit, sort);
        }
        
        // 전체 페이지 수 계산
        int maxPage = (int) Math.ceil((double) listCount / boardLimit);

        // 시작 페이지 계산
        int startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
        
        // 끝 페이지 계산
        int endPage = startPage + pageLimit - 1;
        if (maxPage < endPage) {
            endPage = maxPage;
        }
        
        // PageInfo 객체 생성 및 설정
        PageInfo pi = new PageInfo(currentPage, listCount, pageLimit, maxPage, startPage, endPage, boardLimit);
        
        // request에 필요한 속성 설정
        request.setAttribute("count", pi.getListCount());
        request.setAttribute("list", list);
        request.setAttribute("pi", pi);
        request.setAttribute("status", status); // 필터 상태를 JSP로 전달
        request.setAttribute("sort", sort); // 정렬 상태를 JSP로 전달
        
        // 뷰 페이지로 이동
        request.setAttribute("url", "/views/member/customerList.jsp");
        return new View("main.go");
    }
}

