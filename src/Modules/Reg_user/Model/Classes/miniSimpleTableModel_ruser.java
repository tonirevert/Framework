package Modules.Reg_user.Model.Classes;
import Classes.Singleton_app;
import static Modules.Reg_user.Controller.RuserController.comboRuser;
import Modules.Reg_user.Model.BLL.BLL_ruser;
import Modules.Reg_user.Model.Utils.pager.pagina;
import Modules.Reg_user.View.Pager_ruser;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;

public class miniSimpleTableModel_ruser extends AbstractTableModel {
    public static ArrayList<Reg_user_class> datos = new ArrayList<Reg_user_class>();
    public static ArrayList<Reg_user_class> datosaux = new ArrayList<Reg_user_class>();
    String[] columnas = {Singleton_app.lang.getProperty("min_idcard"),Singleton_app.lang.getProperty("min_name"),
        Singleton_app.lang.getProperty("min_surname"), Singleton_app.lang.getProperty("min_activt"),"Karma"};

    
    ////////////////////estos métodos son necesarios para que jtable funcione/////////////////////
    @Override
    public String getColumnName(int col) {
        return columnas[col].toString();
    }

    //Devuelve el numero de filas
    @Override
    public int getRowCount() {
        return datos.size();
    }

    //Devuelve el numero de columnas
    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    //Devuelve el valor del objeto en la fila y columna
    @Override
    public Object getValueAt(int row, int col) {

        Object dev = null;
        Reg_user_class fila = (Reg_user_class) datos.get(row);

        switch (col) {
            case 0:
                dev = fila.getDni();
                break;

            case 1:
                dev = fila.getName();
                break;

            case 2:
                dev = fila.getSurname();
                break;

            case 3:
                dev= fila.getActivity();
                break;
                
            case 4:
                dev = fila.getKarma();
                break;

        }
        return dev;
    }

    //Determina si una fila y columna ha de ser editable
    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    //Actualiza un objeto de una fila y columna
    @Override
    public void setValueAt(Object value, int row, int col) {
        Reg_user_class fila = (Reg_user_class) datos.get(row);

        switch (col) {
            case 0:
                fila.setDni(value.toString());
                break;

            case 1:
                fila.setName(value.toString());
                break;

            case 2:
                fila.setSurname(value.toString());
                break;
            
            case 3:
                fila.setActivity((int)value);
                break;

            case 4:
                fila.setKarma((String) value);
                break;
        }
        fireTableCellUpdated(row, col);
    }

    public void addRow(Reg_user_class usu) {
        datos.add(usu);
        fireTableDataChanged();
    }

    public void cargar() {
        datos.clear();
        datosaux.clear();
        Singleton_ruser.rus.clear();
        BLL_ruser.autoloadRuser();
        
        Reg_user_class ruser = null;
        java.util.Date date= new java.util.Date();
        for(int i=0;i<=Singleton_ruser.rus.size()-1;i++) {
            ruser=Singleton_ruser.rus.get(i);
            addRow(ruser);
            datosaux.add(ruser);
            
            try {
                Thread.sleep(1); //1 milliseconds
            } catch (Exception e) {
              System.out.println(e);
            }
        }
    }

    public void filtrar() {
        datos.clear();
        int cont=0;

        String name=(String) ((JComboBox)comboRuser).getSelectedItem();
        
        switch(Pager_ruser.comboSearch.getSelectedIndex()){
            case 0:
                if(name!=null){
                    for(int i=0;i<datosaux.size();i++) {
                        if(datosaux.get(i).getDni().startsWith(name.toLowerCase())){
                            addRow(datosaux.get(i));
                            cont++;
                        }
                    }
                    Pager_ruser.pagAmount.setText(String.valueOf(cont));
                    pagina.initLinkBox();
                }                
                break;
                
            case 1:
                if(name!=null){
                    for(int i=0;i<datosaux.size();i++) {
                        if(datosaux.get(i).getName().toLowerCase().startsWith(name.toLowerCase())){
                            addRow(datosaux.get(i));
                            cont++;
                        }
                    }
                    Pager_ruser.pagAmount.setText(String.valueOf(cont));
                    pagina.initLinkBox();
                }
                break;
                
            case 2:
                if(name!=null){
                    for(int i=0;i<datosaux.size();i++) {
                        if(datosaux.get(i).getSurname().toLowerCase().startsWith(name.toLowerCase())){
                            addRow(datosaux.get(i));
                            cont++;
                        }
                    }
                    Pager_ruser.pagAmount.setText(String.valueOf(cont));
                    pagina.initLinkBox();
                }
                break;
        }//End switch / case
    }//End filtrar

    public void filtrarB(){
        datos.clear();
        int cont=0;
        
        String name=(String)((JComboBox)comboRuser).getSelectedItem();
        if(name!=null){
            for(int i=0;i<datosaux.size();i++){
                if(datosaux.get(i).getName().toLowerCase().startsWith(name.toLowerCase())){
                    addRow(datosaux.get(i));
                    cont++;
                }
            }
        }
    }
    
    public Reg_user_class buscar(String u) {
        datos.clear();
        cargar();

        String res;
        for (int i = 0; i < datos.size(); i++) {
            res = datos.get(i).toString();
            if (res.contains(u)) {
                return datos.get(i);
            }
        }
        return null;
    }

    public int buscaUsuario(Reg_user_class u) {
        datos.clear();
        cargar();

        for (int i = 0; i < datos.size(); i++) {
            if (datos.get(i).equals(u)) {
                return i;
            }
        }
        return -1;
    }

    public void removeRow(int fila) {
        datos.remove(fila);
        fireTableDataChanged();
          Pager_ruser.pagAmount.setText(String.valueOf(datos.size()));
            pagina.initLinkBox();
    }
}
