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

public class RecensioneUpdate extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		
		RecensioneDaoImpl recensioneService = new RecensioneDaoImpl();
		int idRecensione = Integer.parseInt(req.getParameter("idRecensione"));
		String contenuto = req.getParameter("contenuto");
		Recensione recensione = recensioneService.getById(idRecensione);

	    recensioneService.updateRecensione( idRecensione, contenuto);
		recensioneService.close();
		
		req.setAttribute("recensione", recensione);
		RequestDispatcher dispatcher = req.getRequestDispatcher("recensioneInserita.jsp");
		dispatcher.forward(req, resp);
		
	}

}
