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
				List<Recensione> listaRecensioni = 	recensioneService.getAllRecensioni(idUtente, idProdotto);


		
			if(listaRecensioni == null){
				listaRecensioni = new ArrayList<>();
				listaRecensioni.add(recensione);
				
          	
          	
          	
			}else if(!listaRecensioni.contains(recensione)){
	
				listaRecensioni.add(recensione);
				recensioneService.insertRecensione(recensione);	
				req.setAttribute("recensione", recensione);
			}
			
		
			recensioneService.close();

			req.setAttribute("listaRecensioni", listaRecensioni);
		

			 RequestDispatcher dispatcher = req.getRequestDispatcher("recensioneInserita.jsp");
				dispatcher.forward(req, resp);
	
	}
	
	
	

}
