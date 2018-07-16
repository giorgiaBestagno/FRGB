package it.accenture.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.accenture.model.Acquisto;
import it.accenture.model.Prodotto;
import it.accenture.model.Spedizione;
import it.accenture.utilities.DBUtilityConnection;

public class AcquistoDaoImpl implements AcquistoDao{
	private Connection connection;
	private Statement statement;
	private PreparedStatement prepared;
	
	public void AcquistoDaoImpl(){
		connection = DBUtilityConnection.getConnection();
	}
	
	
	public Acquisto insertAcquisto (int idProdotto){
		Prodotto prodotto = new Prodotto();
				
		Acquisto acquisto = new Acquisto();
		String query = "insert into acquisto values (acquisto_sequence.nextval, ?,?,?,?)";
			try {
		prepared = connection.prepareStatement(query);
		prepared.setString(1,acquisto.getSpedizione().toString());
		Date dataInizio = Date.valueOf(acquisto.getDataInizio());
		prepared.setDate(2, dataInizio);
		Date dataFine = Date.valueOf(acquisto.getDataFine());
		prepared.setDate(3, dataFine);
		prepared.setInt(4, acquisto.getQuantitaAcquistata());
		prepared.setInt(5, acquisto.getIdUtente());
		prepared.setInt(6, prodotto.getIdProdotto());
		prepared.executeUpdate();
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		if(prepared != null){
			try {
				prepared.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
			return acquisto;
		
	}
	
	
	


	public List<Acquisto> getAll() {
		String query = "select * from acquisto";
		List<Acquisto> listaAcquisti = new ArrayList<>();
		ResultSet rs = null;
		
		try {
			prepared = connection.prepareStatement(query);
			rs = prepared.executeQuery();
			while (rs.next()){
				Acquisto acquisto = new Acquisto();
				acquisto.setIdAcquisto(rs.getInt(1));
				acquisto.setSpedizione(Spedizione.valueOf(rs.getString(2)));
				acquisto.setDataInizio(rs.getDate(3).toLocalDate());
				acquisto.setDataFine(rs.getDate(4).toLocalDate());
				acquisto.setQuantitaAcquistata(rs.getInt(5));
				acquisto.setIdProdotto(rs.getInt(6));
				acquisto.setIdProdotto(rs.getInt(7));
				listaAcquisti.add(acquisto);
			}
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
		
		
		
		return listaAcquisti;
		
	
		
	}

	public List<Acquisto> getElementByDataFine() {
		String query = "select * from acquisto where data_fine = null";		
		List<Acquisto> listaOrdini = new ArrayList<>();
		ResultSet rs = null;
		
		try {
			statement = connection.createStatement();
			rs= statement.executeQuery(query);			
			while (rs.next()){
				Acquisto acquisto = new Acquisto();
				acquisto.setIdAcquisto(rs.getInt(1));
				acquisto.setSpedizione(Spedizione.valueOf(rs.getString(2)));
				acquisto.setDataInizio(rs.getDate(3).toLocalDate());
				acquisto.setDataFine(rs.getDate(4).toLocalDate());
				acquisto.setQuantitaAcquistata(rs.getInt(5));
				acquisto.setIdProdotto(rs.getInt(6));
				acquisto.setIdProdotto(rs.getInt(7));
				listaOrdini.add(acquisto);
			}
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
		
		
		return listaOrdini;
	}

	public void close() {
		if(connection != null){
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}



	

	

	

}
