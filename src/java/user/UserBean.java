/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import enkrypt.Encryption;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name="user")
@SessionScoped

public class UserBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private int userID;
    private String username;
    private String first_name;
    private String last_name;
    private String password;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    public String newUser(){
        Encryption enc = new Encryption();
        byte[] pw = enc.encrypt(password);
        PreparedStatement pst = null;
        Connection con = getConnection();
        String stm ="INSERT INTO users(username, first_name, last_name, password) VALUES(?,?,?,?)";
        try{
            pst = con.prepareStatement(stm);
            pst.setString(1, username);
            pst.setString(2,first_name);
            pst.setString(3,last_name);
            pst.setString(4, password);
            pst.executeUpdate();
            System.out.println("Data added successfully");
            con.close();
            pst.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return "database";
    }
   
    public List<User> getUsers(){
        Encryption enc = new Encryption();
        ResultSet res = null;
        PreparedStatement pst = null;
        Connection con = getConnection();
        String stm = "Select * from users";
        List<User> rec =  new ArrayList<User>();
        try{
            pst = con.prepareStatement(stm);
            pst.executeQuery();
            res = pst.getResultSet();
            
            while(res.next()){
                User user = new User();
                user.setUserID(res.getInt(1));
                user.setUsername(res.getString(2));
                user.setFirst_name(res.getString(3));
                user.setLast_name(res.getString(4));
                user.setPassword(res.getString(5));
                rec.add(user);
            }
            con.close();
            pst.close();
            
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        
        return rec;
        }

    
    public Connection getConnection(){
        Connection con = null;
        
        String url = "jdbc:derby://localhost:1527/Romolslia";
        String user = "adminsen";
        String password = "adminsen";
        try{
            con = DriverManager.getConnection(url, user, password);
                        Calendar cal = new GregorianCalendar();
            System.out.println("Connection completed "+cal.get(Calendar.DAY_OF_WEEK)+" "+cal.get(Calendar.MONTH)+" "+cal.get(Calendar.YEAR));
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        finally {
            
        }
        return con;
    }
    
    private String byteToString(byte[] byt){
        return new String(byt);
    }
}