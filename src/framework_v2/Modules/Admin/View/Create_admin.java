/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework_v2.Modules.Admin.View;


import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author antonio
 */
public class Create_admin extends javax.swing.JFrame {


    
//    private void doPause() {
//        Timer delay = new Timer(3000, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//        dispose();
//        new Pager_admin().setVisible(true);
//            }
//        });
//        
//              
//        saving.setVisible(true);
//        delay.setRepeats(false);
//        delay.start();
//        Create_admin.areaInfo.setText("User created correctly");
//        Create_admin.areaInfo.setBackground(Color.green);
//    }
    
    
    /**
     * Creates new form Create_admin
     */
    public Create_admin() {
        ImageIcon icon = new ImageIcon("src/framework_v2/Modules/Admin/View/img/wood_3.jpg");
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
        fieldDNI = new javax.swing.JTextField();
        labelDNI = new javax.swing.JLabel();
        fieldName = new javax.swing.JTextField();
        labelName = new javax.swing.JLabel();
        labelSurname = new javax.swing.JLabel();
        fieldSurname = new javax.swing.JTextField();
        labelEmail = new javax.swing.JLabel();
        fieldEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        fieldMobile = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        fieldUser = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        radioStateYes = new javax.swing.JRadioButton();
        radioStateNo = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        fieldActivity = new javax.swing.JTextField();
        btnsaveCreateadmin = new javax.swing.JButton();
        btncancelCreateadmin = new javax.swing.JButton();
        btnresetCreateadmin = new javax.swing.JButton();
        checkSurname = new javax.swing.JLabel();
        checkDNI = new javax.swing.JLabel();
        checkName = new javax.swing.JLabel();
        checkEmail = new javax.swing.JLabel();
        checkMobile = new javax.swing.JLabel();
        checkUser = new javax.swing.JLabel();
        fieldPassword = new javax.swing.JPasswordField();
        checkPassword = new javax.swing.JLabel();
        labelPassword2 = new javax.swing.JLabel();
        fieldPassword2 = new javax.swing.JPasswordField();
        checkPassword2 = new javax.swing.JLabel();
        checkActivity = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        dateBirth = new com.toedter.calendar.JDateChooser();
        dateContract = new com.toedter.calendar.JDateChooser();
        checkDatebirth = new javax.swing.JLabel();
        checkDatecontract = new javax.swing.JLabel();
        avatar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaInfo = new javax.swing.JTextArea();
        saving = new javax.swing.JOptionPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(800, 800));
        getContentPane().setLayout(null);

        fieldDNI.setBackground(java.awt.Color.yellow);
        fieldDNI.setToolTipText("");
        getContentPane().add(fieldDNI);
        fieldDNI.setBounds(90, 10, 148, 25);

        labelDNI.setText("ID Card:");
        getContentPane().add(labelDNI);
        labelDNI.setBounds(10, 15, 70, 15);

        fieldName.setBackground(java.awt.Color.yellow);
        getContentPane().add(fieldName);
        fieldName.setBounds(90, 50, 148, 25);

        labelName.setText("Name:");
        getContentPane().add(labelName);
        labelName.setBounds(10, 50, 80, 15);

        labelSurname.setText("Surname:");
        getContentPane().add(labelSurname);
        labelSurname.setBounds(10, 90, 80, 15);

        fieldSurname.setBackground(java.awt.Color.yellow);
        getContentPane().add(fieldSurname);
        fieldSurname.setBounds(90, 90, 150, 25);

        labelEmail.setText("e-mail:");
        getContentPane().add(labelEmail);
        labelEmail.setBounds(10, 130, 80, 15);

        fieldEmail.setBackground(java.awt.Color.yellow);
        getContentPane().add(fieldEmail);
        fieldEmail.setBounds(90, 130, 150, 25);

        jLabel5.setText("Mobile:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 170, 80, 15);

        fieldMobile.setBackground(java.awt.Color.yellow);
        getContentPane().add(fieldMobile);
        fieldMobile.setBounds(90, 170, 150, 25);

        jLabel6.setText("User:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 210, 80, 15);

        fieldUser.setBackground(java.awt.Color.yellow);
        getContentPane().add(fieldUser);
        fieldUser.setBounds(90, 210, 150, 25);

        jLabel7.setText("Password:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 250, 80, 15);

        jLabel9.setText("Birth date:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(290, 15, 90, 15);

        jLabel10.setText("Avatar:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(290, 90, 90, 15);

        jLabel11.setText("State:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(290, 170, 60, 15);

        jLabel12.setText("Connected?");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(343, 170, 90, 15);

        buttonGroupState.add(radioStateYes);
        radioStateYes.setText("Yes");
        getContentPane().add(radioStateYes);
        radioStateYes.setBounds(440, 170, 60, 22);

        buttonGroupState.add(radioStateNo);
        radioStateNo.setSelected(true);
        radioStateNo.setText("No");
        getContentPane().add(radioStateNo);
        radioStateNo.setBounds(500, 170, 60, 22);

        jLabel8.setText("Contract date:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(290, 210, 110, 15);

        jLabel13.setText("Activity:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(290, 250, 90, 15);

        fieldActivity.setBackground(java.awt.Color.yellow);
        getContentPane().add(fieldActivity);
        fieldActivity.setBounds(400, 250, 114, 25);

        btnsaveCreateadmin.setText("Save");
        getContentPane().add(btnsaveCreateadmin);
        btnsaveCreateadmin.setBounds(140, 400, 80, 29);

        btncancelCreateadmin.setText("Cancel");
        getContentPane().add(btncancelCreateadmin);
        btncancelCreateadmin.setBounds(360, 400, 90, 29);

        btnresetCreateadmin.setText("Reset");
        getContentPane().add(btnresetCreateadmin);
        btnresetCreateadmin.setBounds(250, 400, 90, 29);

        checkSurname.setIcon(new javax.swing.ImageIcon(getClass().getResource("/framework_v2/Modules/Admin/View/img/not_ok.png"))); // NOI18N
        getContentPane().add(checkSurname);
        checkSurname.setBounds(250, 90, 23, 23);

        checkDNI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/framework_v2/Modules/Admin/View/img/not_ok.png"))); // NOI18N
        getContentPane().add(checkDNI);
        checkDNI.setBounds(250, 10, 23, 23);

        checkName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/framework_v2/Modules/Admin/View/img/not_ok.png"))); // NOI18N
        getContentPane().add(checkName);
        checkName.setBounds(250, 50, 23, 23);

        checkEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/framework_v2/Modules/Admin/View/img/not_ok.png"))); // NOI18N
        getContentPane().add(checkEmail);
        checkEmail.setBounds(250, 130, 23, 23);

        checkMobile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/framework_v2/Modules/Admin/View/img/not_ok.png"))); // NOI18N
        getContentPane().add(checkMobile);
        checkMobile.setBounds(250, 170, 23, 23);

        checkUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/framework_v2/Modules/Admin/View/img/not_ok.png"))); // NOI18N
        getContentPane().add(checkUser);
        checkUser.setBounds(250, 210, 23, 23);

        fieldPassword.setBackground(java.awt.Color.yellow);
        getContentPane().add(fieldPassword);
        fieldPassword.setBounds(90, 250, 150, 25);

        checkPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/framework_v2/Modules/Admin/View/img/not_ok.png"))); // NOI18N
        getContentPane().add(checkPassword);
        checkPassword.setBounds(250, 250, 23, 23);

        labelPassword2.setText("Verify:");
        getContentPane().add(labelPassword2);
        labelPassword2.setBounds(10, 290, 80, 15);

        fieldPassword2.setBackground(java.awt.Color.yellow);
        getContentPane().add(fieldPassword2);
        fieldPassword2.setBounds(90, 290, 150, 25);

        checkPassword2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/framework_v2/Modules/Admin/View/img/not_ok.png"))); // NOI18N
        getContentPane().add(checkPassword2);
        checkPassword2.setBounds(250, 290, 23, 23);

        checkActivity.setIcon(new javax.swing.ImageIcon(getClass().getResource("/framework_v2/Modules/Admin/View/img/not_ok.png"))); // NOI18N
        getContentPane().add(checkActivity);
        checkActivity.setBounds(550, 250, 23, 23);

        btnSearch.setText("Search");
        getContentPane().add(btnSearch);
        btnSearch.setBounds(350, 90, 90, 29);

        dateBirth.setBackground(java.awt.Color.white);
        dateBirth.setDateFormatString("dd/MM/yyyy");
        dateBirth.setMaxSelectableDate(new java.util.Date(4102444893000L));
        dateBirth.setMinSelectableDate(new java.util.Date(-2208984223000L));
        dateBirth.setName("createdateBirth"); // NOI18N
        dateBirth.setOpaque(false);
        getContentPane().add(dateBirth);
        dateBirth.setBounds(400, 15, 140, 27);
        dateBirth.getAccessibleContext().setAccessibleName(getName());
        dateBirth.getAccessibleContext().setAccessibleDescription(getName());

        getContentPane().add(dateContract);
        dateContract.setBounds(400, 210, 140, 27);

        checkDatebirth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/framework_v2/Modules/Admin/View/img/not_ok.png"))); // NOI18N
        getContentPane().add(checkDatebirth);
        checkDatebirth.setBounds(550, 15, 23, 23);

        checkDatecontract.setIcon(new javax.swing.ImageIcon(getClass().getResource("/framework_v2/Modules/Admin/View/img/not_ok.png"))); // NOI18N
        getContentPane().add(checkDatecontract);
        checkDatecontract.setBounds(550, 210, 23, 23);

        avatar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(avatar);
        avatar.setBounds(460, 60, 100, 100);

        areaInfo.setColumns(2);
        areaInfo.setRows(1);
        areaInfo.setBorder(javax.swing.BorderFactory.createTitledBorder("Info:"));
        jScrollPane1.setViewportView(areaInfo);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 330, 490, 50);

        saving.setBorder(null);
        saving.setIcon(new javax.swing.ImageIcon(getClass().getResource("/framework_v2/Modules/Admin/View/img/Preloader_3.gif"))); // NOI18N
        saving.setMessage("");
        saving.setEnabled(false);
        saving.setFocusable(false);
        saving.setRequestFocusEnabled(false);
        saving.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(saving);
        saving.setBounds(238, 148, 130, 130);

        pack();
    }// </editor-fold>//GEN-END:initComponents
            

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextArea areaInfo;
    public static javax.swing.JLabel avatar;
    public static javax.swing.JButton btnSearch;
    public static javax.swing.JButton btncancelCreateadmin;
    public static javax.swing.JButton btnresetCreateadmin;
    public static javax.swing.JButton btnsaveCreateadmin;
    private javax.swing.ButtonGroup buttonGroupState;
    public static javax.swing.JLabel checkActivity;
    public static javax.swing.JLabel checkDNI;
    public static javax.swing.JLabel checkDatebirth;
    public static javax.swing.JLabel checkDatecontract;
    public static javax.swing.JLabel checkEmail;
    public static javax.swing.JLabel checkMobile;
    public static javax.swing.JLabel checkName;
    public static javax.swing.JLabel checkPassword;
    public static javax.swing.JLabel checkPassword2;
    public static javax.swing.JLabel checkSurname;
    public static javax.swing.JLabel checkUser;
    public static com.toedter.calendar.JDateChooser dateBirth;
    public static com.toedter.calendar.JDateChooser dateContract;
    public static javax.swing.JTextField fieldActivity;
    public static javax.swing.JTextField fieldDNI;
    public static javax.swing.JTextField fieldEmail;
    public static javax.swing.JTextField fieldMobile;
    public static javax.swing.JTextField fieldName;
    public static javax.swing.JPasswordField fieldPassword;
    public static javax.swing.JPasswordField fieldPassword2;
    public static javax.swing.JTextField fieldSurname;
    public static javax.swing.JTextField fieldUser;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDNI;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelPassword2;
    private javax.swing.JLabel labelSurname;
    public static javax.swing.JRadioButton radioStateNo;
    public static javax.swing.JRadioButton radioStateYes;
    public javax.swing.JOptionPane saving;
    // End of variables declaration//GEN-END:variables
}
