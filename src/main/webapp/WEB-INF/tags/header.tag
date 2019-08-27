<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String ctxPath = request.getContextPath(); %>
<%@attribute name="headerData" required="true" type="com.project.project.web.dto.HeaderDTOBuilder.HeaderDTO" %>
<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Shoopy</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">


                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Categories <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <c:forEach items="${headerData.categories}" var="category">
                            <li><a href="/category/${category.id}">${category.name}</a></li>
                        </c:forEach>

                    </ul>
                </li>
                <c:choose>
                    <c:when test="${sessionScope.auth == null}">
                        <li>
                            <a href="/register">Register</a>
                        </li>
                        <li>
                            <a href="/login">Login</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li>
                            <a href="/logout">Logout</a>
                        </li>
                    </c:otherwise>
                </c:choose>

            </ul>
            <div class="nav navbar-nav navbar-right">
                <table class="navbar-brand">
                    <tr>
                        <td rowspan="2"><a class="glyphicon glyphicon-shopping-cart" href="/cart/read"></a></td>
                        <td>Items</td>
                        <td>Total</td>
                    </tr>
                    <tr>
                        <td id="count">${headerData.count}</td>
                        <td id="total">${headerData.totalPrice} c</td>
                    </tr>
                </table>
            </div>
        </div>
        <!-- /.navbar-collapse -->

    </div>
    <!-- /.container -->
</nav>