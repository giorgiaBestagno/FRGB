package it.accenture.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.accenture.model.Categoria;
import it.accenture.model.Prodotto;
import it.accenture.utilities.DBUtilityConnection;

public class ProdottoDaoImpl implements ProdottoDao{
	
	private Connection connection;
	private Statement statement;
	private PreparedStatement prepared; 
	
	public ProdottoDaoImpl() {
		connection = DBUtilityConnection.getConnection();

	}

	public List<Prodotto> listaProdottiDisponibili() {
		
		List<Prodotto> listaProdotti = new ArrayList<>();
		String query = "select * from prodotto where quantita_disponibile > 0";
		ResultSet resultSet = null;
		
		try {
			statement=connection.createStatement();
			resultSet= statement.executeQuery(query);
			
			
			while(resultSet.next()){
				Prodotto prodotto = new Prodotto();
				prodotto.setIdProdotto(resultSet.getInt(1));
				prodotto.setNome(resultSet.getString(2));
				prodotto.setCategoria(Categoria.valueOf(resultSet.getString(3)));
				prodotto.setMarca(resultSet.getString(4));
				prodotto.setPrezzo(resultSet.getDouble(5));
				prodotto.setOfferta(resultSet.getBoolean(6));
				prodotto.setSconto(resultSet.getInt(7));
				prodotto.setQuantitaDisponibile(resultSet.getInt(8));
				prodotto.setImmagine(resultSet.getString(9));
				listaProdotti.add(prodotto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try{
				if(resultSet != null){
					resultSet.close();
				}
				if (statement != null){
					statement.close();
				}
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		
		return listaProdotti;
	}
	public Prodotto getProdottoById(int idProdotto) {
		Prodotto prodotto = new Prodotto();
		String query ="select * from prodotto where id=? ";
		ResultSet resultSet= null;
		try {
			prepared= connection.prepareStatement(query);
			prepared.setInt(1, idProdotto);
			resultSet= prepared.executeQuery();
			
			while(resultSet.next()){
				prodotto.setIdProdotto(resultSet.getInt(1));
				prodotto.setNome(resultSet.getString(2));
				prodotto.setCategoria(Categoria.valueOf(resultSet.getString(3)));
				prodotto.setMarca(resultSet.getString(4));
				prodotto.setPrezzo(resultSet.getDouble(5));
				prodotto.setOfferta(resultSet.getBoolean(6));
				prodotto.setSconto(resultSet.getInt(7));
				prodotto.setQuantitaDisponibile(resultSet.getInt(8));
				prodotto.setImmagine(resultSet.getString(9));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try{
				if(resultSet != null){
					resultSet.close();
				}
				if (prepared != null){
					prepared.close();
				}
			}catch (SQLException e){
				e.printStackTrace();
			}
		}

		return prodotto;
	
	}
	

	public List<Prodotto> listaProdottiNomiSimili(String ricerca) {
		
		List<Prodotto> listaProdotti = new ArrayList<>();
		String query = "select * from prodotto where quantita_disponibile > 0 and nome like '%"
				+ ricerca + 
				"%'";
		ResultSet resultSet = null;
		
		try {
			statement=connection.createStatement();
			resultSet= statement.executeQuery(query);
			
			
			while(resultSet.next()){
				Prodotto prodotto = new Prodotto();
				prodotto.setIdProdotto(resultSet.getInt(1));
				prodotto.setNome(resultSet.getString(2));
				prodotto.setCategoria(Categoria.valueOf(resultSet.getString(3)));
				prodotto.setMarca(resultSet.getString(4));
				prodotto.setPrezzo(resultSet.getDouble(5));
				prodotto.setOfferta(resultSet.getBoolean(6));
				prodotto.setSconto(resultSet.getInt(7));
				prodotto.setQuantitaDisponibile(resultSet.getInt(8));
				prodotto.setImmagine(resultSet.getString(9));
				listaProdotti.add(prodotto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try{
				if(resultSet != null){
					resultSet.close();
				}
				if (statement != null){
					statement.close();
				}
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		
		return listaProdotti;
	}
	

	public List<Prodotto> listaProdottiInOfferta() {
		List<Prodotto> listaProdottiOfferta = new ArrayList<>();
		String query = "select * from prodotto where offerta <> 0 and quantita_disponibile >0 ";
		ResultSet resultSet = null;
		try {
			statement=connection.createStatement();
			resultSet= statement.executeQuery(query);
				
			while(resultSet.next()){
				Prodotto prodotto = new Prodotto();
				prodotto.setIdProdotto(resultSet.getInt(1));
				prodotto.setNome(resultSet.getString(2));
				prodotto.setCategoria(Categoria.valueOf(resultSet.getString(3)));
				prodotto.setMarca(resultSet.getString(4));
				prodotto.setPrezzo(resultSet.getDouble(5));
				prodotto.setOfferta(resultSet.getBoolean(6));
				prodotto.setSconto(resultSet.getInt(7));
				prodotto.setQuantitaDisponibile(resultSet.getInt(8));
				prodotto.setImmagine(resultSet.getString(9));
				listaProdottiOfferta.add(prodotto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try{
				if(resultSet != null){
					resultSet.close();
				}
				if (statement != null){
					statement.close();
				}
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		
		return listaProdottiOfferta;
	}	

	public List<Prodotto> listaProdottiPerCategoria(String categoria) {
		List<Prodotto> listaProdottiPerCategoria = new ArrayList<>();
		String query = "select * from prodotto where categoria = ? and quantita_disponibile> 0";
		ResultSet resultSet = null;
		try {
			prepared=connection.prepareStatement(query);
			prepared.setString(1, categoria);
			resultSet= prepared.executeQuery();
			while(resultSet.next()){
				Prodotto prodotto = new Prodotto();
				prodotto.setIdProdotto(resultSet.getInt(1));
				prodotto.setNome(resultSet.getString(2));
				prodotto.setCategoria(Categoria.valueOf(resultSet.getString(3)));
				prodotto.setMarca(resultSet.getString(4));
				prodotto.setPrezzo(resultSet.getDouble(5));
				prodotto.setOfferta(resultSet.getBoolean(6));
				prodotto.setSconto(resultSet.getInt(7));
				prodotto.setQuantitaDisponibile(resultSet.getInt(8));
				prodotto.setImmagine(resultSet.getString(9));
				listaProdottiPerCategoria.add(prodotto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try{
				if(resultSet != null){
					resultSet.close();
				}
				if (prepared != null){
					prepared.close();
				}
			}catch (SQLException e){
				e.printStackTrace();
			}
		}

		return listaProdottiPerCategoria;
	}

	public Prodotto dettaglioProdotto(int idProdotto) {
		Prodotto prodotto = new Prodotto();
		String query ="select * from prodotto where id=? ";
		ResultSet resultSet= null;
		try {
			prepared= connection.prepareStatement(query);
			prepared.setInt(1, idProdotto);
			resultSet= prepared.executeQuery();
			
			while(resultSet.next()){
				prodotto.setIdProdotto(resultSet.getInt(1));
				prodotto.setNome(resultSet.getString(2));
				prodotto.setCategoria(Categoria.valueOf(resultSet.getString(3)));
				prodotto.setMarca(resultSet.getString(4));
				prodotto.setPrezzo(resultSet.getDouble(5));
				prodotto.setOfferta(resultSet.getBoolean(6));
				prodotto.setSconto(resultSet.getInt(7));
				prodotto.setQuantitaDisponibile(resultSet.getInt(8));
				prodotto.setImmagine(resultSet.getString(9));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try{
				if(resultSet != null){
					resultSet.close();
				}
				if (prepared != null){
					prepared.close();
				}
			}catch (SQLException e){
				e.printStackTrace();
			}
		}

		return prodotto;
	
	}
	
	@Override
	public void updateQuantita(int idProdotto, int quantitaDisponibile) {
		
		String query ="update prodotto set quantita_disponibile = ? where id=?";
		try {
			prepared= connection.prepareStatement(query);
			prepared.setInt(1, quantitaDisponibile);
			prepared.setInt(2, idProdotto);
			prepared.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
		if (prepared != null){
			try {
				prepared.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		}
	}

	@Override
	public List<Prodotto> getByCount() {
		ResultSet rs = null;
		List<Prodotto> listaPiuVenduti = new ArrayList<>();
		String query = " select * from prodotto where id in (select "
				+ "id_prodotto from acquisto group by id_prodotto order by "
				+ "count(quantita_acquistata) desc fetch first 3 rows only)";
		
		try {
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			while(rs.next()){
				Prodotto prodotto = new Prodotto();
				
				prodotto.setIdProdotto(rs.getInt(1));
				prodotto.setNome(rs.getString(2));
				prodotto.setCategoria(Categoria.valueOf(rs.getString(3)));
				prodotto.setMarca(rs.getString(4));
				prodotto.setPrezzo(rs.getDouble(5));
				prodotto.setOfferta(rs.getBoolean(6));
				prodotto.setSconto(rs.getInt(7));
				prodotto.setQuantitaDisponibile(rs.getInt(8));
				prodotto.setImmagine(rs.getString(9));
				listaPiuVenduti.add(prodotto);
				
			}
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
			
		if(rs != null){
			rs.close();
		}
		if(statement != null){
			statement.close();
		}
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		}
		return listaPiuVenduti;
	}
	


	
	


	public void close() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	

}
