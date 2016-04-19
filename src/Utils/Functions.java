package Utils;

import Classes.Singleton_app;
import javax.swing.JOptionPane;



/**Functions to use them for project Exercise 2 from Subject 4 
 * @author Antonio Revert
 * @version 1.0, 09/11/15
 * 
 * */

public class Functions {
	/**Validate float*/
	public static float valnfloat(String message, String title){
		/*Variables initialisation*/
		float num=0.0f;
		String n="";
		boolean correct=false;
		
		do {
			try {
				n=JOptionPane.showInputDialog(null,message,title,JOptionPane.QUESTION_MESSAGE);
				if(n==null){
					JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("f_endoper"), "Error",JOptionPane.INFORMATION_MESSAGE);
				}else{
					num=Float.parseFloat(n);
					correct=true;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("f_numnovalxx"),"Error!",JOptionPane.ERROR_MESSAGE);
				correct=false;
			}
		} while (correct==false);
		
		return num;
	}
	
	/**Validate number*/	
	public static int valnum(String message, String title){
		//Variables initialisation
		int num=0;
		String n="";
		boolean correct=false;
		
		do {
			try {
				n=JOptionPane.showInputDialog(null, message, title,JOptionPane.QUESTION_MESSAGE);
				if (n==null) {
					JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("f_endoper"), "Error",JOptionPane.INFORMATION_MESSAGE);				
				}else{
					num=Integer.parseInt(n);
					correct=true;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("f_numnoval"),"Error!",JOptionPane.ERROR_MESSAGE);
				correct=false;
			}
		} while (correct==false);
		
		return num;
	}
	
	/**Validate number detect if is 0*/
	public static int valnumdet0(String message, String title){
		//Variables initialisation
		int num=0, interrupt=0;
		String n="";
		boolean correct=false;
		
		while(interrupt==0){ //Loop switch to detect 0
			do {
				try {
					n=JOptionPane.showInputDialog(null, message, title,JOptionPane.QUESTION_MESSAGE);
					if (n==null) {
						JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("f_endoper"), "Error",JOptionPane.INFORMATION_MESSAGE);
					}else{
						num=Integer.parseInt(n);
						correct=true;
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("f_numnoval"),"Error!",JOptionPane.ERROR_MESSAGE);
					correct=false;
				}
			} while (correct==false);
			if(num==0){
			JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("f_numdif0"),"Error!",JOptionPane.ERROR_MESSAGE);
			interrupt=0;
			}else{
				interrupt=1;
			}
		}//End while switch to detect 0
		
		return num;
	}
	
	/**Validate character at position 0*/
	public static char valchar(String message, String title){
		//Variables initialisation
		char letter = ' ';//character (letter) initialisation
		String s= "";//Chain (s) initialisation
		boolean correct=false;
		do{
			try{
				s=JOptionPane.showInputDialog(null,message,title,JOptionPane.QUESTION_MESSAGE);
				if(s==null){
					
				}else{
					letter=s.charAt(0);//Take the 1st character from the String and put it to (letter)
					correct=true;//Changes boolean status to true for exit the loop
				}
			}catch(Exception e){
				JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("f_noletter"),"Error!",JOptionPane.ERROR_MESSAGE);
				correct=false;
			}
		}while(correct==false);//Loop condition
	
		return letter;
	}
	
	/**Validate String*/
	public static String valstring(String message, String tittle){
		//Variables initialisation
		String s=""; //Chain (s) initialisation
		boolean correct=false; //boolean initialisation
		
		do {
			try {
				s=JOptionPane.showInputDialog(null,message,tittle,JOptionPane.QUESTION_MESSAGE);
				correct=true;
				if(s==null){
					JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("f_endoper"), "Error",JOptionPane.INFORMATION_MESSAGE);
					correct=false;
				}if(s.equals("") || s.equals(" ")){
					JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("f_entwhite"),"Error!",JOptionPane.ERROR_MESSAGE);
					correct=false;
				}
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("f_valincorr"),"Error!",JOptionPane.ERROR_MESSAGE);
				correct=false;
			}
		} while (correct==false);
		
		return s;
	}
	
}