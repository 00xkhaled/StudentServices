package daos.bus_reservation;
  
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.bus_reservation.BusInformation;


public class BusInformationDao extends BusConnectionDao { 

    
    public ArrayList<BusInformation> buildBus() throws Exception {
                
        ArrayList<BusInformation> list = new ArrayList<>();
        try {   
            Connection conn = getConnection();
            
            String sql = "SELECT * FROM BUSES1";                        
            PreparedStatement ps = conn.prepareStatement(sql);            

            ResultSet rs = ps.executeQuery();           

            while (rs.next()) {
                list.add(populateBuses(rs));
            }
            
            rs.close();
            ps.close();
            
            return list;            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

   
    
    private BusInformation populateBuses(ResultSet rs) throws SQLException {
        BusInformation bus = new BusInformation();
        
        bus.setBusID(rs.getInt("BUS_ID"));
        bus.setBusNumber(rs.getInt("BUS_NUMBER"));
        bus.setDriverNameEn(rs.getString("DRIVER_NAME_EN"));
        bus.setDriverNameAr(rs.getString("DRIVER_NAME_AR"));
        bus.setBusCapacity(rs.getInt("BUS_CAPACITY"));
        bus.setBusTypeEn(rs.getString("BUS_TYPE_EN"));
        bus.setBusTypeAr(rs.getString("BUS_TYPE_AR"));
        bus.setDriverID(rs.getInt("DRIVER_ID"));
        bus.setPlateNo(rs.getInt("PLATE_NO"));
       
        return bus;
    }
    
    public void insertBus(BusInformation bus) throws Exception {                
        try {
            Connection conn = getConnection();
            
            String sql = 
                    "INSERT INTO BUSES1 "
                    + "( BUS_ID, "
                    + " BUS_NUMBER,"
                    + " DRIVER_NAME_EN,"  
                    + " DRIVER_NAME_AR,"
                    + " BUS_CAPACITY,"
                    + " BUS_TYPE_EN,"
                    + " BUS_TYPE_AR,"
                    + " DRIVER_ID,"
                    + " PLATE_NO)"
                    + " VALUES ((select max(BUS_ID) from BUSES1)+1,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(sql); 
                ps.setInt(1, bus.getBusNumber());
                ps.setString(2, bus.getDriverNameEn());
                ps.setString(3, bus.getDriverNameAr());
                ps.setInt(4, bus.getBusCapacity());
                ps.setString(5,bus.getBusTypeEn());
                ps.setString(6,bus.getBusTypeAr());
                ps.setInt(7, bus.getDriverID());
                ps.setInt(8, bus.getPlateNo());
                
                
                ps.executeUpdate();
                ps.close();
            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
    public void updateBus(BusInformation bus) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "UPDATE BUSES1 SET"
                    + "BUS_NUMBER=?,"
                    + "DRIVER_NAME_EN=?,"  
                    + "DRIVER_NAME_AR=?,"
                    + "BUS_CAPACITY=?,"
                    + "BUS_TYPE_EN=?,"
                    + "BUS_TYPE_AR=?,"
                    + "DRIVER_ID=?,"
                    + "PLATE_NO=?"
                    + "WHERE (BUS_ID=?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1,    bus.getBusNumber());
            ps.setString(2, bus.getDriverNameEn());
            ps.setString(3, bus.getDriverNameAr());
            ps.setInt(4,    bus.getBusCapacity()); 
            ps.setString(5, bus.getBusTypeEn());
            ps.setString(6, bus.getBusTypeAr());
            ps.setInt(7,    bus.getDriverID());
            ps.setInt(8,    bus.getPlateNo());

            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
        public void deleteBus(int busID) throws Exception {

        try {
            Connection conn;
            conn = getConnection();
            String sql = "DELETE FROM BUSES1 WHERE BUS_ID=?";                               
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, busID);
            
            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }    }
    

    
    public static void main(String [] args){        
        try {
            BusInformationDao dao = new BusInformationDao();                
            
        } catch (Exception ex) {
            Logger.getLogger(BusInformationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
