package it.exolab.jdbc.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.exolab.jdbc.model.ClienteModel;

public class DAOProdotto {
	public void insertCliente(ClienteModel Cliente) throws ClassNotFoundException, SQLException{
		String query = "insert into clienti(cliente_id, nome, cognome, email, indirizzo, password) "
				+ "values(?,?,?,?,?,?)";
		PreparedStatement stmt = Service.getInstance().getConnection().prepareStatement(query);
		stmt.setString(1, Cliente.getClienteId());
		stmt.setString(2, Cliente.getNome());
		stmt.setString(3, Cliente.getCognome());
		stmt.setString(4, Cliente.getEmail());
		stmt.setString(5, Cliente.getIndirizzo());
		stmt.setString(6, Cliente.getPassword());
		stmt.execute();
		Service.getInstance().closeConnection();
	}
	public List<ClienteModel> findAllCliente() throws ClassNotFoundException, SQLException{
		List<ClienteModel> lcm = new ArrayList <ClienteModel>();
		String query = "select * from clienti";
		// creo lo statement che contiene la query e la connessione
		PreparedStatement stmt = Service.getInstance().getConnection().prepareStatement(query);
		// lancio la query
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next())  {
			String cliente_id = rs.getString("cliente_id");
			String nome = rs.getString("nome");
			String cognome = rs.getString("cognome");
			String email = rs.getString("email");
			String indirizzo = rs.getString("indirizzo");
			String password = rs.getString("password");
			ClienteModel clienteM = new ClienteModel(cliente_id, nome, cognome, email, indirizzo, password);
			lcm.add(clienteM);
		}
		return lcm;
}
