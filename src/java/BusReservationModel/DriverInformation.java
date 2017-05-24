
package BusReservationModel;

import java.io.Serializable;
 /*
 * @author Kamal Jabari
 */
public class DriverInformation implements Serializable{

    
    private int driver_id;
    private String driver_name;
    private String phone;
    private String driver_add;
    private String driver_code;
    private String driver_license_no;
    
    
    public int getDriverID(){
        return this.driver_id;
    }
    public void setDriverID(int driver_id){
        this.driver_id=driver_id;
    }
    
     public String getDriverName(){
        return this.driver_name;
    }
    public void setDriverName(String driver_name){
        this.driver_name=driver_name;
    }
    
     public String getPhone(){
        return this.phone;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
    
     public String getDriverAdd(){
        return this.driver_add;
    }
    public void setDriverAdd(String driver_add ){
        this.driver_add=driver_add;
    }
        
     public String getDriverCode(){
        return this.driver_code;
    }
     
     public void setDriverCode(String driver_code){
     this.driver_code=driver_code;
     }
     
      public String getDriverLicenseNo(){
        return this.driver_license_no;
    }
     
     public void setDriverLicenseNo(String driver_license_no){
     this.driver_license_no=driver_license_no;
     }
    
     
    
}


