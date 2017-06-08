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
import models.tutoring.School;

/**
 *
 * @author Abdalla
 */
public class SchoolsDao extends ConnectionDao  {
        public ArrayList<School> buildSchools() throws Exception {
        ArrayList<School> list = new ArrayList<>();
        Connection conn = getConnection();
        
try {            
            String sql = "SELECT * FROM SCHOOL ORDER BY SCHOOL_ID";                        
            PreparedStatement ps = conn.prepareStatement(sql);            

            ResultSet rs = ps.executeQuery();           

            while (rs.next()) {
                list.add(populateSchool(rs));
            }
            
            rs.close();
            ps.close();
            
          return list;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

   public HashMap<Integer, School> buildSchoolsMap() throws Exception {
        HashMap<Integer, School> map = new HashMap<>();
        Connection conn = getConnection();     
        
         try {            
            String sql = "SELECT * FROM SCHOOL ORDER BY SCHOOL_TYPE_ID";                        
            PreparedStatement ps = conn.prepareStatement(sql);            

            ResultSet rs = ps.executeQuery();           

            while (rs.next()) {
                School school = populateSchool(rs);
                map.put(school.getSchoolId(), school);
            }
            
            rs.close();
            ps.close();

            return map;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }

   }
   
       private School populateSchool(ResultSet rs) throws SQLException {
        School school = new School();
        
        school.setSchoolId(rs.getInt("SCHOOL_ID"));
        school.setNameAr(rs.getString("NAME_AR"));
        school.setNameEn(rs.getString("NAME_EN"));
       /* school.setMajors(rs.getArrayList<Major>("MAJORS");*/
        return school;
    } 
   
}

