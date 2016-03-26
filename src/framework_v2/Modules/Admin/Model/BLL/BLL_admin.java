/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework_v2.Modules.Admin.Model.BLL;

import framework_v2.Modules.Admin.Controller.AdminController;
import framework_v2.Modules.Admin.Model.Utils.Files_lib.json;
import framework_v2.Modules.Admin.Model.Classes.Admin_class;
import framework_v2.Modules.Admin.Model.Classes.Singleton_admin;
import static framework_v2.Modules.Admin.Model.Classes.Singleton_admin.ad;
import framework_v2.Modules.Admin.Model.Classes.miniSimpleTableModel_admin;
import framework_v2.Modules.Admin.Model.DAO.DAO_admin;
import framework_v2.Modules.Admin.Model.Utils.Files_lib.txt;
import framework_v2.Modules.Admin.Model.Utils.Files_lib.xml;
import framework_v2.Modules.Admin.Model.Utils.pager.pagina;
import framework_v2.Modules.Admin.View.Create_admin;
import framework_v2.Modules.Admin.View.Modify_admin;
import framework_v2.Modules.Admin.View.Pager_admin;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import static framework_v2.Modules.Admin.View.Pager_admin.pagerTable;

/**
 *
 * @author antonio
 */
public class BLL_admin {
    
    /**
     * Used to show a message on the Pager admin info area
     */
    public static void PauseNoselect() {
        Timer delay = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        Pager_admin.pagerInfo.setText("");
        Pager_admin.pagerInfo.setBackground(Color.white);
        
            }
        });
        
        delay.setRepeats(false);
        delay.start();
        Pager_admin.pagerInfo.setText("No user selected!");
        Pager_admin.pagerInfo.setBackground(Color.red);
    }
    
    /**
     * Used to show a message on the Pager admin info area
     */
    public static void PauseEmpty() {
        Timer delay = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        Pager_admin.pagerInfo.setText("");
        Pager_admin.pagerInfo.setBackground(Color.white);
        
            }
        });
        
        delay.setRepeats(false);
        delay.start();
        Pager_admin.pagerInfo.setText("List empty!");
        Pager_admin.pagerInfo.setBackground(Color.red);
    }
    
    /**
     * Used to show a message on the Pager admin info area
     */
     public static void PauseIncomplete() {
        Timer delay = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        Create_admin.areaInfo.setText("");
        Create_admin.areaInfo.setBackground(Color.decode("#d6d6d6"));
            }
        });
        delay.setRepeats(false);
        delay.start();
        Create_admin.areaInfo.setText("User data incomplete, please revise it!");
        Create_admin.areaInfo.setBackground(Color.red);
    }
    
    public static int position=-1;
    
    public static void askDniClick(){
        DAO_admin.askDniClick();
    }
 
    /**
     * 
     */
    public static void resetFields(){
        DAO_admin.resetFields();
    }
    
    /**
     * Used to check the create admin fields
     * @param type to choose the action
     */
    public static void askAdmindata(String type){
        boolean correct=false;
        String route="";
        
        switch(type){
            
            case "dni":
                correct = DAO_admin.askDni();
                
                break;
                
            case "name":
                correct = DAO_admin.askName();
                
                break;
            case "surname":
                correct = DAO_admin.askSurname();
                
                break;
            case "email":
                correct = DAO_admin.askEmail();
                
                break;
                
            case "mobile":
                correct = DAO_admin.askMobile();
                
                break;
                
            case "user":
                correct = DAO_admin.askUser();
                
                break;
                
            case "password":
                correct = DAO_admin.askPassword();
                
                break;
                
            case "password2":
                correct = DAO_admin.askPassword2();
                
                break;
                
            case "birthdate":
                correct= DAO_admin.askBirth();
                
                break;
                
            case "avatar":
                route=DAO_admin.askAvatar();
                
                break;
                
            case "datecontract":
                correct = DAO_admin.askDatecontract();
                
                break;
                
            case "activity":
                correct = DAO_admin.askActivity();
                
                break;
            
        }
    }//End askAdmindata
    
    /**
     * Used to check the modify admin fields
     * @param type to choose the action
     */
    public static void modAdmindata(String type){
        boolean correct=false;
        String route="";
        
        switch(type){
            
            case "dni":
                correct = DAO_admin.askDniMod();
                
                break;
                
            case "name":
                correct = DAO_admin.askNameMod();
                
                break;
            case "surname":
                correct = DAO_admin.askSurnameMod();
                
                break;
            case "email":
                correct = DAO_admin.askEmailMod();
                
                break;
                
            case "mobile":
                correct = DAO_admin.askMobileMod();
                
                break;
                
            case "user":
                correct = DAO_admin.askUserMod();
                
                break;
                
            case "password":
                correct = DAO_admin.askPasswordMod();
                
                break;
                
            case "password2":
                correct= DAO_admin.askPassword2Mod();
                break;
                
            case "birthdate":
                correct= DAO_admin.askBirthMod();
                
                break;
                
            case "avatar":
                route = DAO_admin.askAvatarMod();
                
                break;
                
            case "datecontract":
                correct = DAO_admin.askDatecontractMod();
                
                break;
                
            case "activity":
                correct = DAO_admin.askActivityMod();
                
                break;
            
        }
    }//End modAdmindata
    
    /**
     * 
     * @return 
     */
    public static int searchadmin(){
		Admin_class admin=null;
		admin= new Admin_class(Create_admin.fieldDNI.getText());
		
		for (int i = 0;i<=(Singleton_admin.adm.size()-1);i++){
			if((Singleton_admin.adm.get(i)).equals(admin) ){
                                                return i;
                                                }
		}
		return -1;
	}//End searchDniadmin admin
    
    public static int searchDniadmin(){
        int out=0;
        Admin_class admin=null;
        admin= new Admin_class(Create_admin.fieldDNI.getText());
        for (int i = 0;i<=(Singleton_admin.adm.size()-1);i++){
            if((Singleton_admin.adm.get(i)).equals(admin) ){
                    out=-1;
                }
        }

        return out;
        
    }
    
    public static int searchadminMod(Admin_class adm){
        int aux=-1;
        for(int i=0; i<=(Singleton_admin.adm.size()-1);i++){
            if(Singleton_admin.adm.get(i).equals(adm)){
                aux=i;
            }
        }
        return aux;
    }//End searchadminMod
    
    public static boolean create_admin(){
        Admin_class admin=null;
        admin=DAO_admin.create();
        boolean created=false;
        
        if (admin== null){
            PauseIncomplete();
            created=false;
        }else{
            Singleton_admin.adm.add(admin);
            autosaveAdmin();
            Create_admin.areaInfo.setText("User created correctly");
            Create_admin.areaInfo.setBackground(Color.green);
            created=true;
        }
        
        return created;
        
    }//End create_admin
    
    public static Admin_class fill_admin(String dni){
        Admin_class adm=new Admin_class(dni);
        
        position=BLL_admin.searchadminMod(adm);
        
        if (position==-1){
            JOptionPane.showMessageDialog(null,"Not found");
            adm=null;
        }else{
//            System.out.println("else fill BLL admin");
            adm=Singleton_admin.adm.get(position);
            DAO_admin.fillAdminMod(adm);
        }
        
        return adm;
    }

    public static Admin_class fill_admin(){
        Admin_class adm=ad;
        
        position=BLL_admin.searchadminMod(adm);
        
        if (position==-1){
            JOptionPane.showMessageDialog(null,"Not found");
            adm=null;
        }else{
//            System.out.println("else fill BLL admin");
            adm=Singleton_admin.adm.get(position);
            DAO_admin.fillAdminMod(adm);
        }
        
        return adm;
    }
    
    public static boolean save_mod_admin(){

        boolean correct=false;
        Admin_class admin= null;

            admin=DAO_admin.saveAdminMod();
             if (admin== null){
            correct=false;
        }else{
            Singleton_admin.adm.set(position,admin);
            autosaveAdmin();
//            resetFields();
            correct=true;
            position=-1;
            }
             return correct;
    }

        /**
        * Used to edit a row from the table on pager admin
        */
     public static boolean edit_admin() {
        String dni;
        int selection, inicio, selection1;
        boolean correct;
        
        int n=((miniSimpleTableModel_admin) Pager_admin.pagerTable.getModel()).getRowCount();
        if (n != 0) {
                 inicio=(pagina.currentPageIndex-1)*pagina.itemsPerPage; //nos situamos al inicio de la página en cuestión
                selection=Pager_admin.pagerTable.getSelectedRow(); //nos situamos en la fila
                selection1=inicio+selection; //nos situamos en la fila correspondiente de esa página
            if (selection1 == -1) {
                PauseNoselect();
                correct = false;
            } else {
                dni = (String) Pager_admin.pagerTable.getModel().getValueAt(selection1, 0);

                Singleton_admin.ad = new Admin_class(dni);
                new AdminController(new Modify_admin(),1).Init(1);
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
        
        int n=((miniSimpleTableModel_admin) Pager_admin.pagerTable.getModel()).getRowCount();
        if (n != 0) {
                 inicio=(pagina.currentPageIndex-1)*pagina.itemsPerPage; //nos situamos al inicio de la página en cuestión
                selection=Pager_admin.pagerTable.getSelectedRow(); //nos situamos en la fila
                selection1=inicio+selection; //nos situamos en la fila correspondiente de esa página
            if (selection1 == -1) {
                PauseNoselect();
            } else {
                dni = (String) pagerTable.getModel().getValueAt(selection1, 0);
                Singleton_admin.ad = new Admin_class(dni);
                pos = BLL_admin.searchadminMod((Admin_class) ad);
                int opc = JOptionPane.showConfirmDialog(null, "Delete user with ID Card: " + dni+"?",
                        "Info", JOptionPane.WARNING_MESSAGE);

                if (opc == 0) {
                    ((miniSimpleTableModel_admin) pagerTable.getModel()).removeRow(selection1);
                    ad = Singleton_admin.adm.get(pos);

                    Singleton_admin.adm.remove(ad);
                    autosaveAdmin();
                }

                if (((miniSimpleTableModel_admin) pagerTable.getModel()).getRowCount() == 0) {
                    if (((miniSimpleTableModel_admin) pagerTable.getModel()).getRowCount() != 0) {

                    }
                }
            }

        } else {
            PauseEmpty();
        }
//       ((miniSimpleTableModel_admin)TABLA.getModel()).cargar();

    }
    
    public static void autosaveAdmin(){
        json.autosavejsonadmin();
    }
    
    public static void autoloadAdmin(){
        json.autoloadjsonadmin();
    }
    
    public static void savejsonAdmin(){
        json.savejsonadmin();
    }
    
    public static void savetxtAdmin(){
        txt.savetxtadmin();
    }
    
    public static void savexmlAdmin(){
        xml.savexmladmin();
    }
    
}//End public class BLL_admin
