package it.exolab.jdbc.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.exolab.jdbc.controller.OrdineController;
import it.exolab.jdbc.model.Ordine;
import it.exolab.jdbc.model.Stato;

public class DAOOrdine {
	
	public void insertOrdine(Ordine ordine) throws ClassNotFoundException, SQLException {
		
		String query = "INSERT INTO ORDINI(NUM_ORDINE, CLIENTE_ID, STATO, SALDO)" + "values(?,?,?,?)";
		PreparedStatement stmt = DAOService.getInstance().getConnection().prepareStatement(query);
		stmt.setInt(1, ordine.getNumOrdine());
		stmt.setString(2, ordine.getClienteId());
		stmt.setString(3, ordine.getStato().name());
		stmt.setDouble(4, ordine.getSaldo());
		stmt.execute();
		DAOService.getInstance().closeConnection();
	}

	public List<Ordine> findAllOrdini() throws ClassNotFoundException, SQLException {
		List<Ordine> listaOrdini = new ArrayList<Ordine>();
		String query = "SELEC * FROM ORDINI";

		// creo lo statement che contiene la query e la connessione

		PreparedStatement stmt = DAOService.getInstance().getConnection().prepareStatement(query);

		// lancio la query

		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			int num_ordine = rs.getInt("NUM_ORDINE");
			String cliente_id = rs.getString("CLIENTE_ID");
			String st = rs.getString("STATO");
			Stato stato = OrdineController.convertiStatoOrdine(st); // trasforma la stringa in un enum
			double saldo = rs.getInt("SALDO");
			Ordine ordine = new Ordine(num_ordine, cliente_id, stato, saldo);
			listaOrdini.add(ordine);
		}
		DAOService.getInstance().closeConnection();
		return listaOrdini;
	}	
	
	public int getUltimoProgressivo() throws ClassNotFoundException, SQLException {
	
		// questo metodo ritorna l' ultimo numero ordine inserito
		
		String query = "SELECT MAX(NUM_ORDINE) FROM ORDINI";
		
		PreparedStatement stmt = DAOService.getInstance().getConnection().prepareStatement(query);
		ResultSet rs = stmt.executeQuery(query);
		rs.next();
		DAOService.getInstance().closeConnection();
		return rs.getInt("MAX(NUM_ORDINE)");		
	}	
	
}
