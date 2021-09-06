// Trabalho 4 - Ordenacao de Palavras
// Autor: Henrique Batista de Assis
// Data: 20/06/2021

import java.io.*;

public class OrdenacaoPalavras 
{
    public static void main (String[] args) throws FileNotFoundException, IOException
    {
        FileReader lerArquivo = new FileReader ("palavras.txt");
        BufferedReader lerBuffer = new BufferedReader (lerArquivo);
        
        CriaVetor(lerBuffer);
        
    } // fecha funcao main
    
    // CRIA VETOR ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public static void CriaVetor (BufferedReader lerBuffer) throws FileNotFoundException, IOException
    {
        int n = 0, i = 0;
        
        while (true)
        {
            String linha = lerBuffer.readLine();
            
            if (linha == null)
                break;
            
            String vetor[] = linha.split(" ");
                
            if (i == 0) // if para atribuir o numero de casos
            {
                n = Integer.parseInt(vetor[0]);
                i++;
            }
            
            else
            {
                for (int j = 0; j < vetor.length; j++) // for para converter as palavras em letras minusculas
                    vetor[j] = vetor[j].toLowerCase();
                
                MergeSort(vetor, 0, vetor.length); // chama funcao para realizar o merge sort
                
                Print(vetor);
                
            } // fecha else
            
        } // fecha while para leitura de vetores
        
    } // fecha funcao CriaVetor
    
    // MERGE SORT /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public static void MergeSort(String vetor[], int inicio, int tamanhoVetor)
    {
        if (inicio < tamanhoVetor - 1) // if para caso base, realiza acao apenas de tiver elemento no vetor
        {
            int meio = (inicio + tamanhoVetor) / 2; // calcula onde está o meio do vetor
            
            MergeSort(vetor, inicio, meio); // recursividade para a metade da esquerda do vetor
            MergeSort(vetor, meio, tamanhoVetor); // recursividade para a metade da direita do vetor
            
            Intercalacao(vetor, inicio, meio, tamanhoVetor); // chama funcao para aplicar a intercalacao entre os valores
            
        } // fecha if
        
    } // fecha funcao MergeSort
    
    // INTERCALACAO /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public static void Intercalacao(String vetor[], int inicio, int meio, int tamanhoVetor)
    {
        // VARIAVEIS
        String v[] = new String [tamanhoVetor - inicio];
        int i = inicio, m = meio, k = 0; // indicadores
        
        while (i < meio && m < tamanhoVetor) // repete ação até que uma das metades do vetor chegue ao fim
        {
            if (vetor[i].length() > vetor[m].length())
                v[k++] = vetor[i++];
            
            else if (vetor[m].length() > vetor[i].length())
                v[k++] = vetor[m++];
            
            else if (vetor[i].length() == vetor[m].length()) // ordenação de palavras de tamanho igual em ordem alfabética
            {
                if (vetor[i].compareTo(vetor[m]) <= 0)
                    v[k++] = vetor[i++];
                
                else
                    v[k++] = vetor[m++];
            
            }
            
        } // fecha while
        
        while (i < meio) // acresenta palavras que sobrou da primeira metade
            v[k++] = vetor[i++];
        
        while (m < tamanhoVetor) // acresenta palavras que sobrou da segunda metade
            v[k++] = vetor[m++];
        
        for (k = 0, i = inicio; k < v.length; k++, i++)
            vetor[i] = v[k];
        
    } // fecha funcao Intercalacao
    
    // PRINT /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public static void Print(String vetor[])
    {
        for (int i = 0; i < vetor.length; i++)
            System.out.print(vetor[i]+ " ");
        
        System.out.println();
        
    } // fecha funcao print
    
} // fecha programa
