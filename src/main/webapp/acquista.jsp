<%@page import="java.time.LocalDate"%>
<%@page import="it.accenture.model.Spedizione"%>
<%@page import="java.util.ArrayList"%>
<%@page import="it.accenture.model.Utente"%>
<%@page import="it.accenture.model.Prodotto"%>
<%@page import="it.accenture.model.Acquisto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Acquista</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="css/stile.css">
<script type="text/javascript" src="jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</head>
<% Utente utenteLoggato = (Utente) session.getAttribute("utenteLoggato"); %>
<%Prodotto prodotto = (Prodotto) request.getAttribute("prodotto"); %>
<%Spedizione spedizione = (Spedizione) session.getAttribute("spedizione"); %>

<body>

<nav class="nav navbar-inverse">
<div class="navbar-header">
<a href="index.jsp" class="navbar-brand" style="color: white">Home</a>
</div>
<div class="collapse navbar-collapse">
<ul class="nav navbar-nav">
<form action="listaProdottiNomiSimili" method="get">
<input type="text" minlength="2" placeholder="Cerca" name="cerca" size= 30px>
<button type="submit" class="btn btn-default btn-sm" name="cerca"  value="Cerca" style="background-color: white">
<span class="glyphicon glyphicon-search"></span> Cerca 
</button>

</form>
<li><a href=" contatti.jsp" style="color: white">Contatti</a></li>
<% if (utenteLoggato == null) { %>
<li><a href="registrazione.jsp" style="color: white">Registrazione</a></li>
<li><a href="login.jsp" style="color: white">Login</a></li>
<% } else { %>

<li><a href="accountDati" style="color: white">Il Mio Account </a></li>
<li><a href ="logout" style="color: white">Logout</a></li>
<li><a href ="listaOrdini" style="color: white">Ordini In Corso</a></li>
<li><a href ="listaAcquisti" style="color: white">I Miei Acquisti</a></li>


<% } %>
</ul>
</div>

</nav>

<div class="container">
<div class="page-header">
<h1>Acquisto prodotto : <%=prodotto.getNome() %></h1>

</div>

<form action="acquista" method="post" class= "form-group" >
<input type="hidden" name="idProdotto" value="<%=prodotto.getIdProdotto()%>">
<input type="hidden" name="quantitaDisponibile" value="<%=prodotto.getQuantitaDisponibile()%>">



<div class= "form-group">
<label for="quantita">Inserisci Quantità Da Acquistare</label>
<input type="text" id="quantita" name="quantita">


</div>

<div class= "form-group">
<label>Scelta Spedizione</label><br>
<input type="radio" name="spedizione" value="STANDARD">STANDARD &euro 0,00 (5 giorni lavorativi)
<br>
<input type="radio" name="spedizione" value="EXPRESS">EXPRESS &euro 5,00 (3 giorni lavorativi)
<br>
<input type="radio" name="spedizione" value= "PREMIUM">PREMIUM &euro 8,00 (24 ore)
</div>



<div class= "form-group">
<label>Scelta Metodo Di Pagamento</label>
<br><input type="radio" name="pagamento">Carta di credito/debito
<br><input type="radio" name="pagamento">PayPal
<br><input type="radio" name="pagamento">Contrassegno
</div>



<input type="submit" value="Conferma" class="btn btn-primary" onsubmit="return controlloDisponibilita()">
</form>

<!-- alert -->
<div class="alert alert-danger" id="alert" style="display:none"> 
<p class="text-center">La quantità dispondibile è minore della quantità desiderata</p>
</div>



</body>
</html>