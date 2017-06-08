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
import models.tutoring.Major;
import models.tutoring.Person;
import models.tutoring.Tutoring;

/**
 *
 * @author Ursina
 */
public class TutoringsDao extends ConnectionDao{
    public ArrayList<Tutoring> buildTutorings(HashMap <Integer, Person> persons) 
            throws Exception {
        ArrayList<Tutoring> list = new ArrayList<>();        
        
        try {   
            Connection conn = getConnection();
            
            String sql = "SELECT * FROM TUTORINGS";   
            PreparedStatement ps= conn.prepareStatement(sql);   

            ResultSet rs = ps.executeQuery();           
            
            while (rs.next()) {
                list.add(populateTutoringWithType(rs, persons));
            }
            
            rs.close();
            ps.close();
            
            return list;            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    private Tutoring populateTutoringWithType(ResultSet rs, HashMap <Integer, Person> persons) 
            throws SQLException {
        Tutoring tut = new Tutoring();
        
        tut.setTutoringId(rs.getInt("TUTORING_ID"));
        tut.setDay(rs.getString("DAY_VAR"));
        tut.setTime(rs.getString("TIME_VAR"));
        tut.setLocation(rs.getString("LOCATION"));
        tut.setOffered(rs.getTimestamp("OFFERED"));

        
        Person person = persons.get(rs.getInt("F_TUTOR"));
        tut.setTutor(person);                
        
        return tut;
    }
    
    private Tutoring populateTutoring(ResultSet rs) throws SQLException {
        Tutoring tut = new Tutoring();
        
        tut.setTutoringId(rs.getInt("TUTORING_ID"));
        tut.setDay(rs.getString("DAY_VAR"));
        tut.setTime(rs.getString("TIME_VAR"));
        tut.setLocation(rs.getString("LOCATION"));
        tut.setOffered(rs.getTimestamp("OFFERED"));
                
        Major major = new Major();
        major.setMajorId(rs.getInt("MAJ"));
        
        Person person = new Person();
        person.setPersonId(rs.getInt("F_TUTOR"));
        person.setMajor(major);
        
        tut.setTutor(person);
        
        
        return tut;
    }
    
    public void insertTutoring(Tutoring tut) throws Exception {                
        try {
            Connection conn = getConnection();
            
            String sql = "INSERT INTO TUTORINGS (P_TUTORING_ID,"
                    + " DAY_VAR,"
                    + " TIME_VAR,"
                    + " LOCATION,"
                    + " OFFERED,"
                    + " F_TUTOR)"
                    + " VALUES ((select max(EVENT_ID) from EVENTS)+1,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql); 
            
            ps.setString(1, tut.getDay());
            ps.setString(2, tut.getTime());
            ps.setString(3, tut.getLocation());
            ps.setTimestamp(4, tut.getOffered());
            ps.setInt(5, tut.getTutor().getPersonId());

            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
    public void deleteTutoring(int tutoringId) throws Exception {
        Connection conn = getConnection();
        
        try {
            String sql = "DELETE FROM TUTORINGS WHERE TUTORING_ID=?";                               
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, tutoringId);
            
            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
    public Tutoring getTutoring(int tutoringId) throws Exception {
        try {   
            Tutoring tut = null;
            Connection conn = getConnection();
            
            String sql = "SELECT TUTORINGS.*, "
                    + " PERSONS.FIRST_NAME_EN as FN_E,"
                    + " PERSONS.FIRST_NAME_AR as FN_A "
                    + " PERSONS.LAST_NAME_EN as LN_E "
                    + " PERSONS.LAST_NAME_AR as LN_A "
                    + " PERSONS.EMAIL_ADDRESS as MAIL "
                    + " PERSONS.PHONE_NUMBER as PHONE "
                    + " PERSONS.CREDIT_SCORE as CS "
                    + " PERSONS.F_MAJOR as MAJ"
                    + " MAJORS.MAJOR_NAME_EN as MAJ_N_E"
                    + " MAJORS.MAJOR_NAME_AR as MAJ_N_A"                   
                    + " FROM TUTORINGS, PERSONS, MAJORS "
                    + " WHERE TUTORINGS.F_TUTOR=PERSONS.P_PERSON_ID AND"
                    + " PERSONS.F_MAJOR=MAJORS.P_MAJOR_ID AND"
                    + " P_TUTORING_ID=?";                        
            PreparedStatement ps = conn.prepareStatement(sql);            
            ps.setInt(1, tutoringId);
            
            ResultSet rs = ps.executeQuery();           

            while (rs.next()) {
                tut = populateTutoring(rs);
                tut.getTutor().setFirstNameEn(rs.getString("FN_E"));
                tut.getTutor().setFirstNameAr(rs.getString("FN_A"));
                tut.getTutor().setLastNameEn(rs.getString("LN_E"));
                tut.getTutor().setLastNameAr(rs.getString("LN_A"));
                tut.getTutor().setEmailAddress(rs.getString("MAIL"));
                tut.getTutor().setPhoneNumber(rs.getString("PHONE"));
                tut.getTutor().setCreditScore(rs.getInt("CS"));
                tut.getTutor().getMajor().setNameEn(rs.getString("MAJ_N_E"));
                tut.getTutor().getMajor().setNameAr(rs.getString("MAJ_N_A"));
            }

            rs.close();
            ps.close();
            
            return tut;            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
            
    public static void main(String [] args){        
        try {
            TutoringsDao dao = new TutoringsDao();                
            //ArrayList<Event> events = dao.buildEvents();
        } catch (Exception ex) {
            Logger.getLogger(TutoringsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
