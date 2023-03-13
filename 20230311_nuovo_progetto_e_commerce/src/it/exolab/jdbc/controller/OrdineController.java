package it.exolab.jdbc.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import it.exolab.jdbc.model.Cliente;
import it.exolab.jdbc.model.OggettiOrdine;
import it.exolab.jdbc.model.Ordine;
import it.exolab.jdbc.model.Prodotto;
import it.exolab.jdbc.model.Stato;
import it.exolab.jdbc.service.DAOOrdine;

public class OrdineController {
	
	
	private ArrayList<OggettiOrdine> lista = new ArrayList<>();
	private int numOrdine;
	private int numOggetto;
	
	private int getNumOrdine() {
		
		if ( numOrdine == 0 ) {
			DAOOrdine ordineDAO = new DAOOrdine();
			try {
				numOrdine = ordineDAO.getUltimoProgressivo();
				if ( Integer.valueOf(numOrdine) == null ) {
					numOrdine = 0;
				}
				numOrdine++;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return numOrdine;
	}
	
	public void insertOggetti ( Prodotto prodotto, int quantita ) {
		OggettiOrdine oggettiOrdine = new OggettiOrdine(getNumOrdine(), numOggetto + 1, prodotto.getProdottoId(),
				quantita, quantita*prodotto.getPrezzo());
		lista.add(oggettiOrdine);
		
	}	
			
	public static Stato convertiStatoOrdine(String stato ) {
		
		switch (stato) {
		case "LAVORAZIONE":
			return Stato.LAVORAZIONE;
		case "REGISTRATO":
			return Stato.REGISTRATO;
		case "SPEDITO":
			return Stato.SPEDITO;
		case "PAGATO":
			return Stato.PAGATO;
		case "ANNULLATO":
			return Stato.ANNULLATO;
		}
		return null;
	}
	
	
	private void salvaOrdine(Ordine ordine) {
		
		//questo metodo inserisce un ordine nel database.
		
		DAOOrdine ordineDAO = new DAOOrdine();
		try {			
			ordineDAO.insertOrdine(ordine);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}	
	
	public void insertOrdine(Cliente cliente) {
		
		// costruisce l' oggetto ordine partendo dalla lista degli oggetti dell' ordine.
		
		double prezzoTot = 0;
		for ( OggettiOrdine oggettiOrdine : lista ) {
			prezzoTot += oggettiOrdine.getCostoTotale(); 
		}
		Ordine ordine = new Ordine(getNumOrdine(), cliente.getClienteId(), Stato.LAVORAZIONE, prezzoTot);
		salvaOrdine(ordine);
	}
	
}
