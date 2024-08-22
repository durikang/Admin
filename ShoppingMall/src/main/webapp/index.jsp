<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰 페이지</title>
</head>
<body>
<script type="text/javascript">

<c:set var="contextPath" value="${ pageContext.servletContext.contextPath }" scope="application"/>

	window.onload = function(){
		location.href="${contextPath}/main.go";
	}
/* 
	2024082201 by 성빈
 */	

</script>
</body>
</html>