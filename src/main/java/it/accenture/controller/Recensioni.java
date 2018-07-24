package it.accenture.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.accenture.dao.ProdottoDaoImpl;
import it.accenture.dao.RecensioneDaoImpl;
import it.accenture.model.Prodotto;
import it.accenture.model.Recensione;
import it.accenture.model.Utente;

public class Recensioni extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		


		 ProdottoDaoImpl prodottoService = new ProdottoDaoImpl();
		 RecensioneDaoImpl recensioneService = new RecensioneDaoImpl();
		 
		HttpSession sessione = req.getSession();
		
		Prodotto prodotto = (Prodotto) sessione.getAttribute("prodotto");
		 Utente utente = (Utente) sessione.getAttribute("utenteLoggato");
		 int idUtente = utente.getIdUtente();

		 String titolo = req.getParameter("titolo");
		 String contenuto = req.getParameter("contenuto");
		 int idProdotto = Integer.parseInt(req.getParameter("idProdotto"));


		Recensione recensione = (Recensione) req.getAttribute("recensione");

		 recensione = new Recensione(titolo, contenuto, idUtente, idProdotto);

			
		recensioneService.insertRecensione(recensione);
		recensioneService.close();
		System.out.println(recensione);
		req.setAttribute("recensione", recensione);

		
		 RequestDispatcher dispatcher = req.getRequestDispatcher("dettagli.jsp");
			dispatcher.forward(req, resp);
		
	}

}
