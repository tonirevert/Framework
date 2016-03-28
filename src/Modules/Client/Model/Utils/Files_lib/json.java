/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules.Client.Model.Utils.Files_lib;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import Modules.Client.Model.Classes.Client_class;
import Modules.Client.Model.Classes.Singleton_client;
import Modules.Config.Classes.Config_class;
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
	 * Used to save client data to JSON file format
	 */
	public static void savejsonclient(){
		String path="";
		
		try {
			XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
			xstreamjson.setMode(XStream.NO_REFERENCES);
	        xstreamjson.alias("Client_class", Client_class.class);
	          
	          JFileChooser fileChooser = new JFileChooser();
	          fileChooser.setAcceptAllFileFilterUsed(false);
		      fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));
	          int selection = fileChooser.showSaveDialog(null);
			  if(selection == JFileChooser.APPROVE_OPTION){
	        	  File JFC = fileChooser.getSelectedFile();
	        	  path = JFC.getAbsolutePath();
	        	  path = path + ".json";
	        	  
	        	  Gson gson = new Gson();
	        	  String json = gson.toJson(Singleton_client.cli);
	        	  FileWriter fileXml = new FileWriter(path);
	        	  fileXml.write(json.toString());
	        	  fileXml.close();
	        	  
//	        	  JOptionPane.showMessageDialog(null, Singleton_app.lang.getProperty("clijsonsavedok"), Singleton_app.lang.getProperty("savedfiletitle"),
//						JOptionPane.INFORMATION_MESSAGE);
                                JOptionPane.showMessageDialog(null,"File JSON saved correctly");
	          }
		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, Singleton_app.lang.getProperty("problwrijson"), "Error!", JOptionPane.INFORMATION_MESSAGE);
                                                JOptionPane.showMessageDialog(null,"Error saving JSON file");
		}
		
	}
	
	/**
	 * Used to auto save client data to JSON file format
	 */
	public static void autosavejsonclient(){
		String [] p={"/src/Modules/Client/Model/Utils/Files/json/client.json",
		"/src/Modules/Client/Model/Utils/Files/json/dummy_client.json"};
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
		
		if (Singleton_client.cli.size()>0){
			try {
				XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
				xstreamjson.setMode(XStream.NO_REFERENCES);
				xstreamjson.alias("Admin_class", Client_class.class);
				
				Gson gson = new Gson();
                                                                String json = gson.toJson(Singleton_client.cli);
                                                                FileWriter fileXml = new FileWriter(PATH);
                                                                fileXml.write(json.toString());
                                                                fileXml.close();
	        	
			} catch (Exception e) {
//				JOptionPane.showMessageDialog(null, Singleton_app.lang.getProperty("problwrijson"), "Error!",
//						JOptionPane.INFORMATION_MESSAGE);
                                                                JOptionPane.showMessageDialog(null,"Error auto-saving JSON file");
			}        
		} else{
			File path = new File(PATH);
			path.delete();
		}
	}//End auto save JSON admin
	
	/**
	 * Used to auto load client data from JSON file format
	 */
	public static void autoloadjsonclient(){
		String [] p={"/src/Modules/Client/Model/Utils/Files/json/client.json",
		"/src/Modules/Client/Model/Utils/Files/json/dummy_client.json"};
		String p2="";
		String PATH="";
		Client_class a=new Client_class("");
		
		if(Config_class.getinstance().isDummy()==true){
			p2=p[1];
		}else{
			p2=p[0];
		}
		
		try {
			XStream xstream = new XStream(new JettisonMappedXmlDriver());
			xstream.setMode(XStream.NO_REFERENCES);
			xstream.alias("Client_class", Client_class.class);
			
			PATH = new java.io.File(".").getCanonicalPath()+p2;
			
			File path=new File(PATH);
			
			if(path.exists()){
				JsonReader reader = new JsonReader(new FileReader(path));
				JsonParser parser = new JsonParser();
				JsonElement root = parser.parse(reader);
				Gson json = new Gson();
				JsonArray list = root.getAsJsonArray();
				for(JsonElement element : list){
					a = json.fromJson(element, Client_class.class);
					Singleton_client.cli.add(a);
				}//for end
			}//if end
			
			
		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("problopejson"), "Error!", JOptionPane.INFORMATION_MESSAGE);
                                                JOptionPane.showMessageDialog(null,"Error auto-loading JSON file");
		}
	}//End auto load client JSON
	
	
	/**
	 * Used to load client data from JSON file format
	 */
	public static void loadjsonclient(){
		String path= "";
		Client_class client=new Client_class("");
		
		try{
			XStream xstream = new XStream(new JettisonMappedXmlDriver());
			xstream.setMode(XStream.NO_REFERENCES);
			xstream.alias("Client_class", Client_class.class);
			
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setAcceptAllFileFilterUsed(false);
                                                fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));
			int selection = fileChooser.showOpenDialog(null);
			if (selection == JFileChooser.APPROVE_OPTION){
				File JFC = fileChooser.getSelectedFile();
				path = JFC.getAbsolutePath();
				
				Singleton_client.cli.clear();
				
				JsonReader reader = new JsonReader(new FileReader(path));
				JsonParser parser = new JsonParser();
				JsonElement root = parser.parse(reader);
				
				Gson json = new Gson();
				JsonArray list = root.getAsJsonArray();
				for(JsonElement element : list){
					client = json.fromJson(element, Client_class.class);
					Singleton_client.cli.add(client);
				}
			}
			
		} catch (Exception e){
//			JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("problopejson"), "Error",
//					JOptionPane.INFORMATION_MESSAGE);
                                               JOptionPane.showMessageDialog(null,"Error loading JSON file");
		}
	}//End load client JSON
    
}
