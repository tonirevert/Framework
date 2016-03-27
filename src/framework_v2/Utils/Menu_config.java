package framework_v2.Utils;

import framework_v2.Modules.Config.Classes.theme_class;
import framework_v2.Modules.Config.Classes.Config_class;
import framework_v2.Classes.*;



public class Menu_config {

	public static void config(){
		String [] menu={Singleton_app.lang.getProperty("dateform"),Singleton_app.lang.getProperty("currency"),
				Singleton_app.lang.getProperty("fileform"),Singleton_app.lang.getProperty("language"),
				Singleton_app.lang.getProperty("theme"),Singleton_app.lang.getProperty("decformat")};
		String [] date_menu={"dd/MM/yyyy","yyyy/MM/dd","dd-MM-yyyy","yyyy-MM-dd"};
		String [] curr_menu={"€","£","$"};
		String [] file_menu={"json","txt","xml"};
		String [] lang_menu={"en","es","val"};
		String [] them_menu={"Metal","Windows","Motif","Nimbus"};
		String [] deci_menu={".0",".00",".000"};
		int men=0;
		
		men=Funct_menus.menu_but(menu,Singleton_app.lang.getProperty("optedit")+"\n"+Singleton_app.lang.getProperty("currconf")+
				"\n"+Config_class.getinstance().toString(), Singleton_app.lang.getProperty("config"));
		
		switch (men) {
		case 0:
			men=Funct_menus.menu_but(date_menu,Singleton_app.lang.getProperty("chdatef"),menu[0]);
			switch (men) {
			case 0:
				Config_class.getinstance().setDate_format(date_menu[0]);
				break;
			case 1:
				Config_class.getinstance().setDate_format(date_menu[1]);
				break;
			case 2:
				Config_class.getinstance().setDate_format(date_menu[2]);
				break;
			case 3:
				Config_class.getinstance().setDate_format(date_menu[3]);
				break;
			}//End switch / case men
			break;//End case date format
		case 1:
				men=Funct_menus.menu_but(curr_menu,Singleton_app.lang.getProperty("chcurrf"), menu[1]);
				switch (men) {
				case 0:
					Config_class.getinstance().setCurrency('€');
					break;
				case 1:
					Config_class.getinstance().setCurrency('£');
					break;
				case 2:
					Config_class.getinstance().setCurrency('$');
					break;
				}//End switch / case men
			break;
		case 2:
				men=Funct_menus.menu_but(file_menu,Singleton_app.lang.getProperty("chfilef"), menu[2]);
				switch (men) {
				case 0:
					Config_class.getinstance().setFile_format("json");
					break;
				case 1:
					Config_class.getinstance().setFile_format("txt");
					break;
				case 2:
					Config_class.getinstance().setFile_format("xml");
					break;
				}//End switch / case men
			break;
		case 3:
				men=Funct_menus.menu_but(lang_menu,Singleton_app.lang.getProperty("chalngf"), menu[3]);
				switch (men) {
				case 0:
					Config_class.getinstance().setLanguage("en");
					break;
				case 1:
					Config_class.getinstance().setLanguage("es");
					break;
				case 2:
					Config_class.getinstance().setLanguage("val");
					break;
				}//End switch / case men
			break;
		case 4:
				men=Funct_menus.menu_but(them_menu,Singleton_app.lang.getProperty("chthemf"), menu[4]);
				switch (men) {
				case 0:
					Config_class.getinstance().setTheme(them_menu[0]);
					theme_class.selectedtheme(them_menu[0]);
					break;
				case 1:
					Config_class.getinstance().setTheme(them_menu[1]);
					theme_class.selectedtheme(them_menu[1]);
					break;
				case 2:
					Config_class.getinstance().setTheme(them_menu[2]);
					theme_class.selectedtheme(them_menu[2]);
					break;
				case 3:
					Config_class.getinstance().setTheme(them_menu[3]);
					theme_class.selectedtheme(them_menu[3]);
					break;
				}
			break;
		case 5:
				men=Funct_menus.menu_but(deci_menu,Singleton_app.lang.getProperty("chdecif"), menu[5]);
				switch (men) {
				case 0:
					Config_class.getinstance().setDecimals(1);
					break;
				case 1:
					Config_class.getinstance().setDecimals(2);
					break;
				case 2:
					Config_class.getinstance().setDecimals(3);
					break;
				}//End switch / case men
			break;
		}
		
	}
	
}
