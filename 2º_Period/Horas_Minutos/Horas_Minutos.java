// Exerc�cio Horas e Minutos
// Autor: Henrique Batista de Assis
// Data: 21/09/2020

// ENTRADA
import java.util.Scanner;

public class Horas_Minutos{
  public static void main(String[]args){
    Scanner tempo = new Scanner (System.in);
    
    // VARI�VEIS
    int horas;
    int minutos;
    int minutos_totais;
    
    // tempo informado pelo usu�rio
    System.out.println ("Digite um tempo em minutos:");
    minutos_totais = tempo.nextInt();
    for (; minutos_totais < 0; ){
      System.out.println ("Digite um valor positivo, por favor:");
        minutos_totais = tempo.nextInt();
    }
    
    // PROCESSAMENTO
    horas = minutos_totais/60;
    minutos = minutos_totais%60;
    
    // SA�DA
    System.out.println ("O tempo total em horas e minutos � de " +horas+ " horas e " +minutos+ " minutos.");
    
    
  }
}