package it.exolab.jdbc.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.exolab.jdbc.controller.OrdineController;
import it.exolab.jdbc.model.OrdineModel;
import it.exolab.jdbc.model.Stato;

public class DAOOrdine {
	
	OrdineController oc = new OrdineController();
	
	public void insertOrdine(OrdineModel ordine) throws ClassNotFoundException, SQLException{
		String query = "insert into clienti(cliente_id, prodotto_id, stato, num_ordine, quantita) "
				+ "values(?,?,?,?,?)";
		PreparedStatement stmt = Service.getInstance().getConnection().prepareStatement(query);
		stmt.setString(1, ordine.getClienteId());
		stmt.setString(2, ordine.getProdottoId());
		stmt.setString(3, ordine.getStato().name());
		stmt.setInt(4, ordine.getNumOrdine());
		stmt.setInt(5, ordine.getQuantita());
		stmt.execute();
		Service.getInstance().closeConnection();
	}
	public List<OrdineModel> findAllOrdini() throws ClassNotFoundException, SQLException{
		List<OrdineModel> lcm = new ArrayList <OrdineModel>();
		String query = "select * from clienti";
		// creo lo statement che contiene la query e la connessione
		PreparedStatement stmt = Service.getInstance().getConnection().prepareStatement(query);
		// lancio la query
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next())  {
			String cliente_id = rs.getString("cliente_id");
			String prodotto_id = rs.getString("prodotto_id");
			String stato = rs.getString("stato");
			Stato st = oc.convertiStatoOrdine(stato);			
			int num_ordine = rs.getInt("num_ordine");
			int quantita = rs.getInt("quantita");
			OrdineModel clienteM = new OrdineModel(num_ordine, cliente_id, prodotto_id, st, quantita);
			lcm.add(clienteM);
		}
		return lcm;
}
}
