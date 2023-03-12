package it.exolab.jdbc.service;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.exolab.jdbc.model.Cliente;

// classe per mandare le query al database, sia in inserimento che in lettura
public class DAOCliente {

	public void insertCliente(Cliente cliente) throws ClassNotFoundException, SQLException {
		String query = "INSERT INTO CLIENTI(CLIENTE_ID, NOME, COGNOME, EMAIL, INDIRIZZO, PASSWORS)"
				+ "values(?,?,?,?,?,?)";
		PreparedStatement stmt = DAOService.getInstance().getConnection().prepareStatement(query);
		stmt.setString(1, cliente.getClienteId());
		stmt.setString(2, cliente.getNome());
		stmt.setString(3, cliente.getCognome());
		stmt.setString(4, cliente.getEmail());
		stmt.setString(5, cliente.getIndirizzo());
		stmt.setString(6, cliente.getPassword());
		stmt.execute();
		DAOService.getInstance().closeConnection();
	}

	public List<Cliente> findAllCliente() throws ClassNotFoundException, SQLException {
		List<Cliente> listaClienti = new ArrayList<Cliente>();
		String query = "SELECT * FROM CLIENTI";
		// creo lo statement che contiene la query e la connessione
		PreparedStatement stmt = DAOService.getInstance().getConnection().prepareStatement(query);
		// lancio la query
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			String cliente_id = rs.getString("CLIENTE_ID");
			String nome = rs.getString("NOME");
			String cognome = rs.getString("COGNOME");
			String email = rs.getString("EMAIL");
			String indirizzo = rs.getString("INDIRIZZO");
			String password = rs.getString("PASSWORD");
			Cliente cliente = new Cliente(cliente_id, nome, cognome, email, indirizzo, password);
			listaClienti.add(cliente);
		}
		return listaClienti;
	}

	public boolean controllaId(String codiceId) throws ClassNotFoundException, SQLException {

		String query = "SELECT CLIENTE_ID FROM CLIENTI WHERE CLIENTE_ID =" + codiceId;
		PreparedStatement stmt = DAOService.getInstance().getConnection().prepareStatement(query);
		ResultSet rs = stmt.executeQuery(query);
		
		if ( rs.getString("CLIENTE_ID").equalsIgnoreCase("") ) {
			return true;
		}
		else {
			return false;
		}
	}
}
