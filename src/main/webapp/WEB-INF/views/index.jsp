<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>OnTheGo Website</title>

    <!-- Bootstrap Core CSS -->
    <link href="resources.webjars.bootstrap.3.3.6/css/bootstrap.css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/css/style.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

<tag:header headerData="${headerDTO}"/>

<!-- Page Content -->
<div class="container">

    <div class="jumbotron">
        <h1>Welcome to our shop</h1>
        <p>Welcome to our new online shop! Thanks for coming along to check out our new website.
            We hope that you'll be able to find all the things here that you like so much in the shop,
            but now be able to order them when getting to us is proving a bit of a challenge.
        </p>
    </div>


    <hr>
    <tag:footer/>

</div>
<!-- /.container -->

<!-- jQuery -->
<script src="resources.webjars.jsquery.2.2.4/jquery.js/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="resources.webjars.bootstrap.3.3.6/js/bootstrap.js/bootstrap.min.js"></script>


</body>

</html>
