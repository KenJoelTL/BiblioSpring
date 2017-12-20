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
        <title>Biblio Spring</title>
    </head>
    <body>
        <h1>${titre}</h1>
        <a href="books/create">Ajouter un livre &agrave; la biblioth&egrave;que</a>
        <a href="books/logout">Se déconnecter</a>
    
    <div> 
        <table>
            <thead>
                <tr>
                    
                <th>
                    ISBN
                </th>
                <th>
                    Titre
                </th>
                </tr>
            </thead>
                
            <tbody>   
            <c:forEach var="b" items="${liste}">
                <tr>
                    <td>${b.isbn}</td>
                    <td>${b.title}</td>
                    <td><a href="books/update/?isbn=${b.isbn}">modifier</a></td>
                    <td><a href="books/delete/?isbn=${b.isbn}">supprimer</a></td>
                </tr>
            </c:forEach>        
            </tbody>
        </table>
    </div>
    </body>
    
</html>
