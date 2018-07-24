package it.accenture.dao;

import java.util.List;

import it.accenture.model.Categoria;
import it.accenture.model.Prodotto;

public interface ProdottoDao {

	
	public List<Prodotto> listaProdottiDisponibili();
	public List<Prodotto> listaProdottiNomiSimili(String ricerca);
	public List<Prodotto> listaProdottiInOfferta();
	public List<Prodotto> listaProdottiPerCategoria(String categoria);
	public Prodotto getProdottoById(int idProdotto);
	public void updateQuantita(int idProdotto, int quantita);
	public Prodotto dettaglioProdotto(int idProdotto);
	public List<Prodotto> getByCount();
	public void close();
}
