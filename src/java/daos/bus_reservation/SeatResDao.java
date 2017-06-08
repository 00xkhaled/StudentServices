package daos.bus_reservation;
  
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.bus_reservation.SeatRes;


public class SeatResDao extends BusConnectionDao { 

    
    public ArrayList<SeatRes> buildRes() throws Exception {
                
        ArrayList<SeatRes> list = new ArrayList<>();
        try {   
            Connection conn = getConnection();
            
            String sql = "SELECT * FROM SEAT_RESERVATION";                        
            PreparedStatement ps = conn.prepareStatement(sql);            

            ResultSet rs = ps.executeQuery();           

            while (rs.next()) {
                list.add(populateRes(rs));
            }
            
            rs.close();
            ps.close();
            
            return list;            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

   
    
    private SeatRes populateRes(ResultSet rs) throws SQLException {
        SeatRes res = new SeatRes();
        
        res.setStudentID(rs.getInt("BUS_ID"));
        res.setBusNumber(rs.getInt("BUS_NO"));
        res.setSeatID(rs.getInt("SEAT_ID"));
        res.setResTime(rs.getString("RESERVATION_TIME"));
        
       
        return res;
    }
    
    public void insertRes(SeatRes res) throws Exception {                
        try {
            Connection conn = getConnection();
            
            String sql = 
                    "INSERT INTO SEAT_RESERVATION "
                    + "( RESERVATION_ID, "
                    + " BUS_NO,"
                    + " SEAT_ID,"  
                    + " STUDENT_ID,"
                    + " RESERVATION_TIME,"
                    + " VALUES ((select max(RESERVATION_ID) from SEAT_RESERVATION)+1,?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(sql); 
                ps.setInt(1, res.getBusNumber());
                ps.setInt(2, res.getSeatID());
                ps.setInt(3, res.getStudentID());
                ps.setString(4, res.getResTime());
                ps.executeUpdate();
                ps.close();
            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
    
        public void deleteRes(int res_ID) throws Exception {

        try {
            Connection conn;
            conn = getConnection();
            String sql = "DELETE FROM SEAT_RESERVATION WHERE SEAT_ID=?";                               
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, res_ID);
            
            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }    }
    

    
    public static void main(String [] args){        
        try {
            SeatResDao dao = new SeatResDao();                
            
        } catch (Exception ex) {
            Logger.getLogger(SeatResDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
