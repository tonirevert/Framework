/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework_v2.Modules.Admin.Model.BLL;

import framework_v2.Classes.Singleton_app;
import framework_v2.Modules.Admin.Model.Classes.Singleton_admin;
import framework_v2.Modules.Config.Classes.Config_class;
import framework_v2.Modules.Admin.Model.Utils.Files_lib.json;
import framework_v2.Modules.Admin.Model.Utils.Files_lib.txt;
import framework_v2.Modules.Admin.Model.Utils.Files_lib.xml;
import javax.swing.JOptionPane;

/**
 *
 * @author antonio
 */
public class BLL_files_admin {
    
    /**
	 * Function to save admin files in different formats
	 */
	public static void saveadmin(){
		
		if(Singleton_admin.adm.size()!=0){
			
				switch (Config_class.getinstance().getFile_format()) {
				case "json":
					json.savejsonadmin();
					break;
				case "txt":
					txt.savetxtadmin();
					break;
				case "xml":
					xml.savexmladmin();
				}			
			
			}else{
				JOptionPane.showMessageDialog(null, Singleton_app.lang.getProperty("admnoda"), "Info",JOptionPane.INFORMATION_MESSAGE);
			}	
	}//End save admin
        
        /**
	 * Function to load admin files in different formats
	 */
	public static void loadadmin(){
		
		if(Singleton_admin.adm.size()!=0){
			JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("savefirst"), "Info",JOptionPane.INFORMATION_MESSAGE);
			BLL_files_admin.saveadmin();
		}
			switch (Config_class.getinstance().getFile_format()) {
			case "json":
				json.loadjsonadmin();
				break;
			case "txt":
				txt.loadtxtadmin();
				break;
			case "xml":
				xml.loadxmladmin();
				break;
			}
	}//End load admin
    
        /**
	 * Function to save all users using all the formats
	 * before to exit the app
	 */
	public static void autosaveall(){
		
		if(Singleton_admin.adm.size()!=0){
			json.autosavejsonadmin();
			txt.autosavetxtadmin();
			xml.autosavexmladmin();
		}
		
	}//End of autosaveall
	
	/**
	 * Function to load all users using all the formats
	 * when the app start
	 */
	public static void autoloadall(){
		
		
		json.autoloadjsonadmin();
		txt.autoloadtxtadmin();
		xml.autoloadxmladmin();
		
	}//End of autoloadall
}
