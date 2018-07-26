package it.accenture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.accenture.controller.Recensioni;
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
			String query = "update recensione set contenuto = ? where id=?";
				
			try {
				prepared = connection.prepareStatement(query);
				prepared.setString(1, contenuto);
				prepared.setInt(2, idRecensione);
				
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
		@Override
		public List<Recensione> getAllRecensioni(int idProdotto) {
			
			String query = "select * from recensione where id_prodotto = ?";
			List<Recensione> listaRecensioni = new ArrayList<>();
			ResultSet rs = null;
			try {
				prepared = connection.prepareStatement(query);
				
				prepared.setInt(1, idProdotto);

				rs = prepared.executeQuery();
				
				while(rs.next()){
					Recensione recensione = new Recensione();
					
					recensione.setIdRecensione(rs.getInt(1));
					recensione.setTitolo(rs.getString(2));
					recensione.setContenuto(rs.getString(3));
					recensione.setIdUtente(rs.getInt(4));
					recensione.setIdProdotto(rs.getInt(5));
					listaRecensioni.add(recensione);
					
				}

			} catch (SQLException e) {
		
				e.printStackTrace();
			} finally {
				try {
			
				if (prepared != null) {
					
						prepared.close();
				} 
				if (rs != null){
					rs.close();
				}
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
			
			
			return listaRecensioni;
		}
		@Override
		public List<Recensione> getAllRecensioni(int idUtente, int idProdotto) {
			
			String query = "select * from recensione where id_utente = ? and id_prodotto = ?";
			List<Recensione> listaRecensioni = new ArrayList<>();
			ResultSet rs = null;
			try {
				prepared = connection.prepareStatement(query);
				prepared.setInt(1, idUtente);
				prepared.setInt(2, idProdotto);

				rs = prepared.executeQuery();
				
				while(rs.next()){
					Recensione recensione = new Recensione();
					
					recensione.setIdRecensione(rs.getInt(1));
					recensione.setTitolo(rs.getString(2));
					recensione.setContenuto(rs.getString(3));
					recensione.setIdUtente(rs.getInt(4));
					recensione.setIdProdotto(rs.getInt(5));
					listaRecensioni.add(recensione);
					
				}

			} catch (SQLException e) {
		
				e.printStackTrace();
			} finally {
				try {
			
				if (prepared != null) {
					
						prepared.close();
				} 
				if (rs != null){
					rs.close();
				}
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
			
			
			return listaRecensioni;
		}
		
	
		@Override
		public Recensione getRecensioneByIdUtente(int idProdotto, int idUtente) {

			String query = "select * from recensione where id_prodotto = ? and id_utente = ?";
			Recensione recensione = new Recensione();
			ResultSet rs = null;

			
			try {
				prepared = connection.prepareStatement(query);
				prepared.setInt(1, idProdotto);
				prepared.setInt(2, idUtente);

				rs = prepared.executeQuery();
			
				
				
				if(rs.next()){
					
					recensione.setIdRecensione(rs.getInt(1));
					recensione.setTitolo(rs.getString(2));
					recensione.setContenuto(rs.getString(3));
					recensione.setIdUtente(rs.getInt(4));
					recensione.setIdProdotto(rs.getInt(5));
					
				}
				

			
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				
					try {
						if (rs != null) {
							rs.close();
						}
						if(prepared != null){
						prepared.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			
	
			return recensione;
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

	



