<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>IGS GO - Covoiturage</title>
        <meta name="description" content="Dashboard">
        <meta name="keywords" content="" />
        <meta name="theme-color" content="#25282a">
        <!-- <link rel="icon" type="image/png" href="/img/favicon.png" /> -->
        <!-- <link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico" /> -->

        <!-- Google Fonts  -->
        <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,500' rel='stylesheet' type='text/css'> <!-- Body font -->
        <link href='http://fonts.googleapis.com/css?family=Lato:300,400' rel='stylesheet' type='text/css'> <!-- Navbar font -->
        <script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>

        <!-- Libs and Plugins CSS -->
        <link rel="stylesheet" href="FRAMEWORKS/Bootstrap/css/bootstrap.min.css">
        <!-- <link rel="stylesheet" href="inc/font-awesome/css/font-awesome.min.css"> --> <!-- Font Icons -->
        
        <!-- Theme CSS -->
        <link  rel="stylesheet" href="<c:url value="CSS/style.css"/>">


        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->

        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    </head>
    <body>
        <header id="header" class="header-main">
            <!-- Debut Navbar -->
            <nav id="main-navbar" class="navbar navbar-dark bg-dark">
                <a class="navbar-brand" href="#">
                    <img src="<c:url value="IMG/logo.png"/>" width="50" height="50" class="d-inline-block align-center" alt="">
                    IGS GO
                </a>
                <div>
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#ModalSignup">
                    Inscription
                    </button>
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#ModalLogin">
                    Login
                    </button>
                </div>
            </nav>

            <!-- Modal Signup -->
            <div class="modal fade" id="ModalSignup" tabindex="-1" role="dialog" aria-labelledby="ModalSignupLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="ModalSignupLabel">Inscription</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form method="post" action="register">
                                <div class="form-group">
                                    <label for="InputName">Nom</label>
                                    <input type="text" class="form-control" id="nom" name="nom" placeholder="Nom">
                                </div>
                                <div class="form-group">
                                    <label for="InputName">Prénom</label>
                                    <input type="text" class="form-control" id="prenom" name="prenom" placeholder="Prénom">
                                </div>
                                <div class="form-group">
                                    <label for="InputMail">Mail</label>
                                    <div class="input-group mb-3">            
                                        <input type="text" class="form-control" id="mail" name="mail" placeholder="Mail" aria-label="Recipient's username" aria-describedby="basic-addon2">
                                        <div class="input-group-append">
                                            <span class="input-group-text" id="basic-addon2">@campus-igs-toulouse.fr</span>
                                        </div>
                                    </div>
                                    <small id="emailHelp" class="form-text text-muted">Promis, on ne vous spammeras pas.</small>
                                    ${ erreurs.mail }
                                </div>
                                <div class="form-group">
                                    <label for="InputPassword">Mot de passe</label>
                                    <input type="password" class="form-control" id="password" name="password" placeholder="Mot de passe">
                                </div>
                                <div class="form-group">
                                        <label for="InputConfirmPassword">Confirmez le mot de passe</label>
                                        <input type="password" class="form-control" id="Confirmpassword" name="Confirmpassword" placeholder="Confirmation">
                                    </div>
                                     ${ erreurs.Confirmpassword }
                                <div class="form-group">
                                    <label for="InputTel">Téléphone</label>
                                    <input type="text" class="form-control bfh-phone" id="numTel" name="numTel" data-format="dddddddddd">
                                </div>
                                <button type="submit" class="btn btn-primary">Valider</button>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Fermer</button>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Modal Login -->
            <div class="modal fade" id="ModalLogin" tabindex="-1" role="dialog" aria-labelledby="ModalLoginLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="ModalSignupLabel">Connexion</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form method="post" action="login">
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Email</label>
                                    <div class="input-group mb-3">
                                        <input type="text" id="mail" name="email" class="form-control" placeholder="Email" aria-label="Email" aria-describedby="basic-addon2">
                                            <div class="input-group-append">
                                                <span class="input-group-text" id="basic-addon2">@campus-igs-toulouse.fr</span>
                                            </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Mot de passe</label>
                                    <input type="password" class="form-control" id="password" name="password" placeholder="*******">
                                </div>
                                ${ statusMessage } <br />
                                <button type="submit" class="btn btn-primary">Valider</button>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Fermer</button>
                        </div>
                    </div>
                </div>
            </div>
        </header>

        <div id="MainContainer" class="container-fluid">
            <div id="MainRow" class="row">
                <div class="col-lg-6" onload="initialize()">
                        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDQIRnlcNXqCHQV75eFmPe8Li6U_02u5xw&callback=initialize"
                        async defer></script>
                        <script>
                        var geocoder;
                        var map;
                        var uluru = {lat: 43.643845, lng: 1.386830};
                        function initialize() {
                          geocoder = new google.maps.Geocoder();
                          var latlng = new google.maps.LatLng(43.643845, 1.386830);
                          var mapOptions = {
                            zoom: 15,
                            center: latlng,
                            panControl: false,
                            zoomControl: true,
                            mapTypeControl: false,
                            scaleControl: false,
                            streetViewControl: false,
                            overviewMapControl: false,
                            rotateControl: false  
                          }
                          map = new google.maps.Map(document.getElementById('map'), mapOptions);
                          var marker = new google.maps.Marker({
                              position: uluru,
                              map: map
                            });
                        }
                        function codeAddress() {
                          var address = document.getElementById('address').value;
                          geocoder.geocode( { 'address': address}, function(results, status) {
                            if (status == 'OK') {
                              map.setCenter(results[0].geometry.location);
                              var marker2 = new google.maps.Marker({
                                  map: map,
                                  zoom: 15,
                                  position: results[0].geometry.location,
                                  icon:'http://maps.google.com/mapfiles/ms/icons/green-dot.png'
                              });
                              Marker
                            } else {
                              alert('Geocode was not successful for the following reason: ' + status);
                            }
                          });
                        }
                        </script>
                        <div id="map" style="width: 100%; height: 63%;"></div>
                        <form>
                            <div id="addressForm" class="form-row align-items-center">
                                <h4>J'habite à: </h4>
                                <div class="col-auto">
                                    <input id="address" class="form-control" type="text" value="Toulouse, France">
                                </div>
                                <div class="col-auto">
                                    <input type="button" class="btn btn-primary" value="Valider" onclick="codeAddress()">
                                </div>
                            </div>
                        </form>
                </div>
                <div class="col-lg-6">
                    <div id="presentation">
                        <h1>PRESENTATION</h1>
                        <br/>
                        <h3>Salut les cornichons !</h3>
                        <p>Bienvenue sur IGS GO, une application de covoiturage qui vous permettra… d’aller en cours en covoiturant !</p>
                        <p>Notre service est entièrement gratuit et réservé aux étudiants du Campus IGS.</p>
                        <br/>                                <p>Envie de rencontrer d’autres étudiants ?</p>
                        <p>Envie de protéger l’environnement ?</p>
                        <p>La conduite Toulousaine te déplait ?</p>
                        <p>Marre des transports en communs ?</p>
                        <br/>
                        <p>Alors notre service est fait pour toi !</p>
                        <p>Inscris-toi et rejoint le clan des cornichons malins, c’est gratuit !</p>
                        <img src="<c:url value="IMG/logo.png" />" width="150" height="150" class="d-inline-block align-center" alt="">
                    </div>
                </div>
            </div>
        </div>

      <footer id="footer" class="page-footer unique-color-dark pt-0 bg-dark">
            <div class="container">
                <div class="row">
                    <div class="col">
                        <h4 class="text-uppercase font-weight-bold"><strong>IGS GO</strong></h4>
                        <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 250px;">
                        <p>Lorem ipsum dolor sit
                            amet, consectetur adipisicing elit.</p>
                    </div>
                    <div class="col">
                        <h4 class="text-uppercase font-weight-bold"><strong>Réseaux sociaux</strong></h4>
                        <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 250px;">
                        <ul>
                            <li>
                                <a class="resLink" href="#"><img src="<c:url value="IMG/Twitter.png" />" width="50" height="50" class="d-inline-block align-center" alt=""></a>
                            </li>
                            <li>
                                <a class="resLink" href="#"><img src="<c:url value="IMG/Facebook.png" />" width="50" height="50" class="d-inline-block align-center" alt=""></a>
                            </li>
                            <li>
                                <a class="resLink" href="#"><img src="<c:url value="IMG/Instagram.png" />" width="50" height="50" class="d-inline-block align-center" alt=""></a>
                            </li>
                        </ul>
        
                    </div>
                    <div class="col">
                        <h4 class="text-uppercase font-weight-bold"><strong>Partenaires</strong></h4>
                        <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 250px;">
                        <ul>
                            <li>
                                <a class="resLink" href="#"><img src="<c:url value="IMG/GROUPE IGS.jpg" />" width="100" height="50" class="d-inline-block align-center" alt=""></a>
                            </li>
                            <li>
                                <a class="resLink" href="#"><img src="<c:url value="IMG/mairieBlagnac.png" />" width="50" height="50" class="d-inline-block align-center" alt=""></a>
                            </li>
                            <li>
                                <a class="resLink" href="#"><img src="<c:url value="IMG/WWF.jpg" />" width="50" height="50" class="d-inline-block align-center" alt=""></a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="footer-copyright py-3 text-center">
                <div class="container-fluid">
                    © 2018 Copyright: <a href=""><strong> IGS-GO.com</strong></a>
                </div>
            </div>
        </footer>
        
    <!-- Plugins JS -->
    <script src="FRAMEWORKS/Bootstrap/js/bootstrap.min.js"></script>
    <script src="FRAMEWORKS/FormHelper/js/bootstrap-formhelpers.js"></script>
 </body>
</html>