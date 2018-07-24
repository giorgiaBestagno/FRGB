package it.accenture.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.accenture.dao.ProdottoDaoImpl;
import it.accenture.model.Prodotto;
import it.accenture.model.Utente;

public class Carrello extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Prodotto> listaCarrello = new ArrayList<>();
		HttpSession sessione = req.getSession();
		Utente utente = (Utente) sessione.getAttribute("utenteLoggato");
		int idUtente = utente.getIdUtente();
		int idProdotto = Integer.parseInt(req.getParameter("idProdotto"));
		ProdottoDaoImpl prodottoService = new ProdottoDaoImpl();
		Prodotto prodotto = prodottoService.dettaglioProdotto(idProdotto);
		prodottoService.close();
		listaCarrello.add(prodotto);
		req.setAttribute("listaCarrello", listaCarrello);
		RequestDispatcher dispatcher = req.getRequestDispatcher("carrello.jsp");
		dispatcher.forward(req, resp);
	}

}
