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
import models.tutoring.Major;
import models.tutoring.School;

/**
 *
 * @author Abdalla
 */
public class MajorsDao extends ConnectionDao  {
        public ArrayList<Major> buildMajors(HashMap <Integer, School> schools) throws Exception {
        ArrayList<Major> list = new ArrayList<>();
        Connection conn = getConnection();
        
try {            
            String sql = "SELECT * FROM MAJORS ORDER BY P_MAJOR_ID";                        
            PreparedStatement ps = conn.prepareStatement(sql);            

            ResultSet rs = ps.executeQuery();           

            while (rs.next()) {
                list.add(populateMajorWithSchool(rs, schools));
            }
            
            rs.close();
            ps.close();
            
          return list;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

   public HashMap<Integer, Major> buildMajorsMap(HashMap <Integer, School> schools) throws Exception {
        HashMap<Integer, Major> map = new HashMap<>();
        Connection conn = getConnection();     
        
         try {            
            String sql = "SELECT * FROM MAJORS ORDER BY P_MAJOR_ID";                        
            PreparedStatement ps = conn.prepareStatement(sql);            

            ResultSet rs = ps.executeQuery();           

            while (rs.next()) {
                Major major = populateMajorWithSchool(rs, schools);
                map.put(major.getMajorId(), major);
            }
            
            rs.close();
            ps.close();

            return map;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }

   }
   
       private Major populateMajorWithSchool(ResultSet rs, HashMap <Integer, School> schools) throws SQLException {
        Major major = new Major();
        
        major.setMajorId(rs.getInt("P_MAJOR_ID"));
        major.setNameAr(rs.getString("MAJOR_NAME_EN"));
        major.setNameEn(rs.getString("MAJOR_NAME_AR"));
        
        School school = schools.get(rs.getInt("F_SCHOOL"));
        major.setSchool(school);
        
        return major;
    } 
   
}

