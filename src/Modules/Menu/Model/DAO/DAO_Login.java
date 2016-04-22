/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules.Menu.Model.DAO;

import Modules.Admin.Model.BLL.BLLDB_admin;
import Modules.Admin.Model.Classes.Admin_class;
import Modules.Admin.Model.Classes.Singleton_admin;
import Modules.Client.Model.BLL.BLL_Mongo_client;
import Modules.Client.Model.Classes.Client_class;
import Modules.Reg_user.Model.Classes.Reg_user_class;
import static Modules.Menu.Classes.Singleton_menus.no_ok;
import static Modules.Menu.Classes.Singleton_menus.ok;
import Modules.Menu.Controller.MenuController;
import static Modules.Menu.Controller.MenuController.login;
import Modules.Menu.View.Login;
import Modules.Menu.View.Mainmenu;
import Utils.Validate;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author antonio
 */
public class DAO_Login {
    
    public static void loginError1(){
        Timer delay = new Timer(2000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Login.info.setText("");
                    }
             });
                        delay.setRepeats(false);
                        delay.start();
                        Login.info.setText("<html><font color=red>Login or password incorrect!</font></html>");
    }
    
    public static void loginError2(){
        Timer delay = new Timer(2000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Login.info.setText("");
                    }
             });
                        delay.setRepeats(false);
                        delay.start();
                        Login.info.setText("<html><font color=red>Password incorrect!</font></html>");
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
        
         if(Validate.valpass(Login.fieldPass.getText())==true){
            Login.checkPass.setIcon(ok);
            correct=true;
        }else {
            Login.checkPass.setIcon(no_ok);
            correct=false;
        }
         return correct;
    }
    
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
    
    public static boolean tryLogin(){
        
        Object out=null;
        Admin_class adm=null;
        Client_class cli=null;
        Reg_user_class rus=null;
        String dni="",pass="";
        boolean correct=false;
        boolean foundAdmin=false, foundClient=false, foundRuser=false, fiId=false, fiPass=false;
        
        fiId=askDni();
        fiPass=askPass();
        
        if(fiId==true && fiPass==true){
            dni=Login.fieldId.getText();
            pass=Login.fieldPass.getText();
            adm=new Admin_class(dni);
            Singleton_admin.a=adm;
            BLLDB_admin.SearchAdminBLL();
            if(Singleton_admin.a.getPass()!=null){
                System.out.println("User found password: "+Singleton_admin.a.getPass());
                if(Singleton_admin.a.getPass().equals(pass)){
                login.dispose();
                new MenuController(new Mainmenu(), 0).Init(0);
                }else{
                    loginError2();
                }
            }else{
                    System.out.println("Error 1");
                loginError1();
            
            
            }//End if / else admin users
            cli=BLL_Mongo_client.load_Client_dni(dni);
        }else if(cli.getName()!=null){
            if(cli.getPass().equals(pass)){
                
            }
        
        }else{
            out=null;
            System.out.println("Error 2");
            loginError1();
        }
        
        out=adm;
        return correct;
    }
}
