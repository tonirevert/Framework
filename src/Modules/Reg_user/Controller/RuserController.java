/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules.Reg_user.Controller;

import Classes.Singleton_app;
import Modules.Reg_user.Controller.RuserController.Action;
import Modules.Reg_user.Model.BLL.BLL_ruser;
import Modules.Reg_user.Model.Classes.Singleton_ruser;
import static Modules.Reg_user.Model.Classes.Singleton_ruser.ru;
import Modules.Reg_user.Model.Utils.pager.AutocompleteJComboBox;
import Modules.Reg_user.Model.Utils.pager.StringSearchable;
import Modules.Reg_user.Model.Utils.pager.pagina;
import static Modules.Reg_user.View.Pager_ruser.pagerTable;
import Modules.Config.Model.Classes.Config_class;
import Modules.Menu.Controller.MenuController;
import Modules.Menu.View.Mainmenu;
import static Modules.Reg_user.Model.Classes.Singleton_ruser.defaultavatar;
import Modules.Reg_user.Model.Classes.miniSimpleTableModel_ruser;
import Modules.Reg_user.View.Create_ruser;
import Modules.Reg_user.View.List_ruser;
import Modules.Reg_user.View.Modify_ruser;
import static Modules.Reg_user.View.Pager_ruser.jComboBox1;
import Modules.Reg_user.View.Pager_ruser;
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
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *Controller for Registered  users
 * @author antonio
 */
public class RuserController implements ActionListener, KeyListener, MouseListener, FocusListener,PropertyChangeListener, WindowListener{

    public static Create_ruser create;
    public static Modify_ruser edit;
    public static Pager_ruser pager;
    public static List_ruser list;
    public static TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(new miniSimpleTableModel_ruser());
    public static AutocompleteJComboBox comboRuser = null;
    public String comb="";
    
    
    /**
     * Used to call the controller
     * @param frame the name of the frame to use
     * @param i  the case to use from switch options
     */
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
                
            case 3:
                list=(List_ruser)frame;
                break;
        }
                
    }
               
    /**
     * Enumeration of Actions
     */
    public enum Action{
        
        //Create reg user buttons and fields:
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
        
        //Edit reg user buttons and fields
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
        
        //Pager reg user buttons and fields
        pagerWindow,
        AddRuser,
        ModRuser,
        DelRuser,
        ListRuser,
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
        pagReturn,
        
        //List reg user
        listWindow,
        listbtnReturn
    }
    
    /**
     * Enumeration of Properties
     */
    public enum Property{
        
        //JCalendar return properties
        date,//Used for datebirth and date contract
        background,//Used for datebirth and date contract
        enabled,//Used for datebirth and date contract
        ancestor//Used for datebirth and date contract
    }
    
    /**
     * Initialize the frames
     * @param i  0 for create reg user, 1 for modify reg user, 2 for reg user pager, 3 for list reg user
     */
    public void Init(int i){
        
        switch(i){
            
            case 0://Create reg user
                int cx=650;
                int cy=500;
                create.back.setSize(cx,cy);
                Image crback=Singleton_ruser.backCrMo.getImage();
                create.back.setIcon(new ImageIcon(crback.getScaledInstance(cx,cy, java.awt.Image.SCALE_SMOOTH)));
                Singleton_ruser.window="create";
                create.saving.setVisible(false);
                create.setResizable(false);
                create.setSize(cx,cy);
                create.dateBirth.setDateFormatString(Config_class.getinstance().getDate_format());
                create.dateBirth.getDateEditor().setEnabled(false);
                create.areaInfo.setEditable(false);
                create.areaInfo.setBackground(Color.decode("#d6d6d6"));
                create.setLocationRelativeTo(null);
                create.avatar.setIcon(defaultavatar);
                create.setVisible(true);
                
                //Translation:
                create.setTitle(Singleton_app.lang.getProperty("r_wcreate"));
                create.labelDNI.setText(Singleton_app.lang.getProperty("u_idcard"));
                create.labelName.setText(Singleton_app.lang.getProperty("u_name"));
                create.labelSurname.setText(Singleton_app.lang.getProperty("u_surname"));
                create.labelMobile.setText(Singleton_app.lang.getProperty("u_mobile"));
                create.labelUser.setText(Singleton_app.lang.getProperty("u_user"));
                create.labelPassword.setText(Singleton_app.lang.getProperty("u_password"));
                create.labelPassword2.setText(Singleton_app.lang.getProperty("u_verify"));
                create.labeldateBitrh.setText(Singleton_app.lang.getProperty("u_birthday"));
                create.labelState.setText(Singleton_app.lang.getProperty("u_state"));
                create.radioStateYes.setText(Singleton_app.lang.getProperty("booleanyes"));
                create.radioStateNo.setText(Singleton_app.lang.getProperty("booleanno"));
                create.labelActivity.setText(Singleton_app.lang.getProperty("r_activity"));
                
                create.btnsaveCreateruser.setText(Singleton_app.lang.getProperty("w_create"));
                create.btnresetCreateruser.setText(Singleton_app.lang.getProperty("w_Reset"));
                create.btncancelCreateruser.setText(Singleton_app.lang.getProperty("w_Cancel"));
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
                
                create.fieldActivity.setActionCommand("createfieldActivity");
                create.fieldActivity.setName("createfieldActivity");
                create.fieldActivity.addFocusListener(this);
                create.fieldActivity.addActionListener(this);
                create.fieldActivity.addKeyListener(this);
                
                create.btnsaveCreateruser.setName("createbtnSave");
                create.btnsaveCreateruser.addMouseListener(this);

                create.btnresetCreateruser.setName("createbtnReset");
                create.btnresetCreateruser.addMouseListener(this);
                
                create.btncancelCreateruser.setName("createbtnCancel");
                create.btncancelCreateruser.addMouseListener(this);
                
                
                break;//End case 0
                
            case 1://Modify reg user
                int ex=650;
                int ey=500;
                edit.back.setSize(ex,ey);
                Image edback=Singleton_ruser.backCrMo.getImage();
                edit.back.setIcon(new ImageIcon(edback.getScaledInstance(ex, ey, java.awt.Image.SCALE_SMOOTH)));
                Singleton_ruser.window="modify";
                edit.saving.setVisible(false);
                BLL_ruser.fill_ruser(ru.getDni());
                edit.fieldDNI.setEditable(false);
                edit.setResizable(false);
                edit.setSize(ex,ey);
                edit.editdateBirth.setDateFormatString(Config_class.getinstance().getDate_format());
                edit.editdateBirth.getDateEditor().setEnabled(false);
                edit.setLocationRelativeTo(null);
                edit.btnLogout.setVisible(false);
                edit.setVisible(true);

                //Translation:
                edit.setTitle(Singleton_app.lang.getProperty("r_wedit"));
                edit.labelDNI.setText(Singleton_app.lang.getProperty("u_idcard"));
                edit.labelName.setText(Singleton_app.lang.getProperty("u_name"));
                edit.labelSurname.setText(Singleton_app.lang.getProperty("u_surname"));
                edit.labelMobile.setText(Singleton_app.lang.getProperty("u_mobile"));
                edit.labelUser.setText(Singleton_app.lang.getProperty("u_user"));
                edit.labelPassword.setText(Singleton_app.lang.getProperty("u_password"));
                edit.labelPassword2.setText(Singleton_app.lang.getProperty("u_verify"));
                edit.labeldateBirth.setText(Singleton_app.lang.getProperty("u_birthday"));
                edit.labelState.setText(Singleton_app.lang.getProperty("u_state"));
                edit.radioStateYes.setText(Singleton_app.lang.getProperty("booleanyes"));
                edit.radioStateNo.setText(Singleton_app.lang.getProperty("booleanno"));
                edit.labelActivity.setText(Singleton_app.lang.getProperty("r_activity"));
                
                edit.btnsaveEditruser.setText(Singleton_app.lang.getProperty("w_save"));
                edit.btncancelEditruser.setText(Singleton_app.lang.getProperty("w_Cancel"));
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
                
                edit.editfieldActivity.setActionCommand("editfieldActivity");
                edit.editfieldActivity.setName("editfieldActivity");
                edit.editfieldActivity.addFocusListener(this);
                edit.editfieldActivity.addActionListener(this);
                edit.editfieldActivity.addKeyListener(this);

                edit.btnsaveEditruser.setName("editbtnSave");
                edit.btnsaveEditruser.addMouseListener(this);
                
                edit.btncancelEditruser.setName("editbtnCancel");
                edit.btncancelEditruser.addMouseListener(this);
                break;//End case 1
                
            case 2://Pager reg user
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
                myWords.add(Singleton_ruser.rus.get(e).getDni());
                }
                
                StringSearchable searchable = new StringSearchable(myWords);
                comboRuser = new AutocompleteJComboBox(searchable);
                pager.jPanel3.setLayout(new java.awt.BorderLayout());
                pager.jPanel3.add(comboRuser);
                             
                //Translation:
                pager.setTitle(Singleton_app.lang.getProperty("r_wlist"));
                pager.labelSearch.setText(Singleton_app.lang.getProperty("pa_search"));
                pager.labelEntries.setText(Singleton_app.lang.getProperty("pa_shoentr"));
                pager.pagReturn.setText(Singleton_app.lang.getProperty("pa_return"));
                
                pager.comboSearch.removeAllItems();
                pager.comboSearch.addItem(Singleton_app.lang.getProperty("min_idcard"));
                pager.comboSearch.addItem(Singleton_app.lang.getProperty("min_name"));
                pager.comboSearch.addItem(Singleton_app.lang.getProperty("min_surname"));
                
                //Action:
                pager.AddRuser.setToolTipText(Singleton_app.lang.getProperty("pa_adduser"));
                pager.ModRuser.setToolTipText(Singleton_app.lang.getProperty("pa_modiuser"));
                pager.DelRuser.setToolTipText(Singleton_app.lang.getProperty("pa_remouser"));
                pager.ListRuser.setToolTipText(Singleton_app.lang.getProperty("pa_listuser"));
                pager.btnsavejson.setToolTipText(Singleton_app.lang.getProperty("pa_savjson"));
                pager.btnsavetxt.setToolTipText(Singleton_app.lang.getProperty("pa_savtxt"));
                pager.btnsavexml.setToolTipText(Singleton_app.lang.getProperty("pa_savxml"));
                pager.pagerTable.setToolTipText(Singleton_app.lang.getProperty("pa_clichoose"));
                pager.pagButtonpanel.setToolTipText(Singleton_app.lang.getProperty("pa_usebutt"));
                pager.pagFirst.setToolTipText(Singleton_app.lang.getProperty("pa_clifisrt"));
                pager.pagPrev.setToolTipText(Singleton_app.lang.getProperty("pa_cliprev"));
                pager.pagNext.setToolTipText(Singleton_app.lang.getProperty("pa_clinext"));
                pager.pagLast.setToolTipText(Singleton_app.lang.getProperty("pa_clilast"));
                pager.pagLinks.setToolTipText(Singleton_app.lang.getProperty("pa_clinumb"));
                pager.pagReturn.setToolTipText(Singleton_app.lang.getProperty("pa_cliretu"));
                jComboBox1.setToolTipText(Singleton_app.lang.getProperty("pa_cliamou"));
                this.comboRuser.setToolTipText(Singleton_app.lang.getProperty("pa_searchu"));
                
                pager.setName("pagerWindow");
                pager.addWindowListener(this);
                pager.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                
                pager.AddRuser.setName("AddRuser");
                pager.AddRuser.addMouseListener(this);
                
                pager.ModRuser.setName("ModRuser");
                pager.ModRuser.addMouseListener(this);
                
                pager.DelRuser.setName("DelRuser");
                pager.DelRuser.addMouseListener(this);
                
                pager.ListRuser.setName("ListRuser");
                pager.ListRuser.addMouseListener(this);
                
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
                comboRuser.addMouseListener(this);
                
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
                
                break;//End case 2 Pager reg user
                
            case 3:
                int lx=550;
                int ly=413;
                list.back.setSize(lx,ly);
                Image lsback=Singleton_ruser.backList.getImage();
                List_ruser.back.setIcon(new ImageIcon(lsback.getScaledInstance(lx, ly, java.awt.Image.SCALE_SMOOTH)));
                list.StringArea.setEditable(false);
                list.setLocationRelativeTo(null);
                list.setSize(lx,ly);
                list.setResizable(false);
                list.setVisible(true);
                
                list.setName("listWindow");
                list.addWindowListener(this);
                list.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                
                list.setTitle(Singleton_app.lang.getProperty("li_ruser"));
                Border border = new TitledBorder (Singleton_app.lang.getProperty("ruser"));
                list.StringArea.setBorder(border);
                list.btnReturn.setText(Singleton_app.lang.getProperty("pa_return"));
                list.btnReturn.setName("listbtnReturn");
                list.btnReturn.addMouseListener(this);
        
                break;//End case 3 List reg user
            
        }
        
    }
    
    @Override
    /**
     * Not used
     */
    public void keyTyped(KeyEvent e) {
    }

    @Override
    /**
     * Used for actions when the a key is pressed
     */
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
                
                ////Events from Modify registered user
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
    /**
     * Used for actions when the a key is released
     */
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
    /**
     * Used for actions performed
     */
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
    /**
     * Used for actions when the mouse is clicked in the declared fields
     */
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
                        create.areaInfo.setText(Singleton_app.lang.getProperty("w_ucreated"));
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
                    edit.editareaInfo.setText(Singleton_app.lang.getProperty("w_usaved"));
                    edit.editareaInfo.setBackground(Color.green);
                }else{
                    edit.editareaInfo.setText(Singleton_app.lang.getProperty("w_udatinco"));
                    edit.editareaInfo.setBackground(Color.red);
                }
                break;
                
            case editbtnCancel:
                edit.dispose();
                new RuserController(new Pager_ruser(),2).Init(2);
                break;
                
                ////Events from pager admin
            case AddRuser:
                pager.dispose();
                new RuserController(new Create_ruser(),0).Init(0);
                break;
                
            case ModRuser:
                boolean modify;
                modify = BLL_ruser.edit_ruser();
                if (modify == true) {
                pager.dispose();
                }
                break;
                
            case DelRuser:
                    BLL_ruser.delete_file();
                break;
                
            case ListRuser:
                if(true==BLL_ruser.list_ruser()){
                    pager.dispose();
                }
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
                
                ////Events from list Reg user
            case listbtnReturn:
                list.dispose();
                new RuserController(new Pager_ruser(),2).Init(2);
                break;
         }
        

                
    }

    @Override
    /**
     * Not used
     */
    public void mousePressed(MouseEvent e) {
    }

    @Override
    /**
     * Not used
     */
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    /**
     * Used when the mouse enters in the declared values
     */
    public void mouseEntered(MouseEvent e) {
//        System.out.println(e.getComponent().getName());

        switch (Action.valueOf(e.getComponent().getName())){
                ////Events from pager admin
            case AddRuser:
                pager.AddRuser.setIcon(Singleton_ruser.addicon_over);
                pager.pagerInfo.setText(Singleton_app.lang.getProperty("pa_adduser"));
                break;
                
            case ModRuser:
                pager.ModRuser.setIcon(Singleton_ruser.editicon_over);
                pager.pagerInfo.setText(Singleton_app.lang.getProperty("pa_modiuser"));
                break;
                
            case DelRuser:
                pager.DelRuser.setIcon(Singleton_ruser.delicon_over);
                pager.pagerInfo.setText(Singleton_app.lang.getProperty("pa_remouser"));
                break;
                
            case ListRuser:
                pager.ListRuser.setIcon(Singleton_ruser.lsicon_over);
                pager.pagerInfo.setText(Singleton_app.lang.getProperty("pa_listuser"));
                break;
                
            case btnsavejson:
                pager.btnsavejson.setIcon(Singleton_ruser.jsonicon_over);
                pager.pagerInfo.setText(Singleton_app.lang.getProperty("pa_savjson"));
                break;
                
            case btnsavetxt:
                pager.btnsavetxt.setIcon(Singleton_ruser.txticon_over);
                pager.pagerInfo.setText(Singleton_app.lang.getProperty("pa_savtxt"));
                break;
                
            case btnsavexml:
                pager.btnsavexml.setIcon(Singleton_ruser.xmlicon_over);
                pager.pagerInfo.setText(Singleton_app.lang.getProperty("pa_savxml"));
                break;
                
            case pagerTable:
                pager.pagerInfo.setText(Singleton_app.lang.getProperty("pa_clichoose"));
                break;
                
            case pagLinks:
                pager.pagerInfo.setText(Singleton_app.lang.getProperty("pa_clinumb"));
                break;
                
            case comboRuser:
                pager.pagerInfo.setText(Singleton_app.lang.getProperty("pa_searchu"));
                break;
                
            case entriesCombo:
                pager.pagerInfo.setText(Singleton_app.lang.getProperty("pa_cliamou"));
                break;
            
                        }
    }

    @Override
    /**
     * Used when the mouse exists in the declared values
     */
    public void mouseExited(MouseEvent e) {

        switch (Action.valueOf(e.getComponent().getName())){
                ////Events from pager admin
            case AddRuser:
                pager.AddRuser.setIcon(Singleton_ruser.addicon);
                pager.pagerInfo.setText("");
                break;
                
            case ModRuser:
                pager.ModRuser.setIcon(Singleton_ruser.editicon);
                pager.pagerInfo.setText("");    
                break;
                
            case DelRuser:
                pager.DelRuser.setIcon(Singleton_ruser.delicon);
                pager.pagerInfo.setText("");
                break;
                
            case ListRuser:
                pager.ListRuser.setIcon(Singleton_ruser.lsicon);
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
                
            case comboRuser:
                pager.pagerInfo.setText("");
                break;
                
            case entriesCombo:
                pager.pagerInfo.setText("");
                break;
                
        }

    }
    
    @Override
    /**
     * Used when the declared fiels gains the focus
     */
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
                create.areaInfo.setText(Singleton_app.lang.getProperty("uc_inpasswd"));
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
                
                ////Events from Modify Registered user:
                
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
                edit.editareaInfo.setText(Singleton_app.lang.getProperty("uc_inpasswd"));
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
    /**
     * Used when the declared fiels losts the focus
     */
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
                
                ////Events from Modify registered user:
                
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
    /**
     * Used for the property change of date fields
     */
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
    /**
     * Not used
     */
    public void windowOpened(WindowEvent e) {
    }

    @Override
    /**
     * Used when a window is closed
     */
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
                
            case listWindow:
                    list.dispose();
                    new RuserController(new Pager_ruser(),2).Init(2);
                break;
        }//End switch case
    }//End Windows Closing

    @Override
    /**
     * Not used
     */
    public void windowClosed(WindowEvent e) {
    }

    @Override
    /**
     * Not used
     */
    public void windowIconified(WindowEvent e) {
    }

    @Override
    /**
     * Not used
     */
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    /**
     * Not used
     */
    public void windowActivated(WindowEvent e) {
    }

    @Override
    /**
     * Not used
     */
    public void windowDeactivated(WindowEvent e) {
    }
}//End class Admin Controller
