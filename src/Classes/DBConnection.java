/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import static Classes.Singleton_app.dataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

/**
 *Used to connect and disconnect to/from database
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
    
    /**
     * Initialize the connections configuration
     */
    public static void init_BasicDataSourceFactory() {
        Properties propiedades = new Properties();
        /*
        setMaxActive(): Nº máx de conexiones que se pueden abrir simultáneamente.
        setMinIdle(): Nº mín de conexiones inactivas que queremos que haya. Si el nº de conexiones baja de este nº, se abriran más.
        setMaxIdle(): Nº máx de conexiones inactivas que queremos que haya. Si hay más, se irán cerrando.
        */
        propiedades.setProperty("driverClassName", "com.mysql.jdbc.Driver");
        propiedades.setProperty("url", "jdbc:mysql://localhost:3306/prog");
        propiedades.setProperty("maxActive", "10");
        propiedades.setProperty("maxIdle", "8");
        propiedades.setProperty("minIdle", "0");
        propiedades.setProperty("maxWait", "500");
        propiedades.setProperty("initialSize", "5");
        propiedades.setProperty("defaultAutoCommit", "true");
        propiedades.setProperty("username", "root");
        propiedades.setProperty("password", "12345");
        propiedades.setProperty("validationQuery", "select 1");
        propiedades.setProperty("validationQueryTimeout", "100");
        propiedades.setProperty("initConnectionSqls", "SELECT 1;SELECT 2");
        propiedades.setProperty("poolPreparedStatements", "true");
        propiedades.setProperty("maxOpenPreparedStatements", "10");
        
        try {
            dataSource = (BasicDataSource) BasicDataSourceFactory.createDataSource(propiedades);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    /**
     * Used to get a connection from database init
     * @return a connection to database
     */
    public static Connection getConnection() {
        Connection connection=null;
        
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
        return connection;
    }
    
    /**
     * Used to release connection
     * @param connection is the connection to release
     */
    public static void releaseConnection(Connection connection) {
        try {
            if (null != connection) 
                // En realidad no cierra, solo libera la conexion.
                connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    
}
