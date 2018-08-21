/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaclientes;

import java.util.Scanner;

/**
 *
 * @author vinicius
 */
public class Nacionalidade {
    public String Pais;
    public String Sigla;
    Scanner entrada = new Scanner(System.in);
    
    public Nacionalidade(String Pais, String Sigla){
        this.Pais = Pais;
        this.Sigla = Sigla;
    }

    public String getSigla() {
        return Sigla;
    }

    public void setSigla() {
        do{
            System.out.println("Informe a sigla de seu Pais");
            Sigla = entrada.next();
        }while(Sigla.length() < 2);
        
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }
    
}
