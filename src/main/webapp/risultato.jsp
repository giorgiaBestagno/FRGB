<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="it.accenture.controller.ListaProdottiDisponibili"%>
<%@page import="it.accenture.model.Prodotto"%>
<%@page import="it.accenture.model.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Risultato</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="css/stile.css">
<script type="text/javascript" src="jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<% Utente utenteLoggato = (Utente) session.getAttribute ("utenteLoggato"); %>
<%List<Prodotto> listaProdottiDisponibili = (List<Prodotto>) request.getAttribute("listaProdottiDisponibili"); %>

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
<li><a href=" contatti" style="color: white">Contatti</a></li>
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
<div class="page-header">

<h1>Risultato Ricerca</h1>



<%if (listaProdottiDisponibili == null) {%>
<h2>Lista inesistente</h2>
<%}else if( listaProdottiDisponibili.isEmpty()) { %>
<h2>Lista vuota</h2>
<% } else { %>
<% for (Prodotto prodottoDisponibile : listaProdottiDisponibili) { %>
<ul>
<li>
<p>
Id Prodotto : <%=prodottoDisponibile.getIdProdotto() %>
<br>
Nome Prodotto : <%=prodottoDisponibile.getNome() %>
<br>

<img src="<%=prodottoDisponibile.getImmagine() %>" >
<form action="acquista" method="get">
<input type="hidden" name="idProdotto" value="<%=prodottoDisponibile.getIdProdotto()%>">
<input type="submit" value="Acquista" <% if(utenteLoggato != null) {%>
class="btn btn-success"
<% }else{%>
class="btn btn-warning"
disabled
<%} %>
>
</form>
<form action="carrello" method="post">
<input type="hidden" name="idProdotto" value="<%=prodottoDisponibile.getIdProdotto()%>">
<input type="submit" value="Aggiungi al carrello" >
</form>
<form action="dettagliProdotto" method="get">
<input type="hidden" name="idProdotto" value="<%=prodottoDisponibile.getIdProdotto()%>">
<input type="submit" " value="Dettagli Prodotto" >
</form>
<%} %>


</p>


<%} %>


</li>
</ul>
</div>
</div>


</body>
</html>