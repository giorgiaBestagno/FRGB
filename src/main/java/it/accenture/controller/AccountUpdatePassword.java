package it.accenture.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.accenture.dao.UtenteDaoImpl;
import it.accenture.model.Utente;

public class AccountUpdatePassword extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	HttpSession sessione = req.getSession();
	Utente utente = (Utente) sessione.getAttribute("utenteLoggato");
		int idUtente = utente.getIdUtente();
			System.out.println(utente);
	
	String username = req.getParameter("username");
	System.out.println(username);
	UtenteDaoImpl utenteService = new UtenteDaoImpl();
	String password = req.getParameter("password");
	utenteService.updatePassword(password, idUtente);
	((Utente) sessione.getAttribute("utenteLoggato")).setPassword(password);

	utenteService.close();
	
	


RequestDispatcher dispatcher = req.getRequestDispatcher("account.jsp");
		dispatcher.forward(req, resp);

		 }

	
}
