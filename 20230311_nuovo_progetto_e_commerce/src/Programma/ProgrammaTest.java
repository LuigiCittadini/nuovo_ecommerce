package Programma;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.exolab.jdbc.model.Cliente;
import it.exolab.jdbc.service.DAOCliente;
import it.exolab.jdbc.service.DAOService;

public class ProgrammaTest {

	public static void main(String[] args) {
			
		
		List<Cliente> listaClienti = new ArrayList<Cliente>();
		try {
			String query = "SELECT * FROM CLIENTI WHERE CLIENTE_ID = 'dsD385'";
			PreparedStatement stmt;
			stmt = DAOService.getInstance().getConnection().prepareStatement(query);
			ResultSet rs = stmt.executeQuery(query);
			String cliente_id = "";
			while (rs.next()) {
				cliente_id = rs.getString("CLIENTE_ID");
				String nome = rs.getString("NOME");
				String cognome = rs.getString("COGNOME");
				String email = rs.getString("EMAIL");
				String indirizzo = rs.getString("INDIRIZZO");
				String password = rs.getString("PASSWORD");
				Cliente cliente = new Cliente(cliente_id, nome, cognome, email, indirizzo, password);
				listaClienti.add(cliente);			
			}
			System.out.println(listaClienti);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}
}
