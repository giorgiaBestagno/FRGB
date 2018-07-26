package it.accenture.model;

public class Recensione {
	
	
	private int idRecensione;
	private String titolo;
	private String contenuto;
	private int idUtente;
	private int idProdotto;
	
	
	
	
	
	
	public Recensione() {
	
	}

	public Recensione(String titolo, String contenuto, int idUtente, int idProdotto) {
		this.titolo = titolo;
		this.contenuto = contenuto;
		this.idUtente = idUtente;
		this.idProdotto = idProdotto;
	}
	


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recensione other = (Recensione) obj;
	
		if (idProdotto != other.idProdotto)
			return false;
	
		if (idUtente != other.idUtente)
			return false;
		
		return true;
	}
	
	
	
	
	

	public int getIdRecensione() {
		return idRecensione;
	}
	public void setIdRecensione(int idRecensione) {
		this.idRecensione = idRecensione;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getContenuto() {
		return contenuto;
	}
	public void setContenuto(String contenuto) {
		this.contenuto = contenuto;
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
		return "Recensione [idRecensione=" + idRecensione + ", titolo=" + titolo + ", contenuto=" + contenuto
				+ ", idUtente=" + idUtente + ", idProdotto=" + idProdotto + "]";
	}
	
	
	

	

}
