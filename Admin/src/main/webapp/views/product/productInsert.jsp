<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<link href="${contextPath }/resources/product/css/productInsert.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<div align="center">
		<h3>상품 등록</h3>

		<form action="${ contextPath }/productInsertOk.do" method="post"
			onsubmit="return validatePasswords()">
			<table class="insertTableForm">
		<c:set var="catlist" value="${CategoryList }" />
				<tr>
					<th>상품 이름</th>
					<td><input type="text" name="proName" required></td>
				</tr>
				<tr>
					<th>카테고리 번호</th>
					<td>
						<select name="proCategory" requireds>
	                  <c:if test="${empty CategoryList }">
	                     <option value="">:::카테고리 코드 없음:::</option>
	                  </c:if>
	                  
	                  <c:if test="${!empty CategoryList }">
	                     <c:forEach items="${CategoryList }" var="dto">
	                        <option value="${dto.getCategoryId() }">
	                         ${dto.getName() } (${ dto.getCategoryId() })</option>
	                     </c:forEach>
	                  </c:if>
	               </select>
					</td>
				</tr>
				<tr>
					<th>상품 정보</th>
					<td><textarea rows="8" cols="22" name="proInfo"></textarea></td>
				</tr>
				<tr>
					<th>상품 가격</th>
					<td><input type="text" name="proprice" required></td>
				</tr>
				<tr>
                <th>제고 수량</th>
                    <td><input type="text" name="prosu" required></td>
                </tr>
            	<tr>
					<td class="table_bottom button productInsertBtn" colspan="2">
						<input class="btn" type="submit" value="카테고리 등록"> <input
						class="btn" type="reset" value="초기화">
					</td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>