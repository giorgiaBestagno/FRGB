package it.accenture.dao;

import java.util.List;

import it.accenture.model.Acquisto;
import it.accenture.model.Prodotto;
import it.accenture.model.Utente;

public interface AcquistoDao {
	
	
	
	
	public Acquisto insertAcquisto (int idProdotto);
	
	public List<Acquisto> getAll();
	
	public List<Acquisto> getElementByDataFine();
	
	public void close();	
}
