package it.exolab.jdbc.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import it.exolab.jdbc.model.Cliente;
import it.exolab.jdbc.model.Prodotto;
import it.exolab.jdbc.service.DAOCliente;
import it.exolab.jdbc.service.DAOProdotto;
import it.exolab.jdbc.view.ClienteView;

public class ClienteController {
	
	Scanner scanner = new Scanner(System.in);
	
	DAOCliente clienteDAO = new DAOCliente();
	
	public void insertCliente(Cliente cliente) {

		//questo metodo inserisce un cliente nel database e da un codice id casuale ad esso
		
		String codiceId;
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
			}while( clienteDAO.controllaId(codiceId) );
			cliente.setClienteId(codiceId);
			clienteDAO.insertCliente(cliente);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public boolean controllaAccesso(String email, String password) {
		try {
			return clienteDAO.controllaAccesso(email, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean verificaEmail(String email) {
		
		if ( email.contains("@") &&
				email.indexOf('@') == email.lastIndexOf('@')  &&
				email.substring(0, email.indexOf('@')).length() - 1 > 0  && 				
				email.substring(email.indexOf('@')).indexOf('.') > 0 ){
			return true;			
		}
		else {
			return false;
		}		
	}
	public void sceltaMenuCliente(int scelta) {// serve eccezione 
		switch (scelta) {
		case 1:
			aquisto();
			break;
		}
		
	}

	private void aquisto() {
		try {
			String risposta = "";
			ClienteView cv = new ClienteView();
			OrdineController oc = new OrdineController();
			DAOProdotto prodottoDAO = new DAOProdotto(); 
		do {
			List<Prodotto> lista = prodottoDAO.findAllProdotti();
			cv.scegliProdotto(lista);
			int indice = scanner.nextInt();
			int quantita = -1;				
			boolean corretto = true;
			while ( quantita > lista.get(indice - 1).getQuantita() || quantita == -1) {
				cv.scegliquantità(corretto);
				quantita = scanner.nextInt();
				corretto = false;
			}
			scanner.nextLine();
			oc.insertOggetti(lista.get(indice - 1), quantita);
			cv.rispostaAggiuntaProdotto();
			risposta = scanner.nextLine();
		}while ( risposta.equalsIgnoreCase("s") );
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
