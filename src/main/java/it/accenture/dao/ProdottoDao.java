package it.accenture.dao;

import java.util.List;

import it.accenture.model.Categoria;
import it.accenture.model.Prodotto;

public interface ProdottoDao {

	
	public List<Prodotto> listaProdottiDisponibili(int quantitaDisponibile);
	public List<Prodotto> listaProdottiInOfferta();
	public List<Prodotto> listaProdottiPerCategoria(String categoria);
	public Prodotto dettaglioProdotto(int idProdotto);
	public void close();
}
