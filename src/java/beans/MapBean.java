package beans;

import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;


@Named("mapBean")
@SessionScoped


public class MapBean implements Serializable { 
double x=31.777067;
double y=35.802555;
LatLng center;
MapModel model = new DefaultMapModel();  
public MapBean(){
model.addOverlay(new Marker(new LatLng(x,y), "GJU"));
}
public MapModel getModel() {
return this.model;
}
public void update(){
    x=x+0.01;
    model.addOverlay(new Marker(new LatLng(x,y+0.00001), "GJU"));
    center = new LatLng(x,y);
}
}