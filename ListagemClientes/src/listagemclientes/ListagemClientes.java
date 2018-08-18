/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
///Verificando se estou aqui
package listagemclientes;

import static java.lang.System.out;
import java.util.ArrayList;

/**
 *
 * @author Ricardo Santos
 */
public class ListagemClientes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int contador, i;
        // Lista de clientes
        Cliente cliente = new Cliente();
        ArrayList<Cliente> clientes;
        clientes = new ArrayList<Cliente>();
        
        cliente.setNome();
        cliente.setIdade();
        cliente.setCredito();
        cliente.setPais();
        cliente.setSigla();
        cliente.setTelefone();
        
        
        
        clientes.add(cliente);
        
        contador = clientes.size();
        
        for(i = 0; i < contador; i ++)
        {
            out.println(clientes.get(i));
        }
    }
    
}
