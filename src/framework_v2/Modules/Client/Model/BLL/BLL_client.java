/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework_v2.Modules.Client.Model.BLL;

import framework_v2.Modules.Client.Controller.ClientController;
import framework_v2.Modules.Client.Model.Utils.Files_lib.json;
import framework_v2.Modules.Client.Model.Utils.Files_lib.txt;
import framework_v2.Modules.Client.Model.Utils.Files_lib.xml;
import framework_v2.Modules.Client.Model.Utils.pager.pagina;
import framework_v2.Modules.Client.View.Modify_client;
import framework_v2.Modules.Client.View.Pager_client;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import static framework_v2.Modules.Client.View.Pager_client.pagerTable;
import framework_v2.Modules.Client.Model.Classes.Client_class;
import framework_v2.Modules.Client.Model.Classes.Singleton_client;
import static framework_v2.Modules.Client.Model.Classes.Singleton_client.cl;
import framework_v2.Modules.Client.Model.Classes.miniSimpleTableModel_client;
import framework_v2.Modules.Client.Model.DAO.DAO_client;
import framework_v2.Modules.Client.View.Create_client;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author antonio
 */
public class BLL_client {
    
    /**
     * Used to show a message on the Pager admin info area
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
        Pager_client.pagerInfo.setText("No user selected!");
        Pager_client.pagerInfo.setBackground(Color.red);
    }
    
    /**
     * Used to show a message on the Pager admin info area
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
        Pager_client.pagerInfo.setText("List empty!");
        Pager_client.pagerInfo.setBackground(Color.red);
    }
    
    /**
     * Used to show a message on the Pager admin info area
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
        Create_client.areaInfo.setText("User data incomplete, please revise it!");
        Create_client.areaInfo.setBackground(Color.red);
    }
    
    public static int position=-1;
    
    public static void askDniClick(){
        DAO_client.askDniClick();
    }
 
    /**
     * 
     */
    public static void resetFields(){
        DAO_client.resetFields();
    }
    
    /**
     * Used to check the create admin fields
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
     * Used to check the modify admin fields
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
     * 
     * @return 
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
    
    public static int searchclientMod(Client_class cli){
        int aux=-1;
        for(int i=0; i<=(Singleton_client.cli.size()-1);i++){
            if(Singleton_client.cli.get(i).equals(cli)){
                aux=i;
            }
        }
        return aux;
    }//End searchadminMod
    
    public static boolean create_client(){
        Client_class client=null;
        client=DAO_client.create();
        boolean created=false;
        
        if (client== null){
            PauseIncomplete();
            created=false;
        }else{
            Singleton_client.cli.add(client);
            autosaveClient();
            Create_client.areaInfo.setText("User created correctly");
            Create_client.areaInfo.setBackground(Color.green);
            created=true;
        }
        
        return created;
        
    }//End create_admin
    
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
    
    public static boolean save_mod_client(){

        boolean correct=false;
        Client_class client= null;

            client=DAO_client.saveClientMod();
             if (client== null){
            correct=false;
        }else{
            Singleton_client.cli.set(position,client);
            autosaveClient();
//            resetFields();
            correct=true;
            position=-1;
            }
             return correct;
    }//End save mod client

        /**
        * Used to edit a row from the table on pager admin
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
        * Used to delete a row from the table on pager admin
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
                        int opc = JOptionPane.showConfirmDialog(null, "Delete user with ID Card: " + dni+"?",
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
                            autosaveClient();
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
    
    public static void autosaveClient(){
        json.autosavejsonclient();
    }
    
    public static void autoloadClient(){
        json.autoloadjsonclient();
    }
    
    public static void savejsonClient(){
        json.savejsonclient();
    }
    
    public static void savetxtClient(){
        txt.savetxtclient();
    }
    
    public static void savexmlClient(){
        xml.savexmlclient();
    }
    
}//End public class BLL_client
