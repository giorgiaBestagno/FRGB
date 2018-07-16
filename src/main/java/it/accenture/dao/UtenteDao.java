package it.accenture.dao;

import it.accenture.model.Utente;

public interface UtenteDao {

	public void insertUtente(Utente utente);
	public void updatePassword(String password, int idUtente);
	public void updateIndirizzo(String password, int idUtente);
	public Utente getUtenteByUsername(String username);
	public void delete(Utente utente);
	public void close();
	
}

	
