<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="FRAMEWORKS/Bootstrap/css/bootstrap.min.css">

<link rel="stylesheet" href="CSS/style.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
	<header id="header" class="header-main">
    	<!-- Debut Navbar -->
        <nav id="main-navbar" class="navbar navbar-dark bg-dark">
        	<a class="navbar-brand" href="#">
            	<img src="<c:url value="IMG/logo.png" />" width="50" height="50" class="d-inline-block align-center" alt="">
                	IGS GO
        	</a>
        </nav>
     </header>
     
     <div id="MainContainer" class="container-fluid">
            <div id="MainRow" class="row">
            	<div class="col text-center">
            	<span class="font-weight-bold">Je suis conducteur</span><br><br>
            		<a href="<%=request.getContextPath()+"/Trajet"%>"><button type="button" class="btn btn-primary">
            			J'enregistre mon trajet
            		</button></a>
            	</div>
            	<div class="col text-center">
            	<span class="font-weight-bold">Je suis passager</span><br><br>
				<a href="<%=request.getContextPath()+"/Arret"%>">
            		<button type="button" class="btn btn-primary">
            			Je cherche un point d'arrêt proche de moi !
            		</button>
					</a>
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
                                <img src="<c:url value="IMG/Twitter.png" />" width="50" height="50" class="d-inline-block align-center" alt="">
                            </li>
                            <li>
                                <img src="<c:url value="IMG/Facebook.png" />" width="50" height="50" class="d-inline-block align-center" alt="">
                            </li>
                            <li>
                                <img src="<c:url value="IMG/Instagram.png" />" width="50" height="50" class="d-inline-block align-center" alt="">
                            </li>
                        </ul>
        
                    </div>
                    <div class="col">
                        <h4 class="text-uppercase font-weight-bold"><strong>Partenaires</strong></h4>
                        <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 250px;">
                        
                    </div>
                </div>
            </div>
            <div class="footer-copyright py-3 text-center">
                <div class="container-fluid">
                    © 2017 Copyright: <a href=""><strong> IGS-GO.com</strong></a>
                </div>
            </div>
        </footer>




    <script src="FRAMEWORKS/Bootstrap/js/bootstrap.min.js"></script>
    <script src="FRAMEWORKS/FormHelper/js/bootstrap-formhelpers.js"></script>
</body>
</html>