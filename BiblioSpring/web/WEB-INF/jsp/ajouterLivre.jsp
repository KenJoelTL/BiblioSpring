<%-- 
    Document   : ajouterLivre
    Created on : 2017-12-20, 01:30:41
    Author     : Joel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Biblio Spring</title>
    </head>
    <body>
        <h1>Ajout</h1>
        <form:form method="POST" modelAttribute="book" >
             <table>
                <tr>
                    <td><form:label path="isbn">ISBN</form:label></td>
                    <td><form:input path="isbn"/></td>
                </tr>
                <tr>
                    <td><form:label path="title">Titre</form:label></td>
                    <td><form:input path="title"/></td>
                </tr>
                <tr>
                    <td><form:label path="author">Auteur</form:label></td>
                    <td><form:input path="author"/></td>
                </tr>
                <tr>
                    <td><form:label path="nbPages">Pages</form:label></td>
                    <td><form:input path="nbPages"/></td>
                </tr>
                <tr>
                    <td><form:label path="edition">&Eacute;dition</form:label></td>
                    <td><form:input path="edition"/></td>
                </tr>
                <tr>
                    <td><form:label path="language">Langage</form:label></td>
                    <td><form:input path="language"/></td>
                </tr>
                <tr>
                    <td><form:label path="year">Ann&eacute;e</form:label></td>
                    <td><form:input path="year"/></td>
                </tr>
                <tr>
                    <td><form:label path="description">Description</form:label></td>
                    <td><form:input path="description"/></td>
                </tr>
                <tr>
                    <td><form:label path="keywords">Mots-cl&eacute;s</form:label></td>
                    <td><form:input path="keywords"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Ajouter"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
