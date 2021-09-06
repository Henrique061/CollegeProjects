package calculapontos;

/*
 * Autor: Henrique Batista de Assis
 * Data: 26/08/2021
 */

public class Pontos 
{
    // variaveis de instancia (atributos)
    private int x, y;
    
    public Pontos (int pontoX, int pontoY)
    {
        // inicialização dos atributos pelo construtor
        x = pontoX;
        y = pontoY;
        
    } // fecha construtor Pontos
    
    public boolean Igual(Pontos p)
    {
        return this.x == p.x && this.y == p.y;
    } // fecha metodo Igual
    
    public double Distancia (Pontos p)
    {
        double distancia = Math.sqrt(Math.pow((this.x - p.x), 2) + Math.pow((this.y - p.y), 2));
        
        return distancia;
        
    } // fecha metodo Distancia
    
} // fecha classe Pontosontos
