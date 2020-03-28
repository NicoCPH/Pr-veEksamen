<!-- Header & imports -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/headerlogout.inc" %>

<!-- Container -->
<div class="container">
    <!-- Row -->
    <div class="row bg-light justify-content-center pt-3 shadow-lg p-3 mb-5 bg-white rounded">
        <!-- Column -->
        <div class="col">


            <!-- Overview button -->
            <a class="btn btn-sm btn-primary mr-5 mb-4" href="FrontController?target=redirect&destination=overview">Kunde/Ordre Oversigt</a>

            <!-- Specific overview -->
            <a class="btn btn-sm btn-primary ml-1 mb-4" href="FrontController?target=redirect&destination=customeroverview">Specifik Kunde/Ordre Oversigt</a>

            <!-- Forms container -->
            <div class="row">

                        <!-- Register user -->
                        <form name="registeruser" action="FrontController" method="POST" class="col">

                            <label for="inputEmail" class="sr-only">Email address</label>
                            <input name="email" value="admin@cph.dk" type="email" id="inputEmail"
                                   class="form-control mb-3" placeholder="Email adresse" required autofocus>

                            <label for="inputFirstName" class="sr-only">Fornavn</label>
                            <input name="firstname" value="Fornavn" type="text" id="inputFirstName"
                                   class="form-control mb-3" placeholder="Fornavn" required>

                            <label for="inputLastName" class="sr-only">Efternavn</label>
                            <input name="lastname" value="Efternavn" type="text" id="inputLastName"
                                   class="form-control mb-3" placeholder="Efternavn" required>

                            <label for="inputPassword1" class="sr-only">Kodeord 1</label>
                            <input name="password1" value="1234" type="password" id="inputPassword1"
                                   class="form-control mb-3" placeholder="Password1" required>

                            <label for="inputPassword2" class="sr-only">Kodeord 2</label>
                            <input name="password2" value="1234" type="password" id="inputPassword2"
                                   class="form-control mb-3" placeholder="Password2" required>

                            <input type="hidden" name="target" value="registeruser">
                            <button class="btn btn-sm bg-primary btn-primary btn-block" type="submit">Opret bruger</button>
                        </form>
                        <!-- End register user -->


                        <!-- Create admin -->
                        <form name="registeradmin" action="FrontController" method="POST" class="col">

                            <label for="inputEmailAdmin" class="sr-only">Email address</label>
                            <input name="email" value="admin@cph.dk" type="email" id="inputEmailAdmin"
                                   class="form-control mb-3" placeholder="Email adresse" required autofocus>

                            <label for="inputFirstNameAdmin" class="sr-only">Fornavn</label>
                            <input name="firstname" value="Fornavn" type="text" id="inputFirstNameAdmin"
                                   class="form-control mb-3" placeholder="Fornavn" required>

                            <label for="inputLastNameAdmin" class="sr-only">Efternavn</label>
                            <input name="lastname" value="Efternavn" type="text" id="inputLastNameAdmin"
                                   class="form-control mb-3" placeholder="Efternavn" required>

                            <label for="inputPassword1Admin" class="sr-only">Kodeord 1</label>
                            <input name="password1" value="1234" type="password" id="inputPassword1Admin"
                                   class="form-control mb-3" placeholder="Password1" required>

                            <label for="inputPassword2Admin" class="sr-only">Kodeord 2</label>
                            <input name="password2" value="1234" type="password" id="inputPassword2Admin"
                                   class="form-control mb-3" placeholder="Password2" required>

                            <input type="hidden" name="target" value="registeradmin">
                            <button class="btn btn-sm bg-primary btn-primary btn-block" type="submit">Opret medarbejder</button>
                        </form>
                        <!-- End create admin -->


                        <!-- Edit user password-->
                        <form name="editpass" action="FrontController" method="POST" class="col">

                            <label for="inputEmailEditUserPassEmail" class="sr-only">Email address</label>
                            <input name="uemail" value="admin@cph.dk" type="email" id="inputEmailEditUserPassEmail"
                                   class="form-control mb-3" placeholder="Email" required autofocus>

                            <label for="inputEmailEditUserPass1" class="sr-only">Kodeord 1</label>
                            <input name="password1" value="1234" type="password" id="inputEmailEditUserPass1"
                                   class="form-control mb-3" placeholder="Password1" required>

                            <label for="inputEmailEditUserPass2" class="sr-only">Kodeord 2</label>
                            <input name="password2" value="1234" type="password" id="inputEmailEditUserPass2"
                                   class="form-control mb-3" placeholder="Password2" required>

                            <input type="hidden" name="target" value="editpass">

                            <button class="btn btn-sm bg-primary btn-primary btn-block" type="submit">Rediger Kodeord</button>
                        </form>
                        <!-- End edit user password -->

                        <!-- Edit user credit -->
                        <form name="editcredit" action="FrontController" method="POST" class="col">

                            <label for="inputEmailEditUser" class="sr-only">Email address</label>

                            <input name="email" value="admin@cph.dk" type="email" id="inputEmailEditUser"
                                   class="form-control mb-3" placeholder="Email" required autofocus>

                            <label for="inputCredit" class="sr-only">Kredit</label>
                            <input name="credit" type="credit" id="inputCredit" class="form-control mb-3"
                                   placeholder="0" required>

                            <input type="hidden" name="target" value="editcredit">
                            <button class="btn btn-sm bg-primary btn-primary btn-block" type="submit">Tilføj kredit</button>
                        </form>
                        <!-- End user credit -->

                        <!-- Delete user -->
                        <form name="deleteuser" action="FrontController" method="POST" class="col">

                            <label for="inputEmailEditUser" class="sr-only">Email address</label>
                            <input name="demail" value="admin@cph.dk" type="email" id="inputEmailEDeleteUser"
                                   class="form-control mb-3" placeholder="Email" required autofocus>

                            <input type="hidden" name="target" value="deleteuser">
                            <button class="btn btn-sm bg-primary btn-primary btn-block" type="submit">Slet bruger</button>
                        </form>
                        <!-- End delete user -->


            </div>
            <!-- End forms container -->

            <!-- End column -->
        </div>
        <!-- End row -->
    </div>
    <!-- End container -->
</div>


<!-- Footer -->
<%@include file="../includes/footer.inc" %>
