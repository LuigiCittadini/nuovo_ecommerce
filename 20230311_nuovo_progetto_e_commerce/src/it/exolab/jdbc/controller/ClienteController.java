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
	ClienteView cv = new ClienteView();
	static Cliente cliente = null;


	
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
	
	
	public boolean verificaEmail(String email) {
		
		if ( email.contains("@") &&
				email.indexOf('@') == email.lastIndexOf('@')  &&
				email.substring(0, email.indexOf('@')).length() - 1 > 0  && 				
				email.substring(email.indexOf('@')).indexOf('.') > 0 &&
				email.substring(email.lastIndexOf('.')).length() > 1){
			return true;			
		}
		else {
			return false;
		}		
	}
	
	public void registrazione() {
		cv.inserisciEmail();
		String email = scanner.nextLine();
		if ( verificaEmail(email)) {
			cv.inserisciNome();
			String nome = scanner.nextLine();
			cv.inserisciCognome();
			String cognome = scanner.nextLine();
			cv.inserisciIndirizzo();
			String indirizzo = scanner.nextLine();
			cv.inserisciPassword();
			String password = scanner.nextLine();
			Cliente cliente = new Cliente (null, nome, cognome, email, indirizzo, password);
			insertCliente(cliente);
			cv.esitoIscrizionePositivo();
		}
		else {
			cv.esitoIscrizioneNegativo();
		}		
	}	

	public void aquisto() {
		try {
			String risposta = "";
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
			prodottoDAO.aggiornaQuantita(lista.get(indice - 1).getProdottoId(), quantita);
			cv.rispostaAggiuntaProdotto();
			risposta = scanner.nextLine();
		}while ( risposta.equalsIgnoreCase("s") );
		oc.insertOrdine(cliente);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private boolean logIn(String email, String password) {
		try {
			return clienteDAO.controllaAccesso(email, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	

	public void accessoCliente() {
		ProgrammaController pc = new ProgrammaController();
		String email = "";
		String password = "";		
		do {
			cv.messaggioVerificaEmail();
			email = scanner.nextLine();
			cv.messaggioVerificaPassword();
			password = scanner.nextLine();
			if ( !logIn(email, password)) {
				cv.messaggioCredenzialiErrate();
			}
		}while (!logIn(email, password));
		try {
			cliente = clienteDAO.getCliente(email);
			cv.messaggioCredenzialiEsatte();
			pc.apriMenuCliente();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}	
}
