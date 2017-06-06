/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.ViewFilterRide;



/**
 *
 * @author user
 */
public class ViewFilterRideDao extends ConnectionDao {
 
   public ArrayList<ViewFilterRide> getRides() throws Exception {
                
        ArrayList<ViewFilterRide> list = new ArrayList<>();
        try {   
            Connection conn = getConnection();
            
            String sql = "SELECT DESTINATIONS.RIDE_FROM, DESTINATIONS.RIDE_TO, STUDENTS_CARPOOLING.STUDENT_NAME, STUDENTS_CARPOOLING.PHONE,STUDENTS_CARPOOLING.GENDER  FROM STUDENTS_CARPOOLING JOIN DESTINATIONS ON STUDENTS_CARPOOLING.RIDE_ID=DESTINATIONS.RIDE_ID;";                     
            PreparedStatement ps = conn.prepareStatement(sql);            

            ResultSet rs = ps.executeQuery();           

            while (rs.next()) {
                list.add(populateRide2(rs));
            }
            
            rs.close();
            ps.close();
            
            return list;            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
   }
     private ViewFilterRide populateRide2(ResultSet rs) throws SQLException {
        ViewFilterRide ride = new ViewFilterRide();
        
        
        
        ride.setName(rs.getString("STUDENT_NAME"));
        ride.setPhone(rs.getString("PHONE"));
        ride.setGender(rs.getString("GENDER"));
        
        ride.setRideFrom(rs.getString("RIDE_FROM"));
        ride.setRideTo(rs.getString("RIDE_TO"));
        
        
        
        return ride;
    }
    }

    

