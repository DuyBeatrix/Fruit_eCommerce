<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<title>Edit Category</title>
<body>
<div class="container-fluid pt-4 px-4">
  <div class="bg-light rounded p-4">
    <h6 class="mb-4">Edit Blog Detail</h6>
    <form:form method="post" action="${pageContext.request.contextPath}/blogdetails/edit" enctype="multipart/form-data" modelAttribute="blogDetail">
      <form:hidden path="id"/>
      <div class="mb-3">
        <label for="title" class="form-label">Title</label>
        <form:input type="text" path="title" class="form-control" id="title"/>
      </div>
      <div class="mb-3">
        <label for="content" class="form-label">Content</label>
        <form:textarea path="content" class="form-control" id="content"/>
      </div>
      <div class="mb-3">
        <label for="description" class="form-label">Description</label>
        <form:textarea path="description" class="form-control" id="description"/>
      </div>
      <div class="mb-3">
        <label for="blogImg" class="form-label">Image</label>
        <input type="file" name="blogImg" class="form-control-file" id="blogImg"/>
      </div>
      <div class="mb-3">
        <label for="createAt" class="form-label">Create At</label>
        <form:input type="date" path="createAt" class="form-control" id="createAt"/>
      </div>
      <div class="mb-3">
        <label for="blogId" class="form-label">Blog Type ID</label>
        <form:input type="number" path="blogId" class="form-control" id="blogId"/>
      </div>
      <div class="mb-3">
        <label for="customerId" class="form-label">Customer ID</label>
        <form:input type="number" path="customerId" class="form-control" id="customerId"/>
      </div>
      <button type="submit" class="btn btn-primary">Update Blog Detail</button>
    </form:form>
  </div>
</div>
</body>
