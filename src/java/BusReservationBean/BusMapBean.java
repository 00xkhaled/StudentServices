package BusReservationBean;



import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.primefaces.model.map.Polygon;
@Named("BmapBean")
@SessionScoped

public class BusMapBean implements Serializable {
    
    private MapModel mapModel;    
    private double lat;  
    private double lng;  
    double x=31.777067;
    double y=35.802555;
     LatLng coord1 = new LatLng(x, y);
private MapModel model = new DefaultMapModel();
public BusMapBean() {
model.addOverlay(new Marker(new LatLng(x,y), "GJU"));
}
public MapModel getModel() {
return this.model;
}

public void update(){ 
x=x+0.01;  
y=y+0.01;
model.addOverlay(new Marker(new LatLng(x, y), "GJU"));
     
        LatLng coord2 = new LatLng(x, y);
        Polygon polygon = new Polygon();
        polygon.getPaths().add(coord1);
        polygon.getPaths().add(coord2);

        polygon.setStrokeColor("#FF9900");
        polygon.setFillColor("#FF9900");
        polygon.setStrokeOpacity(0.7);
        polygon.setFillOpacity(0.7);
        model.addOverlay(polygon);
       }
<<<<<<< HEAD
}

=======
}
>>>>>>> 5b52864e4596ae4beadecbb5a688a6572cf29602
