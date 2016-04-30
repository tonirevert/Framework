/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules.Menu.Model.BLL;

import Classes.Singleton_app;
import Modules.Menu.Model.DAO.DAO_Login;
import Modules.Menu.View.Login;

/**
 * Used for the log-in window
 * @author antonio
 */
public class BLL_Login {
    
    /**
     * * Used to set the log-in icons when a language icon is clicked
     * @param Language the desired language to set: en, es, val
     */
    public static void setLang(String Language){
        
        DAO_Login.setLang(Language);
        Login.labelId.setText(Singleton_app.lang.getProperty("idcard"));
        Login.labelPass.setText(Singleton_app.lang.getProperty("u_password"));
        Login.showPass.setText(Singleton_app.lang.getProperty("log_showpass"));
        Login.btnOk.setText(Singleton_app.lang.getProperty("log_ok"));
        Login.btnCancel.setText(Singleton_app.lang.getProperty("w_Cancel"));
    }
    
    /**
     * Used to set the log-in icons in function of the configured language
     */
    public static void setIcons(){
        DAO_Login.setIcons();
        Login.labelId.setText(Singleton_app.lang.getProperty("idcard"));
        Login.labelPass.setText(Singleton_app.lang.getProperty("u_password"));
        Login.showPass.setText(Singleton_app.lang.getProperty("log_showpass"));
        Login.btnOk.setText(Singleton_app.lang.getProperty("log_ok"));
        Login.btnCancel.setText(Singleton_app.lang.getProperty("w_Cancel"));
    }
    
    /**
     * Used to check the log-in input fields
     * @param type String with the parameter, dni, password
     */
    public static void askUserdata(String type){
        boolean correct=false;
        String route="";
        
        switch(type){
            
            case "dni":
                correct = DAO_Login.askDni();
                
                break;
                
            case "password":
                correct=DAO_Login.askPass();
                break;
                
            case "showpassword":
                DAO_Login.showPass();
                break;
                
            case "reset":
                DAO_Login.resetFields();
                break;
        }
    }//End of ask User data
    
    /**
     * Function to use try Login from DAO
     */
    public static void Try_Login(){
        DAO_Login.tryLogin();
    }
}
