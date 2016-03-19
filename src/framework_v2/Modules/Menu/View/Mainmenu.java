/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework_v2.Modules.Menu.View;


import static framework_v2.Classes.Singleton_menus.*;
import framework_v2.Modules.Admin.Model.BLL.BLL_admin;
import framework_v2.Modules.Config.View.Config;
import framework_v2.Modules.Admin.View.Pager_admin;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author antonio
 */
public class Mainmenu extends javax.swing.JFrame {

    
    
    
    /**
     * Creates new form Mainmenu
     */
    public Mainmenu() {
        ImageIcon icon = new ImageIcon("src/framework_v2/Modules/Menu/View/img/back.jpg");
        Image img=icon.getImage();
        Image newimg = img.getScaledInstance(700, 460, java.awt.Image.SCALE_SMOOTH);
        setContentPane(new JLabel(new ImageIcon (newimg)));

        initComponents();
        this.setResizable(false);
        this.setSize(700,460);
        this.setTitle("Main Menu");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                BLL_admin.autosaveAdmin();
                JOptionPane.showMessageDialog(null,"Leaving application");
                dispose();
                System.exit(0);
            }
        });
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/framework_v2/Modules/Menu/View/img/client.png"))); // NOI18N
        btnClient.setText("Client users");
        btnClient.setToolTipText("Click for Client users");
        btnClient.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnClient.setMaximumSize(new java.awt.Dimension(96, 29));
        btnClient.setMinimumSize(new java.awt.Dimension(96, 29));
        btnClient.setPreferredSize(new java.awt.Dimension(96, 29));
        btnClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnClientMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnClientMouseEntered(evt);
            }
        });
        getContentPane().add(btnClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 240, 60));

        btnReguser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/framework_v2/Modules/Menu/View/img/reg_user.png"))); // NOI18N
        btnReguser.setText("Registered user");
        btnReguser.setToolTipText("Click for Registered users");
        btnReguser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReguser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReguserMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReguserMouseEntered(evt);
            }
        });
        btnReguser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReguserActionPerformed(evt);
            }
        });
        getContentPane().add(btnReguser, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 240, 60));

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, 60, -1));

        btnAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/framework_v2/Modules/Menu/View/img/admin.png"))); // NOI18N
        btnAdmin.setText("Admin users");
        btnAdmin.setToolTipText("Click for Admin users");
        btnAdmin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAdminMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAdminMouseEntered(evt);
            }
        });
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 240, 60));

        btnConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/framework_v2/Modules/Menu/View/img/conf.png"))); // NOI18N
        btnConfig.setToolTipText("Configuration");
        btnConfig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfigMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnConfigMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnConfigMouseEntered(evt);
            }
        });
        getContentPane().add(btnConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 80, 80));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnReguserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReguserActionPerformed
        
    }//GEN-LAST:event_btnReguserActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
                BLL_admin.autosaveAdmin();        
                JOptionPane.showMessageDialog(null,"Leaving application");
                dispose();
                System.exit(0);
            
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
        dispose();
        new Pager_admin().setVisible(true);
    }//GEN-LAST:event_btnAdminActionPerformed

    private void btnConfigMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfigMouseEntered
        btnConfig.setIcon(configicon_over);
    }//GEN-LAST:event_btnConfigMouseEntered

    private void btnConfigMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfigMouseExited
        btnConfig.setIcon(configicon);
    }//GEN-LAST:event_btnConfigMouseExited

    private void btnConfigMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfigMouseClicked
        dispose();
        new Config().setVisible(true);
    }//GEN-LAST:event_btnConfigMouseClicked

    private void btnAdminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdminMouseEntered
        btnAdmin.setIcon(adminicon_over);
    }//GEN-LAST:event_btnAdminMouseEntered

    private void btnAdminMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdminMouseExited
        btnAdmin.setIcon(adminicon);
    }//GEN-LAST:event_btnAdminMouseExited

    private void btnClientMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClientMouseEntered
        btnClient.setIcon(clienticon_over);
    }//GEN-LAST:event_btnClientMouseEntered

    private void btnClientMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClientMouseExited
        btnClient.setIcon(clienticon);
    }//GEN-LAST:event_btnClientMouseExited

    private void btnReguserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReguserMouseEntered
        btnReguser.setIcon(rusericon_over);
    }//GEN-LAST:event_btnReguserMouseEntered

    private void btnReguserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReguserMouseExited
        btnReguser.setIcon(rusericon);
    }//GEN-LAST:event_btnReguserMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnClient;
    private javax.swing.JLabel btnConfig;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnReguser;
    // End of variables declaration//GEN-END:variables
}
