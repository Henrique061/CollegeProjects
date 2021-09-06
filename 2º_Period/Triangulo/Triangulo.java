// Exerc�cio Tri�ngulo
// Autor: Henrique Batista de Assis
// Data: 05/10/2020

/* Considere o problema de classificar um tri�ngulo em fun��o do comprimento dos seus lados.
 * Para resolver o problema precisamos lembrar a defini��o de um tri�ngulo:
 * Tri�ngulo � uma forma geom�trica (pol�gono) composto de tr�s lados, onde cada lado � menor que a soma dos outros lados.
 * Considere os lados do tri�ngulo A, B e C, assim temos as seguintes classifica��es:
 * - Is�sceles: Quando possui dois lados iguais e um diferente
 * - Escaleno: Quando possui todos os lados diferentes
 * - Equil�tero: Quando possui todos os lados iguais.
*/


// --------------------------------------------ENTRADA------------------------------------------------
import java.util.Scanner;

public class Triangulo{
  public static void main(String[]args){
    Scanner lados = new Scanner (System.in);
    
    // VARI�VEIS
    int A,B,C;
    
    System.out.println ("Informe lado A: ");
    A = lados.nextInt();
    
    System.out.println ("Informe lado B: ");
    B = lados.nextInt();
    
    System.out.println ("Informe lado C: ");
    C = lados.nextInt();
    
// -----------------------------------------PROCESSAMENTO E SA�DA-------------------------------------
    // verifica��o de um trin�ngulo
    if ((Math.abs(B - C) < A && A < (B + C)) && (Math.abs(A - C) < B && B < (A + C)) && (Math.abs(B - A) < C && C < (B + A))) 
    {
      
      // verifica��o equilatero
      if (A == B && A == C && B == C) 
      {
        System.out.println ("O tri�ngulo � equil�tero.");
      }
      
      // verifica��o is�sceles
      else if ((A == B && A != C) || (B == C && B != A) || (C == A && C != B))
      {
        System.out.println ("O tri�ngulo � is�sceles.");
      }
      
      // verifica��o escaleno
      else if (A != B && B != C && C != A) 
      {
        System.out.println ("O tri�ngulo � escaleno.");
      }
    }
    
    // n�o � triangulo (mesmo if da verifica��o de um triangulo)
    else 
    {
      System.out.println ("Os valores n�o equivalem a um tri�ngulo.");
    }
  }
}