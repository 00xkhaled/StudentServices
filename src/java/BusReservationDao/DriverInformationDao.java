package BusReservationDao;
  
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import BusReservationModel.DriverInformation;
import BusReservationBean.DriverInformationBean;


/**
 *
 * @author Kamal Jabari
 * 
 */
public class DriverInformationDao extends BusConnectionDao { 
    
    public ArrayList<DriverInformation> buildEvents() throws Exception {
                
        ArrayList<DriverInformation> list = new ArrayList<>();
        try {   
            Connection conn = getConnection();
            
            String sql = "SELECT * FROM DRIVERS";                        
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

   
    
    private DriverInformation populateEvent(ResultSet rs) throws SQLException {
        DriverInformation event = new DriverInformation();
        
        event.setDriverID(rs.getInt("DRIVER_ID"));
        event.setDriverNameEn(rs.getString("DRIVER_NAME_EN"));
        event.setDriverNameAr(rs.getString("DRIVER_NAME_AR"));
        event.setPhone(rs.getInt("PHONE_NUMBER"));
        event.setDriverAddressEn(rs.getString("DRIVER_ADDRESS_EN"));
        event.setDriverAddressAr(rs.getString("DRIVER_ADDRESS_AR"));
        event.setDriverLicenseNo(rs.getInt("DRIVER_LICENSE_NO"));
        
        
        return event;
    }
    
    public void insertStudent(DriverInformation event) throws Exception {                
        try {
            Connection conn = getConnection();
            
            String sql = "INSERT INTO DRIVERS "
                    + "( DRIVER_ID,"
                    + " DRIVER_NAME_EN,"
                    + " DRIVER_NAME_AR,"
                    + " PHONE_NUMBER, "
                    + " DRIVER_ADDRESS_EN,"
                    + " DRIVER_ADDRESS_AR,"
                    + " DRIVER_LICENSE_NO,"
                    + " VALUES ((select max(STUDENT_ID) from STUDENTS)+1,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql); 
            
            ps.setString(1, event.getDriverNameEn());
            ps.setString(2, event.getDriverNameAr());
            ps.setInt(3 ,   event.getPhone());
            ps.setString(4, event.getDriverAddressEn());
            ps.setString(5, event.getDriverAddressAr()); 
            ps.setInt(6 ,   event.getDriverLicenseNo());
            
                        
            
            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
    public void updateStudent(DriverInformation event) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "UPDATE DRIVERS SET "
                    + " DRIVER_NAME_EN,"
                    + " DRIVER_NAME_AR,"
                    + " PHONE_NUMBER, "
                    + " DRIVER_ADDRESS_EN,"
                    + " DRIVER_ADDRESS_AR,"
                    + " DRIVER_LICENSE_NO,"
                    + " WHERE STUDENT_ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            
             ps.setString(1, event.getDriverNameEn());
            ps.setString(2, event.getDriverNameAr());
            ps.setInt(3 ,   event.getPhone());
            ps.setString(4, event.getDriverAddressEn());
            ps.setString(5, event.getDriverAddressAr()); 
            ps.setInt(6 ,   event.getDriverLicenseNo());           
            ps.setInt(7, event.getDriverID());

            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
    public void deleteStudent(int driver_id) throws Exception {
        Connection conn = getConnection();
        
        try {
            String sql = "DELETE FROM DRIVERS WHERE DRIVER_ID=?";                               
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, driver_id );
            
            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
    public static void main(String [] args){        
        try {
            DriverInformationDao dao = new DriverInformationDao();                
            //ArrayList<Event> events = dao.buildEvents();
        } catch (Exception ex) {
            Logger.getLogger(DriverInformationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
