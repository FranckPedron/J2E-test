<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bonjour</title>
</head>
<body>
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

</body>
</html>
