<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="/WEB-INF/partials/head.jsp">
    <jsp:param name="title" value="Info" />
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
  <h1>Item Information</h1>
  <p>Ad ID: ${ad.id}</p>
  <p>Item: ${ad.title}</p>
  <p>Description: ${ad.description}</p>
  <p>Categories: <c:forEach var="category" items="${categories}">${category.category} </c:forEach> </p>
  <p>Created By: ${user.username}</p>
</body>
</html>
