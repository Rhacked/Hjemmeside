/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package film;

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

import database.Cleanup;

/**
 *
 * @author Rubenhag
 */
@ManagedBean(name="movie")
@SessionScoped
public class MovieBean implements Serializable {

    private int movieID;
    private String name;
    private int runtime;
    private String kategori;

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
    
    public String newMovie(){
        int i = 0;
        PreparedStatement pst;
        Connection con = getConnection();
        String stm ="INSERT INTO movie(name, kategori, runtime) VALUES(?,?,?)";
        try{
            pst = con.prepareStatement(stm);
            pst.setString(1, name);
            pst.setString(2, kategori);
            pst.setInt(3, runtime);
            i = pst.executeUpdate();
            System.out.println("Data added successfully");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        } finally {
            Cleanup.closeConnection(con);
        }
        return "database";
    }
    
    public List<Movie> getMovies(){
        ResultSet res = null;
        PreparedStatement pst = null;
        Connection con = getConnection();
        String stm = "Select * from movie";
        List<Movie> rec =  new ArrayList<Movie>();
        try{
            pst = con.prepareStatement(stm);
            pst.executeQuery();
            res = pst.getResultSet();
            
            while(res.next()){
                Movie movie = new Movie();
                movie.setMovieID(res.getInt(1));
                movie.setName(res.getString(2));
                movie.setKategori(res.getString(3));
                movie.setRuntime(res.getInt(4));
                rec.add(movie);
            }
            
            con.close();
            pst.close();
            res.close();
        } catch (SQLException e){
            System.out.println("Denne SQLExceptionen");
            System.out.println(e.getMessage());
        }
        return rec;
    }

    public Connection getConnection() {
        Connection con = null;

        String url = "jdbc:derby://localhost:1527/Romolslia";
        String user = "adminsen";
        String password = "adminsen";
        try {
            con = DriverManager.getConnection(url, user, password);
            Calendar cal = new GregorianCalendar();
            System.out.println("Connection established at " + cal.get(Calendar.DATE) + cal.get(Calendar.MONTH) + cal.get(Calendar.YEAR) + "." + cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.MINUTE));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return con;
    }
}
