package it.accenture.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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
	
	public AcquistoDaoImpl(){
		connection = DBUtilityConnection.getConnection();
		if (connection == null){
			System.out.println("connection è null");
		}
	}
	
public void insertAcquisto (Acquisto acquisto){
		
		String query = "insert into acquisto values (acquisto_sequence.nextval,?, ?,?,?,?, ?, ?)";
			try {
		prepared = connection.prepareStatement(query);
		prepared.setString(3,acquisto.getSpedizione().toString());
		Date dataInizio = Date.valueOf(LocalDate.now());
		prepared.setDate(4, dataInizio);
		Date dataFine = Date.valueOf(acquisto.getDataFine());
		prepared.setDate(5, dataFine);
		prepared.setDouble(6, acquisto.getSpedizione().getCosto());
		prepared.setInt(7, acquisto.getQuantitaAcquistata());
		prepared.setInt(1, acquisto.getIdUtente());
		prepared.setInt(2, acquisto.getIdProdotto());
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
			
		
	}
	


	public List<Acquisto> getAll(int idUtente) {
		String query = "select * from acquisto where id_utente= " + idUtente;
		List<Acquisto> listaAcquisti = new ArrayList<>();
		ResultSet rs = null;
		
		try {
		
			statement = connection.createStatement();
			rs= statement.executeQuery(query);			
			while (rs.next()){
				Acquisto acquisto = new Acquisto(null, null, null, idUtente, idUtente, idUtente);
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
			if (statement != null){
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
		return listaAcquisti;
		
	
		
	}

	public List<Acquisto> getElementByDataFine(int idUtente) {
		String query = "select * from acquisto where data_fine = null and id_utente= " + idUtente;		
		List<Acquisto> listaOrdini = new ArrayList<>();
		ResultSet rs = null;
		
		try {
			statement = connection.createStatement();
			rs= statement.executeQuery(query);			
			while (rs.next()){
				Acquisto acquisto = new Acquisto(null, null, null, idUtente, idUtente, idUtente);
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
			if (statement != null){
				try {
					statement.close();
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
