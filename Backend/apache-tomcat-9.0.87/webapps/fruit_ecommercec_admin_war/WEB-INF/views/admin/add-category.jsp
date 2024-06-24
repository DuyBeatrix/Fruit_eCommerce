<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<title>Thêm Danh mục</title>
<body>
<!-- Add Category Form Start -->
<div class="container-fluid pt-4 px-4">
    <div class="bg-light rounded p-4">
        <h6 class="mb-4">Thêm Danh Mục</h6>
        <form:form method="post" action="${pageContext.request.contextPath}/category/add" enctype="multipart/form-data" modelAttribute="category">
            <div class="mb-3">
                <label for="cateName" class="form-label">Tên danh mục</label>
                <form:input path="cateName" id="cateName" class="form-control" required="true"/>
            </div>
<%--            <div class="mb-3">--%>
<%--                <label for="cateImg" class="form-label">Category Image</label>--%>
<%--                <input type="file" id="cateImg" name="cateImg" class="form-control-file" required="true"/>--%>
<%--            </div>--%>
            <div class="mb-3">
                <form:input id="fileInput" type="text" style="display: none;" path="cateImg"/>
                <input accept="image/*" type='file' id="imgInp"  class="form-control" />
            </div>
            <div class="form-group mb-3">
                <label for="enable">Trạng thái</label>
                <form:select path="enable" id="enable" class="custom-select tm-select-accounts" required="true">
                    <option value="true">Bật</option>
                    <option value="false">Tắt</option>
                </form:select>
            </div>
            <a href="${pageContext.request.contextPath}/category/1" class="btn btn-secondary">Trở lại</a>
            <button type="submit" class="btn btn-primary">Thêm danh mục</button>
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
<!-- Add Category Form End -->
</body>
