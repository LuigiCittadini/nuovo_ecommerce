package it.exolab.jdbc.controller;

import java.sql.SQLException;

import it.exolab.jdbc.model.Cliente;
import it.exolab.jdbc.service.DAOCliente;

public class ClienteController {
	
	
	public void insertCliente(Cliente cliente) {

		//questo metodo inserisce un cliente nel database e da un codice id casuale ad esso
		
		String codiceId;
		DAOCliente clienteDAO = new DAOCliente();
		try {
			do {
				codiceId = "";
				for ( int i = 0; i < 3; i++ ) {
					char primaParte = (char)((Math.random() * 25) + 98);
					codiceId += primaParte;
				}
				for ( int i = 0; i < 3; i++ ) {
					int secondaParte = (int)(Math.random() * 10 );
					codiceId += secondaParte;
				}			
			}while( !clienteDAO.controllaId(codiceId) );
			cliente.setClienteId(codiceId);
			clienteDAO.insertCliente(cliente);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
}
