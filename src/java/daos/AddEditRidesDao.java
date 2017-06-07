package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.AvailableRide;


/**
 *
 * @author Othman Kurdi
 * 
 */
public class AddEditRidesDao extends ConnectionDao {    
    
    //it will be used by the AvailableRidesBean to flush the data into the tabel;(working)
    public AvailableRide getRide(int rideId) throws Exception {
                
        AvailableRide ride = new AvailableRide();
        try {   
            Connection conn = getConnection();
            
            String sql = "SELECT STUDENTS_CARPOOLING.STUDENT_ID, STUDENTS_CARPOOLING.STUDENT_NAME, STUDENTS_CARPOOLING.PHONE, STUDENTS_CARPOOLING.GENDER, DESTINATIONS.RIDE_FROM, DESTINATIONS.RIDE_TO, DESTINATIONS.DEPARTURE_TIME,CARS.CAR_PLATE_NUMBER, CARS.MAKE, CARS.MODEL, CARS.YEAR_OF_MAKE, CARS.COLOR FROM STUDENTS_CARPOOLING JOIN DESTINATIONS ON STUDENTS_CARPOOLING.RIDE_ID=DESTINATIONS.RIDE_ID JOIN CARS ON STUDENTS_CARPOOLING.RIDE_ID=CARS.RIDE_ID";
            PreparedStatement ps = conn.prepareStatement(sql);            
            ps.setInt(1, rideId);
            ResultSet rs = ps.executeQuery();
                
            ride=populateRide(rs);
            
            rs.close();
            ps.close();
            
            return ride;            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

   
    //it will cooperate with the getRide() methode so that it will seperate the 
    //returned data before return it again.
    private AvailableRide populateRide(ResultSet rs) throws SQLException {
        AvailableRide ride = new AvailableRide();
        
        ride.setRideID(rs.getInt("RIDE_ID"));
        ride.setStudentId(rs.getInt("STUDENT_ID"));
        ride.setName(rs.getString("DRIVER_NAME"));
        ride.setPhone(rs.getString("DRIVER_PHONE"));
        ride.setGender(rs.getString("GENDER"));
        
        ride.setRideFrom(rs.getString("RIDE_FROM"));
        ride.setRideTo(rs.getString("RIDE_TO"));
        ride.setDepartureTime(rs.getString("DEPARTURE_TIME"));
        
        ride.setCarPlateNumber(rs.getInt("CAR_PLATE_NUMBER"));
        ride.setCarMake(rs.getString("CAR_MAKE"));
        ride.setCarModel(rs.getString("CAR_MODEL"));
        ride.setYearOfMake(rs.getString("YEAR_OF_MAKE"));
        ride.setCarColor(rs.getString("CAR_COLOR"));
        
        return ride;
    }
    //not working
    public void insertRide(AvailableRide ride) throws Exception {
        System.out.println("reached dao...");
        try {
            Connection conn = getConnection();

            String sql = "INSERT INTO STUDENTS_CARPOOLING VALUES((SELECT MAX(RIDE_ID) FROM AVAILABLE_RIDES)+1,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, ride.getStudentId());
            ps.setString(2, ride.getName());
            ps.setString(3, ride.getPhone());
            ps.setString(4, ride.getGender());
            ps.executeUpdate();
            
            sql = "INSERT INTO CARS VALUES((select max(RIDE_ID) FROM STUDENTS_CARPOOLING)+1,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ride.getCarPlateNumber());
            ps.setString(2, ride.getCarMake());
            ps.setString(3, ride.getCarModel());
            ps.setString(4, ride.getYearOfMake());
            ps.setString(5, ride.getCarColor());
            ps.executeUpdate();
            
            sql = "INSERT INTO DESTINATIONS VALUES((select max(RIDE_ID) FROM STUDENTS_CARPOOLING)+1,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, ride.getRideFrom());
            ps.setString(2, ride.getRideTo());
            ps.setString(3, ride.getDepartureTime());
            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    //updating(not working)
    public void updateRide(AvailableRide ride) throws Exception {
        try {
            Connection conn = getConnection();
            
            
            String sql = "UPDATE STUDENTS_CARPOOLING SET "
                    + "(STUDENT_ID=?, STUDENT_NAME=?, STUDENT_PHONE=?, GENDER=?) "
                    + "WHERE RIDE_ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, ride.getStudentId());
            ps.setString(2, ride.getName());
            ps.setString(3, ride.getPhone());
            ps.setString(4, ride.getGender());
            ps.setInt(5, ride.getRideID());
            ps.executeUpdate();
            
            sql = "UPDATE CARS SET "
                    + "(CAR_PLATE_NUMBER=?, CAR_MAKE=?, CAR_MODEL=?, YEAR_OF_MAKE=?, CAR_COLOR,?) "
                    + "WHERE RIDE_ID=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ride.getCarPlateNumber());
            ps.setString(2, ride.getCarMake());
            ps.setString(3, ride.getCarModel());
            ps.setString(4, ride.getYearOfMake());
            ps.setString(5, ride.getCarColor());
            ps.setInt(6, ride.getRideID());
            ps.executeUpdate();
            
            sql = "UPDATE DESTINATION SET "
                    + "(RIDE_FROM=?, RIDE_TO=?, DEPARTURE_TIME=?) "
                    + "WHERE RIDE_ID=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, ride.getRideFrom());
            ps.setString(2, ride.getRideTo());
            ps.setString(3, ride.getDepartureTime());
            ps.setInt(4, ride.getRideID());
            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
   
    public static void main(String [] args){        
        try {
            AvailableRidesDao dao = new AvailableRidesDao();                
            
        } catch (Exception ex) {
            Logger.getLogger(AvailableRidesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
