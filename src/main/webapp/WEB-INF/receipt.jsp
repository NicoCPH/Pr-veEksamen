<%--
  Created by IntelliJ IDEA.
  User: jplm
  Date: 12-03-2020
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<!-- Header & imports -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/headerlogout.inc" %>


<!-- Container -->
<div class="container">
    <!-- Row -->
    <div class="row bg-light justify-content-center pt-5 shadow-lg p-3 mb-5 bg-white rounded">
        <!-- Column -->
        <div class="col">

            <!-- Text & button container -->
            <div class="container justify-content-center">
                <!-- Dynamic text -->
                <h1>Kære ${sessionScope.firstname} ${sessionScope.user.lastName} </h1>
                <p>Tak for din bestilling. Vi sender en kvittering til: <b>${sessionScope.email}</b> </p>
                <p>Din nuværende balance er nu: <b>${sessionScope.totalcredit}</b></p>

                <!-- Keep shopping  -->
                <a class="btn btn-sm btn-primary" href="FrontController?target=redirect&destination=customerpage"
                   role="button">Tilbage
                    til indkøb</a>

            </div>
            <!-- End Text & button container -->

            <!-- End column -->
        </div>
        <!-- End row -->
    </div>
    <!-- End container -->
</div>


<!-- Footer -->
<%@include file="../includes/footer.inc" %>