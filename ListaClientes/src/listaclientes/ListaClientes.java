/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaclientes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//programando
/**
 *
 * @author Ricardo Santos
 */
public class ListaClientes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Cria os Clientes
        
        int opcao = -1;
        Scanner entrada = new Scanner(System.in);

        
        //Cria a lista de Clientes
        List<Cliente> clientes = new ArrayList<>();
        //Adiciona os clientes na lista
        while (opcao != 0) {
            System.out.printf("Informe\n1 para inserir, \n2 para listar, \n0 para sair\n ");
            opcao = entrada.nextInt();

            switch (opcao) {
            case 1:
                    Cliente cliente = new Cliente( "SemNome", "SemTelefone", "SemPais", 0, 0.00);
                    cliente.setNome();
                    clientes.forEach((c) -> {
                        if(c.getNome().equals(cliente.getNome()))
                        {
                            System.out.println("Esse nome ja existe na lista");
                        }
                    });
                    cliente.setTelefone();
                    cliente.setPais();
                    cliente.setIdade();
                    clientes.add(cliente);
                break;

            case 2:
                if(clientes.isEmpty())
                {
                    System.out.println("Não há clientes cadastrados.");
                }
                else
                {
                    clientes.forEach((c) -> {
                    System.out.println("Cliente: " + c.getNome());
                    System.out.println("Telefone: " + c.getTelefone());
                    System.out.println("Pais: " + c.getPais());
                    System.out.println("Idade: " + c.getIdade());
                    System.out.println("Credito: " + c.getCredito());
                    });
                }
                break;
            case 0:
                System.out.println("bye");
            }

        }
        //Exibe os nomes dos clientes por um foreach      
    }
    
}
