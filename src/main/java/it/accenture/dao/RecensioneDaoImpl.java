package it.accenture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.accenture.model.Prodotto;
import it.accenture.model.Recensione;
import it.accenture.utilities.DBUtilityConnection;

public class RecensioneDaoImpl implements RecensioneDao {

	private Connection connection;
	private Statement statement;
	private PreparedStatement prepared;
	
	public RecensioneDaoImpl() {
		connection = DBUtilityConnection.getConnection();
		
	}

		public void insertRecensione (Recensione recensione) {
			String query= "insert into recensione values (recensione_sequence.nextval, ?, ?, ?, ?)";
			try {
				prepared = connection.prepareStatement(query);
				prepared.setString(1, recensione.getTitolo());
				prepared.setString(2, recensione.getContenuto());
				prepared.setInt(3, recensione.getIdUtente());
				prepared.setInt(4, recensione.getIdProdotto());
				prepared.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if (prepared != null) {
					try {
						prepared.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		
		
		public void updateRecensione(int idRecensione, String contenuto) {
			String query = "update recensione set contenuto where id=?";
				
			try {
				prepared = connection.prepareStatement(query);
				prepared.setInt(1, idRecensione);
				
				prepared.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (prepared != null) {
					try {
						prepared.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			
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



