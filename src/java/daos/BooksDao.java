/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Event;
import models.EventType;
/**
 *
 * @author tarekashi
 */
public class BooksDao extends ConnectionDao {
    
            throws Exception {
        ArrayList<Event> list = new ArrayList<>();        
        
        try {   
            Connection conn = getConnection();
            
            String sql = "SELECT * FROM EVENTS";                        
            PreparedStatement ps = conn.prepareStatement(sql);            

            ResultSet rs = ps.executeQuery();           

            while (rs.next()) {
                list.add(populateEventWithType(rs, eventTypes));
            }
            
            rs.close();
            ps.close();
            
            return list;            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
}
