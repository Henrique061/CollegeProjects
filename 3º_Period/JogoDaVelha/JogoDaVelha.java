// Jogo da Velha
// Autor: Henrique Batista de Assis
// Data: 05/03/2021

/* - 1ª funcao preenche uma matriz 3x3, indicando que as casas estao vazias; OK
 * - Pedir ao jogador escolher uma posicao; OK
 * - Funcao que verifica qual peca é do jogador e se a posicao escolhida esta preenchida ou nao;
 * - Funcao que verifica o estado do jogo (-1 = continua, 0 = empate, 1 = O vitoria, 2 = X vitoria);
 * - Funcao que imprime o tabuleiro do jogo; OK
 * - Funcao da logica do jogo, chamando todas as funcoes.
*/

import java.util.Scanner;

public class JogoDaVelha 
{
    public static void main (String[] args) // funcao principal
    {
        // VARIAVEIS
        char matrizXO[][] = new char[3][3];
        
        matrizXO = initialize(); // chama funcao initialize
        
        game(matrizXO); // chama funcao game
        
    } // fecha funcao principal
    
    // -------------------------------------------------------------------------
    
    public static char [][] initialize () // funcao initialize
    {
        char matriz[][];
        
        matriz = new char[3][3];
        
        for (int i = 0; i < matriz.length; i++)
            for (int j = 0; j < matriz[0].length; j++)
                matriz[i][j] = '.';
        
        return matriz;
        
    } // fecha funcao initialize
    
    // -------------------------------------------------------------------------
    
    public static void game (char matrizJogo[][]) // funcao game
    {
        Scanner ler = new Scanner (System.in);
        
        // VARIAVEIS
        int vezDe = 0; // 0 = O, 1 = X
        String linha;
        int coluna, continua = -1; // - 1 = continua, 0 = empate, 1 = O vence, 2 = X vence;
        boolean preencheu;
        int linhaMatriz = -1, colunaMatriz = -1;
        
        while (continua == -1) // while continua
        {
            // mostra tabuleiro
            print(matrizJogo);
        
            linha = "";
            coluna = 0;
        
            if (vezDe == 0)
            { // abre if de O
                while(!linha.equals("a") && !linha.equals("b") && !linha.equals("c") && 
                      !linha.equals("A") && !linha.equals("B") && !linha.equals("C"))
                {
                    System.out.print("Jogador 'O' escolhe uma linha (A, B ou C): ");
                    linha = ler.next();
                
                    if(!linha.equals("a") && !linha.equals("b") && !linha.equals("c") && 
                       !linha.equals("A") && !linha.equals("B") && !linha.equals("C"))
                        System.out.println("Posição da linha deve ser A, B ou C.\n");
                
                } // fecha while da linha de O
            
                while(coluna < 1 || coluna > 3)
                {
                    System.out.print("Jogador 'O' escolhe uma coluna (1, 2 ou 3): ");
                    coluna = ler.nextInt();
                    System.out.println();
                
                    if(coluna < 1 || coluna > 3)
                        System.out.println("Posição da coluna deve ser 1, 2 ou 3.\n");
                
                } // fecha while da coluna de O
            } // fecha if de O
        
            else
            { // abre if de X
                while(!linha.equals("a") && !linha.equals("b") && !linha.equals("c") && 
                      !linha.equals("A") && !linha.equals("B") && !linha.equals("C"))
                {
                    System.out.print("Jogador 'X' escolhe uma linha (A, B ou C): ");
                    linha = ler.next();
                
                    if(!linha.equals("a") && !linha.equals("b") && !linha.equals("c") && 
                       !linha.equals("A") && !linha.equals("B") && !linha.equals("C"))
                        System.out.println("Posição da linha deve ser A, B ou C.\n");
                
                } // fecha while da linha de X
            
                while(coluna < 1 || coluna > 3)
                {
                    System.out.print("Jogador 'X' escolhe uma coluna (1, 2 ou 3): ");
                    coluna = ler.nextInt();
                    System.out.println();
                
                    if(coluna < 1 || coluna > 3)
                        System.out.println("Posição da coluna deve ser 1, 2 ou 3.\n");
                
                } // fecha while da coluna de X
            } // fecha if de X
            
            // aloca posicoes na matriz - inicio
            if (linha.equals("a") || linha.equals("A"))
                linhaMatriz = 0;
        
            else if (linha.equals("b") || linha.equals("B"))
                linhaMatriz = 1;
        
            else if (linha.equals("c") || linha.equals("C"))
                linhaMatriz = 2;
            
            colunaMatriz = coluna - 1;
            // aloca posicoes na matriz - fim
        
            preencheu = step(matrizJogo, linhaMatriz, colunaMatriz, vezDe);
            
            if (preencheu == false)
                System.out.println("Posicao escolhida ja foi preenchida, escolha outra posicao. \n");
            
            else // else de verificacao de jogo
            {
                if (vezDe == 0)
                    matrizJogo[linhaMatriz][colunaMatriz] = 'O';

                else
                    matrizJogo[linhaMatriz][colunaMatriz] = 'X';

                continua = status(matrizJogo);
                
                if (vezDe == 0)
                    vezDe = 1;
                
                else
                    vezDe = 0;
                 
            } // fecha else de verificacao de jogo
        
        } // fecha while continua
        
        print(matrizJogo);
        
        if (continua == 0)
            System.out.print("Jogo terminou empatado.");
        
        else if (continua == 1)
            System.out.print("Jogador 'O' venceu a partida!");
        
        else if (continua == 2)
            System.out.print("Jogador 'X' venceu a partida!");
        
    } // fecha funcao game
    
    // -------------------------------------------------------------------------
    
    public static int print(char M[][]) // funcao print
    {
        int retorno = 0;
        
        System.out.println("  | 1 | 2 | 3");
        System.out.println("--------------");
        System.out.println("A | " +M[0][0]+ " | " +M[0][1]+ " | " +M[0][2]);
        System.out.println("--------------");
        System.out.println("B | " +M[1][0]+ " | " +M[1][1]+ " | " +M[1][2]);
        System.out.println("--------------");
        System.out.println("C | " +M[2][0]+ " | " +M[2][1]+ " | " +M[2][2]+ "\n");
        
        return retorno;
        
    } // fecha funcao print
    
    // -------------------------------------------------------------------------
    
    public static boolean step(char matriz[][], int lin, int col, int turno) // funcao step
    {
        boolean preenchido = false;
                
        if (matriz[lin][col] == 'O' || matriz[lin][col] == 'X')
            preenchido = false;
        
        else if (turno == 0)
        {
            matriz[lin][col] = 'O';
            preenchido = true;
                    
        }
                    
        else if (turno == 1)
        {
            matriz[lin][col] = 'X';
            preenchido = true;
                    
        }
        
        return preenchido;
            
        
    } // fecha funcao step
    
    // -------------------------------------------------------------------------
    
    public static int status(char M[][]) // funcao status
    {
        int estado = -1;
        boolean tudoPreenchido = true;
        
        if ((M[0][0] == 'O' && M[0][1] == 'O' && M[0][2] == 'O') ||
            (M[1][0] == 'O' && M[1][1] == 'O' && M[1][2] == 'O') ||
            (M[2][0] == 'O' && M[2][1] == 'O' && M[2][2] == 'O') || // linhas ^
            (M[0][0] == 'O' && M[1][0] == 'O' && M[2][0] == 'O') ||
            (M[0][1] == 'O' && M[1][1] == 'O' && M[2][1] == 'O') ||
            (M[0][2] == 'O' && M[1][2] == 'O' && M[2][2] == 'O') || // colunas ^
            (M[0][0] == 'O' && M[1][1] == 'O' && M[2][2] == 'O') ||
            (M[0][2] == 'O' && M[1][1] == 'O' && M[2][0] == 'O')) // diagonais ^
        { 
            estado = 1;    
        }
        
        else if ((M[0][0] == 'X' && M[0][1] == 'X' && M[0][2] == 'X') ||
                 (M[1][0] == 'X' && M[1][1] == 'X' && M[1][2] == 'X') ||
                 (M[2][0] == 'X' && M[2][1] == 'X' && M[2][2] == 'X') || // linhas ^
                 (M[0][0] == 'X' && M[1][0] == 'X' && M[2][0] == 'X') ||
                 (M[0][1] == 'X' && M[1][1] == 'X' && M[2][1] == 'X') ||
                 (M[0][2] == 'X' && M[1][2] == 'X' && M[2][2] == 'X') || // colunas ^
                 (M[0][0] == 'X' && M[1][1] == 'X' && M[2][2] == 'X') ||
                 (M[0][2] == 'X' && M[1][1] == 'X' && M[2][0] == 'X')) // diagonais ^
        {
            estado = 2;
        }
        
        else
        {
            for (int i = 0; i < M.length; i++)
                for (int j = 0; j < M[0].length; j++)
                    if (M[i][j] == '.')
                        tudoPreenchido = false;
            
            if (tudoPreenchido == true)
                estado = 0;
            
            else
                estado = -1;
                
        } // fecha else
        
        return estado;
    
    } // fecha funcao status
}
