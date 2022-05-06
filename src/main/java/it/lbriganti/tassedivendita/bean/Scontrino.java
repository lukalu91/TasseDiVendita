package it.lbriganti.tassedivendita.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author lbriganti
 *
 */
public class Scontrino {

	private List<Bene> beniacquistati = new ArrayList<>();
	private BigDecimal tasseTotali;
	private BigDecimal spesaTotale;

	public Scontrino(List<Bene> beniacquistati) {
		super();
		this.beniacquistati = beniacquistati;
		this.spesaTotale = this.beniacquistati.stream().map(p -> p.getValore()).reduce(BigDecimal.ZERO, (b1, b2) -> b1.add(b2));
		this.tasseTotali = this.beniacquistati.stream().map(p -> p.getTassa()).reduce(BigDecimal.ZERO, (b1, b2) -> b1.add(b2));
	}

	public List<Bene> getBeniacquistati() {
		return beniacquistati;
	}

	public void setBeniacquistati(List<Bene> beniacquistati) {
		this.beniacquistati = beniacquistati;
	}

	public BigDecimal getTasseTotali() {
		return tasseTotali;
	}

	public BigDecimal getSpesaTotale() {
		return spesaTotale;
	}

	public void print() {
		this.beniacquistati.stream().forEach(b -> System.out.println(b.getQuantita()+" "+b.getDescrizione()+": "+(b.getValore().add(b.getTassa()))));
	
		System.out.println("Sales Taxes: "+this.tasseTotali);
		System.out.println("Total: "+this.spesaTotale);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Scontrino [beniacquistati=");
		builder.append(beniacquistati);
		builder.append(", tasseTotali=");
		builder.append(tasseTotali);
		builder.append(", spesaTotale=");
		builder.append(spesaTotale);
		builder.append("]");
		return builder.toString();
	}
}
