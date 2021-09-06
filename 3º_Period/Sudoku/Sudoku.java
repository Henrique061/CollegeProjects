// Trabalho 1 - Sudoku
// Autor: Henrique Batista de Assis
// Data: 05/04/2021

/*
- Funcao game() chama todas as outras funcoes;

- Funcao initialize() faz a leitura da grade em um arquivo txt e devolve uma matriz 9x9, com os valores iniciais; OK

- Funcao print() imprime a grade do sudoku na tela;

- Funcao step() recebe a posicao e numero escolhido pelo jogador. retorna - 1 se a posicao ja estiver preenchida (ou invalida), 
    0 se tiver número repetido na linha, coluna ou grade, 1 se a posição foi válida. Também é responsável por remover um
    elemento, retorna 1 caso tenha sucesso, - 1 caso não (numero ja vem por padrão no jogo);

- Funcao status() verifica se não há mais posicoes vazias. retorna true caso o jogador tenha ganhado, false se não;
*/

package trabalho_1;

import java.io.*;
import java.util.Scanner;

public class Sudoku {
    public static void main (String[] args) throws FileNotFoundException, IOException
    {
        game();      
    } // fecha funcao principal
    
    // FUNCAO GAME -------------------------------------------------------------
    public static void game () throws FileNotFoundException, IOException
    {
        Scanner ler = new Scanner(System.in);
        
        // VARIAVEIS
        char jogo[][] = new char[9][9];
        char jogoFixo[][] = new char[9][9];
        char valorChar = '.';
        
        int dificuldade = 0, acao = 0, linha = 0, coluna = 0, valor = 0; 
        int procedeAcao = -1, jogarNovamente = 1;
        
        boolean acabou = false;
        
        while (jogarNovamente == 1)
        {
            // condicao para poder jogar novamente
            acabou = false;
            
            // mensagem de boas vindas
            System.out.println("**************************");
            System.out.println("* BEM VINDO AO SUDOKU!!! *");
            System.out.println("************************** \n");
         
            while (true) // laco para escolher a dificuldade
            {
                System.out.println("***********************************");
                System.out.println("* Escolha o Nivel de dificuldade: *");
                System.out.println("* 1 - Facil                       *");
                System.out.println("* 2 - Normal                      *");
                System.out.println("* 3 - Dificil                     *");
                System.out.println("*********************************** \n");
            
                System.out.print("Dificuldade: ");
                dificuldade = ler.nextInt();
            
                if (dificuldade >= 1 && dificuldade <= 3)
                    break;
            
                else
                    System.out.println("\nO valor da dificuldade deve ser 1 (Facil), 2 (Normal) ou 3 (Dificil). \n");
            
            } // fecha dificuldade
        
            System.out.println();
        
            jogo = initialize(dificuldade); 
            
            // atribuindo os valores da matriz do jogo para outra matriz com os valores fixos
            for (int i = 0; i < jogoFixo.length; i++)
                for (int j = 0; j < jogoFixo[0].length; j++)
                    jogoFixo[i][j] = jogo[i][j];
        
            // mensagem de dificuldade - inicio
            if (dificuldade == 1)
                System.out.println("DIFICULDADE FACIL ESCOLHIDA, BOM JOGO!!! \n");
        
            else if (dificuldade == 2)
                System.out.println("DIFICULDADE NORMAL ESCOLHIDA, BOM JOGO!!! \n");
        
            else
                System.out.println("DIFICULDADE DIFICIL ESCOLHIDA, BOM JOGO!!! \n");
            // mensagem de dificuldade - fim
        
            while (acabou == false) // abre while do jogo
            {
                // mostra tabuleiro
                print(jogo);
            
                while (true) // laco para escolher acao desejada
                {
                    System.out.println("**************************");
                    System.out.println("* Escolha uma acao:      *");
                    System.out.println("* 1 - Adicionar um valor *");
                    System.out.println("* 2 - Apagar um valor    *");
                    System.out.println("* 3 - Sair do jogo       *");
                    System.out.println("************************** \n");
            
                    System.out.print("Acao: ");
                    acao = ler.nextInt();
                
                    if (acao >= 1 && acao <= 3)
                        break;
                
                    else
                        System.out.println("\nO valor da acao deve ser 1 (Adicionar valor), 2 (Apagar valor) ou 3 (Sair do jogo). \n");
                
                } // fecha laco da acao desejada
            
                // sai do jogo
                if (acao == 3)
                    break;
            
                while (true) // laco que verifica se escolheu linha e coluna corretamente
                {
                    if (acao == 1)
                        System.out.print("\nDigite a linha e coluna respectivamente, separada por espaco, para escolher onde colocar o valor desejado: ");
            
                    else if (acao == 2)
                        System.out.print("\nDigite a linha e coluna respectivamente, separada por espaco, para escolher o valor a ser removido: ");
            
                    linha = ler.nextInt();
                    coluna = ler.nextInt();
                
                    if ((linha >= 1 && linha <= 9) && (coluna >= 1 && coluna <= 9))
                        break;
                
                    else
                        System.out.print("\nValor da linha e coluna devem ser maiores que 0 e menores que 10.");
                    
                } // fecha laco de escolha de linha e coluna
                
                if (acao == 1)
                {
                    while (true) // laco para ver se escolheu um numero valido
                    {
                        System.out.print("\nEscolha o valor a ser colocado: ");
                        valor = ler.nextInt();
                    
                        if (valor >= 1 && valor <= 9)
                            break;
                    
                        else
                            System.out.print("\nValor a ser preenchido deve ser maior que 0 e menor que 10.");
                    
                    }// fecha laco de escolha de numero
                
                }// fecha if para escolher numero
            
                // subtracao para equivaler ao indice da matriz
                linha = linha - 1;
                coluna = coluna - 1;
            
                procedeAcao = step(jogo, jogoFixo, linha, coluna, valor, acao);
            
                valorChar = (char)(valor + '0');
            
                // colocar numero
                if (acao == 1)
                {
                    if (procedeAcao == -1)
                        System.out.println("\nJa existe um numero nessa posicao.\n");
                
                    if (procedeAcao == 0)
                        System.out.println("\nO numero escolhido possui repeticao na mesma linha, coluna ou grade.\n");
                
                    if (procedeAcao == 1)
                    {
                        jogo[linha][coluna] = valorChar;
                        System.out.println("\nPOSICAO PREENCHIDA!.\n");
                    }
                } // fecha if acao 1
            
                // tirar numero
                if (acao == 2)
                {
                    if (procedeAcao == -1)
                        System.out.println("\nPosicao escolhida ja esta vazia.\n");
                
                    if (procedeAcao == 0)
                    {
                        System.out.println("\nA posicao escolhida possui um numero que não pode ser tirado.\n");
                        System.out.println("Abaixo esta a tabela com os numeros que nao podem ser tirados.\n");
                        System.out.println("────────────────────────────────────────────\n");
                    
                        // exibicao da matriz de apenas os numeros fixos
                        print(jogoFixo);
                    
                        System.out.println("────────────────────────────────────────────");
                        System.out.println("|             Abaixo agora esta a tabela do jogo atual.              |");
                        System.out.println("────────────────────────────────────────────");
                    }
                
                    if (procedeAcao == 1)
                    {
                        jogo[linha][coluna] = '_';
                        System.out.println("\nPOSICAO APAGADA!.\n");
                    }
                } // fecha if acao 2
            
                // verifica se jogo acabou
                acabou = status(jogo);
            
            } // fecha while do jogo, ACABOU O JOGO.
        
            if (acao != 3)
            {
                print(jogo);
                System.out.println("\nPARABENS!!! VOCE VENCEU O JOGO!!!\n");
        
                while(true)
                {
                    System.out.println("***********************");
                    System.out.println("* 1 - Jogar Novamente *");
                    System.out.println("* 2 - Sair do Jogo    *");
                    System.out.println("*********************** \n");
                    
                    System.out.print("Opcao: ");
                    jogarNovamente = ler.nextInt();
            
                    if (jogarNovamente >= 1 && jogarNovamente <= 2)
                        break;
            
                    else
                        System.out.println("\nO valor da opcao deve ser 1 (Jogar novamente) ou 2 (Sair do Jogo). \n");
                }
            
            } // fecha if jogou normalmente
            
            else
                jogarNovamente = 2;
        
        } // fecha while pra fechar programa
        
    } // fecha funcao GAME
    
    // FUNCAO INITIALIZE -------------------------------------------------------
    public static char [][] initialize (int nivel) throws FileNotFoundException, IOException
    {
        char matriz[][] = new char [9][9];
        int i = 0;
        FileReader lerArquivo;
        
        // VERIFICACAO DE DIFICULDADE - INICIO
        if (nivel == 1)
            lerArquivo = new FileReader("sudoku_facil.txt");
        
        else if (nivel == 2)
            lerArquivo = new FileReader("sudoku_normal.txt");
        
        else
            lerArquivo = new FileReader("sudoku_dificil.txt");
        // VERIFICACAO DE DIFICULDADE - FIM
        
        BufferedReader lerBuffer = new BufferedReader(lerArquivo);
        
        while (true) // laco para readline
        {
            String linha = lerBuffer.readLine();
            
            if (linha == null)
                break;
            
            // divisao da linha quando tem um espaço
            String vetorLinha[] = linha.split(" ");
            
            for (int j = 0; j < matriz[0].length; j++)
                matriz[i][j] = vetorLinha[j].charAt(0);
            
            i++;
        }
        lerBuffer.close();
        
        return matriz;
              
    } // fecha funcao INITIALIZE
    
    // FUNCAO PRINT ------------------------------------------------------------
    public static void print(char matriz[][])
    {
        int contLinha = 1;
        
        // disposicao da numeracao das colunas no tabuleiro
        System.out.println("    │ 1 2 3 │ 4 5 6 │ 7 8 9");
        System.out.println("    │ • • • │ • • • │ • • •");
        System.out.println("───────────────────");
        
        for (int i = 0; i < matriz.length; i++) // for 1
        {
            // colocar separação na linha a cada quadrante
            if (i == 3 || i == 6)
                System.out.println("───────────────────");
            
            // disposicao da numeracao das linhas no tabuleiro
            System.out.print(contLinha+ " • │ ");
            
            for (int j = 0; j < matriz[0].length; j++) // for 2
            {
                // colocar separação na coluna a cada quadrante
                if (j == 3 || j == 6)
                    System.out.print("│ ");
                
                System.out.print(matriz[i][j]+ " ");
                
            } // fecha for 2
           
            System.out.println();
            contLinha++;
            
        } // fecha for 1
        
        System.out.println();
        
    } // fecha funcao PRINT
    
    // FUNCAO STEP -------------------------------------------------------------
    public static int step (char matriz[][], char matrizFixo[][], int lin, int col, int num, int opcao)
    {
        int linGrade, colGrade;
        
        if (opcao == 1)
        {
            // verifica se ha um numero ja na posicao
            if (matriz[lin][col] != '_')
                return -1;
            
            // verifica repeticao coluna -------------------
            for (int i = 0; i < matriz.length; i++)
                if (matriz[i][col] == num + '0')
                    return 0;
            
            // verifica repeticao linha -------------------
            for (int j = 0; j < matriz[0].length; j++)
                if (matriz[lin][j] == num + '0')
                    return 0;
            
            // verifica repeticao grade -------------------
            linGrade = (lin / 3) * 3;
            colGrade = (col / 3) * 3;
            
            for (int k = linGrade; k < linGrade + 3; k++)
                for (int l = colGrade; l < colGrade + 3; l++)
                    if (matriz[k][l] == num + '0')
                        return 0;
            
        } // fecha if opcao 1
        
        else if (opcao == 2)
        {
            // verifica se a posicao esta vazia
            if (matriz[lin][col] == '_')
                return -1;
            
            // verifica se nao e um valor fixo
            if (matrizFixo[lin][col] != '_')
                return 0;
            
        } // fecha if opcao 2
        
        return 1;
        
    } // fecha funcao STEP
    
    // FUNCAO STATUS -----------------------------------------------------------
    public static boolean status(char matriz[][])
    {
        // verifica se ha posicao faltando
        for (int i = 0; i < matriz.length; i++)
            for (int j = 0; j < matriz[0].length; j++)
                if (matriz[i][j] == '_')
                    return false;
        
        return true;
        
    } // fecha funcao STATUS
    
} // fecha programa
