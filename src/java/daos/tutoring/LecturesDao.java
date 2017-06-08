/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos.tutoring;

import daos.ConnectionDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.tutoring.Lecture;
import models.tutoring.Major;


/**
 *
 * @author Abdalla
 */
public class LecturesDao extends ConnectionDao {
      public ArrayList<Lecture> buildLectures(HashMap<Integer, Major> majors) 
            throws Exception {
        ArrayList<Lecture> list = new ArrayList<>();
        
                try {   
            Connection conn = getConnection();
            
            String sql = "SELECT * FROM LECTURES";                        
            PreparedStatement ps = conn.prepareStatement(sql);            

            ResultSet rs = ps.executeQuery();           

            while (rs.next()) {
                list.add(populateLectureWithMajor(rs, majors));
            }
            
            rs.close();
            ps.close();
            
            return list;            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
      
    private Lecture populateLectureWithMajor(ResultSet rs, HashMap<Integer, Major> majors) 
            throws SQLException {
        Lecture lecture = new Lecture();
        
        lecture.setLectureId(rs.getInt("P_LECTURE_ID"));
        lecture.setLectureCode(rs.getString("LECTURE_ID"));
        lecture.setLectureNameEn(rs.getString("LECTURE_NAME_EN"));
        lecture.setLectureNameAr(rs.getString("LECTURE_NAME_AR"));
        lecture.setMajor(majors.get(rs.getInt("F_MAJOR"))); 
        
        Major major = majors.get(rs.getInt("P_MAJOR_ID"));        
        lecture.setMajor(major);               
        
        return lecture;
    }
    
     private Lecture populateLecture(ResultSet rs) throws SQLException {
        Lecture lecture = new Lecture();
        
        lecture.setLectureId(rs.getInt("P_LECTURE_ID"));
        lecture.setLectureCode(rs.getString("LECTURE_ID"));
        lecture.setLectureNameEn(rs.getString("LECTURE_NAME_EN"));
        lecture.setLectureNameAr(rs.getString("LECTURE_NAME_AR"));
        lecture.setLectureId(rs.getInt("F_MAJOR"));               
        
        Major major = new Major();
        major.setMajorId(rs.getInt("F_MAJOR"));        
        lecture.setMajor(major);
        
        return lecture;
    }   

    public Lecture getLecture(int lectureId) throws Exception {
        try {   
            Lecture lecture = null;
            Connection conn = getConnection();
            
            String sql = "SELECT LECTURES.*, "
                    + " MAJORS.MAJOR_NAME_EN as MAJ_N_E"
                    + " MAJORS.MAJOR_NAME_AR as MAJ_N_A"                   
                    + " FROM LECTURES, MAJORS "
                    + " WHERE LECTURES.F_MAJOR=MAJORS.P_MAJOR_ID AND"
                    + " P_LECTURE_ID=?";                        
            PreparedStatement ps = conn.prepareStatement(sql);            
            ps.setInt(1, lectureId);
            
            ResultSet rs = ps.executeQuery();           

            while (rs.next()) {
                lecture = populateLecture(rs);
                lecture.getMajor().setNameEn("MAJ_N_E");
                lecture.getMajor().setNameAr("MAJ_N_A");                
            }

            rs.close();
            ps.close();
            
            return lecture;            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
     
        public static void main(String [] args){        
        try {
            LecturesDao dao = new LecturesDao();                
            //ArrayList<Event> events = dao.buildEvents();
        } catch (Exception ex) {
            Logger.getLogger(PersonsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}