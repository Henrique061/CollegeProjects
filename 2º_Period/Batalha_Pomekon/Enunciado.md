Os Ginásios são locais espalhados pelo mundo onde acontecem batalhas entre Pomekons de treinadores rivais, os
treinadores de equipes adversárias lutam pelo controle dos Ginásios. Uma batalha de Pomekons consiste em um
confronto entre Pomekons de treinadores diferentes dentro de um Ginásio em uma mesma arena, cada treinador
coloca seu Pomekon para lutar contra os Pomekons dos outros treinadores, a habilidade de um Pomekon se sair
bem em uma batalha é definida pela sua força de ataque (Pontos de Ataque) e os Pontos de Defesa.
Para determinar qual será o Pomekon vencedor de uma batalha é bem simples, basta calcular qual Pomekon possui
o maior Valor de Golpe em função do Pontos de Ataque e Pontos de Defesa conforme a fórmula abaixo:

Valor Golpe =
((Ataque + Defesa) / 2) + Bônus

No cálculo do Valor do Golpe o level do Pomekon também é levado em consideração, pois o Bônus no Valor do
Golpe só será atribuído ao Pomekon que estiver em um level de valor par.

Objetivo desse trabalho é escrever um programa que terá como entrada a quantidade de batalhas e treinadores, e
as informações para o cálculo do Valor do Golpe para cada um dos Pomekon dos treinadores nas batalhas, pois a
cada batalha o treinador pode trocar o Pomekon que irá usar.
A entrada do programa é realizada através do teclado, logo no início do o seu programa deve ler a quantidade de
batalhas que acontecerão e a quantidade de treinadores de equipes, em seguida, são lidos o valor do bônus que
poderá ser aplicado no cálculo do Valor do Golpe do Pomekon para cada uma das batalhas, e por fim, são lidas as
informações de cada um dos Pomekons envolvidos na batalha: Valor de Ataque, Valor de Defesa e level. Para cada
batalha o seu programa deve informar o Valor do Golpe de cada Pomekon e quem venceu a batalha ou se a batalha
terminou empatada. Considere que sempre teremos um numero de batalha maior igual a 1 e a quantidade de
treinadores maior igual a 2.

Exemplo e saída de entrada
Considere que em uma execução do programa foi informado que teremos 2 batalhas e 4 treinadores:

Entrada da 1a batalha
bonus:5
1o Pomekon
Valor Ataque: 12
Valor Defesa: 23
level:15
2o Pomekon
Valor Ataque: 42
Valor Defesa: 12
level:21
3o Pomekon
Valor Ataque: 35
Valor Defesa: 11
level:6
4o Pomekon
Valor Ataque: 18
Valor Defesa: 18
level:6

Saída da 1a batalha
Valor do Golpe 1o Pomekon: 17,5
Valor do Golpe 2o Pomekon: 27,0
Valor do Golpe 3o Pomekon: 28,0
Valor do Golpe 4o Pomekon: 23,03º Pomekon ganhou essa batalha.
*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~

Entrada da 2a batalha
bônus:3
1o Pomekon
Valor Ataque: 17
Valor Defesa: 18
level:10
2o Pomekon
Valor Ataque: 5
Valor Defesa: 8
level:22
3o Pomekon
Valor Ataque: 30
Valor Defesa: 11
level:1
4o Pomekon
Valor Ataque: 20
Valor Defesa: 9
level:21

Saída da 2a batalha
Valor do Golpe 1o Pomekon: 20,5
Valor do Golpe 2o Pomekon: 9,5
Valor do Golpe 3o Pomekon: 20,5
Valor do Golpe 4o Pomekon: 14,5
Deu empate nessa batalha.

Na implementação do seu programa você deve usar somente os conceitos vistos no conteúdo das aulas desse
semestre até o momento (operadores, tipos, variáveis, estruturas condicionais e de repetição, etc) não podendo
utilizar estruturas de armazenamento que serão vistas mais adianta no curso, tais como vetores, listas e ArrayList.