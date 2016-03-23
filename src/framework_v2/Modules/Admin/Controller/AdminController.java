/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework_v2.Modules.Admin.Controller;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import framework_v2.Modules.Admin.Controller.AdminController.Action;
import framework_v2.Modules.Admin.Model.BLL.BLL_admin;
import framework_v2.Modules.Admin.Model.Classes.Singleton_admin;
import static framework_v2.Modules.Admin.Model.Classes.Singleton_admin.ad;
import static framework_v2.Modules.Admin.Model.Classes.Singleton_admin.defaultavatar;
import framework_v2.Modules.Admin.View.Create_admin;
import static framework_v2.Modules.Admin.View.Create_admin.*;
import framework_v2.Modules.Admin.View.Modify_admin;
import framework_v2.Modules.Admin.View.Pager_admin;
import framework_v2.Modules.Config.Classes.Config_class;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author antonio
 */
public class AdminController implements ActionListener, KeyListener, MouseListener, FocusListener,PropertyChangeListener{

    public static Create_admin create;// = new Create_admin();
    public static Modify_admin edit;// = new Modify_admin();
    public static Pager_admin pager;// = new Pager_admin();
    
    
    public AdminController(JFrame frame, int i){
        switch(i){
            case 0:
                create=(Create_admin) frame;
                break;
                
            case 1:
                edit=(Modify_admin)frame;
                break;
                
            case 2:
                pager=(Pager_admin)frame;
                break;
        }
                
    }

               
    public enum Action{
        
        //Create admin buttons and fields:
        createfieldDNI,
        createfieldName,
        createfieldSurname,
        createfieldEmail,
        createfieldMobile,
        createfieldUser,
        createfieldPassword,
        createfieldVerify,
        createbtnSearch,
        createfieldActivity,
        createbtnSave,
        createbtnReset,
        createbtnCancel,
                
        editfieldName,
        editfieldSurname,
        editfieldEmail,
        editfieldMobile,
        editfieldUser,
        editfieldPassword,
        editfieldVerify,
        editbtnSearch,
        editfieldActivity,
        editbtnSave,
        editbtnCancel
        
    }
    
    public enum Property{
        
        date,//Used for datebirth and date contract
        background,//Used for datebirth and date contract
        enabled,//Used for datebirth and date contract
        ancestor
    }
    
    /**
     * Initialize the frames
     * @param i  0 for create admin, 1 for modify admin, 2 for admin pager
     */
    public void Init(int i){
        
        switch(i){
            
            case 0:
                
                create.setTitle("Create Admin");////////////////////////////////////////////////////////////////////////
                create.saving.setVisible(false);
                create.setResizable(false);
                create.setSize(600,500);
                create.dateBirth.setDateFormatString(Config_class.getinstance().getDate_format());
                create.dateContract.setDateFormatString(Config_class.getinstance().getDate_format());
                create.dateContract.getDateEditor().setEnabled(false);
                create.dateBirth.getDateEditor().setEnabled(false);
                create.dateContract.setEnabled(false);
                create.areaInfo.setEditable(false);
                create.areaInfo.setBackground(Color.decode("#d6d6d6"));
                create.setLocationRelativeTo(null);
                create.avatar.setIcon(defaultavatar);
                create.setVisible(true);
                Singleton_admin.window="create";
                
                create.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                addWindowListener(new WindowAdapter() {
               @Override
               public void windowClosing(WindowEvent e) {
                    create.dispose();
                    new Pager_admin().setVisible(true);
               }
           });
                
                create.fieldDNI.setActionCommand("createfieldDNI");
                create.fieldDNI.setName("createfieldDNI");
                create.fieldDNI.addFocusListener(this);
                create.fieldDNI.addActionListener(this);
                create.fieldDNI.addKeyListener(this);
                
                create.fieldName.setActionCommand("createfieldName");
                create.fieldName.setName("createfieldName");
                create.fieldName.addFocusListener(this);
                create.fieldName.addActionListener(this);
                create.fieldName.addKeyListener(this);
                
                create.fieldSurname.setActionCommand("createfieldSurname");
                create.fieldSurname.setName("createfieldSurname");
                create.fieldSurname.addFocusListener(this);
                create.fieldSurname.addActionListener(this);
                create.fieldSurname.addKeyListener(this);
                
                create.fieldEmail.setActionCommand("createfieldEmail");
                create.fieldEmail.setName("createfieldEmail");
                create.fieldEmail.addFocusListener(this);
                create.fieldEmail.addActionListener(this);
                create.fieldEmail.addKeyListener(this);
                
                create.fieldMobile.setActionCommand("createfieldMobile");
                create.fieldMobile.setName("createfieldMobile");
                create.fieldMobile.addFocusListener(this);
                create.fieldMobile.addActionListener(this);
                create.fieldMobile.addKeyListener(this);
                
                create.fieldUser.setActionCommand("createfieldUser");
                create.fieldUser.setName("createfieldUser");
                create.fieldUser.addFocusListener(this);
                create.fieldUser.addActionListener(this);
                create.fieldUser.addKeyListener(this);
                
                create.fieldPassword.setActionCommand("createfieldPassword");
                create.fieldPassword.setName("createfieldPassword");
                create.fieldPassword.addFocusListener(this);
                create.fieldPassword.addActionListener(this);
                create.fieldPassword.addKeyListener(this);
                
                create.fieldPassword2.setActionCommand("createfieldVerify");
                create.fieldPassword2.setName("createfieldVerify");
                create.fieldPassword2.addFocusListener(this);
                create.fieldPassword2.addActionListener(this);
                create.fieldPassword2.addKeyListener(this);
                
                create.dateBirth.addPropertyChangeListener(this);
                
                create.btnSearch.setName("createbtnSearch");
                create.btnSearch.addMouseListener(this);
                
                create.dateContract.addPropertyChangeListener(this);
                
                create.fieldActivity.setActionCommand("createfieldActivity");
                create.fieldActivity.setName("createfieldActivity");
                create.fieldActivity.addFocusListener(this);
                create.fieldActivity.addActionListener(this);
                create.fieldActivity.addKeyListener(this);
                
                create.btnsaveCreateadmin.setName("createbtnSave");
                create.btnsaveCreateadmin.addMouseListener(this);

                create.btnresetCreateadmin.setName("createbtnReset");
                create.btnresetCreateadmin.addMouseListener(this);
                
                create.btncancelCreateadmin.setName("createbtnCancel");
                create.btncancelCreateadmin.addMouseListener(this);
                
                break;//End case 0
                
            case 1:
                
                edit.setTitle("Modify Admin");////////////////////////////////////////////////////////////////////////
                edit.saving.setVisible(false);
                BLL_admin.fill_admin(ad.getDni());
                edit.fieldDNI.setEditable(false);
                edit.setResizable(false);
                edit.setSize(600,500);
                edit.editdateBirth.setDateFormatString(Config_class.getinstance().getDate_format());
                edit.editdateContract.setDateFormatString(Config_class.getinstance().getDate_format());
                edit.editdateBirth.getDateEditor().setEnabled(false);
                edit.editdateContract.getDateEditor().setEnabled(false);
                edit.setLocationRelativeTo(null);
                edit.setVisible(true);
                Singleton_admin.window="modify";
                
                edit.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                edit.dispose(); 
                new Pager_admin().setVisible(true);//////////////////////////////////////////////////////////////////
            }
        });
                
                edit.editfieldName.setActionCommand("editfieldName");
                edit.editfieldName.setName("editfieldName");
                edit.editfieldName.addFocusListener(this);
                edit.editfieldName.addActionListener(this);
                edit.editfieldName.addKeyListener(this);
                
                edit.editfieldSurname.setActionCommand("editfieldSurname");
                edit.editfieldSurname.setName("editfieldSurname");
                edit.editfieldSurname.addFocusListener(this);
                edit.editfieldSurname.addActionListener(this);
                edit.editfieldSurname.addKeyListener(this);
                
                edit.editfieldEmail.setActionCommand("editfieldEmail");
                edit.editfieldEmail.setName("editfieldEmail");
                edit.editfieldEmail.addFocusListener(this);
                edit.editfieldEmail.addActionListener(this);
                edit.editfieldEmail.addKeyListener(this);
                
                edit.editfieldMobile.setActionCommand("editfieldMobile");
                edit.editfieldMobile.setName("editfieldMobile");
                edit.editfieldMobile.addFocusListener(this);
                edit.editfieldMobile.addActionListener(this);
                edit.editfieldMobile.addKeyListener(this);
                
                edit.editfieldUser.setActionCommand("editfieldUser");
                edit.editfieldUser.setName("editfieldUser");
                edit.editfieldUser.addFocusListener(this);
                edit.editfieldUser.addActionListener(this);
                edit.editfieldUser.addKeyListener(this);
                
                edit.editfieldPassword.setActionCommand("editfieldPassword");
                edit.editfieldPassword.setName("editfieldPassword");
                edit.editfieldPassword.addFocusListener(this);
                edit.editfieldPassword.addActionListener(this);
                edit.editfieldPassword.addKeyListener(this);
                
                edit.editfieldPassword2.setActionCommand("editfieldVerify");
                edit.editfieldPassword2.setName("editfieldVerify");
                edit.editfieldPassword2.addFocusListener(this);
                edit.editfieldPassword2.addActionListener(this);
                edit.editfieldPassword2.addKeyListener(this);
                
                edit.editdateBirth.addPropertyChangeListener(this);
                
                edit.btnSearch.setName("editbtnSearch");
                edit.btnSearch.addMouseListener(this);
                
                edit.editdateContract.addPropertyChangeListener(this);
                
                edit.editfieldActivity.setActionCommand("editfieldActivity");
                edit.editfieldActivity.setName("editfieldActivity");
                edit.editfieldActivity.addFocusListener(this);
                edit.editfieldActivity.addActionListener(this);
                edit.editfieldActivity.addKeyListener(this);
                
                edit.btnsaveEditadmin.setName("editbtnSave");
                edit.btnsaveEditadmin.addMouseListener(this);
                
                edit.btncancelEditadmin.setName("editbtnCancel");
                edit.btncancelEditadmin.addMouseListener(this);
                break;//End case 1
                
            case 2:
                
                break;//End case 2
            
        }
        
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (Action.valueOf(e.getComponent().getName())) {
            
            case createfieldDNI:
                BLL_admin.askAdmindata("dni");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    create.fieldName.requestFocus();
                }
                break;
                
            case createfieldName:
                BLL_admin.askAdmindata("name");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    create.fieldSurname.requestFocus();
	}
                break;
                
            case createfieldSurname:
                BLL_admin.askAdmindata("surname");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    create.fieldEmail.requestFocus();
	}
                break;
                
            case createfieldEmail:
                BLL_admin.askAdmindata("email");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    create.fieldMobile.requestFocus();
	}
                break;
                
            case createfieldMobile:
                BLL_admin.askAdmindata("mobile");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    create.fieldUser.requestFocus();
	}
                break;
                
            case createfieldUser:
                BLL_admin.askAdmindata("user");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    create.fieldPassword.requestFocus();
	}
                break;
                
            case createfieldPassword:
                BLL_admin.askAdmindata("password");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    create.fieldPassword2.requestFocus();
	}
                break;
                
            case createfieldVerify:
                BLL_admin.askAdmindata("password2");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    create.fieldActivity.requestFocus();
	}
                break;
                
            case createfieldActivity:
                BLL_admin.askAdmindata("activity");
                break;
                
                ////Events from Modify admin
            case editfieldName:
                BLL_admin.modAdmindata("name");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    edit.editfieldSurname.requestFocus();
	}
                break;
                
            case editfieldSurname:
                BLL_admin.modAdmindata("surname");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    edit.editfieldEmail.requestFocus();
	}
                break;
                
            case editfieldEmail:
                BLL_admin.modAdmindata("email");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    edit.editfieldMobile.requestFocus();
	}
                break;
                
            case editfieldMobile:
                BLL_admin.modAdmindata("mobile");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    edit.editfieldUser.requestFocus();
	}
                break;
                
            case editfieldUser:
                BLL_admin.modAdmindata("user");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    edit.editfieldPassword.requestFocus();
	}
                break;
                
            case editfieldPassword:
                BLL_admin.modAdmindata("password");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    edit.editfieldPassword2.requestFocus();
	}
                break;
                
            case editfieldVerify:
                BLL_admin.modAdmindata("password2");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    edit.editfieldActivity.requestFocus();
	}
                break;
                
            case editfieldActivity:
                BLL_admin.modAdmindata("activity");
                break;
                
        }//End switch case keyPressed
    }//End keyPressed

    @Override
    public void keyReleased(KeyEvent e) {
         switch (Action.valueOf(e.getComponent().getName())) {
            case createfieldDNI:
                BLL_admin.askAdmindata("dni");
                break;
                
            case createfieldName:
                BLL_admin.askAdmindata("name");
                break;
                
            case createfieldSurname:
                BLL_admin.askAdmindata("surname");
                break;
                
            case createfieldEmail:
                BLL_admin.askAdmindata("email");
                break;
            
            case createfieldMobile:
                BLL_admin.askAdmindata("mobile");
                break;
                
            case createfieldUser:
                BLL_admin.askAdmindata("user");
                break;
                
            case createfieldPassword:
                BLL_admin.askAdmindata("password");
                break;
                
            case createfieldVerify:
                BLL_admin.askAdmindata("password2");
                break;
                
            case createfieldActivity:
                BLL_admin.askAdmindata("activity");
                break;
                
                ////Events from Modify admin:
                
            case editfieldName:
                BLL_admin.modAdmindata("name");
                break;
                
            case editfieldSurname:
                BLL_admin.modAdmindata("surname");
                break;
                
            case editfieldEmail:
                BLL_admin.modAdmindata("email");
                break;
                
            case editfieldMobile:
                BLL_admin.modAdmindata("mobile");
                break;
                
            case editfieldUser:
                BLL_admin.modAdmindata("user");
                break;
                
            case editfieldPassword:
                BLL_admin.modAdmindata("password");
                break;
                
            case editfieldVerify:
                BLL_admin.modAdmindata("password2");
                break;
                
            case editfieldActivity:
                BLL_admin.modAdmindata("activity");
                break;
        }//End switch case keyReleased
    }//End keyReleased
    
    @Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch (Action.valueOf(e.getComponent().getName())){
            
            case createbtnSearch:
                BLL_admin.askAdmindata("avatar");
                break;
            
            case createbtnSave:
                if(BLL_admin.create_admin()==true){
                Timer delay = new Timer(3000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                            create.dispose();
                            new Pager_admin().setVisible(true);////////////////////////////////////////////////////////////
                            }
                        });

                        create.saving.setVisible(true);
                        delay.setRepeats(false);
                        delay.start();
                        create.areaInfo.setText("User created correctly");
                        create.areaInfo.setBackground(Color.green);
                }
                break;
                
            case createbtnReset:
                BLL_admin.resetFields();
                break;
                
            case createbtnCancel:
                create.dispose();
                new Pager_admin().setVisible(true);/////////////////////////////////////////////////////////////////
                break;
                
                ////Events from Modify admin:
                
            case editbtnSearch:
                BLL_admin.modAdmindata("avatar");
                break;
                
            case editbtnSave:
                if(BLL_admin.save_mod_admin()!=false){
                    Timer delay = new Timer(3000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            edit.dispose();
                            new Pager_admin().setVisible(true);/////////////////////////////////////////////////////////////////
                        }
                    });
                    edit.saving.setVisible(true);
                    delay.setRepeats(false);
                    delay.start();
                    edit.editareaInfo.setText("User saved correctly");
                    edit.editareaInfo.setBackground(Color.green);
                }else{
                    edit.editareaInfo.setText("User data incomplete, please revise it");
                    edit.editareaInfo.setBackground(Color.red);
                }
                break;
                
            case editbtnCancel:
                edit.dispose();
                new Pager_admin().setVisible(true);/////////////////////////////////////////////////////////////////
                break;
         }
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void focusGained(FocusEvent e) {
        
//        System.out.println(e.getComponent().getName());
        
         switch (Action.valueOf(e.getComponent().getName())) {
              case createfieldDNI:
                create.areaInfo.setText("Input a ID card number");
                create.areaInfo.setBackground(Color.decode("#d6d6d6"));
                break;
                
            case createfieldName:
                create.areaInfo.setText("Input a name");
                create.areaInfo.setBackground(Color.decode("#d6d6d6"));
                break;
                
            case createfieldSurname:
                create.areaInfo.setText("Input a surname");
                create.areaInfo.setBackground(Color.decode("#d6d6d6"));
                break;
                
            case createfieldEmail:
                create.areaInfo.setText("Input a e-mail address");
                create.areaInfo.setBackground(Color.decode("#d6d6d6"));
                break;
            
            case createfieldMobile:
                create.areaInfo.setText("Input a mobile number like 346XXXXXXXX");
                create.areaInfo.setBackground(Color.decode("#d6d6d6"));
                break;
                
            case createfieldUser:
                create.areaInfo.setText("Input a user name");
                create.areaInfo.setBackground(Color.decode("#d6d6d6"));
                break;
                
            case createfieldPassword:
                create.areaInfo.setText("Input a password like Az123456 (need a capital letter) 8 letters");
                create.areaInfo.setBackground(Color.decode("#d6d6d6"));
                break;
                
            case createfieldVerify:
                create.areaInfo.setText("Verify your password");
                create.areaInfo.setBackground(Color.decode("#d6d6d6"));
                break;
                
            case createfieldActivity:
                create.areaInfo.setText("Input the activity");
                create.areaInfo.setBackground(Color.decode("#d6d6d6"));
                break;
                
                ////Events from Modify admin:
                
            case editfieldName:
                edit.editareaInfo.setText("Input a name");
                edit.editareaInfo.setBackground(Color.decode("#d6d6d6"));
                break;
                
            case editfieldSurname:
                edit.editareaInfo.setText("Input a surname");
                edit.editareaInfo.setBackground(Color.decode("#d6d6d6"));
                break;
                
            case editfieldEmail:
                edit.editareaInfo.setText("Input a e-mail address");
                edit.editareaInfo.setBackground(Color.decode("#d6d6d6"));
                break;
            
            case editfieldMobile:
                edit.editareaInfo.setText("Input a mobile number like 346XXXXXXXX");
                edit.editareaInfo.setBackground(Color.decode("#d6d6d6"));
                break;
                
            case editfieldUser:
                edit.editareaInfo.setText("Input a user name");
                edit.editareaInfo.setBackground(Color.decode("#d6d6d6"));
                break;
                
            case editfieldPassword:
                edit.editareaInfo.setText("Input a password like Az123456 (need a capital letter) 8 letters");
                edit.editareaInfo.setBackground(Color.decode("#d6d6d6"));
                break;
                
            case editfieldVerify:
                edit.editareaInfo.setText("Verify your password");
                edit.editareaInfo.setBackground(Color.decode("#d6d6d6"));
                break;
                
            case editfieldActivity:
                edit.editareaInfo.setText("Input the activity");
                edit.editareaInfo.setBackground(Color.decode("#d6d6d6"));
                break;
         }
    }

    @Override
    public void focusLost(FocusEvent e) {
        switch (Action.valueOf(e.getComponent().getName())) {
              case createfieldDNI:
                create.areaInfo.setText("");
                break;
                
            case createfieldName:
                create.areaInfo.setText("");
                break;
                
            case createfieldSurname:
                create.areaInfo.setText("");
                break;
                
            case createfieldEmail:
                create.areaInfo.setText("");
                break;
            
            case createfieldMobile:
                create.areaInfo.setText("");
                break;
                
            case createfieldUser:
                create.areaInfo.setText("");
                break;
                
            case createfieldPassword:
                create.areaInfo.setText("");
                break;
                
            case createfieldVerify:
                create.areaInfo.setText("");
                break;
                
            case createfieldActivity:
                create.areaInfo.setText("");
                break;
                
                ////Events from Modify admin:
                
            case editfieldName:
                edit.editareaInfo.setText("");
                break;
                
            case editfieldSurname:
                edit.editareaInfo.setText("");
                break;
                
            case editfieldEmail:
                edit.editareaInfo.setText("");
                break;
            
            case editfieldMobile:
                edit.editareaInfo.setText("");
                break;
                
            case editfieldUser:
                edit.editareaInfo.setText("");
                break;
                
            case editfieldPassword:
                edit.editareaInfo.setText("");
                break;
                
            case editfieldVerify:
                edit.editareaInfo.setText("");
                break;
                
            case editfieldActivity:
                edit.editareaInfo.setText("");
                break;
         }
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
//        System.out.println(evt.getPropertyName());

        if(Singleton_admin.window.equals("create")){
                    
            switch (Property.valueOf(evt.getPropertyName())) {

                case date:
                    BLL_admin.askAdmindata("birthdate");
                    BLL_admin.askAdmindata("datecontract");
                    create.areaInfo.setBackground(Color.decode("#d6d6d6"));
                    break;

                case background:
                    BLL_admin.askAdmindata("birthdate");
                    BLL_admin.askAdmindata("datecontract");
                    create.areaInfo.setBackground(Color.decode("#d6d6d6"));
                    break;

                case enabled:
                    BLL_admin.askAdmindata("birthdate");
                    BLL_admin.askAdmindata("datecontract");
                    create.areaInfo.setBackground(Color.decode("#d6d6d6"));
                    break;
            }//End switch case
        }//End if
        if(Singleton_admin.window.equals("modify")){
                    
            switch (Property.valueOf(evt.getPropertyName())) {

                case date:
                    BLL_admin.modAdmindata("birthdate");
                    BLL_admin.modAdmindata("datecontract");
                    edit.editareaInfo.setBackground(Color.decode("#d6d6d6"));
                    break;

                case background:
                    BLL_admin.modAdmindata("birthdate");
                    BLL_admin.modAdmindata("datecontract");
                    edit.editareaInfo.setBackground(Color.decode("#d6d6d6"));
                    break;

                case enabled:
                    BLL_admin.modAdmindata("birthdate");
                    BLL_admin.modAdmindata("datecontract");
                    edit.editareaInfo.setBackground(Color.decode("#d6d6d6"));
                    break;
            }//End switch case
        }//End if
    }
}
