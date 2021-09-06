package calculadorafracao;

/*
 * Autor: Henrique Batista de Assis
 * Data: 02/09/2021
 */

public class CalculadoraFracao {

    public static void main(String[] args) 
    {
        Fracao f1;
        Fracao f2;
        Fracao f3;
        
        // inicializa as fracos chamando o construtor da classe
        f1 = new Fracao(1, 2);
        f2 = new Fracao(3, 4);
        f3 = new Fracao(2, 4);
        
        Fracao som = new Fracao(0, 0);
        Fracao mul = new Fracao(0, 0);
        Fracao div = new Fracao (0, 0);
        boolean igu;
        
        // soma
        som = f1.soma(f2);
        som = som.soma(f3);
        
        // multiplicacao
        mul = f1.multiplicacao(f2);
        mul = mul.multiplicacao(f3);
        
        // divisao
        div = f1.divisao(f2);
        div = div.divisao(f3);
        
        // igualdade
        igu = f1.igualdade(f2);
        
        System.out.println("Soma de f1 + f2 + f3 = " +som);
        System.out.println("Multiplicacao de f1 * f2 * f3 = " +mul);
        System.out.println("Divisao de f1 / f2 / f3 = " +div);
        System.out.println("f1 e f2 são iguais? = " +igu);
    }
    
}
