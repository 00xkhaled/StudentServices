/**
 *
 * @author Evilopeth
 */



package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Inject;
import daos.AvailableRequestsDao;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import models.AvailableRequests;

@Named(value = "availableRequestsBean")
@SessionScoped


public class AvailableRequestsBean implements Serializable {
    
    
    
    private int requests_id;
    private String requests_from;
    private String requests_to;
    private String name;
    private String phone;
    private String leaving_time;
    
    private AvailableRequests selectedRequest;
    
    private final AvailableRequestsDao requestsdao=new AvailableRequestsDao();
    
    
    private ArrayList<AvailableRequests> list;
    
     @Inject
    private SessionBean sessionBean;
     
    public AvailableRequestsBean(){
        init();
    
    }
    
     @PostConstruct
    public void init(){
      
       try {            
            list = requestsdao.buildevents();            
        } catch (Exception ex) {
            Logger.getLogger(AvailableRequestsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
 
    public void add_request()
    {
         try 
         { 
             
        AvailableRequests insertRequest = new AvailableRequests();
        
        insertRequest.setRequestFrom(requests_from);
        insertRequest.setRequestTo(requests_to);
        insertRequest.setName(name);
        insertRequest.setPhone(phone);
        insertRequest.setLeavingTime(leaving_time);
        
        
        System.out.print("reachecd Available Requests Bean requestsDao()");
        
        requestsdao.insertrequest(insertRequest);    
        
        } 
         
         catch (Exception ex)
         {
            Logger.getLogger(AvailableRequestsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        sessionBean.navigate("view_requests");
       
    }
    
    public String getRequestID(){
        return Integer.toString(this.requests_id);
    }
    public void setRequestID(String request_id){
        this.requests_id=Integer.parseInt(request_id);
    }
    public AvailableRequests getSelectedRequest() {
        return selectedRequest;
    }
    public void setSelectedRequest(AvailableRequests selectedRequests) {
        this.selectedRequest = selectedRequests;
    }     
    
     public String getRequestFrom(){
        return this.requests_from;
    }
    public void setRequestFrom(String request_from){
        this.requests_from=request_from;
    }
    
     public String getRequestTo(){
        return this.requests_to;
    }
    public void setRequestTo(String request_to){
        this.requests_to=request_to;
    }
    
     public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
    
     public String getPhone(){
        return this.phone;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
    
     public String getLeavingTime(){
        return this.leaving_time;
    }
    public void setLeavingTime(String leaving_time){
        this.leaving_time=leaving_time;
    }
    
    public void saveSelectedItemId(){
        sessionBean.setSelectedItemId(selectedRequest.getRequestID());
    }

    public ArrayList<AvailableRequests> getList() {
        return list;
    }

    public void setList(ArrayList<AvailableRequests> list) {
        this.list = list;
    }
    
    
}
