<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<title>Product</title>
<head>
<%--    <style>--%>
<%--        .exprire-green {--%>
<%--            color: green;--%>
<%--        }--%>
<%--        .exprire-yellow {--%>
<%--            color: yellow;--%>
<%--        }--%>
<%--        .exprire-red {--%>
<%--            color: red;--%>
<%--        }--%>
<%--    </style>--%>
</head>
<body>
<div class="col-sm-12 col-xl-12">
    <div class="bg-light rounded h-100 p-4">
        <h6 class="mb-4">Product</h6>
        <a href="addproduct" class="btn btn-primary mb-2"><span>+</span> Add new product</a>
        <p class="text-danger">${msg}</p>

        <table class="table table-hover">

            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Tên sản phẩm</th>
                <th scope="col">Giá</th>
                <th scope="col">Số lượng bán</th>
                <th scope="col">Số lượng còn</th>
                <th scope="col" class="d-none">Ngày thêm</th>
                <th scope="col">Ngày hết hạn</th>
                <th scope="col">Giảm giá</th>
                <th scope="col">Danh mục sản phẩm</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="product" items="${paginationProduct}">
                <tr>
                    <th scope="row">${product.productId}</th>
                    <td>${product.productName}</td>
                    <td>${product.productPrice}</td>
                    <td>${product.sell_quantity}</td>
                    <td>${product.quantity}</td>
                    <td class="d-none">${product.createDate}</td>
                    <td class="fw-bold">${product.expDate}</td>
                    <td>${product.sale}</td>
                    <td>${product.cateName}</td>
                    <td>
                        <a href="updateProduct?productId=${product.productId}" class="me-4"><i class="fa-solid fa-arrows-rotate"></i></a>
                        <a href="#"><i class="fa-solid fa-trash-can" style="width: 24px; height: 24px" onclick="deleteProduct('${product.productId}')"></i></a>
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
                        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/product/${i}">${i}</a></li>
                    </c:forEach>
                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                            <span class="sr-only">Next</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
        <h2>Sales Chart</h2>
        <canvas id="myChart" style="width:100%;max-width:600px"></canvas>
    </div>
</div>
<script>
    const xValues = [100,200,300,400,500,600,700,800,900,1000];

    new Chart("myChart", {
        type: "line",
        data: {
            labels: xValues,
            datasets: [{
                data: [860,1140,1060,1060,1070,1110,1330,2210,7830,2478],
                borderColor: "red",
                fill: false
            }, {
                data: [1600,1700,1700,1900,2000,2700,4000,5000,6000,7000],
                borderColor: "green",
                fill: false
            }, {
                data: [300,700,2000,5000,6000,4000,2000,1000,200,100],
                borderColor: "blue",
                fill: false
            }]
        },
        options: {
            legend: {display: false}
        }
    });
</script>
<script>

    function deleteProduct(id) {
        let ans = confirm("Bạn có đồng ý xóa sản phẩm này?");
        if(ans){
            window.location = "delete/"+id;
        }
    }
    document.addEventListener("DOMContentLoaded", function () {

        let rows = document.querySelectorAll("tbody tr");
        rows.forEach(function (row) {
            let createDateStr = row.querySelector("td:nth-child(6)").textContent.trim();
            let expDateStr = row.querySelector("td:nth-child(7)").textContent.trim();

            let createDate = new Date(createDateStr);
            let expDate = new Date(expDateStr);
            console.log("createDate: ",createDate);
            console.log("expDateStr: ",expDate);
            let diffTime = expDate.getTime() - createDate.getTime();
            let diffDays = Math.ceil(diffTime/(1000*60*60*24))
            if(diffDays > 3){
                row.querySelector("td:nth-child(7)").classList.add("text-success")
            }
            else if(diffDays <= 3 && diffDays > 0){
                row.querySelector("td:nth-child(7)").classList.add("text-warning")
            } else {
                row.querySelector("td:nth-child(7)").classList.add("text-danger")
            }

        })
    })
</script>

</body>

