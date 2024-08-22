<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>   

<link rel="stylesheet"  href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<title>Insert title here</title>
<link href="${ contextPath }/resources/common/menubar.css" rel ="stylesheet" type="text/css"/>
<link href="${ contextPath }/resources/master.css" rel ="stylesheet" type="text/css"/>
<header>
        <div class="banner">이 페이지는 쇼핑몰 메인 페이지 입니다.</div>
        <nav>
            <div id="logo">
                
               ShoppingMall <br> Main Page
            </div>
            <ul class="navigation-menu">

                <li><a href="#">전체상품</a>

                </li>
                <li><a href="#">아우터</a>
                    <ul class="subnav">
                        <li class="card-med" id="sup-first">
                            <a href="#">
                                <span>패딩</span>

                            </a>
                        </li>
                        <li class="card-med" id="sup-second">
                            <a href="#">
                                <span>자켓</span>

                            </a>
                        </li>
                        <li class="card-med" id="sup-third">
                            <a href="#">
                                <span>가디건</span>

                            </a>
                        </li>
                        <li class="card-med" id="sup-fourth">
                            <a href="#">
                                <span>코트</span>
                                <span>More Info<span class="material-symbols-outlined">
                                        arrow_forward
                                    </span></span>
                            </a>
                        </li>
                    </ul>
                <li><a href="#">상의</a>
                    <ul class="subnav">
                        <li class="card-med" id="sup-first">
                            <a href="#">
                                <span>셔츠</span>
                                <span>More Info <span class="material-symbols-outlined">
                                        arrow_forward
                                    </span></span>
                            </a>
                        </li>
                        <li class="card-med" id="sup-second">
                            <a href="#">
                                <span>후드</span>
                                <span>More Info<span class="material-symbols-outlined">
                                        arrow_forward
                                    </span></span>
                            </a>
                        </li>
                        <li class="card-med" id="sup-third">
                            <a href="#">
                                <span>반팔</span>
                                <span>More Info<span class="material-symbols-outlined">
                                        arrow_forward
                                    </span></span>
                            </a>
                        </li>
                        <li class="card-med" id="sup-fourth">
                            <a href="#">
                                <span>긴팔</span>
                                <span>More Info<span class="material-symbols-outlined">
                                        arrow_forward
                                    </span></span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li><a href="#">하의</a>
                    <ul class="subnav">
                        <li class="card-med" id="sup-first">
                            <a href="#">
                                <span>슬랙스</span>
                                <span>More Info <span class="material-symbols-outlined">
                                        arrow_forward
                                    </span></span>
                            </a>
                        </li>
                        <li class="card-med" id="sup-second">
                            <a href="#">
                                <span>청바지</span>
                                <span>More Info<span class="material-symbols-outlined">
                                        arrow_forward
                                    </span></span>
                            </a>
                        </li>
                        <li class="card-med" id="sup-third">
                            <a href="#">
                                <span>반바지</span>
                                <span>More Info<span class="material-symbols-outlined">
                                        arrow_forward
                                    </span></span>
                            </a>
                        </li>
                        <li class="card-med" id="sup-fourth">
                            <a href="#">
                                <span>면바지</span>
                                <span>More Info<span class="material-symbols-outlined">
                                        arrow_forward
                                    </span></span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li><a href="#">신발</a>

                </li>
                <li><a href="#">악세사리</a>

                </li>
                <li><a href="#locate">커뮤니티</a>
                </li>

            </ul>
            <div id="utility">

                <a class="utility-button" href="${ contextPath }/views/member/register.jsp">회원가입</a>
                <a class="utility-button" href="#">로그인</a>
                <a class="utility-button" href="#">장바구니</a>
                <a class="utility-button utility-icon" href="#"><span
                        class="material-symbols-outlined">shopping_cart</span></a>



            </div>
        </nav>
    </header>