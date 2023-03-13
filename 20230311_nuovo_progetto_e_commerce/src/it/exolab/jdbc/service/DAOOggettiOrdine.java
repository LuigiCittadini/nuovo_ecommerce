package it.exolab.jdbc.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.exolab.jdbc.model.OggettiOrdine;

public class DAOOggettiOrdine {

	public void insertOggettiOrdine(OggettiOrdine oggettoOrdine) throws ClassNotFoundException, SQLException {

		String query = "INSERT INTO OGGETTI_ORDINE(NUM_ORDINE, OGGETTO#, PRODOTTO_ID, NUM_PRODOTTI, COSTO_TOT)" + "values(?,?,?,?,?)";
		PreparedStatement stmt = DAOService.getInstance().getConnection().prepareStatement(query);
		stmt.setInt(1, oggettoOrdine.getNumeroOrdine());
		stmt.setInt(2, oggettoOrdine.getNumerooOggetto());
		stmt.setString(3, oggettoOrdine.getProdottoId());
		stmt.setInt(4, oggettoOrdine.getNumeroProdotti());
		stmt.setDouble(5, oggettoOrdine.getCostoTotale());
		stmt.execute();
		DAOService.getInstance().closeConnection();
	}
	
	public List<OggettiOrdine> findAllOggettiOrdine() throws ClassNotFoundException, SQLException {
		List<OggettiOrdine> listaOrdini = new ArrayList<OggettiOrdine>();
		String query = "SELEC * FROM OGGETTI_ORDINE";

		// creo lo statement che contiene la query e la connessione

		PreparedStatement stmt = DAOService.getInstance().getConnection().prepareStatement(query);

		// lancio la query

		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			int numOrdine = rs.getInt("NUM_ORDINE");
			int numOggetto = rs.getInt("OGGETTO#");
			String prodottoId = rs.getString("PRODOTTO_ID");
			int numProdotti = rs.getInt("NUM_PRODOTTI");
			double costoTot = rs.getDouble("COSTO_TOT");
			OggettiOrdine oggettiOrdine = new OggettiOrdine(numOrdine, numOggetto, prodottoId, numProdotti,costoTot);
			listaOrdini.add(oggettiOrdine);
		}
		return listaOrdini;
	}

}
