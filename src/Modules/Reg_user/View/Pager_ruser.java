/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules.Reg_user.View;

/**
 *
 * @author antonio
 */
public class Pager_ruser extends javax.swing.JFrame {
    
    /**
     * Creates new form Pager_admin
     */
    public Pager_ruser() {
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

        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pagerTable = new javax.swing.JTable();
        pagButtonpanel = new javax.swing.JPanel();
        pagPrev = new javax.swing.JButton();
        pagNext = new javax.swing.JButton();
        pagBox = new javax.swing.JTextField();
        pagFirst = new javax.swing.JButton();
        pagLast = new javax.swing.JButton();
        pagLinks = new javax.swing.JPanel();
        pagReturn = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        labelEntries = new javax.swing.JLabel();
        labelSearch = new javax.swing.JLabel();
        pagAmount = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        comboSearch = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        AddRuser = new javax.swing.JLabel();
        ModRuser = new javax.swing.JLabel();
        DelRuser = new javax.swing.JLabel();
        btnsavejson = new javax.swing.JLabel();
        btnsavetxt = new javax.swing.JLabel();
        btnsavexml = new javax.swing.JLabel();
        pagerInfo = new javax.swing.JTextArea();
        ListRuser = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        pagerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(pagerTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pagButtonpanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pagButtonpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pagPrev.setText("<");
        pagButtonpanel.add(pagPrev, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        pagNext.setText(">");
        pagButtonpanel.add(pagNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, -1));

        pagBox.setEditable(false);
        pagBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pagBox.setPreferredSize(new java.awt.Dimension(140, 20));
        pagButtonpanel.add(pagBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 80, 30));

        pagFirst.setText("|<");
        pagButtonpanel.add(pagFirst, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        pagLast.setText(">|");
        pagButtonpanel.add(pagLast, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, -1, -1));

        javax.swing.GroupLayout pagLinksLayout = new javax.swing.GroupLayout(pagLinks);
        pagLinks.setLayout(pagLinksLayout);
        pagLinksLayout.setHorizontalGroup(
            pagLinksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pagLinksLayout.setVerticalGroup(
            pagLinksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        pagReturn.setText("Return");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "5", "10", "15", "20", "50", "100" }));

        labelEntries.setText("Show entries:");

        labelSearch.setText("Search");

        pagAmount.setText("jLabel3");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 157, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        comboSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID Card", "Name", "Surname" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(pagButtonpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelEntries, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 121, Short.MAX_VALUE))))
                    .addComponent(pagLinks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(labelSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pagAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pagReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pagButtonpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(labelEntries)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pagLinks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pagReturn)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(pagAmount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        getContentPane().add(jPanel6, java.awt.BorderLayout.CENTER);

        AddRuser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        AddRuser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modules/Client/View/img/add_no_over.png"))); // NOI18N

        ModRuser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ModRuser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modules/Client/View/img/edit_no_over.png"))); // NOI18N

        DelRuser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DelRuser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modules/Client/View/img/minus_no_over.png"))); // NOI18N

        btnsavejson.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modules/Client/View/img/json_no_over.png"))); // NOI18N

        btnsavetxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modules/Client/View/img/txt_no_over.png"))); // NOI18N

        btnsavexml.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modules/Client/View/img/xml_no_over.png"))); // NOI18N

        pagerInfo.setEditable(false);
        pagerInfo.setColumns(1);
        pagerInfo.setRows(1);
        pagerInfo.setBorder(javax.swing.BorderFactory.createTitledBorder("Info:"));

        ListRuser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modules/Admin/View/img/list.png"))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AddRuser)
                .addGap(18, 18, 18)
                .addComponent(ModRuser)
                .addGap(18, 18, 18)
                .addComponent(DelRuser)
                .addGap(27, 27, 27)
                .addComponent(ListRuser)
                .addGap(18, 18, 18)
                .addComponent(pagerInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnsavejson)
                .addGap(18, 18, 18)
                .addComponent(btnsavetxt)
                .addGap(18, 18, 18)
                .addComponent(btnsavexml)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnsavexml)
                    .addComponent(btnsavetxt)
                    .addComponent(btnsavejson)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ListRuser)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(AddRuser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ModRuser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DelRuser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(pagerInfo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );

        getContentPane().add(jPanel7, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel AddRuser;
    public static javax.swing.JLabel DelRuser;
    public static javax.swing.JLabel ListRuser;
    public static javax.swing.JLabel ModRuser;
    public static javax.swing.JLabel btnsavejson;
    public static javax.swing.JLabel btnsavetxt;
    public static javax.swing.JLabel btnsavexml;
    public static javax.swing.JComboBox<String> comboSearch;
    public static javax.swing.JComboBox jComboBox1;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel3;
    public static javax.swing.JPanel jPanel5;
    public static javax.swing.JPanel jPanel6;
    public static javax.swing.JPanel jPanel7;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel labelEntries;
    public static javax.swing.JLabel labelSearch;
    public static javax.swing.JLabel pagAmount;
    public static javax.swing.JTextField pagBox;
    public static javax.swing.JPanel pagButtonpanel;
    public static javax.swing.JButton pagFirst;
    public static javax.swing.JButton pagLast;
    public static javax.swing.JPanel pagLinks;
    public static javax.swing.JButton pagNext;
    public static javax.swing.JButton pagPrev;
    public static javax.swing.JButton pagReturn;
    public static javax.swing.JTextArea pagerInfo;
    public static javax.swing.JTable pagerTable;
    // End of variables declaration//GEN-END:variables
}
