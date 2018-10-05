/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *conectado
 * @author vinicius
 */
public class ConnectionFactory{
    
    public static Connection getConnection (){
        
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_cadastro","root","root");
            
        } catch(SQLException ex){
            throw new RuntimeException("Erro na conexao: ", ex);
          }        
    }
    
   public static void closeConnection(Connection con){
        try{
            if(con != null){
                con.close();
            }        
        }catch(SQLException ex){
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    /**
     *
     * @param con
     * @param stmt
     */
    public static void closeConnection(Connection con, PreparedStatement stmt){
        
        closeConnection(con);
        
        try {
                
            if(stmt != null){
                stmt.close();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    public static void closeConnection(Connection con, com.mysql.jdbc.PreparedStatement stmt, ResultSet rs){
        
        closeConnection(con, stmt);
        
        try {
                
            if(rs != null){
                rs.close();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
  
 


}
