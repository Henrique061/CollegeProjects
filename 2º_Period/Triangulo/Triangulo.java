// Exercício Triângulo
// Autor: Henrique Batista de Assis
// Data: 05/10/2020

/* Considere o problema de classificar um triângulo em função do comprimento dos seus lados.
 * Para resolver o problema precisamos lembrar a definição de um triângulo:
 * Triângulo é uma forma geométrica (polígono) composto de três lados, onde cada lado é menor que a soma dos outros lados.
 * Considere os lados do triângulo A, B e C, assim temos as seguintes classificações:
 * - Isósceles: Quando possui dois lados iguais e um diferente
 * - Escaleno: Quando possui todos os lados diferentes
 * - Equilátero: Quando possui todos os lados iguais.
*/


// --------------------------------------------ENTRADA------------------------------------------------
import java.util.Scanner;

public class Triangulo{
  public static void main(String[]args){
    Scanner lados = new Scanner (System.in);
    
    // VARIÁVEIS
    int A,B,C;
    
    System.out.println ("Informe lado A: ");
    A = lados.nextInt();
    
    System.out.println ("Informe lado B: ");
    B = lados.nextInt();
    
    System.out.println ("Informe lado C: ");
    C = lados.nextInt();
    
// -----------------------------------------PROCESSAMENTO E SAÍDA-------------------------------------
    // verificação de um trinângulo
    if ((Math.abs(B - C) < A && A < (B + C)) && (Math.abs(A - C) < B && B < (A + C)) && (Math.abs(B - A) < C && C < (B + A))) 
    {
      
      // verificação equilatero
      if (A == B && A == C && B == C) 
      {
        System.out.println ("O triângulo é equilátero.");
      }
      
      // verificação isósceles
      else if ((A == B && A != C) || (B == C && B != A) || (C == A && C != B))
      {
        System.out.println ("O triângulo é isósceles.");
      }
      
      // verificação escaleno
      else if (A != B && B != C && C != A) 
      {
        System.out.println ("O triângulo é escaleno.");
      }
    }
    
    // não é triangulo (mesmo if da verificação de um triangulo)
    else 
    {
      System.out.println ("Os valores não equivalem a um triângulo.");
    }
  }
}