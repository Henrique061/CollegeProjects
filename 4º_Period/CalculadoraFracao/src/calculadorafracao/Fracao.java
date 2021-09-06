
package calculadorafracao;

/*
 * Autor: Henrique Batista de Assis
 * Data: 02/09/2021
 */

public class Fracao 
{
    // variaveis de instancia (atributos)
    private int num, den;
    
    // definicao de construtores
    public Fracao(int numerador, int denominador)
    {
        // inicializa os atributos do objeto criado pelo construtor
        num = numerador;
        den = denominador;
    }
    
    // metodo para retornar uma string com os atributos da fracao
    public String toString()
    {
        return num+ "/" +den;
    }
    
    // f1 chama o metodo soma, entao f1 eh um parametro (IMPLICITO) para o metodo, 
    // e as informacoes sao acessadas diretamente atraves dos seus atributos usando
    // o operador de referencia deste objeto "this"
    //
    // f2 eh passado por parametro da forma tradicional (EXPLICITO) para o metodo, 
    //e dentro do metodo eh acessado pelo parametro f
    //
    // (a/b) + (c/d) = ((a.d + b.c) / b.d)
    public Fracao soma(Fracao f)
    {
        // a = num
        // b = den
        // c = f.num
        // d = f.den
        int num = (this.num * f.den + f.num * this.den);
        int den = (f.den * this.den);
        
        Fracao fRetorno = new Fracao(num, den);
        
        return fRetorno;
    }
    
    // multiplacacao = a.c / b.d
    public Fracao multiplicacao(Fracao f)
    {
        int num = (this.num * f.num);
        int den = (this.den * f.den);
        
        Fracao fReturn = new Fracao(num, den);
        
        return fReturn;
    }
    
    // divisao = a.d / b.c
    public Fracao divisao(Fracao f)
    {
        int num = (this.num * f.den);
        int den = (this.den * f.num);
        
        Fracao fReturn = new Fracao(num, den);
        
        return fReturn;
    }
    
    // igualdade = a.d == b.c
    public boolean igualdade(Fracao f)
    {
        boolean igual;
        return igual = this.num * f.den == this.den * f.num;
    }
}
