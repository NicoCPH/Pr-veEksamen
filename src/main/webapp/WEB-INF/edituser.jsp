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

            <!-- Edit user -->
            <form name="edituser" action="FrontController" method="POST" class="form-signin">
                <h1 class="h3 mb-3 font-weight-normal align">Rediger din kode</h1>

                <label for="inputEmailEditUser" class="sr-only">Email address</label>
                <input name="email" value="kunde@cph.dk" type="email" id="inputEmailEditUser" class="form-control mb-3"
                       placeholder="Email adresse" required autofocus>

                <label for="inputPassword1EditUser" class="sr-only">Kodeord 1</label>
                <input name="password1" value="1234" type="password" id="inputPassword1EditUser"
                       class="form-control mb-3" placeholder="Password1" required>

                <label for="inputPassword2EditUser" class="sr-only">Kodeord 2</label>
                <input name="password2" value="1234" type="password" id="inputPassword2EditUser"
                       class="form-control mb-3" placeholder="Password2" required>

                <input type="hidden" name="target" value="edituser">
                <button class="btn btn-sm bg-primary btn-primary btn-block text-center" type="submit">Opdater</button>
            </form>
            <!-- End edit user -->

            <!-- End column -->
        </div>
        <!-- End row -->
    </div>
    <!-- End container -->
</div>

<!-- Footer -->
<%@include file="../includes/footer.inc" %>