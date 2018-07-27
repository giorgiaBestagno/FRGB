<%@page import="it.accenture.model.Acquisto"%>
<%@page import="it.accenture.model.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Successo</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
</head>
<body>
<% Utente utenteLoggato = (Utente) session.getAttribute("utenteLoggato"); %>
<% Acquisto acquisto = (Acquisto) request.getAttribute("acquisto"); %>
<nav class="nav navbar-inverse">
<div class="navbar-header">
<a href="index.jsp" class="navbar-brand" style="color: white">Home</a>
</div>
<div class="collapse navbar-collapse">
<ul class="nav navbar-nav">
<form action="listaProdottiNomiSimili" method="get">
<input type="text" minlength="2" placeholder="Cerca" name="cerca" size= 30px>
<button type="submit" class="btn btn-default btn-sm" name="cerca" id="cerca" value="Cerca" style="background-color: white">
<span class="glyphicon glyphicon-search"></span> Cerca 
</button>

</form>
<li><a href=" contatti" style="color: white">Contatti</a></li>
<% if (utenteLoggato == null) { %>
<li><a href="registrazione.jsp">Registrazione</a></li>
<li><a href="login.jsp">Login</a></li>
<% } else { %>
<form action="categoria" method="get">

<label style="color:white;">Categorie</label>
<select name="scelta">
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

</select>
<input type= "submit" value="Vai">
</form>

<li><a href="accountDati" style="color: white">Il Mio Account </a></li>
<li><a href ="logout" style="color: white">Logout</a></li>
<li><a href ="offerta" style="color: #e663cf">Prodotti In Offerta</a></li>
<li><a href ="carrello" style="color: white">Carrello</a></li>
<li><a href ="listaOrdini" style="color: white">Ordini In Corso</a></li>
<li><a href ="listaAcquisti" style="color: white">I Miei Acquisti</a></li>


<% } %>
</ul>
</div>

</nav>

<div class="container">
<div class="page-header">
<h1>Acquisto effettuato con successo!</h1>
<h3>Quantita Acquistata : <%=acquisto.getQuantitaAcquistata() %></h3>
<h3>Data Inizio : <%=acquisto.getDataInizio() %> 
<h3>Data Fine : <%= acquisto.getDataFine() %></h3>

</div>


</div>

</body>
</html>