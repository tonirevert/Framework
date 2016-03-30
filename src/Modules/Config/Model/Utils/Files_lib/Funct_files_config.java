package Modules.Config.Model.Utils.Files_lib;

import Classes.Singleton_app;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import javax.swing.JOptionPane;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.thoughtworks.xstream.*;
import com.thoughtworks.xstream.annotations.Annotations;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import Modules.Config.Model.Classes.Config_class;





@SuppressWarnings("deprecation")
public class Funct_files_config {
	private static final String ENCODING = "UTF-8";
                
                /**
	 * Used to auto load configuration data from JSON file format
	 */
	public static Config_class loadjsonconfig(){
			String PATH=null;
			Config_class c=new Config_class();
			
			try{
				XStream xstream = new XStream(new JettisonMappedXmlDriver());
				xstream.setMode(XStream.NO_REFERENCES);
				xstream.alias("Config_class", Config_class.class);
				PATH = new java.io.File(".").getCanonicalPath()+"/src/Modules/Config/Model/Utils/Files/config.json";
				
				File path= new File(PATH);
				if(path.exists()){
					JsonReader reader = new JsonReader(new FileReader(PATH));
					JsonParser parser = new JsonParser();
					JsonElement root = parser.parse(reader);
					Gson json = new Gson();
					c = json.fromJson(root, Config_class.class);
					Singleton_app.conf=c;
				}
				
				
			} catch(Exception e){
//				e.printStackTrace();
				JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("ffc_prloadjson"), "Error", JOptionPane.ERROR_MESSAGE);
			}	
			return c;
	}//End load config JSON Configuration
	
	/**
	 * Used to auto save configuration data to JSON file format
	 */
	public static void autosavejsonconfig(){
		String PATH="";

		try {
			PATH = new java.io.File(".").getCanonicalPath()+"/src/Modules/Config/Model/Utils/Files/config.json";
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (Singleton_app.conf!=null){
			try {
				XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
				xstreamjson.setMode(XStream.NO_REFERENCES);
				xstreamjson.alias("Config_class", Config_class.class);
				
				Gson gson = new Gson();
	        	String json = gson.toJson(Singleton_app.conf);
	        	FileWriter fileXml = new FileWriter(PATH);
	        	fileXml.write(json.toString());
	        	fileXml.close();
	        	
			} catch (Exception e) {
//				e.printStackTrace();
				JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("ffc_errsavjson"), "Error!",
						JOptionPane.INFORMATION_MESSAGE);
			}        
		} else{
			File path = new File(PATH);
			path.delete();
		}
	}//End auto save JSON Configuration
	
                /**
	 * Used to auto load configuration data from XML file format
	 */
                public static Config_class loadxmlconfig(){
		String PATH="";
		Config_class c=new Config_class();
		
		try {
			XStream xstream = new XStream();
			Annotations.configureAliases(xstream, Config_class.class);
			
			PATH = new java.io.File(".").getCanonicalPath()+"/src/Modules/Config/Model/Utils/Files/config.xml";
			
			File path = new File(PATH);
			
			if (path.exists()){
				c=(Config_class) xstream.fromXML(new FileReader(PATH));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("problopexml"), "Error!", JOptionPane.INFORMATION_MESSAGE);
		}
		return c;
	}//End auto load XML Configuration
	
	/**
	 * Used to auto save configuration data to XML file format
	 */
	public static void autosavexmlconfig(){
		String PATH="";
		
		try {
			PATH=new java.io.File(".").getCanonicalPath()+"/src/Modules/Config/Model/Utils/Files/config.xml";
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
			try {
				OutputStream os = new ByteArrayOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os);
				XStream xstream = new XStream();
				
				Annotations.configureAliases(xstream, Config_class.class);
				String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
				xstream.toXML(Config_class.getinstance(), osw);
				StringBuffer xml = new StringBuffer();
				xml.append(header);
				xml.append(os.toString());
				
				FileWriter fileXml = new FileWriter(PATH);
				fileXml.write(xml.toString());
				fileXml.close();
				osw.close();
				os.close();
			} catch (Exception e) {
				 JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("problwrixml"), "Error",
						JOptionPane.INFORMATION_MESSAGE);
			}
		
	}//End auto save XML Configuration
}
