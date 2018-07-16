package it.accenture.dao;

import it.accenture.model.Prodotto;
import it.accenture.model.Recensione;

public interface RecensioneDao {
	

	public void insertRecensione (Recensione recensione);
		
	public void updateRecensione (int idRecensione, String contenuto);

	public void close ();
	
	

}


