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
import it.accenture.dao.UtenteDaoImpl;
import it.accenture.model.Prodotto;
import it.accenture.model.Utente;

public class Offerta extends HttpServlet {
	
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Prodotto> listaProdottiOfferta = new ArrayList<>();
		UtenteDaoImpl utenteService = new UtenteDaoImpl();
		HttpSession sessione = req.getSession();
		Utente utente = (Utente) sessione.getAttribute("utenteLoggato");
		int idUtente = utente.getIdUtente();
		ProdottoDaoImpl prodottoService = new ProdottoDaoImpl();

		listaProdottiOfferta = prodottoService.listaProdottiInOfferta();
		for (Prodotto prodotto : listaProdottiOfferta) {
		
		
		
	}
	prodottoService.close();
	req.setAttribute("listaProdottiOfferta", listaProdottiOfferta);
	RequestDispatcher dispatcher = req.getRequestDispatcher("offerta.jsp");
	dispatcher.forward(req, resp);

}
}
