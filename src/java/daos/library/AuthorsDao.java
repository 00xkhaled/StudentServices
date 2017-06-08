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
import models.library.Authors;
import daos.library.LibraryConnectionDao;
import java.util.HashMap;

/**
 *
 * @author tarekashi
 */
public class AuthorsDao extends LibraryConnectionDao {

    public ArrayList<Authors> buildAuthors() throws Exception {
        ArrayList<Authors> list = new ArrayList<>();
        Connection conn = getConnection();
        try {
            String sql = "SELECT * FROM AUTHORS ORDER BY AUTHOR_ID";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(populateAuthor(rs));
            }
            rs.close();
            ps.close();
            return list;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public HashMap<Integer, Authors> buildAuthorsMap() throws Exception {
        HashMap<Integer, Authors> map = new HashMap<>();
        Connection conn = getConnection();

        try {
            String sql = "SELECT * FROM AUTHORS ORDER BY AUTHOR_ID";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Authors author = populateAuthor(rs);
                map.put(author.getAuthorId(), author);
            }
            rs.close();
            ps.close();

            return map;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    private Authors populateAuthor(ResultSet rs) throws SQLException {
        Authors author = new Authors();
        author.setAuthorId(rs.getInt("AUTHOR_ID"));
        author.setAuthornameEn(rs.getString("AUTHOR_NAME_EN"));
        author.setAuthornameAr(rs.getString("AUTHOR_NAME_AR"));
        return author;
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

    public static void main(String[] args) {
        try {
            AuthorsDao dao = new AuthorsDao();
            //ArrayList<Event> events = dao.buildEvents();
        } catch (Exception ex) {
            Logger.getLogger(AuthorsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
