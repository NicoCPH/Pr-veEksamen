<!DOCTYPE html>
<html>

<head>
    <!-- UTF8 -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Responsive -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <!-- External CSS -->
    <link rel="stylesheet" href="styles/styles.css" type="text/css">
    <!-- Google font -->
    <link href="https://fonts.googleapis.com/css?family=Gotu&display=swap" rel="stylesheet">
    <!-- header title -->
    <title>${requestScope.message}</title>
</head>
<body>
<header>
    <!-- Logo -->
<img class="logo img-fluid" src="images/cupcake.jpg">
    <!-- Navigation -->
    <div class="navi container">

        <nav class="navbar navbar-expand-lg navbar-light">
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="nav-item nav-link active" href="FrontController?target=redirect&destination=customerpage">Home <span class="sr-only">(current)</span></a>
                <a class="nav-item nav-link" href="FrontController?target=redirect&destination=logout">Logout</a>
                <a class="nav-item nav-link" href="FrontController?target=redirect&destination=edituser">Rediger bruger</a>
                <a class="nav-item nav-link" href="FrontController?target=redirect&destination=cart">Kurv
                    <img src="images/shopping-cart.png" alt="Shopping cart"></a>
            </div>
        </div>

            <!-- Display user -->
            <form class="form-inline">
                <div class="input-group">
                    <a class="nav-item nav-link text-secondary" href="FrontController?target=redirect&destination=adminpage">Admin</a>
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon1">@</span>
                    </div>
                    <input type="text" class="form-control" placeholder="${sessionScope.email}" aria-label="Username" aria-describedby="basic-addon1">
                </div>
            </form>
        </nav>

    </div>
</header>