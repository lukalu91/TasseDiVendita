
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import it.lbriganti.tassedivendita.bean.Scontrino;
import it.lbriganti.tassedivendita.factory.FactoryBene;
import it.lbriganti.tassedivendita.factory.FactoryScontrino;

public class EserciziTest {
	@Test
	void primo() {
		System.out.println("================");
		System.out.println("PRIMO ESERCIZIO");
		System.out.println("-----------------");
		/*
		 * INPUT:
		 * 
		 * 1 book at 12.49 
		 * 1 music CD at 14.99 
		 * 1 chocolate bar at 0.85
		 * 
		 * OUTPUT:
		 * 
		 * 1 book : 12.49 
		 * 1 music CD: 16.49 
		 * 1 chocolate bar: 0.85 
		 * Sales Taxes: 1.50
		 * Total: 29.83
		 * 
		 */
		
		Scontrino s = FactoryScontrino.getScontrino(Arrays.asList(
				FactoryBene.getBene(1, "book", new BigDecimal("12.49"), false, true),
				FactoryBene.getBene(1, "music CD", new BigDecimal("14.99"), false, false),
				FactoryBene.getBene(1, "chocolate bar", new BigDecimal("0.85"), false, true)
			)
		);
		s.print();
		
		assertEquals(new BigDecimal("1.50").toPlainString(), s.getTasseTotali().toPlainString());
		assertEquals(new BigDecimal("29.83").toPlainString(), s.getSpesaTotale().toPlainString());
		System.out.println("-----------------");
}

	@Test
	void secondo() {
		System.out.println("================");
		System.out.println("SECONDO ESERCIZIO");
		System.out.println("-----------------");

		/*
		 * 
		 * INPUT:
		 * 
		 * 1 imported box of chocolates at 10.00 
		 * 1 imported bottle of perfume at 47.50
		 * 
		 * 
		 * OUTPUT:
		 * 
		 * 1 imported box of chocolates: 10.50 
		 * 1 imported bottle of perfume: 54.65 Sales
		 * Taxes: 7.65 
		 * Total: 65.15
		 * 
		 * 
		 */
		Scontrino s = FactoryScontrino.getScontrino(Arrays.asList(
				FactoryBene.getBene(1, "box of chocolates", new BigDecimal("10.00"), true, true),
				FactoryBene.getBene(1, "bottle of perfume", new BigDecimal("47.50"), true, false)
			)
		);
		s.print();
		
		assertEquals(new BigDecimal("7.65").toPlainString(), s.getTasseTotali().toPlainString());
		assertEquals(new BigDecimal("65.15").toPlainString(), s.getSpesaTotale().toPlainString());
		System.out.println("-----------------");
	
	}

	@Test
	void terzo() {
		System.out.println("================");
		System.out.println("TERZO ESERCIZIO");
		System.out.println("-----------------");
		/*
		 * INPUT:
		 * 
		 * 1 imported bottle of perfume at 27.99 
		 * 1 bottle of perfume at 18.99 
		 * 1 packet of headache pills at 9.75 
		 * 1 box of imported chocolates at 11.25
		 * 
		 * 
		 * OUTPUT: 
		 * 
		 * 1 imported bottle of perfume: 32.19 
		 * 1 bottle of perfume: 20.89 
		 * 1 packet of headache pills: 9.75 
		 * 1 imported box of chocolates: 11.85 Sales
		 * Taxes: 6.70 
		 * Total: 74.68
		 * 
		 */
		Scontrino s = FactoryScontrino.getScontrino(Arrays.asList(
				FactoryBene.getBene(1, "bottle of perfume", new BigDecimal("27.99"), true, false),
				FactoryBene.getBene(1, "bottle of perfume", new BigDecimal("18.99"), false, false),
				FactoryBene.getBene(1, "packet of headache pills", new BigDecimal("9.75"), false, true),
				FactoryBene.getBene(1, "box of chocolates", new BigDecimal("11.25"), true, true)
			)
		);
		s.print();
		
		assertEquals(new BigDecimal("6.70").toPlainString(), s.getTasseTotali().toPlainString());
		assertEquals(new BigDecimal("74.68").toPlainString(), s.getSpesaTotale().toPlainString());
		System.out.println("-----------------");	}
}
