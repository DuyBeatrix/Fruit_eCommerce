<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/22/2024
  Time: 10:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<title>Đăng ký</title>

<body>
<section class="vh-100" style="background-color: #f0f2f5;">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col col-xl-10">
                <div class="card"
                     style="border-radius: 1rem;box-shadow: 0 2px 4px rgba(0, 0, 0, .1), 0 8px 16px rgba(0, 0, 0, .1);">
                    <div class="row g-0">
                        <div class="col-md-6 col-lg-5 d-none d-md-block ">
                            <img src="<c:url value="/resource/user/img/img-login.png"/>"
                                 alt="login form" class="img-fluid h-100" style="border-radius: 1rem 0 0 1rem;"/>
                        </div>
                        <div class="col-md-6 col-lg-7 d-flex align-items-center">
                            <div class="card-body p-4 p-lg-5 text-black">


                                <%--@elvariable id="user" type=""--%>
                                <form:form action="sendEmail" method="post" modelAttribute="user" id="registerForm"  >

                                    <div class="d-flex align-items-center mb-3 pb-1">
                                        <span class="h1 fw-bold mb-0 text-primary">Fruitables</span>
                                    </div>

                                    <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Create an account to log in</h5>
                                    <p class="text-danger mt-2">${requestScope.message}</p>
                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="form2Example17">Email</label>
                                        <form:input type="email" id="form2Example17" class="form-control form-control-lg" path="cusEmail" required="true"/>

                                    </div>
                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="username">Username</label>
                                        <form:input type="text" id="username" class="form-control form-control-lg" path="userName" required="true"/>

                                    </div>

                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="password">Password</label>
                                        <form:input type="password" id="password"
                                               class="form-control form-control-lg" path="password" required="true"/>

                                    </div>
                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="rePassword">Enter the password again</label>
                                        <input type="password" id="rePassword"
                                               class="form-control form-control-lg" name="rePassword" required/>
                                    </div>

                                    <div class="pt-1 mb-4">
                                        <button class="btn btn-primary btn-lg btn-block w-100 text-white" type="submit">
                                            Register
                                        </button>
                                    </div>
                                    <p class="mb-5 pb-lg-2">Do you already have an account? <a href="<c:url value="/login"/> "  style="color: #7fad39;"> Login</a></p>

                                </form:form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


</body>
