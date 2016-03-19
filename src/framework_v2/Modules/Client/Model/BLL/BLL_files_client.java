/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework_v2.Modules.Client.Model.BLL;

import framework_v2.Classes.Singleton_app;
import framework_v2.Modules.Client.Model.Classes.Singleton_client;
import framework_v2.Modules.Client.Model.Utils.json;
import framework_v2.Modules.Client.Model.Utils.txt;
import framework_v2.Modules.Client.Model.Utils.xml;
import framework_v2.Modules.Config.Classes.Config_class;
import javax.swing.JOptionPane;

/**
 *
 * @author antonio
 */
public class BLL_files_client {
    
	/**
	 * Function to save client files in different formats
	 */
	public static void saveclient(){
		
		if(Singleton_client.cli.size()!=0){
				switch (Config_class.getinstance().getFile_format()) {
				case "json":
					json.savejsonclient();
					break;
				case "txt":
					txt.savetxtclient();
					break;
				case "xml":
					xml.savexmlclient();
					break;
					}
			}else{
				JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("clinoda"), "Info",JOptionPane.INFORMATION_MESSAGE);
			}	
	}//End save client
	
	/**
	 * Function to load client files in different formats
	 */
	public static void loadclient(){
				
		if(Singleton_client.cli.size()!=0){
			JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("savefirst"), "Info",JOptionPane.INFORMATION_MESSAGE);
			saveclient();
		}
			switch (Config_class.getinstance().getFile_format()) {
			case "json":
				json.loadjsonclient();
				break;
			case "txt":
				txt.loadtxtclient();
				break;
			case "xml":
				xml.loadxmlclient();
				break;
			}
	}//End load client
    
	/**
	 * Function to save all users using all the formats
	 * before to exit the app
	 */
	public static void autosaveall(){

		
		if(Singleton_client.cli.size()!=0){
			json.autosavejsonclient();
			txt.autosavetxtclient();
			xml.autosavexmlclient();
		}

	}//End of autosaveall
	
	/**
	 * Function to load all users using all the formats
	 * when the app start
	 */
	public static void autoloadall(){

		json.autoloadjsonclient();
		txt.autoloadtxtclient();
		xml.autoloadxmlclient();

	}
}
