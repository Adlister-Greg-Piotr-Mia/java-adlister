<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
</head>

<c:choose>
    <c:when test="${sessionScope.user != null}">
        <jsp:include page="/WEB-INF/partials/loggedInNavbar.jsp" />
    </c:when>
    <c:when test="${sessionScope.user == null}">
        <jsp:include page="/WEB-INF/partials/loggedOutNavbar.jsp" />
    </c:when>
</c:choose>

<body>
<div class="container">
    <h1>Search for an ad</h1>

    <p style="color: blue">
        <c:out value="${error}"></c:out>
    </p>

    <form action="/ads/search" method="get">
        <div class="form-group">
            <label for="search">Search</label>
            <input id="search" name="search" class="form-control" type="text">
        </div>
        <div class="form-group">
            <select for="category">Category</select>
<%--            <option value="volvo">${categories}</option>--%>
<%--            <option value="volvo">${categories}</option>--%>
            <option value="volvo">${categories}</option>
        </div>
        <input type="submit" class="btn btn-block btn-primary">
    </form>
</div>
</body>
</html>
