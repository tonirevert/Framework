/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework_v2.Modules.Menu.Controller;

import static framework_v2.Classes.Singleton_menus.adminicon;
import static framework_v2.Classes.Singleton_menus.adminicon_over;
import static framework_v2.Classes.Singleton_menus.clienticon;
import static framework_v2.Classes.Singleton_menus.clienticon_over;
import static framework_v2.Classes.Singleton_menus.configicon;
import static framework_v2.Classes.Singleton_menus.configicon_over;
import static framework_v2.Classes.Singleton_menus.rusericon;
import static framework_v2.Classes.Singleton_menus.rusericon_over;
import framework_v2.Modules.Admin.Controller.AdminController;
import framework_v2.Modules.Admin.Model.BLL.BLL_admin;
import framework_v2.Modules.Admin.View.Pager_admin;
import framework_v2.Modules.Client.Controller.ClientController;
import framework_v2.Modules.Client.Model.BLL.BLL_client;
import framework_v2.Modules.Client.View.Pager_client;
import framework_v2.Modules.Config.BLL.BLL_Config;
import framework_v2.Modules.Config.Classes.Config_class;
import framework_v2.Modules.Config.Classes.theme_class;
import framework_v2.Modules.Config.View.Config;
import static framework_v2.Modules.Menu.Controller.MenuController.Action.btnAdmin;
import static framework_v2.Modules.Menu.Controller.MenuController.Action.btnConfig;
import static framework_v2.Modules.Menu.Controller.MenuController.main;
import framework_v2.Modules.Menu.View.Mainmenu;
import framework_v2.Modules.Reg_user.Controller.RuserController;
import framework_v2.Modules.Reg_user.View.Pager_ruser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author antonio
 */
public class MenuController implements ActionListener, MouseListener{

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
        btnAdmin,
        btnClient,
        btnReguser,
        btnConfig,
        btnExit,
        
        //Configuration buttons
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
               
                theme_class.selectedtheme(Config_class.getinstance().getTheme());
                SwingUtilities.updateComponentTreeUI(this.main);
                main.setVisible(true);
                
                main.setLocationRelativeTo(null);
                main.setTitle("Main Menu");
                main.setSize(700,460);
                               
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
                
                main.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                main.addWindowListener(new WindowAdapter(){
                    public void windowClosing(WindowEvent e){
                        JOptionPane.showMessageDialog(null, "Leaving the aplication...","Leaving",JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                });
                
                break;
            case 1:
                
                theme_class.selectedtheme(Config_class.getinstance().getTheme());
                SwingUtilities.updateComponentTreeUI(this.conf);
                
                conf.setTitle("Configuration");
                conf.setSize(400, 450);
                conf.setLocationRelativeTo(null);
                conf.setVisible(true);
                
                conf.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                conf.addWindowListener(new WindowAdapter(){
                    public void windowClosing(WindowEvent e){
                        conf.dispose();
                        new MenuController(new Mainmenu(), 0).Init(0);
                    }
                });
                
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
                    JOptionPane.showMessageDialog(null,"Leaving application...");
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
    
}
