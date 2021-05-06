<%-- 
    Document   : createcompte
    Created on : 5 mai 2021, 23:57:20
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
                                <h1 > Bienvenue ${Utilisateurname} </h1>
                            </div>
                            <div class="row justify-content-md-center m-t-25" style="padding-top: 30px;" >
                                <div  class="col-md-8 order-md-4 mb-8 " >
                                    <ul class="list-group">
                                        <li class="list-group-item list-group-item-action list-group-item-light">
                                            Ouvrir un compte 
                                            <form method="POST" ACTION="createCompte.htm">
                                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                                    <span aria-hidden="true">></span>
                                            </button>
                                            </form>
                                        </li>
                                        <li class="list-group-item list-group-item-action list-group-item-light">
                                            Voir mes comptes
                                            <form method="POST" ACTION="afficheCompte.htm">
                                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                                        <span aria-hidden="true">></span>
                                                </button>
                                            </form>
                                        </li>
                                        <li class="list-group-item list-group-item-action list-group-item-light">
                                            Realiser des transferts
                                            <form method="POST" ACTION="affichageCompte.htm">
                                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                                        <span aria-hidden="true">></span>
                                                </button>
                                            </form>
                                        </li>
                                        <li class="list-group-item list-group-item-action list-group-item-light">
                                            Envoyer un message a mon conseiller
                                            <form method="POST" ACTION="transferts.htm">
                                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                                        <span aria-hidden="true"> > </span>
                                                </button>
                                            </form>
                                        </li>
                                      </ul>
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
