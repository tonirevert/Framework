package Modules.Users.Model.Utils;


import Classes.Date_class;
import Classes.Singleton_app;
import Modules.Config.Model.Classes.Config_class;
import Utils.Functions;
import Utils.Validate;
import javax.swing.JOptionPane;



/**
*@author Antonio Revert Hinojosa
*@version 1.2, 09/12/2015
*
*/

/**
 * Functions to work with dates, using the Date_class from Users-Utils
 * @author antonio
 */
public class Date_core_users {

	/**
	 * Used to create a Date_class object using personalised message and title
	 * @param message String with the window text so show
	 * @param title String with the title text to show
	 * @return A Date_class object after check it if is correct or not
	 */
	public static Date_class date(String message,String title){
		Date_class date=null;
		String d="";
		String format=Config_class.getinstance().getDate_format();
		boolean val=false; 
		boolean val2=false;
		
				do {
					do {
						d = Functions.valstring(message, title);
						val = Validate.valdate(d);
						if (val == false)
							JOptionPane.showMessageDialog(null, "Date format is incorrect!\nMust be dd/MM/yyyy"+format+")",
									"Error!", JOptionPane.INFORMATION_MESSAGE);
					} while (val == false);

					date = new Date_class(d);/*Create an object from Date_class called date*/
					val2 = date.checkdate2();/*Check if date is correct using checkdate2*/
					//System.out.println(date.getYear());

					if (val2 == false) {
						JOptionPane.showMessageDialog(null, "Incorrect date entered,\nplease try again", "Error!",
								JOptionPane.INFORMATION_MESSAGE);
					}

				} while (val2 == false);

		return date;/*Return an object from Date_class*/
	}
	
	/**
	 * Used to create a Date_class object using personalised message and title
	 * and format. Usage: Date_core_users.newdate(message,title,format)
	 * @param message String with the window text so show
	 * @param title String with the title text to show
	 * @return A Date_class object after check it if is correct or not
	 */
	public static Date_class newdate(String message,String title){
		Date_class date=null;
		String d="";
		boolean val=false; 
		boolean val2=false;
		String format=Config_class.getinstance().getDate_format();
		
				do {
					do {
						d = Functions.valstring(message, title);
						val = Validate.newvaldate(d);
						if (val == false)
							JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("dcu_dateinc")+format,
									"Error!", JOptionPane.INFORMATION_MESSAGE);
					} while (val == false);

					date = new Date_class(d,1);/*Create an object from Date_class called date*/
					val2 = date.checkdate2();/*Check if date is correct using checkdate2*/
					//System.out.println(date.getYear());

					if (val2 == false) {
						JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("dcu_daterro"), "Error!",
								JOptionPane.INFORMATION_MESSAGE);
					}

				} while (val2 == false);

		return date;/*Return an object from Date_class*/
	}	
	
	
	/**
	 * Used to check if a date is over desired years from parameter years
	 * @param years Integer for the amount of years to check
	 * @param message String with the window text so show
	 * @param title String with the title text to show
	 * @return A Date_class object after check it if is over 18 years or not
	 */
	public static Date_class dateadult(int years,String message,String title){
		Date_class date=null;
		boolean val=false;
		
		do{
			date=Date_core_users.date(message, title);
			
			if(date.intyearstoday()<years){
				JOptionPane.showMessageDialog(null, "Sorry, you must have over "+years+" to register", "Error!",
						JOptionPane.INFORMATION_MESSAGE);
			}else{
				val=true;
			}
			
		}while(val==false);
		
		return date;
	}
	
	/**
	 * Used to check if a date is over desired years from parameter years.
	 * Usage: Date_core_users.newdateadult(18,"message","title","format")
	 * @param years Integer for the amount of years to check.
	 * @param message String with the window text so show.
	 * @param title String with the title text to show.
	 * @return A Date_class object after check it if is over "X" years or not.
	 */
	public static Date_class newdateadult(int years,String message,String title){
		Date_class date=null;
		boolean val=false;
		
		do{			
			date=Date_core_users.newdate(message, title);
//			System.out.println("newdateadult: "+date.intyearstoday());
			if(date.intyearstoday()<years){
				JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("dcu_mustover")+years, "Error!",
						JOptionPane.INFORMATION_MESSAGE);
				val=false;
			}
			else if(date.intyearstoday()>=65){
				JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("dcu_over65"), "Error!",
						JOptionPane.INFORMATION_MESSAGE);
				val=false;
			}else{
				val=true;
			}
			
		}while(val==false);
		
		return date;
	}
	
	/**
	 * Used to check if a date is after today or not.
	 * @param message String with the window text so show
	 * @param title String with the title text to show
	 * @return A Date_class object after check it if is over 18 years or not
	 */
	public static Date_class date_today(String message, String title){
		Date_class date=null;
		boolean val=false;
			
			do {
				date = Date_core_users.date(message, title);/*Use the function date from Date_core*/
				if (date.comp_today() == 2) {
					JOptionPane.showMessageDialog(null, "Contract date cannot be after today", "Error!",
								JOptionPane.INFORMATION_MESSAGE);
				} else {
					val = true;
				}
			} while (val == false);
				
		return date;
	}

	/**
	 * Used to check if a date is after today or not.
	 * @param message String with the window text so show
	 * @param title String with the title text to show
	 * @return A Date_class object after check it if is over 18 years or not
	 */
	public static Date_class newdate_today(String message, String title){
		Date_class date=null;
		boolean val=false;
			
			do {
				date = Date_core_users.newdate(message, title);/*Use the function date from Date_core*/
				if (date.comp_today() == 2) {
					JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("dcu_contdattod"), "Error!",
								JOptionPane.INFORMATION_MESSAGE);
				} else {
					val = true;
				}
			} while (val == false);
				
		return date;
	}
	
	/**
	 * Used to compare a date with another such as Contract date or registration
	 * date and return a date
	 * @param date Get a Date_class object to compare with
	 * @param message String with the window text so show
	 * @param title String with the title text to show
	 * @return Compared date if is after 18 years from the parameter date
	 */
	public static Date_class checkplus18(Date_class date, String message, String title){
		Date_class years=null, contract=null;
		boolean correct=false;
		
		do{
			years=date;
			contract = Date_core_users.date_today(message, title);
			if(contract.compare_birth_contract(years,18)==0){
				JOptionPane.showMessageDialog(null, "User must be over 18", "Error!",
						JOptionPane.INFORMATION_MESSAGE);
			}else{
				correct=true;
			}
		}while(correct==false);
		
		return contract;
	}
	
	/**
	 * Used to compare a date with another such as Contract date or registration
	 * date and return a date
	 * @param date Get a Date_class object to compare with
	 * @param message String with the window text so show
	 * @param title String with the title text to show
	 * @param years An integer for the amount of year to compare from
	 * @return Compared date if is after X years from the parameter date
	 */
	public static Date_class checkplusyears(int years,Date_class date, String message, String title){
		Date_class other=null, contract=null;
		boolean correct=false;
		
		do{
			other=date;
			contract = Date_core_users.date_today(message, title);
			if(contract.compare_birth_contract(other,years)==0){
				JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("dcu_userover")+years+".", "Error!",
						JOptionPane.INFORMATION_MESSAGE);
			}else{
				correct=true;
			}
		}while(correct==false);
		
		return contract;
	}
	
	/**
	 * Used to compare a date with another such as Contract date or registration
	 * date and return a date
	 * @param date Get a Date_class object to compare with
	 * @param message String with the window text so show
	 * @param title String with the title text to show
	 * @param years An integer for the amount of year to compare from
	 * @return Compared date if is after X years from the parameter date
	 */
	public static Date_class newcheckplusyears(int years,Date_class date, String message, String title){
		Date_class other=null, contract=null;
		boolean correct=false;
		
		do{
			other=date;
			contract = Date_core_users.newdate_today(message, title);
			if(contract.compare_birth_contract(other,years)==0){
				JOptionPane.showMessageDialog(null, "User must be over "+years+".", "Error!",
						JOptionPane.INFORMATION_MESSAGE);
			}else{
				correct=true;
			}
		}while(correct==false);
		
		return contract;
	}
        
	/**
	 * Array to test, but doesn't seem it works
	 * @param type the type of data to work with
	 * @return an Array with the desired data
	 */
	public static Date_class[] admindates(String type){
		Date_class[] date=new Date_class[2];
		boolean correct=false;
		
		switch(type){
		case "adult":
			date[0]=Date_core_users.dateadult(18,"Input your birth date:\n(in dd/MM/yyy format)", "Date input");
			break;
		case"contract date":
			do{
				date[1]=Date_core_users.date_today("Input contract date:\n(in dd/MM/yyy format)", "Date input");
				if(date[0].compare_dates(date[1])==0){
					JOptionPane.showMessageDialog(null, "Contract date cannot be before birth date", "Error!",
							JOptionPane.INFORMATION_MESSAGE);
				}else{
					correct=true;
				}
				
			}while(correct==false);			
			break;
//		do{
//			//date[0]=Date_core_users.dateadult("Input your birth date:\n(in dd/MM/yyy format)", "Date input");
//			date[1]=Date_core_users.datecontract("Input contract date:\n(in dd/MM/yyy format)", "Date input");
//			if(date[0].comp_dates(date[1])==2){
//				JOptionPane.showMessageDialog(null, "Contract date cannot be before birth date", "Error!",
//						JOptionPane.INFORMATION_MESSAGE);
//			}else{
//				correct=true;
//			}
//			
//		}while(correct==false);
		}	
		return date;
	}
	
}
