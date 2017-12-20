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
        <title>${titre}</title>
    </head>
    <body>
        <h1>${titre}</h1>
    </body>
    
    <div> 
        <c:forEach var="b" items="${liste}">
            <div>${b.isbn}</div>
        </c:forEach>        
    </div>
    
</html>
