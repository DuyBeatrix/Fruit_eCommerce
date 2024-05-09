<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/10/2024
  Time: 5:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<div id="spinner"--%>
<%--     class="show w-100 vh-100 bg-white position-fixed translate-middle top-50 start-50  d-flex align-items-center justify-content-center">--%>
<%--    <div class="spinner-grow text-primary" role="status"></div>--%>
<%--</div>--%>
<%--<!-- Spinner End -->--%>


<!-- Navbar start -->
<div class="container-fluid fixed-top">
    <div class="container topbar bg-primary d-none d-lg-block">
        <div class="d-flex justify-content-between">
            <div class="top-info ps-2">
                <small class="me-3"><i class="fas fa-map-marker-alt me-2 text-secondary"></i> <a href="#"
                                                                                                 class="text-white">123 Street, New York</a></small>
                <small class="me-3"><i class="fas fa-envelope me-2 text-secondary"></i><a href="#"
                                                                                          class="text-white">Email@Example.com</a></small>
            </div>
            <div class="top-link pe-2">
                <a href="#" class="text-white"><small class="text-white mx-2">Privacy Policy</small>/</a>
                <a href="#" class="text-white"><small class="text-white mx-2">Terms of Use</small>/</a>
                <a href="#" class="text-white"><small class="text-white ms-2">Sales and Refunds</small></a>
            </div>
        </div>
    </div>
    <div class="container px-0">
        <nav class="navbar navbar-light bg-white navbar-expand-xl">
            <a href="<c:url value="/"/>" class="navbar-brand">
                <h1 class="text-primary display-6">Fruitables</h1>
            </a>
            <button class="navbar-toggler py-2 px-3" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarCollapse">
                <span class="fa fa-bars text-primary"></span>
            </button>
            <div class="collapse navbar-collapse bg-white" id="navbarCollapse">
                <div class="navbar-nav mx-auto">
                    <a href="<c:url value="/"/>" class="nav-item nav-link active">Trang chủ</a>
                    <a href="shop.html" class="nav-item nav-link">Cửa hàng</a>
                    <a href="shop-detail.html" class="nav-item nav-link">Bài viết</a>
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Danh mục sản phẩm</a>
                        <div class="dropdown-menu m-0 bg-secondary rounded-0">
                            <c:forEach var="cate" items="${categories}">
                                <a href="cart.html" class="dropdown-item">${cate.cateName}</a>
                            </c:forEach>
<%--                            <a href="chackout.html" class="dropdown-item">Chackout</a>--%>
<%--                            <a href="testimonial.html" class="dropdown-item">Testimonial</a>--%>
<%--                            <a href="404.html" class="dropdown-item">404 Page</a>--%>
                        </div>
                    </div>
                    <a href="contact.html" class="nav-item nav-link">Liên hệ</a>
                    <a href="contact.html" class="nav-item nav-link">Nhà cung cấp</a>
                </div>
                <div class="d-flex m-3 me-0">
                    <!-- <button
                        class="btn-search btn border border-secondary btn-md-square rounded-circle bg-white me-4"
                        data-bs-toggle="modal" data-bs-target="#searchModal"><i
                            class="fas fa-search text-primary"></i></button> -->

<%--                    <div class="position-relative me-3">--%>
<%--                        <input id="searchInput" class="form-control border-2 border-secondary w-90 py-2 px-3 rounded-pill" type="text" placeholder="Search">--%>
<%--                        <button id="searchButton" type="submit"--%>
<%--                                class="btn btn-primary py-2 px-3 position-absolute rounded-pill text-white h-100 fas fa-search" style="top: 0; right: 0;">--%>
<%--                        </button>--%>
<%--                    </div>--%>

                    <form id="searchForm" action="${pageContext.request.contextPath}/search/${freeText}" method="GET">
                        <div class="position-relative me-3">
                            <input name="freeText" id="searchInput" class="form-control border-2 border-secondary w-90 py-2 px-3 rounded-pill" type="text" placeholder="Search">
                            <button type="submit" class="btn btn-primary py-2 px-3 position-absolute rounded-pill text-white h-100 fas fa-search" style="top: 0; right: 0;"></button>
                        </div>
                    </form>

                    <a href="${pageContext.request.contextPath}/cart" class="position-relative me-4 my-auto">

                    <div class="position-relative me-3">
                        <input class="form-control border-2 border-secondary w-90 py-2 px-3 rounded-pill" type="text"
                               placeholder="Tìm kiếm">
                        <button type="submit"
                                class="btn btn-primary py-2 px-3 position-absolute rounded-pill text-white h-100 fas fa-search"
                                style="top: 0; right: 0;"></button>
                    </div>
                    <a href="cart.html" class="position-relative me-4 my-auto">

                        <i class="fa fa-shopping-bag fa-2x"></i>
                        <span
                                class="position-absolute bg-secondary rounded-circle d-flex align-items-center justify-content-center text-dark px-1"
                                style="top: -5px; left: 15px; height: 20px; min-width: 20px;">${cart.size()}</span>
                    </a>
                    <c:if test="${empty loginInfo}">
                        <a href="${pageContext.request.contextPath}/login" class="my-auto">
                            <i class="fas fa-user fa-2x"></i>
                        </a>
                    </c:if>
                    <c:if test="${not empty loginInfo}">
                        <a href="${pageContext.request.contextPath}/logout" class="my-auto">
                            <i class="fa-solid fa-right-from-bracket fa-2x"></i>
                        </a>
                    </c:if>
                </div>
            </div>
        </nav>
    </div>
</div>
<!-- Navbar End -->


<!-- Modal Search Start -->
<div class="modal fade" id="searchModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-fullscreen">
        <div class="modal-content rounded-0">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Search by keyword</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body d-flex align-items-center">
                <div class="input-group w-75 mx-auto d-flex">
                    <input type="search" class="form-control p-3" placeholder="keywords"
                           aria-describedby="search-icon-1">
                    <span id="search-icon-1" class="input-group-text p-3"><i class="fa fa-search"></i></span>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Modal Search End -->

<%--<script>--%>
<%--    document.getElementById("searchButton").addEventListener("click", function() {--%>
<%--        window.location.href = "${pageContext.request.contextPath}/search";--%>
<%--    });--%>
<%--</script>--%>

<script>
    document.getElementById("searchForm").addEventListener("submit", function(event) {
        event.preventDefault(); // Ngăn chặn hành động mặc định của form
        var searchText = document.getElementById("searchInput").value;
        window.location.href = "${pageContext.request.contextPath}/search/" + searchText;
    });
</script>

