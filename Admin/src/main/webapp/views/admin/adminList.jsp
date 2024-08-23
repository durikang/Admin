<%@page import="com.global.customer.model.CustomerDTO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,java.util.List ,com.global.customer.model.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 리스트</title>
<link href="${contextPath}/resources/master.css" rel="stylesheet" type="text/css"/>
<link href="${contextPath}/resources/member/css/memberListPwd.css" rel="stylesheet" type="text/css"/>
<link href="${contextPath}/resources/member/css/memberList.css" rel="stylesheet" type="text/css"/>
<script src="${contextPath}/resources/member/js/listMember.js"></script>
<script type="text/javascript">
/**
 * 
 */
 
 // JavaScript 함수: 클릭한 행의 ID를 가져와서 상세 페이지로 이동
function goToDetailPage(event) {
    const target = event.currentTarget;
    const adminId = target.getAttribute('data-id');
    if (adminId) {
        
        window.location.href = '${contextPath}/adminDetail.do?no=' + adminId + '&status=' + '${status}' + '&currentPage=' + '${pi.currentPage}';
    }
}

// 모든 행에 클릭 이벤트 리스너 추가
document.addEventListener('DOMContentLoaded', function() {
    const rows = document.querySelectorAll('table tr[data-id]');

    rows.forEach(row => {
        row.addEventListener('click', goToDetailPage);
    });
});
</script>

<style type="text/css">
/* 페이지네이션 컨테이너 스타일 */
.pagination {
    display: flex;
    justify-content: center;
    align-items: center;
    margin: 20px 0;
}

/* 페이지네이션 버튼 스타일 */
.pagination-button {
    display: inline-block;
    padding: 10px 15px;
    margin: 0 5px;
    font-size: 16px;
    font-weight: bold;
    color: #333; /* 텍스트 색상을 어두운 회색으로 변경 */
    background-color: #e0e0e0; /* 버튼 배경색을 밝은 회색으로 변경 */
    border: 1px solid #ccc; /* 버튼 테두리 색상 */
    border-radius: 5px;
    text-decoration: none;
    text-align: center;
    transition: background-color 0.3s, color 0.3s, box-shadow 0.3s;
}

/* 페이지네이션 버튼 호버 효과 */
.pagination-button:hover,
.pagination-button:focus {
    background-color: #c0c0c0; /* 호버 시 배경색을 약간 어두운 회색으로 변경 */
    color: #000; /* 텍스트 색상을 검정으로 변경 */
    outline: none;
}

/* 현재 페이지 스타일 */
.pagination-button.current {
    background-color: #b0b0b0; /* 현재 페이지 버튼 배경색을 다소 어두운 회색으로 변경 */
    color: #fff; /* 현재 페이지 텍스트 색상을 흰색으로 변경 */
    cursor: default;
}

/* 비활성화된 버튼 스타일 */
.pagination-button.disabled {
    background-color: #d0d0d0; /* 비활성화된 버튼 배경색을 연한 회색으로 변경 */
    color: #666666; /* 비활성화된 버튼 텍스트 색상 */
    cursor: not-allowed;
    pointer-events: none;
}

/* 버튼 간격 조정 */
.pagination-button + .pagination-button {
    margin-left: 0;
}

/* 반응형 디자인 */
@media (max-width: 768px) {
    .pagination-button {
        padding: 8px 12px;
        font-size: 14px;
    }
}



/* 필터 버튼 스타일링 */
.filter-button {
    display: inline-block;
    padding: 10px 20px;
    font-size: 16px;
    font-weight:bold;
    color: #000;
    background-color: #e0e0e0;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s, box-shadow 0.3s;
    margin-bottom: 20px;
}

.filter-button:hover {
    background-color: #c0c0c0;
    color:#000;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
}

/* 필터 폼 스타일링 */
.form-container {
    display: none; /* 기본적으로 숨김 */
    margin: 20px auto;
    padding: 20px;
    max-width: 600px;
    border: 1px solid #ddd;
    border-radius: 8px;
    background-color: #f9f9f9;
}

.form-container label {
    display: flex;
    align-items: center;
    margin-bottom: 10px;
    font-size: 16px;
}

.form-container input[type="checkbox"] {
    margin-right: 10px;
    transform: scale(1.2);
    cursor: pointer;
}

.form-container input[type="submit"] {
    display: inline-block;
    padding: 10px 20px;
    font-size: 16px;
    font-weight:bold;
    color: #000;
    background-color: #e0e0e0; /* 홈페이지 컨셉에 맞는 색상 */
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s, box-shadow 0.3s;
}

.form-container input[type="submit"]:hover {
    background-color: #c0c0c0;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
}

@media (max-width: 768px) {
    .form-container {
        padding: 15px;
    }

    .form-container input[type="submit"] {
        font-size: 14px;
        padding: 8px 16px;
    }
}


</style>


</head>
<body>

<div align="center">
    <h3>관리자 관리 페이지</h3>
    <div class="spacer"></div> <!-- 공백 추가 -->

	<table border="1">
	    <tr>
	        <td class="table_header button" colspan="9" align="right">
	            전체 관리자 수 : ${count}
	        </td>
	    </tr>
	    <tr>
	        <th>No.</th> 
	        <th>아이디</th> 
	        <th>비밀번호</th>
	        <th>이름</th>
	        <th>이메일</th>
	        <th>직급</th>
	        <th>회원 상태</th>
	    </tr>
	    <c:choose>
	        <c:when test="${not empty list}">
	            <c:forEach items="${list}" var="admin">
	            <tr class="trlist" data-id="${admin.adminId}">
	                <td>${admin.adminId}</td>
	                <td>${admin.userId}</td>
	                <td class="pwd-mask">
	                    <!-- 기본적으로 maskedPwd를 표시 -->
	                    <span>${admin.maskedPwd}</span>
	                    <!-- 마우스 오버 시 실제 비밀번호 표시 -->
	                    <span class="actual-pwd">${admin.password}</span>
	                </td>
	                <td>${admin.name}</td>
	                <td>${admin.email}</td>
	                <td>(${admin.roleCode}) ${admin.roleName }</td>
	                <td>${admin.isDeleted}</td>
	            </tr>
	            </c:forEach>
	        </c:when>
	        <c:otherwise>
	            <tr>
	                <td colspan="10" align="center">
	                    <h3>관리자 데이터가 없습니다.</h3>
	                </td>
	            </tr>
	        </c:otherwise>
	    </c:choose>  
	    <tr>
	        <td class="table_bottom button" colspan="9" align="center">
	            <input type="button" class="btn" value="관리자 등록" onclick="location.href='${contextPath}/adminInsert.do'">
	        </td>
	    </tr>
	</table>
    
	<!-- Pagination Controls -->
	<div class="pagination" align="center">
	    <%-- 이전 버튼 --%>
	    <%--현재 페이지가 1보다 클 때만 "이전" 버튼을 표시합니다.
	        버튼 클릭 시 currentPage를 1 감소시켜 이전 페이지로 이동합니다. --%>
	    <c:if test="${pi.currentPage > 1}">
	        <a href="${contextPath}/customerList.go?currentPage=${pi.currentPage - 1}&status=${param.status}" class="pagination-button">이전</a>
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
	                <a href="${contextPath}/customerList.go?currentPage=${pageNum}&status=${param.status}" class="pagination-button">${pageNum}</a>
	            </c:otherwise>
	        </c:choose>
	    </c:forEach>
	    
	    <%-- 다음 버튼 --%>
	    <%-- 현재 페이지가 maxPage보다 작을 때만 "다음" 버튼을 표시합니다.
	        버튼 클릭 시 currentPage를 1 증가시켜 다음 페이지로 이동합니다. --%>
	    <c:if test="${pi.currentPage < pi.maxPage}">
	        <a href="${contextPath}/customerList.go?currentPage=${pi.currentPage + 1}&status=${param.status}" class="pagination-button">다음</a>
	    </c:if>
	</div>


</div>

</body>
</html>
