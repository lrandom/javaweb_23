<%--
  Created by IntelliJ IDEA.
  User: lrandom
  Date: 3/17/22
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${names}" var="name">
    <c:out value="${name}"/>
</c:forEach>
</body>
</html>
