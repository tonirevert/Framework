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
public class List_client extends javax.swing.JFrame {

    /**
     * Creates new form List_admin
     */
    public List_client() {
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

        btnReturn = new javax.swing.JButton();
        StringArea = new javax.swing.JTextArea();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnReturn.setText("Return");
        getContentPane().add(btnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 350, -1, -1));

        StringArea.setEditable(false);
        StringArea.setColumns(20);
        StringArea.setRows(5);
        StringArea.setBorder(javax.swing.BorderFactory.createTitledBorder("Client:"));
        getContentPane().add(StringArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 468, 300));

        back.setText("back");
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextArea StringArea;
    public static javax.swing.JLabel back;
    public static javax.swing.JButton btnReturn;
    // End of variables declaration//GEN-END:variables
}
