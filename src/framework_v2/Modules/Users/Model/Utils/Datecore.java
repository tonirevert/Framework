/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework_v2.Modules.Users.Model.Utils;

import framework_v2.Classes.Date_class;
import javax.swing.JOptionPane;

/**
 *
 * @author antonio
 */
public class Datecore {
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
		boolean ok=false;
                
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
}
