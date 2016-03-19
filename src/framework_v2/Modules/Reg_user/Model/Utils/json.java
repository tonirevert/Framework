/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework_v2.Modules.Reg_user.Model.Utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import framework_v2.Classes.Singleton_app;
import framework_v2.Modules.Admin.Model.Classes.Singleton_admin;
import framework_v2.Modules.Config.Classes.Config_class;
import framework_v2.Modules.Reg_user.Model.Classes.Reg_user_class;
import framework_v2.Modules.Reg_user.Model.Classes.Singleton_ruser;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author antonio
 */
public class json {
    
    /**
	 * Used to save registered user data to JSON file format
	 */
	public static void savejsonruser(){
		String path="";
		
		try {
			XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
			xstreamjson.setMode(XStream.NO_REFERENCES);
	        xstreamjson.alias("Reg_user_class", Reg_user_class.class);
	          
	          JFileChooser fileChooser = new JFileChooser();
			  fileChooser.setAcceptAllFileFilterUsed(false);
		      fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));
	          int selection = fileChooser.showSaveDialog(null);
	          if(selection == JFileChooser.APPROVE_OPTION){
	        	  File JFC = fileChooser.getSelectedFile();
	        	  path = JFC.getAbsolutePath();
	        	  path = path + ".json";
	        	  
	        	  Gson gson = new Gson();
	        	  String json = gson.toJson(Singleton_ruser.rus);
	        	  FileWriter fileXml = new FileWriter(path);
	        	  fileXml.write(json.toString());
	        	  fileXml.close();
	        	  
	        	  JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("rusjsonsavedok"), Singleton_app.lang.getProperty("savedfiletitle"),
						JOptionPane.INFORMATION_MESSAGE);
	          }
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("problwrijson"), "Error!", 
					JOptionPane.INFORMATION_MESSAGE);
		}
	}//End save JSON ruser
	
	/**
	 * Used to auto save registered user data to JSON file format
	 */
	public static void autosavejsonruser(){
		String [] p={"/src/framework_v2/Modules/Config/Files/ruser_files/ruser_json/ruser.json",
		"/src/framework_v2/Modules/Config/Files/ruser_json/dummy_ruser.json"};
		String p2="";
		String PATH="";
		
		if(Config_class.getinstance().isDummy()==true){
			p2=p[1];
		}else{
			p2=p[0];
		}
		
		try {
			PATH = new java.io.File(".").getCanonicalPath()+p2;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (Singleton_ruser.rus.size()>0){
			try {
				XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
				xstreamjson.setMode(XStream.NO_REFERENCES);
				xstreamjson.alias("Reg_user_class", Reg_user_class.class);
				
				Gson gson = new Gson();
	        	String json = gson.toJson(Singleton_ruser.rus);
	        	FileWriter fileXml = new FileWriter(PATH);
	        	fileXml.write(json.toString());
	        	fileXml.close();
	        	
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Singleton_app.lang.getProperty("problwrijson"), "Error!",
						JOptionPane.INFORMATION_MESSAGE);
			}        
		} else{
			File path = new File(PATH);
			path.delete();
		}
	}//End auto save JSON registered user
	
	/**
	 * Used to auto load registered user data from JSON file format
	 */
	public static void autoloadjsonruser(){
		String [] p={"/src/framework_v2/Modules/Config/Files/ruser_files/ruser_json/ruser.json",
		"/src/framework_v2/Modules/Config/Files/ruser_json/dummy_ruser.json"};
		String p2="";
		String PATH="";
		Reg_user_class a=new Reg_user_class("");
		
		if(Config_class.getinstance().isDummy()==true){
			p2=p[1];
		}else{
			p2=p[0];
		}
		
		try {
			XStream xstream = new XStream(new JettisonMappedXmlDriver());
			xstream.setMode(XStream.NO_REFERENCES);
			xstream.alias("Reg_user_class", Reg_user_class.class);
			
			PATH = new java.io.File(".").getCanonicalPath()+p2;
			
			File path=new File(PATH);
			
			if(path.exists()){
				JsonReader reader = new JsonReader(new FileReader(path));
				JsonParser parser = new JsonParser();
				JsonElement root = parser.parse(reader);
				Gson json = new Gson();
				JsonArray list = root.getAsJsonArray();
				for(JsonElement element : list){
					a = json.fromJson(element, Reg_user_class.class);
					Singleton_ruser.rus.add(a);
				}//for end
			}//if end
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("problopejson"), "Error!", JOptionPane.INFORMATION_MESSAGE);
		}
	}//End auto load registered user JSON

	/**
	 * Used to load registered user data from JSON file format
	 */
	public static void loadjsonruser(){
		String path= "";
		Reg_user_class ruser=new Reg_user_class("");
		
		try{
			XStream xstream = new XStream(new JettisonMappedXmlDriver());
			xstream.setMode(XStream.NO_REFERENCES);
			xstream.alias("Reg_user_class", Reg_user_class.class);
			
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setAcceptAllFileFilterUsed(false);
	        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));
			int selection = fileChooser.showOpenDialog(null);
			if (selection == JFileChooser.APPROVE_OPTION){
				File JFC = fileChooser.getSelectedFile();
				path = JFC.getAbsolutePath();
				
				Singleton_ruser.rus.clear();
				
				JsonReader reader = new JsonReader(new FileReader(path));
				JsonParser parser = new JsonParser();
				JsonElement root = parser.parse(reader);
				
				Gson json = new Gson();
				JsonArray list = root.getAsJsonArray();
				for(JsonElement element : list){
					ruser = json.fromJson(element, Reg_user_class.class);
					Singleton_ruser.rus.add(ruser);
				}
			}
			
		} catch (Exception e){
			JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("problopejson"), "Error",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
