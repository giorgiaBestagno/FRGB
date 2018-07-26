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
		
		List<Recensione> listaRecensioni = (List<Recensione>) req.getAttribute("listaRecensioni");
		
		Recensione recensione = new Recensione();
		HttpSession sessione = req.getSession();
		
		 Utente utente = (Utente) sessione.getAttribute("utenteLoggato");

			 RecensioneDaoImpl recensioneService = new RecensioneDaoImpl();
 			 
		 int idUtente = utente.getIdUtente();
		 System.out.println(idUtente);

		 int idProdotto = Integer.parseInt(req.getParameter("idProdotto"));
         System.out.println(idProdotto);
		 
		 String titolo = req.getParameter("titolo");
		 System.out.println(titolo);

		 String contenuto = req.getParameter("contenuto");
		 System.out.println(contenuto);
		
		 recensione = (Recensione) req.getAttribute("recensione");

		 recensione = new Recensione(titolo, contenuto, idUtente, idProdotto);
		
			if(listaRecensioni !=null && recensioneService.getRecensioneByIdUtente(idProdotto, idUtente) != null){
			
				 RequestDispatcher dispatcher = req.getRequestDispatcher("aggiornaRecensione.jsp");
					dispatcher.forward(req, resp);
			}else{
		recensioneService.insertRecensione(recensione);
		
			

		recensioneService.close();
		System.out.println(recensione);
		req.setAttribute("recensione", recensione);
			}
		
		 RequestDispatcher dispatcher = req.getRequestDispatcher("recensioneInserita.jsp");
			dispatcher.forward(req, resp);
		
	}
	
	
	

}
