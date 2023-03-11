package it.exolab.jdbc.controller;

import java.sql.SQLException;

import it.exolab.jdbc.model.Ordine;
import it.exolab.jdbc.model.Stato;
import it.exolab.jdbc.service.DAOOrdine;

public class OrdineController {
	
	public Stato convertiStatoOrdine(String stato ) {
		
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
	
	public void insertOrdine(Ordine ordine) {
		
		DAOOrdine ordineDAO = new DAOOrdine();
		try {
			int num = ordineDAO.getUltimoProgressivo();
			if ( Integer.valueOf(num) == null ) {
				num = 0;
			}
			num++;
			ordine.setNumOrdine(num);
			ordineDAO.insertOrdine(ordine);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
}
