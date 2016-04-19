package Utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Class to format data 
 * 
*@author Antonio Revert Hinojosa
*@version 1.0
*/


public class Format {
	
	/**One decimal format*/
	public static String format1dec(double moneda){
		DecimalFormat format1 = new DecimalFormat("#.#");//one decimal
		return format1.format(moneda);
	}
	/**Two decimals format*/
	public static String format2dec(double moneda){
		DecimalFormat format1 = new DecimalFormat("#.##");//two decimals
		return format1.format(moneda);
	}
	/**Three decimals format*/
	public static String format3dec(double moneda){
		DecimalFormat format1 = new DecimalFormat("#.###");
		return format1.format(moneda);
	}
	/**Format for Dollars*/
	public static String FormatDollar(double moneda){
		NumberFormat coin=NumberFormat.getCurrencyInstance(Locale.US);
		return coin.format(moneda);
	}
	/**Format for Pounds*/
	public static String FormatPound(double moneda){
		NumberFormat coin=NumberFormat.getCurrencyInstance(Locale.UK);
		return coin.format(moneda);
	}
	/**Format for Euro*/
	public static String FormatEuro(double moneda){
		NumberFormat coin=NumberFormat.getCurrencyInstance( Locale.FRANCE );//Euro
		return coin.format(moneda);
	}
}
