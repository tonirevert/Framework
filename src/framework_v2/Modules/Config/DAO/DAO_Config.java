/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework_v2.Modules.Config.DAO;

import framework_v2.Modules.Config.Classes.Config_class;
import framework_v2.Modules.Config.View.Config;
import javax.swing.SwingUtilities;

/**
 *Used to get the configuration from their Window
 * @author antonio
 * @version 0.1
 */
public class DAO_Config {
    
    
    public static void saveConfig(){
        
        Config_class.getinstance().setDate_format(dateForm());
        Config_class.getinstance().setCurrency(Currency());
//        Config_class.getinstance().setLanguage(Language());
//        Config_class.getinstance().setFile_format(FileForm());
        Config_class.getinstance().setTheme(Theme());
        Config_class.getinstance().setDecimals(Decimals());
        
    }
    
    public static void resetConfig(){
        
        Config.comboDateform.setSelectedIndex(0);
        Config.comboCurrency.setSelectedIndex(0);
        Config.comboLanguage.setSelectedIndex(0);
        Config.comboFileform.setSelectedIndex(0);
        Config.comboTheme.setSelectedIndex(0);
        Config.comboDecimals.setSelectedIndex(0);
    }
    
    public static void loadConfig(){
        
        
    }
    
    public static String dateForm(){
        String [] format={"dd/MM/yyyy","yyyy/MM/dd","dd-MM-yyyy","yyyy-MM-dd"};
        String selection="";
        
        switch(Config.comboDateform.getSelectedIndex()){
            
            case 0:
                selection=format[0];
                break;
                
            case 1:
                selection=format[1];
                break;
                
            case 2:
                selection=format[2];
                break;
                
            case 3:
                selection=format[3];
                break;
        }
        
        return selection;
        
    }//End Date Form
    
    public static char Currency(){
        char [] currency={'€','£','$'};
        char selection=' ';
        
        switch(Config.comboCurrency.getSelectedIndex()){
            
            case 0:
                selection=currency[0];
                break;
                
            case 1:
                selection=currency[1];
                break;
                
            case 2:
                selection=currency[2];
                break;
            
        }
        
        return selection;
        
    }//End Currency
    
    public static String Language(){
        String [] language={"en","es","val"};
        String selection="";
        
        switch(Config.comboLanguage.getSelectedIndex()){
            
            case 0:
                selection=language[0];
                break;
                
            case 1:
                selection=language[1];
                break;
                
            case 2:
                selection=language[2];
                break;
            
        }
        
        return selection;
        
    }//End Language
    
    public static String FileForm(){
        String [] file_form={"json","txt","xml"};
        String selection="";
        
        switch(Config.comboFileform.getSelectedIndex()){
            
            case 0:
                selection=file_form[0];
                break;
                
            case 1:
                selection=file_form[1];
                break;
                
            case 2:
                selection=file_form[2];
                break;
        }
        
        return selection;
        
    }//End File Format
    
    public static String Theme(){
        String [] theme={"Metal","Windows","Motif","Nimbus"};
        String selection="";
        
        switch(Config.comboTheme.getSelectedIndex()){
            
            case 0:
                selection=theme[0];
                break;
                
            case 1:
                selection=theme[1];
                break;
                
            case 2:
                selection=theme[2];
                break;
                
            case 3:
                selection=theme[3];
                break;
        }
        
        return selection;
        
    }//End Theme
    
    public static int Decimals(){
        
        int selection=0;
        
        switch(Config.comboDecimals.getSelectedIndex()){
            
            case 0:
                selection=1;
                break;
                
            case 1:
                selection=2;
                break;
                
            case 2:
                selection=3;
                break;
        }
        
        return selection;
        
    }//End Decimals
    

}//End DAO Config
