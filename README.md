# Criar em Eclipse, um novo Java Project com uma classe chamada RedesController.java no package controller e uma classe Main.java no package view. 

A classe RedesController.java deve ter 3 métodos.

1) O primeiro identifica e retorna o nome do Sistema Operacional (Fazê-lo privado)

2) O segundo verifica o Sistema Operacional e, de acordo com o S.O., faz a chamada de configuração de IP.
A leitura do processo chamado deve verificar cada linha e, imprimir, apenas, o nome do
adaptador de rede e o IPv4, portanto, adaptadores sem IPv4 não devem ser mostrados

3) O terceiro, chamado ping, que verifica o Sistema Operacional e, de acordo com o S.O. e, faz a
chamada de ping em IPv4 com 10 iterações.
A leitura do processo chamado deve verificar as linhas de saída e exibir, apenas o tempo médio
do ping. O teste de ping deve ser feito com a URL www.google.com.br.

A Classe Main.java deve dar as opções de chamadas do método ip ou do método ping com
JOptionPane e, dependendo da escolha, instanciar a Classe RedesController.java e chamar o
método escolhido. A opção de finalizar a aplicação também deve estar disponível.
