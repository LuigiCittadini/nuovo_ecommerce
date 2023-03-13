package it.exolab.jdbc.view;

import java.util.Scanner;

import it.exolab.jdbc.controller.ProgrammaController;

public class ProgrammaView {
	
	Scanner scanner = new Scanner(System.in);
	
	public void menu() {
		
		ProgrammaController pc = new ProgrammaController();
		
		
		System.out.println("PIZZERIA 'DA EXOLAB'");
		System.out.println("1 - CLIENTE");
		System.out.println("2 - GESTORE");
		System.out.println("3 - REGISTRATI");
		System.out.println("0 - ESCI");
		
		int scelta = scanner.nextInt();
		pc.scelta(scelta);		
	}
	
	

}
