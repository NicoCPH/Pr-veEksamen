<%--
  Created by IntelliJ IDEA.
  User: jplm
  Date: 24-03-2020
  Time: 17:24
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

<!-- Alert container -->
<div class="alert alert-danger" role="alert">
<!-- Error message -->
<c:if test="${requestScope.error!= null}">

    <h2>Der opstod en fejl</h2>
    ${requestScope.error}

</c:if>
<!-- End error message -->
</div>
<!-- End alert container -->

<!-- End column -->
</div>
<!-- End row -->
</div>
<!-- End container -->
</div>

<!-- Footer -->
<%@include file="../includes/footer.inc" %>
