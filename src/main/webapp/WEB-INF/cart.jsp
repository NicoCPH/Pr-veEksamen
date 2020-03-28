<%--
  Created by IntelliJ IDEA.
  User: jplm
  Date: 12-03-2020
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="DBAccess.CupcakeInitializer" %>
<%@include file="../includes/headerlogout.inc"%>

<!-- Initialize getters -->
<%
    request.setAttribute("bottoms", CupcakeInitializer.getBottomList());
    request.setAttribute("toppings", CupcakeInitializer.getToppingList());
%>

<!-- Container -->
<div class="container">
    <!-- Row -->
    <div class="row bg-light justify-content-center pt-5 shadow-lg p-3 mb-5 bg-white rounded">
        <!-- Column -->
        <div class="col">

            <div class="container">

            <!-- Hentet fra database Topping og Bottom -->
                <c:set var="count" value="${0}" scope="page"/>
                <c:set var="total" value="${0}"/>
                <c:forEach var="order" items="${sessionScope.neworder}">
                <c:set var="total" value="${total + order.total_price}" />
                <c:set var="count" value="${count + 1}" scope="page"/>
                <div class="container">
                    <form action="FrontController" method="post">
                        <input type="hidden" name="target" value="deleteorderline">
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Bund</th>
                                <th scope="col">Topping</th>
                                <th scope="col">Antal</th>
                                <th scope="col">Pris</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <th scope="row">${count}</th>
                                <td>${order.bottom_name}</td>
                                <td>${order.topping_name}</td>
                                <td>${order.quantity}</td>
                                <td>${order.total_price}</td>
                                <button name="delete" class="btn btn-sm bg-primary btn-primary" value="${order.id}" type="submit">Slet</button>
                            </tr>
                            <tr>
                                </c:forEach>
                                <th scope="row"><b>Samlet Pris: </b></th>
                            <td> - </td>
                            <td> - </td>
                            <td> - </td>
                            <td>${total}</td>
                    </tr>
                    </tbody>
                </table>
            </form>

                <div class="row mt-5">

<!-- knap til at gå til shopping  -->
<a class="btn btn-sm btn-primary mr-5" href="FrontController?target=redirect&destination=customerpage" role="button">Tilbage til indkøb</a>

<!-- knap til at gå til payment  -->
                    <form name="payment" action="FrontController" method="POST">
                        <input type="hidden" name="target" value="payment">
                        <input class="btn btn-sm btn-primary" type="submit" value="Betaling">
                    </form>

                </div>

            </div>
            </div>


            <!-- End column -->
        </div>
        <!-- End row -->
    </div>
    <!-- End container -->
</div>


<!-- Footer -->
<%@include file="../includes/footer.inc"%>