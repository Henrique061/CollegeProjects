// Sistema de coordenadas 2D - Trabalho 1
// Autor: Henrique Batista de Assis
// Data: 26/10/2020

// formula distancia: dAB = R*(x2 - x1)² + (y2 - y1)²*    R = raiz quadrada.    *...* = começo e fim da raiz
// formula em java: Math.sqrt(Math.pow(ponto_x - orig_transX, 2) + Math.pow(ponto_y - orig_transY, 2))
// formula porcentagem: porcentagem = (quantia_escolhida * 100) / quantia_total;

/* 
 * Usuário informa origem translada (!= (0,0));
 * Usuario informa quantos pontos serão lidos;
 * Usuário informa posição de todos os pontos;
 * saída contém:
 *   - todos os pontos transcritos e em qual quadrante está cada; (armazenar valores numa string)
 *   - ponto mais distante;
 *   - ponto mais perto;
 *   - porcentagem da quantia de pontos em cada quadrante.
*/

// --------------------------------------------ENTRADA------------------------------------------------
import java.util.Scanner;

public class Sistemas_de_Coordenadas_2D{
  public static void main(String[]args){
    Scanner entrada = new Scanner (System.in);
    
    // VARIÁVEIS
    // pontos
    float ponto_x = 0, ponto_y = 0;
    float orig_transX = 0, orig_transY = 0;
    
    // distancias
    String dist_longe_saida = "", dist_perto_saida = "";
    double dist_longe = 0, dist_perto = 0;
    double distancia = 0;
    
    // quantia total e contador
    int quantia = 0, cont = 1;
    
    // quadrantes
    float quantia_quadrante_1 = 0, quantia_quadrante_2 = 0, quantia_quadrante_3 = 0;
    float quantia_quadrante_4 = 0, quantia_quadrante_orig = 0;
    String quadrante = "";
    
    // saída de pontos totais
    String pontos = "";
    
// --------------------------------------------------------------------------------------------------------------    
    
    // usuário informa origem translada
    while(orig_transX == 0 && orig_transY == 0)
    {
      System.out.println("Informe o ponto X da origem translada: ");
      orig_transX = entrada.nextFloat();
      System.out.println("Informe o ponto Y da origem translada: ");
      orig_transY = entrada.nextFloat();
      
      // verifica se origem translada não é no ponto (0,0)
      if(orig_transX == 0 && orig_transY == 0)
      {
        System.out.println("Origem translada não pode ser no ponto (0,0). \n");
      }
    }
    
     // usuário informa quantos pontos serão lidos, nao pode ser 0 ou menos.
    while(quantia <= 0)
    {
      System.out.println("Informe a quantidade de pontos que serão lidos.");
      quantia = entrada.nextInt();
      
      if(quantia <= 0)
      {
        System.out.println("Quantia de pontos a ser informada não pode ser menor que 1. \n");
      }
    }
// -----------------------------------------PROCESSAMENTO--------------------------------------------
      // repetição para informar os pontos até a quantia total ser preenchida
      while(cont <= quantia)
      {
        // usuário informa pontos x e y
        System.out.println("Informe o ponto X da " +cont+ "ª coordenada: ");
        ponto_x = entrada.nextFloat();
        System.out.println("Informe o ponto Y da " +cont+ "ª coordenada: ");
        ponto_y = entrada.nextFloat();
        
        // verifica quadrante do ponto em relação a origem translada e armazena a quantia de pontos na mesma
        if (ponto_x > orig_transX && ponto_y > orig_transY)
        {
          quadrante = "no 1º quadrante.";
          quantia_quadrante_1 = quantia_quadrante_1 + 1;
        }
        else if (ponto_x < orig_transX && ponto_y > orig_transY)
        {
          quadrante = "no 2º quadrante.";
          quantia_quadrante_2 = quantia_quadrante_2 + 1;
        }
        else if (ponto_x < orig_transX && ponto_y < orig_transY)
        {
          quadrante = "no 3º quadrante.";
          quantia_quadrante_3 = quantia_quadrante_3 + 1;
        }
        else if (ponto_x > orig_transX && ponto_y < orig_transY)
        {
          quadrante = "no 4º quadrante.";
          quantia_quadrante_4 = quantia_quadrante_4 + 1;
        }
        else if (ponto_x == orig_transX || ponto_y == orig_transY)
        {
          quadrante = "na origem.";
          quantia_quadrante_orig = quantia_quadrante_orig + 1;
        }
        
        // calcula distância do ponto em relação a origem translada
        distancia = Math.sqrt(Math.pow(ponto_x - orig_transX, 2) + Math.pow(ponto_y - orig_transY, 2));
        
        // verifica maior distancia e o armazena em uma variável, depois trasncreve a saida numa string
        if (distancia > dist_longe || cont == 1)
        {
          dist_longe = distancia;
          dist_longe_saida = "Ponto (" +ponto_x+ ", " +ponto_y+ ") é o mais distante da origem translada, distância = " +dist_longe;
        }
        
        // verifica menor distancia e o armazrna em um variável, depois trasncreve a saida numa string
        if (distancia < dist_perto || cont == 1)
        {
          dist_perto = distancia;
          dist_perto_saida = "Ponto (" +ponto_x+ ", " +ponto_y+ ") é o mais próximo da origem translada, distância = " +dist_perto;
        }
        
        // armazena informação do ponto atual numa string
        pontos = pontos + "Ponto (" +ponto_x+ ", " +ponto_y+ ") está " +quadrante+ "\n";
        
        // aumenta valor do contador
        cont = cont + 1;
      }
      
      //porcentagem de elementos em cada quadrante
      quantia_quadrante_1    =    (quantia_quadrante_1 * 100) / quantia;
      quantia_quadrante_2    =    (quantia_quadrante_2 * 100) / quantia;
      quantia_quadrante_3    =    (quantia_quadrante_3 * 100) / quantia;
      quantia_quadrante_4    =    (quantia_quadrante_4 * 100) / quantia;
      quantia_quadrante_orig = (quantia_quadrante_orig * 100) / quantia;
      
// ---------------------------------------------SAÍDA-------------------------------------------------
      // saída das informações de todos os pontos dados
      System.out.println(pontos);
      
      // saída das distancias (perto e longe)
      System.out.println(dist_perto_saida+ ".\n" +dist_longe_saida+ ".\n");
      
      // saída da porcentagem da quantia de pontos por quadrante
      System.out.printf("Porcentagem de pontos no 1º quadrante = %.2f%%.\n", (quantia_quadrante_1));
      System.out.printf("Porcentagem de pontos no 2º quadrante = %.2f%%.\n", (quantia_quadrante_2));
      System.out.printf("Porcentagem de pontos no 3º quadrante = %.2f%%.\n", (quantia_quadrante_3));
      System.out.printf("Porcentagem de pontos no 4º quadrante = %.2f%%.\n", (quantia_quadrante_4));
      System.out.printf("Porcentagem de pontos na origem = %.2f%%.\n",       (quantia_quadrante_orig));
    
  }
}