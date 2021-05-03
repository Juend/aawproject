<%-- 
    Document   : connect
    Created on : 27 août 2014, 10:09:39
    Author     : edarles
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="icon" type="image/x-icon" href="/assets/open-iconic/png/link-intact-8x.png" />
        <title> Connexion ETU'BANQUE</title>
    </head>

    <body>
        <header> 
            <!-- Ici mettre une icône vite fait de ETU BAnQ -->
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <a class="navbar-brand" href="#">ETU'BANQUE</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                  <span class="navbar-toggler-icon"></span>
                </button>
              
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                  <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                      <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="#">Link</a>
                    </li>
                    
                    <li class="nav-item">
                      <a class="nav-link disabled" href="#">Disabled</a>
                    </li>
                  </ul>
                  <ul class="navbar-nav   my-lg-0">
                  <li class="nav-item dropdown my-2 my-lg-0">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      Compte
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
                      <a class="dropdown-item" href="#">Deconnexion</a>
                      <div class="dropdown-divider"></div>
                      <a class="dropdown-item" href="#">Something else here</a>
                    </div>
                  </li>
                </ul>
                </div>
              </nav>
        </header>
        <div class ="col-6">

        </div>
        <div class="card-group">
            <div class="col-sm-6">
                <div class="card text-center">
                    <div class="card-header">
                        <h5 class="card-title">Connectez - vous : </h5>
                    </div>
                    <div class="card-body">
                        <div class = "card-text">
                            <form method="POST" ACTION="connect.htm">
                                <div class="form-group row">
                                    <label for="Radio_compte" class="col-sm-5 col-form-label">Vous etes un : </label>
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="radio" name="Radio_compte" id="Radio_utilisateur" value="Utilisateur">
                                        <label class="form-check-label" for="Radio_utilisateur">Utilisateur</label>
                                      </div>
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="radio" name="Radio_compte" id="Radio_conseiller" value="Conseiller">
                                        <label class="form-check-label" for="Radio_conseiller">Conseiller</label>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="login" class="col-sm-5 col-form-label">Entrez votre login : </label>
                                    <div class="col-sm-7">
                                        <input type="text" class="form-control" id="login" name="login" placeholder="Login">
                                    </div> 
                                </div>
                                <div class="form-group row">
                                    <label for="password" class="col-sm-5 col-form-label">Entrez votre mot de passe : </label>
                                    <div class="col-sm-7">
                                        <input type="text" class="form-control" id="password" name="password" placeholder="Mot de passe">
                                    </div>
                                </div>
                                <button type="submit" class="btn btn-primary" value="OK">Submit</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="card text-center">
                    <div class="card-header">
                        <h5 class="card-title">Creer votre compte: </h5>
                    </div>
                    <div class="card-body">
                        <form method="POST" ACTION="signIn.htm">
                            <div class="form-group row">
                                <label for="Radio_nouveau_compte" class="col-sm-5 col-form-label">Vous etes un nouvel : </label>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="Radio_nouveau_compte" id="Radio_nouveau_utilisateur" value="Utilisateur">
                                    <label class="form-check-label" for="Radio_nouveau_utilisateur">Utilisateur</label>
                                  </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="Radio_nouveau_compte" id="Radio_nouveau_conseiller" value="Conseiller">
                                    <label class="form-check-label" for="Radio_nouveau_conseiller">Conseiller</label>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="login" class="col-sm-5 col-form-label">Entrez votre login : </label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" id="login" name="login" placeholder="Login">
                                </div> 
                            </div>
                            <div class="form-group row">
                                <label for="password" class="col-sm-5 col-form-label">Entrez votre mot de passe : </label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" id="password" name="password" placeholder="Mot de passe">
                                </div>
                            </div>
                            <button type="submit" class="btn btn-primary" value="OK">Submit</button> 
                        </form>
                    </div>
                </div>
            </div>
        </div>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    </body>
</html>

