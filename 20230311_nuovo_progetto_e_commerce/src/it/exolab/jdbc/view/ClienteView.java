package it.exolab.jdbc.view;

import java.util.List;
import java.util.Scanner;

import it.exolab.jdbc.controller.ClienteController;
import it.exolab.jdbc.controller.OrdineController;
import it.exolab.jdbc.model.Cliente;
import it.exolab.jdbc.model.Ordine;
import it.exolab.jdbc.model.Prodotto;

public class ClienteView {
	
	Scanner scanner = new Scanner(System.in);
	
	
	
	public void messaggioVerificaEmail() {
		
		System.out.println("INSERISCI EMAIL");
				
	}
	public void messaggioVerificaPassword() {
		System.out.println("INSERISCI PASSWORD");
	}
	public void messaggioCredenzialiErrate() {
		System.out.println("ACCESSO NON VALIDO");
	}
	public void messaggioCredenzialiEsatte() {
		System.out.println("ACCESSO ESEGUITO CON SUCCESSO");
	}
	
	public void menuCliente() {
		System.out.println("1 - ORDINA PRODOTTI");
		System.out.println("2 - VISUALIZZA ORDINE");
		System.out.println("0 - INDIETRO");		
	}
	
	public void erroreSceltaMenuCliente(){
		System.out.println("SCELTA ERRATA. DIGITA UNA SCELTA CORRETTA");
	}
	
	// form registrazione:
	
	public void inserisciEmail() {
		System.out.println("INSERISCI LA TUA EMAIL");
	}
	public void inserisciNome() {
		System.out.println("INSERISCI NOME");
	}
	public void inserisciCognome() {
		System.out.println("INSERISCI COGNOME");
	}
	public void inserisciIndirizzo() {
		System.out.println("INSERISCI INDIRIZZO");
	}
	public void inserisciPassword() {
		System.out.println("INSERISCI PASSWORD");
	}
	public void esitoIscrizionePositivo() {
		System.out.println("ISCRIZIONE AVVENUTA CON SUCCESSO");
	}
	public void esitoIscrizioneNegativo() {
		System.out.println("EMAIL NON VALIDA O GIA UTILIZZATA");
	}
		

	public void scegliProdotto(List<Prodotto> models) {	
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
	
public void stampaOrdini(List<Ordine> models) {
		for (Ordine model : models) {
			System.out.print("ORDINE: ");
			System.out.print(model.getNumOrdine() + "  -  STATO: ");
			System.out.println(model.getStato() + " ");			
		}		
	}

}
