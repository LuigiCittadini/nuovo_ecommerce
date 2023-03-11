package it.exolab.jdbc.model;

public class Ordine {
	private int numOrdine;
	private String clienteId;
	private Stato stato;
	private double saldo;
	
	public Ordine(int numOrdine, String clienteId, Stato stato, double saldo) {
		super();
		this.numOrdine = numOrdine;
		this.clienteId = clienteId;
		this.stato = stato;
		this.saldo = saldo;
		
	}
	public int getNumOrdine() {
		return numOrdine;
	}
	public void setNumOrdine(int numOrdine) {
		this.numOrdine = numOrdine;
	}
	public String getClienteId() {
		return clienteId;
	}
	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}
	public Stato getStato() {
		return stato;
	}
	public void setStato(Stato stato) {
		this.stato = stato;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
	
}
