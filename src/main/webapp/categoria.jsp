<%@page import="it.accenture.model.Categoria"%>
<%@page import="it.accenture.dao.ProdottoDaoImpl"%>
<%@page import="it.accenture.model.Prodotto"%>
<%@page import="java.util.List"%>
<%@page import="it.accenture.model.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Categoria</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="css/stile.css">
<script type="text/javascript" src="jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</head>


<body>

<% Utente utenteLoggato = (Utente) session.getAttribute ("utenteLoggato"); %>
<%String cat =  request.getParameter("scelta"); %>

<h1>Lista Prodotti in <% out.println(cat); %></h1>
<% ProdottoDaoImpl dao = new ProdottoDaoImpl();
List<Prodotto> listaProdotti = dao.listaProdottiPerCategoria(cat);

%>
<%if (listaProdotti == null || listaProdotti.isEmpty()) { %>
<h2>Lista vuota o inesistente</h2>
<% } else { %>
<ul>
<% for (Prodotto prodotto: listaProdotti) { %>
<li>
<p>
<%=prodotto.getIdProdotto() %>
<%=prodotto.getNome() %>
<%=prodotto.getCategoria() %>
<%=prodotto.getMarca() %>
<%=prodotto.getPrezzo() %>
<%=prodotto.isOfferta()%>
<%=prodotto.getSconto() %>
<%=prodotto.getQuantitaDisponibile() %>
<%=prodotto.getImmagine() %>

</p>


<%} %>
<%} %>
</li>
</ul>
</body>
</html>