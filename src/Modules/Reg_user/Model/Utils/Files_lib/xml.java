/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules.Reg_user.Model.Utils.Files_lib;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.Annotations;
import Classes.Singleton_app;
import Modules.Config.Model.Classes.Config_class;
import Modules.Reg_user.Model.Classes.Reg_user_class;
import Modules.Reg_user.Model.Classes.Singleton_ruser;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import static javax.xml.transform.OutputKeys.ENCODING;

/**
 *
 * @author antonio
 */
public class xml {
    
/**
	 * Used to save registered user data to XML file format
	 */
	public static void savexmlruser(){
		String path="";
		
		try {
			OutputStream os = new ByteArrayOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			XStream xstream = new XStream();
			Annotations.configureAliases(xstream, Reg_user_class.class);
			
			String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
			xstream.toXML(Singleton_ruser.rus, osw);
			StringBuffer xml = new StringBuffer();
			xml.append(header);
			xml.append(os.toString());
			
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));
			int selection = fileChooser.showSaveDialog(null);
			if (selection == JFileChooser.APPROVE_OPTION){
				File JFC = fileChooser.getSelectedFile();
				path = JFC.getAbsolutePath();
				path = path+".xml";
				
				FileWriter fileXml = new FileWriter(path);
				fileXml.write(xml.toString());
				fileXml.close();
				osw.close();
				os.close();
				JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("rusxmlsavedok"),Singleton_app.lang.getProperty("savedfiletitle"),
						JOptionPane.INFORMATION_MESSAGE);
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("problwrixml"), "Error!",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}//End save XML registered user
	
	/**
	 * Used to auto save registered user data to XML file format
	 */
	public static void autosavexmlruser(){
		String [] p={"/src/Modules/Config/Files/ruser_files/ruser_xml/ruser.xml",
		"/src/Modules/Config/Files/ruser_files/ruser_xml/dummy_ruser.xml"};
		String p2="";
		String PATH="";
		
		if(Config_class.getinstance().isDummy()==true){
			p2=p[1];
		}else{
			p2=p[0];
		}
		
		try {
			PATH=new java.io.File(".").getCanonicalPath()+p2;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(Singleton_ruser.rus.size()>0){
			try {
				OutputStream os = new ByteArrayOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os);
				XStream xstream = new XStream();
				
				Annotations.configureAliases(xstream, Reg_user_class.class);
				String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
				xstream.toXML(Singleton_ruser.rus, osw);
				StringBuffer xml = new StringBuffer();
				xml.append(header);
				xml.append(os.toString());
				
				FileWriter fileXml = new FileWriter(PATH);
				fileXml.write(xml.toString());
				fileXml.close();
			} catch (Exception e) {
				 JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("problwrixml"), "Error",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else{
			File path = new File(PATH);
			path.delete();
		}
	}//End auto save XML registered user
	
	/**
	 * Used to auto load registered user data from XML file format
	 */
	@SuppressWarnings({ "unchecked" })
	public static void autoloadxmlruser(){
		String [] p={"/src/Modules/Config/Files/ruser_files/ruser_xml/ruser.xml",
		"/src/Modules/Config/Files/ruser_files/ruser_xml/dummy_ruser.xml"};
		String p2="";
		String PATH="";
		
		if(Config_class.getinstance().isDummy()==true){
			p2=p[1];
		}else{
			p2=p[0];
		}
		
		try {
			XStream xstream = new XStream();
			Annotations.configureAliases(xstream, Reg_user_class.class);
			
			PATH = new java.io.File(".").getCanonicalPath()+p2;
			
			File path = new File(PATH);
			
			if (path.exists()){
				Singleton_ruser.rus=(ArrayList<Reg_user_class>) xstream.fromXML(new FileReader(PATH));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("problopexml"), "Error!", JOptionPane.INFORMATION_MESSAGE);
		}
	}//End auto load XML registered user
	
	/**
	 * Used to load registered user data from XML file format
	 */
	@SuppressWarnings({ "unchecked" })
	public static void loadxmlruser(){
		String path="";
		
		try {
			XStream xstream = new XStream();
			Annotations.configureAliases(xstream, Reg_user_class.class);
			
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));
			int selection = fileChooser.showOpenDialog(null);
			if (selection == JFileChooser.APPROVE_OPTION){
				File JFC = fileChooser.getSelectedFile();
				path = JFC.getAbsolutePath();
				Singleton_ruser.rus=(ArrayList <Reg_user_class>)xstream.fromXML(new FileReader(path));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("problopexml"), "Error!", JOptionPane.INFORMATION_MESSAGE);
		}
	}//End load XML registered user
}
