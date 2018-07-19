 <%@page import="it.accenture.model.Utente"%>
<%@page import="it.accenture.model.Prodotto"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ecommerce</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="css/stile.css">
<script type="text/javascript" src="jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<% Utente utenteLoggato = (Utente) session.getAttribute ("utenteLoggato"); %>
<nav class="nav navbar-inverse">
<div class="navbar-header ">
<a href="index.jsp" class="navbar-brand" style="color: white">Home</a>
</div>

<div class="collapse navbar-collapse">
<ul class="nav navbar-nav">

<form action="listaProdottiNomiSimili" method="get">
<input type="text" minlength="2" placeholder="Cerca" name="cerca" id="cerca" size= 30px>
<input type="submit" name="cerca" id="cerca" value="Cerca" style="background-color: white">
</form>
<li><a href="contatti.jsp" style="color: white">Contatti</a></li>
<%if (utenteLoggato == null){ %>
<li><a href="registrazione.jsp" style="color: white">Registrazione</a></li>
<li><a href="login.jsp" style="color: white;" >Login</a></li>




<% }else { %>

<form action="categoria" method="get">

<label style="color:white;">Categorie</label>
<select name="scelta">
<option value="#" selected="selected">------</option>
<option value="ABBIGLIAMENTO" >Abbigliamento</option> 
<option value="ARTE" >Arte</option> 
<option value="CASA">Casa</option> 
<option value="CUCINA">Cucina</option> 
<option value="ELETTRONICA">Elettronica</option> 
<option value="FILM">Film</option> 
<option value="GIARDINAGGIO">Giardinaggio</option> 
<option value="GIOCATTOLI">Giocattoli</option> 
<option value="LIBRI">Libri</option> 
<option value="SPORT">Sport</option> 
</select>
<input type= "submit" value="Vai">
</form>

<li><a href="accountDati" style="color: white">Il Mio Account </a></li>
<li><a href ="logout " style="color: white">Logout</a></li>
<li><a href ="offerta" style="color: #e663cf">Prodotti In Offerta</a></li>
<li><a href ="" style="color: white">Carrello</a></li>
<li><a href ="listaOrdini" style="color: white">Ordini In Corso</a></li>
<li><a href ="listaAcquisti" style="color: white">I Miei Acquisti</a></li>


<%} %>


</ul>
</div>

</nav>



<div class="container">
<div class = "page-header text-center" >
<h1>Shop Online</h1>

<div class=" carousel-inner">
<div class="item active"> 

<%if (utenteLoggato == null){ %>

<!-- primo carousel per utente non loggato -->


<div class="carousel slide" id="myCarousel" data-ride="carousel" data-interval="5000"> 
<!-- immagini -->


<div class=" carousel-inner">
<div class="item active"> 

<img src="img/ecommerce1.jpg" class="img-carousel">
</div>
<div class="item">
<img src="img/ecommerce2.jpg" class="img-carousel">
</div>
<div class="item">
<img src="img/ecommerce3.jpg" class="img-carousel">
</div>
</div><!-- chiusura div immagini -->
<ol class="carousel-indicators"> 
<li data-target="#myCarousel" data-slide-to="0" class="active"></li> 
<li data-target="#myCarousel" data-slide-to="1"></li>
<li data-target="#myCarousel" data-slide-to="2"></li>
</ol>

<a class="left carousel-control" href="#myCarousel" data-slide="prev">
<span class="glyphicon glyphicon-chevron-left"></span>
</a>
<a class="right carousel-control" href="#myCarousel" data-slide="next">
<span class="glyphicon glyphicon-chevron-right"></span>
</a>

</div>

<!-- fine primo carousel per utente non loggato -->

<%}else{ %>

<!-- primo carousel per utente  loggato -->


<div class="carousel slide" id="myCarousel" data-ride="carousel" data-interval="5000"> 
<!-- immagini -->


<div class=" carousel-inner">
<div class="item active"> 

<img src="img/ecommerce1.jpg" class="img-carousel">
</div>
<div class="item">
<img src="img/ecommerce2.jpg" class="img-carousel">
</div>
<div class="item">
<img src="img/ecommerce3.jpg" class="img-carousel">
</div>
</div><!-- chiusura div immagini -->
<ol class="carousel-indicators"> 
<li data-target="#myCarousel" data-slide-to="0" class="active"></li> 
<li data-target="#myCarousel" data-slide-to="1"></li>
<li data-target="#myCarousel" data-slide-to="2"></li>
</ol>

<a class="left carousel-control" href="#myCarousel" data-slide="prev">
<span class="glyphicon glyphicon-chevron-left"></span>
</a>
<a class="right carousel-control" href="#myCarousel" data-slide="next">
<span class="glyphicon glyphicon-chevron-right"></span>
</a>

</div> <!-- finisce primo carousel -->

<!-- secondo carousel per utente  loggato -->

<div class="carousel slide" id="myCarousel" data-ride="carousel" data-interval="5000"> 
<!-- immagini -->


<div class=" carousel-inner">
<div class="item active"> 

<img src="" class="img-carousel">
</div>
<div class="item">
<img src="" class="img-carousel">
</div>
<div class="item">
<img src="" class="img-carousel">
</div>
</div><!-- chiusura div immagini -->
<ol class="carousel-indicators"> 
<li data-target="#myCarousel" data-slide-to="0" class="active"></li> 
<li data-target="#myCarousel" data-slide-to="1"></li>
<li data-target="#myCarousel" data-slide-to="2"></li>
</ol>

<a class="left carousel-control" href="#myCarousel" data-slide="prev">
<span class="glyphicon glyphicon-chevron-left"></span>
</a>
<a class="right carousel-control" href="#myCarousel" data-slide="next">
<span class="glyphicon glyphicon-chevron-right"></span>
</a>

</div>

<%} %>



</div> <!-- chiusura container -->
</body>
</html>
