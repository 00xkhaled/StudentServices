package beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @Author: Dr. Firas Al-Hawari
 *
 */
@Named(value = "sessionBean")
@SessionScoped
public class SessionBean implements Serializable {
    private String username;
    private String password;          
    
    public SessionBean() {        
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

    public void login() throws Exception {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        boolean success = true;
        
        try {
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {            
              
        }      
        
        if(success){
            navigate("/car_pooling/car_pooling");
        } 
    }    
    
    public void logout() throws Exception {
        try {
            // Release and close database resources and connections                         
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {            
            setPassword(null);
            setUsername(null);

            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.getExternalContext().invalidateSession();
        }
    }    
    
    public void navigate(String url) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
         
        if (facesContext != null) {
            NavigationHandler navigationHandler = facesContext.getApplication().getNavigationHandler();
            navigationHandler.handleNavigation(facesContext, null, url + "?faces-redirect=true");
        }
    } 
}