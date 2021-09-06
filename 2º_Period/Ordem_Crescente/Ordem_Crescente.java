// Exerc�cio Ordem Crescente
// Autor: Henrique Batista de Assis
// Data: 28/09/2020

/* Fa�a um programa que leia tr�s valores num�ricos inteiros e apresente-os em ordem crescente, ou seja, 
 * do menor para o maior, se forem lidos os seguintes valores:3, 1, 2 o seu programa deve imprimir na sa�da: 1, 2, 3
*/

// --------------------------------------------ENTRADA------------------------------------------------
import java.util.Scanner;

public class Ordem_Crescente{
  public static void main(String[]args){
    Scanner crescente = new Scanner (System.in);
    
    // VARI�VEIS
    int A,B,C;
    
    // entrada dos valores pelo usu�rio
    System.out.println ("Informe um valor para A: ");
    A = crescente.nextInt();
    
    System.out.println ("Informe um valor para B: ");
    B = crescente.nextInt();
    
    System.out.println ("Informe um valor para C: ");
    C = crescente.nextInt();
    
// -------------------------------------PROCESSAMENTO E SA�DA------------------------------------------
    // come�o A
    if ((A < B) && (A < C)){
      if (B < C){
        System.out.println ("Resultado em ordem crescente �: " +A+ ", " +B+ " e " +C);
      }
      else {
        System.out.println ("Resultado em ordem crescente �: " +A+ ", " +C+ " e " +B);
      }
    }
    
    // come�o B
    if ((B < A) && (B < C)){
      if (A < C){
        System.out.println ("Resultado em ordem crescente �: " +B+ ", " +A+ " e " +C);
      }
      else {
        System.out.println ("Resultado em ordem crescente �: " +B+ ", " +C+ " e " +A);
      }
    }
    
    // come�o C
    if ((C < A) && (C < B)){
      if (A < B){
        System.out.println ("Resultado em ordem crescente �: " +C+ ", " +A+ " e " +B);
      }
      else {
        System.out.println ("Resultado em ordem crescente �: " +C+ ", " +B+ " e " +A);
      }
    }
    
    
  }
}