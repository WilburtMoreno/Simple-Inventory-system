/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory_frames;

import java.sql.*;
public class mysqlConnection {
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
  
    public Connection getConnection() {
        Connection connect = null;
        try{
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/simple_inv","root","");
            return connect;
        }catch(Exception e) {System.out.println("getConnection error: " + e); return null;}
    }
}
