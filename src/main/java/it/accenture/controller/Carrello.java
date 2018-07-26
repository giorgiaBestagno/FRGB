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

public class Carrello extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession sessione = req.getSession();
		List<Prodotto> listaCarrello =(List<Prodotto>) sessione.getAttribute("listaCarrello");
		ProdottoDaoImpl prodottoService = new ProdottoDaoImpl();
		int idProdotto = Integer.parseInt(req.getParameter("idProdotto"));

		Prodotto prodotto = prodottoService.dettaglioProdotto(idProdotto);
		if (listaCarrello == null){
			listaCarrello = new ArrayList<>();
			
			listaCarrello.add(prodotto);
			
		

		}else if (!listaCarrello.contains(prodotto)){
			
			listaCarrello.add(prodotto);

			
		

		}
		sessione.setAttribute("listaCarrello", listaCarrello);


		prodottoService.close();

		RequestDispatcher dispatcher = req.getRequestDispatcher("carrello.jsp");
		dispatcher.forward(req, resp);
	}

}
