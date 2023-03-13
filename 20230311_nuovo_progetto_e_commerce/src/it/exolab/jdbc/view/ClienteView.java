package it.exolab.jdbc.view;

import java.util.List;
import java.util.Scanner;

import it.exolab.jdbc.controller.ClienteController;
import it.exolab.jdbc.controller.OrdineController;
import it.exolab.jdbc.model.Cliente;
import it.exolab.jdbc.model.Prodotto;

public class ClienteView {
	
	Scanner scanner = new Scanner(System.in);
	ClienteController cc = new ClienteController();
	
	
	public void messaggioVerificaEmail() {
		
		System.out.println("INSERISCI EMAIL");
		
		if( cc.controllaAccesso(email, password)) {
			System.out.println("ACCESSO ESEGUITO CON SUCCESSO");
			menuClienteBis();
			
		}
		else {
			System.out.println("ACCESSO NON VALIDO");
		}		
	}
	public void messaggioVerificaPassword() {
		System.out.println("INSERISCI PASSWORD");
	}
	
	public void menuClienteBis() {
		System.out.println("1 - ORDINA PRODOTTI");
		System.out.println("2 - VISUALIZZA ORDINE");
		System.out.println("0 - INDIETRO");
		int sceltaBis = scanner.nextInt();
		while ( sceltaBis < 0 || sceltaBis > 2 ) {
			System.out.println("SCELTA ERRATA. DIGITA UNA SCELTA CORRETTA");
			sceltaBis = scanner.nextInt();
		}
		cc.sceltaMenuCliente(sceltaBis);
		
	}
	
	public void registrazione() {
		System.out.println("INSERISCI LA TUA EMAIL");
		String email = scanner.nextLine();
		if ( cc.verificaEmail(email)) {
			System.out.println("INSERISCI NOME");
			String nome = scanner.nextLine();
			System.out.println("INSERISCI COGNOME");
			String cognome = scanner.nextLine();
			System.out.println("INSERISCI INDIRIZZO");
			String indirizzo = scanner.nextLine();
			System.out.println("INSERISCI PASSWORD");
			String password = scanner.nextLine();
			Cliente cliente = new Cliente (null, nome, cognome, email, indirizzo, password);
			cc.insertCliente(cliente);
			System.out.println("ISCRIZIONE AVVENUTA CON SUCCESSO");
		}
		else {
			System.out.println("EMAIL NON VALIDA O GIA UTILIZZATA");
		}		
	}	

	public void scegliProdotto(List<Prodotto> models) {	
		
		OrdineController oc = new OrdineController();
		int i = 0;
		for (Prodotto model : models) {
			System.out.print((++i) + " - ");
			System.out.print(model.getProdottoId() + " ");
			System.out.print(model.getDescrizione() + " ");
			System.out.print(model.getQuantita() + " ");
			System.out.print(model.getPrezzo() + " ");
			System.out.println(model.getCollocazione() + " ");			
		}
		System.out.println("INSERISCI L'INDICE DEL PRODOTTO");
	}
	public void scegliquantità (boolean quantitaCorretta) {	
		if ( quantitaCorretta ) {
			System.out.println("QUANTI NE VUOI AQUISTARE?");			
		}
		else {
			System.out.println("QUANTITA' DISPONIBILE INFERIORE A QUELLA SCELTA.");
			System.out.println("SCEGLI UNA QUANTITA' INFERIORE");
		}
		
	}
	public void rispostaAggiuntaProdotto() {
		System.out.println("VUOI AQUISTARE UN ALTRO PRODOTTO? DIGITA s/n");		
	}

}
