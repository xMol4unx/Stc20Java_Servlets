<%@tag description="Main layout" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@attribute name="header" fragment="true" required="false" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
    <jsp:invoke fragment="header"/>
    <a href="${pageContext.request.contextPath}/logout" style="position: absolute; right: 25px; top: 10px;">
        Logout
    </a>
    <jsp:doBody/>
</div>
</body>
</html>