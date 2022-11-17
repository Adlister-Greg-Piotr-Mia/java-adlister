<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>

    <c:choose>
        <c:when test="${sessionScope.user != null}">
            <jsp:include page="/WEB-INF/partials/loggedInNavbar.jsp" />
        </c:when>
        <c:when test="${sessionScope.user == null}">
            <jsp:include page="/WEB-INF/partials/loggedOutNavbar.jsp" />
        </c:when>
    </c:choose>

    <div class="container">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
        <h2>Your Ads</h2>
        <c:forEach var="ad" items="${ads}">
            <div class="col-md-6">
                <h2><a href="/ads/info?id=${ad.id}">${ad.title}</a></h2>
                <p>${ad.description}</p>
                <%--Delete Ad Form--%>
                <form action="/delete" method="post">
                    <input type="hidden" name="ad_id" value="${ad.id}">
                    <input class="btn btn-primary btn-sm" type="submit" value="Delete">
                </form>
                <%--Update Ad Btn--%>
                <form action="/edit" method="get">
                    <input type="hidden" name="ad_id" value="${ad.id}">
                    <input class="btn btn-primary btn-sm" type="submit" value="Edit">
                </form>
            </div>
        </c:forEach>


    </div>

</body>
</html>
