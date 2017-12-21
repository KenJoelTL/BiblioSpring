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
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="./css/style.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Biblio Spring</title>
    </head>
    <body>
      <div class="container">
        <h1>Page de connexion</h1>
            
        <form class="col-lg-8 col-lg-offset-2 form-account" method="POST">
            <div class="form-group col-lg-12">
                <label for="email">Courriel</label>
                <input type="email" class="form-control" id="email" placeholder="Entrez votre courriel" name="email">
            </div>
            <div class="form-group col-lg-12">
                <label for="password">Mot de passe</label>
                <input type="password" class="form-control" id="password" placeholder="Entrez votre mot de passe" name="password">
            </div>
            <div class="form-group col-lg-12">
                <button type="submit" class="btn btn-primary">Se connecter</button>
                <a href='account/create' class="btn btn-success">S'incrire</a>
            </div> 
        </form>        
        
        
      </div>  
    </body>
</html>
