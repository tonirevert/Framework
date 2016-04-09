/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules.Dummy.Classes;

import Classes.DBConnection;
import Classes.Date_class;
import Modules.Admin.Model.Classes.Admin_class;
import Modules.Admin.Model.Classes.Singleton_admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author antonio
 */
public class DB_Dummy {
    
    public static void cargarAdmin(){
        Connection _con = null;
        DBConnection _conexion_DB = new DBConnection();
        PreparedStatement stmt = null;
        int resultado = 0;

        String [] testdni={"12345678Z","48722473D","28554926N","26599039E","42470829H","32648520C","48520326D","28485527G","33582562D","21059874Q"};
        String [] testnames={"Antonio","Jose","Pepe","Marta","Manuel","Andreu","Angela","Jorge","Felipe","Iñaki"};
        String [] testsur={"Revert","Gonzalez","Fernandez","Moran","Sanchis","Tormo","Valls","Hinojosa","Calabuig","Bertomeu"};
        String [] birthdates={"24/05/1981","22/03/1987","23/02/1983","12/04/1973","20/05/1985","20/12/1986","14/03/1980","23/07/1989","25/11/1978","29/12/1977"};
        String [] testmobile={"34650936114","34625896321","34632548985","34962388320","34962383904","34676025489","34696201458","34702963218","34620859624","34624125951"};
        String [] testmail={"test@test.com","test@test.com","test@test.com","test@test.com","test@test.com","test@test.com","test@test.com","test@test.com","test@test.com","test@test.com"};
        String [] testuname={"Thorin","Glados","Frodo","Test4","Test5","Test6","Test7","Test8","Test9","Test10"};
        String [] testpasswd={"1Grñfkei35","1Grñfkei35","1Grñfkei35","1Grñfkei35","1Grñfkei35","1Grñfkei35","1Grñfkei35","1Grñfkei35","1Grñfkei35","1Grñfkei35"};
        String [] testavatar={"avatar","avatar","avatar","avatar","avatar","avatar","avatar","avatar","avatar","avatar"};
        String [] contdates={"13/01/2016","20/04/2014","23/02/2000","27/09/2011","29/11/2015","20/01/2012","20/03/2014","25/03/2008","24/05/2009","26/07/2009"};
        boolean[] testboolean={true,false,false,true,true,true,false,true,true,false};
        String karma="";
        int men=0;
        int state=0;
        int result;
        _con = _conexion_DB.OpenConnection();
        
        try{
        for (int i = 0; i < 9; i++) {
            Admin_class admin = new Admin_class(testdni[i],testnames[i],testsur[i],new Date_class(birthdates[i]),testmobile[i],testmail[i],testuname[i],testpasswd[i],testavatar[i],testboolean[i],new Date_class(contdates[i]),30);
            if(admin.isState()==true){
                state=1;
            }else{
                state=0;
            }
            stmt = _con.prepareStatement("INSERT INTO prog.admin"
                    + "(dni, name, surname, date_birthday, mobile, email, user, password, avatar, state, age, benefit, date_contract, antiquity, salary, activity)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            stmt.setString(1, admin.getDni());
            stmt.setString(2, admin.getName());
            stmt.setString(3, admin.getSurname());
            stmt.setString(4, admin.getBirthday().toString());
            stmt.setString(5, admin.getMobile());
            stmt.setString(6, admin.getEmail());
            stmt.setString(7, admin.getUser());
            stmt.setString(8, admin.getPass());
            stmt.setString(9, admin.getAvatar());
            stmt.setInt(10, state);
            stmt.setInt(11,admin.getAge());
            stmt.setFloat(12, (float)admin.calc_benefit());
            stmt.setString(13, admin.getCont_date().toString());
            stmt.setInt(14, admin.getAntiquity());
            stmt.setFloat(15,(float)admin.calc_salary());
            stmt.setString(16, String.valueOf(admin.getActivity()));

            result=stmt.executeUpdate();
            System.out.println(result);
        }
        _conexion_DB.CloseConnection((com.mysql.jdbc.Connection) _con);
        
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ha habido un problema al insertar un nuevo usuario!");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Ha habido un error Logger!");
                }
            }
        }
    }//End cargar Admin
    
    
    public static void loadAdminArray(){
        Connection _con = null;
        DBConnection _conexion_DB = new DBConnection();
        PreparedStatement stmt = null;
        int state=0;
        int result=0;
        
        
        _con = _conexion_DB.OpenConnection();
        
        try{
        for(int i=0;i<=Singleton_admin.adm.size()-1;i++){
            
             Admin_class admin =Singleton_admin.adm.get(i);
            if(admin.isState()==true){
                state=1;
            }else{
                state=0;
            }
            stmt = _con.prepareStatement("INSERT INTO prog.admin"
                    + "(dni, name, surname, date_birthday, mobile, email, user, password, avatar, state, age, benefit, date_contract, antiquity, salary, activity)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            stmt.setString(1, admin.getDni());
            stmt.setString(2, admin.getName());
            stmt.setString(3, admin.getSurname());
            stmt.setString(4, admin.getBirthday().toString());
            stmt.setString(5, admin.getMobile());
            stmt.setString(6, admin.getEmail());
            stmt.setString(7, admin.getUser());
            stmt.setString(8, admin.getPass());
            stmt.setString(9, admin.getAvatar());
            stmt.setInt(10, state);
            stmt.setInt(11,admin.getAge());
            stmt.setFloat(12, (float)admin.calc_benefit());
            stmt.setString(13, admin.getCont_date().toString());
            stmt.setInt(14, admin.getAntiquity());
            stmt.setFloat(15,(float)admin.calc_salary());
            stmt.setString(16, String.valueOf(admin.getActivity()));

            stmt.executeUpdate();
            result=result+1;
        }
        _conexion_DB.CloseConnection((com.mysql.jdbc.Connection) _con);
            JOptionPane.showMessageDialog(null, "Inserted: "+result+"users to database correctly!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ha habido un problema al insertar un nuevo usuario!");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Ha habido un error Logger!");
                }
            }
        }
        
}
    
}
