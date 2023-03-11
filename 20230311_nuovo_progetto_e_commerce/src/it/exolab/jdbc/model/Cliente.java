package it.exolab.jdbc.model;

public class Cliente {
   private String clienteId;
   private String nome;
   private String cognome;
   private String email;
   private String indirizzo;
   private String password;

   public Cliente(String clienteId, String nome, String cognome, String email, String indirizzo, String password) {
	super();
	this.clienteId = clienteId;
	this.nome = nome;
	this.cognome = cognome;
	this.email = email;
	this.indirizzo = indirizzo;
	this.password = password;
}

public String getClienteId() {
	return clienteId;
}

public void setClienteId(String clienteId) {
	this.clienteId = clienteId;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getCognome() {
	return cognome;
}

public void setCognome(String cognome) {
	this.cognome = cognome;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getIndirizzo() {
	return indirizzo;
}

public void setIndirizzo(String indirizzo) {
	this.indirizzo = indirizzo;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}
   
   
}
