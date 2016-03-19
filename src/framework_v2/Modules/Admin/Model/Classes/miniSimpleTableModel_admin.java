package framework_v2.Modules.Admin.Model.Classes;
import framework_v2.Classes.Date_class;
import framework_v2.Modules.Admin.Model.Classes.Admin_class;
import framework_v2.Modules.Admin.Model.Classes.Singleton_admin;
import framework_v2.Modules.Admin.Model.Utils.pager.pagina;
import framework_v2.Modules.Admin.View.Pager_admin;
import static framework_v2.Modules.Admin.View.Pager_admin.combo;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;

public class miniSimpleTableModel_admin extends AbstractTableModel {
    public static ArrayList<Admin_class> datos = new ArrayList<Admin_class>();
    public static ArrayList<Admin_class> datosaux = new ArrayList<Admin_class>();
    String[] columnas = {"ID Card", "Name", "Surname", "Cont. date","Salary"};

    
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
        Admin_class fila = (Admin_class) datos.get(row);

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
                dev= fila.getCont_date();
                break;
                
            case 4:
                dev = fila.getSalary();
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
        Admin_class fila = (Admin_class) datos.get(row);

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
                fila.setCont_date(((Date_class) value));
                break;

            case 4:
                fila.setSalary((double)value);
                break;
        }
        fireTableCellUpdated(row, col);
    }

    public void addRow(Admin_class usu) {
        datos.add(usu);
        fireTableDataChanged();
    }

    public void cargar() {
        datos.clear();
        datosaux.clear();
        
        Admin_class admin = null;
        java.util.Date date= new java.util.Date();
        for(int i=0;i<=Singleton_admin.adm.size()-1;i++) {
            admin=Singleton_admin.adm.get(i);
            addRow(admin);
            datosaux.add(admin);
            
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

        String nom=(String) ((JComboBox)combo).getSelectedItem();   
        if(nom!=null){
            for(int i=0;i<datosaux.size();i++) {
                //if(datosaux.get(i).getFirst_name().contains(nom)){
                if(datosaux.get(i).getName().toLowerCase().startsWith(nom.toLowerCase())){
                    addRow(datosaux.get(i));
                    cont++;
                }
            }
            Pager_admin.jLabel3.setText(String.valueOf(cont));
//            System.out.println("word selected: " + nom);
            pagina.initLinkBox();
        }
    }

    public Admin_class buscar(String u) {
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

    public int buscaUsuario(Admin_class u) {
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
          Pager_admin.jLabel3.setText(String.valueOf(datos.size()));
            pagina.initLinkBox();
    }
}
