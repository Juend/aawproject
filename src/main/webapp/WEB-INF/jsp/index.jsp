<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title> Connexion mur</title>
    </head>

    <body>
        <div class="container" >
            <h4 class="display-4">Exemple : couche service avec Spring</h4>
        </div>
        <div class="container" style="height:200px;">
        <div class="row">
        <div class="col-auto" style="border: 1px solid silver">
            <FORM method="POST" ACTION="wall.htm">
            <div class="form-group">
            <label for="exampleInputEmail1">Login</label>
            <input type="login" name=login class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter login">
            </div>
            <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input type="password" name = password class="form-control" id="exampleInputPassword1" placeholder="Password">
            </div>
            <center><button type="submit" class="btn btn-primary">Connexion</button></center>
            ${infoMessage1}
            </FORM>   
        </div>
        <div class="col-1" ></div>
        <div class="col-auto" style="border: 1px solid silver">
            <FORM method="POST" ACTION="index.htm">
            <div class="form-group">
            <label for="exampleInputEmail1">Login</label>
            <input type="login" name=login class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter login">
            </div>
            <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input type="password" name = password class="form-control" id="exampleInputPassword1" placeholder="Password">
            </div>
            <center><button type="submit" class="btn btn-primary">SignIn</button></center>
            ${infoMessage2}
            </FORM>   
        </div>
        </div>
        </div>
     
    </body>
</html>

