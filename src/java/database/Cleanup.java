/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Rubenhag
 */
public class Cleanup {
    
    public static void closeResSet(ResultSet res){
        try{
            if(res!=null && !res.isClosed()){
                res.close();
            }
        } catch (SQLException e){
            writeMessage(e, "closeResSet()");
        }
    }

    public static void closeStatement(Statement stm){
        try{
            if(stm!=null && !stm.isClosed()){
                stm.close();
            }
        } catch (SQLException e){
            writeMessage(e,"closeStatement()");
        }
    }
    
    public static void closeConnection(Connection con){
        try{
            if(con!=null && !con.isClosed()){
                con.close();
            }
        } catch (SQLException e){
            writeMessage(e,"closeConnection()");
        }
    }
    
    public static void rollBack(Connection con){
        try{
            if(con!=null && !con.getAutoCommit()){
                con.rollback();
            }
        } catch (SQLException e){
            writeMessage(e,"rollBack()");
        }
    }
    
    public static void setAutoCommit(Connection con){
        try{
            if(con != null && !con.getAutoCommit()){
                con.setAutoCommit(true);
            }
        } catch (SQLException e){
            writeMessage(e,"setAutoCommit()");
        }
    }
    
        public static void writeMessage(Exception e, String message){
        System.err.println("**** Something went wrong: "+message+". ****");
        e.printStackTrace(System.err);
    }
}
