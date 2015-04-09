/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Rubenhag
 */
@ManagedBean(name="navigationBean")
@SessionScoped
public class NavigationBean implements Serializable {
    
    private static final long serialVersionUID = 1520318172495977648L;
    
    /**
     * Redirect to login page.
     * @return Login page name.
     */
    public String redirectToLogin(){
        return "login.xhtml?faces-redirect=true";
    }
    
    /**
     * Go to login page.
     * @return Login page name.
     */
    public String toLogin(){
        return "login";
    }
    
    /**
     * Redirect to index page.
     * @return index page name.
     */
    public String redirectToIndex(){
        return "index";
    }
    
    public String toIndex(){
        return "/index.xhtml?faces-redirect=true";
    }
    
    public String redirectToWelcome(){
        return "Database/welcome.xhtml?faces-redirect=true";
    }
    
    public String toWelcome(){
        return "/Database/welcome.xhtml";
    }
}
