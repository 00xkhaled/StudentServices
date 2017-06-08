package beans.bus_reservation;

import daos.bus_reservation.SeatResDao;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.bus_reservation.SeatRes;
import beans.SessionBean;


@Named("addEditSeatResBean")
@ViewScoped
public class addEditSeatResBean implements Serializable{
    private final SeatResDao SeatResDao = new SeatResDao();
    private int bus_number;
    private int StudentID;
    private int seatId;
    private String busTime;
    
    @Inject
    private SessionBean sessionBean;
    
    public addEditSeatResBean() {        
    }
    
    @PostConstruct
    public void init(){                
        try {
            StudentID = sessionBean.getSelectedItemId();
            if(StudentID > 0){
            SeatRes seat = new SeatRes();
           seat.getStudentID();
           seat.getBusNumber();
           seat.getSeatID();
           seat.getResTime();
            }
        } catch (Exception ex) {
            Logger.getLogger(addEditSeatResBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getStudentID(){
        return this.StudentID;
    }
    public void setStudentID(int StudentId){
        this.StudentID=StudentId;
    }
     public int getBusNumber(){
        return this.bus_number;
    }
    public void setBusNumber(int bus_number){
        this.bus_number=bus_number;
    }
    
     public int getSeatID(){
        return this.seatId;
    }
    public void setSeatID(int seatId){
        this.seatId=seatId;
    } 
    public String getResTime(){
        return this.busTime;
    }
    public void setResTime(String busTime){
        this.busTime=busTime;
    }
    
    
        
    public void saveSeatRes() {
        try {
           SeatRes res = new SeatRes();
           
          
           res.setBusNumber(bus_number);
           res.setStudentID(StudentID);
           res.setSeatID(seatId);
           res.setResTime(busTime);
           
            
            
                SeatResDao.insertRes(res);
            
        } catch (Exception ex) {
            Logger.getLogger(addEditSeatResBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        sessionBean.navigate("seat_res");

       
    }
}
