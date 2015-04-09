/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import user.User;
import user.UserBean;

/**
 *
 * @author Rubenhag
 */
@Named("loginBean")
@SessionScoped
public class LoginBean implements Serializable{
    public String username;
    public String password;
    
    private boolean loggedIn;
    
    @Inject
    private NavigationBean navigationBean;
    
    /**
     * Login operation
     */

    public String doLogin(){
        UserBean userBean = new UserBean();
        List<User> userList = userBean.getUsers();
        for(int i = 0; i<userList.size();i++){
            System.out.println("Username from DB: "+userList.get(i).getUsername()+" Username from bean:"+getUsername());
            if(userList.get(i).getUsername().equals(username) && userList.get(i).getPassword().equals(password)){
                loggedIn = true;
                return navigationBean.redirectToIndex();
            }
        }
        FacesMessage msg = new FacesMessage("Login error!","ERROR MSG");
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage(null, msg);
        if(navigationBean!=null){
            return navigationBean.toLogin();
        }
        
        return "NavigationBean is null";
    }

    /**
     * Logout operation
     * @return 
     */
    
    public String doLogout(){
        loggedIn = false;
        
        FacesMessage msg = new FacesMessage("Logout successfu!","INFO MSG");
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
        return navigationBean.toLogin();
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public NavigationBean getNavigationBean() {
        return navigationBean;
    }

    public void setNavigationBean(NavigationBean navigationBean) {
        this.navigationBean = navigationBean;
    }
     
     
}
