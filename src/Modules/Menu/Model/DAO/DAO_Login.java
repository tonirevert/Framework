/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules.Menu.Model.DAO;

import Classes.Singleton_app;
import Modules.Admin.Model.BLL.BLLDB_admin;
import Modules.Admin.Model.Classes.Admin_class;
import Modules.Admin.Model.Classes.Singleton_admin;
import Modules.Client.Model.BLL.BLL_Mongo_client;
import Modules.Client.Model.Classes.Client_class;
import Modules.Client.View.Modify_client;
import Modules.Config.Model.Classes.Config_class;
import Modules.Menu.Classes.Singleton_menus;
import Modules.Reg_user.Model.Classes.Reg_user_class;
import static Modules.Menu.Classes.Singleton_menus.no_ok;
import static Modules.Menu.Classes.Singleton_menus.ok;
import static Modules.Menu.Classes.Singleton_menus.seteng;
import static Modules.Menu.Classes.Singleton_menus.setspa;
import static Modules.Menu.Classes.Singleton_menus.setval;
import static Modules.Menu.Classes.Singleton_menus.unseteng;
import static Modules.Menu.Classes.Singleton_menus.unsetspa;
import static Modules.Menu.Classes.Singleton_menus.unsetval;
import Modules.Menu.Controller.MenuController;
import static Modules.Menu.Controller.MenuController.login;
import Modules.Menu.View.Login;
import Modules.Menu.View.Mainmenu;
import Modules.Reg_user.Model.BLL.BLL_ruser;
import Modules.Reg_user.Model.Classes.Singleton_ruser;
import Modules.Reg_user.View.Modify_ruser;
import Utils.Validate;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author antonio
 */
public class DAO_Login {
    
    /**
     * Used to show a message using a delay in log-in window
     */
    public static void loginError1(){
        Timer delay = new Timer(2000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Login.info.setText("");
                    }
             });
                        delay.setRepeats(false);
                        delay.start();
                        Login.info.setText(Singleton_app.lang.getProperty("log_error"));
    }
    
    /**
     * Used to show a message using a delay in log-in window
     */
    public static void loginError2(){
        Timer delay = new Timer(2000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Login.info.setText("");
                    }
             });
                        delay.setRepeats(false);
                        delay.start();
                        Login.info.setText(Singleton_app.lang.getProperty("log_error2"));
    }
    
    /**
     * Used to change the language icons in log-in window
     */
    public static void setIcons(){
        
        switch(Config_class.getinstance().getLanguage()){
        
            case "en":
                Login.setEnglish.setIcon(seteng);
                Login.setSpanish.setIcon(unsetspa);
                Login.setValencian.setIcon(unsetval);
                break;
                
            case "es":
                Login.setEnglish.setIcon(unseteng);
                Login.setSpanish.setIcon(setspa);
                Login.setValencian.setIcon(unsetval);
                break;
                
            case "val":
                Login.setEnglish.setIcon(unseteng);
                Login.setSpanish.setIcon(unsetspa);
                Login.setValencian.setIcon(setval);
                break;
    }
        
    }
    
    /**
     * Used to set a new language configuration
     * @param Language a String with the language to set, en for english, es for spanish, val for valencian
     */
    public static void setLang(String Language){
        
        if(Language.equals("en")){
            Config_class.getinstance().setLanguage("en");
            setIcons();
        }
        else if(Language.equals("es")){
            Config_class.getinstance().setLanguage("es");
            setIcons();
        }
        else if(Language.equals("val")){
            Config_class.getinstance().setLanguage("val");
            setIcons();
        }
    }
    
    /**
     * Used to check the DNI of a user
     * @return bollean true if ferification is correct
     */
    public static boolean askDni(){
        boolean correct =false;
//        System.out.println(BLL_admin.searchDniadmin());
         if(Validate.validateDNI(Login.fieldId.getText())==true){
            Login.checkDNI.setIcon(ok);
            correct = true;
        }else{
            Login.checkDNI.setIcon(no_ok);
            correct=false;
        }
        return correct;
    }//End of ask DNI
    
     /**
     * Used to check the password of a user
     * @return bollean true if ferification is correct
     */
    public static boolean askPass(){
        boolean correct=false;
        String pass="";
        
         if(Validate.valpass(String.valueOf(Login.fieldPass.getPassword()))==true){
            Login.checkPass.setIcon(ok);
            correct=true;
        }else {
            Login.checkPass.setIcon(no_ok);
            correct=false;
        }
         return correct;
    }
    
    /**
     * Used to show the password in the log-in window
     */
    public static void showPass(){
        if(Login.showPass.isSelected()==true){
            Login.fieldPass.setEchoChar((char)0);
        }else{
            Login.fieldPass.setEchoChar('*');
        }
    }
    
    public static void resetFields(){
        Login.fieldId.setText("");
        Login.fieldPass.setText("");
        Login.showPass.setSelected(false);
        askDni();
        askPass();
        showPass();
    }
   
    /**
     * Function to check the log-in of the users
     */
    public static void tryLogin(){
        
        Object out=null;
        Admin_class adm=null;
        Client_class cli=null;
        Reg_user_class rus=null;
        String dni="",pass="";
        int pos=0;
        boolean correct=false;
        boolean foundAdmin=false, foundClient=false, foundRuser=false, fiId=false, fiPass=false;
        
        fiId=askDni();
        fiPass=askPass();
        
        if(fiId==true && fiPass==true){
            dni=Login.fieldId.getText();
//            pass=Login.fieldPass.getText();
            pass=String.valueOf(Login.fieldPass.getPassword());
            
            //Start search admin user
            adm=new Admin_class(dni);
            Singleton_admin.a=adm;
            BLLDB_admin.SearchAdminBLL();
            if(Singleton_admin.a.getPass()!=null){
//                System.out.println("User found password: "+Singleton_admin.a.getPass());
                if(Singleton_admin.a.getPass().equals(pass)){
                login.dispose();
                new MenuController(new Mainmenu(), 0).Init(0);
                }else{
                    loginError1();
                }
            }//End if admin users
            
            //Start search client user
            cli=new Client_class(dni);
            cli=BLL_Mongo_client.load_Client_dni(dni);
            if(cli.getPass()!=null){
                Singleton_menus.cli=cli;
//                System.out.println(cli.getName());
                if(cli.getPass().equals(pass)){
                    login.dispose();
                    new MenuController(new Modify_client(), 3).Init(3);
                }else{
                    loginError1();
                }
            }//End else if client
            
//            Singleton_ruser.ru=new Reg_user_class(dni);
            pos=BLL_ruser.searchruser(dni);
            Singleton_menus.pos_rus=pos;
            if(pos!=-1){
                Singleton_menus.rus=Singleton_ruser.rus.get(pos);
                if(Singleton_menus.rus.getPass().equals(pass)){
                    login.dispose();
                    new MenuController(new Modify_ruser(),4).Init(4);
//                    JOptionPane.showMessageDialog(null,rus.toString());
                }else{
                    loginError1();
                }
            }else{
//                System.out.println("Error 1");
                loginError1();
            }
            
            
        }else{
            out=null;
//            System.out.println("Error 2");
            loginError1();
        }
        
        out=adm;
//        return correct;
    }
}//End of DAO log-in
