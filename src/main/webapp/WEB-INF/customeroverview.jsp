<%@ page import="FunctionLayer.LogicFacade" %>
<!-- Header & imports -->
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

<!-- Container -->
<div class="container">
    <!-- Row -->
    <div class="row bg-light justify-content-center pt-5 shadow-lg p-3 mb-5 bg-white rounded">
        <!-- Column -->
        <div class="col">

            <!-- knap til at gå til ordrelinjer  -->
            <form name="customeroverview" action="FrontController" method="GET" class="form-signin">
                <h1 class="h3 mb-3 font-weight-normal align text-center">Vis order på en kunde</h1>
                <label for="inputID" class="sr-only">Oversigt over kunde ordre</label>
                <input name="id" type="number" id="inputID" class="form-control mb-3" placeholder="Kunde id" required
                       autofocus>
                <input type="hidden" name="target" value="customeroverview">
                <button class="btn btn-sm btn-primary btn-block" type="submit">Vis ordre</button>
            </form>

            <div class="container">
            <!-- Show all orders to a specific customer -->
            <c:forEach var="show" items="${showorders}">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col">Dato:</th>
                        <th scope="col">Order id:</th>
                        <th scope="col">Kunde id:</th>
                        <th scope="col">Fornavn:</th>
                        <th scope="col">Efternavn:</th>
                        <th scope="col">Email:</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>${show.order_date}</td>
                        <td>${show.order_id}</td>
                        <td>${show.users_id}</td>
                        <td>${show.firstName}</td>
                        <td>${show.lastName}</td>
                        <td>${show.email}</td>
                    </tr>
                    </tbody>
                </table>
            </c:forEach>
                <!-- End table -->
            </div>

            <!-- End column -->
        </div>
        <!-- End row -->
    </div>
    <!-- End container -->
</div>

<!-- Footer -->
<%@include file="../includes/footer.inc" %>