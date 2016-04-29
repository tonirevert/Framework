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
 *
 * @author antonio
 */
public class BLL_Login {
    
    public static void setLang(String Language){
        
        DAO_Login.setLang(Language);
        Login.labelId.setText(Singleton_app.lang.getProperty("idcard"));
        Login.labelPass.setText(Singleton_app.lang.getProperty("u_password"));
        Login.showPass.setText(Singleton_app.lang.getProperty("log_showpass"));
        Login.btnOk.setText(Singleton_app.lang.getProperty("log_ok"));
        Login.btnCancel.setText(Singleton_app.lang.getProperty("w_Cancel"));
    }
    
    public static void setIcons(){
        DAO_Login.setIcons();
        Login.labelId.setText(Singleton_app.lang.getProperty("idcard"));
        Login.labelPass.setText(Singleton_app.lang.getProperty("u_password"));
        Login.showPass.setText(Singleton_app.lang.getProperty("log_showpass"));
        Login.btnOk.setText(Singleton_app.lang.getProperty("log_ok"));
        Login.btnCancel.setText(Singleton_app.lang.getProperty("w_Cancel"));
    }
    
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
    
    public static void Try_Login(){
        DAO_Login.tryLogin();
    }
}
