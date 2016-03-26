package framework_v2.Utils;

import framework_v2.Modules.Config.Classes.Config_class;



/**
*@author Antonio Revert Hinojosa
*@version 1.0 20/11/15
*/
/**Class for validate all the input Strings:
 * 
 * DNI
 * name
 * email
 * date
 * mobile
 * user
 * pass
 * age
 * antiquity
 * salary
 * shopping
 * activity
 * 
 * */

public class Validate {

	private static final String validname = "^[a-zA-ZÁáÀàÉéÈèÍíÌìÓóÒòÚúÙùÑñüÜ\\s]{3,}$"; //"^[a-zA-Z\\s\\D]*$" [A-Z][a-zA-Z]*\\D{3}
	private static final String validemail = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String validdate = "(0[1-9]|[12][0-9]|3[01])[/](0[1-9]|1[012])[/]((175[7-9])|(17[6-9][0-9])|(1[8-9][0-9][0-9])|([2-9][0-9][0-9][0-9]))";
	private static final String validdate0 = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
	private static final String validdate1 = "^[0-9]{4}/(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])$";
	private static final String validdate2 = "^(3[01]|[12][0-9]|0[1-9])-(1[0-2]|0[1-9])-[0-9]{4}$";
	private static final String validdate3 = "^[0-9]{4}-(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])$";
	private static final String validmobile = "[0-9]{2,2}[0-9]{9}";//"[0-9]{9}"  ^[0-9]{8,8}$
	private static final String validuser = "^[a-zA-Z0-9_-]{3,15}$";
	private static final String validpass = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";
	private static final String validage = "[0-9]{1,2}$";
	private static final String valiantiquity = "[0-9]{1,2}$";
	private static final String validsalary= "([0-9]{1,4}.[0-9]{0,2})$";
	private static final String validshopping= "([0-9]{1,4}.[0-9]{0,2})$";
	private static final String validactivity = "[0-9]{0,9}$";
                private static final String validcltype = "^[a-zA-ZÁáÀàÉéÈèÍíÌìÓóÒòÚúÙùÑñüÜ\\s]{3,}$";
                private static final String valkarm = "^[a-zA-ZÁáÀàÉéÈèÍíÌìÓóÒòÚúÙùÑñüÜ\\s]{3,}$";
	
	public static boolean validateDNI(String DNI) {
		String s = "[0-9]{8}[a-zA-Z]";
		String letras = "TRWAGMYFPDXBNJZSQVHLCKET";
		boolean resultado = true;

		resultado = DNI.matches(s);

		if (resultado) {
			int modulo = (Integer.parseInt(DNI.substring(0, 8))) % 23;
			char letra = letras.charAt(modulo);

			if (letra != DNI.substring(8).toUpperCase().charAt(0))
				resultado = false;
		}

		return resultado;
	}
	/**Validate name*/
	public static boolean valname(String name) {
		return name.matches(validname);
	}
	/**Validate email*/
	public static boolean valemail(String name) {
		return name.matches(validemail);
	}
	/**Validate date*/
	public static boolean valdate(String name){
		return name.matches(validdate);
	}
	/**Validate mobile*/
	public static boolean valmobile(String name){
		return name.matches(validmobile);
	}
	/**Validate user name*/
	public static boolean valuser(String name){
		return name.matches(validuser);
	}
	/**Validate password*/
	public static boolean valpass(String name){
		return name.matches(validpass);
	}
	/**Validate age*/
	public static boolean valage(String name){
		return name.matches(validage);
	}
	/**Validate antiquity*/
	public static boolean valantiquity(String name){
		return name.matches(valiantiquity);
	}
	/**Validate salary*/
	public static boolean valsalary(String name){
		return name.matches(validsalary);
	}
	/**Validate shopping*/
	public static boolean valshopping(String name){
		return name.matches(validshopping);
	}
	/**Validate shopping*/
	public static boolean valactivity(String name){
		return name.matches(validactivity);
	}
	
                /**Validate client type*/
                public static boolean valclitype(String name){
		return name.matches(validcltype);
	}
        
                public static boolean valkarma(String name){
                                return name.matches(valkarm);
                }
                
                /**Validate dates*/
	public static boolean newvaldate(String name){
		//System.out.println("newvaldate: "+name);
		boolean ok=false;
		String format=Config_class.getinstance().getDate_format();
		
		switch(format){
		case "dd/MM/yyyy":
			ok=name.matches(validdate0);
		break;
		case "yyyy/MM/dd":
			ok=name.matches(validdate1);
		break;
		case "dd-MM-yyyy":
			ok=name.matches(validdate2);
		break;
		case "yyyy-MM-dd":
			ok=name.matches(validdate3);
		}
		//System.out.println("ok newvalname: "+ok);
		return ok;
	}
}
