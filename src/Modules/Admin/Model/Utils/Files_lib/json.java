package Modules.Admin.Model.Utils.Files_lib;


import Classes.Singleton_app;
import Modules.Admin.Model.Classes.Singleton_admin;
import Modules.Admin.Model.Classes.Admin_class;
import Modules.Config.Model.Classes.Config_class;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;




public class json {

	/**
	 * Used to save admin data to JSON file format
	 */
	public static void savejsonadmin(){
		String path="";
		
		try {
			XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
			xstreamjson.setMode(XStream.NO_REFERENCES);
	        xstreamjson.alias("Admin_class", Admin_class.class);
	          
	          JFileChooser fileChooser = new JFileChooser();
	          fileChooser.setAcceptAllFileFilterUsed(false);
	          fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));
	          int selection = fileChooser.showSaveDialog(null);
	          if(selection == JFileChooser.APPROVE_OPTION){
	        	  File JFC = fileChooser.getSelectedFile();
	        	  path = JFC.getAbsolutePath();
	        	  path = path + ".json";
	        	  
	        	  Gson gson = new Gson();
	        	  String json = gson.toJson(Singleton_admin.adm);
	        	  FileWriter fileXml = new FileWriter(path);
	        	  fileXml.write(json.toString());
	        	  fileXml.close();
	        	  
	        	  JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("admjsonsavedok"), Singleton_app.lang.getProperty("savedfiletitle"),
						JOptionPane.INFORMATION_MESSAGE);
//                                 JOptionPane.showMessageDialog(null,"File JSON saved correctly");
	          }
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, Singleton_app.lang.getProperty("problwrijson"), "Error!", JOptionPane.INFORMATION_MESSAGE);
//                                                JOptionPane.showMessageDialog(null,"Error saving JSON file");
		}
		
	}//End save JSON admin
	
	/**
	 * Used to auto save admin data to JSON file format
	 */
	public static void autosavejsonadmin(){
//		if(Config_class.getinstance().)
		String [] p={"/src/Modules/Admin/Model/Utils/Files/json/admin.json",
				"/src/Modules/Admin/Model/Utils/Files/json/dummy_admin.json"};
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
		
		if (Singleton_admin.adm.size()>0){
			try {
				XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
				xstreamjson.setMode(XStream.NO_REFERENCES);
				xstreamjson.alias("Admin_class", Admin_class.class);
				
				Gson gson = new Gson();
	        	String json = gson.toJson(Singleton_admin.adm);
	        	FileWriter fileXml = new FileWriter(PATH);
	        	fileXml.write(json.toString());
	        	fileXml.close();
	        	
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Singleton_app.lang.getProperty("problwrijson"), "Error!",
						JOptionPane.INFORMATION_MESSAGE);
//                                                                JOptionPane.showMessageDialog(null,"Error auto-saving JSON file");
			}        
		} else{
			File path = new File(PATH);
			path.delete();
		}
	}//End auto save JSON admin
	
	/**
	 * Used to auto load admin data from JSON file format
	 */
	public static void autoloadjsonadmin(){
		String [] p={"/src/Modules/Admin/Model/Utils/Files/json/admin.json",
				"/src/Modules/Admin/Model/Utils/Files/json/dummy_admin.json"};
		String p2="";
		String PATH="";
		Admin_class a=new Admin_class("");
		
			if(Config_class.getinstance().isDummy()==true){
				p2=p[1];
			}else{
				p2=p[0];
			}
		
		try {
			XStream xstream = new XStream(new JettisonMappedXmlDriver());
			xstream.setMode(XStream.NO_REFERENCES);
			xstream.alias("Admin_class", Admin_class.class);
			
			PATH = new java.io.File(".").getCanonicalPath()+p2;
			
			File path=new File(PATH);
			
			if(path.exists()){
				JsonReader reader = new JsonReader(new FileReader(path));
				JsonParser parser = new JsonParser();
				JsonElement root = parser.parse(reader);
				Gson json = new Gson();
				JsonArray list = root.getAsJsonArray();
				for(JsonElement element : list){
					a = json.fromJson(element, Admin_class.class);
					Singleton_admin.adm.add(a);
				}//for end
			}//if end
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, Singleton_app.lang.getProperty("problwrijson"), "Error!", JOptionPane.INFORMATION_MESSAGE);
//                                                JOptionPane.showMessageDialog(null,"Error auto-loading JSON file");
		}
	}//End auto load admin JSON
	
	/**
	 * Used to load admin data from JSON file format
	 */
	public static void loadjsonadmin(){
		String path= "";
		Admin_class a=new Admin_class("");
		
		try{
			XStream xstream = new XStream(new JettisonMappedXmlDriver());
			xstream.setMode(XStream.NO_REFERENCES);
			xstream.alias("Admin_class", Admin_class.class);
			
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setAcceptAllFileFilterUsed(false);
	        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));
			int selection = fileChooser.showOpenDialog(null);
			if (selection == JFileChooser.APPROVE_OPTION){
				File JFC = fileChooser.getSelectedFile();
				path = JFC.getAbsolutePath();
				
				Singleton_admin.adm.clear();
				
				JsonReader reader = new JsonReader(new FileReader(path));
				JsonParser parser = new JsonParser();
				JsonElement root = parser.parse(reader);
				
				Gson json = new Gson();
				JsonArray list = root.getAsJsonArray();
				for(JsonElement element : list){
					a = json.fromJson(element, Admin_class.class);
					Singleton_admin.adm.add(a);
				}
			}
			
		} catch (Exception e){
			JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("problopejson"), "Error!",
					JOptionPane.INFORMATION_MESSAGE);
//                                                JOptionPane.showMessageDialog(null,"Error loading JSON file");
		}
	}
	
}
