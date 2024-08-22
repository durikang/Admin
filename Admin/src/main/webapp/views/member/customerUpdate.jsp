<%@page import="com.global.customer.model.CustomerDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${contextPath }/resources/member/passwordValidate/css/passwordValidate.css" rel ="stylesheet" type="text/css"/>
<link href="${contextPath }/resources/member/insertTable/css/insertTable.css" rel ="stylesheet" type="text/css"/>
<link href="${contextPath }/resources/member/css/memberInsert.css" rel ="stylesheet" type="text/css"/>
<!-- Daum 주소 API -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="${contextPath }/resources/member/passwordValidate/js/PasswordValidate.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h3>${ member.name } 의 상세 페이지 </h3>
			<form action="customerUpdateOk.do" method="post" onsubmit="return validatePassword();">
				<input type="hidden" name="num" value="${ member.userNo }">
				<table class="insertTableForm" border="1">
					<tr>
						<th>아이디</th>
						<td>${ member.userId }</td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input type="text" name="name" value="${ member.name}" required></td>
					</tr>
					<tr>
						<th>회원비밀번호</th>
						<td><input type="password" id="pwd" name="pwd" value="" required></td>
					</tr>
					<tr>
						<th>회원비밀번호 확인</th>
						<td><input type="password" id="pwdConfirm" name="pwdConfirm" value="" required></td>
					</tr>
				</table>
	            <div class="errorArea">
	                <span id="password-error" class="error-message"></span>
	            </div>        
				<table class="insertTableForm" border="1">
					<tr>
						<th>회원 주소</th>
		                <td>
		                    <input type="text" name="addr" id="addr" value="${ member.location }" required>
		                </td>
		                <td>
		                	<input class="btn" type="button" value="주소 검색" onclick="execDaumPostcode()">
		                </td>
					</tr>
				</table>
				<table class="insertTableForm" border="1">
					<tr>
						<th>회원 직업</th>
						<td><input type="text" name ="job" value="${ member.job }"></td>
					</tr>
					<tr>
						<th>탈퇴 여부</th>
						<td>
							<c:choose>
								<c:when test="${member.getStatus() eq 'Y'}">
									탈퇴 처리된 회원입니다.
								</c:when>
								<c:otherwise>
									회원입니다.
								</c:otherwise>
							</c:choose>
						    <select name="isDeleted">
						        <c:choose>
						            <c:when test="${member.getStatus() eq 'Y'}">
						                <option value="Y" selected>회원 탈퇴</option>
						                <option value="N">탈퇴 복구</option>
						            </c:when>
						            <c:otherwise>
						                <option value="Y">회원 탈퇴</option>
						                <option value="N" selected>탈퇴 복구</option>
						            </c:otherwise>
						        </c:choose>
						    </select>
						    
						</td>
					</tr>
					<tr>
						<td class="table_bottom button memberInsertBtn" colspan="8" align="center">
							<input class="btn" type="submit" value="수정하기" onclick="test();">&nbsp;&nbsp;
							<input class="btn" type="reset" value="초기화">&nbsp;&nbsp;
							<input class="btn" type="button" value="회원 목록" onclick="location.href='${contextPath}/customerList.li?currentPage=${currentPage}&status=${status}'">
						</td>
					</tr>
				</table>
			</form>
	</div>
</body>
</html>