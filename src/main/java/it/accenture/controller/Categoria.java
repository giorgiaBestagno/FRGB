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

import it.accenture.dao.ProdottoDaoImpl;
import it.accenture.model.Prodotto;
import it.accenture.model.Utente;

public class Categoria extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Prodotto> listaPerCategoria = new ArrayList<>();
		ProdottoDaoImpl prodottoService = new ProdottoDaoImpl();
		HttpSession sessione = req.getSession();
		Utente utente = (Utente) sessione.getAttribute("utenteLoggato");
		int idUtente = utente.getIdUtente();
		
		String categoria = req.getParameter("scelta");
		listaPerCategoria= prodottoService.listaProdottiPerCategoria(categoria);
		prodottoService.close();
		RequestDispatcher dispatcher = req.getRequestDispatcher("categoria.jsp");
		dispatcher.forward(req, resp);		
	}
	
}
