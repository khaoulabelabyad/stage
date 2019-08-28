<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String ctxPath = request.getContextPath(); %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Ecommerce Website</title>

    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"/>

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
    <h3>Shopping cart</h3>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Product name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Subtotal</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${cartEntries}" var="cartEntry">
            <tr>
                <td>${cartEntry.article.name}</td>
                <td>${cartEntry.article.price} c</td>
                <td>${cartEntry.quantity}</td>
                <td>${cartEntry.article.price} c</td>
                <td><a class="glyphicon glyphicon-trash delete-entry" href="/cart/remove/${cartEntry.article.id}"></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="row">
        <div class="col-md-9"></div>
        <div class="col-md-3">
            <c:choose>
                <c:when test="${headerDTO.count > 0 }">
                    <h4>Grand Total : ${headerDTO.totalPrice} c</h4>
                </c:when>
                <c:otherwise>
                    <h4>Your cart is empty!</h4>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    <div class="row">
        <div class="col-md-9"></div>
        <div class="col-md-3">
            <c:choose>
                <c:when test="${headerDTO.count  > 0}">
                    <form action="/order/confirm" class="inline-form">
                        <button type="submit" class="btn btn-success">Confirm order</button>
                    </form>
                    <form action="/cart/clear" class="inline-form">
                        <button type="submit" class="btn btn-warning">Clear cart</button>
                    </form>
                </c:when>
                <c:otherwise>
                    <a class="btn btn-primary" href="/">Continue shopping</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>

    <hr>
    <tag:footer/>

</div>
<!-- /.container -->

<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

<script type="text/javascript" src="<%= ctxPath %>/js/cart.js"></script>
<script type="text/javascript">
    $('a.delete-entry').on('click', function(e){
        $(this).parent().parent().remove();
    });
</script>
</body>

</html>

