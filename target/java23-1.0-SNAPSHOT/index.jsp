<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<fmt:setLocale value="ja_JP"/>
<fmt:setBundle basename="main"/>
<fmt:message key="age"/>
<fmt:message key="hi"/>
<fmt:message key="name"/>

<c:out value="Hello JavaWeb23"/>
<a href="hello-servlet">Hello Servlet</a>

<c:set var="name" value="Luan"/>

<c:out value="Hello ${name}"/>

<c:set var="age" value="${19}"/>

<c:if test="${age > 18}" var="compareResult">
    <c:out value="${compareResult}"/>
    <c:out value="Bạn đã đủ tuổi tham gia"/>
</c:if>

<c:choose>
    <c:when test="${age==6}">
        <c:out value="Bạn là nhi đồng"/>
    </c:when>

    <c:when test="${age==12}">
        <c:out value="Bạn là thiếu niên"/>
    </c:when>

    <c:when test="${age==18}">
        <c:out value="Bạn là thanh niên"></c:out>
    </c:when>

    <c:otherwise>
        <c:out value="Bạn không phải là nhi đồng, thiếu niên, thanh niên"/>
    </c:otherwise>
</c:choose>

<%
    ArrayList<String> names = new ArrayList<>();
    names.add("Luan");
    names.add("Huy");
    names.add("Hoa");
%>

<c:forEach var="name" begin="1" end="12">
    <c:out value="${name}"/>
</c:forEach>

<c:set value="1000000" var="balance"/>
<fmt:setLocale value="vi_VN"/>
<fmt:formatNumber value="${balance}" type="currency">
</fmt:formatNumber>

</body>
</html>