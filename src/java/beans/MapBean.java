package beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@SessionScoped
public class MapBean implements Serializable {
private MapModel model = new DefaultMapModel();
public MapBean() {
model.addOverlay(new Marker(new LatLng(31.777067, 35.802555), "GJU"));
}
public MapModel getModel() {
return this.model;
}
}