/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos.library;

import static java.nio.file.Files.list;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.library.Book;
import models.library.Authors;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.library.Book;
import models.library.Authors;

/**
 *
 * @author tarekashi
 */
public class BookInformationDao extends LibraryConnectionDao {

    public ArrayList<Book> buildEvents(HashMap<Integer, Authors> authors) throws Exception {

        ArrayList<Book> list = new ArrayList<>();
        try {
            Connection conn = getConnection();

            String sql = "SELECT * FROM BOOKS";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(populateBookwithAuthors(rs, authors));
            }
            rs.close();
            ps.close();
            return list;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    private Book populateBookwithAuthors(ResultSet rs, HashMap<Integer, Authors> authors) throws SQLException {
        Book book = new Book();

        book.setBookId(rs.getInt("BOOK_ID"));
        book.setBooktitleEn(rs.getString("TITLE_EN"));
        book.setBooktitleAr(rs.getString("TITLE_AR"));
        book.setGenre(rs.getString("GENERE"));
        book.setPublishyear(rs.getInt("PUBLISH_YEAR"));
        book.setVersion(rs.getString("VERSION"));
        book.setNumofpages(rs.getInt("PAGE_NUMBERS"));
        book.setPrice(rs.getInt("PRICE"));
        book.setPriceday(rs.getInt("PRICE_DAY"));
        book.setStatus(rs.getString("STATUS"));
        book.setOwnername(rs.getString("OWNER_NAME"));
        Authors author = authors.get(rs.getInt("AUTHOR_ID"));
        book.setAuthor(author);
        return book;
    }

    private Book populateBook(ResultSet rs) throws SQLException {
        Book book = new Book();

        book.setBookId(rs.getInt("BOOK_ID"));
        book.setBooktitleEn(rs.getString("TITLE_EN"));
        book.setBooktitleAr(rs.getString("TITLE_AR"));
        book.setGenre(rs.getString("GENERE"));
        book.setPublishyear(rs.getInt("PUBLISH_YEAR"));
        book.setVersion(rs.getString("VERSION"));
        book.setNumofpages(rs.getInt("PAGE_NUMBERS"));
        book.setPrice(rs.getInt("PRICE"));
        book.setPriceday(rs.getInt("PRICE_DAY"));
        book.setStatus(rs.getString("STATUS"));
        book.setOwnername(rs.getString("OWNER_NAME"));

        Authors authors = new Authors();
        authors.setAuthorId(rs.getInt("AUTHOR_ID"));
        book.setAuthor(authors);

        return book;
    }

    public void insertBook(Book event) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "INSERT INTO BOOKS (BOOK_ID,"
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
                    + "AUTHOR_ID)"
                    + " VALUES ((select max(BOOK_ID) from BOOKS)+1,?,?,?,?,?,?,?,?,?,?)";
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
            ps.setInt(7, event.getAuthor().getAuthorId());
            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    // hamza

    public void BuyBook(Book book) throws Exception {
        Connection conn = getConnection();

        try {
            String sql = "UPDATE BOOKS SET OWNER_NAME=?,"
                    + " STATUS=?,"
                    + " WHERE BOOK_ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, book.getOwnername());
            ps.setString(2, book.getStatus());
            ps.setInt(3, book.getBookId());
            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public void borrowBook(Book book) throws Exception {
        Connection conn = getConnection();

        try {
            String sql = "UPDATE BOOKS SET RETURN_DATE=?,"
                    + " STATUS=?,"
                    + " WHERE BOOK_ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setTimestamp(1, book.getReturnDate());
            ps.setString(2, book.getStatus());
            ps.setInt(3, book.getBookId());

            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
// hamza 

    public Book getBook(int bookId) throws Exception {
        try {
            Book book = null;
            Connection conn = getConnection();

            String sql = "SELECT BOOKS.*, "
                    + " AUTHORS.AUTHOR_NAME_EN as AUTHOR_EN,"
                    + " AUTHORS.AUTHOR_NAME_AR as AUTHOR_AR "
                    + " FROM BOOKS, AUTHORS "
                    + " WHERE BOOKS.AUTHOR_ID=AUTHORS.AUTHOR_ID AND"
                    + " BOOK_ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, bookId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                book = populateBook(rs);
                book.getAuthorEn().setAuthornameEn(rs.getString("AUTHOR_EN"));
                book.getAuthorAr().setAuthornameAr(rs.getString("AUTHOR_AR"));
            }

            rs.close();
            ps.close();

            return book;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            BookInformationDao dao = new BookInformationDao();
            //ArrayList<Event> events = dao.buildEvents();
        } catch (Exception ex) {
            Logger.getLogger(BookInformationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
