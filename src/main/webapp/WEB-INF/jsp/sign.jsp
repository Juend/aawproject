<%-- 
    Document   : sign
    Created on : 1 avr. 2019, 15:17:52
    Author     : emmanuelle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>SignIn </title>
    </head>
    
    <body>
        <h1>Connexion </h1>
        <form method="post" action="connect.htm">
            <fieldset>
                Login* : <input type="text" name="login" /><br />
                Password*: <input type="text" name="password" /><br />
                <input type="submit" name="action" value="Connexion"/>
            </fieldset>
        </form>
         <h2>${connectMessage}</h2>
        <font size="1" color="#ff0000">* Champs obligatoire</font>
        
        <h1>SignIn </h1>
        <form method="post" action="signIn.htm">
            <fieldset>
                Login* : <input type="text" name="login" /><br />
                Password*: <input type="text" name="password" /><br />
                Nom* : <input type="text" name="nom" /><br />
                Prénom*: <input type="text" name="prenom" /><br />
                <input type="submit" name="action" value="Connexion"/>
            </fieldset>
        </form>
        <h2>${signInMessage}</h2>
        <font size="1" color="#ff0000">* Champs obligatoire</font>
        
    </body>
</html>
