package BusReservationDao;

import static java.nio.file.Files.list;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.logging.Level;
import java.util.logging.Logger;
import BusReservationModel.StudentInformation;
import daos.ConnectionDao;


/**
 *
 * @author Kamal Jabari
 * 
 */
public class StudentInformationDao extends ConnectionDao { 
    
    public ArrayList<StudentInformation> buildEvents() throws Exception {
                
        ArrayList<StudentInformation> list = new ArrayList<>();
        try {   
            Connection conn = getConnection();
            
            String sql = "SELECT * FROM STUDENT_INFO";                        
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

   
    
    private StudentInformation populateEvent(ResultSet rs) throws SQLException {
        StudentInformation event = new StudentInformation();
        
         event.setStudentID(rs.getInt("STUDENT_ID"));
        event.setStudentName(rs.getString("STUDENT_NAME"));
        event.setPhone(rs.getString("STUDENT_PHONE"));
        event.setSeatPreRes(rs.getString("SEAT_PRE_RES"));
        
        return event;
    }
    
    public void insertStudent(StudentInformation event) throws Exception {                
        try {
            Connection conn = getConnection();
            
            String sql = "INSERT INTO STUDENT_INFO "
                    + "( STUDENT_ID,"
                    + " STUDENT_NAME,"
                    + " STUDENT_PHONE,"
                    + " SEAT_PRE_RES,"
                    + " VALUES ((select max(STUDENT_ID) from STUDENT_INFO)+1,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql); 
            
            ps.setString(1, event.getStudentName());
            ps.setString(2, event.getPhone());
            ps.setString(3, event.getSeatPreRes());
            
            
            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
    public void updateEvent(StudentInformation event) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "UPDATE STUDENT_INFO SET "
                    + "(STUDENT_NAME=?,"
                    + " STUDENT_PHONE=?,"
                    + " SEAT_PRE_RES=?,"
                    + " WHERE STUDENT_ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, event.getStudentName());
            ps.setString(2, event.getPhone());
            ps.setString(3, event.getSeatPreRes());            
            ps.setInt(4, event.getStudentID());

            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
    public void deleteEvent(int student_id) throws Exception {
        Connection conn = getConnection();
        
        try {
            String sql = "DELETE FROM STUDENT_INFO WHERE STUDENT_ID=?";                               
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, student_id);
            
            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
    public static void main(String [] args){        
        try {
            StudentInformationDao dao = new StudentInformationDao();                
            //ArrayList<Event> events = dao.buildEvents();
        } catch (Exception ex) {
            Logger.getLogger(StudentInformationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
