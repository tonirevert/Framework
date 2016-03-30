/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules.Client.View;


import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author antonio
 */
public class Create_client extends javax.swing.JFrame {
  
    
    /**
     * Creates new form Create_admin
     */
    public Create_client() {
        ImageIcon icon = new ImageIcon("src/Modules/Client/View/img/wood_3.jpg");
        Image img=icon.getImage();
        Image newimg = img.getScaledInstance(600, 500, java.awt.Image.SCALE_SMOOTH);
        setContentPane(new JLabel(new ImageIcon (newimg)));
        
        initComponents();
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupState = new javax.swing.ButtonGroup();
        buttonGroupPremium = new javax.swing.ButtonGroup();
        fieldDNI = new javax.swing.JTextField();
        labelDNI = new javax.swing.JLabel();
        checkDNI = new javax.swing.JLabel();
        fieldName = new javax.swing.JTextField();
        labelName = new javax.swing.JLabel();
        checkName = new javax.swing.JLabel();
        fieldSurname = new javax.swing.JTextField();
        labelSurname = new javax.swing.JLabel();
        checkSurname = new javax.swing.JLabel();
        fieldEmail = new javax.swing.JTextField();
        labelEmail = new javax.swing.JLabel();
        checkEmail = new javax.swing.JLabel();
        fieldMobile = new javax.swing.JTextField();
        labelMobile = new javax.swing.JLabel();
        checkMobile = new javax.swing.JLabel();
        fieldUser = new javax.swing.JTextField();
        labelUser = new javax.swing.JLabel();
        checkUser = new javax.swing.JLabel();
        fieldPassword = new javax.swing.JPasswordField();
        labelPassword = new javax.swing.JLabel();
        checkPassword = new javax.swing.JLabel();
        fieldPassword2 = new javax.swing.JPasswordField();
        labelPassword2 = new javax.swing.JLabel();
        checkPassword2 = new javax.swing.JLabel();
        fieldShopping = new javax.swing.JTextField();
        labelShopping = new javax.swing.JLabel();
        checkShopping = new javax.swing.JLabel();
        dateBirth = new com.toedter.calendar.JDateChooser();
        labeldateBirth = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        labelAvatar = new javax.swing.JLabel();
        labelState = new javax.swing.JLabel();
        radioStateYes = new javax.swing.JRadioButton();
        radioStateNo = new javax.swing.JRadioButton();
        labelRegister = new javax.swing.JLabel();
        labelClientType = new javax.swing.JLabel();
        fieldClientType = new javax.swing.JTextField();
        btnsaveCreateclient = new javax.swing.JButton();
        btncancelCreateclient = new javax.swing.JButton();
        btnresetCreateclient = new javax.swing.JButton();
        checkClientType = new javax.swing.JLabel();
        dateRegistration = new com.toedter.calendar.JDateChooser();
        checkDatebirth = new javax.swing.JLabel();
        checkDateRegistration = new javax.swing.JLabel();
        avatar = new javax.swing.JLabel();
        saving = new javax.swing.JOptionPane();
        labelPremium = new javax.swing.JLabel();
        radioPremiumYes = new javax.swing.JRadioButton();
        radioPremiumNo = new javax.swing.JRadioButton();
        areaInfo = new javax.swing.JTextArea();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(800, 800));
        getContentPane().setLayout(null);

        fieldDNI.setBackground(java.awt.Color.yellow);
        fieldDNI.setToolTipText("");
        getContentPane().add(fieldDNI);
        fieldDNI.setBounds(130, 5, 148, 20);

        labelDNI.setText("ID Card:");
        getContentPane().add(labelDNI);
        labelDNI.setBounds(25, 5, 105, 14);

        checkDNI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modules/Client/View/img/not_ok.png"))); // NOI18N
        getContentPane().add(checkDNI);
        checkDNI.setBounds(280, 5, 23, 23);

        fieldName.setBackground(java.awt.Color.yellow);
        getContentPane().add(fieldName);
        fieldName.setBounds(130, 40, 148, 20);

        labelName.setText("Name:");
        getContentPane().add(labelName);
        labelName.setBounds(25, 40, 105, 14);

        checkName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modules/Client/View/img/not_ok.png"))); // NOI18N
        getContentPane().add(checkName);
        checkName.setBounds(280, 40, 23, 23);

        fieldSurname.setBackground(java.awt.Color.yellow);
        getContentPane().add(fieldSurname);
        fieldSurname.setBounds(130, 75, 150, 20);

        labelSurname.setText("Surname:");
        getContentPane().add(labelSurname);
        labelSurname.setBounds(25, 75, 105, 14);

        checkSurname.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modules/Client/View/img/not_ok.png"))); // NOI18N
        getContentPane().add(checkSurname);
        checkSurname.setBounds(280, 75, 23, 23);

        fieldEmail.setBackground(java.awt.Color.yellow);
        getContentPane().add(fieldEmail);
        fieldEmail.setBounds(130, 110, 150, 20);

        labelEmail.setText("e-mail:");
        getContentPane().add(labelEmail);
        labelEmail.setBounds(25, 110, 105, 14);

        checkEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modules/Client/View/img/not_ok.png"))); // NOI18N
        getContentPane().add(checkEmail);
        checkEmail.setBounds(280, 110, 23, 23);

        fieldMobile.setBackground(java.awt.Color.yellow);
        getContentPane().add(fieldMobile);
        fieldMobile.setBounds(130, 145, 150, 20);

        labelMobile.setText("Mobile:");
        getContentPane().add(labelMobile);
        labelMobile.setBounds(25, 145, 105, 14);

        checkMobile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modules/Client/View/img/not_ok.png"))); // NOI18N
        getContentPane().add(checkMobile);
        checkMobile.setBounds(280, 145, 23, 23);

        fieldUser.setBackground(java.awt.Color.yellow);
        getContentPane().add(fieldUser);
        fieldUser.setBounds(130, 180, 150, 20);

        labelUser.setText("User:");
        getContentPane().add(labelUser);
        labelUser.setBounds(25, 180, 105, 14);

        checkUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modules/Client/View/img/not_ok.png"))); // NOI18N
        getContentPane().add(checkUser);
        checkUser.setBounds(280, 180, 23, 23);

        fieldPassword.setBackground(java.awt.Color.yellow);
        getContentPane().add(fieldPassword);
        fieldPassword.setBounds(130, 215, 150, 20);

        labelPassword.setText("Password:");
        getContentPane().add(labelPassword);
        labelPassword.setBounds(25, 215, 105, 14);

        checkPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modules/Client/View/img/not_ok.png"))); // NOI18N
        getContentPane().add(checkPassword);
        checkPassword.setBounds(280, 215, 23, 23);

        fieldPassword2.setBackground(java.awt.Color.yellow);
        getContentPane().add(fieldPassword2);
        fieldPassword2.setBounds(130, 250, 150, 20);

        labelPassword2.setText("Verify:");
        getContentPane().add(labelPassword2);
        labelPassword2.setBounds(25, 250, 105, 14);

        checkPassword2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modules/Client/View/img/not_ok.png"))); // NOI18N
        getContentPane().add(checkPassword2);
        checkPassword2.setBounds(280, 250, 23, 23);

        fieldShopping.setBackground(java.awt.Color.yellow);
        getContentPane().add(fieldShopping);
        fieldShopping.setBounds(130, 285, 150, 20);

        labelShopping.setText("Shopping:");
        getContentPane().add(labelShopping);
        labelShopping.setBounds(25, 285, 105, 14);

        checkShopping.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modules/Client/View/img/not_ok.png"))); // NOI18N
        getContentPane().add(checkShopping);
        checkShopping.setBounds(280, 285, 23, 23);

        dateBirth.setBackground(java.awt.Color.white);
        dateBirth.setDateFormatString("dd/MM/yyyy");
        dateBirth.setMaxSelectableDate(new java.util.Date(4102444893000L));
        dateBirth.setMinSelectableDate(new java.util.Date(-2208984223000L));
        dateBirth.setName("createdateBirth"); // NOI18N
        dateBirth.setOpaque(false);
        getContentPane().add(dateBirth);
        dateBirth.setBounds(430, 15, 140, 20);
        dateBirth.getAccessibleContext().setAccessibleName(getName());
        dateBirth.getAccessibleContext().setAccessibleDescription(getName());

        labeldateBirth.setText("Birth date:");
        getContentPane().add(labeldateBirth);
        labeldateBirth.setBounds(310, 15, 90, 14);

        btnSearch.setText("Search");
        getContentPane().add(btnSearch);
        btnSearch.setBounds(380, 90, 90, 23);

        labelAvatar.setText("Avatar:");
        getContentPane().add(labelAvatar);
        labelAvatar.setBounds(310, 90, 90, 14);

        labelState.setText("State: Connected?");
        getContentPane().add(labelState);
        labelState.setBounds(310, 170, 140, 14);

        buttonGroupState.add(radioStateYes);
        radioStateYes.setText("Yes");
        getContentPane().add(radioStateYes);
        radioStateYes.setBounds(470, 170, 60, 23);

        buttonGroupState.add(radioStateNo);
        radioStateNo.setSelected(true);
        radioStateNo.setText("No");
        getContentPane().add(radioStateNo);
        radioStateNo.setBounds(530, 170, 60, 23);

        labelRegister.setText("Register date:");
        getContentPane().add(labelRegister);
        labelRegister.setBounds(310, 210, 110, 14);

        labelClientType.setText("Client type:");
        getContentPane().add(labelClientType);
        labelClientType.setBounds(310, 250, 110, 14);

        fieldClientType.setBackground(java.awt.Color.yellow);
        getContentPane().add(fieldClientType);
        fieldClientType.setBounds(430, 250, 114, 20);

        btnsaveCreateclient.setText("Save");
        getContentPane().add(btnsaveCreateclient);
        btnsaveCreateclient.setBounds(160, 400, 80, 23);

        btncancelCreateclient.setText("Cancel");
        getContentPane().add(btncancelCreateclient);
        btncancelCreateclient.setBounds(380, 400, 100, 23);

        btnresetCreateclient.setText("Reset");
        getContentPane().add(btnresetCreateclient);
        btnresetCreateclient.setBounds(270, 400, 90, 23);

        checkClientType.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modules/Client/View/img/not_ok.png"))); // NOI18N
        getContentPane().add(checkClientType);
        checkClientType.setBounds(580, 250, 23, 23);

        dateRegistration.setMaxSelectableDate(new java.util.Date(4102444875000L));
        dateRegistration.setMinSelectableDate(new java.util.Date(-2208984241000L));
        getContentPane().add(dateRegistration);
        dateRegistration.setBounds(430, 210, 140, 20);

        checkDatebirth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modules/Client/View/img/not_ok.png"))); // NOI18N
        getContentPane().add(checkDatebirth);
        checkDatebirth.setBounds(580, 15, 23, 23);

        checkDateRegistration.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modules/Client/View/img/not_ok.png"))); // NOI18N
        getContentPane().add(checkDateRegistration);
        checkDateRegistration.setBounds(580, 210, 23, 23);

        avatar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(avatar);
        avatar.setBounds(490, 60, 100, 100);

        saving.setBorder(null);
        saving.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modules/Client/View/img/Preloader_3.gif"))); // NOI18N
        saving.setMessage("");
        saving.setEnabled(false);
        saving.setFocusable(false);
        saving.setRequestFocusEnabled(false);
        saving.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(saving);
        saving.setBounds(260, 148, 130, 130);

        labelPremium.setText("Is premium?");
        getContentPane().add(labelPremium);
        labelPremium.setBounds(310, 290, 110, 14);

        buttonGroupPremium.add(radioPremiumYes);
        radioPremiumYes.setText("Yes");
        getContentPane().add(radioPremiumYes);
        radioPremiumYes.setBounds(440, 290, 60, 23);

        buttonGroupPremium.add(radioPremiumNo);
        radioPremiumNo.setSelected(true);
        radioPremiumNo.setText("No");
        getContentPane().add(radioPremiumNo);
        radioPremiumNo.setBounds(500, 290, 60, 23);

        areaInfo.setColumns(2);
        areaInfo.setRows(1);
        areaInfo.setBorder(javax.swing.BorderFactory.createTitledBorder("Info:"));
        getContentPane().add(areaInfo);
        areaInfo.setBounds(65, 330, 490, 50);

        back.setText("back");
        getContentPane().add(back);
        back.setBounds(0, 0, 22, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents
            

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextArea areaInfo;
    public static javax.swing.JLabel avatar;
    public static javax.swing.JLabel back;
    public static javax.swing.JButton btnSearch;
    public static javax.swing.JButton btncancelCreateclient;
    public static javax.swing.JButton btnresetCreateclient;
    public static javax.swing.JButton btnsaveCreateclient;
    private javax.swing.ButtonGroup buttonGroupPremium;
    private javax.swing.ButtonGroup buttonGroupState;
    public static javax.swing.JLabel checkClientType;
    public static javax.swing.JLabel checkDNI;
    public static javax.swing.JLabel checkDateRegistration;
    public static javax.swing.JLabel checkDatebirth;
    public static javax.swing.JLabel checkEmail;
    public static javax.swing.JLabel checkMobile;
    public static javax.swing.JLabel checkName;
    public static javax.swing.JLabel checkPassword;
    public static javax.swing.JLabel checkPassword2;
    public static javax.swing.JLabel checkShopping;
    public static javax.swing.JLabel checkSurname;
    public static javax.swing.JLabel checkUser;
    public static com.toedter.calendar.JDateChooser dateBirth;
    public static com.toedter.calendar.JDateChooser dateRegistration;
    public static javax.swing.JTextField fieldClientType;
    public static javax.swing.JTextField fieldDNI;
    public static javax.swing.JTextField fieldEmail;
    public static javax.swing.JTextField fieldMobile;
    public static javax.swing.JTextField fieldName;
    public static javax.swing.JPasswordField fieldPassword;
    public static javax.swing.JPasswordField fieldPassword2;
    public static javax.swing.JTextField fieldShopping;
    public static javax.swing.JTextField fieldSurname;
    public static javax.swing.JTextField fieldUser;
    public static javax.swing.JLabel labelAvatar;
    public static javax.swing.JLabel labelClientType;
    public static javax.swing.JLabel labelDNI;
    public static javax.swing.JLabel labelEmail;
    public static javax.swing.JLabel labelMobile;
    public static javax.swing.JLabel labelName;
    public static javax.swing.JLabel labelPassword;
    public static javax.swing.JLabel labelPassword2;
    public static javax.swing.JLabel labelPremium;
    public static javax.swing.JLabel labelRegister;
    public static javax.swing.JLabel labelShopping;
    public static javax.swing.JLabel labelState;
    public static javax.swing.JLabel labelSurname;
    public static javax.swing.JLabel labelUser;
    public static javax.swing.JLabel labeldateBirth;
    public static javax.swing.JRadioButton radioPremiumNo;
    public static javax.swing.JRadioButton radioPremiumYes;
    public static javax.swing.JRadioButton radioStateNo;
    public static javax.swing.JRadioButton radioStateYes;
    public javax.swing.JOptionPane saving;
    // End of variables declaration//GEN-END:variables
}
