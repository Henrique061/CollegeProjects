// Exercício Ordem Crescente
// Autor: Henrique Batista de Assis
// Data: 28/09/2020

/* Faça um programa que leia três valores numéricos inteiros e apresente-os em ordem crescente, ou seja, 
 * do menor para o maior, se forem lidos os seguintes valores:3, 1, 2 o seu programa deve imprimir na saída: 1, 2, 3
*/

// --------------------------------------------ENTRADA------------------------------------------------
import java.util.Scanner;

public class Ordem_Crescente{
  public static void main(String[]args){
    Scanner crescente = new Scanner (System.in);
    
    // VARIÁVEIS
    int A,B,C;
    
    // entrada dos valores pelo usuário
    System.out.println ("Informe um valor para A: ");
    A = crescente.nextInt();
    
    System.out.println ("Informe um valor para B: ");
    B = crescente.nextInt();
    
    System.out.println ("Informe um valor para C: ");
    C = crescente.nextInt();
    
// -------------------------------------PROCESSAMENTO E SAÍDA------------------------------------------
    // começo A
    if ((A < B) && (A < C)){
      if (B < C){
        System.out.println ("Resultado em ordem crescente é: " +A+ ", " +B+ " e " +C);
      }
      else {
        System.out.println ("Resultado em ordem crescente é: " +A+ ", " +C+ " e " +B);
      }
    }
    
    // começo B
    if ((B < A) && (B < C)){
      if (A < C){
        System.out.println ("Resultado em ordem crescente é: " +B+ ", " +A+ " e " +C);
      }
      else {
        System.out.println ("Resultado em ordem crescente é: " +B+ ", " +C+ " e " +A);
      }
    }
    
    // começo C
    if ((C < A) && (C < B)){
      if (A < B){
        System.out.println ("Resultado em ordem crescente é: " +C+ ", " +A+ " e " +B);
      }
      else {
        System.out.println ("Resultado em ordem crescente é: " +C+ ", " +B+ " e " +A);
      }
    }
    
    
  }
}