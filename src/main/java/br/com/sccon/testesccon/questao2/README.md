# Questão 2

Escreva um método que recebe uma lista de strings como parâmetro. Essa lista possui uma série de nomes
próprios, podendo conter nomes repetidos. O método deve retornar um objeto com o número de
ocorrências por nome, com a contagem seguindo a ordem alfabética dos nomes. A contagem de ocorrências
por nome deve ser case-insensitive e deve ignorar acentuação (“João” e “jOao” são considerados como
sendo o mesmo nome). Não utilize funções Lambda.

Exemplo de entrada: {“Pedro”, “João”, “Maria”, “JOAO”, “Alberto”, “João”, “MARiA”}

Saída esperada: {“ALBERTO” = 1, “JOAO” = 3, “MARIA” = 2, “PEDRO” = 1}
 
## Resposta
 
 1. Implementação da classe de Agrupamento, ordenação e contagem de strings:
 - https://github.com/michelmdes/sccon-test/blob/master/src/main/java/br/com/sccon/testesccon/questao2/AgrupadorOrdenadoList.java
 2. Testes unitários de validação: 
 - https://github.com/michelmdes/sccon-test/blob/master/src/test/java/br/com/sccon/testesccon/questao2/AgrupadorOrdenadoListTest.java
 