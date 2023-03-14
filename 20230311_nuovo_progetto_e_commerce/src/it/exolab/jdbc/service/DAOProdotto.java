package it.exolab.jdbc.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.exolab.jdbc.model.Prodotto;

public class DAOProdotto {
	
	public void insertOrdine(Prodotto prodotto) throws ClassNotFoundException, SQLException {

		String query = "INSERT INTO PRODOTTI(PRODOTTO_ID, DESCRIZIONE, QUANTITA, PREZZO, COLLOCAZIONE)"
				+ "values(?,?,?,?,?)";
		PreparedStatement stmt = DAOService.getInstance().getConnection().prepareStatement(query);
		stmt.setString(1, prodotto.getProdottoId());
		stmt.setString(2, prodotto.getDescrizione());
		stmt.setInt(3, prodotto.getQuantita());
		stmt.setDouble(4, prodotto.getPrezzo());
		stmt.setString(5, prodotto.getCollocazione());
		stmt.execute();
		DAOService.getInstance().closeConnection();
	}

	public List<Prodotto> findAllProdotti() throws ClassNotFoundException, SQLException {
		List<Prodotto> listaProdotti = new ArrayList<Prodotto>();
		String query = "SELECT * FROM PRODOTTI";

		// creo lo statement che contiene la query e la connessione

		PreparedStatement stmt = DAOService.getInstance().getConnection().prepareStatement(query);

		// lancio la query

		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			String prodottoId = rs.getString("PRODOTTO_ID");
			String descrizione = rs.getString("DESCRIZIONE");
			int quantita = rs.getInt("QUANTITA");
			double prezzo = rs.getDouble("PREZZO");
			String collocazione = rs.getString("COLLOCAZIONE");
			Prodotto prodotto = new Prodotto(prodottoId, descrizione, quantita, prezzo, collocazione);
			listaProdotti.add(prodotto);
		}
		DAOService.getInstance().closeConnection();
		return listaProdotti;
	}
	
	public boolean eliminaProdotto(String codiceProdotto) throws ClassNotFoundException, SQLException{
		
		String query = "SELECT COUNT(*) PRODOTTO_ID FROM PRODOTTI WHERE PRODOTTO_ID = " + codiceProdotto;
		PreparedStatement stmt = DAOService.getInstance().getConnection().prepareStatement(query);	
		ResultSet rs = stmt.executeQuery(query);
		int count = rs.getInt("count");
		if ( count == 0 ) {
			return false;
		}
		else {
			query = "DELETE FROM PRODOTTI WHERE PRODOTTO_ID = " + codiceProdotto;
			stmt = DAOService.getInstance().getConnection().prepareStatement(query);
			return true;
		}
	}
	
	public void aggiornaQuantita(String codiceProdotto, int quantitaDaSottrarre) throws ClassNotFoundException, SQLException {
		
		String query = "SELECT QUANTITA FROM PRODOTTI WHERE PRODOTTO_ID = '" + codiceProdotto + "'";
		PreparedStatement stmt = DAOService.getInstance().getConnection().prepareStatement(query);	
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			int quantita = rs.getInt("QUANTITA");
			
		query = "UPDATE PRODOTTI SET QUANTITA = " + (quantita - quantitaDaSottrarre) + "WHERE PRODOTTO_ID = '" + codiceProdotto + "'";
		stmt = DAOService.getInstance().getConnection().prepareStatement(query);
		}
		rs = stmt.executeQuery(query);
		DAOService.getInstance().closeConnection();
	}

}
