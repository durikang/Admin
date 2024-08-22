<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet"  href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<title>Insert title here</title>
<link href="${ contextPath }/resources/common/menubar.css" rel ="stylesheet" type="text/css"/>
<link href="${ contextPath }/resources/master.css" rel ="stylesheet" type="text/css"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="banner">이 페이지는 쇼핑몰 회원가입 페이지 입니다.</div>
        <nav>
            <div id="logo">
                
               ShoppingMall <br> Register Page
            </div>
            
            <h2>회원가입</h2>
            <form action="register_ok.jsp" method="post">
            	아이디:<input type="text" name="id"></br>
            	비밀번호 : <input type="password" name="pwd"></br>
            	이름 : <input type="text" name="name"></br>
            	이메일 : <input type="text" name="E-mail"></br>
            	
            	<input type="radio" name="gender" value="m" checked>남자
            	<input type="radio" name="gender" value="f" > 여자
            	
            	<input type="submit" value="가입">
            </form>
</body>
</html>