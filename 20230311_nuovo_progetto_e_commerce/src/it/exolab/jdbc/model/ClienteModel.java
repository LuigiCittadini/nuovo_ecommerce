package it.exolab.jdbc.model;

public class ClienteModel {
   private String clienteId;
   private String Nome;
   private String Cognome;
   private String Email;
   private String Indirizzo;
   private String Password;

   public ClienteModel(String clienteId, String nome, String cognome, String email, String indirizzo, String password) {
	super();
	this.clienteId = clienteId;
	Nome = nome;
	Cognome = cognome;
	Email = email;
	Indirizzo = indirizzo;
	Password = password;
}

public String getClienteId() {
	return clienteId;
}

public void setClienteId(String clienteId) {
	this.clienteId = clienteId;
}

public String getNome() {
	return Nome;
}

public void setNome(String nome) {
	Nome = nome;
}

public String getCognome() {
	return Cognome;
}

public void setCognome(String cognome) {
	Cognome = cognome;
}

public String getEmail() {
	return Email;
}

public void setEmail(String email) {
	Email = email;
}

public String getIndirizzo() {
	return Indirizzo;
}

public void setIndirizzo(String indirizzo) {
	Indirizzo = indirizzo;
}

public String getPassword() {
	return Password;
}

public void setPassword(String password) {
	Password = password;
}
   
   
}
