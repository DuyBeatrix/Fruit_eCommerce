<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/19/2024
  Time: 12:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
                                <c:forEach var="probycate" items="${probycate}">
                                <div class="col-md-6 col-lg-4 col-xl-3">
                                    <div class="rounded position-relative fruite-item">
                                        <div class="fruite-img">
                                            <img src="<c:url value="/resource/user/img/products/${probycate.productImg}"/>" class="img-fluid w-100 rounded-top"
                                                 alt="">
                                        </div>
                                        <div class="text-white bg-secondary px-3 py-1 rounded position-absolute"
                                             style="top: 10px; left: 10px;">${probycate.cateName}</div>
                                        <div class="p-4 border border-secondary border-top-0 rounded-bottom">
                                            <h4>${probycate.productName}</h4>
                                            <p>${probycate.shortDesc}</p>
                                            <div class="d-flex justify-content-between flex-lg-wrap">
                                                <p class="text-dark fs-5 fw-bold mb-0">${probycate.productPrice} / kg</p>
                                                <a href="#"
                                                   class="btn border border-secondary rounded-pill px-3 text-primary"><i
                                                        class="fa fa-shopping-bag me-2 text-primary"></i> Add to
                                                    cart</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                </c:forEach>
</body>

