<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 6/13/2024
  Time: 12:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<title>Manage Users</title>
<body>
<!-- Recent Users Start -->
<div class="container-fluid pt-4 px-4">
    <div class="bg-light text-center rounded p-4">
        <div class="d-flex align-items-center justify-content-between mb-4">
            <h6 class="mb-0">User Management</h6>
            <td><a class="btn btn-sm btn-primary" href="${pageContext.request.contextPath}/user/add">Add New User</a></td>
        </div>
        <div class="table-responsive">
            <table class="table text-start align-middle table-bordered table-hover mb-0">
                <thead>
                <tr class="text-dark">
                    <th scope="col">ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">Username</th>
                    <th scope="col">Email</th>
                    <th scope="col">Phone</th>
                    <th scope="col">Address</th>
                    <th scope="col">Gender</th>
                    <th scope="col">Role ID</th>
                    <th scope="col">Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${paginationUsers}">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.cusName}</td>
                        <td>${user.username}</td>
                        <td>${user.cusEmail}</td>
                        <td>${user.cusPhone}</td>
                        <td>${user.cusAddress}</td>
                        <td>${user.gender ? 'Male' : 'Female'}</td>
                        <td>${user.roleId}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/user/edit/${user.id}" class="me-4"><i class="fa-solid fa-arrows-rotate"></i></a>
                            <a href="${pageContext.request.contextPath}/user/delete/${user.id}" onclick="deleteUser('${user.id}')"><i class="fa-solid fa-trash-can" style="width: 24px; height: 24px" onclick="deleteProduct('${product.productId}')"></i></a>
<%--                            <a class="btn btn-sm btn-warning" href="${pageContext.request.contextPath}/user/edit/${user.id}">Edit</a>--%>
<%--                            <a class="btn btn-sm btn-danger" href="${pageContext.request.contextPath}/user/delete/${user.id}" onclick="deleteUser('${user.id}')">Delete</a>--%>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="d-flex justify-content-center">
                <nav aria-label="Page navigation example">
                    <ul class="pagination">
                        <li class="page-item">
                            <a class="page-link" href="${pageContext.request.contextPath}/user/${1}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                                <span class="sr-only">Previous</span>
                            </a>
                        </li>
                        <c:forEach begin="1" end="${endPage}" var="i">
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/user/${i}">${i}</a></li>
                        </c:forEach>
                        <li class="page-item">
                            <a class="page-link" href="${pageContext.request.contextPath}/user/${endPage}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                                <span class="sr-only">Next</span>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</div>
<script>
    function deleteUser(id) {
        let ans = confirm("Bạn có đồng ý xóa nguười dùng này này?");
        if(ans){
            window.location = "delete/"+id;
        }
    }
</script>
<!-- Recent Users End -->
</body>
