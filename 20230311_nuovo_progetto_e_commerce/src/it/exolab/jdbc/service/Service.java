package it.exolab.jdbc.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// serve per la connessione questa classe
public class Service {
	// Pattern singleton 
	private static Service instance = null; 
	private Connection connection = null; //attributo aggiunto all'idea del singleton per fare la connessione
	private Service() {}
	public static Service getInstance() {
		if(instance == null) {
			instance = new Service();
		}
		return instance;
	}
	//
	// connection restituisce l'oggetto tramite il quale comunichiamo col database
	// lo istanzio una volta sola, se c'� gi� la connessione non devo rifarlo
	public Connection getConnection() throws ClassNotFoundException, SQLException { 
		if(connection == null) {
			//step2 create  the connection object  
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			
			String host = "192.168.100.37";
			String connectionString = "jdbc:oracle:thin:@" + host +":1521/pdb1";
			
			connection=DriverManager.getConnection(  
					connectionString,"u11","u11");  
		}
		return connection;
	}
	//tutte le connessioni le lasciamo fare all'oggetto della classe DAO non le facciamo fare all'esterno
	//perci� � private
	public void closeConnection() throws SQLException{	
		if(connection != null) {
			connection.close();
			connection=null;
		}
	}
	
}
