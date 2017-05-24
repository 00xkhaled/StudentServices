package daos;

import static java.nio.file.Files.list;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.AvailableRides;
import models.EventType;


/**
 *
 * @author OthmanKurdi
 * 
 */
public class AvailableRidesDao extends ConnectionDao {     
    public ArrayList<AvailableRides> buildEvents() throws Exception {
                
        ArrayList<AvailableRides> list = new ArrayList<>();
        try {   
            Connection conn = getConnection();
            
            String sql = "SELECT * FROM AVAILABLE_RIDES";                        
            PreparedStatement ps = conn.prepareStatement(sql);            

            ResultSet rs = ps.executeQuery();           

            while (rs.next()) {
                list.add(populateEvent(rs));
            }
            
            rs.close();
            ps.close();
            
            return list;            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

   
    
    private AvailableRides populateEvent(ResultSet rs) throws SQLException {
        AvailableRides event = new AvailableRides();
        
         event.setRideID(rs.getInt("RIDE_ID"));
        event.setRideFrom(rs.getString("RIDE_FROM"));
        event.setRideTo(rs.getString("RIDE_TO"));
        event.setName(rs.getString("DRIVER_NAME"));
        event.setPhone(rs.getString("DRIVER_PHONE"));
        event.setDepartureTime(rs.getString("DEPARTURE_TIME"));
        return event;
    }
    
    public void insertRide(AvailableRides event) throws Exception {                
        try {
            Connection conn = getConnection();
            
            String sql = "INSERT INTO AVAILABLE_RIDES "
                    + "( RIDE_ID,"
                    + " RIDE_FROM,"
                    + " RIDE_TO,"
                    + " DRIVER_NAME,"
                    + " DRIVER_PHONE,"
                    + " DEPARTURE_TIME"
                    + " VALUES ((select max(RIDE_ID) from AVAILABLE_RIDES)+1,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql); 
            
            ps.setString(1, event.getRideFrom());
            ps.setString(2, event.getRideTo());
            ps.setString(3, event.getName());
            ps.setString(4, event.getPhone());
            ps.setString(5, event.getDepartureTime());
            
            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
    public void updateEvent(AvailableRides event) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "UPDATE AVAILABLE_RIDES SET "
                    + "(RIDE_FROM=?,"
                    + " RIDE_TO=?,"
                    + " DRIVER_NAME=?,"
                    + " DRIVER_PHONE=?,"
                    + " DEPARTURE_TIME=?"
                    + " WHERE RIDE_ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            
           ps.setString(1, event.getRideFrom());
            ps.setString(2, event.getRideTo());
            ps.setString(3, event.getName());
            ps.setString(4, event.getPhone());
            ps.setString(5, event.getDepartureTime());            
            ps.setInt(6, event.getRideID());

            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
    public void deleteEvent(int RideID) throws Exception {
        Connection conn = getConnection();
        
        try {
            String sql = "DELETE FROM AVAILABLE_RIDES WHERE RIDE_ID=?";                               
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, RideID);
            
            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    /*
    public AvailableRides getEvent(int RideId) throws Exception {
        try {   
            AvailableRides event = null;
            Connection conn = getConnection();
            
            String sql = "SELECT AVAILABLE_RIDES.*, "
                    + " EVENT_TYPES.NAME_EN as TYPE_EN,"
                    + " EVENT_TYPES.NAME_AR as TYPE_AR "
                    + " FROM EVENTS, EVENT_TYPES "
                    + " WHERE EVENTS.EVENT_TYPE_ID=EVENT_TYPES.EVENT_TYPE_ID AND"
                    + " RIDE_ID=?";                        
            PreparedStatement ps = conn.prepareStatement(sql);            
            ps.setInt(1, eventId);
            
            ResultSet rs = ps.executeQuery();           

            while (rs.next()) {
                event = populateEvent(rs);
                event.getType().setNameEn(rs.getString("TYPE_EN"));
                event.getType().setNameAr(rs.getString("TYPE_AR"));
            }

            rs.close();
            ps.close();
            
            return event;            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
      */      
    public static void main(String [] args){        
        try {
            AvailableRidesDao dao = new AvailableRidesDao();                
            //ArrayList<Event> events = dao.buildEvents();
        } catch (Exception ex) {
            Logger.getLogger(AvailableRidesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
