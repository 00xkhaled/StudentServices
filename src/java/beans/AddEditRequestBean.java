package beans;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import oracle.sql.TIMESTAMP;
import daos.RequestDao;
import java.text.SimpleDateFormat;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.FlowEvent;
import models.Request;


/**
 *
 * @author Khaled Daoudieh
 * 
 */

@ManagedBean
@Named(value = "addEditRequestBean")
@ViewScoped
public class AddEditRequestBean implements Serializable


{
    
    
    
    private final RequestDao requestdao = new RequestDao();
    private int requestId;
   private String firstname;

    private String lastname;

    private Integer age;

    private String street;

    private String city;

    private String postalCode;

    private String info;

    private String email;

    private String phone;

    private String gender;

    private String ridefrom;

    private String rideto;

    private String time;
    
    
    

    private Date date;
    
    @Inject
    private SessionBean sessionBean;
    
    public AddEditRequestBean() {        
    }
    
    @PostConstruct
    public void init() {
        try {
            requestId = sessionBean.getSelectedItemId();

            if (requestId > 0) {
                Request request = requestdao.getRequest(requestId);
                
              firstname=request.getFirstname();
            lastname=request.getLastname();
             city=request.getCity();
             street=request.getStreet();
            email=request.getEmail();
           phone=request.getPhone();
          gender= request.getGender();
            ridefrom=request.getRidefrom();
             rideto=request.getRideto();
             info=request.getInfo();
           time=request.getTime();

                
                
            }
        } catch (Exception ex) {
            Logger.getLogger(AddEditRidesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getRideid() {
        return requestId;
    }

    public void setRideid(int rideid) {
        this.requestId = rideid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRidefrom() {
        return ridefrom;
    }

    public void setRidefrom(String ridefrom) {
        this.ridefrom = ridefrom;
    }

    public String getRideto() {
        return rideto;
    }

    public void setRideto(String rideto) {
        this.rideto = rideto;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

         

    
       
       
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
    
    
private Request user = new Request();
     
    private boolean skip;
     
    public Request getUser() {
        return user;
    }
 
    public void setUser(Request user) {
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
    
    
    
    
    
     @Inject

        
    public void saveEvent() {
        try {
            
            
            Request request = new Request();
            
            
            
            request.setFirstname(firstname);
            request.setLastname(lastname);
            request.setAge(age);
            request.setCity(city);
            request.setStreet(street);
            request.setPostalCode(postalCode);
            request.setInfo(info);
            request.setEmail(email);
            request.setPhone(phone);
            request.setGender(gender);
            request.setRidefrom(ridefrom);
            request.setRideto(rideto);
            request.setInfo(info);
            
        
            
            if (sessionBean.getSelectedItemId() > 0) {
                requestdao.updaterequest(request);
            } else {
                requestdao.updaterequest(request);
            }
        } catch (Exception ex) {
            Logger.getLogger(AddEditRequestBean.class.getName()).log(Level.SEVERE, null, ex);
        }
         
       
        sessionBean.navigate("view_requests");
    }
}
