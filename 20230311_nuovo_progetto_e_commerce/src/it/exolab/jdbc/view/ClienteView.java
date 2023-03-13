package it.exolab.jdbc.view;

import java.util.Scanner;

import it.exolab.jdbc.controller.ClienteController;

public class ClienteView {
	
	Scanner scanner = new Scanner(System.in);
	ClienteController cc = new ClienteController();
	
	public void menuCliente() {
		
		System.out.println("INSERISCI EMAIL");
		String email = scanner.nextLine();
		System.out.println("INSERISCI PASSWORD");
		String password = scanner.nextLine();
		cc.controllaAccesso(email, password);
		
		
	}

}
