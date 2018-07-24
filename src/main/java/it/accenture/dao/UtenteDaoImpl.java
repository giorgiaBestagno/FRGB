package it.accenture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.accenture.model.Utente;
import it.accenture.utilities.DBUtilityConnection;

public class UtenteDaoImpl implements UtenteDao {

	private Connection connection;
	private PreparedStatement prepared;
	private Statement statement;
	
	public UtenteDaoImpl() {connection = DBUtilityConnection.getConnection();}
	
	public void insertUtente(Utente utente ) {
		String query= "insert into utente (id, nome, cognome, username, password, indirizzo) values"
				+ " (utente_sequence.nextval, ?, ?, ?, ?, ?)";
	try {
			prepared = connection.prepareStatement(query);
			prepared.setString(1, utente.getNome());
			prepared.setString(2, utente.getCognome());
			prepared.setString(3, utente.getUsername());
			prepared.setString(4, utente.getPassword());
			prepared.setString(5, utente.getIndirizzo());
			System.out.println(utente.getNome());
			System.out.println(utente.getCognome());
			System.out.println(utente.getUsername());
			System.out.println(utente.getPassword());
			System.out.println(utente.getIndirizzo());

			
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
		
	/*	try {
			statement= connection.createStatement();
			System.out.println(query);
			int i= statement.executeUpdate(query);
			

		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		
		
	}

	public void updatePassword(String password, int idUtente) {
		String query = "update utente set password=? where id= ?";
		try {
			prepared = connection.prepareStatement(query);
			prepared.setString(1, password);
			prepared.setInt(2, idUtente);
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

	public void updateIndirizzo(String indirizzo, int idUtente) {
		String query = "update utente set indirizzo=? where id = ?";
		try {
		prepared = connection.prepareStatement(query);
		prepared.setString(1, indirizzo);
		prepared.setInt(2, idUtente);
		prepared.executeQuery();
		}catch (SQLException e) {
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
	
	public Utente getUtenteByUsername(String username) {
		Utente utente = null;
		String query = "select * from utente where username = ?";
		ResultSet resultSet = null;
		try {
		prepared = connection.prepareStatement(query);
		prepared.setString(1, username);
		resultSet = prepared.executeQuery();
		if (resultSet.next()) {
			utente = new Utente();
			utente.setIdUtente(resultSet.getInt(1));
			utente.setNome(resultSet.getString(2));
			utente.setCognome(resultSet.getString(3));
			utente.setUsername(resultSet.getString(4));
			utente.setPassword(resultSet.getString(5));
			utente.setIndirizzo(resultSet.getString(6));

		}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
			if (resultSet != null) {
				resultSet.close();
				}
				if(prepared != null) {
					prepared.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		return utente;
		
		}

	public void delete(Utente utente) {
		String query = "delete from utente where id= ?";
		try {
			prepared = connection.prepareStatement(query);
			prepared.setInt(1, utente.getIdUtente());
			prepared.executeQuery();
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
	public void close() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

			public Utente getByUsernameAndPassword(String username, String password) {
			Utente utente = null;
			String query = "select * from utente where username = ? and password = ?";
			
			ResultSet resultSet = null;
			try {
				prepared = connection.prepareStatement(query);
				prepared.setString(1, username);
				prepared.setString(2,password);
				resultSet = prepared.executeQuery();
				
				if(resultSet.next()){
					utente = new Utente();
					utente.setIdUtente(resultSet.getInt(1));
					utente.setNome(resultSet.getString(2));
					utente.setCognome(resultSet.getString(3));
					utente.setUsername(username);
					utente.setPassword(password); 
					utente.setIndirizzo(resultSet.getString(6));

				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				
				try{
					if (resultSet != null){
						resultSet.close();
					
				}if (prepared!= null){
					prepared.close();
				}
			}catch (SQLException e){
				e.printStackTrace();
			}
			}
			return utente;
		}
		
}


	
	
