/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules.Reg_user.Model.BLL;

import Classes.Singleton_app;
import Modules.Config.Model.Classes.Config_class;
import Modules.Reg_user.Model.Classes.Singleton_ruser;
import Modules.Reg_user.Model.Utils.Files_lib.json;
import Modules.Reg_user.Model.Utils.Files_lib.txt;
import Modules.Reg_user.Model.Utils.Files_lib.xml;
import javax.swing.JOptionPane;

/**
 *
 * @author antonio
 */
public class BLL_files_ruser {
    
	/**
	 * Function with a menu to save registered users files in different formats
	 */
	public static void saveruser(){
		
		if(Singleton_ruser.rus.size()!=0){
			
				switch (Config_class.getinstance().getFile_format()) {
				case "json":
					json.savejsonruser();
					break;
				case "txt":
					txt.savetxtruser();
					break;
				case "xml":
					xml.savexmlruser();
					break;
				}
			}else{
				JOptionPane.showMessageDialog(null, Singleton_app.lang.getProperty("rusnoda"), "Info",JOptionPane.INFORMATION_MESSAGE);
			}	
	}//End save registered user
	
	/**
	 * Function to load registered user files in different formats
	 */
	public static void loadruser(){
		
		if(Singleton_ruser.rus.size()!=0){
			JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("savefirst"), "Info",JOptionPane.INFORMATION_MESSAGE);
			saveruser();
		}
			switch (Config_class.getinstance().getFile_format()) {
			case "json":
				json.loadjsonruser();
				break;
			case "txt":
				txt.loadtxtruser();
				break;
			case "xml":
				xml.loadxmlruser();
				break;
			}
	}//End load registered user
	
	/**
	 * Function to save all users using all the formats
	 * before to exit the app
	 */
	public static void autosaveall(){
		
		if(Singleton_ruser.rus.size()!=0){
			json.autosavejsonruser();
			txt.autosavetxtruser();
			xml.autosavexmlruser();
		}
	}//End of autosaveall
	
	/**
	 * Function to load all users using all the formats
	 * when the app start
	 */
	public static void autoloadall(){

		
		json.autoloadjsonruser();
		txt.autoloadtxtruser();
		xml.autoloadxmlruser();
		
	}
    
}
