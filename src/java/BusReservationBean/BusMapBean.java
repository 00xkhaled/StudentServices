package BusReservationBean;



import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
@Named("BmapBean")
@SessionScoped
    

public class BusMapBean implements Serializable {
    private MapModel mapModel;    
    private double lat;  
    private double lng;  
    double x=31.777067;
    double y=35.802555;
private MapModel model = new DefaultMapModel();
public BusMapBean() {
model.addOverlay(new Marker(new LatLng(x,y), "GJU"));
}
public MapModel getModel() {
return this.model;
}
public void update(){
x=x+0.01;    
model.addOverlay(new Marker(new LatLng(x, y), "GJU"));
}
}