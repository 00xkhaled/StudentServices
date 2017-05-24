
package BusReservationModel;

import java.io.Serializable;
 /*
 * @author Kamal Jabari
 */
public class BusInformation implements Serializable{

    
    private int bus_id;
    private String bus_number;
    private String bus_type;
    private String bus_capacity;
    private String driver_id;
    private String plate_no;
    
    public int getBusID(){
        return this.bus_id;
    }
    public void setStudentID(int bus_id){
        this.bus_id=bus_id;
    }
    
     public String getBusNumber(){
        return this.bus_number;
    }
    public void setBusNumber(String bus_number){
        this.bus_number=bus_number;
    }
    
     public String getBusType(){
        return this.bus_type;
    }
    public void setBusType(String phone){
        this.bus_type=bus_type;
    }
    
     public String getBusCapacity(){
        return this.bus_capacity;
    }
    public void setBusBusCapacity(String bus_capacity){
        this.bus_capacity=bus_capacity;
    }

    public String getDriverID(){
            return this.driver_id;
    }
        public void setDriverID(String driver_id){
             this.driver_id=driver_id;
    }
        
    public String getPlateNo(){
            return this.driver_id;
    }
        public void setPlateNo(String plate_no){
             this.plate_no=plate_no;
    }
    
}


