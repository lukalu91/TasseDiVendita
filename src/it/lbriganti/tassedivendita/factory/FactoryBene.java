package it.lbriganti.tassedivendita.factory;

import java.math.BigDecimal;

import it.lbriganti.tassedivendita.bean.Bene;

/**
 * 
 * @author lbriganti
 *
 */
public class FactoryBene {

	/**
	 * 
	 * @param descrizione
	 * @param importo
	 * @param importato
	 * @param esentasse
	 * @return
	 */
	public static Bene getBene(String descrizione, BigDecimal importo, boolean importato, boolean esentasse) {
		return new Bene(descrizione, importo, importato, esentasse);
	}
	
}
