/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listagemclientes;

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
        ArrayList<String> clientes = new ArrayList();
        Cliente dados;
        dados = new Cliente();
        dados.setNome();
        clientes.add(dados.getNome());
        contador = clientes.size();
        for(i = 0; i < contador; i ++)
        {
            System.out.printf("Posição %s\n",clientes.get(i));
        }
    }
    
}
