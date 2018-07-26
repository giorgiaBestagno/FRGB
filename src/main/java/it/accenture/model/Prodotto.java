package it.accenture.model;

public class Prodotto {
	
	private int idProdotto;
	private String nome;
	private Categoria categoria;
	private String marca;
	private double prezzo;
	private boolean offerta;
	private int sconto;
	private int quantitaDisponibile;
	private String immagine;
	
	@Override
	public boolean equals (Object object){
		if(this == object){
			return true;
				
		}
		if(object == null){
			
			return false;
			}
		
		if(this.getClass() != object.getClass()){
			return false;
		}
		Prodotto prodotto = (Prodotto) object;
		if(this.idProdotto == prodotto.idProdotto){
		
		return true;
		}else{
			return false;
		}
	}
	
	
	public int getIdProdotto() {
		return idProdotto;
	}
	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public boolean isOfferta() {
		return offerta;
	}
	public void setOfferta(boolean offerta) {
		this.offerta = offerta;
	}
	public int getSconto() {
		return sconto;
	}
	public void setSconto(int sconto) {
		this.sconto = sconto;
	}
	public int getQuantitaDisponibile() {
		return quantitaDisponibile;
	}
	public void setQuantitaDisponibile(int quantitaDisponibile) {
		this.quantitaDisponibile = quantitaDisponibile;
	}
	public String getImmagine() {
		return immagine;
	}
	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}
	@Override
	public String toString() {
		return "Prodotto [idProdotto=" + idProdotto + ", nome=" + nome + ", categoria=" + categoria + ", marca=" + marca
				+ ", prezzo=" + prezzo + ", offerta=" + offerta + ", sconto=" + sconto + ", quantitaDisponibile="
				+ quantitaDisponibile + ", immagine=" + immagine + "]";
	}
	
	
	
	

}
