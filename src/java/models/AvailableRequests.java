/*
 * @author Evilopeth
 */

package models;
import java.io.Serializable;
 

// Avaliabe requests model 

public class AvailableRequests implements Serializable{
   
    
    
    private int request_id;
    private String name;
    private String phone;

    private String requests_from;
    private String requests_to;
    
    private String leaving_time;
   
   
    
    
    public int getRequestID(){
        return this.request_id;
    }
    public void setRequestID(int request_id){
        this.request_id=request_id;
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
   
     public String getLeavingTime(){
        return this.leaving_time;
    }
    public void setLeavingTime(String leaving_time){
        this.leaving_time=leaving_time;
    }
    

}


