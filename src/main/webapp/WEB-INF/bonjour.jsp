<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bonjour</title>
</head>
<body>
<%@ include file="menu.jsp" %>
    <c:out value="${prenom}" />
    <form method="post" action="bonjour">
        <p>
            <label for="nom">Nom: </label>
            <input type="text" id="nom" name="nom"/>
        </p>
        <p>
            <label for="prenom">Prenom: </label>
            <input type="text" id="prenom" name="prenom"/>
        </p>

        <input type="submit"/>
    </form>

    <ul>
        <c:forEach var="utilisateur" items="${utilisateurs}">
            <li><c:out value="${utilisateur.prenom} ${utilisateur.nom}" /></li>
        </c:forEach>
    </ul>
</body>
</html>
