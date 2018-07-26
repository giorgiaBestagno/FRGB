
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

public class ListaAcquisti extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	List<Acquisto> listaAcquisti = new ArrayList<>();
	
	
	AcquistoDaoImpl acquistoService = new AcquistoDaoImpl();
	HttpSession sessione = req.getSession();
	 Utente utente = (Utente) sessione.getAttribute("utenteLoggato");
	 	int idUtente = utente.getIdUtente();
	System.out.println(idUtente);
	listaAcquisti = acquistoService.getAllAcquisti(idUtente);
	System.out.println(listaAcquisti);
	acquistoService.close();
	req.setAttribute("listaAcquisti", listaAcquisti);		
	RequestDispatcher dispatcher = req.getRequestDispatcher("acquisti.jsp");
	dispatcher.forward(req, resp);
	
	}

}
