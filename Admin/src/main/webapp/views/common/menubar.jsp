<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link href="${contextPath }/resources/master.css" rel="stylesheet" type="text/css" />
<link href="${contextPath }/resources/common/menubar.css" rel="stylesheet" type="text/css" />

<!-- 관리자 페이지 메뉴바 -->
<div class="navbar">
   <a href="${contextPath}/views/main.jsp" class="logo">관리자 페이지</a> <a
      href="#dashboard" class="active">대시보드</a>
   <div class="dropdown">
      <button class="dropbtn">
         관리자 관리 <i class="fa fa-caret-down"></i>
      </button>
      <div class="dropdown-content">
         <a href="${ contextPath }/adminInsert.do">관리자 등록</a> 
         <a href="${ contextPath }/adminRoleInsert.go">관리자 역활 등록</a> 
         <a href="${ contextPath }/adminRoleList.li">관리자 역활 목록</a> 
         <a href="${ contextPath }/adminList.li">관리자 목록</a>
      </div>
   </div>
   <div class="dropdown">
      <button class="dropbtn">
         회원 관리 <i class="fa fa-caret-down"></i>
      </button>
      <div class="dropdown-content">
         <a href="${ contextPath }/customerInsertForm.go">회원 등록</a> 
         <a href="${ contextPath }/customerList.li">회원 목록</a>
      </div>
   </div>
   <div class="dropdown">
      <button class="dropbtn">
         상품 관리 <i class="fa fa-caret-down"></i>
      </button>
      <div class="dropdown-content">
         <a href="${contextPath}/productInsert.go">상품 등록</a> 
         <a href="${contextPath}/productList.li">상품 목록</a> 
         <a href="${contextPath}/productCategoryInsert.go">카테고리 등록</a> 
         <a href="${contextPath}/productCategoryList.li">>카테고리 목록</a>
      </div>
   </div>
   <div class="dropdown">
      <button class="dropbtn">
         주문 관리 <i class="fa fa-caret-down"></i>
      </button>
      <div class="dropdown-content">
         <a href="#orderList">주문 목록</a> 
         <a href="#orderProcess">주문 처리</a>
      </div>
   </div>
   <div class="dropdown">
      <button class="dropbtn">
         게시판 <i class="fa fa-caret-down"></i>
      </button>
      <div class="dropdown-content">
         <a href="#orderList">공지 게시판</a> 
         <a href="#orderProcess">자유 게시판</a> 
         <a href="#orderProcess">리뷰 게시판</a> 
         <a href="#orderProcess">고객 QNA 게시판</a>
      </div>
   </div>
   <a href="#statistics">통계</a> 
   <a href="#settings">설정</a>
</div>


