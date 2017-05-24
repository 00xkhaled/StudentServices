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
import LibraryModel.Book;
import LibraryDao.LibraryConnectionDao;


/**
 *
 * @author tarekashi
 */
public class BookInformationDao extends LibraryConnectionDao {
    public ArrayList<Book> buildEvents() throws Exception {
                
        ArrayList<Book> list = new ArrayList<>();
        try {   
            Connection conn = getConnection();
            
            String sql = "SELECT * FROM BOOKS";                        
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
    
     private Book populateEvent(ResultSet rs) throws SQLException {
        Book event = new Book();
        
         event.setBookId(rs.getInt("BOOK_ID"));
        event.setBooktitleEn(rs.getString("TITLE_EN"));
        event.setBooktitleAr(rs.getString("TITLE_AR"));
        event.setGenre(rs.getString("GENERE"));
        event.setPublishyear(rs.getInt("PUBLISH_YEAR"));
        event.setVersion(rs.getString("VERSION"));
        event.setNumofpages(rs.getInt("PAGE_NUMBERS"));
        event.setPrice(rs.getInt("PRICE"));
        event.setPriceday(rs.getInt("PRICE_DAY"));
        event.setStatus(rs.getString("STATUS"));
        event.setOwnername(rs.getString("OWNER_NAME"));
        return event;
    }
     
      public void insertBook(Book event) throws Exception {                
        try {
            Connection conn = getConnection();
            
            String sql = "INSERT INTO BOOKS "
                    + "( BOOK_ID,"
                    + " TITLE_EN,"
                    + " TITLE_AR,"
                    + " GENERE,"
                    + " PUBLISH_YEAR,"
                    + " VERSION,"
                    + " PAGE_NUMBERS,"
                    + " PRICE,"
                    + " PRICE_DAY,"
                    + " STATUS,"
                    + " OWNER_NAME,"
                    + " VALUES ((select max(BOOK_ID) from BOOKS)+1,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql); 
            
            ps.setInt(1, event.getBookId());
            ps.setString(2, event.getBooktitleEn());
            ps.setString(3, event.getBooktitleAr());
            ps.setString(4, event.getGenre());
            ps.setInt(5, event.getPublishyear());
            ps.setString(6, event.getVersion());
            ps.setInt(7, event.getNumofpages());
            ps.setInt(8, event.getPrice());
            ps.setInt(9, event.getPriceday());
            ps.setString(10, event.getStatus());
            ps.setString(11, event.getOwnername());
            
            
            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
      public static void main(String [] args){        
        try {
            BookInformationDao dao = new BookInformationDao();                
            //ArrayList<Event> events = dao.buildEvents();
        } catch (Exception ex) {
            Logger.getLogger(BookInformationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
