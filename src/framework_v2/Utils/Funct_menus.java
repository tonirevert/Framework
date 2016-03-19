package framework_v2.Utils;

import framework_v2.Classes.Singleton_app;
import javax.swing.JOptionPane;



public class Funct_menus {

	/**Confirm dialog for boolean*/
	public static boolean confboolean(String message, String tittle){
		boolean correct=false;
		int opt=0;
		String[] men={Singleton_app.lang.getProperty("booleanyes"),Singleton_app.lang.getProperty("booleanno")};
		
		opt=menu_but(men, message,tittle);
		
		if(opt==0)
			correct=true;
		
		return correct;
	}
	
	
	/**Button options menu */
	public static int menu_but(String[] name, String message, String title){
		int option=0;
		
		option=JOptionPane.showOptionDialog(null, message, title, 0, JOptionPane.QUESTION_MESSAGE, null, name, name[0]);
		
		return option;
	}
	
	/**Button Low Medium High menu */
	public static String menlomehi(String message, String tittle){
		String karma="";
		int opt=0;
		String[] men={"Low","Medium","High"};
		
		opt=menu_but(men,message,tittle);
			
		if(opt==0){
			karma="Low";
		}else if(opt==1){
			karma="Medium";
		}else if(opt==2){
			karma="High";
		}
		
		
		return karma;
	}

	/**Combobox menu type*/
	public static String menu_combo(String[] options, String message,String title){
		String option="";
		Object selection=JOptionPane.showInputDialog(null, message, title,JOptionPane.QUESTION_MESSAGE,null, options,0);
		try {
			option=selection.toString();
		} catch (Exception e) {
			option="";
		}
		return option;
	}
	
	public static String menuCombo(String[] options, String message,String title){
		//Menú de opciones con combo-box
		String op = "";
		Object selection = JOptionPane.showInputDialog(null,message,title,JOptionPane.QUESTION_MESSAGE,null,options,0);					 
			if(selection==null)			
				op ="";			
			else
				op = (String)selection;
		return op;
	}
}
