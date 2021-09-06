// Exercício Distância Entre Pontos
// Autor: Henrique Batista de Assis
// Data: 21/09/2020

/* 
 * Como representar os pontos em um plano cartesiano, o que é um plano cartesiano?
 * R: É um diagrama que permite localizar pontos distintos dentro de um sistema de coordenadas retangulares,
 *    podendo assim calcularmos a distância entre 2 ou mais pontos.
 * 
 * Tem alguma fórmula matemática que nos ajuda?
 * R: Sim, basta escolher 2 pontos distintos que possuem qualquer coordenada A(x1, y1) e B(x2, y2) no plano 
 *    cartesiano, assim aplica-se a fórmula: dAB = R*(x2 - x1)² + (y2 - y1)²*.
 *    * = Começo e término da raíz.
 * 
 * Como armazenar os pontos no programa ?
 * R: Para armazenar os pontos, basta atribuir cada uma em uma variável diferente do tipo double.
 * 
 * Tenho todos os recursos de programação na linguagem Java para resolver o problema?
 * R: Sim. Para raíz quadrada, utiliza-se da função "Math.sqrt(double n)" onde n = o valor ou expressão a ser calculado.
 *    E para elevação, basta utilizar a função "Math.pow(double x, double y)" onde mostra o resultado de x elevado à y.
*/

// --------------------------------------------ENTRADA------------------------------------------------
import java.util.Scanner;

public class Distancia_Pontos{
  public static void main(String[]args){
    Scanner cartesiano = new Scanner (System.in);
    
    // VARIÁVEIS
    double a_x1;
    double a_y1;
    double b_x2;
    double b_y2;
    double distancia;
    
    // declaração dos pontos pelo usuário.
    System.out.println ("Informe a posição do Ponto A em x");
    a_x1 = cartesiano.nextDouble();
    
    System.out.println ("Informe a posição do Ponto A em y");
    a_y1 = cartesiano.nextDouble();
    
    System.out.println ("Informe a posição do Ponto B em x");
    b_x2 = cartesiano.nextDouble();
    
    System.out.println ("Informe a posição do Ponto B em y");
    b_y2 = cartesiano.nextDouble();
    
    // ---------------------------------------PROCESSAMENTO--------------------------------------------
    distancia = Math.sqrt(Math.pow(b_x2 - a_x1, 2) + Math.pow(b_y2 - a_y1, 2));
    
    //-------------------------------------------SAÍDA-------------------------------------------------
    System.out.printf ("A distância entre os pontos A e B é de %.2f.",(distancia));
  }
}