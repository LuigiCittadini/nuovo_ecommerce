package it.exolab.jdbc.controller;

import java.sql.SQLException;

import it.exolab.jdbc.service.DAOProdotto;

public class ProdottoController {
	
	public void visualizzaProdotti(){
		DAOProdotto prodottoDAO = new DAOProdotto();
		try {
			prodottoDAO.findAllProdotti();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
