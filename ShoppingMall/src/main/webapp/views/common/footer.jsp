<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${ contextPath }/resources/common/footer.css" rel ="stylesheet" type="text/css"/>
<style type="text/css">
#footer {
    /* width: 1150px; */
    display: block;
    height: 20%;
    margin:auto;
    border-top: 1px solid #cdcdcd;
    padding-top: 30px;
    text-align: center;
    background-color: #f1f1f1;
}

#footer1,#footer2{
	display:inline;
	margin:0;
	padding:0;
}


#footer1 > a {
    text-decoration: none;
    font-weight: 600;
    margin: 0 10px;
    line-height: 25px;
    color: black;
}

#footer1 > a:hover {
    color: deepskyblue;
}

#footer2 > p {
    margin: 20px;
    font-size: 12px;
}

#footer2 > p:first-child {
    margin-bottom: 10px;
}

#footer2 > p:last-child {
    text-align: center;
}



</style>

</head>
<body>

    <footer id="footer">
        <section id="footer1">
            <a href="#">이용약관</a> |
            <a href="#">개인정보처리방침</a> |
            <a href="#">FAQ</a> |
            <a href="#">고객센터</a> |
            <a href="#">사이트맵</a>
        </section>
        <section id="footer2">
            <p>© 2024 전체 폼 통합. All rights reserved.</p>
            <p>이 사이트는 학습 목적으로 제작되었습니다.</p>
        </section>
    </footer>




</body>
</html>