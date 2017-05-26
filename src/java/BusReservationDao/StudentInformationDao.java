package BusReservationDao;
  
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import BusReservationModel.StudentInformation;


/**
 *
 * @author Kamal Jabari
 * 
 */
public class StudentInformationDao extends BusConnectionDao { 
    
    public ArrayList<StudentInformation> buildStudent() throws Exception {
                
        ArrayList<StudentInformation> list = new ArrayList<>();
        try {   
            Connection conn = getConnection();
            
            String sql = "SELECT * FROM STUDENTS";                        
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
        event.setStudentFNameEn(rs.getString("STUDENT_FIRST_NAME_EN"));
        event.setStudentLNameEn(rs.getString("STUDENT_LAST_NAME_EN"));
        event.setStudentFNameAr(rs.getString("STUDENT_FIRST_NAME_AR"));
        event.setStudentLNameAr(rs.getString("STUDENT_LAST_NAME_AR"));
        event.setPhone(rs.getInt("STUDENT_PHONE_NUMBER"));
        event.setStudentAddressEn(rs.getString("STUDENT_ADDRESS_EN"));
        event.setStudentAddressAr(rs.getString("STUDENT_ADDRESS_AR"));
        event.setSeatPreRes(rs.getInt("SEATS_PREVIOUSLY_RESERVED"));
        
        return event;
    }
    
    public void insertStudent(StudentInformation event) throws Exception {                
        try {
            Connection conn = getConnection();
            
            String sql = "INSERT INTO STUDENTS "
                    + "( STUDENT_ID,"
                    + " STUDENT_FNAME_EN,"
                    + " STUDENT_FNAME_AR,"                    
                    + " STUDENT_LNAME_EN,"
                    + " STUDENT_LNAME_AR,"
                    + " STUDENT_PHONE_NUMBER,"
                    + " SEATS_PREVIOUSLY_RESERVED,"
                    + " STUDENT_ADDRESS_EN,"
                    + " STUDENT_ADDRESS_AR,"
                    + " VALUES ((select max(STUDENT_ID) from STUDENTS)+1,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql); 
            
            ps.setString(1, event.getStudentFNameEn());
            ps.setString(2, event.getStudentFNameAr());
            ps.setString(3, event.getStudentLNameEn());
            ps.setString(4, event.getStudentLNameAr()); 
            ps.setInt(5 ,   event.getPhone());
            ps.setInt(6 ,   event.getSeatPreRes());
            ps.setString(7, event.getStudentAddressEn());
            ps.setString(8, event.getStudentAddressAr());
                        
            
            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
    public void updateStudent(StudentInformation event) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "UPDATE STUDENTS SET "
                    + " STUDENT_FNAME_EN,"
                    + " STUDENT_FNAME_AR,"                    
                    + " STUDENT_LNAME_EN,"
                    + " STUDENT_LNAME_AR,"
                    + " STUDENT_PHONE_NUMBER,"
                    + " SEATS_PREVIOUSLY_RESERVED,"
                    + " STUDENT_ADDRESS_EN,"
                    + " STUDENT_ADDRESS_AR,"
                    + " WHERE STUDENT_ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, event.getStudentFNameEn());
            ps.setString(2, event.getStudentFNameAr());
            ps.setString(3, event.getStudentLNameEn());
            ps.setString(4, event.getStudentLNameAr()); 
            ps.setInt(5 ,   event.getPhone());
            ps.setInt(6 ,   event.getSeatPreRes());
            ps.setString(7, event.getStudentAddressEn());
            ps.setString(8, event.getStudentAddressAr());            
            ps.setInt(9, event.getStudentID());

            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
    public void deleteStudent(int student_id) throws Exception {
        Connection conn = getConnection();
        
        try {
            String sql = "DELETE FROM STUDENTS WHERE STUDENT_ID=?";                               
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
