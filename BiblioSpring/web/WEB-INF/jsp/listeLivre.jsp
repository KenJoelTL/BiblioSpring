<%-- 
    Document   : listeLivre
    Created on : 2017-12-13, 21:29:09
    Author     : Joel
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.modele.Book"%>
<%@page import="com.services.BookService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Biblio Spring</title>
    </head>
    <body>
        <div class="container-fluid">
            
        <h1>${titre}</h1>
        <div class="row">
            <div class="col-lg-6">
                <a href="books/create" class="btn btn-primary">Ajouter un l,mmn,nivre &agrave; la biblioth&egrave;que</a>        
            </div> 
            <div class="col-lg-6">
                <span class="pull-right"><a href="logout/" class="btn btn-success">Se déconnecter</a></span>
            </div>
        </div>
    
        <table class="table table-striped">
            <thead>
                <tr>                   
                    <th>ISBN</th>
                    <th>Titre</th>
                    <th>Auteur</th>
                    <th>Langage</th>
                    <th>Edition</th>
                    <th>Ann&eacute;e</th>
                    <th>Description</th>
                    <th>Mots-clé</th>

                    <th></th>
                    <th></th>
                </tr>
            </thead>
                
            <tbody>   
            <c:forEach var="b" items="${liste}">
                <tr>
                    <td>${b.isbn}</td>
                    <td>${b.title}</td>
                    <td>${b.author}</td>
                    <td>${b.language}</td>
                    <td>${b.edition}</td>
                    <td>${b.year}</td>
                    <td>${b.description}</td>
                    <td>${b.keywords}</td>
                    <td><a href="books/update/?isbn=${b.isbn}" class="btn btn-link">modifier</a></td><td> <a href="books/delete/?isbn=${b.isbn}" class="btn btn-link">supprimer</a></td>
                </tr>
            </c:forEach>        
            </tbody>
        </table>

        </div>
    </body>
    
</html>
