<%-- 
    Document   : wall
    Created on : 25 janv. 2021, 15:07:35
    Author     : emma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Mon espace</title>
    </head>
    <body>
        <div class="container" >
            <h4 class="display-4">${helloMessage}</h4>
        </div>
        <div class="container" style="height:200px;">
        <div class="row">
        <div class="col-auto">
            <ul class="list-group">
                 ${messageList}
            </ul>
        </div>
        <div class="col-2" ></div>
        <div class="col-auto" style="border: 1px solid silver">
            <FORM method="POST" ACTION="wallFriend.htm">
            <div class="form-group">
            <label for="exampleInputEmail1">Your friend login</label>
            <input type="login" name=loginFriend class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter login">
            </div>
            <div class="form-group">
            <label for="message">Your message</label>
            <textarea class="form-control" rows="5" id="message" name=message></textarea>
            </div>
                <center><button type="submit" class="btn btn-primary">Send !</button></center>
            ${infoMessage}
            </FORM>   
        </div>
        </div>
        </div>
    </body>
</html>
