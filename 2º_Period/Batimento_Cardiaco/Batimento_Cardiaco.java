// Exerc�cio Batimento Card�aco
// Autor: Henrique Batista de Assis
// Data: 14/09/2020

// Batimento = 75 bpm
// 1h = 60m
// 1h = 4500b
// 1d = 24h

// 1d = 108.000b
// 1m = 30d
// 1a = 365d

// ENTRADA
import java.util.Scanner;

public class Batimento_Cardiaco{
  public static void main(String[]args){
    Scanner entrada = new Scanner (System.in);
    
    // VARI�VEIS
    long anos;
    long meses;
    long dias;
    
    // anos
    System.out.println ("Digite sua idade em anos:");
    anos = entrada.nextLong();
    for (; anos < 0 || anos > 120; ){
      System.out.println ("Quantia de anos inv�lida, digite uma quantia v�lida");
      anos = entrada.nextLong();
    }
    
    // meses
    System.out.println ("Meses (Entre 0 e 11)");
    meses = entrada.nextLong();
    for (; meses < 0 || meses > 11; ){
      System.out.println ("Quantia de meses inv�lida, digite uma quantia v�lida");
      meses = entrada.nextLong();
    }
    
    // dias
    System.out.println ("Dias (Entre 0 e 30)");
    dias = entrada.nextLong();
    for (; dias < 0 || dias > 30; ){
      System.out.println ("Quantia de dias inv�lida, digitie uma quantia v�lida");
      dias = entrada.nextLong();
    }
    
    // PROCESSAMENTO
    
    //SA�DA
    System.out.println ("Seu n�mero total de batimentos card�acos � em torno de "+((anos * 365) + (meses * 30) + dias) * 108000+" batimentos.");
    
  }
}