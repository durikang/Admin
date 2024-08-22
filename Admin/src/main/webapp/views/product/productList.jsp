<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 전체 리스트 페이지</title>
<script type="text/javascript">
/**
 * 
 */
 
 // JavaScript 함수: 클릭한 행의 ID를 가져와서 상세 페이지로 이동
function goToDetailPage(event) {
    const target = event.currentTarget;
    const userNo = target.getAttribute('data-id');
    if (userNo) {
        /* window.location.href = '${contextPath}/detail.do?no=' + userNo + '&status='+${status}+'&currentPage='+${pi.currentPage}; */
        window.location.href = '${contextPath}/customerDetail.do?no=' + userNo + '&status=' + '${status}' + '&currentPage=' + '${pi.currentPage}';
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
</head>
<body>
	<div align="center">
		<hr width="50%" color="red">
		<h3>상품 전체 리스트 페이지</h3>
		<hr width="50%" color="red">
		<br>
		<br>


		<table border="1" width="650">
			<tr>

				<th>상품 번호</th>
				<th>상품 이름</th>
				<th>상품 설명</th>
				<th>상품 가격</th>
				<th>상품 수량</th>
				<th>상품 등록일</th>
				<th>상품 수정일</th>
				<th>상품 상태</th>
				
			</tr>
			<c:set var="list" value="${List }" />
			<c:if test="${!empty list }">
				<c:forEach items="${list }" var="dto">
					<tr>
						<td>${dto.getProductId() }</td>
						<td>${dto.getName() }</td>
						<td>${dto.getDescription() }</td>
						<td>${dto.getPrice() }</td>
						<td>${dto.getStockQuantity() }</td>
						<td>${dto.getCreatedAt() }</td>
						<td>${dto.getUpdatedAt() }</td>
						<td>${dto.getIsDeleted() }</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty list }">
				<tr>
					<td colspan="8" align="center">
						<h3>전체 게시물이 없습니다.</h3>
					</td>
				</tr>
			</c:if>
		</table>
	</div>
</body>
</html>

<!-- 아이디	이름	비밀번호	나이	마일리지	직업	주소	등록일	회원 상태 -->