<%@page import="it.accenture.model.Prodotto"%>
<%@page import="java.util.List"%>
<%@page import="it.accenture.model.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Il Mio Account</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="css/stile.css">
<script type="text/javascript" src="jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</head>

<body>
<% List<Prodotto> listaCarrello = (List<Prodotto>) session.getAttribute("listaCarrello"); %>
<% Utente utenteLoggato = (Utente) session.getAttribute("utenteLoggato"); %>
<% Utente utente = (Utente) request.getAttribute("utente"); %>
<nav class="nav navbar-inverse ">
<div class="navbar-header">
<a href="index.jsp" class="navbar-brand" style="color: white">Home</a>
</div>
<div class="collapse navbar-collapse">
<ul class="nav navbar-nav">

<li><a href=" contatti.jsp" style="color: white">Contatti</a></li>

<%if (utenteLoggato == null){ %>
<li><a href="registrazione.jsp" style="color: white">Registrazione</a></li>
<li><a href="login.jsp" style="color: white">Login</a></li>

<% } else {  %>


<li><a href ="logout" style="color: white">Logout</a></li>
<li><a href ="carrello.jsp" style="color: white">Carrello</a></li>

<li><a href ="listaOrdini" style="color: white">Ordini In Corso</a></li>
<li><a href ="listaAcquisti" style="color: white">I Miei Acquisti</a></li>


<% } %>

</ul>
</div>

</nav>

<div class="container">
<div class = "page-header text-center">
<h1>Il Mio Account</h1>

<div class="list-group">
<div class="list-group-item">
<p>IdUtente : <%=utenteLoggato.getIdUtente() %></p>
<p>Nome : <%=utenteLoggato.getNome() %></p>
<p>Cognome : <%=utenteLoggato.getCognome() %></p>
<p>Username : <%=utenteLoggato.getUsername() %></p>
<p>Password : <%=utenteLoggato.getPassword()%></p>
<p>Indirizzo : <%=utenteLoggato.getIndirizzo()%></p>

<form action="accountUpdatePassword" method="post">
<input type="hidden" name="username" value="<%=utenteLoggato.getUsername()%>">

<label for="password">Inserisci Nuova Password</label>
<input type="password" id="password" name="password">
<input type="submit" value="Cambia Password" id="password">
<br>

</form>
<form action="accountUpdateIndirizzo" method="post">
<input type="hidden" name="username" value="<%=utenteLoggato.getUsername()%>">

<label for="indirizzo" >Inserisci Nuovo Indirizzo</label>
<input type="text" id="indirizzo" name="indirizzo">
<input type="submit" value="Cambia Indirizzo" id="indirizzo" >
<br>
</form>






</div>

</div>
</div>
</div><!-- chiusura container -->

</body>
</html>
