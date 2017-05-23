package beans;

import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
@Named("mapBean")
@SessionScoped
    

public class MapBean implements Serializable {
    private MapModel mapModel;    
    private double lat;  
    private double lng;  
    double x=31.777067;
    double y=35.802555;
private MapModel model = new DefaultMapModel();
public MapBean() {
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