package it.exolab.jdbc.model;

public class ProdottoModel {
	private String ProdottoId;
	private String Descrizione;
	private int quantita;
	private double prezzo;
	private String Collocazione;
	public ProdottoModel(String prodottoId, String descrizione, int quantita, double prezzo, String collocazione) {
		super();
		ProdottoId = prodottoId;
		Descrizione = descrizione;
		this.quantita = quantita;
		this.prezzo = prezzo;
		Collocazione = collocazione;
	}
	public String getProdottoId() {
		return ProdottoId;
	}
	public void setProdottoId(String prodottoId) {
		ProdottoId = prodottoId;
	}
	public String getDescrizione() {
		return Descrizione;
	}
	public void setDescrizione(String descrizione) {
		Descrizione = descrizione;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public String getCollocazione() {
		return Collocazione;
	}
	public void setCollocazione(String collocazione) {
		Collocazione = collocazione;
	}
	
	
}
