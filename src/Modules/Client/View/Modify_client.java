/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules.Client.View;

/**
 *
 * @author antonio
 */
public class Modify_client extends javax.swing.JFrame {
  
    
    /**
     * Creates new form Create_admin
     */
    public Modify_client() {
       
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
        editfieldName = new javax.swing.JTextField();
        labelName = new javax.swing.JLabel();
        checkName = new javax.swing.JLabel();
        editfieldSurname = new javax.swing.JTextField();
        labelSurname = new javax.swing.JLabel();
        checkSurname = new javax.swing.JLabel();
        editfieldEmail = new javax.swing.JTextField();
        labelEmail = new javax.swing.JLabel();
        checkEmail = new javax.swing.JLabel();
        editfieldMobile = new javax.swing.JTextField();
        labelMobile = new javax.swing.JLabel();
        checkMobile = new javax.swing.JLabel();
        editfieldUser = new javax.swing.JTextField();
        labelUser = new javax.swing.JLabel();
        checkUser = new javax.swing.JLabel();
        editfieldPassword = new javax.swing.JPasswordField();
        labelPassword = new javax.swing.JLabel();
        checkPassword = new javax.swing.JLabel();
        editfieldPassword2 = new javax.swing.JPasswordField();
        labelPassword2 = new javax.swing.JLabel();
        checkPassword2 = new javax.swing.JLabel();
        editfieldShopping = new javax.swing.JTextField();
        labelShopping = new javax.swing.JLabel();
        checkShopping = new javax.swing.JLabel();
        editdateBirth = new com.toedter.calendar.JDateChooser();
        labeldateBith = new javax.swing.JLabel();
        checkDatebirth = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        avatar = new javax.swing.JLabel();
        labelAvatar = new javax.swing.JLabel();
        labelState = new javax.swing.JLabel();
        radioStateYes = new javax.swing.JRadioButton();
        radioStateNo = new javax.swing.JRadioButton();
        editdateRegistration = new com.toedter.calendar.JDateChooser();
        labeldateReg = new javax.swing.JLabel();
        checkDateRegistration = new javax.swing.JLabel();
        editfieldClientType = new javax.swing.JTextField();
        labelClientType = new javax.swing.JLabel();
        checkClientType = new javax.swing.JLabel();
        labelPremium = new javax.swing.JLabel();
        radioPremiumYes = new javax.swing.JRadioButton();
        radioPremiumNo = new javax.swing.JRadioButton();
        btnsaveEditclient = new javax.swing.JButton();
        btncancelEditclient = new javax.swing.JButton();
        saving = new javax.swing.JOptionPane();
        editareaInfo = new javax.swing.JTextArea();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(800, 800));
        getContentPane().setLayout(null);

        fieldDNI.setBackground(java.awt.Color.yellow);
        fieldDNI.setToolTipText("");
        getContentPane().add(fieldDNI);
        fieldDNI.setBounds(130, 5, 148, 25);

        labelDNI.setText("ID Card:");
        getContentPane().add(labelDNI);
        labelDNI.setBounds(25, 5, 105, 15);

        checkDNI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modules/Client/View/img/not_ok.png"))); // NOI18N
        getContentPane().add(checkDNI);
        checkDNI.setBounds(280, 5, 23, 23);

        editfieldName.setBackground(java.awt.Color.yellow);
        getContentPane().add(editfieldName);
        editfieldName.setBounds(130, 40, 148, 25);

        labelName.setText("Name:");
        getContentPane().add(labelName);
        labelName.setBounds(25, 40, 105, 15);

        checkName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modules/Client/View/img/not_ok.png"))); // NOI18N
        getContentPane().add(checkName);
        checkName.setBounds(280, 40, 23, 23);

        editfieldSurname.setBackground(java.awt.Color.yellow);
        getContentPane().add(editfieldSurname);
        editfieldSurname.setBounds(130, 75, 150, 25);

        labelSurname.setText("Surname:");
        getContentPane().add(labelSurname);
        labelSurname.setBounds(25, 75, 105, 15);

        checkSurname.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modules/Client/View/img/not_ok.png"))); // NOI18N
        getContentPane().add(checkSurname);
        checkSurname.setBounds(280, 75, 23, 23);

        editfieldEmail.setBackground(java.awt.Color.yellow);
        getContentPane().add(editfieldEmail);
        editfieldEmail.setBounds(130, 110, 150, 25);

        labelEmail.setText("e-mail:");
        getContentPane().add(labelEmail);
        labelEmail.setBounds(25, 110, 105, 15);

        checkEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modules/Client/View/img/not_ok.png"))); // NOI18N
        getContentPane().add(checkEmail);
        checkEmail.setBounds(280, 110, 23, 23);

        editfieldMobile.setBackground(java.awt.Color.yellow);
        getContentPane().add(editfieldMobile);
        editfieldMobile.setBounds(130, 145, 150, 25);

        labelMobile.setText("Mobile:");
        getContentPane().add(labelMobile);
        labelMobile.setBounds(25, 145, 105, 15);

        checkMobile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modules/Client/View/img/not_ok.png"))); // NOI18N
        getContentPane().add(checkMobile);
        checkMobile.setBounds(280, 145, 23, 23);

        editfieldUser.setBackground(java.awt.Color.yellow);
        getContentPane().add(editfieldUser);
        editfieldUser.setBounds(130, 180, 150, 25);

        labelUser.setText("User:");
        getContentPane().add(labelUser);
        labelUser.setBounds(25, 180, 105, 15);

        checkUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modules/Client/View/img/not_ok.png"))); // NOI18N
        getContentPane().add(checkUser);
        checkUser.setBounds(280, 180, 23, 23);

        editfieldPassword.setBackground(java.awt.Color.yellow);
        getContentPane().add(editfieldPassword);
        editfieldPassword.setBounds(130, 215, 150, 25);

        labelPassword.setText("Password:");
        getContentPane().add(labelPassword);
        labelPassword.setBounds(25, 215, 105, 15);

        checkPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modules/Client/View/img/not_ok.png"))); // NOI18N
        getContentPane().add(checkPassword);
        checkPassword.setBounds(280, 215, 23, 23);

        editfieldPassword2.setBackground(java.awt.Color.yellow);
        getContentPane().add(editfieldPassword2);
        editfieldPassword2.setBounds(130, 250, 150, 25);

        labelPassword2.setText("Verify:");
        getContentPane().add(labelPassword2);
        labelPassword2.setBounds(25, 250, 105, 15);

        checkPassword2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modules/Client/View/img/not_ok.png"))); // NOI18N
        getContentPane().add(checkPassword2);
        checkPassword2.setBounds(280, 250, 23, 23);
        getContentPane().add(editfieldShopping);
        editfieldShopping.setBounds(130, 285, 150, 25);

        labelShopping.setText("Shopping:");
        getContentPane().add(labelShopping);
        labelShopping.setBounds(25, 285, 105, 15);

        checkShopping.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modules/Client/View/img/not_ok.png"))); // NOI18N
        getContentPane().add(checkShopping);
        checkShopping.setBounds(280, 285, 23, 23);

        editdateBirth.setBackground(java.awt.Color.white);
        editdateBirth.setDateFormatString("dd/MM/yyyy");
        editdateBirth.setMaxSelectableDate(new java.util.Date(4102444893000L));
        editdateBirth.setMinSelectableDate(new java.util.Date(-2208984223000L));
        editdateBirth.setName("createdateBirth"); // NOI18N
        editdateBirth.setOpaque(false);
        getContentPane().add(editdateBirth);
        editdateBirth.setBounds(430, 15, 140, 27);
        editdateBirth.getAccessibleContext().setAccessibleName(getName());
        editdateBirth.getAccessibleContext().setAccessibleDescription(getName());

        labeldateBith.setText("Birth date:");
        getContentPane().add(labeldateBith);
        labeldateBith.setBounds(310, 15, 90, 15);

        checkDatebirth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modules/Client/View/img/not_ok.png"))); // NOI18N
        getContentPane().add(checkDatebirth);
        checkDatebirth.setBounds(580, 15, 23, 23);

        btnSearch.setText("Search");
        getContentPane().add(btnSearch);
        btnSearch.setBounds(380, 90, 90, 29);

        avatar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(avatar);
        avatar.setBounds(490, 60, 100, 100);

        labelAvatar.setText("Avatar:");
        getContentPane().add(labelAvatar);
        labelAvatar.setBounds(310, 90, 90, 15);

        labelState.setText("State: Connected?");
        getContentPane().add(labelState);
        labelState.setBounds(310, 170, 140, 15);

        buttonGroupState.add(radioStateYes);
        radioStateYes.setText("Yes");
        getContentPane().add(radioStateYes);
        radioStateYes.setBounds(470, 170, 60, 22);

        buttonGroupState.add(radioStateNo);
        radioStateNo.setSelected(true);
        radioStateNo.setText("No");
        getContentPane().add(radioStateNo);
        radioStateNo.setBounds(530, 170, 60, 22);

        editdateRegistration.setMaxSelectableDate(new java.util.Date(4102444865000L));
        editdateRegistration.setMinSelectableDate(new java.util.Date(-2208984251000L));
        getContentPane().add(editdateRegistration);
        editdateRegistration.setBounds(430, 210, 140, 27);

        labeldateReg.setText("Register date:");
        getContentPane().add(labeldateReg);
        labeldateReg.setBounds(310, 210, 110, 15);

        checkDateRegistration.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modules/Client/View/img/not_ok.png"))); // NOI18N
        getContentPane().add(checkDateRegistration);
        checkDateRegistration.setBounds(580, 210, 23, 23);

        editfieldClientType.setBackground(java.awt.Color.yellow);
        getContentPane().add(editfieldClientType);
        editfieldClientType.setBounds(430, 250, 114, 25);

        labelClientType.setText("Client type:");
        getContentPane().add(labelClientType);
        labelClientType.setBounds(310, 250, 110, 15);

        checkClientType.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modules/Client/View/img/not_ok.png"))); // NOI18N
        getContentPane().add(checkClientType);
        checkClientType.setBounds(580, 250, 23, 23);

        labelPremium.setText("Is premium?");
        getContentPane().add(labelPremium);
        labelPremium.setBounds(310, 290, 110, 15);

        buttonGroupPremium.add(radioPremiumYes);
        radioPremiumYes.setText("Yes");
        getContentPane().add(radioPremiumYes);
        radioPremiumYes.setBounds(440, 290, 60, 22);

        buttonGroupPremium.add(radioPremiumNo);
        radioPremiumNo.setSelected(true);
        radioPremiumNo.setText("No");
        getContentPane().add(radioPremiumNo);
        radioPremiumNo.setBounds(500, 290, 60, 22);

        btnsaveEditclient.setText("Save");
        getContentPane().add(btnsaveEditclient);
        btnsaveEditclient.setBounds(160, 400, 80, 29);

        btncancelEditclient.setText("Cancel");
        getContentPane().add(btncancelEditclient);
        btncancelEditclient.setBounds(380, 400, 90, 29);

        saving.setBorder(null);
        saving.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modules/Client/View/img/Preloader_3.gif"))); // NOI18N
        saving.setMessage("");
        saving.setEnabled(false);
        saving.setFocusable(false);
        saving.setRequestFocusEnabled(false);
        saving.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(saving);
        saving.setBounds(260, 148, 130, 130);

        editareaInfo.setColumns(2);
        editareaInfo.setRows(1);
        editareaInfo.setBorder(javax.swing.BorderFactory.createTitledBorder("Info:"));
        getContentPane().add(editareaInfo);
        editareaInfo.setBounds(65, 330, 490, 50);

        back.setText("back");
        getContentPane().add(back);
        back.setBounds(0, 0, 30, 15);

        pack();
    }// </editor-fold>//GEN-END:initComponents
            

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel avatar;
    public static javax.swing.JLabel back;
    public static javax.swing.JButton btnSearch;
    public static javax.swing.JButton btncancelEditclient;
    public static javax.swing.JButton btnsaveEditclient;
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
    public static javax.swing.JTextArea editareaInfo;
    public static com.toedter.calendar.JDateChooser editdateBirth;
    public static com.toedter.calendar.JDateChooser editdateRegistration;
    public static javax.swing.JTextField editfieldClientType;
    public static javax.swing.JTextField editfieldEmail;
    public static javax.swing.JTextField editfieldMobile;
    public static javax.swing.JTextField editfieldName;
    public static javax.swing.JPasswordField editfieldPassword;
    public static javax.swing.JPasswordField editfieldPassword2;
    public static javax.swing.JTextField editfieldShopping;
    public static javax.swing.JTextField editfieldSurname;
    public static javax.swing.JTextField editfieldUser;
    public static javax.swing.JTextField fieldDNI;
    public static javax.swing.JLabel labelAvatar;
    private javax.swing.JLabel labelClientType;
    public static javax.swing.JLabel labelDNI;
    public static javax.swing.JLabel labelEmail;
    public static javax.swing.JLabel labelMobile;
    public static javax.swing.JLabel labelName;
    public static javax.swing.JLabel labelPassword;
    public static javax.swing.JLabel labelPassword2;
    public static javax.swing.JLabel labelPremium;
    public static javax.swing.JLabel labelShopping;
    public static javax.swing.JLabel labelState;
    public static javax.swing.JLabel labelSurname;
    public static javax.swing.JLabel labelUser;
    public static javax.swing.JLabel labeldateBith;
    public static javax.swing.JLabel labeldateReg;
    public static javax.swing.JRadioButton radioPremiumNo;
    public static javax.swing.JRadioButton radioPremiumYes;
    public static javax.swing.JRadioButton radioStateNo;
    public static javax.swing.JRadioButton radioStateYes;
    public javax.swing.JOptionPane saving;
    // End of variables declaration//GEN-END:variables
}
