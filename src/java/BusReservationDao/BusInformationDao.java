package BusReservationDao;
  
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.logging.Level;
import java.util.logging.Logger;
import BusReservationModel.BusInformation;
import BusReservationDao.BusConnectionDao;


public class BusInformationDao extends BusConnectionDao { 
    
    public ArrayList<BusInformation> buildEvents() throws Exception {
                
        ArrayList<BusInformation> list = new ArrayList<>();
        try {   
            Connection conn = getConnection();
            
            String sql = "SELECT * FROM BUSES";                        
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

   
    
    private BusInformation populateEvent(ResultSet rs) throws SQLException {
        BusInformation event = new BusInformation();
        
        event.setBusID(rs.getInt("BUS_ID"));
        event.setBusNumber(rs.getInt("BUS_NUMBER"));
        event.setDriverNameEn(rs.getString("DRIVER_NAME_EN"));
        event.setDriverNameAr(rs.getString("DRIVER_NAME_AR"));
        event.setBusCapacity(rs.getInt("BUS_CAPACITY"));
        event.setBusTypeEn(rs.getString("BUS_TYPE_EN"));
        event.setBusTypeAr(rs.getString("BUS_TYPE_AR"));
        event.setDriverID(rs.getInt("DRIVER_ID"));
        event.setPlateNo(rs.getInt("PLATE_NO"));
       
        return event;
    }
    
    public void insertBus(BusInformation event) throws Exception {                
        try {
            Connection conn = getConnection();
            
            String sql = "INSERT INTO BUSES "
                    + "( BUS_ID,"
                    + " BUS_NUMBER,"
                    + " DRIVER_NAME_EN,"  
                    + " DRIVER_NAME_AR,"
                    + " BUS_CAPACITY,"
                    + " BUS_TYPE_EN,"
                    + " BUS_TYPE_AR,"
                    + " DRIVER_ID,"
                    + " PLATE_NO,"
                    + " VALUES ((select max(BUS_ID) from BUSES)+1,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql); 
            
            ps.setInt(1, event.getBusNumber());
            ps.setString(2, event.getDriverNameEn());
            ps.setString(3, event.getDriverNameAr());
            ps.setInt(4, event.getBusCapacity()); 
            ps.setString(5,   event.getBusTypeEn());
            ps.setString(6,   event.getBusTypeAr());
            ps.setInt(7, event.getDriverID());
            ps.setInt(8, event.getPlateNo());
                        
            
            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
    public void updateEvent(BusInformation event) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "UPDATE INTO BUSES "
                    + " (BUS_NUMBER,"
                    + " DRIVER_NAME_EN,"  
                    + " DRIVER_NAME_AR,"
                    + " BUS_CAPACITY,"
                    + " BUS_TYPE_EN,"
                    + " BUS_TYPE_AR,"
                    + " DRIVER_ID,"
                    + " PLATE_NO,"
                    + " WHERE BUS_ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, event.getBusNumber());
            ps.setString(2, event.getDriverNameEn());
            ps.setString(3, event.getDriverNameAr());
            ps.setInt(4, event.getBusCapacity()); 
            ps.setString(5,   event.getBusTypeEn());
            ps.setString(6,   event.getBusTypeAr());
            ps.setInt(7, event.getDriverID());
            ps.setInt(8, event.getPlateNo());

            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
    public void deleteEvent(int bus_id) throws Exception {
        Connection conn = getConnection();
        
        try {
            String sql = "DELETE FROM BUSES WHERE BUS_ID=?";                               
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, bus_id);
            
            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
    public static void main(String [] args){        
        try {
            BusInformationDao dao = new BusInformationDao();                
            //ArrayList<Event> events = dao.buildEvents();
        } catch (Exception ex) {
            Logger.getLogger(StudentInformationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
