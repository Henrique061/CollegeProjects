// Operacoes com Vetores - Trabalho 3
// Autor: Henrique Batista de Assis
// Data: 14/12/2020

/*
 * 1) Inicializar o vetor com números aleatórios;
 * 2) Imprimir o vetor;
 * 3) Verificar se um determinado número está contido no vetor;
 * 4) Buscar o maior número armazenado no vetor;
 * 5) Calcular a média dos números pares armazenados no vetor;
 * 6) Calcular o percentual dos números ímpares armazenados no vetor;
 * 7) Buscar a maior diferença absoluta entre números armazenados no vetor;
 * 8) Verificar se dado um valor existe dois números em posições distintas que somados são iguais ao valor informado.
*/

import java.util.Scanner;
import java.util.Random;

public class Operacoes_com_Vetores
{
  public static void main(String[]args) // FUNCAO PRINCIPAL
  {
    Scanner vetores = new Scanner (System.in);
    
    // VARIÁVEIS ------------------------------------------------------------------------------------------------------
    // funcao principal
    int vetor[] = new int[0];
    int opcao = 1; 
    
    // opcao 1
    int N = 0;
    
    // opcao 2
    int mostrar = 0, mostrar_cont = 0;
    
    // opcao 3
    int contido = -1, esta_contido = -1;
    
    // opcao 4
    int maior = 0;
    
    // opcao 5
    float media = 0;
    
    // opcao 6
    float percentual = 0;
    
    // opcao 7
    int diferenca = 0;
    
    // opcao 8
    int valor_somado = -1;
    boolean somado = false;
    
    // MENU -----------------------------------------------------------------------------------------------------------
    while (opcao != 0)
    { // abre while menu
      
      // TRANSCRICAO DAS OPCOES - INICIO +++++++++++++++++++++++++
      
      // titulo do menu
      System.out.println("MENU - Operacoes com Vetores - MENU");
      
      // opcao 1
      System.out.println("1 - Gerar valores aleatorios de 0 a 100 para o vetor.");
      // opcao 2
      System.out.println("2 - Imprimir o vetor atual.");      
      // opcao 3
      System.out.println("3 - Verificar se determinado numero esta contido no vetor.");      
      // opcao 4
      System.out.println("4 - Verificar o maior valor do vetor.");      
      // opcao 5
      System.out.println("5 - Verificar a media de todos os valores pares do vetor.");      
      // opcao 6
      System.out.println("6 - Verificar o percentual da quantia de numeros impares no vetor.");      
      // opcao 7
      System.out.println("7 - Verificar a maior diferenca entre dois numeros no vetor.");      
      // opcao 8
      System.out.println("8 - Verificar se dois valores distintos no vetor, quando somados, equivale a um determinado valor.");      
      // opcao 0
      System.out.println("0 - Sair do programa.\n");
      
      
      // TRANSCRICAO DAS OPCOES - FIM +++++++++++++++++++++++++++++
      
      // escolher opcao
      System.out.println("Digite o valor correspondente a acao desejada.");
      opcao = vetores.nextInt();
      
      // SELECAO OPCOES - INICIO ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      
      // OPCAO 1 ------------------------------------------------------------------------------------------------------
      if (opcao == 1)
      {
        N = 0;
        
        // usuario escolhe a quantidade de vetores
        while (N < 1)
        {
          System.out.println("Digite o tamanho do vetor.");
          N = vetores.nextInt();
          
          if (N < 1)
          {
            System.out.println("Tamanho do vetor deve ser de pelo menos 1.");
          }
        }
        
        // chama a função opcao_1
        vetor = new int[N];
        opcao_1(vetor);
        
        // confirma a geração do vetor
        System.out.println("Valores para o vetor de tamanho " +N+ " gerado.\n");
        
      } // fecha OPCAO 1
      
      // OPCAO 2 ------------------------------------------------------------------------------------------------------
      else if (opcao == 2)
      {
        // verifica se opcao 1 foi selecionada antes
        if (N < 1)
        {
          System.out.println("Vetor não foi gerado. Por favor, selecione a opcao 1 para gera-lo.\n");
        }
        
        // imprime vetor
        else
        {
          mostrar_cont = 0;
            
          for ( mostrar = 0; mostrar < vetor.length; mostrar++)
          {
            System.out.println("Valor do vetor de indice " +mostrar_cont+ " = " +vetor[mostrar]);
            
            mostrar_cont++;
          }
          System.out.print("\n");
        }
        
      } // fecha OPCAO 2
      
      // OPCAO 3 ------------------------------------------------------------------------------------------------------
      else if (opcao == 3)
      {
        // verifica se opcao 1 foi selecionada antes
        if (N < 1)
        {
          System.out.println("Vetor não foi gerado. Por favor, selecione a opcao 1 para gera-lo.\n");
        }
        
        else
        {
          
          // usuario escolhe o valor a verificar se esta contido
          contido = -1;
          
          while (contido < 0 || contido > 100)
          {
            System.out.println("Digite o valor a ser procurado dentro do vetor.");
            contido = vetores.nextInt();
          
            if (contido < 0 || contido > 100)
            {
              System.out.println("Valor a ser verificado deve ser um numero positivo menor que 101.");
            }
          } // fecha while
          
          // chama funcao opcao_3
          esta_contido = opcao_3(vetor, contido);
          
          // verifica se esta contido ou nao
          if (esta_contido != -1)
          {
            System.out.println("Valor encontrado no vetor.\n");
          }
          
          else
          {
            System.out.println("Valor não existente no vetor.\n");
          }
          
        } // fecha else
        
      } // fecha opcao 3
      
      // OPCAO 4 ------------------------------------------------------------------------------------------------------
      else if (opcao == 4)
      {
        // verifica se opcao 1 foi selecionada antes
        if (N < 1)
        {
          System.out.println("Vetor não foi gerado. Por favor, selecione a opcao 1 para gera-lo.\n");
        }
        
        else
        {
          // chama funcao opcao_4
          maior = opcao_4(vetor);
          
          // imprime maior numero
          System.out.println("Maior valor do vetor = " +maior+ "\n");
          
        } // fecha else
        
      } // fecha opcao 4
      
      // OPCAO 5 ------------------------------------------------------------------------------------------------------
      else if (opcao == 5)
      {
        // verifica se opcao 1 foi selecionada antes
        if (N < 1)
        {
          System.out.println("Vetor nao foi gerado. Por favor, selecione a opcao 1 para gera-lo.\n");
        }
        
        else
        {
          // chama funcao opcao_5
          media = opcao_5(vetor);
          
          // imprime media
          System.out.printf("Media de numeros pares e de: %.2f.\n\n", (media));
          
        } // fecha else
        
      } // fecha opcao 5
        
      // OPCAO 6 ------------------------------------------------------------------------------------------------------
      else if (opcao == 6)
      {
        // verifica se opcao 1 foi selecionada antes
        if (N < 1)
        {
          System.out.println("Vetor nao foi gerado. Por favor, selecione a opcao 1 para gera-lo.\n");
        }
        
        else
        {
          // chama funcao opcao_6
          percentual = opcao_6(vetor);
          
          // imprime percentual
          System.out.printf("Porcentagem da quantidade de numeros impares no vetor e de: %.2f%%.\n\n", (percentual));
          
        } // fecha else
        
      } // fecha opcao 6
      
      // OPCAO 7 ------------------------------------------------------------------------------------------------------
      else if (opcao == 7)
      {
        // verifica se opcao 1 foi selecionada antes
        if (N < 1)
        {
          System.out.println("Vetor nao foi gerado. Por favor, selecione a opcao 1 para gera-lo.\n");
        }
        
        else
        {
          // chama funcao opcao_7
          diferenca = opcao_7(vetor);
          
          // imprime maior diferença
          System.out.println("Maior diferença entre dois numeros dentro do vetor e de: " +diferenca+ ".\n");
          
        } // fecha else
        
      } // fecha opcao 7
      
      // OPCAO 8 ------------------------------------------------------------------------------------------------------
      else if (opcao == 8)
      {
        // verifica se opcao 1 foi selecionada antes
        if (N < 1)
        {
          System.out.println("Vetor nao foi gerado. Por favor, selecione a opcao 1 para gera-lo.\n");
        }
        
        else
        {
          valor_somado = -1;
            
          // verifica se o valor informado não é negativo
          while (valor_somado < 0 || valor_somado > 200)
          {
            System.out.println("Informe o valor a verificar se existe equivalencia na soma de dois valores distintos no vetor:");
            valor_somado = vetores.nextInt();
            
            if (valor_somado < 0 || valor_somado > 200)
            {
              System.out.println("Valor informado deve ser um numero positivo menor que 201.");
            }
            
          } // fecha while
          
          // chama funcao opcao 8
          somado = opcao_8(vetor, valor_somado);
          
          // imprime se há equivalencia na soma ou nao
          if (somado == true)
          {
            System.out.println("Valor informado equivale a soma de dois valores distintos do vetor.\n");
          }
          else
          {
            System.out.println("Não existe equivalencia na soma de dois numeros distintos do vetor com o valor informado.\n");
          }
          
        } // fecha else
        
      } // fecha opcao 8
      
      // OPCAO ERRADA -------------------------------------------------------------------------------------------------
      else
      {
        if (opcao != 0)
        {
          System.out.println("Opcao invalida.\n");
        }
      }
      
      // OPCAO 0 ------------------------------------------------------------------------------------------------------
    } // fecha while menu
    
    // saiu do programa
    System.out.println("Programa finalizado.");
    
    // SELECAO OPCOES - FIM +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    
  } // fecha FUNCAO PRINCIPAL
  
    
// FUNCOES DAS OPCOES - INICIO ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// ----------------------------------------------- OPCAO 1 ------------------------------------------------------------
  
  public static void opcao_1(int vetor_gerado[]) // FUNCAO OPCAO 1
  {
    // VARIAVEIS -----------
    int i = 0;
    
    // PROCESSAMENTO -------
    Random aleatorio = new Random();
    
    // repeticao "for" para gerar numeros do vetor
    for ( i = 0; i < vetor_gerado.length; i++)
    {
      vetor_gerado[i] = aleatorio.nextInt(101);
    }
    
  } // fecha FUNCAO OPCAO 1
  
// ----------------------------------------------- OPCAO 3 ------------------------------------------------------------
  public static int opcao_3(int vetor_contido[], int valor_contido) // FUNCAO OPCAO 3
  {
    // VARIAVEIS -----------
    int i3 = 0, contem = -1;
    
    // PROCESSAMENTO -------
    // repeticao "for" para procurar numero contido
    for ( i3 = 0; i3 < vetor_contido.length; i3++)
    {
      if ( vetor_contido[i3] == valor_contido)
      {
        contem = i3;
      }     
    }
    
    return contem;
    
  }// fecha FUNCAO OPCAO 3
  
// ----------------------------------------------- OPCAO 4 ------------------------------------------------------------
  public static int opcao_4(int vetor_maior[]) // FUNCAO OPCAO 4
  {
    // VARIAVEIS -----------
    int i4 = 0, maior4 = -1;
    
    // PROCESSAMENTO -------
    // repeticao "for" para procurar maior numero
    for ( i4 = 0; i4 < vetor_maior.length; i4++)
    {
      if ( vetor_maior[i4] > maior4)
      {
        maior4 = vetor_maior[i4];
      }
    }
    
    return maior4;
    
    
  }// fecha FUNCAO OPCAO 4
  
// ----------------------------------------------- OPCAO 5 ------------------------------------------------------------
  public static float opcao_5(int vetor_media[]) // FUNCAO OPCAO 5
  {
    // VARIAVEIS -----------
    int i5 = 0, par5 = 0;
    float media5 = 0, quantia5 = 0, soma5 = 0;
    
    // PROCESSAMENTO -------
    // repeticao "for" para adicionar numeros pares a soma e quantia
    for (i5 = 0; i5 < vetor_media.length; i5++)
    {
      par5 = vetor_media[i5] % 2;
      
      // se for par, acresecenta na soma e quantia
      if (par5 == 0)
      {
        soma5 = soma5 + vetor_media[i5];
        quantia5++;
      } 
        
    } // fecha for
    
    // calcula media
    if (quantia5 != 0)
    {
      media5 = soma5 / quantia5;
    }
    
    return media5;
    
  } // fecha FUNCAO OPCAO 5
  
// ----------------------------------------------- OPCAO 6 ------------------------------------------------------------
  public static float opcao_6(int vetor_percentual[]) // FUNCAO OPCAO 6
  {
    // VARIAVEIS -----------
    int i6 = 0, impar6 = 0;
    float quantia6 = 0, percentual6 = 0;
    
    // PROCESSAMENTO -------
    // repeticao "for" para adicionar quantia de numeros impares
    for (i6 = 0; i6 < vetor_percentual.length; i6++)
    {
      impar6 = vetor_percentual[i6] % 2;
      
      // se for impar, acrescenta a quantia de impares
      if (impar6 == 1)
      {
        quantia6++;
      }
      
    } // fecha for
    
    percentual6 = (quantia6 * 100) / i6;
    
    return percentual6;
    
  } // fecha FUNCAO OPCAO 6
  
// ----------------------------------------------- OPCAO 7 ------------------------------------------------------------
  public static int opcao_7(int vetor_diferenca[]) // FUNCAO OPCAO 7
  {
    // VARIAVEIS -----------
    int i7 = 0, cont7 = 1, cont_aux = 1, diferenca7 = 0, maior_dif7 = 0;
    
    // PROCESSAMENTO -------
    // repeticao "for" para aumentar o valor do primero vetor
    for (i7 = 0; i7 < vetor_diferenca.length; i7++)
    {
      cont7 = cont_aux;
      
      // repeticao "for" para aumentar o valor do segundo vetor
      for (cont7 = cont_aux; cont7 < vetor_diferenca.length; cont7++)
      {
        // calcula diferenca
        diferenca7 = Math.abs(vetor_diferenca[i7] - vetor_diferenca[cont7]);
        
        // verifica se a diferenca e maior que a anterior
        if (diferenca7 > maior_dif7 || (i7 == 0 && cont7 == 1))
        {
          maior_dif7 = diferenca7;          
        }
        
      } // fecha for 2
      
      cont_aux++;
      
    } // fecha for 1
    
    return maior_dif7;
    
  } // fecha FUNCAO OPCAO 7
  
// ----------------------------------------------- OPCAO 8 ------------------------------------------------------------
  public static boolean opcao_8(int vetor_somado[], int valor_somado8) // FUNCAO OPCAO 8
  {
    // VARIAVEIS -----------
    int i8 = 0, cont8 = 1, cont_aux8 = 1, soma8 = 0;
    boolean somado8 = false;
    
    // PROCESSAMENTO -------
    // repeticao "for" para aumentar o valor do primero vetor (if para parar for)
    if (somado8 == false) // if 1
    {
      for (i8 = 0; i8 < vetor_somado.length; i8++) // for 1
      {
        cont8 = cont_aux8;
      
        // repeticao "for" para aumentar o valor do segundo vetor (if para parar for)
        if (somado8 == false) // if 2
        {
          for (cont8 = cont_aux8; cont8 < vetor_somado.length; cont8++) // for 2
          {
            // calcula a soma de dois valores do vetor
            soma8 = vetor_somado[i8] + vetor_somado[cont8];
        
            // verifica se valor somado é igual ao valor informado
            if (soma8 == valor_somado8)
            {
              somado8 = true;
            }
        
          } // fecha for 2
          
        } // fecha if 2        
      
      cont_aux8++;
      
      } // fecha for 1
      
    } // fecha if 1
        
    return somado8;
    
  } // fecha FUNCAO OPCAO 8
  
} // fecha programa