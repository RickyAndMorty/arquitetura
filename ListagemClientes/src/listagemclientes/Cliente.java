/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listagemclientes;

import java.util.Scanner;

/**
 *
 * @author Ricardo Santos
 * 
 * Esta classe implementa os gets e sets relacionados aos atributos do cliente
 * 
 */
public class Cliente
{
	//Atributos privados da classe Cliente
	private String nome, telefone, pais, sigla; 
	private double credito; 
	private int idade; 
        Scanner ler = new Scanner(System.in);
	// Métodos Públicos 
	public void setNome()
		{
		    // Seta o nome do cliente
                    System.out.printf("Informe o nome:");
                    nome  = ler.nextLine();
		}
	public void setTelefone()
		{
		    //Seta o telefone do cliente
                    System.out.printf("Informe o telefone:");
                    telefone  = ler.nextLine();
		}
	public void setPais()
		{
		    //Seta Pais do cliente
                    System.out.printf("Informe o país:");
                    pais  = ler.nextLine();
		}
	public void setSigla()
		{
		    //Seta a Sigla do cliente
                    System.out.printf("Informe a sigla:");
                    sigla  = ler.nextLine();
		}
	public void setCredito()
		{
		    //Seta crédito do cliente
                    System.out.printf("Informe o credito:");
                    credito  = ler.nextDouble();
		}
	public void setIdade()
		{
		    //Seta idade do cliente
                    System.out.printf("Informe a idade:");
                    idade  = ler.nextInt();
		}

	public String getNome()
		{
		    //Devolve o nome do cliente
                    return nome;
		}
	public String getTelefone()
		{
		    //Devolve o telefone do cliente
                    return telefone;
		}
		String getPais()
		{
		    //Devolve o Pais do cliente
                    return pais;
		}
		double getCredito()
		{
		    //Devolve o credito do cliente
                    return credito;
		}
		int getIdade()
		{
	            //devolve a idade do cliente
                    return idade;
		}
}