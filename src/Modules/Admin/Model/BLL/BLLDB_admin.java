/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules.Admin.Model.BLL;

import Classes.DBConnection;
import Modules.Admin.Model.DAO.DAOBD_admin;
import com.mysql.jdbc.Connection;

import javax.swing.JOptionPane;

/**
 *
 * @author antonio
 */
public class BLLDB_admin {
  
    
    /**
     * Used to connect to database and add new admin user on it
     * @return a boolean with the result state
     */
    public static boolean newAdminBLL() {

            boolean correct;
            Connection _con = null;

            DBConnection _connection_DB = new DBConnection();

            _con = _connection_DB.OpenConnection();

            correct = DAOBD_admin.newAdmin(_con);

            _connection_DB.CloseConnection((com.mysql.jdbc.Connection) _con);

            return correct;
        }
    

    /**
     * Used to load admin users from database into Array List
     */
    public static void loadAdminBLL() {

            Connection _con = null;
            DBConnection _connection_DB = new DBConnection();

            _con = _connection_DB.OpenConnection();
            DAOBD_admin _adminDAO = new DAOBD_admin();

            try {
                _adminDAO.loadAdmin(_con);//Recuperamos los empleados 

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "An error happened Logger2!");
            }
            _connection_DB.CloseConnection(_con);

        }//End load Admin BLL

    /**
     * Used to connect and modify an Admin user from database
     * @return a boolean with the result state
     */
    public static boolean modifyAdminBLL() {
            boolean correct=false;
            Connection _con;

            DBConnection _connection_DB = new DBConnection();

            _con = _connection_DB.OpenConnection();
            DAOBD_admin _adminDAO = new DAOBD_admin();

            correct=_adminDAO.modifyAdmin(_con);
            _connection_DB.CloseConnection(_con);

            return correct;

        }//End modify Admin BLL

    /**
     * Used to connect and delete an Admin user from database
     * @return a boolean with the result state
     */
    public static boolean deleteAdminBLL() {

        Connection _con;
        boolean correct;

        DBConnection _connection_DB = new DBConnection();

        _con = _connection_DB.OpenConnection();
        DAOBD_admin _adminDAO = new DAOBD_admin();

        correct = _adminDAO.deleteAdmin(_con);
        _connection_DB.CloseConnection(_con);

        return correct;
    }//End delete Admin BLL
    
    /**
     * 
     * @return 
     */
    public static boolean SearchAdminBLL() {

        Connection _con;
         boolean correct;

        DBConnection _connection_DB = new DBConnection();

        _con = _connection_DB.OpenConnection();
        DAOBD_admin _adminDAO = new DAOBD_admin();

        correct = _adminDAO.searchDNI(_con);
        _connection_DB.CloseConnection(_con);

        return correct;
    }

}
