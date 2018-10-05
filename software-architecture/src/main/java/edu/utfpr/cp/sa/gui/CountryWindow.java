package edu.utfpr.cp.sa.gui;

import connection.CountryDAO;
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
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

class CountryTableModel extends AbstractTableModel {
	//List <Country> countries;
       private ArrayList<Country> countries;
        
	
	private String columnNames[] = {"Id","Name", "Acronym", "Phone Digits"};
	
	public CountryTableModel(Set<Country> countries) {
		this.countries = new CountryDAO().readPesquisa();
	}
	
	@Override
	public int getRowCount() {
                //CountryTableId.set();
		return countries.size();
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
		//CountryDAO cou = new CountryDAO();
                //countries = cou.readPesquisa();
                
                //System.out.println("aqui");
                //System.out.println(countries);
                
		switch (columnIndex) {
			case 0: return this.countries.get(rowIndex).getId();        
				
				
			case 1:return this.countries.get(rowIndex).getName();
				
				
			case 2:return this.countries.get(rowIndex).getAcronym();
				
                         
                        case 3: return this.countries.get(rowIndex).getPhoneDigits();
                       
	
			default:
				break;
		}
		
		return null;
	}
	
}

public class CountryWindow extends JFrame {
       
	private JPanel contentPane;
        private JTextField Id;
	private JTextField name;
	private JTextField acronym;
	private JTextField phoneDigits;
	private JTable table;
	private Set<Country> countries;
        
	
	private void create () {
		Country c = new Country();
                CountryDAO countrydao = new CountryDAO();
               // countries = (Set<Country>) new CountryDAO().readPesquisa();
                //Id.setText(Integer.toString(countries.size()));
                //Id.setText("55mnjbjbjl");
                c.setId(new Integer (Id.getText()));
		c.setName(name.getText());
		c.setAcronym(acronym.getText());
		c.setPhoneDigits(new Integer(phoneDigits.getText()));
		
                 
                try {
                    if(countrydao.CadastrarFuncionario(c)){
                    JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso");
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "Você deve preencher todos os campos");
                }
                } catch (SQLException ex) {
                    Logger.getLogger(CountryWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
	
	public CountryWindow(Set<Country> countries) {
		this.countries = countries;
                
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane panelTable = new JScrollPane();
		contentPane.add(panelTable, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new CountryTableModel(countries));
		panelTable.setViewportView(table);
                
		
		JPanel panelInclusion = new JPanel();
		contentPane.add(panelInclusion, BorderLayout.NORTH);
		panelInclusion.setLayout(new GridLayout(5, 2, 0, 0));
                
                JLabel lblId = new JLabel("Id");
                panelInclusion.add(lblId);
                
                Id = new JTextField();
                panelInclusion.add(Id);
                Id.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		panelInclusion.add(lblName);
		
		name = new JTextField();
		panelInclusion.add(name);
		name.setColumns(10);
		
		JLabel lblAcronym = new JLabel("Acronym");
		panelInclusion.add(lblAcronym);
		
		acronym = new JTextField();
		panelInclusion.add(acronym);
		acronym.setColumns(10);
		
		JLabel lblPhoneDigits = new JLabel("Phone Digits");
		panelInclusion.add(lblPhoneDigits);
		
		phoneDigits = new JTextField();
		panelInclusion.add(phoneDigits);
		phoneDigits.setColumns(10);
		
		JButton btnCreate = new JButton("Create");
		panelInclusion.add(btnCreate);
		btnCreate.addActionListener(e -> this.create());
		
		JButton btnClose = new JButton("Close");
		panelInclusion.add(btnClose);
		btnClose.addActionListener(e -> this.dispose());
		
		this.pack();
		this.setVisible(true);
	}

}
