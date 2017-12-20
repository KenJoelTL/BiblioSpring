<%-- 
    Document   : login
    Created on : 2017-12-13, 22:11:49
    Author     : Joel
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Biblio Spring</title>
    </head>
    <body>
        <h1>Page de connexion</h1>
        
        <form action="/connexion">
            Email: <input type="email"/> <br>
            Mot de passe: <input type="password"/> <br>
            <button>Se connecter</button>
        </form>
    
    </body>
</html>
