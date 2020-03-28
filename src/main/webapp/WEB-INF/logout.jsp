<!-- Header & imports -->
<%@ page import="FunctionLayer.LoginSampleException" %>
<%@ page import="FunctionLayer.LogicFacade" %>
<%@ page import="DBAccess.CupcakeInitializer" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.inc" %>

<!-- Initializing -->
<%!
    @Override
    public void jspInit() {
        try {
            LogicFacade.orders();
            LogicFacade.user();
            CupcakeInitializer.initBottoms();
            CupcakeInitializer.initToppings();
        } catch (LoginSampleException e) {
            e.printStackTrace();
        }
    }
%>
<!-- End initializing -->


<%
    /*
    if(request.getServletContext().getAttribute("bottomList") == null) {
        request.getServletContext().setAttribute("bottomList", Initialize.METODEKALD);
    }
    */
%>


<!-- Container -->
<div class="container">
    <!-- Row -->
    <div class="row bg-light justify-content-center pt-5 shadow-lg p-3 mb-5 bg-white rounded">
        <!-- Column -->
        <div class="col">

            <!-- Carousel -->
            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img class="d-block w-100" src="images/cupcake.jpg" alt="First slide">
                    </div>

                    <div class="carousel-item">
                        <img class="d-block w-100" src="images/cupcake.jpg" alt="Second slide">
                    </div>

                    <div class="carousel-item">
                        <img class="d-block w-100" src="images/cupcake.jpg" alt="Third slide">
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>

            </div>
            <!-- End carousel -->


            <!-- Error message -->
            <c:if test="${requestScope.error!= null}">

                <h2>Error ! </h2>
                ${requestScope.error}

            </c:if>
            <!-- End error message -->


            <!-- End column -->
        </div>
        <!-- End row -->
    </div>
    <!-- End container -->
</div>

<!-- Footer -->
<%@include file="../includes/footer.inc" %>