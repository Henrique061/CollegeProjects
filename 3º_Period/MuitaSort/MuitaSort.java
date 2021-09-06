// Trabalho 2 - Muita Sort
// Autor: Henrique Batista de Assis
// Data: 07/05/2021

/*
 * - Vetor com N numeros inteiros positivos; - OK
 * - Um numero inteiro positivo M; - OK
 * - Ordenar o vetor em ordem crescente ao valor do seu modulo de M (V[] % M); - OK
 *
 * - EMPATE IMPAR E PAR: IMPAR vem antes; - OK
 * - EMPATE IMPARES: MAIOR vem na frente; - OK
 * - EMPATE PARES: MENOR vem na frente;
 * - SEQUENCIA LOGICA: Impar > <, par < >;
 *
 * - Entrada feita por arquivo txt; - OK
 * - Primeira linha com o numero inteiro N e numero inteiro M; - OK
 * - Segunda linha com os valores do vetor; - OK
*/

import java.io.*;
import java.util.Scanner;

public class MuitaSort 
{
    public static void main (String[] args) throws FileNotFoundException, IOException
    {
        FileReader lerArquivo;
        
        // VARIAVEIS
        int example, testAgain = 1, N = 0, M = 0;
        int vetor[] = new int [0], vetorOriginal[] = new int [0];
        String nReceiver = "", mReceiver = "";
        String vetorReceiver[];
        boolean secondLine = false, chooseExample;
        
        while(testAgain == 1)
        {
            chooseExample = true; // variavel para definir qual mensagem aparecera na funcao ChooseExample
            example = ChooseExample(chooseExample); // funcao para usuario escolher qual exemplo quer escolher
        
            // VERIFICACAO DE EXEMPLO - INICIO
            if (example == 1)
                lerArquivo = new FileReader("sort_1.txt");

            else if (example == 2)
                lerArquivo = new FileReader("sort_2.txt");

            else
                lerArquivo = new FileReader("sort_3.txt");
            // VERIFICACAO DE EXEMPLO - FIM
        
            // LEITURA DE ARQUIVO - INICIO -----------------------------------------
            BufferedReader lerBuffer = new BufferedReader(lerArquivo);
            secondLine = false; // variavel para verificar se esta na segunda linha do txt
        
            while(true) // laço para readline
            {
                String line = lerBuffer.readLine();
            
                if (line == null)
                    break;
            
                // divisao da linha quando tem um espaço
                String vetorLine[] = line.split(" ");
            
                if (secondLine == false) // verificacao para atribuir a primeira linha as variaveis String N e M
                {
                    for (int i = 0; i < vetorLine.length; i++) // laco para atribuir as variaveis String N e M
                    {
                        if (i == 0)
                            nReceiver = vetorLine[i];
                    
                        else
                            mReceiver = vetorLine[i];
                    
                    } // fecha for N e M receivers
                
                    N = Integer.parseInt(nReceiver);
                    M = Integer.parseInt(mReceiver);
                    // passando de String's para Int's
                
                    secondLine = true;
                
                } // fecha if N e M receivers
            
                else // atribuir o vetor String pela segunda linha do txt
                {
                    vetor = new int [N];
                    vetorReceiver = new String [N];
                    vetorOriginal = new int [N]; // vetor para mostrar ao usuario qual era a sequencia numerica original
                    // alocando o tamanho dos vetores int's e String
                
                    for (int i = 0; i < vetorLine.length; i++) // laco para atribuir os valores aos vetores
                    {
                        vetorReceiver[i] = vetorLine[i];
                        vetor[i] = Integer.parseInt(vetorReceiver[i]);
                        vetorOriginal[i] = vetor[i];
                    }
       
                } // fecha else vetor
            
            } // fecha while lerArquivo
        
            lerBuffer.close();
            // LEITURA DE ARQUIVO - FIM --------------------------------------------
        
            ModSort(vetor, M); // chama funcao ModSort (bubblesort no vetor pelo modulo)
        
            PairOddSort(vetor, M); // chama funcao PairOddSort (bubblesort para organizar os pares e ímpares)
        
            Print(vetor, vetorOriginal, M, N); // chama funcao para printar a solucao
        
            chooseExample = false; // variavel para definir qual mensagem aparecera na funcao ChooseExample
            testAgain = ChooseExample(chooseExample); // chama funcao ChooseExample para testar um exemplo novamente
        }// fecha while principal
        
    } // fecha funcao principal
    
    // FUNCAO CHOOSE EXAMPLE ////////////////////////////////////////////////////////////////////////////////////////////
    public static int ChooseExample(boolean chooseExample)
    {
        Scanner ler = new Scanner(System.in);
        
        int example = 0, testAgain = 0;
        
        if (chooseExample == true) // if para opcao de escolher um exemplo
        {
            System.out.print("Escolha qual exemplo deseja verificar a ordenação, 1, 2 ou 3: ");
        
            while (true) // laco para o jogador escolher um numero entre 1 e 3 apenas
            {
                example = ler.nextInt();
            
                if (example >= 1 && example <= 3)
                    break;
            
                else
                    System.out.print("\nO valor escolhido deve ser 1, 2 ou 3: ");
            }
        
            return example;
        }
        
        else if (chooseExample == false) // if para opcao de sair do programa
        {
            System.out.println("\n\nEscolha qual acao deseja fazer:");
            System.out.println("1 - Testar um exemplo novamente.");
            System.out.println("2 - Sair do programa");
        
            while (true) // laco para o jogador escolher um numero entre 1 e 3 apenas
            {
                testAgain = ler.nextInt();
            
                if (testAgain >= 1 && testAgain <= 2)
                    break;
            
                else
                    System.out.print("\nO valor escolhido deve ser 1 (testar novamente) ou 2 (sair do programa): ");
            }
            System.out.println("");
        
            return testAgain;
        }
        
        return 0;
    } // fecha funcao ChooseExample
    
    public static void ModSort(int vetor[], int M)
    {
        for (int j = 1; j < vetor.length; j++)
            for (int i = 0; i < vetor.length - j; i++)
            {
                if((vetor[i] % M) > (vetor[i + 1] % M)) // comparacao do vetor modulo de M para realizar a troca
                {
                    int temp = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = temp;
                }
            }
    } // fecha funcao ModSort
    
    public static void PairOddSort(int vetor[], int M)
    {
        int temp = 0, parImparAtual, parImparProximo;
        
        for (int j = 1; j < vetor.length; j++)
            for (int i = 0; i < vetor.length - j; i++)
                if ((vetor[i] % M) == (vetor[i + 1] % M)) // faz a troca apenas se o modulo for igual entre os numeros
                {
                    parImparAtual = vetor[i] % 2;
                    parImparProximo = vetor[i + 1] % 2;
                    // variaveis que calculam o par e impar do valor do indice atual do vetor e do proximo
                    
                    if (parImparAtual == 0 && parImparProximo == 1) // troca para deixar numeros impares na frente
                    {
                        temp = vetor[i];
                        vetor[i] = vetor[i + 1];
                        vetor[i + 1] = temp;
                    }
                    
                    else if (parImparAtual == 1 && parImparProximo == 1) // troca entre impares para o maior ir para frente
                    {
                        if (vetor[i] < vetor[i + 1])
                        {
                            temp = vetor[i];
                            vetor[i] = vetor[i + 1];
                            vetor[i + 1] = temp;
                        }
                    }
                    
                    else if (parImparAtual == 0 && parImparProximo == 0) // troca entre pares para o menor ir para frente
                    {
                        if (vetor[i] > vetor[i + 1])
                        {
                            temp = vetor[i];
                            vetor[i] = vetor[i + 1];
                            vetor[i + 1] = temp;
                        } 
                    }
                    
                }// fecha if da comparacao do modulo
        
    } // fecha funcao PairOddSort
    
    public static void Print(int vetor[], int vetorOriginal[], int M, int N)
    {
        System.out.println("\nQuantidade de numeros no vetor: " +N);
        System.out.println("Valor utilizado para calcular o modulo: " +M+ "\n");
        System.out.println("Vetor em sua ordem original:");
        
        for (int i = 0; i < vetorOriginal.length; i++) // laco para disponibilizar o vetor original
            System.out.print(vetorOriginal[i]+ "  ");
        
        System.out.println("\n\nVetor ordenado de acordo com seu modulo, impares e pares:");
        
        for (int i = 0; i < vetor.length; i++) // laco para disponibilizar o vetor ordenado
            System.out.print(vetor[i]+ "  ");
    } // fecha funcao Print
    
} // fecha programa
