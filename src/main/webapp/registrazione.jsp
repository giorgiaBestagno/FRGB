
<%@page import="it.accenture.model.Utente"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrazione</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="css/stile.css">
<script type="text/javascript" src="jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>


<% Utente utenteLoggato = (Utente) session.getAttribute("utenteLoggato"); %>
<nav class="nav navbar-inverse">
<div class="navbar-header">
<a href="index.jsp" class="navbar-brand" style="color: white">Home</a>
</div>
<div class="collapse navbar-collapse">
<ul class="nav navbar-nav">
<input type="text" minlength="2" placeholder="Cerca" name="cerca" id="cerca" size= 30px>
<input type="submit" name="cerca" id="cerca" value="Cerca" style="background-color: white" onsubmit="risultato.jsp">
<li><a href=" contatti" style="color: white">Contatti</a></li>

<% if (utenteLoggato == null) { %>
<li><a href="registrazione.jsp" style="color: white">Registrazione</a></li>
<li><a href="login.jsp" style="color: white">Login</a></li>
<% } else {  %>
<li><a href="logout" style="color: white">Logout</a></li>
<% } %>
</ul>
</div>
</nav>

<div class="container" >
<!-- header -->
<div class="page-header text-center">
<h1>Registrazione</h1>

</div>
<!--  form -->
<form class="form-horizontal" action="registrazione" method="post" onsubmit="return validazione()">
<!-- nome -->
<div class="form-group">
<label for="nome" class="control-label col-md-4">Inserisci Nome</label>
<div class="col-md-5">
<input type="text" name ="nome" id="nome" class="form-control">
</div>
<span class="col-md-3"></span>
</div>

<!-- cognome -->
<div class="form-group">
<label for="cognome" class="control-label col-md-4">Inserisci Cognome</label>
<div class="col-md-5">
<input type="text" name ="cognome" id="cognome" class="form-control">
</div>
<span class="col-md-3"></span>
</div>

<!--  username -->
<div class="form-group">
<label for="username" class="control-label col-md-4">Inserisci username</label>
<div class="col-md-5">
<input type="text" name ="username" id="username" class="form-control">
</div>
<span class="col-md-3"></span>
</div>

<!--  password -->
<div class="form-group">
<label for="password" class="control-label col-md-4">Inserisci Password</label>
<div class="col-md-5">
<input type="password" name ="password" id="password" class="form-control">
</div>
<span class="col-md-3"></span>
</div>

<!--indirizzo  -->
<div class="form-group">
<label for="indirizzo" class="control-label col-md-4">Inserisci Indirizzo</label>
<div class="col-md-5">
<input type="text" name ="indirizzo" id="indirizzo" class="form-control">
</div>
<span class="col-md-3"></span>
</div>

<!--  bottoni -->
<div class="form-group">
<span class="col-md-4"></span>
<div class="col-md-5">
<input type="submit" value="Registrati" class="btn btn-primary">
<input type="reset" value="Ripristina" class="btn btn-warning" style="margin-left:2%;">
</div>

<span class="col-md-3"></span>

</div>
</form>
<!-- link -->
<div class="row">
<span class="col-md-4"></span>
<div class="col-md-5">
<p>Sei già registrato?</p>
<p>Clicca <a href="login.jsp">qui </a>per la login</p>
</div>
<span class="col-md-3"></span>
</div>

<!-- alert -->
<div class="alert alert-danger" id="alert" style="display:none">
<p class="text-center">Tutti i campi sono obbligatori</p>
</div>

</div> <!-- chiusura container -->

</body>
</html>



</body>
</html>