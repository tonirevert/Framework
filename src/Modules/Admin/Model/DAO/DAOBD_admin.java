/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules.Admin.Model.DAO;

import Classes.Date_class;
import Modules.Admin.Model.Classes.Admin_class;
import Modules.Admin.Model.Classes.Singleton_admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author antonio
 */
public class DAOBD_admin {
    
    
    /**
     * Used to add a new Admin user to the MySQL database
     * @param con to get a connection from BLLDB_admin
     * @return int value 1 if process is correct 0 if not
     */
    public static boolean newAdmin(Connection con){
        
        PreparedStatement stmt = null;
        boolean correct=false;
        int state=0;
        
        try{
        
        stmt= con.prepareStatement("INSERT INTO prog.admin"
                    + "(dni, name, surname, date_birthday, mobile, email, user, password, avatar, state, age, benefit, date_contract, antiquity, salary, activity)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        
            if(Singleton_admin.a.isState()==true){
                state=1;
            }else{
                state=0;
            }
        
            stmt.setString(1, Singleton_admin.a.getDni());
            stmt.setString(2, Singleton_admin.a.getName());
            stmt.setString(3, Singleton_admin.a.getSurname());
            stmt.setString(4, Singleton_admin.a.getBirthday().toString());
            stmt.setString(5, Singleton_admin.a.getMobile());
            stmt.setString(6, Singleton_admin.a.getEmail());
            stmt.setString(7, Singleton_admin.a.getUser());
            stmt.setString(8, Singleton_admin.a.getPass());
            stmt.setString(9, Singleton_admin.a.getAvatar());
            stmt.setInt(10, state);
            stmt.setInt(11,Singleton_admin.a.getAge());
            stmt.setFloat(12, (float)Singleton_admin.a.calc_benefit());
            stmt.setString(13, Singleton_admin.a.getCont_date().toString());
            stmt.setInt(14, Singleton_admin.a.getAntiquity());
            stmt.setFloat(15,(float)Singleton_admin.a.calc_salary());
            stmt.setString(16, String.valueOf(Singleton_admin.a.getActivity()));

            correct=stmt.execute();
        
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Problem saving user");
        } finally{
            if(stmt==null){
                try{
                    stmt.close();
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, "Problems with logger!");
                }
            }
        }
        
        return correct;
    }//End of new Admin
    
    /**
     * Used to load admin users from the MySQL database into the Array list
     * @param con to get a connection from BLLDB_admin
     */
    public void loadAdmin(Connection con){
        
        ResultSet rs=null;
        boolean state=false;
        PreparedStatement stmt=null;
        Singleton_admin.adm.clear();
        
        try{
            stmt=con.prepareStatement("SELECT * FROM prog.admin");
            rs=stmt.executeQuery();
            
            Admin_class admin=null;
            
            while(rs.next()){
                
                if(rs.getInt("state")==0){
                    state=true;
                }else{
                    state=false;
                }
                
                admin=new Admin_class();
                admin.setDni(rs.getString("dni"));
                admin.setName(rs.getString("name"));
                admin.setSurname(rs.getString("surname"));
                admin.setBirthday(new Date_class(rs.getString("date_birthday")));
                admin.setMobile(rs.getString("mobile"));
                admin.setEmail(rs.getString("email"));
                admin.setUser(rs.getString("user"));
                admin.setPass(rs.getString("password"));
                admin.setAvatar(rs.getString("avatar"));
                admin.setState(state);
                admin.setAge(rs.getInt("age"));
                admin.setBenefit(rs.getFloat("benefit"));
                admin.setCont_date(new Date_class(rs.getString("date_contract")));
                admin.setAntiquity(rs.getInt("antiquity"));
                admin.setSalary(rs.getFloat("salary"));
                admin.setActivity(rs.getInt("activity"));
                
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Problems loading users!");
        } finally{
            if(stmt==null){
                try{
                    stmt.close();
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, "Problems with logger!");
                }
            }
        }
    }//End of load Admin
    
    /**
     * Used to modify one admin user into the MySQL database
     * @param con to get a connection from BLLDB_admin
     * @return a boolean with the result
     */
    public boolean modifyAdmin(Connection con){
        
        boolean correct=false;
        PreparedStatement stmt = null;
        int state=0;
        
        try{
        
        stmt= con.prepareStatement("UPDATE prog.admin SET dni=?, name=?, surname=?, date_birthday=?, mobile=?, "
                    + "email=?, user=?, password=?, avatar=?, state=?, age=?, benefit=?, date_contract=?, antiquity=?, salary=?, activity=?,"
                    + "WHERE dni=?");
        
            if(Singleton_admin.a.isState()==true){
                state=1;
            }else{
                state=0;
            }
        
            stmt.setString(1, Singleton_admin.a.getDni());
            stmt.setString(2, Singleton_admin.a.getName());
            stmt.setString(3, Singleton_admin.a.getSurname());
            stmt.setString(4, Singleton_admin.a.getBirthday().toString());
            stmt.setString(5, Singleton_admin.a.getMobile());
            stmt.setString(6, Singleton_admin.a.getEmail());
            stmt.setString(7, Singleton_admin.a.getUser());
            stmt.setString(8, Singleton_admin.a.getPass());
            stmt.setString(9, Singleton_admin.a.getAvatar());
            stmt.setInt(10, state);
            stmt.setInt(11,Singleton_admin.a.getAge());
            stmt.setFloat(12, (float)Singleton_admin.a.calc_benefit());
            stmt.setString(13, Singleton_admin.a.getCont_date().toString());
            stmt.setInt(14, Singleton_admin.a.getAntiquity());
            stmt.setFloat(15,(float)Singleton_admin.a.calc_salary());
            stmt.setString(16, String.valueOf(Singleton_admin.a.getActivity()));
            
            stmt.setString(17, Singleton_admin.a.getDni());
            correct=stmt.execute();
                            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Problem saving user");
        } finally{
            if(stmt==null){
                try{
                    stmt.close();
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, "Problems with logger!");
                }
            }
        }
        
        return correct;
        
    }//End of modify Admin
    
    /**
     * Used to delete an Admin user from the MySQL database
     * @param con to get a connection from BLLDB_admin
     * @return a boolean with the result
     */
    public boolean deleteAdmin(Connection con){
        boolean correct=false;
        PreparedStatement stmt=null;
        
        try{
            stmt=con.prepareStatement("DELETE FROM prog.admin WHERE dni=?");
            stmt.setString(1,Singleton_admin.a.getDni());
            stmt.executeUpdate();
            correct=true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error deleting user!");
            correct=false;
        } finally{
            if(stmt==null){
                try{
                    stmt.close();
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, "Problems with logger!");
                    correct=false;
                }
            }
        }
        
        return correct;
        
    }//End of delete Admin
    
    /**
     * Used to search an Admin user from the MySQL database using their DNI
     * @param con to get a connection from BLLDB_admin
     * @return a boolean with the result
     */
    public boolean searchDNI(Connection con){
        boolean correct=false;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        
        try{
            stmt=con.prepareStatement("SELECT * FROM prog.admin WHERE dni=?");
            stmt.setString(1,Singleton_admin.a.getDni());
            rs=stmt.executeQuery();
            
            while(rs.next()){
                
                obtainAdmin(rs);
            }
            correct=true;
                    
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Problems searching admin user!");
        }
        
        
        return correct;
    }//End of search DNI
    
    /**
     * 
     * @param rs 
     */
    private void obtainAdmin(ResultSet rs){
        boolean state=false;
        
        try{
            
                if(rs.getInt("state")==0){
                    state=true;
                }else{
                    state=false;
                }
                Singleton_admin.a.setDni(rs.getString("dni"));
                Singleton_admin.a.setName(rs.getString("name"));
                Singleton_admin.a.setSurname(rs.getString("surname"));
                Singleton_admin.a.setBirthday(new Date_class(rs.getString("date_birthday")));
                Singleton_admin.a.setMobile(rs.getString("mobile"));
                Singleton_admin.a.setEmail(rs.getString("email"));
                Singleton_admin.a.setUser(rs.getString("user"));
                Singleton_admin.a.setPass(rs.getString("password"));
                Singleton_admin.a.setAvatar(rs.getString("avatar"));
                Singleton_admin.a.setState(state);
                Singleton_admin.a.setAge(rs.getInt("age"));
                Singleton_admin.a.setBenefit(rs.getFloat("benefit"));
                Singleton_admin.a.setCont_date(new Date_class(rs.getString("date_contract")));
                Singleton_admin.a.setAntiquity(rs.getInt("antiquity"));
                Singleton_admin.a.setSalary(rs.getFloat("salary"));
                Singleton_admin.a.setActivity(rs.getInt("activity"));
                
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Logger error!");
        }
    }
    
}
