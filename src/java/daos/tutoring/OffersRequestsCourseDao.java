package daos.tutoring;

import daos.ConnectionDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import models.tutoring.OffersRequestsCourse;
import models.tutoring.Person;
import models.tutoring.Tutoring;

/**
 *
 * @author Dr. Firas Al-Hawari
 * 
 */
public class OffersRequestsCourseDao extends ConnectionDao {     
    /*public ArrayList<OffersRequestsCourse> buildORC(HashMap<Integer, Person> persons, HashMap <Integer, Tutoring> tutorings) throws Exception {
        ArrayList<OffersRequestsCourse> list = new ArrayList<>();
        Connection conn = getConnection();
        
        try {            
            String sql = "SELECT * FROM OFFERS_REQUESTS_COURSE ORDER_BY P_OR_COURSE_ID";                        
            PreparedStatement ps = conn.prepareStatement(sql);            

            ResultSet rs = ps.executeQuery();           

            while (rs.next()) {
                list.add(populateORCType(rs));
            }
            
            rs.close();
            ps.close();

            return list;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }*/
    
    public HashMap<Integer, OffersRequestsCourse> buildORCMap(HashMap<Integer, Person> persons, HashMap <Integer, Tutoring> tutorings) throws Exception {
        HashMap<Integer, OffersRequestsCourse> map = new HashMap<>();
        Connection conn = getConnection();
        
        try {            
            String sql = "SELECT * FROM OFFERS_REQUESTS_COURSE ORDER_BY P_OR_COURSE_ID";                        
            PreparedStatement ps = conn.prepareStatement(sql);            

            ResultSet rs = ps.executeQuery();           

            while (rs.next()) {
                OffersRequestsCourse oRCourse = populateORCType(rs, persons, tutorings);
                map.put(oRCourse.getOffersRequestsCourseId(), oRCourse);
            }
            
            rs.close();
            ps.close();

            return map;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    private OffersRequestsCourse populateORCType(ResultSet rs,HashMap<Integer, Person> persons, HashMap <Integer, Tutoring> tutorings) throws SQLException {
        
        OffersRequestsCourse oRCourse = new OffersRequestsCourse();
        
        oRCourse.setOffersRequestsCourseId(rs.getInt("P_OR_COURSE_ID"));
        oRCourse.setAccpeted(rs.getInt("ACCEPTED") == 0 ? false: true);
        
        Person person = persons.get(rs.getInt("F_STUDENT_RECEIVER_ID"));
        oRCourse.setLearner(person);
        
        Tutoring tutoring = tutorings.get(rs.getInt("F_TUTORING_ID"));
        oRCourse.setTutoring(tutoring);
        
        return oRCourse;
    }   
}

