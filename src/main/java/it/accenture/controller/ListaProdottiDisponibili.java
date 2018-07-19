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


public class ListaProdottiDisponibili extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Prodotto> listaProdottiDisponibili = new ArrayList<>();
		ProdottoDaoImpl prodottoService = new ProdottoDaoImpl();
		
		listaProdottiDisponibili = prodottoService.listaProdottiDisponibili();
		
		for (Prodotto prodottoDisponibile : listaProdottiDisponibili) {
			System.out.println(prodottoDisponibile);
			
		}
		prodottoService.close();
		req.setAttribute("listaProdottiDisponibili", listaProdottiDisponibili);
		RequestDispatcher dispatcher = req.getRequestDispatcher("risultato.jsp");
		dispatcher.forward(req, resp);
	
		
	}

}
