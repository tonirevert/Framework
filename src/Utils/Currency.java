package Utils;

import Modules.Config.Model.Classes.Config_class;



public class Currency {

	public static String autocurrency(double moneda){
		String out="";
		

		
		switch (Config_class.getinstance().getCurrency()) {
		case '€':
//			System.out.println("euro");
			out=Currency.autodecimals(moneda)+" €";
			break;
		case '£':
//			System.out.println("pound");
			moneda=moneda*0.728380d;
//			out=Format.FormatPound(moneda);
			out="£"+Currency.autodecimals(moneda);
			break;
		case '$':
//			System.out.println("dollar");
			moneda=moneda*1.09246f;
//			out=Format.FormatDollar(moneda);
			out="$"+Currency.autodecimals(moneda);
			break;
		}
		return out;	
	}
	
	public static String autodecimals(double moneda){
		String out="";
		
		switch (Config_class.getinstance().getDecimals()){
		case 1:
			out=Format.format1dec(moneda);
			break;
		case 2:
			out=Format.format2dec(moneda);
			break;
		case 3:
			out=Format.format3dec(moneda);
			break;
		}
		
		return out;
	}
}
