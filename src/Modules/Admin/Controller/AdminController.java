/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules.Admin.Controller;

import Classes.Singleton_app;
import Modules.Admin.Controller.AdminController.Action;
import Modules.Admin.Model.BLL.BLL_admin;
import Modules.Admin.Model.Classes.Singleton_admin;
import static Modules.Admin.Model.Classes.Singleton_admin.ad;
import static Modules.Admin.Model.Classes.Singleton_admin.defaultavatar;
import Modules.Admin.Model.Classes.miniSimpleTableModel_admin;
import Modules.Admin.Model.Utils.pager.AutocompleteJComboBox;
import Modules.Admin.Model.Utils.pager.StringSearchable;
import Modules.Admin.Model.Utils.pager.pagina;
import Modules.Admin.View.Create_admin;
import Modules.Admin.View.List_admin;
import Modules.Admin.View.Modify_admin;
import Modules.Admin.View.Pager_admin;

import static Modules.Admin.View.Pager_admin.jComboBox1;
import static Modules.Admin.View.Pager_admin.pagerTable;
import Modules.Config.Classes.Config_class;
import Modules.Menu.Controller.MenuController;
import Modules.Menu.View.Mainmenu;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author antonio
 */
public class AdminController implements ActionListener, KeyListener, MouseListener, FocusListener,PropertyChangeListener, WindowListener{
        
    public static Create_admin create;
    public static Modify_admin edit;
    public static Pager_admin pager;
    public static List_admin list;
    public static TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(new miniSimpleTableModel_admin());
    public static AutocompleteJComboBox comboAdmin = null;
    public String comb="";
    
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
                
            case 3:
                list=(List_admin)frame;
                break;
                
        }
                
    }
               
    public enum Action{
        
        //Create admin buttons and fields:
        createWindow,
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
        
        //Edit admin buttons and fields
        editWindow,
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
        editbtnCancel,
        
        //Pager admin buttons and fields
        pagerWindow,
        AddAdmin,
        ModAdmin,
        DelAdmin,
        ListAdmin,
        btnsavejson,
        btnsavetxt,
        btnsavexml,
        pagerTable,
        comboBoxChanged,
        comboBoxEdited,
        comboAdmin,
        entriesCombo,
        jComboBox1,
        pagFirst,
        pagPrev,
        pagBox,
        pagNext,
        pagLast,
        pagLinks,
        pagReturn,
        
        //List admin
        listWindow,
        listbtnReturn
    }
    
    public enum Property{
        
        //JCalendar return properties
        date,//Used for datebirth and date contract
        background,//Used for datebirth and date contract
        enabled,//Used for datebirth and date contract
        ancestor//Used for datebirth and date contract
    }
    
    /**
     * Initialize the frames
     * @param i  0 for create admin, 1 for modify admin, 2 for admin pager
     */
    public void Init(int i){
        
        switch(i){
            
            case 0://Create admin
                int cx=650;
                int cy=500;
                create.back.setSize(cx,cy);
                Image crback=Singleton_admin.backCrMo.getImage();
                create.back.setIcon(new ImageIcon(crback.getScaledInstance(cx,cy, java.awt.Image.SCALE_SMOOTH)));
                Singleton_admin.window="create";
                create.saving.setVisible(false);
                create.setResizable(false);
                create.setSize(cx,cy);
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
                
                //Translation:
                create.setTitle(Singleton_app.lang.getProperty("a_wcreate"));
                create.labelDNI.setText(Singleton_app.lang.getProperty("u_idcard"));
                create.labelName.setText(Singleton_app.lang.getProperty("u_name"));
                create.labelSurname.setText(Singleton_app.lang.getProperty("u_surname"));
                create.labelMobile.setText(Singleton_app.lang.getProperty("u_mobile"));
                create.labelUser.setText(Singleton_app.lang.getProperty("u_user"));
                create.labelPassword.setText(Singleton_app.lang.getProperty("u_password"));
                create.labelPassword2.setText(Singleton_app.lang.getProperty("u_verify"));
                create.labeldateBirth.setText(Singleton_app.lang.getProperty("u_birthday"));
                create.labelState.setText(Singleton_app.lang.getProperty("u_state"));
                create.labeldateContract.setText(Singleton_app.lang.getProperty("a_contdate"));
                create.labelActivity.setText(Singleton_app.lang.getProperty("a_activity"));
                
                create.btnsaveCreateadmin.setText(Singleton_app.lang.getProperty("w_create"));
                create.btnresetCreateadmin.setText(Singleton_app.lang.getProperty("w_Reset"));
                create.btncancelCreateadmin.setText(Singleton_app.lang.getProperty("w_Cancel"));
                create.btnSearch.setText(Singleton_app.lang.getProperty("w_search"));
                
                //Actions:
                create.setName("createWindow");
                create.addWindowListener(this);
                create.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                
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
                
                break;//End case 0 create admin
                
            case 1://Modify admin
                int ex=650;
                int ey=500;
                edit.back.setSize(ex,ey);
                Image edback=Singleton_admin.backCrMo.getImage();
                edit.back.setIcon(new ImageIcon(edback.getScaledInstance(ex, ey, java.awt.Image.SCALE_SMOOTH)));
                Singleton_admin.window="modify";
                edit.saving.setVisible(false);
                BLL_admin.fill_admin(ad.getDni());
                edit.fieldDNI.setEditable(false);
                edit.setResizable(false);
                edit.setSize(ex,ey);
                edit.editdateBirth.setDateFormatString(Config_class.getinstance().getDate_format());
                edit.editdateContract.setDateFormatString(Config_class.getinstance().getDate_format());
                edit.editdateBirth.getDateEditor().setEnabled(false);
                edit.editdateContract.getDateEditor().setEnabled(false);
                edit.setLocationRelativeTo(null);
                edit.setVisible(true);

                //Translation:
                edit.setTitle(Singleton_app.lang.getProperty("a_wedit"));
                edit.labelDNI.setText(Singleton_app.lang.getProperty("u_idcard"));
                edit.labelName.setText(Singleton_app.lang.getProperty("u_name"));
                edit.labelSurname.setText(Singleton_app.lang.getProperty("u_surname"));
                edit.labelMobile.setText(Singleton_app.lang.getProperty("u_mobile"));
                edit.labelUser.setText(Singleton_app.lang.getProperty("u_user"));
                edit.labelPassword.setText(Singleton_app.lang.getProperty("u_password"));
                edit.labelPassword2.setText(Singleton_app.lang.getProperty("u_verify"));
                edit.labeldateBirth.setText(Singleton_app.lang.getProperty("u_birthday"));
                edit.labelState.setText(Singleton_app.lang.getProperty("u_state"));
                edit.labeldateContract.setText(Singleton_app.lang.getProperty("a_contdate"));
                edit.labelActivity.setText(Singleton_app.lang.getProperty("a_activity"));
                
                edit.btnsaveEditadmin.setText(Singleton_app.lang.getProperty("w_save"));
                edit.btncancelEditadmin.setText(Singleton_app.lang.getProperty("w_Cancel"));
                edit.btnSearch.setText(Singleton_app.lang.getProperty("w_search"));
                
                //Action:
                edit.setName("editWindow");
                edit.addWindowListener(this);
                edit.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                        
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
                break;//End case 1 edit admin
                
            case 2://Pager admin
                pager.setLocationRelativeTo(null);
                pager.setResizable(false);
                pager.setVisible(true);
                
                pager.pagerTable.setModel( new miniSimpleTableModel_admin() );
                ((miniSimpleTableModel_admin)pagerTable.getModel()).cargar();
                pager.pagerTable.setFillsViewportHeight(true);
                pager.pagerTable.setRowSorter(sorter);
                
                pagina.inicializa();
                pagina.initLinkBox();
                
                pager.pagAmount.setText(String.valueOf(Singleton_admin.adm.size()));
                
                List<String> myWords = new ArrayList<String>();
                
                for (int e=0;e<=Singleton_admin.adm.size()-1;e++) {
                myWords.add(Singleton_admin.adm.get(e).getName());
                }
                
                StringSearchable searchable = new StringSearchable(myWords);
                comboAdmin = new AutocompleteJComboBox(searchable);
                pager.jPanel3.setLayout(new java.awt.BorderLayout());
                pager.jPanel3.add(comboAdmin);
                
                //Translation:
                pager.setTitle(Singleton_app.lang.getProperty("a_wlist"));
                
                //Actions:
                pager.AddAdmin.setToolTipText("Add a new user");
                pager.ModAdmin.setToolTipText("Modify selected user");
                pager.DelAdmin.setToolTipText("Delete selected user");
                pager.ListAdmin.setToolTipText("Click to list the selected user");
                pager.btnsavejson.setToolTipText("Save users to JSON");
                pager.btnsavetxt.setToolTipText("Save users to TXT");
                pager.btnsavexml.setToolTipText("Save users to XML");
                pager.pagerTable.setToolTipText("Double click to choose one user");
                pager.pagButtonpanel.setToolTipText("Use the buttons for navigate the pages");
                pager.pagFirst.setToolTipText("Click to go to first page");
                pager.pagPrev.setToolTipText("Click to go to previous page");
                pager.pagNext.setToolTipText("Click to go to next page");
                pager.pagLast.setToolTipText("Click to go to last page");
                pager.pagLinks.setToolTipText("Click on the numbers for navigate the pages");
                pager.pagReturn.setToolTipText("Click to return to the previous menu");
                jComboBox1.setToolTipText("Click to change the amount of users per page");
                this.comboAdmin.setToolTipText("Click to user search");
                
                pager.setName("pagerWindow");
                pager.addWindowListener(this);
                pager.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                
                pager.AddAdmin.setName("AddAdmin");
                pager.AddAdmin.addMouseListener(this);
                
                pager.ModAdmin.setName("ModAdmin");
                pager.ModAdmin.addMouseListener(this);
                
                pager.DelAdmin.setName("DelAdmin");
                pager.DelAdmin.addMouseListener(this);
                
                pager.ListAdmin.setName("ListAdmin");
                pager.ListAdmin.addMouseListener(this);
                
                pager.btnsavejson.setName("btnsavejson");
                pager.btnsavejson.addMouseListener(this);
                
                pager.btnsavetxt.setName("btnsavetxt");
                pager.btnsavetxt.addMouseListener(this);
                
                pager.btnsavexml.setName("btnsavexml");
                pager.btnsavexml.addMouseListener(this);
                
                pager.pagerTable.setName("pagerTable");
                pager.pagerTable.addMouseListener(this);
                
                comboAdmin.setActionCommand("comboAdmin");
                comboAdmin.setName("comboAdmin");
                comboAdmin.addActionListener(this);
                comboAdmin.addMouseListener(this);
                
                jComboBox1.setActionCommand("entriesCombo");
                jComboBox1.setName("entriesCombo");
                jComboBox1.addActionListener(this);
                jComboBox1.addMouseListener(this);
                
                pager.pagFirst.setName("pagFirst");
                pager.pagFirst.addMouseListener(this);
                
                pager.pagPrev.setName("pagPrev");
                pager.pagPrev.addMouseListener(this);
                
                pager.pagBox.setName("pagBox");
                pager.pagBox.addMouseListener(this);
                
                pager.pagNext.setName("pagNext");
                pager.pagNext.addMouseListener(this);
                
                pager.pagLast.setName("pagLast");
                pager.pagLast.addMouseListener(this);
                
                pager.pagLinks.setName("pagLinks");
                pager.pagLinks.addMouseListener(this);
                
                pager.pagReturn.setName("pagReturn");
                pager.pagReturn.addMouseListener(this);
                
                break;//End case 2 Pager admin
                
            case 3:
                int lx=550;
                int ly=413;
                list.back.setSize(lx,ly);
                Image lsback=Singleton_admin.backList.getImage();
                List_admin.back.setIcon(new ImageIcon(lsback.getScaledInstance(lx, ly, java.awt.Image.SCALE_SMOOTH)));
                list.setTitle("Admin data list");
                list.StringArea.setEditable(false);
                list.setLocationRelativeTo(null);
                list.setSize(lx,ly);
                list.setResizable(false);
                list.setVisible(true);
                
                list.setName("listWindow");
                list.addWindowListener(this);
                list.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                
                list.btnReturn.setName("listbtnReturn");
                list.btnReturn.addMouseListener(this);
        
                break;//End case 3 List admin
            
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
    }//End of keyPressed

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
    }//End of keyReleased
    
    @Override
    public void actionPerformed(ActionEvent e) {
//        System.out.println(e.getActionCommand());
        switch (Action.valueOf(e.getActionCommand())){
           
            case comboAdmin:
                    pagina.currentPageIndex = 1;
                    pagina.initLinkBox();
                    ((miniSimpleTableModel_admin)pagerTable.getModel()).filtrar();
                    comboAdmin.requestFocus();
                break;
            
            case entriesCombo:
                pagina.itemsPerPage=Integer.parseInt(jComboBox1.getSelectedItem().toString());
                pagina.currentPageIndex = 1;
                pagina.initLinkBox();
                break;
                
        }
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
                            new AdminController(new Pager_admin(),2).Init(2);
                            }
                        });

                        create.saving.setVisible(true);
                        delay.setRepeats(false);
                        delay.start();
                        create.areaInfo.setText(Singleton_app.lang.getProperty("w_ucreated"));
                        create.areaInfo.setBackground(Color.green);
                }
                break;
                
            case createbtnReset:
                BLL_admin.resetFields();
                break;
                
            case createbtnCancel:
                create.dispose();
                new AdminController(new Pager_admin(),2).Init(2);
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
                            new AdminController(new Pager_admin(),2).Init(2);
                        }
                    });
                    edit.saving.setVisible(true);
                    delay.setRepeats(false);
                    delay.start();
                    BLL_admin.autosaveAdmin();
                    edit.editareaInfo.setText(Singleton_app.lang.getProperty("w_usaved"));
                    edit.editareaInfo.setBackground(Color.green);
                }else{
                    edit.editareaInfo.setText(Singleton_app.lang.getProperty("w_udatinco"));
                    edit.editareaInfo.setBackground(Color.red);
                }
                break;
                
            case editbtnCancel:
                edit.dispose();
                new AdminController(new Pager_admin(),2).Init(2);
                break;
                
                ////Events from pager admin
            case AddAdmin:
                pager.dispose();
                new AdminController(new Create_admin(),0).Init(0);
                break;
                
            case ModAdmin:
                boolean modify;
                modify = BLL_admin.edit_admin();
                if (modify == true) {
                pager.dispose();
                }
                break;
                
            case ListAdmin:
                if(true==BLL_admin.list_admin()){
                pager.dispose();
                }
                break;
                
            case DelAdmin:
                BLL_admin.delete_file();
                break;
                
            case btnsavejson:
                BLL_admin.savejsonAdmin();
                break;
                
            case btnsavetxt:
                BLL_admin.savetxtAdmin();
                break;
                
            case btnsavexml:
                BLL_admin.savexmlAdmin();
                break;
                
            case pagerTable:
                if (e.getClickCount() == 2) {
                pager.dispose();
                BLL_admin.edit_admin();
                }
                break;
                
            case entriesCombo:
//                System.out.println("framework_v2.Modules.Admin.Controller.AdminController.mouseClicked()");
                pagina.itemsPerPage=Integer.parseInt(jComboBox1.getSelectedItem().toString());
                pagina.currentPageIndex = 1;
                pagina.initLinkBox();
                break;
                
            case pagFirst:
                pagina.currentPageIndex = 1;
                pagina.initLinkBox();                
                break;
                
            case pagPrev:
                pagina.currentPageIndex -= 1;
                pagina.initLinkBox();
                break;
                
            case pagBox:
                
                break;
                
            case pagNext:
                pagina.currentPageIndex += 1;
                pagina.initLinkBox();
                break;
                
            case pagLast:
                pagina.currentPageIndex = pagina.maxPageIndex;
                pagina.initLinkBox();
                break;
                
            case pagLinks:
                
                break;
                
            case pagReturn:
                pager.dispose();
                new MenuController(new Mainmenu(),0).Init(0);
                break;
                
                ////Events from list Admin
            case listbtnReturn:
                list.dispose();
                new AdminController(new Pager_admin(),2).Init(2);
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
        
//        System.out.println(e.getComponent().getName());

        switch (Action.valueOf(e.getComponent().getName())){
                ////Events from pager admin
            case AddAdmin:
                pager.AddAdmin.setIcon(Singleton_admin.addicon_over);
                pager.pagerInfo.setText("Click to add new user");
                break;
                
            case ModAdmin:
                pager.ModAdmin.setIcon(Singleton_admin.editicon_over);
                pager.pagerInfo.setText("Click to modify selected user");    
                break;
                
            case DelAdmin:
                pager.DelAdmin.setIcon(Singleton_admin.delicon_over);
                pager.pagerInfo.setText("Click to delete selected user");
                break;
                
            case ListAdmin:
                pager.ListAdmin.setIcon(Singleton_admin.lsicon_over);
                pager.pagerInfo.setText("Click to list selected user");
                break;
                
            case btnsavejson:
                pager.btnsavejson.setIcon(Singleton_admin.jsonicon_over);
                pager.pagerInfo.setText("Save to JSON file format");
                break;
                
            case btnsavetxt:
                pager.btnsavetxt.setIcon(Singleton_admin.txticon_over);
                pager.pagerInfo.setText("Save to TXT file format");
                break;
                
            case btnsavexml:
                pager.btnsavexml.setIcon(Singleton_admin.xmlicon_over);
                pager.pagerInfo.setText("Save to XML file format");
                break;
                
            case pagerTable:
                pager.pagerInfo.setText("Select one user");
                break;
                
            case pagLinks:
                pager.pagerInfo.setText("Click on the numbers to navigate pages");
                break;
                
            case comboAdmin:
                pager.pagerInfo.setText("");
                break;
                
            case entriesCombo:
                pager.pagerInfo.setText("");
                break;
            
                        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

        switch (Action.valueOf(e.getComponent().getName())){
                ////Events from pager admin
            case AddAdmin:
                pager.AddAdmin.setIcon(Singleton_admin.addicon);
                pager.pagerInfo.setText("");
                break;
                
            case ModAdmin:
                pager.ModAdmin.setIcon(Singleton_admin.editicon);
                pager.pagerInfo.setText("");    
                break;
                
            case DelAdmin:
                pager.DelAdmin.setIcon(Singleton_admin.delicon);
                pager.pagerInfo.setText("");
                break;
                
            case ListAdmin:
                pager.ListAdmin.setIcon(Singleton_admin.lsicon);
                pager.pagerInfo.setText("");
                break;
                
            case btnsavejson:
                pager.btnsavejson.setIcon(Singleton_admin.jsonicon);
                pager.pagerInfo.setText("");
                break;
                
            case btnsavetxt:
                pager.btnsavetxt.setIcon(Singleton_admin.txticon);
                pager.pagerInfo.setText("");
                break;
                
            case btnsavexml:
                pager.btnsavexml.setIcon(Singleton_admin.xmlicon);
                pager.pagerInfo.setText("");
                break;
                
            case pagerTable:
                pager.pagerInfo.setText("");
                break;
                
            case pagLinks:
                pager.pagerInfo.setText("");
                break;
                
            case comboAdmin:
                pager.pagerInfo.setText("");
                break;
                
            case entriesCombo:
                pager.pagerInfo.setText("");
                break;
                
        }//End switch / case

    }//End mouse exited
    
    @Override
    public void focusGained(FocusEvent e) {
//        System.out.println(e.getComponent().getName());
        
         switch (Action.valueOf(e.getComponent().getName())) {
              case createfieldDNI:
                create.areaInfo.setText(Singleton_app.lang.getProperty("u_idinfo"));
                create.areaInfo.setBackground(Color.decode("#d6d6d6"));
                break;
                
            case createfieldName:
                create.areaInfo.setText(Singleton_app.lang.getProperty("u_nainfo"));
                create.areaInfo.setBackground(Color.decode("#d6d6d6"));
                break;
                
            case createfieldSurname:
                create.areaInfo.setText(Singleton_app.lang.getProperty("u_suinfo"));
                create.areaInfo.setBackground(Color.decode("#d6d6d6"));
                break;
                
            case createfieldEmail:
                create.areaInfo.setText(Singleton_app.lang.getProperty("u_eminfo"));
                create.areaInfo.setBackground(Color.decode("#d6d6d6"));
                break;
            
            case createfieldMobile:
                create.areaInfo.setText(Singleton_app.lang.getProperty("u_moinfo"));
                create.areaInfo.setBackground(Color.decode("#d6d6d6"));
                break;
                
            case createfieldUser:
                create.areaInfo.setText(Singleton_app.lang.getProperty("u_usinfo"));
                create.areaInfo.setBackground(Color.decode("#d6d6d6"));
                break;
                
            case createfieldPassword:
                create.areaInfo.setText(Singleton_app.lang.getProperty("u_painfo"));
                create.areaInfo.setBackground(Color.decode("#d6d6d6"));
                break;
                
            case createfieldVerify:
                create.areaInfo.setText(Singleton_app.lang.getProperty("u_veinfo"));
                create.areaInfo.setBackground(Color.decode("#d6d6d6"));
                break;
                
            case createfieldActivity:
                create.areaInfo.setText(Singleton_app.lang.getProperty("u_acinfo"));
                create.areaInfo.setBackground(Color.decode("#d6d6d6"));
                break;
                
                ////Events from Modify admin:
                
            case editfieldName:
                edit.editareaInfo.setText(Singleton_app.lang.getProperty("u_nainfo"));
                edit.editareaInfo.setBackground(Color.decode("#d6d6d6"));
                break;
                
            case editfieldSurname:
                edit.editareaInfo.setText(Singleton_app.lang.getProperty("u_suinfo"));
                edit.editareaInfo.setBackground(Color.decode("#d6d6d6"));
                break;
                
            case editfieldEmail:
                edit.editareaInfo.setText(Singleton_app.lang.getProperty("u_eminfo"));
                edit.editareaInfo.setBackground(Color.decode("#d6d6d6"));
                break;
            
            case editfieldMobile:
                edit.editareaInfo.setText(Singleton_app.lang.getProperty("u_moinfo"));
                edit.editareaInfo.setBackground(Color.decode("#d6d6d6"));
                break;
                
            case editfieldUser:
                edit.editareaInfo.setText(Singleton_app.lang.getProperty("u_usinfo"));
                edit.editareaInfo.setBackground(Color.decode("#d6d6d6"));
                break;
                
            case editfieldPassword:
                edit.editareaInfo.setText(Singleton_app.lang.getProperty("u_painfo"));
                edit.editareaInfo.setBackground(Color.decode("#d6d6d6"));
                break;
                
            case editfieldVerify:
                edit.editareaInfo.setText(Singleton_app.lang.getProperty("u_veinfo"));
                edit.editareaInfo.setBackground(Color.decode("#d6d6d6"));
                break;
                
            case editfieldActivity:
                edit.editareaInfo.setText(Singleton_app.lang.getProperty("u_acinfo"));
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

            }//End switch case
        }//End if
        if(Singleton_admin.window.equals("modify")){
                    
            switch (Property.valueOf(evt.getPropertyName())) {

                case date:
                    BLL_admin.modAdmindata("birthdate");
                    BLL_admin.modAdmindata("datecontract");
                    edit.editareaInfo.setBackground(Color.decode("#d6d6d6"));
                    break;

            }//End switch case
        }//End if
    }//End of property Change
    
    @Override
    public void windowOpened(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent e) {
        switch(Action.valueOf(e.getComponent().getName())){
            
            case createWindow:
                    create.dispose();
                    new AdminController(new Pager_admin(),2).Init(2);
                break;
            
            case editWindow:
                     edit.dispose(); 
                     new AdminController(new Pager_admin(),2).Init(2);
                break;
                
            case pagerWindow:
                     pager.dispose();
                     new MenuController(new Mainmenu(),0).Init(0);
                break;
                
            case listWindow:
                     list.dispose(); 
                     new AdminController(new Pager_admin(),2).Init(2);
                break;
        }//End switch case
    }//End Windows Closing

    @Override
    public void windowClosed(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}//End class Admin Controller
