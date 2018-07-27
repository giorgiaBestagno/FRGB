<%@page import="it.accenture.model.Recensione"%>
<%@page import="it.accenture.model.Prodotto"%>
<%@page import="it.accenture.model.Utente"%>
<%@page import="it.accenture.model.Acquisto"%>
<%@page import="java.util.List" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>I miei Acquisti</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="css/stile.css">
<script type="text/javascript" src="jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<% Utente utenteLoggato = (Utente)session.getAttribute("utenteLoggato"); %>
<% List<Acquisto> listaAcquisti = (List<Acquisto>) request.getAttribute("listaAcquisti"); %>
<% Recensione recensione = (Recensione) request.getAttribute("recensione"); %>

<nav class="nav navbar-inverse">
<div class="navbar-header ">
<a href="index.jsp" class="navbar-brand" style="color: white">Home</a>
</div>

<div class="collapse navbar-collapse">
<ul class="nav navbar-nav">
<form action="listaProdottiNomiSimili" method="get">
<input type="text" minlength="2" placeholder="Cerca" id="cerca" name="cerca" size= 30px>
<button type="submit" class="btn btn-default btn-sm" name="cerca"  value="Cerca" style="background-color: white">
<span class="glyphicon glyphicon-search"></span> Cerca 
</button>

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
<li><a href ="carrello" style="color: white">Carrello</a></li>
<li><a href ="listaOrdini" style="color: white">Ordini In Corso</a></li>


<%} %>


</ul>
</div>

</nav>




<div class="container"> 
<div class="page-header">
<h1>I miei Acquisti</h1>
</div>
<%if(listaAcquisti.isEmpty()){ %>
<p>Lista Ordini vuota</p>
<%}else{ %>
<div class="list-group">
<%for(Acquisto acquisto : listaAcquisti){%>
<div class="list-group-item">
<p> Id prodotto : <%=acquisto.getIdProdotto() %>
<p>Id acquisto : <%=acquisto.getIdAcquisto() %></p>
<p>Spedizione : <%=acquisto.getSpedizione().toString() %></p>
<p>Data inizio : <%=acquisto.getDataInizio() %></p>
<p>Data Consegna : <%=acquisto.getDataFine() %></p>
<p>Quantità acquistata : <%=acquisto.getQuantitaAcquistata() %></p>

</div>



<form action="acquista" method="get">
<input type="hidden" id="idProdotto" value="<%=acquisto.getIdProdotto()%>">
<input type="submit"  id="idProdotto" value="Acquista di nuovo" <% if(utenteLoggato != null) {%>
class="btn"
<% }else{%>
class="btn btn-warning"
disabled
<%} %>> 

</form>

<form action="recensioni" method="get" class = "form-horizontal">
<input type="hidden" name="idProdotto" value="<%=acquisto.getIdProdotto()%>">

<h4> Inserisci Nuova Recensione</h4>

<div class="form-group">
<label for="titolo" >Titolo</label>
<br>
<input type="text" id="titolo" name="titolo">
</div>
<div class="form-group">
<label for="contenuto" >Testo Recensione</label>
<br>
<textarea rows="4" cols="20" id="contenuto" name="contenuto" maxlength="240"></textarea>
</div>
<div class="form-group">
<input type="submit" id="recensione" value="Aggiungi recensione" style="color: white">




</div>

</form>




<%} %>

<%} %>


</div>

</div>
 


</body>
</html>