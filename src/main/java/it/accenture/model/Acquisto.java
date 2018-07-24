package it.accenture.model;

import java.time.LocalDate;

public class Acquisto {
	
	private int idAcquisto;
	private Spedizione spedizione;
	private LocalDate dataInizio;
	private LocalDate dataFine;
	private int quantitaAcquistata;
	private double costoSpedizione;
	private int idUtente;
	private int idProdotto;
	
	
	
	
	
	
	public Acquisto(Spedizione spedizione, LocalDate dataInizio, LocalDate dataFine, int quantitaAcquistata,
			int idUtente, int idProdotto) {
		super();
		this.spedizione = spedizione;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.quantitaAcquistata = quantitaAcquistata;
		this.idUtente = idUtente;
		this.idProdotto = idProdotto;
		
	}
	
	

	
	
	
	





	public Acquisto() {
		
	}












	public int getIdAcquisto() {
		return idAcquisto;
	}
	public void setIdAcquisto(int idAcquisto) {
		this.idAcquisto = idAcquisto;
	}
	public Spedizione getSpedizione() {
		return spedizione;
	}
	public void setSpedizione(Spedizione spedizione) {
		this.spedizione = spedizione;
	}
	public LocalDate getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}
	public LocalDate getDataFine() {
		return dataFine;
	}
	public void setDataFine(LocalDate dataFine) {
		this.dataFine = dataFine;
	}
	
	public int getQuantitaAcquistata() {
		return quantitaAcquistata;
	}
	public void setQuantitaAcquistata(int quantitaAcquistata) {
		this.quantitaAcquistata = quantitaAcquistata;
	}
	public int getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}
	public int getIdProdotto() {
		return idProdotto;
	}
	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}
	@Override
	public String toString() {
		return "Acquisto [idAcquisto=" + idAcquisto + ", spedizione=" + spedizione + ", dataInizio=" + dataInizio
				+ ", dataFine=" + dataFine + ", quantitaAcquistata="
				+ quantitaAcquistata + ", idUtente=" + idUtente + ", idProdotto=" + idProdotto + "]";
	}
	
	
	
	
	
	

}
