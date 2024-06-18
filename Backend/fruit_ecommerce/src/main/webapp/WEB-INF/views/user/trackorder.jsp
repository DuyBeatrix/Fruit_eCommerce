<%--
  Created by IntelliJ IDEA.
  User: FPT
  Date: 03/06/2024
  Time: 9:25 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>

<div class="container" style="margin-top: 100px">
    <div><h2>Thông tin đơn hàng</h2></div>
    <table class="table">
        <thead>
        <tr>
            <th>Full Name</th>
            <th>Address</th>
            <th>Phone Number</th>
            <th>Time</th>
            <th>Total Price</th>
            <th>Status</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${trackorder}">
            <tr>
                <td>${order.fullName}</td>
                <td>${order.address}</td>
                <td>${order.phone}</td>
                <td>${order.createDay}</td>
                <td>${order.total}</td>
                <td>${order.status}</td>
                <td><a href="<c:url value="/trackorderdetail/${order.checkoutid}"/> ">View order details</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
</body>
