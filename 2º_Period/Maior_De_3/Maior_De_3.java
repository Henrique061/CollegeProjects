// Exerc�cio Maior Entre 3 Valores
// Autor: Henrique Batista de Assis
// Data: 28/09/2020

/* 
 * Fa�a um programa que leia tr�s valores inteiros, determine e imprima o maior deles. Se forem lidos os seguintes valores:
 * -1, 10, 4
 * o seu programa deve imprimir na saida: 10
*/

// --------------------------------------------ENTRADA------------------------------------------------
import java.util.Scanner;

public class Maior_De_3{
  public static void main(String[]args){
    Scanner maior_de_3 = new Scanner (System.in);
    
    // VARI�VEIS
    int A,B,C,maior,controlador;
    
    // entrada dos valores pelo usu�rio
    System.out.println ("Informe um valor para A:");
    A = maior_de_3.nextInt();
    
    System.out.println ("Informe um valor para B:");
    B = maior_de_3.nextInt();
    
    System.out.println ("Informe um valor para C:");
    C = maior_de_3.nextInt();
    
// -----------------------------------------PROCESSAMENTO--------------------------------------------
    // Se A > B
    if (A > B){
      controlador = A;
    } 
    else {
      controlador = B;
    }
    
    // Se resultado de (A > B) > C
    if (controlador > C) {
      maior = controlador;
    } 
    else {
      maior = C;
    }
    
// ---------------------------------------------SA�DA------------------------------------------------
    System.out.println ("O maior valor � " +maior+ ".");
  }
}