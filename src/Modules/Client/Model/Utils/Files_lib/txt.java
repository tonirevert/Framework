/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules.Client.Model.Utils.Files_lib;

import Classes.Singleton_app;
import Modules.Client.Model.Classes.Client_class;
import Modules.Client.Model.Classes.Singleton_client;
import Modules.Config.Model.Classes.Config_class;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author antonio
 */
public class txt {
    
    /**
	 * Used to save client user data to TXT file format
	 */
	public static void savetxtclient(){
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
				path = path+ ".txt";
				f = new File(path);
				
				FileOutputStream fo=new FileOutputStream(f);
				ObjectOutputStream o=new ObjectOutputStream(fo);
				o.writeObject(Singleton_client.cli);
				o.close();
				JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("clitxtsavedok"),Singleton_app.lang.getProperty("savedfiletitle"),
						JOptionPane.INFORMATION_MESSAGE);
//                                                                JOptionPane.showMessageDialog(null,"File TXT saved correctly");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("problwritxt"), "Error!", JOptionPane.INFORMATION_MESSAGE);
//                                                JOptionPane.showMessageDialog(null,"Error saving TXT file");
		}
	}//End save TXT client
	
	/**
	 * Used to auto save client user data to TXT file format
	 */
	public static void autosavetxtclient(){
		String [] p={"/src/Modules/Client/Model/Utils/Files/txt/client.txt",
		"/src/Modules/Client/Model/Utils/Files/txt/dummy_client.txt"};
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

		if(Singleton_client.cli.size()>0){
			try {
				File f= new File(PATH);
				FileOutputStream fo=new FileOutputStream(f);
				ObjectOutputStream o=new ObjectOutputStream(fo);
				o.writeObject(Singleton_client.cli);
				o.close();
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("problwritxt"), "Error!", JOptionPane.INFORMATION_MESSAGE);
//                                                                JOptionPane.showMessageDialog(null,"Error auto-saving TXT  file");
			}
		}
	}//End auto save TXT client
	
	/**
	 * Used to auto load client user data from TXT file format
	 */
	@SuppressWarnings("unchecked")
	public static void autoloadtxtclient(){
		String [] p={"/src/Modules/Client/Model/Utils/Files/txt/client.txt",
		"/src/Modules/Client/Model/Utils/Files/txt/dummy_client.txt"};
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
			Singleton_client.cli = (ArrayList<Client_class>)oi.readObject();
			oi.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("problopetxt"), "Error!", JOptionPane.INFORMATION_MESSAGE);
//                                                JOptionPane.showMessageDialog(null,"Error auto-loading TXT  file");
		}
	}//End auto load TXT client
	
	/**
	 * Used to load client user data from TXT file format
	 */
	@SuppressWarnings("unchecked")
	public static void loadtxtclient(){
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
				Singleton_client.cli = (ArrayList<Client_class>)oi.readObject();
				oi.close();
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("problopetxt"), "Error!", JOptionPane.INFORMATION_MESSAGE);
//                                                JOptionPane.showMessageDialog(null,"Error loading TXT file");
		}
		
	}//End load TXT client
}
