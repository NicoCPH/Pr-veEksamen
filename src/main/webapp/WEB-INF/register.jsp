<%--
  Created by IntelliJ IDEA.
  User: jplm
  Date: 21-03-2020
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<!-- Header -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.inc" %>

<!-- Registre bruger -->

<!-- Container -->
<div class="container">
    <!-- Row -->
    <div class="row bg-light justify-content-center pt-5 shadow-lg p-3 mb-5 bg-white rounded">
        <!-- Column -->
        <div class="col">

            <!-- Admin / bruger login -->
            <form name="registre" action="FrontController" method="POST" class="form-signin">
                <h1 class="h3 mb-3 font-weight-normal align text-center">Opret bruger</h1>

                <label for="inputEmail" class="sr-only">Email address</label>
                <input name="email" value="jp@cph.dk" type="email" id="inputEmail" class="form-control mb-3"
                       placeholder="Email adresse" required autofocus>

                <label for="inputFirstName" class="sr-only">Fornavn</label>
                <input name="firstname" value="Fornavn" type="text" id="inputFirstName" class="form-control mb-3"
                       placeholder="Fornavn" required>

                <label for="inputLastName" class="sr-only">Efternavn</label>
                <input name="lastname" value="Efternavn" type="text" id="inputLastName" class="form-control mb-3"
                       placeholder="Efternavn" required>

                <label for="inputPassword1" class="sr-only">Kodeord 1</label>
                <input name="password1" value="1234" type="password" id="inputPassword1" class="form-control mb-3"
                       placeholder="Password1" required>

                <label for="inputPassword2" class="sr-only">Kodeord 2</label>
                <input name="password2" value="1234" type="password" id="inputPassword2" class="form-control mb-3"
                       placeholder="Password2" required>

                <input type="hidden" name="target" value="register">
                <button class="btn btn-sm bg-primary btn-primary btn-block text-center" type="submit">Opret</button>
            </form>


            <!-- End column -->
        </div>
        <!-- End row -->
    </div>
    <!-- End container -->
</div>


<!-- Footer -->
<%@include file="../includes/footer.inc" %>
