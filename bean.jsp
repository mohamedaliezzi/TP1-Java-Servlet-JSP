<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Résultat Person</title>
</head>
<body>

    <h1>Informations reçues</h1>

    <jsp:useBean id="person" class="isep.lab1.bean.Person" />

    <jsp:setProperty name="person" property="*" />

    <p>Prénom : <jsp:getProperty name="person" property="firstName" /></p>
    <p>Nom : <jsp:getProperty name="person" property="lastName" /></p>
    <p>Date de naissance : <jsp:getProperty name="person" property="birthDay" /></p>
    <p>Sexe : <jsp:getProperty name="person" property="sex" /></p>

    <br>
    <a href="form-jsp.html">Retour au formulaire</a>

</body>
</html>
