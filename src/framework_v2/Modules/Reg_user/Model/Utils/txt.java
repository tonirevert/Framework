/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework_v2.Modules.Reg_user.Model.Utils;

import framework_v2.Classes.Singleton_app;
import framework_v2.Modules.Config.Classes.Config_class;
import framework_v2.Modules.Reg_user.Model.Classes.Reg_user_class;
import framework_v2.Modules.Reg_user.Model.Classes.Singleton_ruser;
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
	 * Used to save registered user data to TXT file format
	 */
	public static void savetxtruser(){
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
				o.writeObject(Singleton_ruser.rus);
				o.close();
				JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("rustxtsavedok"),Singleton_app.lang.getProperty("savedfiletitle"),
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("problwritxt"), "Error!", JOptionPane.INFORMATION_MESSAGE);
		}
	}//End save TXT registered user
	
	/**
	 * Used to auto save registered user data to TXT file format
	 */
	public static void autosavetxtruser(){
		String [] p={"/src/framework_v2/Modules/Config/Files/ruser_files/ruser_txt/ruser.txt",
		"/src/framework_v2/Modules/Config/Files/ruser_txt/dummy_ruser.txt"};
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

		if(Singleton_ruser.rus.size()>0){
			try {
				File f= new File(PATH);
				FileOutputStream fo=new FileOutputStream(f);
				ObjectOutputStream o=new ObjectOutputStream(fo);
				o.writeObject(Singleton_ruser.rus);
				o.close();
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("problwritxt"), "Error!", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}//End auto save TXT registered user
	
	/**
	 * Used to auto load registered user data from TXT file format
	 */
	@SuppressWarnings("unchecked")
	public static void autoloadtxtruser(){
		String [] p={"/src/framework_v2/Modules/Config/Files/ruser_files/ruser_txt/ruser.txt",
		"/src/framework_v2/Modules/Config/Files/ruser_txt/dummy_ruser.txt"};
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
			Singleton_ruser.rus = (ArrayList<Reg_user_class>)oi.readObject();
			oi.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("problopetxt"), "Error!", JOptionPane.INFORMATION_MESSAGE);
		}
	}//End auto load TXT registered user
	
	/**
	 * Used to auto load registered user data from TXT file format
	 */
	@SuppressWarnings("unchecked")
	public static void loadtxtruser(){
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
				Singleton_ruser.rus = (ArrayList<Reg_user_class>)oi.readObject();
				oi.close();
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("problopetxt"), "Error!", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}//End load TXT registered user
}
