<%@page import="com.global.customer.model.CustomerDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${contextPath }/resources/master.css" rel ="stylesheet" type="text/css"/>
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
		
			<table border="1">
				<tr>
					<th>No.</th>
					<td>${info.adminId }</td>
				</tr>
				<tr>
					<th>아이디</th>
					<td>${info.userId }</td>
				</tr>

				<tr>
					<th>이름</th>
					<td>${info.name }</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>${info.email }</td>
				</tr>
				<tr>
					<th>직급</th>
					<td>${info.roleCode }</td>
				</tr>
				<tr>
					<th>회원 상태</th>
					<td>
	                    <c:choose>
	                        <c:when test="${info.getStatus() eq 'N'}">
	                            <c:set var="res" value="정상"/>
	                        </c:when>
	                        <c:otherwise>
	                            <c:set var="res" value="탈퇴회원"/>
	                        </c:otherwise>
	                    </c:choose>
                    <c:out value="${res}"/>
					
					</td>
				</tr>
				<tr>
					<td class="table_bottom button" colspan="8" align="center">
						<input class="btn" type="button" value="정보 수정" onclick="location.href='${ contextPath }/adminUpdateForm.do?no=${info.adminId}&currentPage=${currentPage}&status=${status}'">&nbsp;&nbsp;
						<c:choose>
	                        <c:when test="${info.status == 'N'}">
	                            <input class="btn" type="button" value="정보 삭제" onclick="location.href='${ contextPath }/adminDelete.do?no=${info.adminId}&currentPage=${currentPage}&status=${status}'">&nbsp;&nbsp;
	                        </c:when>
	                    </c:choose>
						<input class="btn" type="button" value="관리자 목록" onclick="location.href='${contextPath}/adminList.li?currentPage=${currentPage}&status=${status}'">
					</td>
				</tr>
			</table>

	</div>

</body>
</html>