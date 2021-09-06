// Batalha Pomekon - Trabalho 2
// Autor: Henrique Batista de Assis
// Data: 23/11/2020

// fórmula golpe: ((ataque + defesa) / 2) + bonus
// bonus é aplicado para pomekons de nível PAR

/*
 * - usuário informa número de batalhas;
 * - usuário informa número de treinadores;
 * - usuário informa valor do bonus para cada batalha;
 * - usuário informa estatísticas dos pomekons de cada treinador (ataque, defesa e nível);
 * - saída informa o valor de golpe (vg) de cada pomekon;
 * - saída informa o voncedor ou se deu empate
 * obs: batalha >= 1 e treinadores >= 2
*/

import java.util.Scanner;

public class Batalha_Pomekon{
  public static void main(String[]args){
    Scanner batalha_pomekon = new Scanner (System.in);
    
// --------------------------------------------VARIÁVEIS------------------------------------------------
    // infos iniciais
    int treinadores = 0, batalhas = 0;
    
    // batalhas
    int bonus = -1;
    float vg_maior = 0;
    boolean empate = false;
    
    // pomekons
    int nivel = 0;
    float ataque = -1, defesa = -1, vg = 0;
    int par = 0;
    
    // saídas
    String vg_saida = "", vencedor = "";
    
    // controladores
    int cont_batalha = 1, cont_treinador = 1;
    
// --------------------------------------------ENTRADA------------------------------------------------
    // usuário informa numero de batalhas
    while (batalhas < 1)
    {
      System.out.println("Informe o número de batalhas:");
      batalhas = batalha_pomekon.nextInt();
      
      // verifica se o numero de batalhas não é 0 ou menos
      if (batalhas < 1)
      {
        System.out.println("Quantidade de batalhas deve ser pelo menos 1");
      }
    }
    
    // usuário informa numero de treinadores
    while (treinadores < 2)
    {
      System.out.println("Informe o número de treinadores a batalharem:");
      treinadores = batalha_pomekon.nextInt();
      
      // verifica se o numero de treinadores não é 1 ou menos
      if (treinadores < 2)
      {
        System.out.println("Quantidade de treinadores a batalharem deve ser pelo menos 2");
      }
    }
    
// ------------------------------------PROCESSAMENTO E SAÍDA------------------------------------------
    // repetição aplicada até todas as batalhas forem preenchidas
    while (cont_batalha <= batalhas)
    {
      cont_treinador = 1;
      
      // usuário informa o valor do bonus da batalha x (não pode ser negativo)
      while (bonus < 0)
      {
        System.out.println("Informe o valor do bônus a ser aplicado aos pomekons de nível par na " +cont_batalha+ "ª batalha:");
        bonus = batalha_pomekon.nextInt();
      
        if (bonus < 0)
        {
          System.out.println("Valor do bonus deve ser pelo menos 0");
        }
      }
      
      // repetição para declarar os pomekons de cada treinador
      while (cont_treinador <= treinadores)
      {
        // usuário informa ataque do pomekon (não pode ser negativo)
        while (ataque < 0)
        {
          System.out.println("Informe o ataque do pomekon do " +cont_treinador+ "º treinador para a " +cont_batalha+ "ª batalha:");
          ataque = batalha_pomekon.nextFloat();
        
          if (ataque < 0)
          {
            System.out.println("Valor do ataque deve ser pelo menos 0");
          }
        }
        
        // usuário informa defesa do pomekon (não pode ser negativo)
        while (defesa < 0)
        {
          System.out.println("Informe a defesa do pomekon do " +cont_treinador+ "º treinador para a " +cont_batalha+ "ª batalha:");
          defesa = batalha_pomekon.nextFloat();
        
          if (defesa < 0)
          {
            System.out.println("Valor da defesa deve ser pelo menos 0");
          }
        }
      
        // usuário informa nível do pomekon (não pode ser menor que 1)
        while (nivel < 1)
        {
          System.out.println("Informe o nível do pomekon do " +cont_treinador+ "º treinador para a " +cont_batalha+ "ª batalha:");
          nivel = batalha_pomekon.nextInt();
        
          if (nivel < 1)
          {
            System.out.println("Valor do nível deve ser pelo menos 1");
          }
        }
        
        // verifica se nível é par
        par = nivel % 2;
        
        // calcula valor do golpe (adiciona bonus se o nivel do pomekon for par)
        if (par == 0)
        {
          vg = ((ataque + defesa) / 2) + bonus;
        }
        else
        {
          vg = (ataque + defesa) / 2;
        }
        
        // armazena valor do golpe numa string
        vg_saida = vg_saida + "Valor do golpe do pomekon do " +cont_treinador+ "º treinador: " +vg+ "\n";
        
        // compara valor do golpe com pomekon anterior
        if (vg_maior == vg && cont_treinador != 1)
        {
          empate = true;
        }
        else if (vg_maior < vg || cont_treinador == 1)
        {
          empate = false;
          vg_maior = vg;
          vencedor = "O vencedor foi o pomekon do " +cont_treinador+ "º treinador.";
        }
        
        // SAÍDAS -----------------------------------------------------------------------------------------------------
        if (cont_treinador == treinadores)
        {
          System.out.println("Resultados da " +cont_batalha+ "ª batalha:\n");
          
          // saída dos valores de golpe dos pomekons
          System.out.println(vg_saida);
          
          // saida do vencedor ou empate
          if (empate == true)
          {
            System.out.println("Houve empate na " +cont_batalha+ "ª batalha.\n");
          }
          else
          {
            System.out.println(vencedor + "\n");
          }
          // reseta informações e troca de batalhas
          vg_saida = "";
          vencedor = "";
          empate = false;
          bonus = -1;
          System.out.println("*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~ \n");
        }
        
        // aumenta cont_treinador em 1 e reseta informações
        ataque = -1;
        defesa = -1;
        nivel = 0;
        par = 0;
        cont_treinador = cont_treinador + 1;
                  
      } // fechamento cont_treinador
      
      // aumenta cont_batalha em 1
      cont_batalha = cont_batalha + 1;
      
    } // fechamento cont_batalha
  }
}