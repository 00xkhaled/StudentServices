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

/**
 *
 * @author Ursina
 */
public class PersonsDao extends ConnectionDao{
    public ArrayList<Person> buildPersons(HashMap<Integer, Major> majors) 
            throws Exception {
        ArrayList<Person> list = new ArrayList<>();        
        
        try {   
            Connection conn = getConnection();
            
            String sql = "SELECT * FROM PERSONS";                        
            PreparedStatement ps = conn.prepareStatement(sql);            

            ResultSet rs = ps.executeQuery();           

            while (rs.next()) {
                list.add(populatePersonWithType(rs, majors));
            }
            
            rs.close();
            ps.close();
            
            return list;            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
       public HashMap<Integer, Person> buildPersonsMap(HashMap <Integer, Major> majors) throws Exception {
        HashMap<Integer, Person> map = new HashMap<>();
        Connection conn = getConnection();     
        
         try {            
            String sql = "SELECT * FROM PERSONS ORDER BY P_PERSON_ID";                        
            PreparedStatement ps = conn.prepareStatement(sql);            

            ResultSet rs = ps.executeQuery();           

            while (rs.next()) {
                Person person = populatePersonWithType(rs, majors);
                map.put(person.getPersonId(), person);
            }
            
            rs.close();
            ps.close();

            return map;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }

   }

    private Person populatePersonWithType(ResultSet rs, HashMap<Integer, Major> majors) 
            throws SQLException {
        Person person = new Person();
        
        person.setPersonId(rs.getInt("P_PERSON_ID"));
        person.setFirstNameEn(rs.getString("FIRST_NAME_EN"));
        person.setFirstNameAr(rs.getString("FIRST_NAME_AR"));
        person.setLastNameEn(rs.getString("LAST_NAME_EN"));
        person.setLastNameAr(rs.getString("LAST_NAME_AR"));
        person.setEmailAddress(rs.getString("EMAIL_ADRESS"));
        person.setPhoneNumber(rs.getString("PHONE_NUMBER"));
        person.setCreditScore(rs.getInt("CREDIT_SCORE"));
        
        Major major = majors.get(rs.getInt("F_MAJOR"));        
        person.setMajor(major);                
        
        return person;
    }
    
    private Person populatePerson(ResultSet rs) throws SQLException {
        Person person = new Person();
        
        person.setPersonId(rs.getInt("P_PERSON_ID"));
        person.setFirstNameEn(rs.getString("FIRST_NAME_EN"));
        person.setFirstNameAr(rs.getString("FIRST_NAME_AR"));
        person.setLastNameEn(rs.getString("LAST_NAME_EN"));
        person.setLastNameAr(rs.getString("LAST_NAME_AR"));
        person.setEmailAddress(rs.getString("EMAIL_ADRESS"));
        person.setPhoneNumber(rs.getString("PHONE_NUMBER"));
        person.setCreditScore(rs.getInt("CREDIT_SCORE"));
        
        Major major = new Major();
        major.setMajorId(rs.getInt("F_MAJOR"));        
        person.setMajor(major);                
        
        return person;
    }
    
    public void updatePerson(Person person) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "UPDATE PERSONS SET FIRST_NAME_EN=?,"
                    + " FIRST_NAME_AR=?,"
                    + " LAST_NAME_EN=?,"
                    + " LAST_NAME_AR=?,"
                    + " EMAIL_ADRESS=?,"
                    + " PHONE_NUMBER=?"
                    + " CREDIT_SCORE=?"
                    + " F_MAJOR=?"
                    + " WHERE P_PERSON_ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, person.getFirstNameEn());
            ps.setString(2, person.getFirstNameAr());
            ps.setString(3, person.getLastNameEn());
            ps.setString(4, person.getLastNameAr());
            ps.setString(5, person.getEmailAddress());
            ps.setString(5, person.getPhoneNumber());
            ps.setInt(6, person.getCreditScore());
            ps.setInt(7, person.getMajor().getMajorId());
            ps.setInt(8, person.getPersonId());

            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
    public Person getPerson(int personId) throws Exception {
        try {   
            Person person = null;
            Connection conn = getConnection();
            
            String sql = "SELECT PERSONS.*, "
                    + " MAJORS.MAJOR_NAME_EN as MAJ_N_E"
                    + " MAJORS.MAJOR_NAME_AR as MAJ_N_A" 
                    + " FROM PERSONS "
                    + " WHERE PERSONS.F_MAJOR=MAJORS.P_MAJOR_ID AND"
                    + " P_PERSON_ID=?";                        
            PreparedStatement ps = conn.prepareStatement(sql);            
            ps.setInt(1, personId);
            
            ResultSet rs = ps.executeQuery();           

            while (rs.next()) {
                person = populatePerson(rs);
                person.getMajor().setNameEn(rs.getString("MAJ_N_E"));
                person.getMajor().setNameAr(rs.getString("MAJ_N_A"));
            }

            rs.close();
            ps.close();
            
            return person;            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
            
    public static void main(String [] args){        
        try {
            PersonsDao dao = new PersonsDao();                
            //ArrayList<Event> events = dao.buildEvents();
        } catch (Exception ex) {
            Logger.getLogger(PersonsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
