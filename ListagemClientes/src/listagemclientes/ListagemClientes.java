/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
///Verificando se estou aqui

package listagemclientes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Ricardo Santos
 */
public class ListagemClientes {
    public String nome;
    public int telefone;
    public double limitecredito;
    public String pais;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public double getLimitecredito() {
        return limitecredito;
    }

    public void setLimitecredito(double limitecredito) {
        this.limitecredito = limitecredito;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public ListagemClientes(){
        this.nome = "";
        this.telefone = 0;
        this.limitecredito = 0;
        this.pais = "";       
    }
   
    
    public void ListagemClientes(String nome, int telefone, double limitecredito, String pais){
        this.nome = nome;
        this.telefone = telefone;
        this.limitecredito = limitecredito;
        this.pais = pais;
    
    }
    
    public double ValidarCredito(int idade){
        if(idade <= 18){
            return 100.00;
        }else if(idade >18 && idade <=35 ){            
        return 300.00;
        }else return 500.00;
    }
    
    

    
 
    public static void main(String[] args) {
        // TODO code application logic here
        //ListagemClientes list = new ListagemClientes();
        int idade, i=0;
        //ArrayList<ListagemClientes> listagemclientes = new ArrayList<>();
        List<ListagemClientes> listagemclientes = new ArrayList<>();
        // ArrayList<String> listagemclientes = new ArrayList();
        Scanner ln = new Scanner(System.in);
        for(i=0;i<2;i++){
        ListagemClientes list = new ListagemClientes();
        
        
        System.out.println("Insira seu Nome:");
        list.nome = ln.next();
        
        System.out.println("Insira o numero do Telefone:");
        list.telefone = ln.nextInt();
        
        System.out.println("Insira sua idade:");
        idade = ln.nextInt();        
        list.limitecredito = list.ValidarCredito(idade);
        
        System.out.println("Insira seu pais:");
        list.pais = ln.next();
        listagemclientes.add(list);
        }
        
        //listagemclientes.add(new ListagemClientes(list.getNome(),list.getTelefone(),list.getLimitecredito(),list.pais));
       for(i=0;i<2;i++){
        System.out.println(listagemclientes.get(i).nome);
        System.out.println(listagemclientes.get(i).telefone);
        System.out.println(listagemclientes.get(i).limitecredito);
        System.out.println(listagemclientes.get(i).pais);
       }
       
    }
    
}
