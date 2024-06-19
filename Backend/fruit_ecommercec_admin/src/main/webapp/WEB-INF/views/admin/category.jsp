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
<title>Add new Category</title>
<body>
<!-- Recent Sales Start -->
<div class="container-fluid pt-4 px-4">
  <div class="bg-light text-center rounded p-4">
    <div class="d-flex align-items-center justify-content-between mb-4">
      <h6 class="mb-0">Recent Salse</h6>
      <td><a class="btn btn-sm btn-primary" href="${pageContext.request.contextPath}/category/add">Thêm Danh Mục</a></td>
      </tr>
    </div>
    <div class="table-responsive">
      <table class="table text-start align-middle table-bordered table-hover mb-0">
        <thead>
        <tr class="text-dark">
          <th scope="col">ID</th>
<%--          <th scope="col">Ảnh</th>--%>
          <th scope="col">Tên danh mục</th>
          <th scope="col">Trạng thái</th>
          <th scope="col">Hành Động</th>
        </tr>
        </thead>
        <tbody>
      <c:forEach var="category" items="${paginationCategory}">
        <tr>
          <td>${category.cateId}</td>
<%--          <td><img src="/resource/admin/img/category/${category.cateImg}" width="100" height="100"/></td>--%>
            <td>${category.cateImg}</td>
            <td>${category.cateName}</td>
          <td>${category.enable}</td>
          <td>
              <a href="${pageContext.request.contextPath}/user/edit/${user.id}" class="me-4"><i class="fa-solid fa-arrows-rotate"></i></a>
          </td>
        </tr>
      </c:forEach>
        </tbody>
      </table>
      <div class="d-flex justify-content-center">
        <nav aria-label="Page navigation example">
          <ul class="pagination">
            <li class="page-item">
              <a class="page-link" href="#" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
                <span class="sr-only">Previous</span>
              </a>
            </li>
            <c:forEach begin="1" end="${endPage}" var="i">
              <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/category/${i}">${i}</a></li>
            </c:forEach>
            <%--                <li class="page-item"><a class="page-link" href="#">2</a></li>--%>
            <%--                <li class="page-item"><a class="page-link" href="#">3</a></li>--%>
            <li class="page-item">
              <a class="page-link" href="#" aria-label="Next">
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
<!-- Recent Sales End -->
</body>
