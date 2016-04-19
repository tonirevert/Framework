/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules.Reg_user.Model.BLL;

import Classes.Singleton_app;
import Modules.Reg_user.Controller.RuserController;
import Modules.Reg_user.Model.Utils.Files_lib.json;
import Modules.Reg_user.Model.Classes.Reg_user_class;
import Modules.Reg_user.Model.Classes.Singleton_ruser;
import static Modules.Reg_user.Model.Classes.Singleton_ruser.ru;
import Modules.Reg_user.Model.Classes.miniSimpleTableModel_ruser;
import Modules.Reg_user.Model.DAO.DAO_ruser;
import Modules.Reg_user.Model.Utils.Files_lib.txt;
import Modules.Reg_user.Model.Utils.Files_lib.xml;
import Modules.Reg_user.Model.Utils.pager.pagina;
import Modules.Reg_user.View.Create_ruser;
import Modules.Reg_user.View.List_ruser;
import Modules.Reg_user.View.Modify_ruser;
import Modules.Reg_user.View.Pager_ruser;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import static Modules.Reg_user.View.Pager_ruser.pagerTable;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * BLL to use all the DAO functions
 * @author antonio
 */
public class BLL_ruser {
    
    /**
     * Used to show a message on the Pager ruser info area
     */
    public static void PauseNoselect() {
        Timer delay = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        Pager_ruser.pagerInfo.setText("");
        Pager_ruser.pagerInfo.setBackground(Color.white);
        
            }
        });
        
        delay.setRepeats(false);
        delay.start();
        Pager_ruser.pagerInfo.setText(Singleton_app.lang.getProperty("bll_nosel"));
        Pager_ruser.pagerInfo.setBackground(Color.red);
    }
    
    /**
     * Used to show a message on the Pager ruser info area
     */
    public static void PauseEmpty() {
        Timer delay = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        Pager_ruser.pagerInfo.setText("");
        Pager_ruser.pagerInfo.setBackground(Color.white);
        
            }
        });
        
        delay.setRepeats(false);
        delay.start();
        Pager_ruser.pagerInfo.setText(Singleton_app.lang.getProperty("bll_lsempty"));
        Pager_ruser.pagerInfo.setBackground(Color.red);
    }
    
    /**
     * Used to show a message on the Pager ruser info area
     */
     public static void PauseIncomplete() {
        Timer delay = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        Create_ruser.areaInfo.setText("");
        Create_ruser.areaInfo.setBackground(Color.decode("#d6d6d6"));
            }
        });
        delay.setRepeats(false);
        delay.start();
        Create_ruser.areaInfo.setText(Singleton_app.lang.getProperty("bll_incomp"));
        Create_ruser.areaInfo.setBackground(Color.red);
    }
    
    public static int position=-1;
    
    /**
     * 
     */
    public static void askDniClick(){
        DAO_ruser.askDniClick();
    }
 
    /**
     * Used to reser all the fields in the create view
     */
    public static void resetFields(){
        DAO_ruser.resetFields();
    }
    
    /**
     * Used to check the create ruser fields
     * @param type to choose the action
     */
    public static void askRuserdata(String type){
        boolean correct=false;
        String route="";
        
        switch(type){
            
            case "dni":
                correct = DAO_ruser.askDni();
                break;
                
            case "name":
                correct = DAO_ruser.askName();
                break;
                
            case "surname":
                correct = DAO_ruser.askSurname();
                break;
                
            case "email":
                correct = DAO_ruser.askEmail();
                break;
                
            case "mobile":
                correct = DAO_ruser.askMobile();
                break;
                
            case "user":
                correct = DAO_ruser.askUser();
                break;
                
            case "password":
                correct = DAO_ruser.askPassword();
                break;
                
            case "password2":
                correct = DAO_ruser.askPassword2();
                break;
                
            case "birthdate":
                correct= DAO_ruser.askBirth();
                break;
                
            case "avatar":
                route=DAO_ruser.askAvatar();
                break;
                
            case "activity":
                correct = DAO_ruser.askActivity();
                break;
                
//            case "karma":
//                correct = DAO_ruser.askKarma();
//                break;
            
        }
    }//End askRuserdata
    
    /**
     * Used to check the modify ruser fields
     * @param type to choose the action
     */
    public static void modRuserdata(String type){
        boolean correct=false;
        String route="";
        
        switch(type){
            
            case "dni":
                correct = DAO_ruser.askDniMod();
                
                break;
                
            case "name":
                correct = DAO_ruser.askNameMod();
                
                break;
            case "surname":
                correct = DAO_ruser.askSurnameMod();
                
                break;
            case "email":
                correct = DAO_ruser.askEmailMod();
                
                break;
                
            case "mobile":
                correct = DAO_ruser.askMobileMod();
                
                break;
                
            case "user":
                correct = DAO_ruser.askUserMod();
                
                break;
                
            case "password":
                correct = DAO_ruser.askPasswordMod();
                
                break;
                
            case "password2":
                correct= DAO_ruser.askPassword2Mod();
                break;
                
            case "birthdate":
                correct= DAO_ruser.askBirthMod();
                
                break;
                
            case "avatar":
                route = DAO_ruser.askAvatarMod();
                
                break;
                
            case "activity":
                correct = DAO_ruser.askActivityMod();
                break;
                
//            case "karma":
//                correct= DAO_ruser.askKarmaMod();
//                break;
            
        }
    }//End modRuserdata
    
    /**
     * Used to search a user in the Array List
     * @return the position of the user in the Array List
     */
    public static int searchruser(){
		Reg_user_class ruser=null;
		ruser= new Reg_user_class(Create_ruser.fieldDNI.getText());
		
		for (int i = 0;i<=(Singleton_ruser.rus.size()-1);i++){
			if((Singleton_ruser.rus.get(i)).equals(ruser) ){
                                                return i;
                                                }
		}
		return -1;
	}//End searchDniruser ruser
    
    /**
     * Used to search a user in the Array List
     * @return the position of the user in the Array List
     */
    public static int searchDniruser(){
        int out=0;
        Reg_user_class admin=null;
        admin= new Reg_user_class(Create_ruser.fieldDNI.getText());
        for (int i = 0;i<=(Singleton_ruser.rus.size()-1);i++){
            if((Singleton_ruser.rus.get(i)).equals(admin) ){
                    out=-1;
                }
        }

        return out;
        
    }
    
    /**
     * Used to search a Registered user in the Array List
     * @param rus an Admin user to search for
     * @return the position of the user in the Array List
     */
    public static int searchruserMod(Reg_user_class rus){
        int aux=-1;
        for(int i=0; i<=(Singleton_ruser.rus.size()-1);i++){
            if(Singleton_ruser.rus.get(i).equals(rus)){
                aux=i;
            }
        }
        return aux;
    }//End searchruserMod
    
    /**
     * Use the DAO create function and check's if user is created correctly
     * @return boolean true if the the user is created correctly
     */
    public static boolean create_ruser(){
        Reg_user_class ruser=null;
        ruser=DAO_ruser.create();
        boolean created=false;
        
        if (ruser== null){
            PauseIncomplete();
            created=false;
        }else{
            Singleton_ruser.rus.add(ruser);
            autosaveRuser();
            Create_ruser.areaInfo.setText(Singleton_app.lang.getProperty("bll_created"));
            Create_ruser.areaInfo.setBackground(Color.green);
            created=true;
        }
        
        return created;
        
    }//End create_ruser
    
    /**
     * Used to fill modify user window with the user data
     * @param dni string with the desired dni to find and fill
     * @return Reg user
     */
    public static Reg_user_class fill_ruser(String dni){
        Reg_user_class rus=new Reg_user_class(dni);
        
        position=BLL_ruser.searchruserMod(rus);
        
        if (position==-1){
            JOptionPane.showMessageDialog(null,"Not found");
            rus=null;
        }else{
//            System.out.println("else fill BLL ruser");
            rus=Singleton_ruser.rus.get(position);
            DAO_ruser.fillRuserMod(rus);
        }
        
        return rus;
    }

    /**
     * Used to fill modify user window with the user data
     * @return Reg user
     */
    public static Reg_user_class fill_ruser(){
        Reg_user_class rus=ru;
        
        position=BLL_ruser.searchruserMod(rus);
        
        if (position==-1){
            JOptionPane.showMessageDialog(null,"Not found");
            rus=null;
        }else{
//            System.out.println("else fill BLL ruser");
            rus=Singleton_ruser.rus.get(position);
            DAO_ruser.fillRuserMod(rus);
        }
        
        return rus;
    }
    
    /**
     * Save the modified user into the database
     * @return boolean with the result of the process
     */
    public static boolean save_mod_ruser(){

        boolean correct=false;
        Reg_user_class ruser= null;

            ruser=DAO_ruser.saveRuserMod();
             if (ruser== null){
            correct=false;
        }else{
            Singleton_ruser.rus.set(position,ruser);
            autosaveRuser();
//            resetFields();
            correct=true;
            position=-1;
            }
             return correct;
    }

        /**
        * Used to edit a row from the table on pager ruser
        */
     public static boolean edit_ruser() {
        String dni;
        int selection, inicio, selection1;
        boolean correct;
        
        int n=((miniSimpleTableModel_ruser) Pager_ruser.pagerTable.getModel()).getRowCount();
        if (n != 0) {
                 inicio=(pagina.currentPageIndex-1)*pagina.itemsPerPage; //nos situamos al inicio de la página en cuestión
                selection=Pager_ruser.pagerTable.getSelectedRow(); //nos situamos en la fila
                selection1=inicio+selection; //nos situamos en la fila correspondiente de esa página
            if (selection1 == -1) {
                PauseNoselect();
                correct = false;
            } else {
                dni = (String) Pager_ruser.pagerTable.getModel().getValueAt(selection1, 0);

                Singleton_ruser.ru = new Reg_user_class(dni);
                new RuserController(new Modify_ruser(),1).Init(1);
                correct = true;

            }
        } else {
            PauseEmpty();
            correct = false;
        }
        return correct;
    }
    
        /**
        * Used to delete a row from the table on pager ruser
        */
        public static void delete_file(){
        String dni;
        
        int pos;
        int selection, inicio, selection1;
        
        int n=((miniSimpleTableModel_ruser) Pager_ruser.pagerTable.getModel()).getRowCount();
        if (n != 0) {
                 inicio=(pagina.currentPageIndex-1)*pagina.itemsPerPage; //nos situamos al inicio de la página en cuestión
                selection=Pager_ruser.pagerTable.getSelectedRow(); //nos situamos en la fila
                selection1=inicio+selection; //nos situamos en la fila correspondiente de esa página
            if (selection1 == -1) {
                PauseNoselect();
            } else {
                dni = (String) pagerTable.getModel().getValueAt(selection1, 0);
                Singleton_ruser.ru = new Reg_user_class(dni);
                pos = BLL_ruser.searchruserMod((Reg_user_class) ru);
                int opc = JOptionPane.showConfirmDialog(null, Singleton_app.lang.getProperty("bll_remove") + dni+"?",
                        "Info", JOptionPane.WARNING_MESSAGE);

                if (opc == 0) {
                    ((miniSimpleTableModel_ruser) pagerTable.getModel()).removeRow(selection1);
                    ru = Singleton_ruser.rus.get(pos);
                            if(ru.getAvatar().equals(Singleton_ruser.defaultavatar.toString())){

                            }else{try {
                                //Deletes the file if exists
                                Files.delete(Paths.get(ru.getAvatar()));
                        } catch (IOException ex) {
                            Logger.getLogger(BLL_ruser.class.getName()).log(Level.SEVERE, null, ex);
                        }
                            }
                    Singleton_ruser.rus.remove(ru);
                    autosaveRuser();
                }

                if (((miniSimpleTableModel_ruser) pagerTable.getModel()).getRowCount() == 0) {
                    if (((miniSimpleTableModel_ruser) pagerTable.getModel()).getRowCount() != 0) {

                    }
                }
            }

        } else {
            PauseEmpty();
        }
//       ((miniSimpleTableModel_admin)TABLA.getModel()).cargar();

    }

        /**
        * Used to list a row from the table on pager reg user
        */
     public static boolean list_ruser() {
        String dni;
        Reg_user_class ruser=null;
        int selection, inicio, selection1;
        boolean correct;
        
        int n=((miniSimpleTableModel_ruser) Pager_ruser.pagerTable.getModel()).getRowCount();
        if (n != 0) {
                 inicio=(pagina.currentPageIndex-1)*pagina.itemsPerPage; //nos situamos al inicio de la página en cuestión
                selection=Pager_ruser.pagerTable.getSelectedRow(); //nos situamos en la fila
                selection1=inicio+selection; //nos situamos en la fila correspondiente de esa página
            if (selection1 == -1) {
                PauseNoselect();
                correct = false;
            } else {
                dni = (String) Pager_ruser.pagerTable.getModel().getValueAt(selection1, 0);
                ruser=new Reg_user_class(dni);
                new RuserController(new List_ruser(),3).Init(3);
                List_ruser.StringArea.setText(Singleton_ruser.rus.get(searchruserMod(ruser)).toString());
                correct = true;

            }
        } else {
            PauseEmpty();
            correct = false;
        }
        return correct;
    }
        
    /**
     * Funciton to auto save user in json format
     */
    public static void autosaveRuser(){
        json.autosavejsonruser();
    }
    
    /**
     * Funciton to auto load user in json format
     */
    public static void autoloadRuser(){
        json.autoloadjsonruser();
    }
    
    /**
     * Funciton to save to json
     */
    public static void savejsonRuser(){
        json.savejsonruser();
    }
    
    /**
     * Funciton to save to txt
     */
    public static void savetxtRuser(){
        txt.savetxtruser();
    }
    
    /**
     * Funciton to save to xml
     */
    public static void savexmlRuser(){
        xml.savexmlruser();
    }
    
}//End public class BLL_admin
