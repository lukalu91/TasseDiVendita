package it.lbriganti.tassedivendita.bean;

import java.math.BigDecimal;

/**
 * 
 * @author lbriganti
 *
 */
public abstract class ATassabile {
	private static int STANDARD_TAX = 10;
	private static int IMPORTED_TAX = 5;

	public abstract boolean isImportata();
	
	public abstract boolean isEsentasse();
	
	public abstract BigDecimal getValore();

	public abstract int getQuantita();

	public BigDecimal getTassa() {
		int taxPerc = STANDARD_TAX;
		if(isEsentasse() && !isImportata()) {
			return new BigDecimal("0");
		}
		
		if(isEsentasse()) {
			taxPerc = 0;
		}
		
		if(isImportata()) {
			taxPerc += IMPORTED_TAX;
		}
		
		BigDecimal tax = getValore().multiply(new BigDecimal(taxPerc)).divide(new BigDecimal("100"));
		
		String textBD = tax.toPlainString();
		int radixLoc = textBD.indexOf('.');
		
		String nonDecimal = textBD.substring(0, radixLoc);
		String decimal = textBD.substring(radixLoc + 1, textBD.length());
		
		while (decimal.length()>2) {
			//prendo l ultimo valore
			int val = Integer.parseInt(""+decimal.charAt(decimal.length()-1));

			int decimalVal = Integer.parseInt(decimal.substring(0, decimal.length()-1));

			//arrotondo
			if(val >= 5) {
				decimalVal++;
			}
			if(decimal.length() == (""+decimalVal).length()) {
				nonDecimal = ""+(Integer.parseInt(nonDecimal)+1);
				decimal = (""+decimalVal).substring(1);
			}else {
				decimal = ""+decimalVal;
			}
		}
		
		//arrotondo parte finale
		int val = Integer.parseInt(""+decimal.charAt(decimal.length()-1));
		int val1 = Integer.parseInt(""+decimal.charAt(decimal.length()-2));

		if(val > 5) {
			val = 0;
			val1++;
		}else if(val > 0){
			val = 5;
		}
		
		decimal = val1+""+val;
		return new BigDecimal(nonDecimal+"."+decimal);
	}
}
