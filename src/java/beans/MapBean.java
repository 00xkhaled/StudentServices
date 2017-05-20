package beans;

import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
@ManagedBean
@SessionScoped
    

public class MapBean implements Serializable {
    private MapModel mapModel;    
    private double lat;  
    private double lng;  
private MapModel model = new DefaultMapModel();
public MapBean() {
model.addOverlay(new Marker(new LatLng(31.777067, 35.802555), "GJU"));
}
public MapModel getModel() {
return this.model;
}
}