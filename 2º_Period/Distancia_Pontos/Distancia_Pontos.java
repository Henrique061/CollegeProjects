// Exerc�cio Dist�ncia Entre Pontos
// Autor: Henrique Batista de Assis
// Data: 21/09/2020

/* 
 * Como representar os pontos em um plano cartesiano, o que � um plano cartesiano?
 * R: � um diagrama que permite localizar pontos distintos dentro de um sistema de coordenadas retangulares,
 *    podendo assim calcularmos a dist�ncia entre 2 ou mais pontos.
 * 
 * Tem alguma f�rmula matem�tica que nos ajuda?
 * R: Sim, basta escolher 2 pontos distintos que possuem qualquer coordenada A(x1, y1) e B(x2, y2) no plano 
 *    cartesiano, assim aplica-se a f�rmula: dAB = R*(x2 - x1)� + (y2 - y1)�*.
 *    * = Come�o e t�rmino da ra�z.
 * 
 * Como armazenar os pontos no programa ?
 * R: Para armazenar os pontos, basta atribuir cada uma em uma vari�vel diferente do tipo double.
 * 
 * Tenho todos os recursos de programa��o na linguagem Java para resolver o problema?
 * R: Sim. Para ra�z quadrada, utiliza-se da fun��o "Math.sqrt(double n)" onde n = o valor ou express�o a ser calculado.
 *    E para eleva��o, basta utilizar a fun��o "Math.pow(double x, double y)" onde mostra o resultado de x elevado � y.
*/

// --------------------------------------------ENTRADA------------------------------------------------
import java.util.Scanner;

public class Distancia_Pontos{
  public static void main(String[]args){
    Scanner cartesiano = new Scanner (System.in);
    
    // VARI�VEIS
    double a_x1;
    double a_y1;
    double b_x2;
    double b_y2;
    double distancia;
    
    // declara��o dos pontos pelo usu�rio.
    System.out.println ("Informe a posi��o do Ponto A em x");
    a_x1 = cartesiano.nextDouble();
    
    System.out.println ("Informe a posi��o do Ponto A em y");
    a_y1 = cartesiano.nextDouble();
    
    System.out.println ("Informe a posi��o do Ponto B em x");
    b_x2 = cartesiano.nextDouble();
    
    System.out.println ("Informe a posi��o do Ponto B em y");
    b_y2 = cartesiano.nextDouble();
    
    // ---------------------------------------PROCESSAMENTO--------------------------------------------
    distancia = Math.sqrt(Math.pow(b_x2 - a_x1, 2) + Math.pow(b_y2 - a_y1, 2));
    
    //-------------------------------------------SA�DA-------------------------------------------------
    System.out.printf ("A dist�ncia entre os pontos A e B � de %.2f.",(distancia));
  }
}