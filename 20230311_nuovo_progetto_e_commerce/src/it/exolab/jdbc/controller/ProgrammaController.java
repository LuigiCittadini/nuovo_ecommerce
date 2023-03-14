package it.exolab.jdbc.controller;

import java.util.Scanner;

import it.exolab.jdbc.view.ClienteView;
import it.exolab.jdbc.view.ProgrammaView;

public class ProgrammaController {
	
	
	Scanner scanner = new Scanner(System.in);
	ProgrammaView pv = new ProgrammaView();
	ClienteController cc = new ClienteController();
	ClienteView cv = new ClienteView();
	
	public void start() {
	pv.menu();
	int scelta = scanner.nextInt();
	
	while ( scelta < 0 || scelta > 3 ) {
		cv.erroreSceltaMenuCliente();
		scelta = scanner.nextInt();
	} 
	scelta(scelta);	
	}
	
	public void scelta(int scelta) {
		
		switch (scelta) {
		case 1:
			cc.accessoCliente();;
			break;
		case 2: 
			
			break;
		case 3: 
			cc.registrazione();
			break;
		case 0:
			System.exit(0);
			break;
			
		}
	}
	public void sceltaMenuCliente(int scelta) {// serve eccezione 
		switch (scelta) {
		case 1:
			cc.aquisto();
			break;
		case 2:
			cc.visualizzaStatoOrdine();
			break;
		}
	}
	public void apriMenuCliente() {
		cv.menuCliente();
		controllaSceltaMenuCliente();
	}	
	
	public void controllaSceltaMenuCliente() {
		int scelta = scanner.nextInt();		
		while ( scelta < 0 || scelta > 2 ) {
			cv.erroreSceltaMenuCliente();
			scelta = scanner.nextInt();
		}
		sceltaMenuCliente(scelta);		
	}
	
	

}
