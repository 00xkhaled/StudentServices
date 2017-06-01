package beans;


/**
 *
 * @author Khaled
 */
import java.text.SimpleDateFormat;
 
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.FlowEvent;
import models.RequestInformation;
 
@ManagedBean
@ViewScoped



public class UserWizard implements Serializable

{
    
    
       @Inject
    private SessionBean sessionBean;
       
       
    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
     
    public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
         
        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    }
 
    private RequestInformation user = new RequestInformation();
     
    private boolean skip;
     
    public RequestInformation getUser() {
        return user;
    }
 
    public void setUser(RequestInformation user) {
        this.user = user;
    }
     
    public void save() {
        
        FacesMessage msg = new FacesMessage("Thanks" + user.getFirstname()+ "please wait for call or comfirmation ");
        
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
                sessionBean.navigate("add_requests");

    }
     
    public boolean isSkip() {
        return skip;
    }
 
    public void setSkip(boolean skip) {
        this.skip = skip;
    }
     
    public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }
}