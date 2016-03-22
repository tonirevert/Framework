/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework_v2.Modules.Admin.Controller;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import static framework_v2.Modules.Admin.Model.Classes.Singleton_admin.defaultavatar;
import framework_v2.Modules.Admin.View.Create_admin;
import static framework_v2.Modules.Admin.View.Create_admin.avatar;
import static framework_v2.Modules.Admin.View.Create_admin.dateBirth;
import static framework_v2.Modules.Admin.View.Create_admin.dateContract;
import framework_v2.Modules.Admin.View.Modify_admin;
import framework_v2.Modules.Admin.View.Pager_admin;
import framework_v2.Modules.Config.Classes.Config_class;
import framework_v2.Modules.Menu.Controller.MenuController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JFrame;

/**
 *
 * @author antonio
 */
public class AdminController implements ActionListener, KeyListener, MouseListener{

    public static Create_admin create = new Create_admin();
    public static Modify_admin edit = new Modify_admin();
    public static Pager_admin pager = new Pager_admin();
    
    
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
        createdateBirth,
        createbtnSearch,
        createdateContract,
        createfieldActivity,
        createbtnSave,
        createbtnReset,
        createbtnCancel
        
    }
    
    /**
     * Initialize the frames
     * @param i  0 for create admin, 1 for modify admin, 2 for admin pager
     */
    public void Init(int i){
        
        switch(i){
            
            case 0:
                
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
                
                addWindowListener(new WindowAdapter() {
               @Override
               public void windowClosing(WindowEvent e) {
                    create.dispose();
                    new Pager_admin().setVisible(true);
               }
           });
                
                create.fieldDNI.setActionCommand("createfieldDNI");
                create.fieldDNI.addActionListener(this);
                create.fieldDNI.addKeyListener(this);
                
                create.fieldName.setActionCommand("createfieldName");
                create.fieldName.addActionListener(this);
                create.fieldName.addKeyListener(this);
                
                create.fieldSurname.setActionCommand("createfieldSurname");
                create.fieldSurname.addActionListener(this);
                create.fieldSurname.addKeyListener(this);
                
                create.fieldEmail.setActionCommand("createfieldEmail");
                create.fieldEmail.addActionListener(this);
                create.fieldEmail.addKeyListener(this);
                
                create.fieldMobile.setActionCommand("createfieldMobile");
                create.fieldMobile.addActionListener(this);
                create.fieldMobile.addKeyListener(this);
                
                create.fieldUser.setActionCommand("createfieldUser");
                create.fieldUser.addActionListener(this);
                create.fieldUser.addKeyListener(this);
                
                create.fieldPassword.setActionCommand("createfieldPassword");
                create.fieldPassword.addActionListener(this);
                create.fieldPassword.addKeyListener(this);
                
                create.fieldPassword2.setActionCommand("createfieldVerify");
                create.fieldPassword2.addActionListener(this);
                create.fieldPassword2.addKeyListener(this);
                
                create.dateBirth.setName("createdateBirth");
                create.dateBirth.addMouseListener(this);
                
                create.btnSearch.setName("createbtnSearch");
                create.btnSearch.addMouseListener(this);
                
                create.dateContract.setName("createdateContract");
                create.dateContract.addMouseListener(this);
                
                create.fieldActivity.setActionCommand("createfieldActivity");
                create.fieldActivity.addActionListener(this);
                create.fieldActivity.addKeyListener(this);
                
                
                
                break;//End case 0
                
            case 1:
                
                break;//End case 1
                
            case 2:
                
                break;//End case 2
            
        }
        
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch (MenuController.Action.valueOf(e.getComponent().getName())){
            
//            case btn
            
         }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
