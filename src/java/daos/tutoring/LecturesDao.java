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
import models.tutoring.Lecture;
import models.tutoring.Major;


/**
 *
 * @author Abdalla
 */
public class LecturesDao extends ConnectionDao {
      public ArrayList<Lecture> buildLecturess(HashMap<Integer, Major> majors) 
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
        lecture.setMajor(rs.getMajor("F_MAJOR")); //see timeStamp in event's Dao & model//
        
        //lecture.setPosts(rs.getString("PLACE_EN"));
        
        Major majorType = majors.get(rs.getInt("P_MAJOR_ID"));        
        lecture.setMajor(majorType);            //treating major as an object    
        
        return lecture;
    }
    
     private Lecture populateLecture(ResultSet rs) throws SQLException {
        Lecture lecture = new Lecture();
        
        lecture.setLectureId(rs.getInt("P_LECTURE_ID"));
        lecture.setLectureCode(rs.getString("LECTURE_ID"));
        lecture.setLectureNameEn(rs.getString("LECTURE_NAME_EN"));
        lecture.setLectureNameAr(rs.getString("LECTURE_NAME_AR"));
        lecture.setLectureId(rs.getInt("F_MAJOR"));               
        
        Major majorType = new Major();
        majorType.setMajor(rs.getInt("P_MAJOR_ID"));        
        lecture.setMajor(majorType);
        
        return lecture;
    }   
     
     public void insertLecture(Lecture lecture) throws Exception {                
        try {
            Connection conn = getConnection();
            
            String sql = "INSERT INTO LECTURES (P_LECTURE_ID,"
                    + " LECTURE_ID,"
                    + " LECTURE_NAME_EN,"
                    + " LECTURE_NAME_AR,"
                    + " F_MAJOR," 
                    + " VALUES ((select max(P_LECTURE_ID) from LECTURES)+1,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql); 
            
            ps.setString(1, lecture.getLectureCode());
            ps.setString(2, lecture.getLectureNameEn());
            ps.setString(3, lecture.getLectureNameAr());
            ps.setMajor(4, lecture.getMajor());
            
            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
     
     
      public void updateLecture(Lecture lecture) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "UPDATE LECTURES SET LECTURE_ID=?,"
                    + " LECTURE_NAME_EN=?,"
                    + " LECTURE_NAME_AR=?,"
                    + " F_MAJOR=?,"
                    + " WHERE P_LECTURE_ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, lecture.getLectureCode());
            ps.setString(2, lecture.getLectureNameEn());
            ps.setString(3, lecture.getLectureNameAr());
            ps.setMajor(4, lecture.getMajor());
            
            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
            
}
