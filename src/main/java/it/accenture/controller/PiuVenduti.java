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
import it.accenture.model.Acquisto;
import it.accenture.model.Prodotto;
import it.accenture.model.Utente;

public class PiuVenduti extends HttpServlet {

	@Override
	protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sessione = req.getSession();
		List<Prodotto> listaPiuVenduti = new ArrayList<>();
		ProdottoDaoImpl prodottoService = new ProdottoDaoImpl();
		listaPiuVenduti = prodottoService.getByCount();
		System.out.println(listaPiuVenduti);
		prodottoService.close();
		sessione.setAttribute("listaPiuVenduti", listaPiuVenduti);
		
	/*	for (Prodotto prodotto : listaPiuVenduti){
			String percorso = prodotto.getImmagine();
			req.setAttribute("percorso", percorso);		
		}*/
		RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
		dispatcher.forward(req, resp);
	

		
	}
	
	
}
