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

import it.accenture.dao.AcquistoDaoImpl;
import it.accenture.dao.ProdottoDaoImpl;
import it.accenture.dao.RecensioneDaoImpl;
import it.accenture.model.Acquisto;
import it.accenture.model.Recensione;
import it.accenture.model.Utente;

public class Recensioni extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		HttpSession sessione = req.getSession();

		Utente utente = (Utente) sessione.getAttribute("utenteLoggato");
		 int idUtente = utente.getIdUtente();

		 int idProdotto = Integer.parseInt(req.getParameter("idProdotto"));	 
		 String titolo = req.getParameter("titolo");
		 String contenuto = req.getParameter("contenuto");	
			Recensione recensione = new Recensione(titolo, contenuto, idUtente, idProdotto);

			 RecensioneDaoImpl recensioneService = new RecensioneDaoImpl();
			Recensione recensione2 = recensioneService.getByIdUtenteAndIdProdotto(idUtente, idProdotto);


		
			if(recensione2 != null && recensione2.equals(recensione)){
				int idRecensione = recensione2.getIdRecensione();
				req.setAttribute("idRecensione", idRecensione);			
          	
          	
          	
			}else {
	
				recensioneService.insertRecensione(recensione);	
				req.setAttribute("recensione", recensione);
			}
			
		
			recensioneService.close();

			

			 RequestDispatcher dispatcher = req.getRequestDispatcher("recensioneInserita.jsp");
				dispatcher.forward(req, resp);
	
	}
	
	
	

}
