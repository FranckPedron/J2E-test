<%--
  Created by IntelliJ IDEA.
  User: Franck
  Date: 03/10/2022
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Autre</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<p>Vous êtes sur autre.jsp</p>
<c:if test="${ !empty sessionScope.nom && !empty sessionScope.prenom}">
  <p>Vous êtes: ${ sessionScope.nom} ${ sessionScope.prenom} !</p>
</c:if>
</body>
</html>
