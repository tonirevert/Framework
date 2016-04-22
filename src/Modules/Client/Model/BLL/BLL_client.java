/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules.Client.Model.BLL;

import Classes.Singleton_app;
import Modules.Client.Controller.ClientController;
import Modules.Client.Model.Utils.Files_lib.json;
import Modules.Client.Model.Utils.Files_lib.txt;
import Modules.Client.Model.Utils.Files_lib.xml;
import Modules.Client.Model.Utils.pager.pagina;
import Modules.Client.View.Modify_client;
import Modules.Client.View.Pager_client;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import static Modules.Client.View.Pager_client.pagerTable;
import Modules.Client.Model.Classes.Client_class;
import Modules.Client.Model.Classes.Singleton_client;
import static Modules.Client.Model.Classes.Singleton_client.cl;
import Modules.Client.Model.Classes.miniSimpleTableModel_client;
import Modules.Client.Model.DAO.DAO_client;
import Modules.Client.View.Create_client;
import Modules.Client.View.List_client;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * BLL to use all the DAO functions
 * @author antonio
 */
public class BLL_client {
    
    /**
     * Used to show a message on the Pager client info area
     */
    public static void PauseNoselect() {
        Timer delay = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        Pager_client.pagerInfo.setText("");
        Pager_client.pagerInfo.setBackground(Color.white);
        
            }
        });
        
        delay.setRepeats(false);
        delay.start();
        Pager_client.pagerInfo.setText(Singleton_app.lang.getProperty("bll_nosel"));
        Pager_client.pagerInfo.setBackground(Color.red);
    }
    
    /**
     * Used to show a message on the Pager client info area
     */
    public static void PauseEmpty() {
        Timer delay = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        Pager_client.pagerInfo.setText("");
        Pager_client.pagerInfo.setBackground(Color.white);
        
            }
        });
        
        delay.setRepeats(false);
        delay.start();
        Pager_client.pagerInfo.setText(Singleton_app.lang.getProperty("bll_lsempty"));
        Pager_client.pagerInfo.setBackground(Color.red);
    }
    
    /**
     * Used to show a message on the Pager client info area
     */
     public static void PauseIncomplete() {
        Timer delay = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        Create_client.areaInfo.setText("");
        Create_client.areaInfo.setBackground(Color.decode("#d6d6d6"));
            }
        });
        delay.setRepeats(false);
        delay.start();
        Create_client.areaInfo.setText(Singleton_app.lang.getProperty("bll_incomp"));
        Create_client.areaInfo.setBackground(Color.red);
    }
    
    public static int position=-1;
    
    /**
     * 
     */
    public static void askDniClick(){
        DAO_client.askDniClick();
    }
 
    /**
     * Used to reser all the fields in the create view
     */
    public static void resetFields(){
        DAO_client.resetFields();
    }
    
    /**
     * Used to check the create client fields
     * @param type to choose the action
     */
    public static void askClientdata(String type){
        boolean correct=false;
        String route="";
        
        switch(type){
            
            case "dni":
                correct = DAO_client.askDni();
                break;
                
            case "name":
                correct = DAO_client.askName();
                break;
            case "surname":
                correct = DAO_client.askSurname();
                break;
            case "email":
                correct = DAO_client.askEmail();
                break;
                
            case "mobile":
                correct = DAO_client.askMobile();
                break;
                
            case "user":
                correct = DAO_client.askUser();
                break;
                
            case "password":
                correct = DAO_client.askPassword();
                break;
                
            case "password2":
                correct = DAO_client.askPassword2();
                break;
                
            case "birthdate":
                correct= DAO_client.askBirth();
                break;
                
            case "avatar":
                route=DAO_client.askAvatar();
                break;
                
            case "datereg":
                correct = DAO_client.askDateRegistration();
                break;
                
            case "shopping":
                correct = DAO_client.askShopping();
                break;
            
            case "clienttype":
                correct = DAO_client.askCientType();
                break;
                
        }//End switch type
    }//End askAdmindata
    
    /**
     * Used to check the modify client fields
     * @param type to choose the action
     */
    public static void modClientdata(String type){
        boolean correct=false;
        String route="";
        
        switch(type){
            
            case "dni":
                correct = DAO_client.askDniMod();
                break;
                
            case "name":
                correct = DAO_client.askNameMod();
                break;
            case "surname":
                correct = DAO_client.askSurnameMod();
                break;
            case "email":
                correct = DAO_client.askEmailMod();
                break;
                
            case "mobile":
                correct = DAO_client.askMobileMod();
                break;
                
            case "user":
                correct = DAO_client.askUserMod();
                break;
                
            case "password":
                correct = DAO_client.askPasswordMod();
                break;
                
            case "password2":
                correct= DAO_client.askPassword2Mod();
                break;
                
            case "birthdate":
                correct= DAO_client.askBirthMod();
                break;
                
            case "avatar":
                route = DAO_client.askAvatarMod();
                break;
                
            case "datereg":
                correct = DAO_client.askDateRegistrationMod();
                break;
                
            case "shopping":
                correct = DAO_client.askShoppingMod();
                break;
            
            case "clienttype":
                correct = DAO_client.askCientTypeMod();
                break;
            
        }
    }//End modAdmindata
    
    /**
     * Used to search a user in the Array List
     * @return the position of the user in the Array List
     */
    public static int searchclient(){
		Client_class client=null;
		client= new Client_class(Create_client.fieldDNI.getText());
		
		for (int i = 0;i<=(Singleton_client.cli.size()-1);i++){
			if((Singleton_client.cli.get(i)).equals(client) ){
                                                return i;
                                                }
		}
		return -1;
	}//End searchDniadmin admin
    
    /**
     * Used to search a user in the Array List
     * @return the position of the user in the Array List
     */
    public static int searchDniclient(){
        int out=0;
        Client_class client=null;
        client= new Client_class(Create_client.fieldDNI.getText());
        for (int i = 0;i<=(Singleton_client.cli.size()-1);i++){
            if((Singleton_client.cli.get(i)).equals(client) ){
                    out=-1;
                }
        }

        return out;
        
    }
    
    /**
     * Used to search a Client user in the Array List
     * @param cli an Admin user to search for
     * @return the position of the user in the Array List
     */
    public static int searchclientMod(Client_class cli){
        int aux=-1;
        for(int i=0; i<=(Singleton_client.cli.size()-1);i++){
            if(Singleton_client.cli.get(i).equals(cli)){
                aux=i;
            }
        }
        return aux;
    }//End searchadminMod
    
    /**
     * Use the DAO create function and check's if user is created correctly
     * @return boolean true if the the user is created correctly
     */
    public static boolean create_client(){
        Client_class client=null;
        client=DAO_client.create();
        boolean created=false;
        
        if (client== null){
            PauseIncomplete();
            created=false;
        }else{
            Singleton_client.cli.add(client);
            BLL_Mongo_client.insert_Client(client);
//            autosaveClient();
            Create_client.areaInfo.setText(Singleton_app.lang.getProperty("bll_created"));
            Create_client.areaInfo.setBackground(Color.green);
            created=true;
        }
        
        return created;
        
    }//End create_admin
    
    /**
     * Used to fill modify user window with the user data
     * @param dni string with the desired dni to find and fill
     * @return Client user
     */
    public static Client_class fill_client(String dni){
        Client_class cli=new Client_class(dni);
        
        position=BLL_client.searchclientMod(cli);
        
        if (position==-1){
            JOptionPane.showMessageDialog(null,"Not found");
            cli=null;
        }else{
//            System.out.println("else fill BLL admin");
            cli=Singleton_client.cli.get(position);
            DAO_client.fillClientMod(cli);
        }
        
        return cli;
    }

    /**
     * Used to fill modify user window with the user data
     * @return Client user
     */
    public static Client_class fill_client(){
        Client_class cli=cl;
        
        position=BLL_client.searchclientMod(cli);
        
        if (position==-1){
            JOptionPane.showMessageDialog(null,"Not found");
            cli=null;
        }else{
//            System.out.println("else fill BLL admin");
            cli=Singleton_client.cli.get(position);
            DAO_client.fillClientMod(cli);
        }
        
        return cli;
    }
    
    /**
     * Save the modified user into the database
     * @return boolean with the result of the process
     */
    public static boolean save_mod_client(){

        boolean correct=false;
        Client_class client= null;

            client=DAO_client.saveClientMod();
             if (client== null){
            correct=false;
        }else{
                 BLL_Mongo_client.update_Client(client);
//                 Singleton_client.cli.set(position,client);
            
//            autosaveClient();
//            resetFields();
            correct=true;
            position=-1;
            }
             return correct;
    }//End save mod client

        /**
        * Used to edit a row from the table on pager client
        */
     public static boolean edit_client() {
        String dni;
        int selection, inicio, selection1;
        boolean correct;
        
        int n=((miniSimpleTableModel_client) Pager_client.pagerTable.getModel()).getRowCount();
        if (n != 0) {
                 inicio=(pagina.currentPageIndex-1)*pagina.itemsPerPage; //nos situamos al inicio de la página en cuestión
                selection=Pager_client.pagerTable.getSelectedRow(); //nos situamos en la fila
                selection1=inicio+selection; //nos situamos en la fila correspondiente de esa página
            if (selection1 == -1) {
                PauseNoselect();
                correct = false;
            } else {
                dni = (String) Pager_client.pagerTable.getModel().getValueAt(selection1, 0);

                Singleton_client.cl = new Client_class(dni);
                new ClientController(new Modify_client(),1).Init(1);
                correct = true;

            }
        } else {
            PauseEmpty();
            correct = false;
        }
        return correct;
    }
    
        /**
        * Used to delete a row from the table on pager client
        */
        public static void delete_file() {
                String dni;

                int pos;
                int selection, inicio, selection1;

                int n=((miniSimpleTableModel_client) Pager_client.pagerTable.getModel()).getRowCount();
                if (n != 0) {
                         inicio=(pagina.currentPageIndex-1)*pagina.itemsPerPage; //nos situamos al inicio de la página en cuestión
                        selection=Pager_client.pagerTable.getSelectedRow(); //nos situamos en la fila
                        selection1=inicio+selection; //nos situamos en la fila correspondiente de esa página
                    if (selection1 == -1) {
                        PauseNoselect();
                    } else {
                        dni = (String) pagerTable.getModel().getValueAt(selection1, 0);
                        Singleton_client.cl = new Client_class(dni);
                        pos = BLL_client.searchclientMod((Client_class) cl);
                        int opc = JOptionPane.showConfirmDialog(null, Singleton_app.lang.getProperty("bll_remove") + dni+"?",
                                "Info", JOptionPane.WARNING_MESSAGE);

                        if (opc == 0) {
                            ((miniSimpleTableModel_client) pagerTable.getModel()).removeRow(selection1);
                            cl = Singleton_client.cli.get(pos);
                            
                                if(cl.getAvatar().equals(Singleton_client.defaultavatar.toString())){

                            }else{try {
                                //Deletes the file if exists
                                Files.delete(Paths.get(cl.getAvatar()));
                                } catch (IOException ex) {
                                    Logger.getLogger(BLL_client.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            Singleton_client.cli.remove(cl);
                            BLL_Mongo_client.remove_Client(cl);
//                            autosaveClient();
                        }

                        if (((miniSimpleTableModel_client) pagerTable.getModel()).getRowCount() == 0) {
                            if (((miniSimpleTableModel_client) pagerTable.getModel()).getRowCount() != 0) {

                            }
                        }
                    }

                } else {
                    PauseEmpty();
                }
        }//End delete_file
    
       /**
        * Used to list a row from the table on pager client
        */
     public static boolean list_client() {
        String dni;
        Client_class cluser=null;
        int selection, inicio, selection1;
        boolean correct;
        
        int n=((miniSimpleTableModel_client) Pager_client.pagerTable.getModel()).getRowCount();
        if (n != 0) {
                 inicio=(pagina.currentPageIndex-1)*pagina.itemsPerPage; //nos situamos al inicio de la página en cuestión
                selection=Pager_client.pagerTable.getSelectedRow(); //nos situamos en la fila
                selection1=inicio+selection; //nos situamos en la fila correspondiente de esa página
            if (selection1 == -1) {
                PauseNoselect();
                correct = false;
            } else {
                dni = (String) Pager_client.pagerTable.getModel().getValueAt(selection1, 0);
                cluser = new Client_class(dni);
                new ClientController(new List_client(),3).Init(3);
                List_client.StringArea.setText(Singleton_client.cli.get(searchclientMod(cluser)).toString());
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
    public static void autosaveClient(){
        json.autosavejsonclient();
    }
    
    /**
     * Funciton to auto load user in json format
     */
    public static void autoloadClient(){
        json.autoloadjsonclient();
    }
    
    /**
     * Funciton to save to json
     */
    public static void savejsonClient(){
        json.savejsonclient();
    }
    
    /**
     * Funciton to save to txt
     */
    public static void savetxtClient(){
        txt.savetxtclient();
    }
    
    /**
     * Funciton to save to xml
     */
    public static void savexmlClient(){
        xml.savexmlclient();
    }
    
    
}//End public class BLL_client
