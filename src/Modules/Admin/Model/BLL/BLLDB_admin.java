/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules.Admin.Model.BLL;

import Classes.DBConnection;
import Modules.Admin.Model.DAO.DAOBD_admin;
import java.sql.Connection;


import javax.swing.JOptionPane;

/**
 * BLL to handle the actions with database
 * @author antonio
 */
public class BLLDB_admin {
  
    
    /**
     * Used to connect to database and add new admin user on it
     * @return a boolean with the result state
     */
    public static boolean newAdminBLL() {

            boolean correct;
            Connection con = null;

            con=DBConnection.getConnection();

            correct = DAOBD_admin.newAdmin(con);

            DBConnection.releaseConnection(con);
//            System.out.println(correct);
            return correct;
        }
    

    /**
     * Used to load admin users from database into Array List
     */
    public static void loadAdminBLL() {

            Connection con = null;

            con=DBConnection.getConnection();
            
            DAOBD_admin _adminDAO = new DAOBD_admin();

            try {
                _adminDAO.loadAdmin(con);//Recuperamos los empleados 

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "An error happened Logger2!");
            }

            DBConnection.releaseConnection(con);

        }//End load Admin BLL

    /**
     * Used to connect and modify an Admin user from database
     * @return a boolean with the result state
     */
    public static boolean modifyAdminBLL() {
            boolean correct=false;
            Connection con=null;

            con=DBConnection.getConnection();
            
            DAOBD_admin _adminDAO = new DAOBD_admin();

            correct=_adminDAO.modifyAdmin(con);

            DBConnection.releaseConnection(con);
            
            return correct;

        }//End modify Admin BLL

    /**
     * Used to connect and delete an Admin user from database
     * @return a boolean with the result state
     */
    public static boolean deleteAdminBLL() {

        Connection con;
        boolean correct;

        con=DBConnection.getConnection();
        
        DAOBD_admin _adminDAO = new DAOBD_admin();

        correct = _adminDAO.deleteAdmin(con);
        
        DBConnection.releaseConnection(con);

        return correct;
    }//End delete Admin BLL
    
    /**
     * Used to search an Admin user from database
     * @return a boolean with the result state
     */
    public static boolean SearchAdminBLL() {

        Connection con;
         boolean correct;

        con=DBConnection.getConnection();
        
        DAOBD_admin _adminDAO = new DAOBD_admin();

        correct = _adminDAO.searchDNI(con);
//        System.out.println("correct: " +correct);
        DBConnection.releaseConnection(con);

        return correct;
    }

}
