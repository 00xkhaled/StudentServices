package beans.bus_reservation;

import beans.SessionBean;
import daos.bus_reservation.SeatResDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import models.bus_reservation.SeatRes;

@Named("SeatResBean")
@ViewScoped
public class SeatResBean implements Serializable {

    private int res_id;
    private int seat_id;
    private int bus_number;
    private int student_id;
    private String res_time;

    private SeatRes selectedRes;
    private final SeatResDao bus = new SeatResDao();
    private ArrayList<SeatRes> list;

    @Inject
    private SessionBean sessionBean;

    public SeatResBean() {
        init();

    }

    @PostConstruct
    public void init() {
        try {
            list = bus.buildRes();
        } catch (Exception ex) {
            Logger.getLogger(SeatResBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getResID() {
        return this.res_id;
    }

    public void setResID(int res_id) {
        this.res_id = res_id;
    }

    public SeatRes getSelectedRes() {
        return selectedRes;
    }

    public void setSelectedRes(SeatRes selectedRes) {
        this.selectedRes = selectedRes;
    }

    public ArrayList<SeatRes> getRes() {
        return list;
    }

    public int getBusNumber() {
        return this.bus_number;
    }

    public void setBusNumber(int bus_number) {
        this.bus_number = bus_number;
    }

    public int getStudentID() {
        return this.student_id;
    }

    public void setStudentID(int student_id) {
        this.student_id = student_id;
    }

    public String getResTime() {
        return this.res_time;
    }

    public void setResTime(String res_time) {
        this.res_time = res_time;
    }

    public int getSeatID() {
        return this.seat_id;
    }

    public void setSeatID(int seat_id) {
        this.seat_id = seat_id;
    }

    

    public ArrayList<SeatRes> getList() {
        return list;
    }

    public void setList(ArrayList<SeatRes> list) {
        this.list = list;
    }

    public void deleteSelectedRes() {
        try {
            bus.deleteRes(selectedRes.getResID());
        } catch (Exception ex) {
            Logger.getLogger(SeatResBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
