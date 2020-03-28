<!-- Header & imports -->
<%@ page import="DBAccess.CupcakeInitializer" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/headerlogout.inc" %>


<!-- initializing -->
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

            <!-- Carousel -->
            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img class="rounded mx-auto d-block" src="images/cupcake1.png" alt="First slide">
                    </div>
                    <div class="carousel-item">
                        <img class="rounded mx-auto d-block" src="images/cupcake2.png" alt="Second slide">
                    </div>
                    <div class="carousel-item">
                        <img class="rounded mx-auto d-block" src="images/cupcake3.png" alt="Third slide">
                    </div>
                    <div class="carousel-item">
                        <img class="rounded mx-auto d-block" src="images/cupcake4.png" alt="Fourth slide">
                    </div>
                </div>
                <a class="carousel-control-prev bg-light" href="#carouselExampleIndicators" role="button"
                   data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next bg-light" href="#carouselExampleIndicators" role="button"
                   data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>

        </div>
        <div class="col">
            <!-- Select/dropdown menu -->
            <div class="form-group ">
                <form name="cart" action="FrontController" method="GET">
                    <label class="align-items-center" for="select1">Vælg bund:</label>
                    <select class="form-control" name="bottom" id="select1">
                        <c:forEach var="bottom" items="${bottoms}">
                            <option value="${bottom.value.bottom_id}">${bottom.value.name} ${bottom.value.price} kr
                            </option>
                        </c:forEach>
                    </select>
                    <label class="align-items-center mt-2" for="select1">Vælg top:</label>
                    <select class="form-control" name="topping" id="select2">
                        <c:forEach var="topping" items="${toppings}">
                            <option value="${topping.value.topping_id}">${topping.value.name} ${topping.value.price}
                                kr
                            </option>
                        </c:forEach>
                    </select>
                    <label class="align-items-center mt-2" for="select1">Vælg antal:</label>
                    <select class="form-control" type="number" name="quantity">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                        <option>6</option>
                        <option>7</option>
                        <option>8</option>
                        <option>9</option>
                        <option>10</option>
                    </select>
                    <input type="hidden" name="target" value="dropdown">
                    <!-- Add order to cart -->
                    <button class="btn btn-sm btn-primary mt-2 btn-block" type="submit">Tilføj til kurv</button>
                </form>
                <!-- End Select/dropdown menu -->
            </div>
            </div>
            <!-- End carousel -->

            <!-- End column -->
        </div>
        <!-- End row -->
    </div>
    <!-- End container -->
</div>

<!-- Footer -->
<%@include file="../includes/footer.inc" %>