/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules.Menu.Controller;

import Classes.Mongo_DB;
import Classes.Singleton_app;
import static Modules.Menu.Classes.Singleton_menus.adminicon;
import static Modules.Menu.Classes.Singleton_menus.adminicon_over;
import static Modules.Menu.Classes.Singleton_menus.clienticon;
import static Modules.Menu.Classes.Singleton_menus.clienticon_over;
import static Modules.Menu.Classes.Singleton_menus.configicon;
import static Modules.Menu.Classes.Singleton_menus.configicon_over;
import static Modules.Menu.Classes.Singleton_menus.rusericon;
import static Modules.Menu.Classes.Singleton_menus.rusericon_over;
import Modules.Admin.Controller.AdminController;
import Modules.Admin.View.Pager_admin;
import Modules.Client.Controller.ClientController;
import Modules.Client.Model.BLL.BLL_client;
import Modules.Client.Model.Classes.Singleton_client;
import Modules.Client.View.Modify_client;
import Modules.Client.View.Pager_client;
import Modules.Config.Model.BLL.BLL_Config;
import Modules.Config.Model.Classes.Config_class;
import Modules.Config.Model.Classes.theme_class;
import Modules.Config.View.Config;
import Modules.Menu.Classes.Singleton_menus;
import static Modules.Menu.Controller.MenuController.Action.btnAdmin;
import static Modules.Menu.Controller.MenuController.Action.btnConfig;
import static Modules.Menu.Controller.MenuController.main;
import Modules.Menu.Model.BLL.BLL_Login;
import Modules.Menu.Model.DAO.DAO_Login;
import Modules.Menu.View.Login;
import Modules.Menu.View.Mainmenu;
import Modules.Reg_user.Controller.RuserController;
import Modules.Reg_user.Model.BLL.BLL_ruser;
import Modules.Reg_user.Model.Classes.Singleton_ruser;
import Modules.Reg_user.View.Modify_ruser;
import Modules.Reg_user.View.Pager_ruser;
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
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author antonio
 */
public class MenuController implements ActionListener, MouseListener, KeyListener,FocusListener, WindowListener, PropertyChangeListener{

    public static Mainmenu main;
    public static Config conf;
    public static Login login;
    public static Modify_client mod_cli;
    public static Modify_ruser mod_rus;
    private JPanel panel;
    
    /**
     * Disconnect from Mongo DB and exits the application with status 0
     */
    public void Exit(){
        Mongo_DB.disconnect();
        System.exit(0);
        
    }
    
    public MenuController(JFrame frame, int i){
        switch(i){
            case 0:
                main=(Mainmenu) frame;
                break;
                
            case 1:
                conf=(Config)frame;
                break;
                
            case 2:
                login=(Login)frame;
                break;
                
            case 3:
                mod_cli=(Modify_client)frame;
                break;
                
            case 4:
                mod_rus=(Modify_ruser)frame;
                break;
        }
                
    }

        
    /**
     * 
     */
    public enum Action{
        
        //Main menu buttons
        mainMenu,
        btnAdmin,
        btnClient,
        btnReguser,
        btnConfig,
        btnExit,
        
        //Configuration buttons
        configMenu,
        btnSaveConf,
        btnResetConf,
        btnCancelConf,
        
        //Login buttons
        loginMenu,
        fieldId,
        fieldPass,
        showPass,
        btnOkLogin,
        btnResetLogin,
        btnCancelLogin,
        
        //Edit Client
        clientWindow,
        clientfieldName,
        clientfieldSurname,
        clientfieldEmail,
        clientfieldMobile,
        clientfieldUser,
        clientfieldPassword,
        clientfieldVerify,
        clientbtnSearch,
        clientfieldShopping,
        clientfieldClientType,
        clientbtnSave,
        clientbtnCancel,
        
        //Edit Reg user
        ruserWindow,
        ruserfieldName,
        ruserfieldSurname,
        ruserfieldEmail,
        ruserfieldMobile,
        ruserfieldUser,
        ruserfieldPassword,
        ruserfieldVerify,
        ruserbtnSearch,
        ruserfieldActivity,
        ruserbtnSave,
        ruserbtnCancel,
        
    }
    
    /**
     * 
     * @param i  0 for main menu, 1 for config menu
     */
    public void Init(int i){
        
        switch(i){
            
            case 0:
                int mx=700;
                int my=460;
                main.back.setSize(mx, my);
                Image mback=Singleton_menus.mainback.getImage();
                main.back.setIcon(new ImageIcon(mback.getScaledInstance(mx, my, java.awt.Image.SCALE_SMOOTH)));
                theme_class.selectedtheme(Config_class.getinstance().getTheme());
                SwingUtilities.updateComponentTreeUI(main);
                main.setTitle("Main Menu");
                
                //Translations:
                main.setTitle(Singleton_app.lang.getProperty("mm_title"));
                main.btnAdmin.setText(Singleton_app.lang.getProperty("mm_admin"));
                main.btnAdmin.setToolTipText(Singleton_app.lang.getProperty("mm_admint"));
                main.btnClient.setText(Singleton_app.lang.getProperty("mm_client"));
                main.btnClient.setToolTipText(Singleton_app.lang.getProperty("mm_clientt"));
                main.btnReguser.setText(Singleton_app.lang.getProperty("mm_ruser"));
                main.btnReguser.setToolTipText(Singleton_app.lang.getProperty("mm_rusert"));
                main.btnConfig.setToolTipText(Singleton_app.lang.getProperty("mm_conft"));
                main.btnExit.setText(Singleton_app.lang.getProperty("mm_exit"));
                main.btnExit.setToolTipText(Singleton_app.lang.getProperty("mm_exitt"));
                
                //Actions:
                main.setName("mainMenu");
                main.addWindowListener(this);
                main.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                main.setLocationRelativeTo(null);
                
                main.setResizable(false);
                main.setSize(mx,my);
                main.setVisible(true);
                               
                main.btnAdmin.setName("btnAdmin");
                main.btnAdmin.addMouseListener(this);
                main.btnClient.setName("btnClient");
                main.btnClient.addMouseListener(this);
                main.btnReguser.setName("btnReguser");
                main.btnReguser.addMouseListener(this);
                main.btnConfig.setName("btnConfig");
                main.btnConfig.addMouseListener(this);
                main.btnExit.setName("btnExit");
                main.btnExit.addMouseListener(this);
                
                break;
            case 1:
                int cx=400;
                int cy=450;
                conf.back.setSize(cx,cy);
                Image confback=Singleton_menus.configback.getImage();
                conf.back.setIcon(new ImageIcon (confback.getScaledInstance(cx, cy,java.awt.Image.SCALE_SMOOTH)));
                theme_class.selectedtheme(Config_class.getinstance().getTheme());
                SwingUtilities.updateComponentTreeUI(this.conf);
                conf.setTitle("Configuration");
                
                //Translation:
                conf.labelDateform.setText(Singleton_app.lang.getProperty("co_dateform"));
                conf.labelCurrency.setText(Singleton_app.lang.getProperty("co_currency"));
                conf.labelLanguage.setText(Singleton_app.lang.getProperty("co_language"));
                conf.labelFileform.setText(Singleton_app.lang.getProperty("co_fileform"));
                conf.labelTheme.setText(Singleton_app.lang.getProperty("co_theme"));
                conf.labelDecimals.setText(Singleton_app.lang.getProperty("co_decformat"));
                conf.comboDateform.setToolTipText(Singleton_app.lang.getProperty("co_datetool"));
                conf.comboCurrency.setToolTipText(Singleton_app.lang.getProperty("co_currtool"));
                conf.comboLanguage.setToolTipText(Singleton_app.lang.getProperty("co_langtool"));
                conf.comboFileform.setToolTipText(Singleton_app.lang.getProperty("co_filetool"));
                conf.comboTheme.setToolTipText(Singleton_app.lang.getProperty("co_themetool"));
                conf.comboDecimals.setToolTipText(Singleton_app.lang.getProperty("co_dectool"));
                
                conf.comboLanguage.removeAllItems();
                conf.comboLanguage.addItem(Singleton_app.lang.getProperty("co_langenglish"));
                conf.comboLanguage.addItem(Singleton_app.lang.getProperty("co_langspanish"));
                conf.comboLanguage.addItem(Singleton_app.lang.getProperty("co_langvalencian"));
                
                conf.comboCurrency.removeAllItems();
                conf.comboCurrency.addItem(Singleton_app.lang.getProperty("co_cureuro"));
                conf.comboCurrency.addItem(Singleton_app.lang.getProperty("co_curdollar"));
                conf.comboCurrency.addItem(Singleton_app.lang.getProperty("co_curpound"));
                
                conf.comboDecimals.removeAllItems();
                conf.comboDecimals.addItem(Singleton_app.lang.getProperty("co_1decimal"));
                conf.comboDecimals.addItem(Singleton_app.lang.getProperty("co_2deciaml"));
                conf.comboDecimals.addItem(Singleton_app.lang.getProperty("co_3deciaml"));
                
                conf.btnSaveConf.setText(Singleton_app.lang.getProperty("w_save"));
                conf.btnSaveConf.setToolTipText(Singleton_app.lang.getProperty("co_savetool"));
                conf.btnResetConf.setText(Singleton_app.lang.getProperty("w_Reset"));
                conf.btnResetConf.setToolTipText(Singleton_app.lang.getProperty("co_resetool"));
                conf.btnCancelConf.setText(Singleton_app.lang.getProperty("w_Cancel"));
                conf.btnCancelConf.setToolTipText(Singleton_app.lang.getProperty("co_cancel"));
                
                conf.setName("configMenu");
                conf.addWindowListener(this);
                conf.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                
                conf.setResizable(false);
                conf.setSize(cx, cy);
                conf.setLocationRelativeTo(null);
                conf.setVisible(true);
                BLL_Config.load();
                
                conf.btnSaveConf.setName("btnSaveConf");
                conf.btnSaveConf.addMouseListener(this);
                conf.btnResetConf.setName("btnResetConf");
                conf.btnResetConf.addMouseListener(this);
                conf.btnCancelConf.setName("btnCancelConf");
                conf.btnCancelConf.addMouseListener(this);
                
                break;//End of case 1
                
            case 2:
                int lx=400;
                int ly=300;
//                login.back.setSize(lx,ly);
//                Image logback=Singleton_menus.loginback.getImage();
//                login.back.setIcon(new ImageIcon (logback.getScaledInstance(lx, ly,java.awt.Image.SCALE_SMOOTH)));

                login.setTitle("Login");
                
                login.setName("loginMenu");
                login.addWindowListener(this);
                login.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                login.setLocationRelativeTo(null);
                
                login.labelId.setText(Singleton_app.lang.getProperty("idcard"));
                login.labelPass.setText(Singleton_app.lang.getProperty("u_password"));
                login.showPass.setText(Singleton_app.lang.getProperty("log_showpass"));
                
                login.setResizable(false);
                login.setSize(lx,ly);
                login.setVisible(true);
                
                login.fieldId.setName("fieldId");
                login.fieldId.setActionCommand("fieldId");
                login.fieldId.addKeyListener(this);
                login.fieldPass.setName("fieldPass");
                login.fieldPass.setActionCommand("fieldPass");
                login.fieldPass.addKeyListener(this);
                login.fieldPass.setEchoChar('*');
                login.showPass.setName("showPass");
                login.showPass.addMouseListener(this);
                
                login.btnOk.setName("btnOkLogin");
                login.btnOk.setActionCommand("btnOkLogin");
                login.btnOk.addKeyListener(this);
                
                login.btnOk.addMouseListener(this);
                login.btnReset.setName("btnResetLogin");
                login.btnReset.addMouseListener(this);
                login.btnReset.addKeyListener(this);
                
                login.btnCancel.setName("btnCancelLogin");
                login.btnCancel.addMouseListener(this);
                login.btnCancel.addKeyListener(this);
                
                break;
                
            case 3://Modify client
                int clix=650;
                int cliy=500;
                mod_cli.back.setSize(clix,cliy);
                Image edcliback=Singleton_client.backCrMo.getImage();
                mod_cli.back.setIcon(new ImageIcon(edcliback.getScaledInstance(clix, cliy, java.awt.Image.SCALE_SMOOTH)));
                Singleton_client.window="modify";
                mod_cli.saving.setVisible(false);
                
                BLL_client.fill_client(Singleton_menus.cli.getDni(),1);
                mod_cli.fieldDNI.setEditable(false);
                mod_cli.setResizable(false);
                mod_cli.setSize(clix,cliy);
                mod_cli.editdateBirth.setDateFormatString(Config_class.getinstance().getDate_format());
                mod_cli.editdateRegistration.setDateFormatString(Config_class.getinstance().getDate_format());
                mod_cli.editdateBirth.getDateEditor().setEnabled(false);
                mod_cli.editdateRegistration.getDateEditor().setEnabled(false);
                mod_cli.setLocationRelativeTo(null);
                mod_cli.editfieldShopping.setEditable(false);
                mod_cli.radioPremiumNo.setEnabled(false);
                mod_cli.radioPremiumYes.setEnabled(false);
                mod_cli.editdateRegistration.setEnabled(false);
                mod_cli.setVisible(true);

                //Translation:
                mod_cli.setTitle(Singleton_app.lang.getProperty("c_wedit"));
                mod_cli.labelDNI.setText(Singleton_app.lang.getProperty("u_idcard"));
                mod_cli.labelName.setText(Singleton_app.lang.getProperty("u_name"));
                mod_cli.labelSurname.setText(Singleton_app.lang.getProperty("u_surname"));
                mod_cli.labelMobile.setText(Singleton_app.lang.getProperty("u_mobile"));
                mod_cli.labelUser.setText(Singleton_app.lang.getProperty("u_user"));
                mod_cli.labelPassword.setText(Singleton_app.lang.getProperty("u_password"));
                mod_cli.labelPassword2.setText(Singleton_app.lang.getProperty("u_verify"));
                mod_cli.labelShopping.setText(Singleton_app.lang.getProperty("c_shopping"));
                mod_cli.labeldateBith.setText(Singleton_app.lang.getProperty("u_birthday"));
                mod_cli.labelState.setText(Singleton_app.lang.getProperty("u_state"));
                mod_cli.radioStateYes.setText(Singleton_app.lang.getProperty("booleanyes"));
                mod_cli.radioStateNo.setText(Singleton_app.lang.getProperty("booleanno"));
                mod_cli.labeldateReg.setText(Singleton_app.lang.getProperty("c_regdate"));
                mod_cli.labelClientType.setText(Singleton_app.lang.getProperty("c_clitype"));
                mod_cli.labelPremium.setText(Singleton_app.lang.getProperty("c_premium"));
                mod_cli.radioPremiumYes.setText(Singleton_app.lang.getProperty("booleanyes"));
                mod_cli.radioPremiumNo.setText(Singleton_app.lang.getProperty("booleanno"));
                
                mod_cli.btnsaveEditclient.setText(Singleton_app.lang.getProperty("w_save"));
                mod_cli.btncancelEditclient.setText(Singleton_app.lang.getProperty("exit"));
                mod_cli.btnSearch.setText(Singleton_app.lang.getProperty("w_search"));
                
                //Actions:
                mod_cli.setName("clientWindow");
                mod_cli.addWindowListener(this);
                mod_cli.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                        
                mod_cli.editfieldName.setActionCommand("clientfieldName");
                mod_cli.editfieldName.setName("clientfieldName");
                mod_cli.editfieldName.addFocusListener(this);
                mod_cli.editfieldName.addActionListener(this);
                mod_cli.editfieldName.addKeyListener(this);
                
                mod_cli.editfieldSurname.setActionCommand("clientfieldSurname");
                mod_cli.editfieldSurname.setName("clientfieldSurname");
                mod_cli.editfieldSurname.addFocusListener(this);
                mod_cli.editfieldSurname.addActionListener(this);
                mod_cli.editfieldSurname.addKeyListener(this);
                
                mod_cli.editfieldEmail.setActionCommand("clientfieldEmail");
                mod_cli.editfieldEmail.setName("clientfieldEmail");
                mod_cli.editfieldEmail.addFocusListener(this);
                mod_cli.editfieldEmail.addActionListener(this);
                mod_cli.editfieldEmail.addKeyListener(this);
                
                mod_cli.editfieldMobile.setActionCommand("clientfieldMobile");
                mod_cli.editfieldMobile.setName("clientfieldMobile");
                mod_cli.editfieldMobile.addFocusListener(this);
                mod_cli.editfieldMobile.addActionListener(this);
                mod_cli.editfieldMobile.addKeyListener(this);
                
                mod_cli.editfieldUser.setActionCommand("clientfieldUser");
                mod_cli.editfieldUser.setName("clientfieldUser");
                mod_cli.editfieldUser.addFocusListener(this);
                mod_cli.editfieldUser.addActionListener(this);
                mod_cli.editfieldUser.addKeyListener(this);
                
                mod_cli.editfieldPassword.setActionCommand("clientfieldPassword");
                mod_cli.editfieldPassword.setName("clientfieldPassword");
                mod_cli.editfieldPassword.addFocusListener(this);
                mod_cli.editfieldPassword.addActionListener(this);
                mod_cli.editfieldPassword.addKeyListener(this);
                
                mod_cli.editfieldPassword2.setActionCommand("clientfieldVerify");
                mod_cli.editfieldPassword2.setName("clientfieldVerify");
                mod_cli.editfieldPassword2.addFocusListener(this);
                mod_cli.editfieldPassword2.addActionListener(this);
                mod_cli.editfieldPassword2.addKeyListener(this);
                
                mod_cli.editdateBirth.addPropertyChangeListener(this);
                
                mod_cli.btnSearch.setName("clientbtnSearch");
                mod_cli.btnSearch.addMouseListener(this);
                
//                mod_cli.editdateRegistration.addPropertyChangeListener(this);
                
//                mod_cli.editfieldShopping.setActionCommand("clientfieldShopping");
//                mod_cli.editfieldShopping.setName("clientfieldShopping");
//                mod_cli.editfieldShopping.addFocusListener(this);
//                mod_cli.editfieldShopping.addActionListener(this);
//                mod_cli.editfieldShopping.addKeyListener(this);
                
                mod_cli.editfieldClientType.setActionCommand("clientfieldClientType");
                mod_cli.editfieldClientType.setName("clientfieldClientType");
                mod_cli.editfieldClientType.addFocusListener(this);
                mod_cli.editfieldClientType.addActionListener(this);
                mod_cli.editfieldClientType.addKeyListener(this);
                
                mod_cli.btnsaveEditclient.setName("clientbtnSave");
                mod_cli.btnsaveEditclient.addMouseListener(this);
                
                mod_cli.btncancelEditclient.setName("clientbtnCancel");
                mod_cli.btncancelEditclient.addMouseListener(this);
                break;//End case modify client
                
            case 4://Modify reg user
                int rusx=650;
                int rusy=500;
                mod_rus.back.setSize(rusx,rusy);
                Image edrusback=Singleton_ruser.backCrMo.getImage();
                mod_rus.back.setIcon(new ImageIcon(edrusback.getScaledInstance(rusx, rusy, java.awt.Image.SCALE_SMOOTH)));
//                Singleton_ruser.window="modify";
                mod_rus.saving.setVisible(false);
                BLL_ruser.fill_ruser(Singleton_menus.rus.getDni());
                mod_rus.fieldDNI.setEditable(false);
                mod_rus.setResizable(false);
                mod_rus.setSize(rusx,rusy);
                mod_rus.editdateBirth.setDateFormatString(Config_class.getinstance().getDate_format());
                mod_rus.editdateBirth.getDateEditor().setEnabled(false);
                mod_rus.editfieldActivity.setEditable(false);
                mod_rus.setLocationRelativeTo(null);
                mod_rus.setVisible(true);

                //Translation:
                mod_rus.setTitle(Singleton_app.lang.getProperty("r_wedit"));
                mod_rus.labelDNI.setText(Singleton_app.lang.getProperty("u_idcard"));
                mod_rus.labelName.setText(Singleton_app.lang.getProperty("u_name"));
                mod_rus.labelSurname.setText(Singleton_app.lang.getProperty("u_surname"));
                mod_rus.labelMobile.setText(Singleton_app.lang.getProperty("u_mobile"));
                mod_rus.labelUser.setText(Singleton_app.lang.getProperty("u_user"));
                mod_rus.labelPassword.setText(Singleton_app.lang.getProperty("u_password"));
                mod_rus.labelPassword2.setText(Singleton_app.lang.getProperty("u_verify"));
                mod_rus.labeldateBirth.setText(Singleton_app.lang.getProperty("u_birthday"));
                mod_rus.labelState.setText(Singleton_app.lang.getProperty("u_state"));
                mod_rus.radioStateYes.setText(Singleton_app.lang.getProperty("booleanyes"));
                mod_rus.radioStateNo.setText(Singleton_app.lang.getProperty("booleanno"));
                mod_rus.labelActivity.setText(Singleton_app.lang.getProperty("r_activity"));
                
                mod_rus.btnsaveEditruser.setText(Singleton_app.lang.getProperty("w_save"));
                mod_rus.btncancelEditruser.setText(Singleton_app.lang.getProperty("exit"));
                mod_rus.btnSearch.setText(Singleton_app.lang.getProperty("w_search"));
                
                //Action:
                mod_rus.setName("ruserWindow");
                mod_rus.addWindowListener(this);
                mod_rus.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                        
                mod_rus.editfieldName.setActionCommand("ruserfieldName");
                mod_rus.editfieldName.setName("ruserfieldName");
                mod_rus.editfieldName.addFocusListener(this);
                mod_rus.editfieldName.addActionListener(this);
                mod_rus.editfieldName.addKeyListener(this);
                
                mod_rus.editfieldSurname.setActionCommand("ruserfieldSurname");
                mod_rus.editfieldSurname.setName("ruserfieldSurname");
                mod_rus.editfieldSurname.addFocusListener(this);
                mod_rus.editfieldSurname.addActionListener(this);
                mod_rus.editfieldSurname.addKeyListener(this);
                
                mod_rus.editfieldEmail.setActionCommand("ruserfieldEmail");
                mod_rus.editfieldEmail.setName("ruserfieldEmail");
                mod_rus.editfieldEmail.addFocusListener(this);
                mod_rus.editfieldEmail.addActionListener(this);
                mod_rus.editfieldEmail.addKeyListener(this);
                
                mod_rus.editfieldMobile.setActionCommand("ruserfieldMobile");
                mod_rus.editfieldMobile.setName("ruserfieldMobile");
                mod_rus.editfieldMobile.addFocusListener(this);
                mod_rus.editfieldMobile.addActionListener(this);
                mod_rus.editfieldMobile.addKeyListener(this);
                
                mod_rus.editfieldUser.setActionCommand("ruserfieldUser");
                mod_rus.editfieldUser.setName("ruserfieldUser");
                mod_rus.editfieldUser.addFocusListener(this);
                mod_rus.editfieldUser.addActionListener(this);
                mod_rus.editfieldUser.addKeyListener(this);
                
                mod_rus.editfieldPassword.setActionCommand("ruserfieldPassword");
                mod_rus.editfieldPassword.setName("ruserfieldPassword");
                mod_rus.editfieldPassword.addFocusListener(this);
                mod_rus.editfieldPassword.addActionListener(this);
                mod_rus.editfieldPassword.addKeyListener(this);
                
                mod_rus.editfieldPassword2.setActionCommand("ruserfieldVerify");
                mod_rus.editfieldPassword2.setName("ruserfieldVerify");
                mod_rus.editfieldPassword2.addFocusListener(this);
                mod_rus.editfieldPassword2.addActionListener(this);
                mod_rus.editfieldPassword2.addKeyListener(this);
                
                mod_rus.editdateBirth.addPropertyChangeListener(this);
                
                mod_rus.btnSearch.setName("ruserbtnSearch");
                mod_rus.btnSearch.addMouseListener(this);
                
//                mod_rus.editfieldActivity.setActionCommand("ruserfieldActivity");
//                mod_rus.editfieldActivity.setName("ruserfieldActivity");
//                mod_rus.editfieldActivity.addFocusListener(this);
//                mod_rus.editfieldActivity.addActionListener(this);
//                mod_rus.editfieldActivity.addKeyListener(this);

                mod_rus.btnsaveEditruser.setName("ruserbtnSave");
                mod_rus.btnsaveEditruser.addMouseListener(this);
                
                mod_rus.btncancelEditruser.setName("ruserbtnCancel");
                mod_rus.btncancelEditruser.addMouseListener(this);
                break;
                
        }//End of switch case Init
        
    }//End of init
    
    @Override
    public void actionPerformed(ActionEvent ae){
//        System.out.println(ae.getActionCommand());
        switch (Action.valueOf(ae.getActionCommand())){
            
            case btnOkLogin:
                BLL_Login.Try_Login();
                break;
        }//End of switch case actionPerformed
        
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
       switch (Action.valueOf(e.getComponent().getName())){
           
           case btnAdmin:
                    main.dispose();
                    new AdminController(new Pager_admin(),2).Init(2);
                break;
                
                case btnClient:
                    main.dispose();
                    new ClientController(new Pager_client(),2).Init(2);
                break;
                
                case btnReguser:
                    main.dispose();
                    new RuserController(new Pager_ruser(),2).Init(2);
                break;
                
                case btnConfig:
                    main.dispose(); 
                    new MenuController(new Config(), 1).Init(1);
               break;
               
               case btnExit:
                    JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("mm_leave"),"Info",JOptionPane.INFORMATION_MESSAGE);
                    main.dispose();
                    Exit();
                break;
                
                case btnSaveConf:
                    BLL_Config.save();
                    conf.dispose();
                    new MenuController(new Mainmenu(), 0).Init(0);
                break;
                
                case btnResetConf:
                    BLL_Config.reset();
                break;
                
                case btnCancelConf:
                    conf.dispose();
                    new MenuController(new Mainmenu(), 0).Init(0);
                break;
                
                case showPass:
                    BLL_Login.askUserdata("showpassword");
                    break;
                
                case btnOkLogin:
                    BLL_Login.Try_Login();
                    break;
                
                case btnResetLogin:
                    BLL_Login.askUserdata("reset");
                    break;
                    
                case btnCancelLogin:
                    JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("mm_leave"),"Info",JOptionPane.INFORMATION_MESSAGE);
                    login.dispose();
                    Exit();
                    break;
                    
                case clientbtnSave:
                    
                    break;
                    
                case clientbtnCancel:
                    JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("mm_leave"),"Info",JOptionPane.INFORMATION_MESSAGE);
                    mod_cli.dispose();
                    Exit();
                    break;
                    
                case ruserbtnSave:
                    
                    break;
                    
                case ruserbtnCancel:
                    JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("mm_leave"),"Info",JOptionPane.INFORMATION_MESSAGE);
                    mod_rus.dispose();
                    Exit();
                    break;
       }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
        switch (Action.valueOf(e.getComponent().getName())){
               
         }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch (Action.valueOf(e.getComponent().getName())){
               
         }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        switch (Action.valueOf(e.getComponent().getName())){
            
            case btnAdmin:
                main.btnAdmin.setIcon(adminicon_over);
                break;
            
            case btnClient:
                main.btnClient.setIcon(clienticon_over);
                break;
                
            case btnReguser:
                main.btnReguser.setIcon(rusericon_over);
                break;
                
            case btnConfig:
                main.btnConfig.setIcon(configicon_over);
            break;
    }
    }

    @Override
    public void mouseExited(MouseEvent e) {
         switch (Action.valueOf(e.getComponent().getName())){
            
            case btnAdmin:
                main.btnAdmin.setIcon(adminicon);
                break;
            
            case btnClient:
                main.btnClient.setIcon(clienticon);
                break;
                
            case btnReguser:
                main.btnReguser.setIcon(rusericon);
                break;
                
            case btnConfig:
                main.btnConfig.setIcon(configicon);
            break;
    }
    }
    
    
        @Override
    public void keyTyped(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println(e.getComponent().getName());
//        System.out.println(e.getKeyCode());
        switch (Action.valueOf(e.getComponent().getName())) {
            
            case fieldId:
                BLL_Login.askUserdata("dni");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    login.fieldPass.requestFocus();
                }
                break;
        
            case fieldPass:
                BLL_Login.askUserdata("password");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    login.btnOk.requestFocus();
                }
                break;
                
            case btnOkLogin:
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    BLL_Login.Try_Login();
                }
                break;
                
            case btnResetLogin:
                    BLL_Login.askUserdata("reset");
                    break;
                    
            case btnCancelLogin:
                    JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("mm_leave"),"Info",JOptionPane.INFORMATION_MESSAGE);
                    login.dispose();
                    Exit();
                    break;
                
           //Client Window
                
            case clientfieldName:
                BLL_client.modClientdata("name");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    mod_cli.editfieldSurname.requestFocus();
	}
                break;
                
            case clientfieldSurname:
                BLL_client.modClientdata("surname");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    mod_cli.editfieldEmail.requestFocus();
	}
                break;
                
            case clientfieldEmail:
                BLL_client.modClientdata("email");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    mod_cli.editfieldMobile.requestFocus();
	}
                break;
                
            case clientfieldMobile:
                BLL_client.modClientdata("mobile");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    mod_cli.editfieldUser.requestFocus();
	}
                break;
                
            case clientfieldUser:
                BLL_client.modClientdata("user");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    mod_cli.editfieldPassword.requestFocus();
	}
                break;
                
            case clientfieldPassword:
                BLL_client.modClientdata("password");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    mod_cli.editfieldPassword2.requestFocus();
	}
                break;
                
            case clientfieldVerify:
                BLL_client.modClientdata("password2");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    mod_cli.editfieldShopping.requestFocus();
	}
                break;
                
            case clientfieldShopping:
                BLL_client.modClientdata("shopping");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    mod_cli.editfieldClientType.requestFocus();
	}
                break;
                
            case clientfieldClientType:
                BLL_client.modClientdata("clienttype");
                break;
                
                //Registered user window:
            case ruserfieldName:
                BLL_ruser.modRuserdata("name");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    mod_rus.editfieldSurname.requestFocus();
	}
                break;
                
            case ruserfieldSurname:
                BLL_ruser.modRuserdata("surname");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    mod_rus.editfieldEmail.requestFocus();
	}
                break;
                
            case ruserfieldEmail:
                BLL_ruser.modRuserdata("email");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    mod_rus.editfieldMobile.requestFocus();
	}
                break;
                
            case ruserfieldMobile:
                BLL_ruser.modRuserdata("mobile");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    mod_rus.editfieldUser.requestFocus();
	}
                break;
                
            case ruserfieldUser:
                BLL_ruser.modRuserdata("user");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    mod_rus.editfieldPassword.requestFocus();
	}
                break;
                
            case ruserfieldPassword:
                BLL_ruser.modRuserdata("password");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    mod_rus.editfieldPassword2.requestFocus();
	}
                break;
                
            case ruserfieldVerify:
                BLL_ruser.modRuserdata("password2");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    mod_rus.editfieldActivity.requestFocus();
	}
                break;
                
            case ruserfieldActivity:
//                BLL_ruser.modRuserdata("activity");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (Action.valueOf(e.getComponent().getName())) {
            
            case fieldId:
                BLL_Login.askUserdata("dni");
                break;
                
            case fieldPass:
                BLL_Login.askUserdata("password");
                break;
        
           //Client Window
                
            case clientfieldName:
                BLL_client.modClientdata("name");
                break;
                
            case clientfieldSurname:
                BLL_client.modClientdata("surname");
                break;
                
            case clientfieldEmail:
                BLL_client.modClientdata("email");
                break;
                
            case clientfieldMobile:
                BLL_client.modClientdata("mobile");
                break;
                
            case clientfieldUser:
                BLL_client.modClientdata("user");
                break;
                
            case clientfieldPassword:
                BLL_client.modClientdata("password");
                break;
                
            case clientfieldVerify:
                BLL_client.modClientdata("password2");
                break;
                
            case clientfieldShopping:
                BLL_client.modClientdata("shopping");
                break;
                
            case clientfieldClientType:
                BLL_client.modClientdata("clienttype");
                break;
                
                //Registered user Window:
            case ruserfieldName:
                BLL_ruser.modRuserdata("name");
                break;
                
            case ruserfieldSurname:
                BLL_ruser.modRuserdata("surname");
                break;
                
            case ruserfieldEmail:
                BLL_ruser.modRuserdata("email");
                break;
                
            case ruserfieldMobile:
                BLL_ruser.modRuserdata("mobile");
                break;
                
            case ruserfieldUser:
                BLL_ruser.modRuserdata("user");
                break;
                
            case ruserfieldPassword:
                BLL_ruser.modRuserdata("password");
                break;
                
            case ruserfieldVerify:
                BLL_ruser.modRuserdata("password2");
                break;
                
            case ruserfieldActivity:
//                BLL_ruser.modRuserdata("activity");
                break;
        }
    }
    
    
        @Override
    public void windowOpened(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
        @Override
    public void focusGained(FocusEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void focusLost(FocusEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void windowClosing(WindowEvent e) {
        switch(MenuController.Action.valueOf(e.getComponent().getName())){
            
            case mainMenu:
                JOptionPane.showMessageDialog(null, Singleton_app.lang.getProperty("mm_leave"),"Info",JOptionPane.INFORMATION_MESSAGE);
                Exit();
                break;
                
            case configMenu:
                conf.dispose();
                new MenuController(new Mainmenu(),0).Init(0);
                break;
                
            case loginMenu:
                JOptionPane.showMessageDialog(null, Singleton_app.lang.getProperty("mm_leave"),"Info",JOptionPane.INFORMATION_MESSAGE);
                Exit();
                break;
                
            case clientWindow:
                JOptionPane.showMessageDialog(null, Singleton_app.lang.getProperty("mm_leave"),"Info",JOptionPane.INFORMATION_MESSAGE);
                mod_cli.dispose();
                Exit();
                break;
                
            case ruserWindow:
                JOptionPane.showMessageDialog(null, Singleton_app.lang.getProperty("mm_leave"),"Info",JOptionPane.INFORMATION_MESSAGE);
                mod_rus.dispose();
                Exit();
                break;
        }
    }

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
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
