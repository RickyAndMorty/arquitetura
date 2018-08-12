import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.in;
import java.util.Scanner; 

/*
Para essa atividade, você deverá criar aplicativo desktop que armazene em um array/lista um nome 
informado pelo usuario e permita listar todos os nomes armazenados. Cabe ao usuário do sistema 
decidir quando quer informar um novo nome ou listar os nomes armazenados. O código fonte da 
aplicação deverá ser armazenado em um repositório na sua conta no GitHub. Se você usar alguma IDE 
(e.g., Netbeans, IntelliJ, etc), submeta o projeto criado pela IDE, contendo todas as pastas e arquivos, 
com exceção dos arquivos executáveis. Para esta atividade, você deve submeter no Moodle o link do 
repositório no GitHub. O professor irá analisar o código diretamente no GitHub. 

Adicionalmente, considere as seguintes observações:

Excepcionalmente, essa atividade é individual;
É necessário criar uma interface para interação com o usuário, mas não precisa ser uma 
interface gráfica, pode ser textual;
Os nomes armazenados no array/lista não precisam ser gravados em banco de dados;

*/
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
