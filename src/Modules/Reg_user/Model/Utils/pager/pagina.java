package Modules.Reg_user.Model.Utils.pager;


import Modules.Reg_user.Model.Classes.miniSimpleTableModel_ruser;
import Modules.Reg_user.View.Pager_ruser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JRadioButton;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;

public class pagina {

    public static final LinkViewRadioButtonUI ui = new LinkViewRadioButtonUI();
    public static int LR_PAGE_SIZE = 5;
    public static Box box = Box.createHorizontalBox();

    public static int currentPageIndex = 1;
    public static int itemsPerPage = 5;
    public static int maxPageIndex;
    public static String option="user";

    public static void inicializa() {
//        String option="admin";
        int rowCount = 0;
        switch (option) {
            case "user":
                rowCount = ((miniSimpleTableModel_ruser) Modules.Reg_user.View.Pager_ruser.pagerTable.getModel()).getRowCount();
                break;

        }

        int v = rowCount % itemsPerPage == 0 ? 0 : 1;
        
        maxPageIndex = rowCount / itemsPerPage + v;
//        System.out.println("V: "+v+" rowCount: "+rowCount+" itemsPerPage "+itemsPerPage+" maxPageIndex: "+maxPageIndex);
        
        box.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        switch (option) {
            case "user":
                Pager_ruser.pagLinks.setLayout(new BorderLayout());
                Pager_ruser.pagLinks.add(pagina.box);
                break;

        }
    }

    public static void initLinkBox() {
        switch (option) {
            case "user":
                Modules.Reg_user.Controller.RuserController.sorter.setRowFilter(new RowFilter<TableModel, Integer>() {
                    @Override
                    public boolean include(RowFilter.Entry<? extends TableModel, ? extends Integer> entry) {
                        int ti = currentPageIndex - 1;
                        int ei = entry.getIdentifier();
                        return ti * itemsPerPage <= ei && ei < ti * itemsPerPage + itemsPerPage;
                    }
                });
                break;

        }

        int startPageIndex = currentPageIndex - LR_PAGE_SIZE;
        int endPageIndex = 0;
        if (startPageIndex <= 0) {
            startPageIndex = 1;
        }

        int rowCount = 0;
        switch (option) {
            case "user":
                rowCount = ((miniSimpleTableModel_ruser) Modules.Reg_user.View.Pager_ruser.pagerTable.getModel()).getRowCount();
                break;

        }

        int v = rowCount % itemsPerPage == 0 ? 0 : 1;
        maxPageIndex = rowCount / itemsPerPage + v;
        endPageIndex = currentPageIndex + LR_PAGE_SIZE - 1;
        if (endPageIndex > maxPageIndex) {
            endPageIndex = maxPageIndex;
        }

        box.removeAll();
        if ((rowCount <= itemsPerPage) && (rowCount > 0)) { //caben todos los datos en la misma página
            switch (option) {
                case "user":
                    //actualizar botones y caja: desactivarlos
                    Pager_ruser.pagFirst.setEnabled(false);
                    Pager_ruser.pagPrev.setEnabled(false);
                    Pager_ruser.pagLast.setEnabled(false);
                    Pager_ruser.pagNext.setEnabled(false);
                    Pager_ruser.pagBox.setText("");
                    break;

            }
            //actualizar enlaces: sólo 1 enlace
            ButtonGroup bg = new ButtonGroup();
            box.add(Box.createHorizontalGlue());
            JRadioButton c = makeRadioButton(1);
            box.add(c);
            bg.add(c);
            box.add(Box.createHorizontalGlue());
            box.revalidate();
            box.repaint();

        } else if (rowCount == 0) { //no hay rdos
            switch (option) {
                case "user":
                    //actualizar botones y caja: desactivarlos
                    Pager_ruser.pagFirst.setEnabled(false);
                    Pager_ruser.pagPrev.setEnabled(false);
                    Pager_ruser.pagLast.setEnabled(false);
                    Pager_ruser.pagNext.setEnabled(false);
                    Pager_ruser.pagBox.setText("");
                    break;

            }
            //actualizar enlaces: no hay enlaces
            ButtonGroup bg = new ButtonGroup();
            box.add(Box.createHorizontalGlue());
            JRadioButton c = makeRadioButton(0);
            box.add(c);
            bg.add(c);
            box.add(Box.createHorizontalGlue());
            box.revalidate();
            box.repaint();

        } else if (rowCount > itemsPerPage) {
            switch (option) {
                case "user":
                    
                    Pager_ruser.pagFirst.setEnabled(currentPageIndex > 1);
                    Pager_ruser.pagPrev.setEnabled(currentPageIndex > 1);
                    Pager_ruser.pagLast.setEnabled(currentPageIndex < maxPageIndex);
                    Pager_ruser.pagNext.setEnabled(currentPageIndex < maxPageIndex);
                    Pager_ruser.pagBox.setText(Integer.toString(currentPageIndex) + String.format(" / %d", maxPageIndex));
                    break;

            }

            ButtonGroup bg = new ButtonGroup();
            box.add(Box.createHorizontalGlue());
            for (int i = startPageIndex; i <= endPageIndex; i++) {
                JRadioButton c = makeRadioButton(i);
                box.add(c);
                bg.add(c);
            }
            box.add(Box.createHorizontalGlue());
            box.revalidate();
            box.repaint();
        }
    }

    public static JRadioButton makeRadioButton(final int target) {
        JRadioButton radio = new JRadioButton(String.valueOf(target)) {
            @Override
            protected void fireStateChanged() {
                ButtonModel model1 = getModel();
                if (!model1.isEnabled()) {
                    setForeground(Color.GRAY);
                } else if (model1.isPressed() && model1.isArmed()) {
                    setForeground(Color.GREEN);
                } else if (model1.isSelected()) {
                    setForeground(Color.RED);
                }
                super.fireStateChanged();
            }
        };
        radio.setForeground(Color.BLUE);
        radio.setUI(ui);
        if (target == currentPageIndex) {
            radio.setSelected(true);
        }
        radio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPageIndex = target;
                initLinkBox();
            }
        });
        return radio;
    }
}
