package edu.utfpr.cp.sa.gui;

import connection.CountryDAO;
import connection.CustomerDAO;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import edu.utfpr.cp.sa.entity.Country;
import edu.utfpr.cp.sa.entity.Customer;

import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;

class CustomerTableModel extends AbstractTableModel {
	
	private ArrayList<Customer> customers;
	private String columnNames[] = {"ID_Customer","ID_Country","Name", "Phone", "Credit Limit", "Age", "Country"};
	
	public CustomerTableModel(Set<Customer> customers) {
		this.customers = new CustomerDAO().readPesquisa();
	}
	
	@Override
	public int getRowCount() {
		return customers.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		switch (columnIndex) {
			case 0:
				return this.customers.get(rowIndex).getId_user();
                              
                        case 1:
                                return this.customers.get(rowIndex).getCountry().getId();
				
			case 2:
				return this.customers.get(rowIndex).getName();
				
			case 3:
				return this.customers.get(rowIndex).getPhone();

			case 4:
				return this.customers.get(rowIndex).getCreditLimit();

			case 5:
				return this.customers.get(rowIndex).getAge();
                        
                        case 6:
                                return this.customers.get(rowIndex).getCountry().getName();
				
			default:
				break;
		}
		
		return null;
	}
	
}

public class CustomerWindow extends JFrame {

	private JPanel contentPane;
        private JTextField id;
	private JTextField name;
	private JTextField phone;
	private JTextField age;
	private JComboBox<String> country;
	private JTable table;
	
	private Set<Customer> customers;
        //private ArrayList<Country> countries;
	private Set<Country> countries;
	
        
        private void altera(){
        Customer c = new Customer();
                CustomerDAO customerdao = new CustomerDAO();
		Country selected = countries.stream().filter(e -> e.getName().equalsIgnoreCase((String) country.getSelectedItem()))
		.findFirst().get();
		
                c.setId_user(new Integer (id.getText()));    
                
		try {
			c.setCountry(selected);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
			return;
			
		}
		
		c.setAge(new Integer (age.getText()));
		
		try {
			c.setName(name.getText());
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
			return;
			
		}
		
		try {
			c.setPhone(phone.getText());

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
			return;
			
		}
						

                        
                try {
                    if(customerdao.AlterarFuncionario(c)){
                    JOptionPane.showMessageDialog(this, "Customer successfully added!");
			this.table.setModel(new CustomerTableModel(customers));
			this.pack();
                }else{
                    JOptionPane.showMessageDialog(this, "Sorry, customer already exists");
                }
                } catch (SQLException ex) {
                    Logger.getLogger(CountryWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
		
        
        
        
        }
	private void create () {
		Customer c = new Customer();
                CustomerDAO customerdao = new CustomerDAO();
		Country selected = countries.stream().filter(e -> e.getName().equalsIgnoreCase((String) country.getSelectedItem()))
		.findFirst().get();
		
                c.setId_user(new Integer (id.getText()));    
                
		try {
			c.setCountry(selected);//como colocar o nome 
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
			return;
			
		}
		
		c.setAge(new Integer (age.getText()));
		
		try {
			c.setName(name.getText());
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
			return;
			
		}
		
		try {
			c.setPhone(phone.getText());

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
			return;
			
		}
						

                        
                try {
                    if(customerdao.CadastrarFuncionario(c)){
                    JOptionPane.showMessageDialog(this, "Customer successfully added!");
			this.table.setModel(new CustomerTableModel(customers));
			this.pack();
                }else{
                    JOptionPane.showMessageDialog(this, "Sorry, customer already exists");
                }
                } catch (SQLException ex) {
                    Logger.getLogger(CountryWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
		
	}
	
	public CustomerWindow(Set<Customer> customers, Set<Country> countries) {
		this.customers = customers;
		this.countries = new CountryDAO().readCountry();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane panelTable = new JScrollPane();
		contentPane.add(panelTable, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new CustomerTableModel(customers));
		panelTable.setViewportView(table);
		
		JPanel panelInclusion = new JPanel();
		contentPane.add(panelInclusion, BorderLayout.NORTH);
		panelInclusion.setLayout(new GridLayout(7, 2, 0, 0));
                
                JLabel lblId = new JLabel("ID");
                panelInclusion.add(lblId);
                
                id = new JTextField();
                panelInclusion.add(id);
                id.setColumns(10);
                
		
		JLabel lblName = new JLabel("Name");
		panelInclusion.add(lblName);
		
		name = new JTextField();
		panelInclusion.add(name);
		name.setColumns(10);
		
		JLabel lblPhone = new JLabel("Phone");
		panelInclusion.add(lblPhone);
		
		phone = new JTextField();
		panelInclusion.add(phone);
		phone.setColumns(10);

		JLabel lblAge = new JLabel("Age");
		panelInclusion.add(lblAge);
		
		age = new JTextField();
		panelInclusion.add(age);
		age.setColumns(10);
		
		JLabel lblCountry = new JLabel("Country");
		panelInclusion.add(lblCountry);
		
                country = new JComboBox<>(this.countries.stream().map(Country::getName).toArray(String[]::new  ));
                
		//country = new JComboBox<> (countries.strList.toArray());
                //DefaultComboBoxModel defaultComboBox = new DefaultComboBoxModel(strList.toArray());
                //comboBox.setModel(defaultComboBoxModel);
		panelInclusion.add(country);
		
		JButton btnCreate = new JButton("Create");
		panelInclusion.add(btnCreate);
		btnCreate.addActionListener(e -> this.create());
		
		JButton btnClose = new JButton("Close");
		panelInclusion.add(btnClose);
		btnClose.addActionListener(e -> this.dispose());
                
                JButton btnAltera = new JButton("Alterar");
                panelInclusion.add(btnAltera);
                btnAltera.addActionListener(e -> this.altera());
		
		this.pack();
		this.setVisible(true);
	}

}
