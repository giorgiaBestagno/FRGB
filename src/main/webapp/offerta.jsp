<%@page import="java.util.List"%>
<%@page import="it.accenture.model.Utente"%>
<%@page import="it.accenture.model.Prodotto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Offerte</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="css/stile.css">
<script type="text/javascript" src="jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
<% Utente utenteLoggato = (Utente) session.getAttribute("utenteLoggato"); %>
<%List<Prodotto> listaProdottiOfferta = (List<Prodotto>) request.getAttribute("listaProdottiOfferta"); %>

<nav class="nav navbar-inverse">
<div class="navbar-header ">
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
<li><a href=" contatti.jsp" style="color: white">Contatti</a></li>
<% if (utenteLoggato == null) { %>
<li><a href="registrazione.jsp" style="color: white">Registrazione</a></li>
<li><a href="login.jsp" style="color: white;">Login</a></li>
<% } else {  %>

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
<h1>Offerte</h1>


<%if (listaProdottiOfferta == null) {%>
<h2>Lista inesistente</h2>

<%}else if( listaProdottiOfferta.isEmpty()) { %>
<h2>Lista vuota</h2>

<% } else { %>
<% for (Prodotto prodotto : listaProdottiOfferta) { %>
<ul>
<li>
<p>
Id Prodotto : <%=prodotto.getIdProdotto() %>
<br>
Nome Prodotto : <%=prodotto.getNome() %>
<br>
Categoria Prodotto : <%=prodotto.getCategoria() %><br>
Marca Prodotto : <%=prodotto.getMarca() %><br>
Prezzo Prodotto : <%=prodotto.getPrezzo() %><br>
Offerta : <%=prodotto.isOfferta()%><br>
Sconto : <%=prodotto.getSconto() %><br>
Quantità disponibile : <%=prodotto.getQuantitaDisponibile() %><br>
<img src="<%=prodotto.getImmagine() %>"><br>

<form action="acquista" method="get">
<input type="hidden" name="idProdotto" value="<%=prodotto.getIdProdotto()%>">
<input type="submit" value="Acquista" <% if(utenteLoggato != null) {%>
class="btn btn-success"
<% }else{%>
class="btn btn-warning"
disabled
<%} %>
>
</form>
<form action="carrello" method="get">
<input type="hidden" name="idProdotto" value="<%=prodotto.getIdProdotto()%>">
<input type="submit" value="Aggiungi al carrello" >
</form>
<form action="dettagliProdotto" method="get">
<input type="hidden" name="idProdotto" value="<%=prodotto.getIdProdotto()%>">
<input type="submit" " value="Dettagli Prodotto" >
</form>

</p>


<%} %>
<%} %>

</li>
</ul>
</div>
</div>


</body>
</html>