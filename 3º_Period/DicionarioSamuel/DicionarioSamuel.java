// Trabalho 3 - Dicinario do Samuel
// Autor: Henrique Batista de Assis
// Data: 31/05/2021

/*
 * - Historia salva em arquivo txt;
 * - palavra = sequencia de letras ou uma letra so;
 * - case insensitive, ou seja, AAA, aaa, AaA é tudo uma palabvra so;
 * - para cada palavra achada, deve fazer uma busca para ver se ja consta no dicionario;
 * - a palavra deve ser inserida em ordem alfabetica

 * - armazenar palavras num String vetor[100];
 * - buscas feitas por funcao recursiva;
 * - inserir palavras por funcao recursiva;
 * - OBS: NÃO ARMAZENAR AS PALAVRAS TODAS E DEPOIS ORDENAR, E SIM JA IR ORDENADO QUANDO ADICIONA UMA PALAVRA NO VETOR;
*/

import java.io.*;
        
public class DicionarioSamuel 
{
    // MAIN ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void main (String[] args) throws FileNotFoundException, IOException
    {
        // VARIAVEIS
        FileReader lerArquivo = new FileReader("story.txt");
        String allWords[] = new String [100];
        
        BufferedReader lerBuffer = new BufferedReader(lerArquivo); // buferiza entrada de arquivo
        
        int numberOfWords = StoreWordsR(allWords, lerBuffer, 0); // chama funcao recursiva para armazenar todas as palavras dentro de um vetor
        
        lerBuffer.close();
        
        PrintR(allWords, 0); // chama funcao recursiva para printar vetor
        
        System.out.println("\nHa " +numberOfWords+ " palavras no dicionario.");
        
        
        
    } // fecha funcao main
    
    // STORE WORDS /////////////////////////////////////////////////////////////////////////////////////////////////////
    public static int StoreWordsR(String allWords[], BufferedReader lerBuffer, int i) throws FileNotFoundException, IOException
    {
        String line = lerBuffer.readLine();
        
        if (line.equals(".")) // if para caso base
            return i;
        
        else 
        {
            String lineText[] = line.split(" "); // armazena linha inteira num vetor string
            
            i = StoreAllWordsR(allWords, lineText, i, 0); // chama funcao de recursiva de armazenamento de palavras no vetor original
            
            i = StoreWordsR(allWords, lerBuffer, i);
            
            return i;
        }
        
    } // fecha funcao SortWordsR
    
    // STORE ALL WORDS /////////////////////////////////////////////////////////////////////////////////////////////////////
    public static int StoreAllWordsR(String allWords[], String lineWords[], int i, int k)
    {
        int repeatWord = 0; // 0 = não tem repeticao; 1 = tem repeticao
        
        if (k >= lineWords.length) // if para caso base
            return i;
        
        else
        {
            repeatWord = RepeatWordR(lineWords[k], allWords, 0); // funcao recursiva para verificar se há palavra repetida
            
            if (repeatWord == 0) // realiza acao se nao houver palavra repetida
            {
                allWords[i] = lineWords[k];
            
                SortWordsR(allWords, i);
                i++;
            }
            
            k++;
            
            return StoreAllWordsR(allWords, lineWords, i, k);
            
        } // fecha else
        
    } // fecha funcao StoreWordsR
    
    // REPEAT WORD //////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static int RepeatWordR(String word, String allWords[], int i)
    {
        if (i >= allWords.length || allWords[i] == null) // if para caso base
            return 0;
        
        else if (word.compareToIgnoreCase(allWords[i]) != 0)
        {
            i++;
            return RepeatWordR(word, allWords, i);
        }
        
        return 1;
        
    } // fecha funcao RepeatWordR
    
    // SORT WORDS ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static int SortWordsR(String allWords[], int i)
    {
        if (i >= allWords.length || i == 0 || allWords[i] == null) // if para caso base
            return 0;
        
        else
        {
            if (allWords[i].compareToIgnoreCase(allWords[i - 1]) >= 0)
                return 0;
            
            else // realiza o sort
            {
               String temp = allWords[i - 1];
               allWords[i - 1] = allWords[i];
               allWords[i] = temp;
               
               i--;
               
               return SortWordsR(allWords, i);
               
            } // fecha else 2
            
        } // fecha else 1
        
    } // fecha funcao SortWordsR
    
    // PRINT /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void PrintR(String allWords[], int i)
    {
        if (i < allWords.length && allWords[i] != null) // if caso base, realizara a acao se atender as condicoes
        {
            System.out.println(allWords[i].toLowerCase());
            i++;
            
            PrintR(allWords, i);
            
        } // fecha if
        
    } // fecha funcao print
    
} // fecha programa

