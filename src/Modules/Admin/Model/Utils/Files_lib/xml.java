package Modules.Admin.Model.Utils.Files_lib;


import Classes.Singleton_app;
import Modules.Admin.Model.Classes.Singleton_admin;
import Modules.Admin.Model.Classes.Admin_class;
import Modules.Config.Classes.Config_class;
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
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.Annotations;



@SuppressWarnings("deprecation")
public class xml {
	
	private static final String ENCODING = "UTF-8";
	
	/**
	 * Used to save admin user data to XML file format
	 */
	public static void savexmladmin(){
		String path="";
		
		try {
			OutputStream os = new ByteArrayOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			XStream xstream = new XStream();
			Annotations.configureAliases(xstream, Admin_class.class);
			
			String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
			xstream.toXML(Singleton_admin.adm, osw);
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
				JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("admxmlsavedok"),Singleton_app.lang.getProperty("savedfiletitle"),
						JOptionPane.INFORMATION_MESSAGE);
//                                                                JOptionPane.showMessageDialog(null,"File XML saved correctly");
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("problwrixml"), "Error!",
					JOptionPane.INFORMATION_MESSAGE);
//                                                JOptionPane.showMessageDialog(null,"Error saving XML file");
		}
	}//End save XML admin
	
	/**
	 * Used to auto save admin user data to XML file format
	 */
	public static void autosavexmladmin(){
		String [] p={"/src/Modules/Admin/Model/Utils/Files/xml/admin.xml",
		"/src/Modules/Admin/Model/Utils/Files/xml/dummy_admin.xml"};
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
		
		if(Singleton_admin.adm.size()>0){
			try {
				OutputStream os = new ByteArrayOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os);
				XStream xstream = new XStream();
				
				Annotations.configureAliases(xstream, Admin_class.class);
				String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
				xstream.toXML(Singleton_admin.adm, osw);
				StringBuffer xml = new StringBuffer();
				xml.append(header);
				xml.append(os.toString());
				
				FileWriter fileXml = new FileWriter(PATH);
				fileXml.write(xml.toString());
				fileXml.close();
			} catch (Exception e) {
				 JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("problwrixml"), "Error",JOptionPane.INFORMATION_MESSAGE);
//                                                                 JOptionPane.showMessageDialog(null,"Error saving XML file");
			}
		} else{
			File path = new File(PATH);
			path.delete();
		}
	}//End auto save XML admin
	
	/**
	 * Used to auto load admin user data from XML file format
	 */
	@SuppressWarnings({ "unchecked" })
	public static void autoloadxmladmin(){
		String [] p={"/src/Modules/Admin/Model/Utils/Files/xml/admin.xml",
		"/src/Modules/Admin/Model/Utils/Files/xml/dummy_admin.xml"};
		String p2="";
		String PATH="";
		
		if(Config_class.getinstance().isDummy()==true){
			p2=p[1];
		}else{
			p2=p[0];
		}
		
		try {
			XStream xstream = new XStream();
			Annotations.configureAliases(xstream, Admin_class.class);
			
			PATH = new java.io.File(".").getCanonicalPath()+p2;
			
			File path = new File(PATH);
			
			if (path.exists()){
				Singleton_admin.adm=(ArrayList<Admin_class>) xstream.fromXML(new FileReader(PATH));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("problopexml"), "Error!", JOptionPane.INFORMATION_MESSAGE);
//                                                JOptionPane.showMessageDialog(null,"Error loading from the XML file");
		}
	}//End auto load XML admin
	
	/**
	 * Used to load admin user data from XML file format
	 */
	@SuppressWarnings({ "unchecked" })
	public static void loadxmladmin(){
		String path="";
		
		try {
			XStream xstream = new XStream();
			Annotations.configureAliases(xstream, Admin_class.class);
			
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setAcceptAllFileFilterUsed(false);
                                                fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));
			int selection = fileChooser.showOpenDialog(null);
			if (selection == JFileChooser.APPROVE_OPTION){
				File JFC = fileChooser.getSelectedFile();
				path = JFC.getAbsolutePath();
				Singleton_admin.adm=(ArrayList <Admin_class>)xstream.fromXML(new FileReader(path));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("problopexml"), "Error!", JOptionPane.INFORMATION_MESSAGE);
//                                                JOptionPane.showMessageDialog(null,"Error loading XML file");
		}
	}//End load XML admin
	
}
