<%-- 
    Document   : modifierLivre
    Created on : 2017-12-19, 20:34:58
    Author     : Joel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="<c:url value="/ressources/css/style.css" />">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Biblio Spring</title>
    </head>
    <body>
        <div class="container pageContent">
        <form:form method="POST" class="col-lg-8 col-lg-offset-2" modelAttribute="book">
        <h1>Modification</h1>
            <div class="form-group col-lg-6">
                <form:label path="title">Titre</form:label>
                <form:input path="title" class="form-control" maxlength="50"/>
            </div>
           <div class="form-group col-lg-6">
                <form:label path="author">Auteur</form:label>
                <form:input path="author" class="form-control" maxlength="50"/>
            </div>
            <div class="form-group col-lg-6">
                <form:label path="edition">&Eacute;dition</form:label>
                <form:input path="edition" class="form-control" maxlength="25"/>
            </div>
            <div class="form-group col-lg-3">
                <form:label path="nbPages">Pages</form:label>
                <form:input path="nbPages" class="form-control" type="number" min="1" max="99999999999"/>
            </div>
            <div class="form-group col-lg-3">
                <form:label path="year">Ann&eacute;e</form:label>
                <form:input path="year" class="form-control" type="number" max="99999999999"/>
            </div>
            <div class="form-group col-lg-3">
                <form:label path="language">Langue</form:label>
                <form:input path="language" class="form-control" maxlength="7"/>
            </div>
            <div class="form-group col-lg-3">
                <form:label path="keywords">Mots-cl&eacute;s</form:label>
                <form:input path="keywords" class="form-control" maxlength="6"/>
            </div>
            <div class="form-group col-lg-12">
                <form:label path="description">Description</form:label>
                <form:textarea path="description" class="form-control" rows="5"/>
            </div>
            <div class="form-group col-lg-12">
                <button type="submit" class='btn btn-primary'>Modifier</button>
                <a href="../../books" class="btn btn-link">Retour &agrave; la liste des livres</a>
            </div>
        </form:form>
        </div>
    </body>
</html>
