package Modules.Dummy.Classes;

import Classes.Singleton_app;
import Modules.Config.Model.Classes.Config_class;
import Modules.Dummy.DAO.DAO_Dummy;
import Utils.Funct_menus;
import Utils.Functions;
import javax.swing.JOptionPane;



public class BLL_files_Dummy {

//	workdum=Treballar amb dummy's
//			worksav=Treballar amb usu. guard.
	
//	public static void loadstartapp(){
//		String [] choice={Singleton_app.lang.getProperty("workdum"),Singleton_app.lang.getProperty("worksav")};
//		int quantity=0;
//		int men=0;
//		boolean ok=false;
//		
//		do{
//			men=Funct_menus.menu_but(choice,Singleton_app.lang.getProperty("chusety"),Singleton_app.lang.getProperty("usertyp"));
//			switch (men) {
//			case 0:
//				Config_class.getinstance().setDummy(true);
//				quantity=Functions.valnum(Singleton_app.lang.getProperty("inamdum"),Singleton_app.lang.getProperty("quandum"));
////				DAO_Dummy.createDummys(quantity);
////				BLL_files_Dummy.autosaveall();
////				BLL_files_Dummy.autoloadall();
//				ok=true;
//				break;
//			case 1:
//				Config_class.getinstance().setDummy(false);
////				BLL_files_Dummy.autoloadall();
//				ok=true;
//				break;
//			default:
//				Config_class.getinstance().setDummy(false);
//				JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("conwout"), "Info", JOptionPane.INFORMATION_MESSAGE);
//				ok=true;
//				break;
//			}
//		}while(ok==false);
//		
//		
//	}
}
