import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.in;
import java.util.Scanner; 

public class Arquitetura 
{
 
  public static void main(String args[]) throws IOException 
  {
    int  auxiliar = 0,i;
    Scanner ler = new Scanner(System.in);
    String[] nome = new String[10];
    do
    {
        System.out.println("Menu:\n1 - Cadastrar nome.\n2 - Listar nome(s).\n3 - Sair");
        auxiliar = ler.nextInt();
        System.out.println("======");
        if(auxiliar == 1)
        {
            for(i = 0; i < 3; i ++)
            {
                nome[i] = ler.nextLine();
            }
        }
        if(auxiliar == 2)
        {
            for(i = 0; i < 3; i ++)
            {
                System.out.println("Nome: " + nome[i]);
            }
            
        }
    }while( auxiliar != 3);
  }
 }
