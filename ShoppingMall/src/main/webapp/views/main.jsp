<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html lang="kor">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>관리지 페이지</title>

</head>

<body>
	<!-- header 영역 -->
	<c:import url="common/menubar.jsp"/>
    <!-- Main 영역 -->
    <!-- 서블릿에서 전달된 URL에 따라 동적으로 JSP 페이지를 포함 -->

    <section class="hero">
        <h1>Your One-Stop Shop for Every Pet's Needs!</h1>
        <div class="btn-group">
            <button class="btn-filled-dark"><span class="material-symbols-outlined">
                    shopping_cart
                </span>전체 상품</button>
            <button class="btn-outline-dark btn-hover-color"><span class="material-symbols-outlined">
                search
                </span>상품 검색</button>
        </div>
    </section>
    <section>
        <h2>Shop by Pet</h2>

        <ul class="shop-pets">
            <li class="card-large card-dark" id="sup-second">
                <div class="card-image"><img src=""></div>
                 <div class="main_bodytext">아우터</div>
                <ul>
                    <li><a href="#">Food &amp; Treats</a></li>
                    <li><a href="#">Toys</a></li>
                    <li><a href="#">Furniture</a></li>
                </ul>
                    <button class="btn-outline-dark main_bodybutton">Shop All
                    <span class="material-symbols-outlined"></span>
                    </button>
            </li>

            <li class="card-large card-dark" id="sup-second">
                <div class="card-image"><img src=""></div>
                <div class="main_bodytext">상의</div>
                <ul>
                    <li><a href="#">Food &amp; Treats</a></li>
                    <li><a href="#">Toys</a></li>
                    <li><a href="#">Beds &amp; Furniture</a></li>

                </ul>
                    <button class="btn-outline-dark main_bodybutton">Shop All
                    <span class="material-symbols-outlined"></span>
                    </button>
            </li>

            <li class="card-large card-dark" id="sup-second">
                <div class="card-image"><img src=""> </div>
                <div class="main_bodytext">하의</div>
                <ul>
                    <li><a href="#">Food &amp; Treats</a></li>
                    <li><a href="#">Toys</a></li>
                    <li><a href="#">Furniture</a></li>
                    </ul>
					<button class="btn-outline-dark main_bodybutton">Shop All
                    <span class="material-symbols-outlined"></span>
                    </button>

            </li>
            <li class="card-large card-dark" id="sup-fourth">
                <div class="card-image"><img src=""> </div>
                <div class="main_bodytext">신발</div>
                <ul>
                    <li><a href="#">Food &amp; Treats</a></li>
                    <li><a href="#">Toys</a></li>
                    <li><a href="#">Furniture</a></li>
                </ul>
					<button class="btn-outline-dark main_bodybutton">Shop All
                    <span class="material-symbols-outlined"></span>
                    </button>

            </li>
            <li class="card-large card-dark" id="sup-second">
                <div class="card-image"><img src=""></div>
                <div class="main_bodytext">악세사리</div>
                <ul>
                    
                    <li><a href="#">Food &amp; Treats</a></li>
                    <li><a href="#">Toys</a></li>
                    <li><a href="#">Furniture</a></li>
                </ul>
					<button class="btn-outline-dark main_bodybutton">Shop All
                    <span class="material-symbols-outlined"></span>
                    </button>
            </li>
        </ul>
    </section>
    <section id="locate">
        <div>
            <h2>커뮤니티</h2>
            <table class="community" style="margin:50px;">
                    <tbody>
                        <tr>
							<th>전체 게시물 리스트가 없습니다.....</th>
                        </tr>
                    </tbody>
            </table>
			<div class="btn-group">
			    <!-- 이전 페이지 버튼 -->
			    <button class="btn-filled-dark">
			        <span class="material-symbols-outlined">arrow_back</span>
			        이전 페이지
			    </button>
			
			    <!-- 다음 페이지 버튼 -->
			    <button class="btn-outline-dark btn-hover-color">
			        <span class="material-symbols-outlined">arrow_forward</span>
			        다음 페이지
			    </button>
			</div>
        </div>
    </section>
	<!-- footer 영역 -->
	<c:import url="common/footer.jsp"/>
</html>

</html>


</html>