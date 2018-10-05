/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;


import edu.utfpr.cp.sa.entity.Country;
import edu.utfpr.cp.sa.entity.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vinicius
 */
public class CountryDAO {

   
    
    public boolean CadastrarFuncionario(Country c) throws SQLException{
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;

        try {
            stmt = (PreparedStatement) con.prepareStatement("INSERT INTO Country VALUES(?,?,?,?)");
            stmt.setInt(1,c.getId());
            stmt.setString(2,c.getName());
            stmt.setString(3,c.getAcronym());
            stmt.setInt(4,c.getPhoneDigits());
            
        
            stmt.executeUpdate();
        
            ConnectionFactory.closeConnection(con,stmt);
            return true;
        }catch (SQLException ex){
            Logger.getLogger(CountryDAO.class.getName()).log(Level.SEVERE, null, ex);
            ConnectionFactory.closeConnection(con,stmt);
            return false;               
        }    
    }
    
    
    
    
    
    
    
     public ArrayList<Country> readPesquisa(){
	
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList <Country> c = new ArrayList<>();
        //Set <Country> c = new HashSet<Country>();
        
        try{
        
            stmt = con.prepareStatement("SELECT * FROM Country");
            rs = stmt.executeQuery();
            
            

            while (rs.next()) {
                
                Country cou = new Country();
                
                cou.setId(rs.getInt("id_country"));
                cou.setName(rs.getString("name"));
                cou.setAcronym(rs.getString("acronym"));
                cou.setPhoneDigits(rs.getInt("phoneDigits"));
                
      
                c.add(cou);
            }
            
            //ConnectionFactory.closeConnection(con, stmt, rs);
            return c;
            
        } catch (SQLException ex) {

            Logger.getLogger(CountryDAO.class.getName()).log(Level.SEVERE, null, ex);
            //ConnectionFactory.closeConnection(con, stmt, rs);
            return null;
            
        }
    }
    public Set<Country> readCountry(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        // List<String> strList = new ArrayList<String>();
         //List<Country> strList = new ArrayList<Country>();
        //ArrayList <Country> strList = new ArrayList<>();
        Set <Country> strList = new HashSet<Country>();
        
        
        try{
     
        stmt = con.prepareStatement("SELECT * FROM bd_cadastro.Country;");
        rs = stmt.executeQuery();
      
        
        while(rs.next()){
            Country cou = new Country();
                //strList.add(rs.getString("name_country"));
           
            cou.setId(rs.getInt("id_country"));
            cou.setName(rs.getString("name"));
            cou.setAcronym(rs.getString("acronym"));
            cou.setPhoneDigits(rs.getInt("phoneDigits"));
            
            //cou.setPhoneDigits(rs.getInt("phoneDigits"));
            strList.add(cou);
        }
      
        return strList;
         } catch (SQLException ex) {

            Logger.getLogger(CountryDAO.class.getName()).log(Level.SEVERE, null, ex);
            //ConnectionFactory.closeConnection(con, stmt, rs);
            return null;
            
        }
     }
     
    
}
