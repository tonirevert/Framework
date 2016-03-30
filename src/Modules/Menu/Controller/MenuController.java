/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules.Menu.Controller;

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
import Modules.Admin.Model.BLL.BLL_admin;
import Modules.Admin.View.Pager_admin;
import Modules.Client.Controller.ClientController;
import Modules.Client.Model.BLL.BLL_client;
import Modules.Client.View.Pager_client;
import Modules.Config.BLL.BLL_Config;
import Modules.Config.Classes.Config_class;
import Modules.Config.Classes.theme_class;
import Modules.Config.View.Config;
import Modules.Menu.Classes.Singleton_menus;
import static Modules.Menu.Controller.MenuController.Action.btnAdmin;
import static Modules.Menu.Controller.MenuController.Action.btnConfig;
import static Modules.Menu.Controller.MenuController.main;
import Modules.Menu.View.Mainmenu;
import Modules.Reg_user.Controller.RuserController;
import Modules.Reg_user.View.Pager_ruser;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author antonio
 */
public class MenuController implements ActionListener, MouseListener, WindowListener{

    public static Mainmenu main;// = new Mainmenu();
    public static Config conf;//= new Config();
    private JPanel panel;
    
    public MenuController(JFrame frame, int i){
        switch(i){
            case 0:
                main=(Mainmenu) frame;
                break;
                
            case 1:
                conf=(Config)frame;
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
        btnCancelConf
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
                
                conf.btnSaveConf.setText(Singleton_app.lang.getProperty("w_save"));
                conf.btnResetConf.setText(Singleton_app.lang.getProperty("w_Reset"));
                conf.btnCancelConf.setText(Singleton_app.lang.getProperty("w_Cancel"));
                
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
                
                break;
                
        }//End of switch case Init
        
    }//End of init
    
    @Override
    public void actionPerformed(ActionEvent ae){
        
        switch (Action.valueOf(ae.getActionCommand())){
            
          
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
                    BLL_admin.autosaveAdmin();
                    BLL_client.autosaveClient();
                    JOptionPane.showMessageDialog(null,Singleton_app.lang.getProperty("mm_leave"),"Info",JOptionPane.INFORMATION_MESSAGE);
                    main.dispose();
                    System.exit(0);
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
    public void windowOpened(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent e) {
        switch(MenuController.Action.valueOf(e.getComponent().getName())){
            
            case mainMenu:
                JOptionPane.showMessageDialog(null, Singleton_app.lang.getProperty("mm_leave"),"Info",JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
                break;
                
            case configMenu:
                conf.dispose();
                new MenuController(new Mainmenu(),0).Init(0);
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
    
}
