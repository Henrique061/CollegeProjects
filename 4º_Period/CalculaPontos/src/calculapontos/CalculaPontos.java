package calculapontos;

/*
 * Autor: Henrique Batista de Assis
 * Data: 26/08/2021
 */

public class CalculaPontos {
    public static void main(String[] args) 
    {
        Pontos A = new Pontos(1, 2);
        Pontos B = new Pontos(3, 4);
        
        boolean iguais = A.Igual(B);
        double dist = A.Distancia(B);
        
        System.out.println("A e B sao iguais? = " +iguais);
        System.out.println("Distancia entre A e B = " +dist);
        
    } // fecha funcao main
    
}
