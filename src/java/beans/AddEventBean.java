package beans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.Event;
import models.EventType;

/**
 *
 * @author Firas.Alhawari
 * 
 */
@Named(value = "addEventBean")
@ViewScoped
public class AddEventBean implements Serializable{
    private int eventTypeId;
    private String nameEn;
    private String nameAr;
    private String placeEn;
    private String placeAr;
    private int capacity;
    private Date date;
    
    @Inject
    private EventsBean eventsBean;
    
    @Inject
    private SessionBean sessionBean;
    
    public AddEventBean() {        
    }

    public int getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(int eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameAr() {
        return nameAr;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }

    public String getPlaceEn() {
        return placeEn;
    }

    public void setPlaceEn(String placeEn) {
        this.placeEn = placeEn;
    }

    public String getPlaceAr() {
        return placeAr;
    }

    public void setPlaceAr(String placeAr) {
        this.placeAr = placeAr;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
        
    public void addEvent(){
        Event event = new Event();
        
        EventType eventType = eventsBean.getEventTypes().get(eventTypeId-1);
        event.setEventId(eventsBean.getEvents().size()+1);
        event.setType(eventType);
        event.setNameEn(nameEn);
        event.setNameAr(nameAr);
        event.setPlaceEn(placeEn);
        event.setPlaceAr(placeAr);
        event.setCapacity(capacity);
        event.setDate(date);
        
        eventsBean.getEvents().add(event);
        
        sessionBean.navigate("manage_events");
    }   
}
