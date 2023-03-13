package it.exolab.jdbc.controller;

import it.exolab.jdbc.view.ClienteView;
import it.exolab.jdbc.view.ProgrammaView;

public class ProgrammaController {
	
	ProgrammaView pv = new ProgrammaView();
	ClienteController cc = new ClienteController();
	ClienteView cv = new ClienteView();
	
	public void start() {
	pv.menu();
	}
	
	public void scelta(int scelta) {
		
		switch (scelta) {
		case 1:
			cc.accessoCliente();;
			break;
		case 2: 
			
			break;
		case 3: 
			cv.registrazione();
		}
	}

}
