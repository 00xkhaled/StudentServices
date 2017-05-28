/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibraryDao;

import static java.nio.file.Files.list;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.logging.Level;
import java.util.logging.Logger;
import LibraryModel.Authors;
import LibraryDao.LibraryConnectionDao;

/**
 *
 * @author tarekashi
 */
public class AuthorsDao extends LibraryConnectionDao {
    public ArrayList<Authors> buildEvents() throws Exception {
                
        ArrayList<Authors> list = new ArrayList<>();
        try {   
            Connection conn = getConnection();
            
            String sql = "SELECT * FROM AUTHORS";                        
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
    
     private Authors populateEvent(ResultSet rs) throws SQLException {
        Authors event = new Authors();
        
         event.setAuthorId(rs.getInt("AUTHOR_ID"));
        event.setAuthornameEn(rs.getString("AUTHOR_NAME_EN"));
        event.setAuthornameAr(rs.getString("AUTHOR_NAME_AR"));
        return event;
    }
     
      public void insertAuthor(Authors event) throws Exception {                
        try {
            Connection conn = getConnection();
            
            String sql = "INSERT INTO AUTHORS "
                    + "( AUTHOR_ID,"
                    + " AUTHOR_NAME_EN,"
                    + " AUTHOR_NAME_AR,"
                    + " VALUES ((select max(AUTHOR_ID) from AUTHORS)+1,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql); 
            
            ps.setInt(1, event.getAuthorId());
            ps.setString(2, event.getAuthornameEn());
            ps.setString(3, event.getAuthornameAr());
            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
      public static void main(String [] args){        
        try {
            AuthorsDao dao = new AuthorsDao();                
            //ArrayList<Event> events = dao.buildEvents();
        } catch (Exception ex) {
            Logger.getLogger(AuthorsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
