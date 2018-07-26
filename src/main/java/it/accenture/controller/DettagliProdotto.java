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
import it.accenture.dao.RecensioneDaoImpl;
import it.accenture.model.Prodotto;
import it.accenture.model.Recensione;
import it.accenture.model.Utente;



public class DettagliProdotto extends HttpServlet{
	
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	List<Recensione> listaRecensioni = new ArrayList<>();

	HttpSession sessione = req.getSession();
	int idProdotto = Integer.parseInt(req.getParameter("idProdotto"));
	 System.out.println(idProdotto);
		RecensioneDaoImpl recensioneService = new RecensioneDaoImpl();
		listaRecensioni = recensioneService.getAllRecensioni(idProdotto);


     ProdottoDaoImpl prodottoService = new ProdottoDaoImpl();
	Prodotto prodotto = prodottoService.dettaglioProdotto(idProdotto);
	prodottoService.close();
	recensioneService.close();
	req.setAttribute("listaRecensioni", listaRecensioni);

	req.setAttribute("prodotto", prodotto);
	System.out.println(prodotto);
	RequestDispatcher dispatcher = req.getRequestDispatcher("dettagli.jsp");
	dispatcher.forward(req, resp);

	
	}


	}

