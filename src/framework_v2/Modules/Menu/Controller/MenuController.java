/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework_v2.Modules.Menu.Controller;

import framework_v2.Modules.Config.View.Config;
import static framework_v2.Modules.Menu.Controller.MenuController.Action.btnAdmin;
import framework_v2.Modules.Menu.View.Mainmenu;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author antonio
 */
public class MenuController implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static Mainmenu main = new Mainmenu();
    public static Config conf= new Config();
    
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
    
    public enum Action{
        
        //Main menu buttons
        btnAdmin,
        btnClient,
        btnReguser,
        btnConfig,
        btnExit,
        
        //Configuration buttons
        btnSave,
        btnReturn
    }
    
    public void Init(int i){
        
        switch(i){
            
            case 0:
                
                ImageIcon icon = new ImageIcon("src/framework_v2/Modules/Menu/View/img/back.jpg");
                Image img=icon.getImage();
                Image newimg = img.getScaledInstance(700, 460, java.awt.Image.SCALE_SMOOTH);
        
                
                main.setVisible(true);
                main.setLocationRelativeTo(null);
                main.setTitle("Main Menu");
                main.setContentPane(new JLabel(new ImageIcon (newimg)));
                
                main.btnAdmin.setActionCommand("btnAdmin");
                main.btnAdmin.addActionListener(this);
                main.btnClient.setActionCommand("btnClient");
                main.btnClient.addActionListener(this);
                main.btnReguser.setActionCommand("btnReguser");
                main.btnReguser.addActionListener(this);
                main.btnConfig.setActionCommand("btnConfig");
                main.btnConfig.addActionListener(this);
                
                this.main.addWindowListener(new WindowAdapter(){
                    public void windowClosing(WindowEvent e){
                        JOptionPane.showMessageDialog(null, "Leaving the aplication...","Leaving",JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                });
                
                break;
            case 1:
                
                break;
                
        }//End of switch case
        
    }
}
