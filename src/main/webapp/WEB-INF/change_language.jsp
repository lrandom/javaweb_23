<%--
  Created by IntelliJ IDEA.
  User: lrandom
  Date: 3/17/22
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ftm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<ftm:setBundle basename="main"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/java23-1.0-SNAPSHOT/ServletChangeLanguage" method="post">
    <select name="locale-name">
        <option value="en_US" ${sessionScope.locale == "en_US" ? 'selected="selected"':''}>USA</option>
        <option value="vi_VN" ${sessionScope.locale == "vi_VN" ? 'selected="selected"':''}>Việt Nam</option>
        <option value="ja_JP" ${sessionScope.locale == "ja_JP" ? 'selected="selected"':''}>Japan</option>
    </select>
    <button>Submit</button>
</form>

<div>
    <fmt:message key="name"></fmt:message>
    <fmt:message key="age"></fmt:message>
    <fmt:message key="hi"></fmt:message>
</div>

</body>
</html>
