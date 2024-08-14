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
		<h3>${ mem.name } 의
			상세 페이지
		</h3>
		
			<table border="1">
				<tr>
					<th>회원No.</th>
					<td>${mem.userNo }</td>
				</tr>
				<tr>
					<th>회원 아이디</th>
					<td>${mem.userId }</td>
				</tr>

				<tr>
					<th>회원명</th>
					<td>${mem.name }</td>
				</tr>
				<tr>
					<th>회원 나이</th>
					<td>${mem.age }</td>
				</tr>
				<tr>
					<th>회원 마일리지</th>
					<td><fmt:formatNumber value="${mem.mileage }" /></td>
				</tr>
				<tr>
					<th>회원 직업</th>
					<td>${mem.job }</td>
				</tr>
				<tr>
					<th>회원 주소</th>
					<td>${mem.location }</td>
				</tr>
				<tr>
					<th>회원 등록일</th>
					<td><fmt:formatDate value="${ mem.createdAt }"/></td>
				</tr>
				<tr>
					<th>회원 상태</th>
					<td>
	                    <c:choose>
	                        <c:when test="${mem.status eq 'N'}">
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
						<input class="btn" type="button" value="회원정보 수정" onclick="location.href='${ contextPath }/update.do?no=${mem.userNo}&currentPage=${currentPage}&status=${status}'">&nbsp;&nbsp;
						<c:choose>
	                        <c:when test="${mem.status == 'N'}">
	                            <input class="btn" type="button" value="회원정보 삭제" onclick="location.href='${ contextPath }/delete.do?no=${mem.userNo}&currentPage=${currentPage}&status=${status}'">&nbsp;&nbsp;
	                        </c:when>
	                    </c:choose>
						<input class="btn" type="button" value="회원 목록" onclick="location.href='${contextPath}/mlist.go?currentPage=${currentPage}&status=${status}'">
					</td>
				</tr>
			</table>

	</div>

</body>
</html>