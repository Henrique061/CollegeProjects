Deve implementar um programa que realizará uma série de
operações envolvendo vetores e funções, o usuário pode solicitar as seguintes operações:

1) Inicializar o vetor com números aleatórios;
2) Imprimir o vetor;
3) Verificar se um determinado número está contido no vetor;
4) Buscar o maior número armazenado no vetor;
5) Calcular a média dos números pares armazenados no vetor;
6) Calcular o percentual dos números ímpares armazenados no vetor;
7) Buscar a maior diferença absoluta entre números armazenados no vetor;
8) Verificar se dado um valor existe dois números em posições distintas que somados são iguais ao valor informado.

Para o usuário escolher as operações, o seu programa deverá mostrar um menu de opções, sendo que para cada
opção deverá ser executada a operação correspondente, além disso, o programa deverá executar até o momento
que usuário solicite finalizar o programa, ou seja, o usuário pode escolher outras operações do menu de opção
várias vezes, após ser executada a operação o menu de opções é apresentado novamente. A seguir são descritas
detalhadamente cada uma das operações:

1. Inicializar o vetor com números aleatórios;
Enquanto o usuário não escolher essa operação as outras operações não poderão executar, pois o vetor
estará vazio. Quando o usuário selecionar essa opção o programa solicita o tamanho do vetor (N), em
seguida é criado um vetor com N posições e preenchida as posições do vetor com números inteiros
positivos gerados aletoriamente.

2. Imprimir o vetor;
Nessa operação o seu programa imprime o conteúdo do vetor.

3. Verificar se um determinado número está contido no vetor;
Nessa operação o seu programa solicita que o usuário informe um valor a ser procurado no vetor, em
seguida é chamada a função correspondente a essa operação, a função recebe por parâmetro o vetor e o
valor a ser procurado, caso o valor esteja no vetor sua função retorna o índice onde foi encontrado o
valor, e caso contrário sua função retorna -1, por fim, fora da função, o seu programa imprime uma
mensagem informando se o valor foi ou não encontrado.

4. Buscar o maior número armazenado no vetor;
Nessa operação o seu programa não solicita nada ao usuário, somente chama a função que recebe por
parâmetro o vetor de números, a função percorre o vetor e retorna o maior elemento encontrado no
vetor, no programa principal é impresso o maior elemento encontrado no vetor.

5. Calcular a média dos números pares armazenados no vetor;
Nessa operação o seu programa não solicita nada ao usuário, somente chama a função que recebe por
parâmetro o vetor de números, a função calcula e retorna a média dos números pares armazenados no
vetor, no programa principal é impresso a média calculada.

6. Calcular o percentual dos números ímpares armazenados no vetor;
Nessa operação o seu programa não solicita nada ao usuário, somente chama a função que recebe por
parâmetro o vetor de números, a função calcula e retorna o percentual de números ímpares armazenados
no vetor, no programa principal é impresso o percentual calculado.

7. Buscar a maior diferença absoluta entre números armazenados no vetor;
Nessa operação o seu programa não solicita nada ao usuário, somente chama a função que recebe por
parâmetro o vetor de números, a função retorna o valor da maior diferença absoluta entre dois números
armazenados no vetor, no programa principal é impresso o valor da diferença encontrado.

8. Verificar se dado um valor existe dois números em posições distintas que somados são iguais ao valor informado.
E por fim, temos a operação que verifica se existe no vetor dois números, em posições distintas, que
somados tem como resultado o valor informado por parâmetro à função, nessa operação deve ser
implementada uma função que recebe como parâmetro o vetor e um valor, sem seguida, a função verifica
se existe dois números que somados é igual ao valor informado por parâmetro, caso exista esses dois
números no vetor a função retorna true e false caso contrário.