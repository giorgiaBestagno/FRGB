package it.accenture.dao;

import java.util.List;

import it.accenture.model.Acquisto;
import it.accenture.model.Prodotto;
import it.accenture.model.Utente;

public interface AcquistoDao {
	
	
	
	
	public void insertAcquisto (Acquisto acquisto);
	
	public List<Acquisto> getAll(int idUtente);
	
	public List<Acquisto> getElementByDataFine(int idUtente);
	
	public void close();	
}
