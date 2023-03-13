package it.exolab.jdbc.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import it.exolab.jdbc.model.OggettiOrdine;
import it.exolab.jdbc.service.DAOOggettiOrdine;

public class OggettiOrdineController {
	
	public void salvaLista(ArrayList<OggettiOrdine> lista) {
		
		DAOOggettiOrdine oggettiOrdineDAO = new DAOOggettiOrdine();
		try {
			oggettiOrdineDAO.insertOggettiOrdine(lista);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		};
		
	}

}
