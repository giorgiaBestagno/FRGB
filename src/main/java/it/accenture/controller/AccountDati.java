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

import it.accenture.dao.UtenteDaoImpl;
import it.accenture.model.Utente;

public class AccountDati extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String username = req.getParameter("username");
	System.out.println(username);
	UtenteDaoImpl utenteService = new UtenteDaoImpl();
	Utente utente = utenteService.getUtenteByUsername(username);
	utenteService.close();
	HttpSession sessione = req.getSession();
	utente = (Utente) sessione.getAttribute("utenteLoggato");
		int idUtente = utente.getIdUtente();
			System.out.println("sono nella servlet AccountDati" + utente);
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("account.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	
}

