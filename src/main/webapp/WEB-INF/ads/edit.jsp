<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Edit Ad" />
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
    <h1>Update Ad</h1>
    <p style="color: red">
        <c:out value="${error}"></c:out>
    </p>
    <form action="/edit" method="post">
        <input type="hidden" name="ad_id" value="${ad.id}">
        <input type="hidden" name="default_title" value="${ad.title}">
        <input type="hidden" name="default_description" value="${ad.description}">
        <div class="form-group">
            <label for="title">Title</label>
            <input
                id="title"
                name="ad_title"
                class="form-control"
                type="text"
                placeholder="${ad.title}"
            >
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea
                id="description"
                name="ad_description"
                class="form-control"
                type="text"
                placeholder="${ad.description}"></textarea>
        </div>
        <input type="submit" class="btn btn-block btn-primary">
    </form>
</div>
</body>
</html>
