<%-- 
    Document   : transfertintercompte
    Created on : 6 mai 2021, 03:01:19
    Author     : Justine ENOND 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="icon" type="image/x-icon" href="/assets/open-iconic/png/link-intact-8x.png" />
        <title>ETU'BANQUE</title>
    </head>

    <body>
        <header> 
           <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <a class="navbar-brand" href="#">ETU'BANQUE</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                  <span class="navbar-toggler-icon"></span>
                </button>
              
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                  <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                      <a class="nav-link" href="accueil.htm">Accueil <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="affichagecomptes.htm">Comptes</a>
                    </li>                   
                    <li class="nav-item">
                      <a class="nav-link " href="transferts.htm">Transferts</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link " href="#">Conseiller</a>
                    </li>
                  </ul>
                  <ul class="navbar-nav   my-lg-0">
                  <li class="nav-item dropdown my-2 my-lg-0">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        ${loginName}
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
                      <a class="dropdown-item" href="disconnect.htm">Deconnexion</a>
                      <div class="dropdown-divider"></div>
                      <a class="dropdown-item" href="#">Mes paramètres</a>
                    </div>
                  </li>
                </ul>
                </div>
              </nav>
        </header>
        <div class="main-content" style="padding-top: 130px; min-height: 100vh;">
            <div class="section__content section__content--p30" style ="position: relative; margin: 0 auto; z-index: 1; padding: 0 30px;">
                <div class="container-fluid">
                    <div class="row justify-content-md-center m-t-25">
                        <div class="col-md-12 order-md-4 mb-8 ">
                            <div class="row justify-content-md-center m-t-25" >
                                <h1 > Transfert inter-comptes :  </h1>
                            </div>
                            <div class="row justify-content-md-center m-t-25" style="padding-top: 30px;" >
                                <div  class="col-md-8 order-md-4 mb-8 " >
                                    <div class="card text-center"  >
                                        <div class="card-body">
                                            <div class = "card-text">
                                                <form method="POST" ACTION="opetransferts.htm">
                                                    <div class="form-group row">
                                                        <label for="nom_ope" class="col-sm-5 col-form-label">Nom de l'operation : </label>
                                                        <div class="col-sm-7">
                                                            <input type="text" class="form-control" id="nom_ope" name="nom_ope" >
                                                        </div> 
                                                    </div>
                                                    <div class="form-group row">
                                                        <label for="id_compte_deb" class="col-sm-5 col-form-label"> Actionnaire : </label>
                                                        <select name="id_compte_deb" id="id_compte_deb" class="custom-select">
                                                            <option selected disabled>Choisir le compte à debiter</option>
                                                            {$listes_comptes_deb}
                                                        </select>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label for="id_compte_cred" class="col-sm-5 col-form-label">Beneficiaire : </label>
                                                        <select name="id_compte_cred" id="id_compte_cred" class="custom-select">
                                                            <option selected disabled>Choisir le compte à créditer</option>
                                                            {$listes_comptes_cred}
                                                        </select>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label for="somme" class="col-sm-5 col-form-label">Somme a prelever : </label>
                                                        <div class="col-sm-7">
                                                            <input type="text" class="form-control" id="somme" name="somme" >
                                                        </div> 
                                                    </div>
                                                    <button type="submit" class="btn btn-primary" value="OK">Soumettre</button> 
                                                </form>
                                            </div>                        
                                        </div>
                                        <div class= "card-footer">
                                            <div class="alert alert-danger" role="alert">${submitMessage}</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    </body>
</html>
