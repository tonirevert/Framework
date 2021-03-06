package Utils;

import Modules.Config.Model.Classes.Config_class;



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

/**
 * Class to validate strings
 * @author antonio
 */
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
                private static final String validshopping= "^-?[0-9]+([.][0-9]*)?$";
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
        
                /**
                 * Validate name and surname
                 * @param name a String with the name or surname to check
                 * @return a boolean with the result
                 */
	public static boolean valname(String name) {
		return name.matches(validname);
	}
        
                /**
                 * Validate email
                 * @param name a String with the email to check
                 * @return a boolean with the result
                 */
	public static boolean valemail(String name) {
		return name.matches(validemail);
	}
	
                /**
                 * Validate date
                 * @param date a String with the date to check
                 * @return a boolean with the result
                 */
	public static boolean valdate(String date){
		return date.matches(validdate);
	}
	
                /**
                 * Validate mobile
                 * @param mobile a String with the mobile to check
                 * @return a boolean with the result
                 */
	public static boolean valmobile(String mobile){
		return mobile.matches(validmobile);
	}
	
                /**
                 * Validate user name
                 * @param user a String with the username to check
                 * @return a boolean with the result
                 */
	public static boolean valuser(String user){
		return user.matches(validuser);
	}
	
                /**
                 * Validate password
                 * @param pass a String with the password to check
                 * @return a boolean with the result
                 */
	public static boolean valpass(String pass){
		return pass.matches(validpass);
	}
	
                /**
                 * Validate age
                 * @param age a String of the age
                 * @return a boolean with the result
                 */
	public static boolean valage(String age){
		return age.matches(validage);
	}
	
                /**
                 * Validate antiquity
                 * @param antiquity a String of the antiquity
                 * @return a boolean with the result
                 */
	public static boolean valantiquity(String antiquity){
		return antiquity.matches(valiantiquity);
	}
	
                /**
                 * Validate salary
                 * @param salary a String with the salary to check
                 * @return a boolean with the result
                 */
	public static boolean valsalary(String salary){
		return salary.matches(validsalary);
	}
	/**Validate shopping*/
                /**
                 * Validate shopping
                 * @param shopping a String with the shopping to check
                 * @return a boolean with the result
                 */
	public static boolean valshopping(String shopping){
		return shopping.matches(validshopping);
	}
	
                /**
                 * Validate shopping
                 * @param activity a String with the activity to check
                 * @return a boolean with the result
                 */
	public static boolean valactivity(String activity){
		return activity.matches(validactivity);
	}
	
                /**
                 * Validate client type
                 * @param type a String with the client type to check
                 * @return a boolean with the result
                 */
                public static boolean valclitype(String type){
		return type.matches(validcltype);
	}
                
                /**
                 * Validate the karma
                 * @param karma a String with the karma to check
                 * @return a boolean with the result
                 */
                public static boolean valkarma(String karma){
                                return karma.matches(valkarm);
                }
                
                /**
                 * Validate dates tacking into account the format of config
                 * @param date a String with the date to check
                 * @return a boolean with the result
                 */
	public static boolean newvaldate(String date){
		//System.out.println("newvaldate: "+name);
		boolean ok=false;
		String format=Config_class.getinstance().getDate_format();
		
		switch(format){
		case "dd/MM/yyyy":
			ok=date.matches(validdate0);
		break;
		case "yyyy/MM/dd":
			ok=date.matches(validdate1);
		break;
		case "dd-MM-yyyy":
			ok=date.matches(validdate2);
		break;
		case "yyyy-MM-dd":
			ok=date.matches(validdate3);
		}
		//System.out.println("ok newvalname: "+ok);
		return ok;
	}
}
