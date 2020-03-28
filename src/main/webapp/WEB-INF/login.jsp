<%--
  Created by IntelliJ IDEA.
  User: jplm
  Date: 12-03-2020
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<!-- Header & imports -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.inc" %>

<!-- Container -->
<div class="container">
    <!-- Row -->
    <div class="row bg-light justify-content-center pt-5 shadow-lg p-3 mb-5 bg-white rounded">
        <!-- Column -->
        <div class="col">

            <!-- Admin / bruger login -->
            <form name="login" action="FrontController" method="GET" class="form-signin">
                <h1 class="h3 mb-3 font-weight-normal align text-center">Log ind</h1>
                <label for="inputEmail" class="sr-only">Email address</label>
                <input name="email" value="jp@cph.dk" type="email" id="inputEmail" class="form-control mb-2"
                       placeholder="Email adresse" required autofocus>
                <label for="inputPassword" class="sr-only">Kodeord</label>
                <input name="password" value="1234" type="password" id="inputPassword" class="form-control"
                       placeholder="Password" required>
                <div class="checkbox mb-2">
                    <label>
                        <a href="FrontController?target=redirect&destination=register">Registrer dig</a>
                    </label>
                </div>
                <input type="hidden" name="target" value="login">
                <input type="hidden" name="firstname" value="login">
                <button class="btn btn-sm btn-primary btn-block" type="submit">Log in</button>
            </form>
            <!-- End login -->


            <!-- End column -->
        </div>
        <!-- End row -->
    </div>
    <!-- End container -->
</div>


<!-- Footer -->
<%@include file="../includes/footer.inc" %>
