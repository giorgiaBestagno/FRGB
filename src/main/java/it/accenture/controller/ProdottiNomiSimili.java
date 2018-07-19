package it.accenture.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.accenture.dao.ProdottoDaoImpl;
import it.accenture.model.Prodotto;

public class ProdottiNomiSimili extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		List<Prodotto> listaProdottiNomiSimili = new ArrayList<>();
		ProdottoDaoImpl prodottoService = new ProdottoDaoImpl();
		
		listaProdottiNomiSimili = prodottoService.listaProdottiNomiSimili(req.getParameter("cerca"));
		
		
		for (Prodotto prodottoDisponibile : listaProdottiNomiSimili) {
			System.out.println(prodottoDisponibile);
			
		}
		prodottoService.close();
		req.setAttribute("listaProdottiDisponibili", listaProdottiNomiSimili);
		RequestDispatcher dispatcher = req.getRequestDispatcher("risultato.jsp");
		dispatcher.forward(req, resp);
	
		
	}
		
		
	}

