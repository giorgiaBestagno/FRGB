package it.accenture.dao;

import java.util.List;

import it.accenture.model.Prodotto;
import it.accenture.model.Recensione;

public interface RecensioneDao {
	

	public void insertRecensione (Recensione recensione);
		
	public void updateRecensione (int idRecensione, String contenuto);
	
	public List<Recensione> getAllRecensioni(int idProdotto);
	
	public Recensione getRecensioneByIdUtente(int idProdotto, int idUtente);

	public void close ();
	
	

}


