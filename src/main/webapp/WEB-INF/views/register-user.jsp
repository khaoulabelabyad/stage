<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String ctxPath = request.getContextPath(); %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <!-- Bootstrap Core CSS -->
    <link href="resources.webjars.bootstrap.3.3.6/css/bootstrap.css/bootstrap.min.css" rel="stylesheet">
    <title>Registration</title>
    <style>
        #register-form span {
            color: #a94442;
            background-color: #f2dede;
            border-color: #ebccd1;
        }
        .header-spacer{
            margin-top: 55px;
        }
    </style>
</head>
<body>
<tag:header headerData="${headerDTO}"/>
<div class="container header-spacer">
    <div class="page-header">
        <h3>Register
            <small>a customer</small>
        </h3>
    </div>

    <div class="row">
        <div class="col-lg-12">

            <form:form id="register-form" action="/register" method="post" modelAttribute="customerForm">

                <div class="form-group">
                    <label for="first">First name</label>
                    <form:input path="firstName" type="text" class="form-control" id="first" placeholder="First name"/>
                    <form:errors path="firstName"/>
                </div>
                <div class="form-group">
                    <label for="last">Last name</label>
                    <form:input type="text" class="form-control" id="last" path="lastName" placeholder="Last name"/>
                    <form:errors path="lastName"/>
                </div>
                <div class="form-group">
                    <label for="email">Email address</label>
                    <form:input type="text" class="form-control" id="email" path="email" placeholder="Email"/>
                    <form:errors path="email"/>
                </div>
                <div class="form-group">
                    <label for="login">Login</label>
                    <form:input type="text" class="form-control" id="login" path="login" placeholder="Login"/>
                    <form:errors path="login"/>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <form:input type="password" class="form-control" id="password" path="password"
                                placeholder="Password"/>
                    <form:errors path="password"/>
                </div>
                <button type="submit" class="btn btn-primary">Register Now</button>

            </form:form>
        </div>
    </div>
</div>
<!-- jQuery -->
<script src="resources.webjars.jsquery.2.2.4/jquery.js/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="resources.webjars.bootstrap.3.3.6/js/bootstrap.js/bootstrap.min.js"></script>
</body>
</html>