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
import models.tutoring.Comment;
import models.tutoring.Person;
import models.tutoring.Post;

/**
 *
 * @author Ursina
 */
public class CommentsDao extends ConnectionDao{
    public ArrayList<Comment> buildComments(HashMap<Integer, Person> people, HashMap<Integer, Post> posts) 
            throws Exception {
        ArrayList<Comment> list = new ArrayList<>();        
        
        try {   
            Connection conn = getConnection();
            
            String sql = "SELECT * FROM COMMENTS";                        
            PreparedStatement ps = conn.prepareStatement(sql);            

            ResultSet rs = ps.executeQuery();           

            while (rs.next()) {
                list.add(populateCommentWithType(rs, people, posts));
            }
            
            rs.close();
            ps.close();
            
            return list;            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    private Comment populateCommentWithType(ResultSet rs, HashMap<Integer, Person> people, HashMap<Integer, Post> posts) 
            throws SQLException {
        Comment comment = new Comment();
        
        comment.setCommentId(rs.getInt("P_COMMENT_ID"));
        comment.setContent(rs.getString("CONTENT"));
        
        Post post = posts.get(rs.getInt("F_POST"));
        comment.setPost(post);
        
        Person person = people.get(rs.getInt("F_PERSON"));
        comment.setAuthor (person);                
        
        return comment;
    }
    
    private Comment populateComment(ResultSet rs) throws SQLException {
        Comment comment = new Comment();
        
        comment.setCommentId(rs.getInt("P_COMMENT_ID"));
        comment.setContent(rs.getString("CONTENT"));
        
        Person person = new Person();
        person.setPersonId(rs.getInt("PERSON_ID"));        
        comment.setAuthor(person);                
        
        return comment;
    }
    
    public void insertComment(Comment comment) throws Exception {                
        try {
            Connection conn = getConnection();
            
            String sql = "INSERT INTO COMMENTS (P_COMMENT_ID,"
                    + " CONTENT,"
                    + " F_PERSON,"
                    + " F_POST)"
                    + " VALUES ((select max(P_COMMENT_ID) from COMMENTS)+1,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql); 
            
            ps.setString(1, comment.getContent());
            ps.setInt(2, comment.getAuthor().getPersonId());
            ps.setInt(3, comment.getPost().getPostId());
            
            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
    public void updateComment(Comment comment) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "UPDATE COMMENTS SET CONTENT=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, comment.getContent());

            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
    public void deleteComment(int commentId) throws Exception {
        Connection conn = getConnection();
        
        try {
            String sql = "DELETE FROM COMMENTS WHERE P_COMMENT_ID=?";                               
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, commentId);
            
            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
    public Comment getComment(int commentId) throws Exception {
        try {   
            Comment comment = null;
            Connection conn = getConnection();
            
            String sql = "SELECT COMMENTS.*, "
                    + " FROM COMMENTS "
                    + " WHERE P_COMMENT_ID=?";                        
            PreparedStatement ps = conn.prepareStatement(sql);            
            ps.setInt(1, commentId);
            
            ResultSet rs = ps.executeQuery();           

            while (rs.next()) {
                comment = populateComment(rs);
            }

            rs.close();
            ps.close();
            
            return comment;            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
            
    public static void main(String [] args){        
        try {
            CommentsDao dao = new CommentsDao();                
            //ArrayList<Event> events = dao.buildEvents();
        } catch (Exception ex) {
            Logger.getLogger(CommentsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}