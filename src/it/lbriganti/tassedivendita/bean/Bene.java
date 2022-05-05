package it.lbriganti.tassedivendita.bean;

import java.math.BigDecimal;

/**
 * 
 * @author lbriganti
 *
 */
public class Bene extends ATassabile{

	private String descrizione;
	private BigDecimal valore;
	private boolean importata;
	private boolean esentasse;
	
	public Bene(String descrizione, BigDecimal valore, boolean importata, boolean esentasse) {
		super();
		this.descrizione = descrizione;
		this.valore = valore;
		this.importata = importata;
		this.esentasse = esentasse;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public BigDecimal getValore() {
		return valore;
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
		builder.append("Bene [descrizione=");
		builder.append(descrizione);
		builder.append(", importata=");
		builder.append(importata);
		builder.append(", esentasse=");
		builder.append(esentasse);
		builder.append("]");
		return builder.toString();
	}
	
}
