<%@page import="it.accenture.model.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contatti</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="css/stile.css">
<script type="text/javascript" src="jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<% Utente utenteLoggato = (Utente) session.getAttribute ("utenteLoggato"); %>
<nav class="nav navbar-inverse">
<div class="navbar-header">
<a href="index.jsp" class="navbar-brand" style="color:white">Home</a>
</div>
<div class="collapse navbar-collapse">
<ul class="nav navbar-nav">

<% if (utenteLoggato == null) { %>
<li><a href="registrazione.jsp" style="color: white">Registrazione</a></li>
<li><a href="login.jsp" style="color: white">Login</a></li>
<% } else { %>

<li><a href ="logout" style="color: white">Logout</a></li>


<% } %>
</ul>
</div>

</nav>

<h1 style="margin: 40px; color: #e663cf">Contatti</h1>
<div style="margin: 50px">
<h4>
FRGB</h4>
<br>
<p style="bold">Numero di telefono: 02 12345678</p>
<br>
<p style="bold">Mail: frgb@gmail.com</p>
<br>
<p style="bold">Ecommerce è lo shop online dedicato a chi cerca originalità e unicità in ogni cosa. <br>
Su Ecommerce trovi ogni giorno nuove offerte e promozioni sulle proposte del momento. <br>
Dallo sport, all'arte, ai libri e tanto altro.</p><br>

<p style="bold">Indirizzo:</p><p> Via Meravigli, 6, 20123 Milano (MI), Italy</p>

</div>
<h2 style="margin: 40px; color: #e663cf">Dove siamo</h2>
<div id="googleMap" style="width:100%;height:400px;"></div>

<script>
function myMap() {
var mapProp= {
    center:new google.maps.LatLng(51.508742,-0.120850),
    zoom:5,
};
var map=new google.maps.Map(document.getElementById("googleMap"),mapProp);
}
</script>

<script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY&callback=myMap"></script>

</body>
</html>