/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import com.mysql.jdbc.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author antonio
 */
public class DBConnection {
    
    /**
     * Opens a connection to database
     * @return a connection to database
     */
    public Connection OpenConnection() {

        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String urlOdbc = "jdbc:mysql://127.0.0.1:3306/prog";
            con = (Connection) (java.sql.DriverManager.getConnection(urlOdbc, "root", "12345"));
            
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ha sido imposible establecer la conexion!");
        }
        return con;
    }

    /**
     * Closes a connection to database 
     * @param con is the connection to close
     */
    public void CloseConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Ha sido imposible cerrar la conexion!");
        }
    }
}
