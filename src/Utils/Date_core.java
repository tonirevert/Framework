package Utils;

import Classes.Date_class;
import javax.swing.JOptionPane;


public class Date_core {
	
	public static Date_class date(String message,String title){
		Date_class date=null;
		String d="";
		boolean val=false; 
		boolean val2=false;
		
		do{
			do {
				d = Functions.valstring(message, title);
				val = Validate.valdate(d);
				if (val == false)
					JOptionPane.showMessageDialog(null, "Date format is incorrect!\nMust be dd/MM/yyyy", "Error!",
							JOptionPane.INFORMATION_MESSAGE);
			} while (val == false);
			
			date = new Date_class(d);
			val2=date.checkdate2();
			
			if (val2 == false){
				JOptionPane.showMessageDialog(null, "Incorrect date entered,\nplease try again", "Error!",
						JOptionPane.INFORMATION_MESSAGE);
			}
			
		}while(val2==false);
		
		return date;
	}

}
