/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules.Config.View;

/**
 *
 * @author antonio
 */
public class Config extends javax.swing.JFrame {

    /**
     * Creates new form Config
     */
    public Config() {
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

        labelDateform = new javax.swing.JLabel();
        comboDateform = new javax.swing.JComboBox<>();
        labelCurrency = new javax.swing.JLabel();
        comboCurrency = new javax.swing.JComboBox<>();
        labelLanguage = new javax.swing.JLabel();
        comboLanguage = new javax.swing.JComboBox<>();
        labelFileform = new javax.swing.JLabel();
        comboFileform = new javax.swing.JComboBox<>();
        btnSaveConf = new javax.swing.JButton();
        btnCancelConf = new javax.swing.JButton();
        labelTheme = new javax.swing.JLabel();
        comboTheme = new javax.swing.JComboBox<>();
        labelDecimals = new javax.swing.JLabel();
        comboDecimals = new javax.swing.JComboBox<>();
        btnResetConf = new javax.swing.JButton();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(400, 300));
        getContentPane().setLayout(null);

        labelDateform.setText("Date format:");
        getContentPane().add(labelDateform);
        labelDateform.setBounds(50, 36, 130, 15);

        comboDateform.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "dd/MM/yyyy", "dd-MM-yyyy", "yyyy-MM-dd", "yyyy/MM/dd" }));
        comboDateform.setToolTipText("");
        getContentPane().add(comboDateform);
        comboDateform.setBounds(180, 30, 120, 25);

        labelCurrency.setText("Currency:");
        getContentPane().add(labelCurrency);
        labelCurrency.setBounds(50, 80, 130, 20);

        comboCurrency.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Euro", "Dollar", "Pound" }));
        comboCurrency.setToolTipText("");
        getContentPane().add(comboCurrency);
        comboCurrency.setBounds(180, 79, 120, 25);

        labelLanguage.setText("Language:");
        getContentPane().add(labelLanguage);
        labelLanguage.setBounds(50, 130, 130, 15);

        comboLanguage.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "English", "Spanish", "Valencian" }));
        comboLanguage.setToolTipText("");
        getContentPane().add(comboLanguage);
        comboLanguage.setBounds(180, 130, 120, 25);

        labelFileform.setText("File format:");
        getContentPane().add(labelFileform);
        labelFileform.setBounds(50, 180, 130, 15);

        comboFileform.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "JSON", "TXT", "XML" }));
        comboFileform.setToolTipText("");
        getContentPane().add(comboFileform);
        comboFileform.setBounds(180, 180, 120, 25);

        btnSaveConf.setText("Save");
        btnSaveConf.setToolTipText("");
        getContentPane().add(btnSaveConf);
        btnSaveConf.setBounds(40, 340, 100, 29);

        btnCancelConf.setText("Cancel");
        btnCancelConf.setToolTipText("");
        getContentPane().add(btnCancelConf);
        btnCancelConf.setBounds(260, 340, 105, 29);

        labelTheme.setText("Theme:");
        getContentPane().add(labelTheme);
        labelTheme.setBounds(50, 230, 130, 15);

        comboTheme.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Metal", "Windows", "Motif", "Nimbus", " " }));
        comboTheme.setToolTipText("");
        getContentPane().add(comboTheme);
        comboTheme.setBounds(180, 230, 120, 25);

        labelDecimals.setText("Decimals:");
        getContentPane().add(labelDecimals);
        labelDecimals.setBounds(50, 280, 130, 15);

        comboDecimals.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 decimal", "2 decimals", "3 decimals" }));
        comboDecimals.setToolTipText("Choose the decimal format");
        getContentPane().add(comboDecimals);
        comboDecimals.setBounds(180, 280, 120, 25);

        btnResetConf.setText("Reset");
        btnResetConf.setToolTipText("");
        getContentPane().add(btnResetConf);
        btnResetConf.setBounds(155, 340, 90, 29);

        back.setText("back");
        getContentPane().add(back);
        back.setBounds(0, 0, 30, 15);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel back;
    public static javax.swing.JButton btnCancelConf;
    public static javax.swing.JButton btnResetConf;
    public static javax.swing.JButton btnSaveConf;
    public static javax.swing.JComboBox<String> comboCurrency;
    public static javax.swing.JComboBox<String> comboDateform;
    public static javax.swing.JComboBox<String> comboDecimals;
    public static javax.swing.JComboBox<String> comboFileform;
    public static javax.swing.JComboBox<String> comboLanguage;
    public static javax.swing.JComboBox<String> comboTheme;
    public static javax.swing.JLabel labelCurrency;
    public static javax.swing.JLabel labelDateform;
    public static javax.swing.JLabel labelDecimals;
    public static javax.swing.JLabel labelFileform;
    public static javax.swing.JLabel labelLanguage;
    public static javax.swing.JLabel labelTheme;
    // End of variables declaration//GEN-END:variables
}
