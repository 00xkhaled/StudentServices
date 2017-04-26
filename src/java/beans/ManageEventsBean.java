package beans;

import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
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
@Named(value = "manageEventsBean")
@ViewScoped
public class ManageEventsBean implements Serializable{
    private Event selectedEvent;    
    
    private ArrayList<Event> filteredEvents;
    
    @Inject
    private EventsBean eventsBean;
    
    public ManageEventsBean() {        
    }       
    
    @PostConstruct
    public void init(){
        filteredEvents = eventsBean.getEvents();
    }

    public Event getSelectedEvent() {
        return selectedEvent;
    }

    public void setSelectedEvent(Event selectedEvent) {
        this.selectedEvent = selectedEvent;
    }  

    public ArrayList<Event> getFilteredEvents() {
        return filteredEvents;
    }

    public void setFilteredEvents(ArrayList<Event> filteredEvents) {
        this.filteredEvents = filteredEvents;
    }   
    
    public void searchEvents(){        
    }
    
    public void deleteSelected(){
        filteredEvents.remove(selectedEvent);
    }
}
