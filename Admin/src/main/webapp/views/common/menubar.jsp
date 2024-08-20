<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link href="${contextPath }/resources/master.css" rel="stylesheet"
	type="text/css" />
<link href="${contextPath }/resources/common/menubar.css"
	rel="stylesheet" type="text/css" />

<!-- 관리자 페이지 메뉴바 -->
<div class="navbar">
	<a href="${contextPath}/views/main.jsp" class="logo">관리자 페이지</a> <a href="#dashboard"
		class="active">대시보드</a>
	<div class="dropdown">
		<button class="dropbtn">
			회원 관리 <i class="fa fa-caret-down"></i>
		</button>
		<div class="dropdown-content">
			<a href="${contextPath}/views/main.jsp?url=/views/member/customerInsert.jsp">회원 등록</a> <a
				href="${ contextPath }/mlist.go">회원 목록</a>
		</div>
	</div>
	<div class="dropdown">
		<button class="dropbtn">
			상품 관리 <i class="fa fa-caret-down"></i>
		</button>
		<div class="dropdown-content">
			<a href="#productInsert">상품 등록</a> <a href="#productList">상품 목록</a>
		</div>
	</div>
	<div class="dropdown">
		<button class="dropbtn">
			주문 관리 <i class="fa fa-caret-down"></i>
		</button>
		<div class="dropdown-content">
			<a href="#orderList">주문 목록</a> <a href="#orderProcess">주문 처리</a>
		</div>
	</div>
	<a href="#statistics">통계</a> <a href="#settings">설정</a>
</div>


