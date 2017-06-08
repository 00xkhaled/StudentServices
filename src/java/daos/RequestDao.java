package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.AvailableRequests;
import models.Event;
import models.Request;

public class RequestDao extends ConnectionDao // extend the connection dao
{

    private Request populateEvent(ResultSet rs) throws SQLException {
        Request request = new Request();

        request.setFirstname(rs.getString("FIRST_NAME"));
        request.setLastname(rs.getString("LAST_NAME"));
        request.setCity(rs.getString("CITY"));
        request.setStreet(rs.getString("STREET"));
        request.setEmail(rs.getString("EMAIL"));
        request.setPhone(rs.getString("PHONE"));
        request.setGender(rs.getString("GENDER"));
        request.setRidefrom(rs.getString("RIDE_FROM"));
        request.setRideto(rs.getString("RIDE_TO"));
        request.setInfo(rs.getString("INFO"));

        return request;

    }

    public void insertrequest(Request request) throws Exception {
        System.out.println("Connected to the dao :) ");

        try {
            Connection conn = getConnection();

            String sql
                    = "INSERT INTO AVAILABLE_REQUESTS "
                    + "(REQUEST_ID,"
                    + "FIRST_NAME,"
                    + "LAST_NAME,"
                    + "CITY,"
                    + "TIME,"
                    + "STREET,"
                    + "EMAIL,"
                    + "PHONE,"
                    + "GENDER,"
                    + "RIDE_FROM,"
                    + "RIDE_TO,"
                    + "INFO)"
                    + " VALUES ((select max(REQUEST_ID) from AVAILABLE_REQUESTS)+1,?,?,?,?,?,?,?,?,?,?,?)";


            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, request.getFirstname());
            ps.setString(2, request.getLastname());
            ps.setString(3, request.getCity());
            ps.setString(4, request.getStreet());
            ps.setString(5, request.getEmail());
            ps.setString(6, request.getPhone());
            ps.setString(7, request.getGender());
            ps.setString(8, request.getRidefrom());
            ps.setString(9, request.getRideto());
            ps.setString(10, request.getInfo());
            ps.setString(11, request.getTime());


            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
    /* delete event based on the id */ 

    public void deleteEvent(int REQUEST_ID) throws Exception {

        Connection conn = getConnection();

        try {
            String sql = "DELETE FROM AVAILABLE_REQUESTS WHERE REQUEST_ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, REQUEST_ID);

            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
    
       public Request getRequest(int requestId) throws Exception {
        try {   
            Request request = null;
            Connection conn = getConnection();
            
            String sql = "SELECT AVAILABLE_REQUESTS.*, "
                  
                    + "( FIRST_NAME,"
                    + " LAST_NAME,"
                    + " CITY,"
                    + " STREET,"
                    + "EMAIL,"
                    + "PHONE,"
                    + "GENDER,"
                    + "RIDE_FROM,"
                    + "RIDE_TO,"
                    + "INFO,"
                    + " VALUES ((select max(REQUEST_ID) from AVAILABLE_REQUESTS)+1,?,?,?,?,?,?,?,?,?,?)";
            
            
            
            PreparedStatement ps = conn.prepareStatement(sql);            
            ps.setInt(1, requestId);
            
            ResultSet rs = ps.executeQuery();           

            while (rs.next()) {
                request = populateEvent(rs);
                
            }

            rs.close();
            ps.close();
            
            return request;            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    

    
    /* update event*/
    public void updaterequest(Request request) throws Exception {
        try {
            Connection conn = getConnection();

            String sql =
                    "UPDATE AVAILABLE_REQUESTS "
                    + "( FIRST_NAME,"
                    + "LAST_NAME,"
                
                    + " CITY,"
                    + " STREET,"
                    + "EMAIL,"
                    + "PHONE,"
                    + "GENDER,"
                    + "RIDE_FROM,"
                    + "RIDE_TO,"
                    + "INFO)"
                    + " VALUES ((select max(REQUEST_ID) from AVAILABLE_REQUESTS)+1,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

             ps.setString(1, request.getFirstname());
            ps.setString(2, request.getLastname());
            ps.setString(3, request.getCity());
            ps.setString(4, request.getStreet());
            ps.setString(5, request.getEmail());
            ps.setString(6, request.getPhone());
            ps.setString(7, request.getGender());
            ps.setString(8, request.getRidefrom());
            ps.setString(9, request.getRideto());
            ps.setString(10, request.getInfo());

            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());

        }
    }
    
    
    
 public ArrayList<Request> buildevents() throws Exception 
    
    {
                
        ArrayList<Request> list = new ArrayList<>();
        try 
        {   
            Connection conn = getConnection();
            
            String sql = "SELECT * FROM AVAILABLE_REQUESTS";          // select all avaliable requests               
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                
                while (rs.next()) {
                    list.add(populateEvent(rs));
                }
                
                rs.close();
            }
            
            return list;            
        } 
        catch (SQLException e)
        {
            throw new SQLException(e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            Request dao = new Request();
        } catch (Exception ex) {
            Logger.getLogger(Request.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
