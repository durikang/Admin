<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>]
<link rel="stylesheet"  href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link href="${ contextPath }/resources/common/menubar.css" rel ="stylesheet" type="text/css"/>
<link href="${ contextPath }/resources/master.css" rel ="stylesheet" type="text/css"/>
<link href="${ contextPath }/resources/common/footer.css" rel ="stylesheet" type="text/css"/>
</head>
<body>
	<!-- header 영역 -->
	<c:import url="../common/menubar.jsp"/>
		<div class ="loginH" align="center">
			<h2>로그인 폼</h2>
			<form id="loginfr" action="${ contextPath }/login_ok" method="post">
				<table>
					<tr>아이디</tr>
					<tr><input type="text" name="userId"></tr></br>
					<tr>비밀번호</tr>
					<tr><input type="password" name ="pwd"></tr> </br>
				</table>			
			</form>
		</div>
	<!-- footer 영역 -->
	<c:import url="../common/footer.jsp"/>
</body>
</html>