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
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vinicius
 */
public class CustomerDAO {
    public boolean AlterarFuncionario(Customer c) throws SQLException{
    Connection conn = ConnectionFactory.getConnection();
            
    String sql = "UPDATE bd_cadastro.Customer SET id_customer=?, id_country=?, name_user=?,  phone=?, age=?,creditLimit=? WHERE id_customer=?";
 
    PreparedStatement statement = conn.prepareStatement(sql);
                System.out.println("Oiiii"+c.getCountry().getId());

            statement.setInt(1, c.getId_user());
            statement.setInt(2, c.getCountry().getId());
            statement.setString(3,c.getName());
            statement.setString(4,c.getPhone());
            statement.setInt(5,c.getAge());
            statement.setDouble(6,c.getCreditLimit());  
            statement.setInt(7, c.getId_user());
    int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
        System.out.println("An existing user was updated successfully!");
        ConnectionFactory.closeConnection(conn,statement);
        return true;
    }else{
            ConnectionFactory.closeConnection(conn,statement);
        return false;
        }
    }
    public boolean CadastrarFuncionario(Customer c) throws SQLException{
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;

        try {
            stmt = (PreparedStatement) con.prepareStatement("INSERT INTO Customer VALUES(?,?,?,?,?,?)");
            stmt.setInt(1, c.getId_user());
            stmt.setInt(2, c.getCountry().getId());
            stmt.setString(3,c.getName());
            stmt.setString(4,c.getPhone());
            stmt.setInt(5,c.getAge());
            stmt.setDouble(6,c.getCreditLimit());            
           // stmt.setString(6,c.getCountry().getName());
            
            
        
            stmt.executeUpdate();
        
            ConnectionFactory.closeConnection(con,stmt);
            return true;
        }catch (SQLException ex){
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
            ConnectionFactory.closeConnection(con,stmt);
            return false;               
        }    
    }
    
     public ArrayList<Customer> readPesquisa(){
	
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList <Customer> c = new ArrayList<>();
        System.out.println("Estou aqui");
        
        try{
             //SELECT * FROM Customer               
             //SELECT * FROM Country JOIN Customer USING (id)
             //SELECT id, name_user,phone,age,creditLimit,name FROM Country JOIN Customer USING (id)
            stmt = con.prepareStatement("SELECT id_customer,id_country, name_user,phone,age,creditLimit,name,phoneDigits FROM Country JOIN Customer USING (id_country)");
            rs = stmt.executeQuery();
            
            

            while (rs.next()) {
                
                Customer cou = new Customer();
                
                cou.setId_user(rs.getInt("id_customer"));
                cou.getCountry().setId(rs.getInt("id_country"));
                cou.getCountry().setPhoneDigits(rs.getInt("phoneDigits"));
                try {
                    cou.setName(rs.getString("name_user"));
                } catch (Exception ex) {
                    Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                try {
                    cou.setPhone(rs.getString("phone"));
                } catch (Exception ex) {
                    Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                cou.setAge(rs.getInt("age"));
                cou.setCreditLimit(rs.getDouble("creditLimit"));   
              
                cou.getCountry().setName(rs.getString("name"));
                
               
                //cou.getCountry().setAcronym(rs.getString("acronym"));
                
                //res.getProduto().setNome_produto(rs.getString("nome_produto"));
               //getCountry().getName()
                
                
                c.add(cou);
                
            }
            
            //ConnectionFactory.closeConnection(con, stmt, rs);
            return c;
            
        } catch (SQLException ex) {

            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
            //ConnectionFactory.closeConnection(con, stmt, rs);
            return null;
            
        }
    }
     
     
     
       

    
    
    
}
