/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework_v2.Modules.Client.Controller;

import framework_v2.Modules.Client.Model.BLL.BLL_client;
import framework_v2.Modules.Client.Model.Classes.Singleton_client;
import static framework_v2.Modules.Client.Model.Classes.Singleton_client.cl;
import static framework_v2.Modules.Client.Model.Classes.Singleton_client.defaultavatar;
import framework_v2.Modules.Client.Model.Classes.miniSimpleTableModel_client;
import framework_v2.Modules.Client.Model.Utils.pager.AutocompleteJComboBox;
import framework_v2.Modules.Client.Model.Utils.pager.StringSearchable;
import framework_v2.Modules.Client.Model.Utils.pager.pagina;
import framework_v2.Modules.Client.View.Create_client;
import framework_v2.Modules.Client.View.Modify_client;
import framework_v2.Modules.Client.View.Pager_client;
import static framework_v2.Modules.Client.View.Pager_client.jComboBox1;
import static framework_v2.Modules.Client.View.Pager_client.pagerTable;
import framework_v2.Modules.Config.Classes.Config_class;
import framework_v2.Modules.Menu.Controller.MenuController;
import framework_v2.Modules.Menu.View.Mainmenu;
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
public class ClientController implements ActionListener, KeyListener, MouseListener, FocusListener,PropertyChangeListener, WindowListener{

    public static Create_client create;
    public static Modify_client edit;
    public static Pager_client pager;
    public static TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(new miniSimpleTableModel_client());
    public static AutocompleteJComboBox combo = null;
    public String comb="";
    
    public ClientController(JFrame frame, int i){
        switch(i){
            case 0:
                create=(Create_client) frame;
                break;
                
            case 1:
                edit=(Modify_client)frame;
                break;
                
            case 2:
                pager=(Pager_client)frame;
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
        createfieldShopping,
        createfieldClientType,
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
        editfieldShopping,
        editfieldClientType,
        editfieldActivity,
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
        combo,
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
                Singleton_client.window="create";
                create.setTitle("Create Client");////////////////////////////////////////////////////////////////////////
                create.saving.setVisible(false);
                create.setResizable(false);
                create.setSize(600,500);
                create.dateBirth.setDateFormatString(Config_class.getinstance().getDate_format());
                create.dateRegistration.setDateFormatString(Config_class.getinstance().getDate_format());
                create.dateRegistration.getDateEditor().setEnabled(false);
                create.dateBirth.getDateEditor().setEnabled(false);
                create.dateRegistration.setEnabled(false);
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
                
                create.dateRegistration.addPropertyChangeListener(this);
                
                create.fieldShopping.setActionCommand("createfieldShopping");
                create.fieldShopping.setName("createfieldShopping");
                create.fieldShopping.addFocusListener(this);
                create.fieldShopping.addActionListener(this);
                create.fieldShopping.addKeyListener(this);
                
                create.fieldClientType.setActionCommand("createfieldClientType");
                create.fieldClientType.setName("createfieldClientType");
                create.fieldClientType.addFocusListener(this);
                create.fieldClientType.addActionListener(this);
                create.fieldClientType.addKeyListener(this);
                
                create.btnsaveCreateadmin.setName("createbtnSave");
                create.btnsaveCreateadmin.addMouseListener(this);

                create.btnresetCreateadmin.setName("createbtnReset");
                create.btnresetCreateadmin.addMouseListener(this);
                
                create.btncancelCreateadmin.setName("createbtnCancel");
                create.btncancelCreateadmin.addMouseListener(this);
                
                break;//End case 0
                
            case 1://Modify admin
                Singleton_client.window="modify";
                edit.setTitle("Modify Admin");////////////////////////////////////////////////////////////////////////
                edit.saving.setVisible(false);
                BLL_client.fill_client(cl.getDni());
                edit.fieldDNI.setEditable(false);
                edit.setResizable(false);
                edit.setSize(600,500);
                edit.editdateBirth.setDateFormatString(Config_class.getinstance().getDate_format());
                edit.editdateRegistration.setDateFormatString(Config_class.getinstance().getDate_format());
                edit.editdateBirth.getDateEditor().setEnabled(false);
                edit.editdateRegistration.getDateEditor().setEnabled(false);
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
                
                edit.editdateRegistration.addPropertyChangeListener(this);
                
                edit.editfieldShopping.setActionCommand("editfieldShopping");
                edit.editfieldShopping.setName("editfieldShopping");
                edit.editfieldShopping.addFocusListener(this);
                edit.editfieldShopping.addActionListener(this);
                edit.editfieldShopping.addKeyListener(this);
                
                edit.editfieldClientType.setActionCommand("editfieldClientType");
                edit.editfieldClientType.setName("editfieldClientType");
                edit.editfieldClientType.addFocusListener(this);
                edit.editfieldClientType.addActionListener(this);
                edit.editfieldClientType.addKeyListener(this);
                
                edit.btnsaveEditclient.setName("editbtnSave");
                edit.btnsaveEditclient.addMouseListener(this);
                
                edit.btncancelEditclient.setName("editbtnCancel");
                edit.btncancelEditclient.addMouseListener(this);
                break;//End case 1
                
            case 2://Pager admin
                pager.setTitle("Admin management list");
                pager.setLocationRelativeTo(null);
                pager.setResizable(false);
                pager.setVisible(true);
                
                pager.pagerTable.setModel( new miniSimpleTableModel_client() );
                ((miniSimpleTableModel_client)pagerTable.getModel()).cargar();
                pager.pagerTable.setFillsViewportHeight(true);
                pager.pagerTable.setRowSorter(sorter);
                
                pagina.inicializa();
                pagina.initLinkBox();
                
                pager.pagAmount.setText(String.valueOf(Singleton_client.cli.size()));
                
                List<String> myWords = new ArrayList<String>();
                
                for (int e=0;e<=Singleton_client.cli.size()-1;e++) {
                myWords.add(Singleton_client.cli.get(e).getName());
                }
                
                StringSearchable searchable = new StringSearchable(myWords);
                combo = new AutocompleteJComboBox(searchable);
                pager.jPanel3.setLayout(new java.awt.BorderLayout());
                pager.jPanel3.add(combo);
                               
                pager.AddClient.setToolTipText("Add a new admin user");
                pager.ModClient.setToolTipText("Modify selected admin user");
                pager.DelClient.setToolTipText("Delete selected admin user");
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
                this.combo.setToolTipText("Click to user search");
                
                pager.setName("pagerWindow");
                pager.addWindowListener(this);
                pager.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                
                pager.AddClient.setName("AddAdmin");
                pager.AddClient.addMouseListener(this);
                
                pager.ModClient.setName("ModAdmin");
                pager.ModClient.addMouseListener(this);
                
                pager.DelClient.setName("DelAdmin");
                pager.DelClient.addMouseListener(this);
                
                pager.btnsavejson.setName("btnsavejson");
                pager.btnsavejson.addMouseListener(this);
                
                pager.btnsavetxt.setName("btnsavetxt");
                pager.btnsavetxt.addMouseListener(this);
                
                pager.btnsavexml.setName("btnsavexml");
                pager.btnsavexml.addMouseListener(this);
                
                pager.pagerTable.setName("pagerTable");
                pager.pagerTable.addMouseListener(this);
                
                this.combo.setActionCommand("combo");
                this.combo.setName("combo");
                this.combo.addActionListener(this);
                
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
                BLL_client.askClientdata("dni");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    create.fieldName.requestFocus();
                }
                break;
                
            case createfieldName:
                BLL_client.askClientdata("name");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    create.fieldSurname.requestFocus();
	}
                break;
                
            case createfieldSurname:
                BLL_client.askClientdata("surname");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    create.fieldEmail.requestFocus();
	}
                break;
                
            case createfieldEmail:
                BLL_client.askClientdata("email");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    create.fieldMobile.requestFocus();
	}
                break;
                
            case createfieldMobile:
                BLL_client.askClientdata("mobile");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    create.fieldUser.requestFocus();
	}
                break;
                
            case createfieldUser:
                BLL_client.askClientdata("user");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    create.fieldPassword.requestFocus();
	}
                break;
                
            case createfieldPassword:
                BLL_client.askClientdata("password");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    create.fieldPassword2.requestFocus();
	}
                break;
                
            case createfieldVerify:
                BLL_client.askClientdata("password2");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    create.fieldActivity.requestFocus();
	}
                break;
                
            case createfieldActivity:
                BLL_admin.askAdmindata("activity");
                break;
                
                ////Events from Modify admin
            case editfieldName:
                BLL_client.modClientdata("name");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    edit.editfieldSurname.requestFocus();
	}
                break;
                
            case editfieldSurname:
                BLL_client.modClientdata("surname");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    edit.editfieldEmail.requestFocus();
	}
                break;
                
            case editfieldEmail:
                BLL_client.modClientdata("email");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    edit.editfieldMobile.requestFocus();
	}
                break;
                
            case editfieldMobile:
                BLL_client.modClientdata("mobile");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    edit.editfieldUser.requestFocus();
	}
                break;
                
            case editfieldUser:
                BLL_client.modClientdata("user");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    edit.editfieldPassword.requestFocus();
	}
                break;
                
            case editfieldPassword:
                BLL_client.modClientdata("password");
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    edit.editfieldPassword2.requestFocus();
	}
                break;
                
            case editfieldVerify:
                BLL_client.modClientdata("password2");
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
                BLL_client.askClientdata("dni");
                break;
                
            case createfieldName:
                BLL_client.askClientdata("name");
                break;
                
            case createfieldSurname:
                BLL_client.askClientdata("surname");
                break;
                
            case createfieldEmail:
                BLL_client.askClientdata("email");
                break;
            
            case createfieldMobile:
                BLL_client.askClientdata("mobile");
                break;
                
            case createfieldUser:
                BLL_client.askClientdata("user");
                break;
                
            case createfieldPassword:
                BLL_client.askClientdata("password");
                break;
                
            case createfieldVerify:
                BLL_client.askClientdata("password2");
                break;
                
            case createfieldActivity:
                BLL_client.askClientdata("activity");
                break;
                
                ////Events from Modify admin:
                
            case editfieldName:
                BLL_client.modClientdata("name");
                break;
                
            case editfieldSurname:
                BLL_client.modClientdata("surname");
                break;
                
            case editfieldEmail:
                BLL_client.modClientdata("email");
                break;
                
            case editfieldMobile:
                BLL_client.modClientdata("mobile");
                break;
                
            case editfieldUser:
                BLL_client.modClientdata("user");
                break;
                
            case editfieldPassword:
                BLL_client.modClientdata("password");
                break;
                
            case editfieldVerify:
                BLL_client.modClientdata("password2");
                break;
                
            case editfieldActivity:
                BLL_client.modClientdata("activity");
                break;
        }//End switch case keyReleased
    }//End of keyReleased
    
    @Override
    public void actionPerformed(ActionEvent e) {
//        System.out.println(e.getActionCommand());
        switch (Action.valueOf(e.getActionCommand())){
           
            case combo:
                    pagina.currentPageIndex = 1;
                    pagina.initLinkBox();
                    ((miniSimpleTableModel_client)pagerTable.getModel()).filtrar();
                    combo.requestFocus();
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
                BLL_client.askClientdata("avatar");
                break;
            
            case createbtnSave:
                if(BLL_client.create_client()==true){
                Timer delay = new Timer(3000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                            create.dispose();
                            new ClientController(new Pager_client(),2).Init(2);
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
                BLL_client.resetFields();
                break;
                
            case createbtnCancel:
                create.dispose();
                new ClientController(new Pager_client(),2).Init(2);
                break;
                
                ////Events from Modify admin:
                
            case editbtnSearch:
                BLL_client.modClientdata("avatar");
                break;
                
            case editbtnSave:
                if(BLL_client.save_mod_client()!=false){
                    Timer delay = new Timer(3000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            edit.dispose();
                            new ClientController(new Pager_client(),2).Init(2);
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
                new ClientController(new Pager_client(),2).Init(2);
                break;
                
                ////Events from pager admin
            case AddAdmin:
                pager.dispose();
                new ClientController(new Create_client(),0).Init(0);
                break;
                
            case ModAdmin:
                boolean modify;
                modify = BLL_client.edit_client();
                if (modify == true) {
                pager.dispose();
                }
                break;
                
            case DelAdmin:
                BLL_client.delete_file();
                break;
                
            case btnsavejson:
                BLL_client.savejsonClient();
                break;
                
            case btnsavetxt:
                BLL_client.savetxtClient();
                break;
                
            case btnsavexml:
                BLL_client.savexmlClient();
                break;
                
            case pagerTable:
                if (e.getClickCount() == 2) {
                pager.dispose();
                BLL_client.edit_client();
                }
                break;
                
//            case entriesCombo:
//                System.out.println("framework_v2.Modules.Admin.Controller.AdminController.mouseClicked()");
//                pagina.itemsPerPage=Integer.parseInt(jComboBox1.getSelectedItem().toString());
//                pagina.currentPageIndex = 1;
//                pagina.initLinkBox();
//                break;
                
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
                pager.AddClient.setIcon(Singleton_client.addicon_over);
                pager.pagerInfo.setText("Click to add new Admin user");
                break;
                
            case ModAdmin:
                pager.ModClient.setIcon(Singleton_client.editicon_over);
                pager.pagerInfo.setText("Click to modify selected Admin user");    
                break;
                
            case DelAdmin:
                pager.DelClient.setIcon(Singleton_client.delicon_over);
                pager.pagerInfo.setText("Click to delete selected Admin user");
                break;
                
            case btnsavejson:
                pager.btnsavejson.setIcon(Singleton_client.jsonicon_over);
                pager.pagerInfo.setText("Save to JSON file format");
                break;
                
            case btnsavetxt:
                pager.btnsavetxt.setIcon(Singleton_client.txticon_over);
                pager.pagerInfo.setText("Save to TXT file format");
                break;
                
            case btnsavexml:
                pager.btnsavexml.setIcon(Singleton_client.xmlicon_over);
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
                pager.AddClient.setIcon(Singleton_client.addicon);
                pager.pagerInfo.setText("");
                break;
                
            case ModAdmin:
                pager.ModClient.setIcon(Singleton_client.editicon);
                pager.pagerInfo.setText("");    
                break;
                
            case DelAdmin:
                pager.DelClient.setIcon(Singleton_client.delicon);
                pager.pagerInfo.setText("");
                break;
                
            case btnsavejson:
                pager.btnsavejson.setIcon(Singleton_client.jsonicon);
                pager.pagerInfo.setText("");
                break;
                
            case btnsavetxt:
                pager.btnsavetxt.setIcon(Singleton_client.txticon);
                pager.pagerInfo.setText("");
                break;
                
            case btnsavexml:
                pager.btnsavexml.setIcon(Singleton_client.xmlicon);
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

        if(Singleton_client.window.equals("create")){
                    
            switch (Property.valueOf(evt.getPropertyName())) {

                case date:
                    BLL_client.askClientdata("birthdate");
                    BLL_client.askClientdata("datecontract");
                    create.areaInfo.setBackground(Color.decode("#d6d6d6"));
                    break;

            }//End switch case
        }//End if
        if(Singleton_client.window.equals("modify")){
                    
            switch (Property.valueOf(evt.getPropertyName())) {

                case date:
                    BLL_client.modClientdata("birthdate");
                    BLL_client.modClientdata("datecontract");
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
                    new ClientController(new Pager_client(),2).Init(2);
                break;
            
            case editWindow:
                     edit.dispose(); 
                     new ClientController(new Pager_client(),2).Init(2);
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
