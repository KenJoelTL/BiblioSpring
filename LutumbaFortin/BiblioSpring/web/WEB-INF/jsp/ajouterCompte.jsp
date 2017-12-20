<%-- 
    Document   : ajouterCompte
    Created on : 2017-12-20, 15:10:04
    Author     : usager
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Inscription</h1>
        <form:form method="POST" modelAttribute="account">
             <table>
                <tr>
                    <td><form:label path="email">Courriel</form:label></td>
                    <td><form:input path="email" type="email"/></td>
                </tr>
                <tr>
                    <td><form:label path="name">Prenom</form:label></td>
                    <td><form:input path="name"/></td>
                </tr>
                <tr>
                    <td><form:label path="lastName">Nom</form:label></td>
                    <td><form:input path="lastName"/></td>
                </tr>
                <tr>
                    <td><form:label path="password">Mot de passe</form:label></td>
                    <td><form:input path="password" type="password"/></td>
                </tr>
                              
                <tr>
                    <td><input type="submit" value="S'inscrire"/></td>
                </tr>
            </table>
        </form:form>
        
        
    </body>
</html>
