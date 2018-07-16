<%@page import="it.accenture.model.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="css/stile.css">
<script type="text/javascript" src="jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<title>Login</title>
</head>
<body>

<% String username = (String) request.getAttribute("username"); %>
<% Object errore = request.getAttribute("errore"); %>
<% Utente utenteLoggato = (Utente) session.getAttribute("utenteLoggato"); %>
<nav class="nav navbar-inverse">
<div class="navbar-header">
<a href="index.jsp" class="navbar-brand" style="color: white">Home</a>
<input type="text" placeholder="Cerca" name="cerca" id="cerca" size= 30px>
<input type="submit" name="cerca" id="cerca" value="Cerca" style="background-color: white" onsubmit="risultato.jsp">
<li><a href=" contatti.jsp" style="color: white">Contatti</a></li>
</div>
<div class="collapse navbar-collapse">
<ul class="nav navbar-nav">
<% if (utenteLoggato != null) { %>

<form action="categoria.jsp" method="get">

<label style="color:white;">Categorie</label>
<select name="scelta" onchange="location.href = categoria.jsp;">
<option value="#" selected="selected">------</option>
<option value="ABBIGLIAMENTO">Abbigliamento</option> 
<option value="ARTE">Arte</option> 
<option value="CASA">Casa</option> 
<option value="CUCINA">Cucina</option> 
<option value="ELETTRONICA">Elettronica</option> 
<option value="FILM">Film</option> 
<option value="GIARDINAGGIO">Giardinaggio</option> 
<option value="GIOCATTOLI">Giocattoli</option> 
<option value="LIBRI">Libri</option> 
<option value="SPORT">Sport</option> 
<option value="offerta.jsp" style="background-color:#e91e63; color:white">Prodotti in offerta</option> 

</select>
</form>

<li><a href="account.jsp" style="color: white">Il Mio Account </a></li>
<li><a href ="index.jsp" style="color: white">Logout</a></li>
<li><a href ="carrello.jsp" style="color: white">Carrello</a></li>
<li><a href ="ordini.jsp" style="color: white">Ordini In Corso</a></li>
<li><a href ="acquisti.jsp" style="color: white">I Miei Acquisti</a></li>


<% } %>
</ul>
</div>
</nav>

<div class="container" >
<!-- header -->
<div class="page-header text-center">
<h1>Login</h1>
</div>
<!-- form -->
<form class="form-horizontal" action="login" method="post" onsubmit="return validazioneLogin()">

<!-- username-->
<div class="form-group">
<label for="username" class="control-label col-md-4">Inserisci Username</label>
<div class="col-md-5">
<input type="text" name="username" id="username" class="form-control"
<%if (username!= null){ %>
value="<%=username%>"
<%}%> 
>

</div>
<span class="col-md-3"></span>
</div>

<!-- password -->
<form class="form-horizontal" action="registrazione" method="post">
<!--  nome -->
<div class="form-group">
<label for="password" class="control-label col-md-4">Inserisci Password</label>
<div class="col-md-5">
<input type="password" name="password" id="password" class="form-control">
</div>
<span class="col-md-3"></span>
</div>

<!-- bottoni -->
<div class="form-group">
<span class="col-md-4"></span>
<div class="col-md-5">
<input type="submit" value="Login" class="btn btn-primary">
<input type="reset" value="Ripristina" class="btn btn-warning" style="margin-left:2%;">
</div>
<span class="col-md-3"></span>
</div>
</form>

<!-- link -->
<div class="row">
<span class="col-md-4"></span>
<div class="col-md-5">
<p>Non sei registrato?</p>
<p>Clicca <a href="registrazione.jsp">qui</a> per la registrazione</p>
</div>
<span class="col-md-3"></span>
</div>

<!-- alert -->
<div class="alert alert-danger" id="alert" style="display:none"> <!--  col none il documento fa parte della pagina html, però non viene mostrato -->
<p class="text-center">Tutti i campi sono obbligatori</p>
</div>

<!-- alert 2 -->
<% if ( errore != null) { %>
<div class="alert alert-danger">
<p class="text-center">Username o password sbagliati</p>
</div>
<% } %>
</div> <!-- chiusura container -->

</body>

</html>