/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules.Menu.View;

/**
 *
 * @author antonio
 */
public class Mainmenu extends javax.swing.JFrame {

    
    
    
    /**
     * Creates new form Mainmenu
     */
    public Mainmenu() {
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

        btnClient = new javax.swing.JButton();
        btnReguser = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnAdmin = new javax.swing.JButton();
        btnConfig = new javax.swing.JLabel();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modules/Menu/View/img/client.png"))); // NOI18N
        btnClient.setText("Client users");
        btnClient.setToolTipText("Click for Client users");
        btnClient.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnClient.setMaximumSize(new java.awt.Dimension(96, 29));
        btnClient.setMinimumSize(new java.awt.Dimension(96, 29));
        btnClient.setPreferredSize(new java.awt.Dimension(96, 29));
        getContentPane().add(btnClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 240, 60));

        btnReguser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modules/Menu/View/img/reg_user.png"))); // NOI18N
        btnReguser.setText("Registered user");
        btnReguser.setToolTipText("Click for Registered users");
        btnReguser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        getContentPane().add(btnReguser, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 240, 60));

        btnExit.setText("Exit");
        btnExit.setToolTipText("Click to exit the aplication");
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, 80, -1));

        btnAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modules/Menu/View/img/admin.png"))); // NOI18N
        btnAdmin.setText("Admin users");
        btnAdmin.setToolTipText("Click for Admin users");
        btnAdmin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        getContentPane().add(btnAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 240, 60));

        btnConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modules/Menu/View/img/conf.png"))); // NOI18N
        btnConfig.setToolTipText("Click to enter Configuration");
        getContentPane().add(btnConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 80, 80));

        back.setText("back");
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel back;
    public javax.swing.JButton btnAdmin;
    public javax.swing.JButton btnClient;
    public javax.swing.JLabel btnConfig;
    public javax.swing.JButton btnExit;
    public javax.swing.JButton btnReguser;
    // End of variables declaration//GEN-END:variables
}
