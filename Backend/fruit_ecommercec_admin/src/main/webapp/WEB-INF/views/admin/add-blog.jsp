<!-- add-blog.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<title>Add New Blog Detail</title>
<body>
<!-- Add BlogDetail Form Start -->
<div class="container-fluid pt-4 px-4">
    <div class="bg-light rounded p-4">
        <h6 class="mb-4">Add New Blog Detail</h6>
        <form:form method="post" action="${pageContext.request.contextPath}/blogdetails/add" enctype="multipart/form-data" modelAttribute="blogDetail">
            <div class="mb-3">
                <label for="title" class="form-label">Title</label>
                <form:input path="title" id="title" class="form-control" required="true"/>
            </div>
            <div class="mb-3">
                <label for="content" class="form-label">Content</label>
                <form:textarea path="content" id="content" class="form-control" required="true"/>
            </div>
            <div class="mb-3">
                <label for="description" class="form-label">Description</label>
                <form:textarea path="description" id="description" class="form-control" required="true"/>
            </div>
<%--            <div class="mb-3">--%>
<%--                <label for="blogImg" class="form-label">Image</label>--%>
<%--                <input type="file" id="blogImg" name="blogImg" class="form-control-file" required="true"/>--%>
<%--            </div>--%>

                <div class="mb-3">
                        <form:input id="fileInput" type="text" style="display: none;" path="blogImg"/>
                        <input accept="image/*" type='file' id="imgInp"  class="form-control" />
                    </div>


            <div class="mb-3">
                <label for="blogId" class="form-label">Blog Type</label>
                <form:select path="blogId" id="blogId" class="form-control" required="true">
                    <form:options items="${blogTypes}" itemValue="id" itemLabel="id"/>
                </form:select>
            </div>
            <div class="mb-3">
                <label for="customerId" class="form-label">Customer</label>
                <form:select path="customerId" id="customerId" class="form-control" required="true">
                    <form:options items="${customers}" itemValue="id" itemLabel="id"/>
                </form:select>
            </div>
            <button type="submit" class="btn btn-primary">Add Blog Detail</button>
        </form:form>
    </div>
</div>
<script>
    imgInp.onchange = evt => {
        const [file] = imgInp.files
        if (file) {
            blah.src = URL.createObjectURL(file)
        }
    }
    document.getElementById('imgInp').addEventListener('change', function() {
        document.getElementById('fileInput').value = this.files[0].name;
    });
</script>
<!-- Add BlogDetail Form End -->
</body>
</html>
