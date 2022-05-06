package it.lbriganti.tassedivendita.bean;

import java.math.BigDecimal;

/**
 * 
 * @author lbriganti
 *
 */
public class Bene extends ATassabile{

	private int quantita;
	private String descrizione;
	private BigDecimal valore;
	private boolean importata;
	private boolean esentasse;
	
	public Bene(int quantita, String descrizione, BigDecimal valore, boolean importata, boolean esentasse) {
		super();
		this.quantita = quantita;
		this.descrizione = descrizione;
		this.valore = valore;
		this.importata = importata;
		this.esentasse = esentasse;
	}
	
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public BigDecimal getValore() {
		return valore.multiply(new BigDecimal(this.quantita));
	}
	public void setValore(BigDecimal valore) {
		this.valore = valore;
	}
	public boolean isImportata() {
		return importata;
	}
	public void setImportata(boolean importata) {
		this.importata = importata;
	}
	public boolean isEsentasse() {
		return esentasse;
	}
	public void setEsentasse(boolean esentasse) {
		this.esentasse = esentasse;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Bene [quantita=");
		builder.append(quantita);
		builder.append(", descrizione=");
		builder.append(descrizione);
		builder.append(", valore=");
		builder.append(valore);
		builder.append(", importata=");
		builder.append(importata);
		builder.append(", esentasse=");
		builder.append(esentasse);
		builder.append("]");
		return builder.toString();
	}
}
