<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"  href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<title>Insert title here</title>
<style>
	.reg{
		
		color : black;
		width: 1000px;
		margin: auto;
		margin-top: 50px;
	}
	#regtx talbe {margin : auto;}
	#regtx input {margin : 5px;}
</style>

<link href="${ contextPath }/resources/common/menubar.css" rel ="stylesheet" type="text/css"/>
<link href="${ contextPath }/resources/master.css" rel ="stylesheet" type="text/css"/>
<link href="${ contextPath }/resources/common/footer.css" rel ="stylesheet" type="text/css"/>

</head>
<body>
	<!-- header 영역 -->
	<c:import url="../common/menubar.jsp"/>

	<div class="reg" align="center">
		<h2 align="center">회원가입 폼</h2>
		<form id="regtx" action="${contextPath}/register_ok" method="post">
			
			<table>
				<tr>
					<td>아이디 : </td>
					<td><input type="text" name="userId" maxlength="50" required></td>
					<td><button type="button">중복확인</button></td>
				</tr>
				<tr>
					<td>비밀번호 : </td>
					<td><input type="password" name="pwd" maxlength="100" required></td>
					<td><td>
				</td>
				<tr>
					<td>비밀번호 확인 : </td>
					<td><input type="password" maxlength="100" required></td>
					<td></td>
				</tr>
				<tr>
					<td>이름 : </td>
					<td><input type="text" name="name" maxlength="100" required></td>
					<td></td>
				</tr>
				<tr>
					<td>이메일 : </td>
					<td><input type="text" name="email" maxlength="100" required></td>
					<td></td>
				</tr>
				<tr>
					<td>나이 : </td>
					<td><input type="number" name="age" required></td>
					<td></td>
				</tr>
				<tr>
					<td>직업 : </td>
					<td><input type="text" name="job" required></td>
					<td></td>
				</tr>
				<tr>
					<td>주소 : </td>
					<td><input type="text" name="location" required></td>
					<td></td>
				</tr>
				
			</table>
			<br><br>

			<div align="center">
				<button type="submit">가 입</button>
				<button type="reset">초기화</button>
			</div>
			<br>
		</form>
	</div>
	<!-- footer 영역 -->
	<c:import url="../common/footer.jsp"/>
</body>
</html>