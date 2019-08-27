<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String ctxPath = request.getContextPath(); %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<!DOCTYPE html>
<head>
    <link rel="stylesheet" href="/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/css/theme.css"/>
    <title>Login</title>
</head>
<body>

<tag:header headerData="${headerDTO}"/>

<div class="container header-spacer">
    <div class="page-header">
        <h3>Login
            <small>as customer</small>
        </h3>
    </div>
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-login">
                <div class="panel-body">
                    <c:if test="${not empty loginError}">
                        <div class="alert alert-danger">Wrong user or password</div>
                    </c:if>
                    <c:if test="${registration}">
                        <div class="alert alert-success">Registration successfully</div>
                    </c:if>
                    <div class="row">
                        <div class="col-lg-12">
                            <form id="login-form" action="/login" method="post" role="form"
                                  style="display: block;">
                                <div class="form-group">
                                    <input type="text" name="login" id="login" tabindex="1"
                                           class="form-control" placeholder="Your login" value=""/>
                                </div>
                                <div class="form-group">
                                    <input type="password" name="password" id="password"
                                           tabindex="2" class="form-control" placeholder="Your Password"/>
                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-sm-6 col-sm-offset-3">
                                            <input type="submit" name="login-submit" id="login-submit"
                                                   tabindex="4" class="form-control btn btn-login"
                                                   value="Log In"/>
                                        </div>
                                    </div>
                                </div>
                                <input type="hidden" name="referer" value="${Referer}">
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>