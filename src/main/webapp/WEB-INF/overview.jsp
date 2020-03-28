<!-- Header & imports -->
<%@ page import="FunctionLayer.LogicFacade" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../includes/headerlogout.inc" %>

<!-- String to Integer -->
<%
    try {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("showorders", LogicFacade.showOrders(id));
    } catch (NumberFormatException ne) {
        ne.getMessage();
    }
%>
<!-- Oversigt over alle ordre -->
<%
    request.setAttribute("ordersList", LogicFacade.orders());
%>
<!-- Oversigt over alle kunder -->
<%
    request.setAttribute("userList", LogicFacade.user());
%>


<!-- Container -->
<div class="container">
    <!-- Row -->
    <div class="row bg-light justify-content-center pt-5 shadow-lg p-3 mb-5 bg-white rounded">
        <!-- Column -->
        <div class="col">

            <!-- Delete order -->
            <form name="deleteorder" action="FrontController" method="POST" class="form-signin">
                <h1 class="h3 mb-3 font-weight-normal align text-center">Slet en ordre</h1>
                <label for="inputID" class="sr-only">Slet en ordre</label>
                <input name="id" type="number" id="inputID" class="form-control mb-3" placeholder="Ordre id" required
                       autofocus>
                <input type="hidden" name="target" value="deleteorder">
                <button class="btn btn-sm btn-primary btn-block" type="submit">Slet ordre</button>
            </form>
            <!-- End delete order -->

            <div class="container w-75">
                <h3 class="my-y 5 text-center">Alle brugere i systemet</h3>
                <!-- All users -->
                <c:forEach var="user" items="${userList}">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th scope="col">Kunde id:</th>
                            <th scope="col">Email:</th>
                            <th scope="col">Kodeord:</th>
                            <th scope="col">Rolle:</th>
                            <th scope="col">Fornavn:</th>
                            <th scope="col">Efternavn:</th>
                            <th scope="col">Kredit:</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th scope="row">${user.id}</th>
                            <td>${user.email}</td>
                            <td>${user.firstName}</td>
                            <td>${user.lastName}</td>
                            <td>${user.password}</td>
                            <td>${user.role}</td>
                            <td>${user.credit}</td>
                        </tr>
                        </tbody>
                    </table>
                </c:forEach>
                <!-- End all users -->
            </div>

            <div class="container w-75">
                <h3 class="my-y 5 text-center">Alle ordre i systemet</h3>
            <!-- All orders -->
            <c:forEach var="orders" items="${ordersList}">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col">Dato:</th>
                        <th scope="col">Order id:</th>
                        <th scope="col">Kunde id:</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>${orders.order_date}</td>
                        <td>${orders.order_id}</td>
                        <td>${orders.users_id}</td>
                    </tr>
                    </tbody>
                </table>
            </c:forEach>
            <!-- End all orders -->
            </div>


            <!-- End column -->
        </div>
        <!-- End row -->
    </div>
    <!-- End container -->
</div>

<!-- Footer -->
<%@include file="../includes/footer.inc" %>
