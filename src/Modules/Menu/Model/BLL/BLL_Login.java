/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules.Menu.Model.BLL;

import Modules.Menu.Model.DAO.DAO_Login;

/**
 *
 * @author antonio
 */
public class BLL_Login {
    
    
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
}
