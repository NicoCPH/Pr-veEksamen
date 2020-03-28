<%--
  Created by IntelliJ IDEA.
  User: jplm
  Date: 12-03-2020
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<!-- Header & imports -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/headerlogout.inc"%>

<!-- Container -->
<div class="container">
    <!-- Row -->
    <div class="row bg-light justify-content-center pt-5 shadow-lg p-3 mb-5 bg-white rounded">
        <!-- Column -->
        <div class="col">

            <!-- Total price and totalt price - valid credit -->
            <c:set var="total" value="${0}"/>
            <c:forEach var="priser" items="${sessionScope.neworder}">
                <c:set var="total" value="${total + priser.total_price}" />
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col">Topping navn: </th>
                        <th scope="col">Bottom navn: </th>
                        <th scope="col">Antal: </th>
                        <th scope="col">Antal: </th>

                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>${priser.topping_name}</td>
                        <td>${priser.bottom_name}</td>
                        <td>${priser.quantity}</td>
                        <td>${priser.total_price}</td>
                    </tr>

            </c:forEach>
            <c:set var="credit-total" scope="session" value="${sessionScope.credit-total}"/>
            <tr>
                <th><b>Kredit før køb:</b></th>
                <th><b>Kredit efter køb:</b></th>
                <th> - </th>
                <th><b>Samlet pris:</b></th>
            </tr>
                    <tr>
            <td>${sessionScope.credit}</td>
            <td>${credit-total}</td>
                        <td> - </td>
                        <td>${total} kr</td>
                    </tr>
                    </tbody>
                </table>
            <!-- End all orders -->

            <div class="row">
                <!-- Keep shopping -->
                <a class="btn btn-sm btn-primary mt-5" href="FrontController?target=redirect&destination=customerpage" role="button">Tilbage til indkøb</a>
            <!-- Receipt -->
            <form name="receipt" action="FrontController" method="POST">
                <input type="hidden" name="target" value="receipt">
                <input class="btn btn-sm btn-primary mt-5 mx-3" type="submit" value="Kvittering">
            </form>

            <!-- End column -->
            </div>

            <!-- End column -->
        </div>
        <!-- End row -->
    </div>
    <!-- End container -->
</div>


<!-- Footer -->
<%@include file="../includes/footer.inc"%>
