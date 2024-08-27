<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Pagination Controls -->
	<div class="pagination" align="center">
	    <%-- 이전 버튼 --%>
	    <%--현재 페이지가 1보다 클 때만 "이전" 버튼을 표시합니다.
	        버튼 클릭 시 currentPage를 1 감소시켜 이전 페이지로 이동합니다. --%>
	    <c:if test="${pi.currentPage > 1}">
	        <a href="${contextPath}/${ address }?currentPage=${pi.currentPage - 1}&status=${param.status}" class="pagination-button">이전</a>
	    </c:if>
	    
	    <%-- 페이지 번호 버튼 --%>
	    <%-- startPage와 endPage 사이의 페이지 번호를 반복하여 페이지 버튼을 생성합니다.
	        현재 페이지는 current 클래스를 가진 <span>으로 표시하고, 나머지 페이지는 <a> 링크로 표시합니다. --%>
	    <c:forEach var="pageNum" begin="${pi.startPage}" end="${pi.endPage}">
	        <c:choose>
	            <c:when test="${pageNum == pi.currentPage}">
	                <span class="pagination-button current">${pageNum}</span>
	            </c:when>
	            <c:otherwise>
	                <a href="${contextPath}/${ address }?currentPage=${pageNum}&status=${param.status}" class="pagination-button">${pageNum}</a>
	            </c:otherwise>
	        </c:choose>
	    </c:forEach>
	    
	    <%-- 다음 버튼 --%>
	    <%-- 현재 페이지가 maxPage보다 작을 때만 "다음" 버튼을 표시합니다.
	        버튼 클릭 시 currentPage를 1 증가시켜 다음 페이지로 이동합니다. --%>
	    <c:if test="${pi.currentPage < pi.maxPage}">
	        <a href="${contextPath}/${ address }?currentPage=${pi.currentPage + 1}&status=${param.status}" class="pagination-button">다음</a>
	    </c:if>
	</div>