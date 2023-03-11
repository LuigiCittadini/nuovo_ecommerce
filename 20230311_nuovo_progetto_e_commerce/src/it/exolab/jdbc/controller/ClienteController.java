package it.exolab.jdbc.controller;

import java.sql.SQLException;

import it.exolab.jdbc.model.Cliente;
import it.exolab.jdbc.service.DAOCliente;

public class ClienteController {
	
	public void insertCliente(Cliente cliente) {
		
		String codiceId = "";
		DAOCliente clienteDAO = new DAOCliente();
		try {
			do {
				for ( int i = 0; i < 3; i++ ) {
					char primaParte = (char)((Math.random() * 25) + 98);
					codiceId += primaParte;
				}
				for ( int i = 0; i < 3; i++ ) {
					int secondaParte = (int)(Math.random() * 10 );
					codiceId += secondaParte;
				}			
			}while( !clienteDAO.controllaCodiceId(codiceId) );
			cliente.setClienteId(codiceId);
			clienteDAO.insertCliente(cliente);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
}
