package it.accenture.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.accenture.dao.AcquistoDaoImpl;
import it.accenture.model.Acquisto;
import it.accenture.model.Utente;

public class ListaOrdini extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Acquisto> listaOrdini = new ArrayList<>();
		AcquistoDaoImpl acquistoService = new AcquistoDaoImpl();
		HttpSession sessione = req.getSession();
		 Utente utente = (Utente) sessione.getAttribute("utenteLoggato");
		 int idUtente = utente.getIdUtente();
		listaOrdini = acquistoService.getAllOrdini(idUtente);
		acquistoService.close();

			
		
		req.setAttribute("listaOrdini", listaOrdini);
		
	
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("ordini.jsp");
		dispatcher.forward(req, resp);
		
	}
}
