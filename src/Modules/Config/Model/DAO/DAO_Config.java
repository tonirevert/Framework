/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules.Config.Model.DAO;

import Modules.Config.Model.Classes.Config_class;
import Modules.Config.View.Config;

/**
 *Used to get the configuration from their Window
 * @author antonio
 * @version 0.1
 */
public class DAO_Config {
    
    /**
     * Uses the set config functions to change the current config
     */
    public static void saveConfig(){
        
        Config_class.getinstance().setDate_format(dateForm());
        Config_class.getinstance().setCurrency(Currency());
        Config_class.getinstance().setLanguage(Language());
//        Config_class.getinstance().setFile_format(FileForm());
        Config_class.getinstance().setTheme(Theme());
        Config_class.getinstance().setDecimals(Decimals());
        
    }//End of save config
    
    /**
     * Used to set to defaults all the fields from Config menu
     */
    public static void resetConfig(){
        
        Config.comboDateform.setSelectedIndex(0);
        Config.comboCurrency.setSelectedIndex(0);
        Config.comboLanguage.setSelectedIndex(0);
        Config.comboFileform.setSelectedIndex(0);
        Config.comboTheme.setSelectedIndex(0);
        Config.comboDecimals.setSelectedIndex(0);
        
    }//End of reset config
    
    /**
     * Loads the configuration to set it into the config window
     */
    public static void loadConfig(){
        
        Config.comboDateform.setSelectedIndex(filldateForm());
        Config.comboCurrency.setSelectedIndex(fillCurrency());
        Config.comboLanguage.setSelectedIndex(fillLanguage());
        Config.comboFileform.setSelectedIndex(fillFileform());
        Config.comboTheme.setSelectedIndex(fillTheme());
        Config.comboDecimals.setSelectedIndex(fillDecimals());
        
    }//End of load config
    
    /**
    *Returns the desired date format from the config menu
    * @return String with the desired date format 
    */
    public static String dateForm(){
        String [] format={"dd/MM/yyyy","dd-MM-yyyy","yyyy-MM-dd","yyyy/MM/dd"};
        StringBuffer selection=new StringBuffer();
        
        switch(Config.comboDateform.getSelectedIndex()){
            
            case 0:
                selection.append(format[0]);
                break;
                
            case 1:
                selection.append(format[1]);
                break;
                
            case 2:
                selection.append(format[2]);
                break;
                
            case 3:
                selection.append(format[3]);
                break;
        }
        
        return selection.toString();
        
    }//End Date Form
    
    /**
    *Returns the desired currency format from the config menu
    * @return String with the desired currency format 
    */
    public static char Currency(){
        char [] currency={'€','$','£'};
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
    
    /**
    *Returns the desired language format from the config menu
    * @return String with the desired language format 
    */
    public static String Language(){
        String [] language={"en","es","val"};
        StringBuffer selection=new StringBuffer();
        
        switch(Config.comboLanguage.getSelectedIndex()){
            
            case 0:
                selection.append(language[0]);
                break;
                
            case 1:
                selection.append(language[1]);
                break;
                
            case 2:
                selection.append(language[2]);
                break;
            
        }
        
        return selection.toString();
        
    }//End Language
    
    /**
    *Returns the desired file format from the config menu
    * @return String with the desired file format 
    */
    public static String FileForm(){
        String [] file_form={"json","txt","xml"};
        StringBuffer selection=new StringBuffer();
        
        switch(Config.comboFileform.getSelectedIndex()){
            
            case 0:
                selection.append(file_form[0]);
                break;
                
            case 1:
                selection.append(file_form[1]);
                break;
                
            case 2:
                selection.append(file_form[2]);
                break;
        }
        
        return selection.toString();
        
    }//End File Format
    
    /**
    *Returns the desired theme from the config menu
    * @return String with the desired theme
    */
    public static String Theme(){
        String [] theme={"Metal","Windows","Motif","Nimbus"};
        StringBuffer selection=new StringBuffer();
        
        switch(Config.comboTheme.getSelectedIndex()){
            
            case 0:
                selection.append(theme[0]);
                break;
                
            case 1:
                selection.append(theme[1]);
                break;
                
            case 2:
                selection.append(theme[2]);
                break;
                
            case 3:
                selection.append(theme[3]);
                break;
        }
        
        return selection.toString();
        
    }//End Theme
    
    /**
    *Returns the desired quantity of decimals from the config menu
    * @return int with the desired quantity of decimals
    */
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
    
    /**
    *Used to fill date format field into the config menu
    * @return int with the actual selection
    */
    public static int filldateForm(){
        String [] format={"dd/MM/yyyy","dd-MM-yyyy","yyyy-MM-dd","yyyy/MM/dd"};
        int selection=0;
        
            
             if(Config_class.getinstance().getDate_format().equals(format[0])){
                selection=0;
             }
             else if(Config_class.getinstance().getDate_format().equals(format[1])){
                 selection=1;
             }
             else if(Config_class.getinstance().getDate_format().equals(format[2])){
                 selection=2;
             }
             else if(Config_class.getinstance().getDate_format().equals(format[3])){
                 selection=3;
             }
             
        return selection;
        
    }//End fill date format
    
    /**
    *Used to fill currency format field into the config menu
    * @return int with the actual selection
    */
    public static int fillCurrency(){
        char [] currency={'€','$','£'};
        int selection=0;
        
        if(Config_class.getinstance().getCurrency()==currency[0]){
            selection=0;
        }
        else if(Config_class.getinstance().getCurrency()==currency[1]){
            selection=1;
        }
        else if(Config_class.getinstance().getCurrency()==currency[2]){
            selection=2;
        }
        
        return selection;
    }//End fill currency
    
    /**
    *Used to fill language format field into the config menu
    * @return int with the actual selection
    */
    public static int fillLanguage(){
        String [] language={"en","es","val"};
        int selection=0;
        
        if(Config_class.getinstance().getLanguage().equals(language[0])){
            selection=0;
        }
        else if(Config_class.getinstance().getLanguage().equals(language[1])){
            selection=1;
        }
        else if(Config_class.getinstance().getLanguage().equals(language[2])){
            selection=2;
        }
        
        return selection;
        
    }//End fill language

    /**
    *Used to fill file format field into the config menu
    * @return int with the actual selection
    */
    public static int fillFileform(){
        String [] file_form={"json","txt","xml"};
        int selection=0;
        
        if(Config_class.getinstance().getFile_format().equals(file_form[0])){
            selection=0;
        }
        else if(Config_class.getinstance().getFile_format().equals(file_form[1])){
            selection=1;
        }
        else if(Config_class.getinstance().getFile_format().equals(file_form[2])){
            selection=2;
        }
        
        return selection;
        
    }//End fill file form
    
    /**
    *Used to fill theme field into the config menu
    * @return int with the actual selection
    */
    public static int fillTheme(){
        String [] theme={"Metal","Windows","Motif","Nimbus"};
        int selection=0;
        
        if(Config_class.getinstance().getTheme().equals(theme[0])){
            selection=0;
        }
        else if(Config_class.getinstance().getTheme().equals(theme[1])){
            selection=1;
        }
        else if(Config_class.getinstance().getTheme().equals(theme[2])){
            selection=2;
        }
        else if(Config_class.getinstance().getTheme().equals(theme[3])){
            selection=3;
        }
        
        return selection;
        
    }//End fill theme
    
    /**
    *Used to fill decimals format field into the config menu
    * @return int with the actual selection
    */
    public static int fillDecimals(){
        int selection=0;
        
        switch(Config_class.getinstance().getDecimals()){
            
            case 1:
                selection=0;
                break;
            case 2:
                selection=1;
                break;
            case 3:
                selection=2;
                break;
        }
        
        return selection;
        
    }//End fill deciamls
    
}//End DAO Config
