/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules.Reg_user.Controller;

import Modules.Reg_user.Controller.RuserController.Action;
import Modules.Reg_user.Model.BLL.BLL_ruser;
import Modules.Reg_user.Model.Classes.Singleton_ruser;
import static Modules.Reg_user.Model.Classes.Singleton_ruser.ru;
import Modules.Reg_user.Model.Utils.pager.AutocompleteJComboBox;
import Modules.Reg_user.Model.Utils.pager.StringSearchable;
import Modules.Reg_user.Model.Utils.pager.pagina;
import static Modules.Reg_user.View.Pager_ruser.jComboBox1;
import static Modules.Reg_user.View.Pager_ruser.pagerTable;
import Modules.Config.Classes.Config_class;
import Modules.Menu.Controller.MenuController;
import Modules.Menu.View.Mainmenu;
import static Modules.Reg_user.Model.Classes.Singleton_ruser.defaultavatar;
import Modules.Reg_user.Model.Classes.miniSimpleTableModel_ruser;
import Modules.Reg_user.View.Create_ruser;
import Modules.Reg_user.View.Modify_ruser;
import Modules.Reg_user.View.Pager_ruser;
import java.awt.Color;
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
import javax.swing.JFrame;
import javax.swing.Timer;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author antonio
 */
public class RuserController implements ActionListener, KeyListener, MouseListener, FocusListener,PropertyChangeListener, WindowListener{

    public static Create_ruser create;
    public static Modify_ruser edit;
    public static Pager_ruser pager;
    public static TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(new miniSimpleTableModel_ruser());
    public static AutocompleteJComboBox comboRuser = null;
    public String comb="";
    
    public RuserController(JFrame frame, int i){
        switch(i){
            case 0:
                create=(Create_ruser) frame;
                break;
                
            case 1:
                edit=(Modify_ruser)frame;
                break;
                
            case 2:
                pager=(Pager_ruser)frame;
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
//        createfieldKarma,
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
//        editfieldKarma,
        editbtnSave,
        editbtnCancel,
        
        //Pager admin buttons and fields
        pagerWindow,
        AddAdmin,
        ModAdmin,
        DelAdmin,
        btnsavejson,
        btnsavetxt,
        btnsavexml,
        pagerTable,
        comboBoxChanged,
        comboBoxEdited,
        comboRuser,
        entriesCombo,
        jComboBox1,
        pagFirst,
        pagPrev,
        pagBox,
        pagNext,
        pagLast,
        pagLinks,
        pagReturn
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
                Singleton_ruser.window="create";
                create.setTitle("Create Reg. user");////////////////////////////////////////////////////////////////////////
                create.saving.setVisible(false);
                create.setResizable(false);
                create.setSize(600,500);
                create.dateBirth.setDateFormatString(Config_class.getinstance().getDate_format());
                create.dateBirth.getDateEditor().setEnabled(false);
                create.areaInfo.setEditable(false);
                create.areaInfo.setBackground(Color.decode("#d6d6d6"));
                create.setLocationRelativeTo(null);
                create.avatar.setIcon(defaultavatar);
                create.setVisible(true);
                
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
                
                create.fieldActivity.setActionCommand("createfieldActivity");
                create.fieldActivity.setName("createfieldActivity");
                create.fieldActivity.addFocusListener(this);
                create.fieldActivity.addActionListener(this);
                create.fieldActivity.addKeyListener(this);
                
//                create.fieldKarma.setActionCommand("createfieldKarma");
//                create.fieldKarma.setName("createfieldKarma");
//                create.fieldKarma.addFocusListener(this);
//                create.fieldKarma.addActionListener(this);
//                create.fieldKarma.addKeyListener(this);
                
                create.btnsaveCreateruser.setName("createbtnSave");
                create.btnsaveCreateruser.addMouseListener(this);

                create.btnresetCreateruser.setName("createbtnReset");
                create.btnresetCreateruser.addMouseListener(this);
                
                create.btncancelCreateruser.setName("createbtnCancel");
                create.btncancelCreateruser.addMouseListener(this);
                
                
                break;//End case 0
                
            case 1://Modify admin
                Singleton_ruser.window="modify";
                edit.setTitle("Modify Reg. user");////////////////////////////////////////////////////////////////////////
                edit.saving.setVisible(false);
                BLL_ruser.fill_ruser(ru.getDni());
                edit.fieldDNI.setEditable(false);
                edit.setResizable(false);
                edit.setSize(600,500);
                edit.editdateBirth.setDateFormatString(Config_class.getinstance().getDate_format());
                edit.editdateBirth.getDateEditor().setEnabled(false);
                edit.setLocationRelativeTo(null);
                edit.setVisible(true);

                
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
                
                edit.editfieldActivity.setActionCommand("editfieldActivity");
                edit.editfieldActivity.setName("editfieldActivity");
                edit.editfieldActivity.addFocusListener(this);
                edit.editfieldActivity.addActionListener(this);
                edit.editfieldActivity.addKeyListener(this);
                
//                edit.editfieldKarma.setActionCommand("editfieldKarma");
//                edit.editfieldKarma.setName("editfieldKarma");
//                edit.editfieldKarma.addFocusListener(this);
//                edit.editfieldKarma.addActionListener(this);
//                edit.editfieldKarma.addKeyListener(this);
                
                edit.btnsaveEditruser.setName("editbtnSave");
                edit.btnsaveEditruser.addMouseListener(this);
                
                edit.btncancelEditruser.setName("editbtnCancel");
                edit.btncancelEditruser.addMouseListener(this);
                break;//End case 1
                
            case 2://Pager admin
                pager.setTitle("Reg. user management list");
                pager.setLocationRelativeTo(null);
                pager.setResizable(false);
                pager.setVisible(true);
                
                pager.pagerTable.setModel( new miniSimpleTableModel_ruser() );
                ((miniSimpleTableModel_ruser)pagerTable.getModel()).cargar();
                pager.pagerTable.setFillsViewportHeight(true);
                pager.pagerTable.setRowSorter(sorter);
                
                pagina.inicializa();
                pagina.initLinkBox();
                
                pager.pagAmount.setText(String.valueOf(Singleton_ruser.rus.size()));
                
                List<String> myWords = new ArrayList<String>();
                
                for (int e=0;e<=Singleton_ruser.rus.size()-1;e++) {
                myWords.add(Singleton_ruser.rus.get(e).getName());
                }
                
                StringSearchable searchable = new StringSearchable(myWords);
                comboRuser = new AutocompleteJComboBox(searchable);
                pager.jPanel3.setLayout(new java.awt.BorderLayout());
                pager.jPanel3.add(comboRuser);
                               
                pager.AddAdmin.setToolTipText("Add a new admin user");
                pager.ModAdmin.setToolTipText("Modify selected admin user");
                pager.DelAdmin.setToolTipText("Delete selected admin user");
                pager.btnsavejson.setToolTipText("Save users to JSON");
                pager.btnsavetxt.setToolTipText("Save users to TXT");
                pager.btnsavexml.setToolTipText("Save users to XML");
                pager.pagerTable.setToolTipText("Click to choose one user");
                pager.pagButtonpanel.setToolTipText("Use the buttons for navigate the pages");
                pager.pagFirst.setToolTipText("Click to go to first page");
                pager.pagPrev.setToolTipText("Click to go to previous page");
                pager.pagNext.setToolTipText("Click to go to next page");
                pager.pagLast.setToolTipText("Click to go to last page");
                pager.pagLinks.setToolTipText("Click on the numbers for navigate the pages");
                pager.pagReturn.setToolTipText("Click to return to the previous menu");
                jComboBox1.setToolTipText("Click to change the amount of users per page");
                this.comboRuser.setToolTipText("Click to user search");
                
                pager.setName("pagerWindow");
                pager.addWindowListener(this);
                pager.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                
                pager.AddAdmin.setName("AddAdmin");
                pager.AddAdmin.addMouseListener(this);
                
                pager.ModAdmin.setName("ModAdmin");
                pager.ModAdmin.addMouseListener(this);
                
                pager.DelAdmin.setName("DelAdmin");
                pager.DelAdmin.addMouseListener(this);
                
                pager.btnsavejson.setName("btnsavejson");
                pager.btnsavejson.addMouseListener(this);
                
                pager.btnsavetxt.setName("btnsavetxt");
                pager.btnsavetxt.addMouseListener(this);
                
                pager.btnsavexml.setName("btnsavexml");
                pager.btnsavexml.addMouseListener(this);
                
                pager.pagerTable.setName("pagerTable");
                pager.pagerTable.addMouseListener(this);
                
                comboRuser.setActionCommand("comboRuser");
                comboRuser.setName("comboRuser");
                comboRuser.addActionListener(this);
                
                jComboBox1.setActionCommand("entriesCombo");
                jComboBox1.setName("entriesCombo");
                jComboBox1.addActionListener(this);
                
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
                BLL_ruser.askRuserdata("dni");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    create.fieldName.requestFocus();
                }
                break;
                
            case createfieldName:
                BLL_ruser.askRuserdata("name");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    create.fieldSurname.requestFocus();
	}
                break;
                
            case createfieldSurname:
                BLL_ruser.askRuserdata("surname");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    create.fieldEmail.requestFocus();
	}
                break;
                
            case createfieldEmail:
                BLL_ruser.askRuserdata("email");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    create.fieldMobile.requestFocus();
	}
                break;
                
            case createfieldMobile:
                BLL_ruser.askRuserdata("mobile");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    create.fieldUser.requestFocus();
	}
                break;
                
            case createfieldUser:
                BLL_ruser.askRuserdata("user");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    create.fieldPassword.requestFocus();
	}
                break;
                
            case createfieldPassword:
                BLL_ruser.askRuserdata("password");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    create.fieldPassword2.requestFocus();
	}
                break;
                
            case createfieldVerify:
                BLL_ruser.askRuserdata("password2");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    create.fieldActivity.requestFocus();
	}
                break;
                
            case createfieldActivity:
                BLL_ruser.askRuserdata("activity");
                break;
                
                ////Events from Modify admin
            case editfieldName:
                BLL_ruser.modRuserdata("name");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    edit.editfieldSurname.requestFocus();
	}
                break;
                
            case editfieldSurname:
                BLL_ruser.modRuserdata("surname");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    edit.editfieldEmail.requestFocus();
	}
                break;
                
            case editfieldEmail:
                BLL_ruser.modRuserdata("email");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    edit.editfieldMobile.requestFocus();
	}
                break;
                
            case editfieldMobile:
                BLL_ruser.modRuserdata("mobile");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    edit.editfieldUser.requestFocus();
	}
                break;
                
            case editfieldUser:
                BLL_ruser.modRuserdata("user");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    edit.editfieldPassword.requestFocus();
	}
                break;
                
            case editfieldPassword:
                BLL_ruser.modRuserdata("password");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    edit.editfieldPassword2.requestFocus();
	}
                break;
                
            case editfieldVerify:
                BLL_ruser.modRuserdata("password2");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    edit.editfieldActivity.requestFocus();
	}
                break;
                
            case editfieldActivity:
                BLL_ruser.modRuserdata("activity");
                break;

        }//End switch case keyPressed
    }//End of keyPressed

    @Override
    public void keyReleased(KeyEvent e) {
         switch (Action.valueOf(e.getComponent().getName())) {
            case createfieldDNI:
                BLL_ruser.askRuserdata("dni");
                break;
                
            case createfieldName:
                BLL_ruser.askRuserdata("name");
                break;
                
            case createfieldSurname:
                BLL_ruser.askRuserdata("surname");
                break;
                
            case createfieldEmail:
                BLL_ruser.askRuserdata("email");
                break;
            
            case createfieldMobile:
                BLL_ruser.askRuserdata("mobile");
                break;
                
            case createfieldUser:
                BLL_ruser.askRuserdata("user");
                break;
                
            case createfieldPassword:
                BLL_ruser.askRuserdata("password");
                break;
                
            case createfieldVerify:
                BLL_ruser.askRuserdata("password2");
                break;
                
            case createfieldActivity:
                BLL_ruser.askRuserdata("activity");
                break;
                
                ////Events from Modify admin:
                
            case editfieldName:
                BLL_ruser.modRuserdata("name");
                break;
                
            case editfieldSurname:
                BLL_ruser.modRuserdata("surname");
                break;
                
            case editfieldEmail:
                BLL_ruser.modRuserdata("email");
                break;
                
            case editfieldMobile:
                BLL_ruser.modRuserdata("mobile");
                break;
                
            case editfieldUser:
                BLL_ruser.modRuserdata("user");
                break;
                
            case editfieldPassword:
                BLL_ruser.modRuserdata("password");
                break;
                
            case editfieldVerify:
                BLL_ruser.modRuserdata("password2");
                break;
                
            case editfieldActivity:
                BLL_ruser.modRuserdata("activity");
                break;
        }//End switch case keyReleased
    }//End of keyReleased
    
    @Override
    public void actionPerformed(ActionEvent e) {
//        System.out.println(e.getActionCommand());
        switch (Action.valueOf(e.getActionCommand())){
           
            case comboRuser:
                    pagina.currentPageIndex = 1;
                    pagina.initLinkBox();
                    ((miniSimpleTableModel_ruser)pagerTable.getModel()).filtrar();
                    comboRuser.requestFocus();
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
                BLL_ruser.askRuserdata("avatar");
                break;
            
            case createbtnSave:
                if(BLL_ruser.create_ruser()==true){
                Timer delay = new Timer(3000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                            create.dispose();
                            new RuserController(new Pager_ruser(),2).Init(2);
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
                BLL_ruser.resetFields();
                break;
                
            case createbtnCancel:
                create.dispose();
                new RuserController(new Pager_ruser(),2).Init(2);
                break;
                
                ////Events from Modify admin:
                
            case editbtnSearch:
                BLL_ruser.modRuserdata("avatar");
                break;
                
            case editbtnSave:
                if(BLL_ruser.save_mod_ruser()!=false){
                    Timer delay = new Timer(3000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            edit.dispose();
                            new RuserController(new Pager_ruser(),2).Init(2);
                        }
                    });
                    edit.saving.setVisible(true);
                    delay.setRepeats(false);
                    delay.start();
                    BLL_ruser.autosaveRuser();
                    edit.editareaInfo.setText("User saved correctly");
                    edit.editareaInfo.setBackground(Color.green);
                }else{
                    edit.editareaInfo.setText("User data incomplete, please revise it");
                    edit.editareaInfo.setBackground(Color.red);
                }
                break;
                
            case editbtnCancel:
                edit.dispose();
                new RuserController(new Pager_ruser(),2).Init(2);
                break;
                
                ////Events from pager admin
            case AddAdmin:
                pager.dispose();
                new RuserController(new Create_ruser(),0).Init(0);
                break;
                
            case ModAdmin:
                boolean modify;
                modify = BLL_ruser.edit_ruser();
                if (modify == true) {
                pager.dispose();
                }
                break;
                
            case DelAdmin:
                    BLL_ruser.delete_file();
                break;
                
            case btnsavejson:
                BLL_ruser.savejsonRuser();
                break;
                
            case btnsavetxt:
                BLL_ruser.savetxtRuser();
                break;
                
            case btnsavexml:
                BLL_ruser.savexmlRuser();
                break;
                
            case pagerTable:
                if (e.getClickCount() == 2) {
                pager.dispose();
                BLL_ruser.edit_ruser();
                }
                break;
                
            case entriesCombo:
                System.out.println("framework_v2.Modules.Admin.Controller.AdminController.mouseClicked()");
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
                pager.AddAdmin.setIcon(Singleton_ruser.addicon_over);
                pager.pagerInfo.setText("Click to add new Admin user");
                break;
                
            case ModAdmin:
                pager.ModAdmin.setIcon(Singleton_ruser.editicon_over);
                pager.pagerInfo.setText("Click to modify selected Admin user");    
                break;
                
            case DelAdmin:
                pager.DelAdmin.setIcon(Singleton_ruser.delicon_over);
                pager.pagerInfo.setText("Click to delete selected Admin user");
                break;
                
            case btnsavejson:
                pager.btnsavejson.setIcon(Singleton_ruser.jsonicon_over);
                pager.pagerInfo.setText("Save to JSON file format");
                break;
                
            case btnsavetxt:
                pager.btnsavetxt.setIcon(Singleton_ruser.txticon_over);
                pager.pagerInfo.setText("Save to TXT file format");
                break;
                
            case btnsavexml:
                pager.btnsavexml.setIcon(Singleton_ruser.xmlicon_over);
                pager.pagerInfo.setText("Save to XML file format");
                break;
                
            case pagerTable:
                pager.pagerInfo.setText("Select one user");
                break;
                
            case pagLinks:
                pager.pagerInfo.setText("Click on the numbers to navigate pages");
                break;
            
                        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

        switch (Action.valueOf(e.getComponent().getName())){
                ////Events from pager admin
            case AddAdmin:
                pager.AddAdmin.setIcon(Singleton_ruser.addicon);
                pager.pagerInfo.setText("");
                break;
                
            case ModAdmin:
                pager.ModAdmin.setIcon(Singleton_ruser.editicon);
                pager.pagerInfo.setText("");    
                break;
                
            case DelAdmin:
                pager.DelAdmin.setIcon(Singleton_ruser.delicon);
                pager.pagerInfo.setText("");
                break;
                
            case btnsavejson:
                pager.btnsavejson.setIcon(Singleton_ruser.jsonicon);
                pager.pagerInfo.setText("");
                break;
                
            case btnsavetxt:
                pager.btnsavetxt.setIcon(Singleton_ruser.txticon);
                pager.pagerInfo.setText("");
                break;
                
            case btnsavexml:
                pager.btnsavexml.setIcon(Singleton_ruser.xmlicon);
                pager.pagerInfo.setText("");
                break;
                
            case pagerTable:
                pager.pagerInfo.setText("");
                break;
                
            case pagLinks:
                pager.pagerInfo.setText("");
                break;
                
        }

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
                
//            case createfieldKarma:
//                create.areaInfo.setText("Input the karma (in text)");
//                create.areaInfo.setBackground(Color.decode("#d6d6d6"));
//                break;
                
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
                
//            case editfieldKarma:
//                edit.editareaInfo.setText("Input the karma (in text)");
//                edit.editareaInfo.setBackground(Color.decode("#d6d6d6"));
//                break;
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
                
//            case createfieldKarma:
//                create.areaInfo.setText("");
//                break;
                
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
                
//            case editfieldKarma:
//                create.areaInfo.setText("");
//                break;
         }
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
//        System.out.println(evt.getPropertyName());

        if(Singleton_ruser.window.equals("create")){
                    
            switch (Property.valueOf(evt.getPropertyName())) {

                case date:
                    BLL_ruser.askRuserdata("birthdate");
                    BLL_ruser.askRuserdata("datecontract");
                    create.areaInfo.setBackground(Color.decode("#d6d6d6"));
                    break;

            }//End switch case
        }//End if
        if(Singleton_ruser.window.equals("modify")){
                    
            switch (Property.valueOf(evt.getPropertyName())) {

                case date:
                    BLL_ruser.modRuserdata("birthdate");
                    BLL_ruser.modRuserdata("datecontract");
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
                    new RuserController(new Pager_ruser(),2).Init(2);
                break;
            
            case editWindow:
                     edit.dispose(); 
                     new RuserController(new Pager_ruser(),2).Init(2);
                break;
                
            case pagerWindow:
                     pager.dispose();
                     new MenuController(new Mainmenu(),0).Init(0);
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
