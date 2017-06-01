package daos.bus_reservation;
  
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.bus_reservation.StudentInformation;


/**
 *
 * @author Kamal Jabari
 * 
 */
public class StudentInformationDao extends BusConnectionDao { 
    
    public ArrayList<StudentInformation> getStudent() throws Exception {
                
        ArrayList<StudentInformation> list = new ArrayList<>();
        try {   
            Connection conn = getConnection();
            
            String sql = "SELECT * FROM STUDENTS";                        
            PreparedStatement ps = conn.prepareStatement(sql);            

            ResultSet rs = ps.executeQuery();           

            while (rs.next()) {
                list.add(populateStudent(rs));
            }
            
            rs.close();
            ps.close();
            
            return list;            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

   
    
    private StudentInformation populateStudent(ResultSet rs) throws SQLException {
        StudentInformation student = new StudentInformation();
        
        student.setStudentID(rs.getInt("STUDENT_ID"));
        student.setStudentFNameEn(rs.getString("STUDENT_FIRST_NAME_EN"));
        student.setStudentLNameEn(rs.getString("STUDENT_LAST_NAME_EN"));
        student.setStudentFNameAr(rs.getString("STUDENT_FIRST_NAME_AR"));
        student.setStudentLNameAr(rs.getString("STUDENT_LAST_NAME_AR"));
        student.setPhone(rs.getInt("STUDENT_PHONE_NUMBER"));
        student.setStudentAddressEn(rs.getString("STUDENT_ADDRESS_EN"));
        student.setStudentAddressAr(rs.getString("STUDENT_ADDRESS_AR"));
        student.setSeatPreRes(rs.getInt("SEATS_PREVIOUSLY_RESERVED"));
        
        return student;
    }
    
    public void insertStudent(StudentInformation student) throws Exception {                
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
                    + " STUDENT_ADDRESS_AR)"
                    + " VALUES ((select max(STUDENT_ID) from STUDENTS)+1,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql); 
            
            ps.setString(1, student.getStudentFNameEn());
            ps.setString(2, student.getStudentFNameAr());
            ps.setString(3, student.getStudentLNameEn());
            ps.setString(4, student.getStudentLNameAr()); 
            ps.setInt(5 ,   student.getPhone());
            ps.setInt(6 ,   student.getSeatPreRes());
            ps.setString(7, student.getStudentAddressEn());
            ps.setString(8, student.getStudentAddressAr());
                        
            
            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
    public void updateStudent(StudentInformation student) throws Exception {
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
            
            ps.setString(1, student.getStudentFNameEn());
            ps.setString(2, student.getStudentFNameAr());
            ps.setString(3, student.getStudentLNameEn());
            ps.setString(4, student.getStudentLNameAr()); 
            ps.setInt(5 ,   student.getPhone());
            ps.setInt(6 ,   student.getSeatPreRes());
            ps.setString(7, student.getStudentAddressEn());
            ps.setString(8, student.getStudentAddressAr());            
            ps.setInt(9, student.getStudentID());

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
            //ArrayList<Event> students = dao.buildEvents();
        } catch (Exception ex) {
            Logger.getLogger(StudentInformationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
