package it.exolab.jdbc.controller;

import it.exolab.jdbc.model.Stato;

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
}
