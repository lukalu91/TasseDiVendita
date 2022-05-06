package it.lbriganti.tassedivendita.factory;

import java.util.List;

import it.lbriganti.tassedivendita.bean.Bene;
import it.lbriganti.tassedivendita.bean.Scontrino;

/**
 * 
 * @author lbriganti
 *
 */
public class FactoryScontrino {

	public static Scontrino getScontrino(List<Bene> list) {
		return new Scontrino(list);
	}
	
}
