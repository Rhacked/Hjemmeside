/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package film;

/**
 *
 * @author Rubenhag
 */
public class Movie {
    
    private int movieID;
    private String name;
    private String kategori;
    private int runtime;

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

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }
    
    
    
}
