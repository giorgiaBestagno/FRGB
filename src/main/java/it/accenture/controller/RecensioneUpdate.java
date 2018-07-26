package it.accenture.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.accenture.dao.RecensioneDaoImpl;
import it.accenture.model.Recensione;
import it.accenture.model.Utente;

public class RecensioneUpdate extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sessione = req.getSession();
		Utente utente = (Utente) sessione.getAttribute("utenteLoggato");
		Recensione recensione = (Recensione) req.getAttribute("recensione");
		int idUtente = utente.getIdUtente();
		int idRecensione = recensione.getIdRecensione();
		RecensioneDaoImpl recensioneService = new RecensioneDaoImpl();
		String contenuto = (String) req.getAttribute("contenuto");
		recensioneService.updateRecensione(idRecensione, contenuto);
		recensioneService.close();
		req.setAttribute("recensione", recensione);
		RequestDispatcher dispatcher = req.getRequestDispatcher("recensioneInserita.jsp");
		dispatcher.forward(req, resp);
		
	}

}
