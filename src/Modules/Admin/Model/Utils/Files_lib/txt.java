package Modules.Admin.Model.Utils.Files_lib;



import Modules.Admin.Model.Classes.Admin_class;
import Modules.Config.Classes.Config_class;
import Modules.Admin.Model.Classes.Singleton_admin;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;



public class txt {

	/**
	 * Used to save admin user data to TXT file format
	 */
	public static void savetxtadmin(){
		String path= "";
		try {
			File f;
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setAcceptAllFileFilterUsed(false);
                                                fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("TXT (*.txt)", "txt"));
			int selection = fileChooser.showSaveDialog(null);
			if (selection == JFileChooser.APPROVE_OPTION){
				File JFC = fileChooser.getSelectedFile();
				path = JFC.getAbsolutePath();
				path = path+".txt";
				f = new File(path);
				
				FileOutputStream fo=new FileOutputStream(f);
				ObjectOutputStream o=new ObjectOutputStream(fo);
				o.writeObject(Singleton_admin.adm);
				o.close();
//				JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("admtxtsavedok"),Singleton_app.lang.getProperty("savedfiletitle"),
//						JOptionPane.INFORMATION_MESSAGE);
                                                                 JOptionPane.showMessageDialog(null,"File TXT saved correctly");
			}
		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("problwritxt"), "Error!", JOptionPane.INFORMATION_MESSAGE);
                                                JOptionPane.showMessageDialog(null,"Error saving TXT file");
		}
	}//End save TXT admin
	
	/**
	 * Used to auto save admin user data to TXT file format
	 */
	public static void autosavetxtadmin(){
		String [] p={"/src/Modules/Admin/Model/Utils/Files/txt/admin.txt",
		"/src/Modules/Admin/Model/Utils/Files/txt/dummy_admin.txt"};
		String p2="";
		String PATH="";
		
		if(Config_class.getinstance().isDummy()==true){
			p2=p[1];
		}else{
			p2=p[0];
		}
		
		try {
			PATH=new java.io.File(".").getCanonicalPath()+p2;
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(Singleton_admin.adm.size()>0){
			try {
				File f= new File(PATH);
				FileOutputStream fo=new FileOutputStream(f);
				ObjectOutputStream o=new ObjectOutputStream(fo);
				o.writeObject(Singleton_admin.adm);
				o.close();
				
			} catch (Exception e) {
//				JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("problwritxt"), "Error!", JOptionPane.INFORMATION_MESSAGE);
                                                                JOptionPane.showMessageDialog(null,"Error auto-saving TXT  file");
			}
		}
	}//End auto save TXT admin
	
	/**
	 * Used to auto load admin user data from TXT file format
	 */
	@SuppressWarnings("unchecked")
	public static void autoloadtxtadmin(){
		String [] p={"/src/Modules/Admin/Model/Utils/Files/txt/admin.txt",
		"/src/Modules/Admin/Model/Utils/Files/txt/dummy_admin.txt"};
		String p2="";
		String PATH="";
		
		if(Config_class.getinstance().isDummy()==true){
			p2=p[1];
		}else{
			p2=p[0];
		}
		
		try {
			PATH = new java.io.File(".").getCanonicalPath()+p2;
			
			File path=new File(PATH);
			
			FileInputStream fi=new FileInputStream(path);
			ObjectInputStream oi=new ObjectInputStream(fi);
			Singleton_admin.adm = (ArrayList<Admin_class>)oi.readObject();
			oi.close();
			
		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("problopetxt"), "Error!", JOptionPane.INFORMATION_MESSAGE);
                                                JOptionPane.showMessageDialog(null,"Error auto-loading TXT  file");
		}
	}//End auto load TXT admin
	
	/**
	 * Used to load admin user data from TXT file format
	 */
	@SuppressWarnings("unchecked")
	public static void loadtxtadmin(){
		String path="";
		try {
			File f;
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setAcceptAllFileFilterUsed(false);
                                                fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("TXT (*.txt)", "txt"));
			int selection = fileChooser.showOpenDialog(null);
			if(selection == JFileChooser.APPROVE_OPTION){
				File JFC = fileChooser.getSelectedFile();
				path = JFC.getAbsolutePath();
				f = new File(path);
				
				FileInputStream fi=new FileInputStream(f);
				ObjectInputStream oi=new ObjectInputStream(fi);
				Singleton_admin.adm = (ArrayList<Admin_class>)oi.readObject();
				oi.close();
			}
			
		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("problopetxt"), "Error!", JOptionPane.INFORMATION_MESSAGE);
                                                JOptionPane.showMessageDialog(null,"Error loading TXT file");
		}
		
	}//End load txt admin

}
