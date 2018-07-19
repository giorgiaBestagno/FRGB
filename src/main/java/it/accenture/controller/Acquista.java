package it.accenture.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.accenture.dao.AcquistoDaoImpl;
import it.accenture.dao.ProdottoDaoImpl;
import it.accenture.model.Acquisto;
import it.accenture.model.Prodotto;
import it.accenture.model.Spedizione;
import it.accenture.model.Utente;

public class Acquista extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idProdotto = Integer.parseInt(req.getParameter("idProdotto"));
		ProdottoDaoImpl prodottoService = new ProdottoDaoImpl();		
		Prodotto prodotto = prodottoService.getProdottoById(idProdotto);
		prodottoService.close();
		req.setAttribute("prodotto", prodotto);
		System.out.println(prodotto);
		RequestDispatcher dispatcher = req.getRequestDispatcher("acquista.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AcquistoDaoImpl acquistoService = new AcquistoDaoImpl();
		HttpSession sessione = req.getSession();
		Prodotto prodotto = (Prodotto) sessione.getAttribute("prodotto");
		Utente utente = (Utente) sessione.getAttribute("utenteLoggato");
		int idUtente = utente.getIdUtente();
		LocalDate dataInizio = LocalDate.now();
		int idProdotto = Integer.parseInt(req.getParameter("idProdotto"));
		int quantita =  Integer.parseInt(req.getParameter("quantita"));
		String spedizioneString = req.getParameter("spedizione");
		Spedizione spedizione = Spedizione.valueOf(spedizioneString);
		LocalDate dataFine = null;
		if(spedizioneString.equals("STANDARD") ){
			 dataFine = LocalDate.now().plusDays(5);
			}else if(spedizioneString.equals("EXPRESS")){
				 dataFine = LocalDate.now().plusDays(3);
			}else{
				 dataFine = LocalDate.now().plusDays(1);
			}
		
		String pagamento = req.getParameter("pagamento");
		Acquisto acquisto = new Acquisto(spedizione, dataInizio, dataFine, quantita, idUtente, idProdotto);
		acquistoService.insertAcquisto(acquisto);
		System.out.println(acquisto);
		req.setAttribute("acquisto", acquisto);
		RequestDispatcher dispatcher = req.getRequestDispatcher("successo.jsp");
		dispatcher.forward(req, resp);
		
		
		
	}

}
