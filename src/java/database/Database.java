/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Rubenhag
 */
public class Database {
    
    private Connection con;
    
    public void closeConnection(){
        System.out.println("Closing databaseconnection");
        Cleanup.closeConnection(con);
    }

    public Connection getConnection() throws Exception {

        String url = "jdbc:derby://localhost:1527/Romolslia";
        String user = "adminsen";
        String password = "adminsen";
        try {
            con = DriverManager.getConnection(url, user, password);
            Calendar cal = new GregorianCalendar();
            System.out.println("Connection established at " + cal.get(Calendar.DATE) + cal.get(Calendar.MONTH) + cal.get(Calendar.YEAR) + "." + cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.MINUTE));
        } catch (SQLException e) {
            Cleanup.writeMessage(e, "getConnection()");
            Cleanup.closeConnection(con);
        }
        return con;
    }
    
    public void getInfo(String isbn){
        
    }
    
    
}
