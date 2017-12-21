<%-- 
    Document   : ajouterCompte
    Created on : 2017-12-20, 15:10:04
    Author     : usager
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="<c:url value="/ressources/css/style.css" />">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            
        <h1>Inscription</h1>
        <form:form class="col-lg-8 col-lg-offset-2 form-account" method="POST" modelAttribute="account">
               <div class="form-group col-lg-12">
                    <form:label path="email">Courriel</form:label>
                    <form:input path="email" type="email" class="form-control"/>
                </div>
                <div class="form-group col-lg-6">
                    <form:label path="name">Prenom</form:label>
                    <form:input path="name" class="form-control"/>
                </div>
                <div class="form-group col-lg-6">
                    <form:label path="lastName">Nom</form:label>
                    <form:input path="lastName" class="form-control"/>
                </div>
                <div class="form-group col-lg-12">
                    <form:label path="password">Mot de passe</form:label>
                    <form:input path="password" type="password" class="form-control"/>
                </div>
                              
                <div class="form-group col-lg-12">
                    <button type="submit" class="btn btn-success">S'inscrire</button>
                    <a href="../" class="btn btn-link">Retour &agrave; la connexion</a>
                </div>
            </table>
        </form:form>
        </div>        
        
    </body>
</html>
