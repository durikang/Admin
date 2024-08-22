<%@page import="com.global.admin.model.AdminDTO"%>
<%@page import="com.global.customer.model.CustomerDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	AdminDTO admin = (AdminDTO)request.getAttribute("info");
	
	String email = admin.getEmail();


    // @을 기준으로 문자열을 두 부분으로 나누기
    String[] parts = email.split("@");

    // 첫 번째 부분은 emailId, 두 번째 부분은 emailAddress
    String emailId = parts[0];
    String emailAddress = parts[1];


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${contextPath }/resources/master.css" rel ="stylesheet" type="text/css"/>
<link href="${contextPath }/resources/member/css/memberInsert.css" rel ="stylesheet" type="text/css"/>
<script src="${contextPath }/resources/member/passwordValidate/js/PasswordValidate.js"></script>
<link href="${contextPath }/resources/member/passwordValidate/css/passwordValidate.css" rel ="stylesheet" type="text/css"/>
<script src="${contextPath }/resources/member/js/insertMember.js"></script>
<title>Insert title here</title>
<script>
	window.onload = function(){
		var pwd = document.getElementById("pwd");
		if(pwd.textContent !=='')
			var length = pwd.textContent.length;
			for(int i=0;i<length;i++){
				pwd.textContent +="*";
			}
		}
	}

</script>
</head>
<body>
	<c:set var="currentPage" value="${requestScope.currentPage}" />
	<c:set var="status" value="${requestScope.status}" />

	<div align="center">
		<h3>${ info.name } 의
			상세 페이지
		</h3>
		<form action="adminUpdateOk.do" method="post" onsubmit="return validatePassword();">
		<input type="hidden" name="num" value="${ info.adminId }">
				<table class="insertTableForm" border="1">
					<tr>
						<th>No.</th>
						<td>${info.adminId }</td>
					</tr>
					<tr>
						<th>아이디</th>
						<td>${ info.userId }</td>
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
						<th>이름</th>
						<td><input type="text" name="name" value="${ info.name }"></td>
					</tr>
					<tr>
						<th>이메일</th>
		                <td>
		                	<input type="text" name="email" value="${ info.email }">
		                </td>
					</tr>
					<tr>
						<th>직급</th>
						<td>
							<select name="role" id="adminRole" required>
		                    	<c:choose>
									<c:when test="${ !empty list }">
										<c:forEach items="${list}" var="role">
											<option value="${ role.roleCode }">${role.roleName }</option>
										</c:forEach>
									</c:when>
			                    	<c:otherwise>
				                        등록된 역활이 없습니다. 역활 등록부터 해주세요.
			                    	</c:otherwise>
		                    	</c:choose>
		                    </select>
						</td>
					</tr>
					<tr>
						<th>회원 상태</th>
						<td>
						    <select name="memberStatus">
						        <option value="N" <c:if test="${info.getStatus() eq 'N'}">selected</c:if>>정상</option>
						        <option value="Y" <c:if test="${info.getStatus() eq 'Y'}">selected</c:if>>탈퇴회원</option>
						    </select>
						</td>
					</tr>
					<tr>
						<td class="table_bottom button memberInsertBtn" colspan="8" align="center">
							<input class="btn" type="submit" value="수정하기" onclick="test();">&nbsp;&nbsp;
							<input class="btn" type="reset" value="초기화">&nbsp;&nbsp;
							<input class="btn" type="button" value="회원 목록" onclick="location.href='${contextPath}/adminList.li?currentPage=${currentPage}&status=${status}'">
						</td>
					</tr>
				</table>
		</form>
	</div>

</body>
</html>