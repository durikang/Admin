<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>카테고리 등록</title>
</head>
<body>
	<div align="center">
    <h3>카테고리 등록</h3>

    <form action="${ contextPath }/productCategoryInsert.do" method="post" onsubmit="return validatePasswords()">
        <table class="insertTableForm">
            <tr>
                <th>카테고리 이름</th>
                <td>
                    <input type="text" name="memId" required>
                </td>
            </tr>
             <tr>
                <th>카테고리 정보</th>
                <td>
                    <textarea rows="1" cols="7"></textarea>
                </td>
            </tr>
            
         </table>
     </form>
     </div>

</body>
</html>