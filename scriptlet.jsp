<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP Scriptlet</title>
</head>
<body>
    <h1>Informations du serveur</h1>

    <%
        java.util.Date date = new java.util.Date();
        out.println("<p>Date et heure actuelles : " + date + "</p>");
        out.println("<p>Nom d'hôte du client : " + request.getRemoteHost() + "</p>");
    %>

</body>
</html>
