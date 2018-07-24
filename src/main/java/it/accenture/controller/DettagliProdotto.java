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



public class DettagliProdotto extends HttpServlet{
	
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	HttpSession sessione = req.getSession();
	int idProdotto = Integer.parseInt(req.getParameter("idProdotto"));
	 System.out.println(idProdotto);
     ProdottoDaoImpl prodottoService = new ProdottoDaoImpl();
	Prodotto prodotto = prodottoService.dettaglioProdotto(idProdotto);
	prodottoService.close();
	req.setAttribute("prodotto", prodotto);
	System.out.println(prodotto);
	RequestDispatcher dispatcher = req.getRequestDispatcher("dettagli.jsp");
	dispatcher.forward(req, resp);
}


}