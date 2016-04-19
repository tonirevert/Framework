/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules.Admin.Model.BLL;

import Classes.Singleton_app;
import Modules.Admin.Model.Classes.Singleton_admin;
import Modules.Config.Model.Classes.Config_class;
import Modules.Admin.Model.Utils.Files_lib.json;
import Modules.Admin.Model.Utils.Files_lib.txt;
import Modules.Admin.Model.Utils.Files_lib.xml;
import javax.swing.JOptionPane;

/**
 * Functions to work with files, saving and loading them into files
 * @author antonio
 */
public class BLL_files_admin {
    
                /**
	 * Function to save admin files in different formats
	 */
	public static void saveadmin(){
		
		if(!Singleton_admin.adm.isEmpty()){
			
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
		
		if(!Singleton_admin.adm.isEmpty()){
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
		
		if(!Singleton_admin.adm.isEmpty()){
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
