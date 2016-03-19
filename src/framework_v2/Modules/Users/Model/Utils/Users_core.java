package framework_v2.Modules.Users.Model.Utils;

import framework_v2.Classes.Singleton_app;
import framework_v2.Utils.*;
import javax.swing.JOptionPane;



/**
 * 
 * @author Antonio Revert
 * @version 1.3, 04/02/16
 */


public class Users_core {
	
	/**
	 * Used to choose a case from this function for ask for data
	 * @param type For all user types: dni, name, surname, birthday, mobile,
	 * email, user, pass. 
	 * For Admin type: cont_date, salary, activity.
	 * For Client type: reg_date, shopping, client_type.
	 * 
	 * @return A validated String with the desired data
	 */
	public static String request_data(String type) {
		String s = "";
		boolean val = false;

		switch (type) {
		case "dni":
			do {
//				s = Functions.valstring(Singleton_app.lang.getProperty("uc_inidcard"),Singleton_app.lang.getProperty("uc_datain"));
				s=Functions.valstring("Input ID Card to search","Input ID Card");
                                                                val = Validate.validateDNI(s);
				if (val == false){
//					JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("uc_idcarderr"), "Error!",
//							JOptionPane.INFORMATION_MESSAGE);
                                JOptionPane.showMessageDialog(null,"Not found","Error!",JOptionPane.ERROR_MESSAGE);
                                }
			} while (val == false);
			break;
			
		case "name":
			do {
				s = Functions.valstring(Singleton_app.lang.getProperty("uc_inname"),Singleton_app.lang.getProperty("uc_datain"));
				val = Validate.valname(s);
				if (val == false)
					JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("uc_nameerr"), "Error!",
							JOptionPane.INFORMATION_MESSAGE);
			} while (val == false);
			break;
		case "surname":
			do {
				s = Functions.valstring(Singleton_app.lang.getProperty("uc_insurnam"),Singleton_app.lang.getProperty("uc_datain"));
				val = Validate.valname(s);
				if (val == false)
					JOptionPane.showMessageDialog(null, Singleton_app.lang.getProperty("uc_surnerror"), "Error!",
							JOptionPane.INFORMATION_MESSAGE);
			} while (val == false);
			break;
//		case "birthday":
//			do {
//				s = Functions.valstring("Input birthday:\n(dd/mm/yyyy)", "Data iput");
//				val = Validate.valdate(s);
//				if (val == false)
//					JOptionPane.showMessageDialog(null, "Date incorrect", "Error!",
//							JOptionPane.INFORMATION_MESSAGE);
//			} while (val == false);
//			break;
		case "mobile":
			do {
				s = Functions.valstring(Singleton_app.lang.getProperty("uc_inmobile"),Singleton_app.lang.getProperty("uc_datain"));
				val = Validate.valmobile(s);
				if (val == false)
					JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("uc_mobileerr"), "Error!",
							JOptionPane.INFORMATION_MESSAGE);
			} while (val == false);
			break;
		case "email":
			do {
				s = Functions.valstring(Singleton_app.lang.getProperty("uc_inemail"),Singleton_app.lang.getProperty("uc_datain"));
				val = Validate.valemail(s);
				if (val == false)
					JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("uc_mailerror"), "Error!",
							JOptionPane.INFORMATION_MESSAGE);
			} while (val == false);
			break;
		case "user":
			do {
				s = Functions.valstring(Singleton_app.lang.getProperty("uc_username"),Singleton_app.lang.getProperty("uc_datain"));
				val = Validate.valuser(s);
				if (val == false)
					JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("uc_usernamerr"), "Error!",
							JOptionPane.INFORMATION_MESSAGE);
			} while (val == false);
			break;
		case "pass":
			do {
				s = Functions.valstring(Singleton_app.lang.getProperty("uc_inpasswd"),Singleton_app.lang.getProperty("uc_datain"));
				val = Validate.valpass(s);
				if (val == false)
					JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("uc_passwderr"), "Error!",
							JOptionPane.INFORMATION_MESSAGE);
			} while (val == false);
			break;
//		case "age":
//			do {
//				s = Integer.toString(Functions.valnumdet0("Input age:(1-99)", "Data iput"));
//				val = Validate.valage(s);
//				if (val == false)
//					JOptionPane.showMessageDialog(null, "Age incorrect (1-99)", "Error!",
//							JOptionPane.INFORMATION_MESSAGE);
//			} while (val == false);
//			break;
//		case "cont_date":
//			do {
//				s = Functions.valstring("Input contract date:\n(dd/mm/yyyy)", "Data iput");
//				val = Validate.valdate(s);
//				if (val == false)
//					JOptionPane.showMessageDialog(null, "Date incorrect", "Error!",
//							JOptionPane.INFORMATION_MESSAGE);
//			} while (val == false);
//			break;
//		case "antiquity":
//			do {
//				s = Integer.toString(Functions.valnumdet0("Input antiquity:\n(1-99)", "Data iput"));
//				val = Validate.valage(s);
//				if (val == false)
//					JOptionPane.showMessageDialog(null, "Antiquity incorrect (1-99)", "Error!",
//							JOptionPane.INFORMATION_MESSAGE);
//			} while (val == false);
//			break;
//		case "salary":
//			do{
//				s = Functions.valstring("Input salary:\n(x.xx)", "Data iput");
//				val = Validate.valsalary(s);
//				if (val == false)
//					JOptionPane.showMessageDialog(null, "Salary incorrect (x.xx)", "Error!",
//							JOptionPane.INFORMATION_MESSAGE);
//			}while (val == false);
//			break;
		case "activity":
			do{
				s = Functions.valstring(Singleton_app.lang.getProperty("uc_inactivity"),Singleton_app.lang.getProperty("uc_datain"));
				val = Validate.valactivity(s);
				if (val == false)
					JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("uc_erractivity"), "Error!",
							JOptionPane.INFORMATION_MESSAGE);
			}while (val == false);
			break;
//		case "reg_date":
//			do {
//				s = Functions.valstring("Input registry date:\n(dd/mm/yyyy)", "Data iput");
//				val = Validate.valdate(s);
//				if (val == false)
//					JOptionPane.showMessageDialog(null, "Date incorrect", "Error!",
//							JOptionPane.INFORMATION_MESSAGE);
//			} while (val == false);
//			break;
		case "shopping":
			do{
				s = Functions.valstring(Singleton_app.lang.getProperty("uc_shopping"),Singleton_app.lang.getProperty("uc_datain"));
				val = Validate.valshopping(s);
				if (val == false)
					JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("uc_shopperr"), "Error!",
							JOptionPane.INFORMATION_MESSAGE);
			}while (val == false);
			break;
		case "client_type":
			break;

		}
		return s;
	}

}
