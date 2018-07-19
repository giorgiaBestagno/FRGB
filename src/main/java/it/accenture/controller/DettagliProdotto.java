package it.accenture.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.accenture.dao.ProdottoDaoImpl;
import it.accenture.model.Prodotto;



public class DettagliProdotto {
	
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
	int idProdotto = Integer.parseInt(req.getParameter("idProdotto"));
	ProdottoDaoImpl prodottoService = new ProdottoDaoImpl();
	Prodotto prodotto = prodottoService.dettaglioProdotto(idProdotto);
	prodottoService.close();
	req.setAttribute("prodotto", prodotto);
	RequestDispatcher dispatcher = req.getRequestDispatcher("dettagli.jsp");
	dispatcher.forward(req, resp);
}


}
