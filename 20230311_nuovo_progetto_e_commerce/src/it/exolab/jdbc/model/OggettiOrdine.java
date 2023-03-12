package it.exolab.jdbc.model;

public class OggettiOrdine {
	
	private int numeroOrdine;
	private int numerooOggetto;
	private String prodottoId;
	private int numeroProdotti;
	private double costoTotale;
	
	public OggettiOrdine(int numeroOrdine, int numerooOggetto, String prodottoId, int numeroProdotti,double costoTotale) {
		super();
		this.numeroOrdine = numeroOrdine;
		this.numerooOggetto = numerooOggetto;
		this.prodottoId = prodottoId;
		this.numeroProdotti = numeroProdotti;
		this.costoTotale = costoTotale;
	}

	public int getNumeroOrdine() {
		return numeroOrdine;
	}

	public void setNumeroOrdine(int numeroOrdine) {
		this.numeroOrdine = numeroOrdine;
	}

	public int getNumerooOggetto() {
		return numerooOggetto;
	}

	public void setNumerooOggetto(int numerooOggetto) {
		this.numerooOggetto = numerooOggetto;
	}

	public String getProdottoId() {
		return prodottoId;
	}

	public void setProdottoId(String prodottoId) {
		this.prodottoId = prodottoId;
	}

	public int getNumeroProdotti() {
		return numeroProdotti;
	}

	public void setNumeroProdotti(int numeroProdotti) {
		this.numeroProdotti = numeroProdotti;
	}

	public double getCostoTotale() {
		return costoTotale;
	}

	public void setCostoTotale(double costoTotale) {
		this.costoTotale = costoTotale;
	}
}
