<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
        <h2>Your Ads</h2>
        <c:forEach var="ad" items="${ads}">
            <div class="col-md-6">
                <h2><a href="/ads/info?id=${ad.id}">${ad.title}</a></h2>
                <p>${ad.description}</p>
                <a href="#" class="btn btn-primary">Edit</a>
            </div>
        </c:forEach>


    </div>

</body>
</html>
