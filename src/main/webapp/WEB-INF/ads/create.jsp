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
        <h1>Create a new Ad</h1>

        <p style="color: red">
            <c:out value="${error}"></c:out>
        </p>

        <form action="/ads/create" method="post">
            <div class="form-group">
                <label for="title">Title</label>
                <input id="title" name="title" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <textarea id="description" name="description" class="form-control" type="text"></textarea>
            </div>
            <div class="form-group">
                <c:forEach var="category" items="${categories}">
                    <input name="category" type="checkbox" class="btn-check" id="${category.id}" value="${category.id}" autocomplete="off">
                    <label for="${category.id}">${category.category}</label>
                </c:forEach>
            </div>
            <input type="submit" class="btn btn-block btn-primary">
        </form>
    </div>
</body>
</html>
