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
//Tamo junto
//commit teste estou aqui
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
        List<Nacionalidade> nac = new ArrayList<>();
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
                    do{
                        int a = 0;
                    cliente.setPais();
                    Nacionalidade nacionalidade = new Nacionalidade( "default");
                    nac.forEach((c) -> {
                        if(c.getPais().equals(cliente.getPais()))//estou comparando banco com o cadastro
                        {
                            System.out.println("Pais ja cadastrado");
                            //se pais for igual com o do banco, esta errado, tem que ser diferente apenas com o do cliente
                        }else{
                            nacionalidade.Pais = cliente.getPais();
                            nac.add(nacionalidade);
                            a = 1;
                            System.out.println("Cadastro de pais concluido com sucesso");//cadastra pais
                            
                        }
                    });
                    }while(a != 1);
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
