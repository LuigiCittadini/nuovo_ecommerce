package Programma;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.exolab.jdbc.model.ClienteModel;
import it.exolab.jdbc.service.DAOCliente;

public class ProgrammaTest {

	public static void main(String[] args) {
			DAOCliente daoc = new DAOCliente();
			List <ClienteModel> lcm= new ArrayList<>();
			try {
				daoc.insertCliente(new ClienteModel("user03", "Vincenzo", "Gaudimonte", "hhdbcb@msmsh.com", "via de sto ceppo", "password03"));
				daoc.insertCliente(new ClienteModel("user04", "Vicienz", "Gaudimont", "hhdcccc@msmsh.com", "via de sto ceppo", "password04"));
				lcm = daoc.findAllCliente();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(ClienteModel c : lcm) {
				System.out.println(c.getNome());
			}
	}

}
