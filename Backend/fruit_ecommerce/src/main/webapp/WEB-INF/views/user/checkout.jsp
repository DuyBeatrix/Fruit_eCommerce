<%--
  Created by IntelliJ IDEA.
  User: FPT
  Date: 5/4/2024
  Time: 1:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body>
<!-- Single Page Header start -->
<div class="container-fluid page-header py-5">
    <h1 class="text-center text-white display-6">Checkout</h1>
    <ol class="breadcrumb justify-content-center mb-0">
        <li class="breadcrumb-item"><a href="#">Home</a></li>
        <li class="breadcrumb-item"><a href="#">Pages</a></li>
        <li class="breadcrumb-item active text-white">Checkout</li>
    </ol>
</div>
<!-- Single Page Header End -->


<!-- Checkout Page Start -->
<div class="container-fluid py-5">
    <div class="container py-5">
        <h1 class="mb-4">Billing details</h1>
        <form action="#">
            <div class="row g-5">
                <div class="col-md-12 col-lg-6 col-xl-6">
                    <div class="form-item">
                        <label class="form-label my-3"><b>Full Name </b><sup>*</sup></label>
                        <input type="text" class="form-control">
                    </div>
                    <div class="form-item">
                        <label class="form-label my-3"><b>Address</b> <sup>*</sup></label>
                        <input type="text" class="form-control" placeholder="House Number Street Name">
                    </div>
                    <div class="form-item">
                        <label class="form-label my-3"><b>Phone number</b> <sup>*</sup></label>
                        <input type="tel" class="form-control">
                    </div>
                    <div class="form-item">
                        <label class="form-label my-3"><b>Email Address</b> <sup>*</sup></label>
                        <input type="email" class="form-control">
                    </div>
                    <div class="form-check my-3">
                        <input type="checkbox" class="form-check-input" id="Account-1" name="Accounts" value="Accounts">
                        <label class="form-check-label" for="Account-1">Create an account?</label>
                    </div>
                    <hr>
                    <div class="form-check my-3">
                        <input class="form-check-input" type="checkbox" id="Address-1" name="Address" value="Address">
                        <label class="form-check-label" for="Address-1">Ship to a different address?</label>
                    </div>
                    <div class="form-item">
                        <textarea name="text" class="form-control" spellcheck="false" cols="30" rows="11" placeholder="Oreder Notes (Optional)"></textarea>
                    </div>
                </div>
                <div class="col-md-12 col-lg-6 col-xl-6">
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                            <tr>
                                <th scope="col">Products</th>
                                <th scope="col">Name</th>
                                <th scope="col">Price</th>
                                <th scope="col">Quantity</th>
                                <th scope="col">Total</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <th scope="row">
                                    <div class="d-flex align-items-center mt-2">
                                        <img src="img/vegetable-item-2.jpg" class="img-fluid rounded-circle" style="width: 90px; height: 90px;" alt="">
                                    </div>
                                </th>
                                <td class="py-5">Awesome Brocoli</td>
                                <td class="py-5">10000 VND</td>
                                <td class="py-5">2</td>
                                <td class="py-5">$138.00</td>
                            </tr>
                            <tr>
                                <th scope="row">
                                    <div class="d-flex align-items-center mt-2">
                                        <img src="img/vegetable-item-5.jpg" class="img-fluid rounded-circle" style="width: 90px; height: 90px;" alt="">
                                    </div>
                                </th>
                                <td class="py-5">Potatoes</td>
                                <td class="py-5">$69.00</td>
                                <td class="py-5">2</td>
                                <td class="py-5">$138.00</td>
                            </tr>
                            <tr>
                                <th scope="row">
                                    <div class="d-flex align-items-center mt-2">
                                        <img src="img/vegetable-item-3.png" class="img-fluid rounded-circle" style="width: 90px; height: 90px;" alt="">
                                    </div>
                                </th>
                                <td class="py-5">Big Banana</td>
                                <td class="py-5">$69.00</td>
                                <td class="py-5">2</td>
                                <td class="py-5">$138.00</td>
                            </tr>
                            <tr>
                                <th scope="row">
                                </th>
                                <td class="py-3"></td>
                                <td class="py-3"></td>
                                <td class="py-3">
                                    <p class="mb-0 text-dark py-3"><b>Subtotal</b></p>
                                </td>
                                <td class="py-3">
                                    <div class="py-3">
                                        <p class="mb-0 text-dark">$414.00</p>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <th scope="row">
                                </th>
                                <td class="py-3">
                                    <p class="mb-0 text-dark py-4">Shipping</p>
                                </td>
                                <td colspan="3" class="py-3">
                                    <div class="form-check text-start">
                                        <input type="checkbox" class="form-check-input bg-primary border-0" id="Shipping-1" name="Shipping-1" value="Shipping">
                                        <label class="form-check-label" for="Shipping-1">Free Shipping</label>
                                    </div>
                                    <div class="form-check text-start">
                                        <input type="checkbox" class="form-check-input bg-primary border-0" id="Shipping-2" name="Shipping-1" value="Shipping">
                                        <label class="form-check-label" for="Shipping-2">Flat rate: $15.00</label>
                                    </div>
                                    <div class="form-check text-start">
                                        <input type="checkbox" class="form-check-input bg-primary border-0" id="Shipping-3" name="Shipping-1" value="Shipping">
                                        <label class="form-check-label" for="Shipping-3">Local Pickup: $8.00</label>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <th scope="row">
                                </th>
                                <td class="py-3">
                                    <p class="mb-0 text-dark text-uppercase py-3"><b>TOTAL</b></p>
                                </td>
                                <td class="py-3"></td>
                                <td class="py-3"></td>
                                <td class="py-3">
                                    <div class="py-3">
                                        <p class="mb-0 text-dark"><b>$135.00</b></p>
                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="row g-4 text-center align-items-center justify-content-center border-bottom py-3">
                        <div class="col-12">
                            <div class="form-check text-start my-3">
                                <input type="checkbox" class="form-check-input bg-primary border-0" id="Payments-1" name="Payments" value="Payments">
                                <label class="form-check-label" for="Payments-1">Check Payments</label>
                            </div>
                        </div>
                    </div>
                    <div class="row g-4 text-center align-items-center justify-content-center border-bottom py-3">
                        <div class="col-12">
                            <div class="form-check text-start my-3">
                                <input type="checkbox" class="form-check-input bg-primary border-0" id="Delivery-1" name="Delivery" value="Delivery">
                                <label class="form-check-label" for="Delivery-1">Cash On Delivery</label>
                            </div>
                        </div>
                    </div>
                    <div class="row g-4 text-center align-items-center justify-content-center pt-4">
                        <button type="button" class="btn border-secondary py-3 px-4 text-uppercase w-100 text-primary">Place Order</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
<!-- Checkout Page End -->
</body>