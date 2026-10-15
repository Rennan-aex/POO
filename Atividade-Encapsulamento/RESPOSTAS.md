# Prática POO 02 – Encapsulamento – Respostas

## 1. getTitular().setNome(...)

Sim, isso altera o estado do objeto Aluno de fora da classe ContaEstudantil. O problema é que o método getTitular() devolve a própria referência do objeto que está dentro da conta, ou seja, quem chama consegue pegar o objeto e mexer nele direto, chamando setNome() e mudando o nome do titular. Isso fere o encapsulamento, porque o atributo titular estava protegido, mas a referência vazou.

Para evitar isso, poderíamos criar um método como getNomeTitular() que devolve só a String do nome, sem expor o objeto inteiro. Outra opção é devolver uma cópia do Aluno dentro de getTitular(), assim quem chama mexe na cópia e não afeta o original. Uma terceira opção seria deixar a classe Aluno imutável, sem setters, mas aí não daria para mudar nome nenhum depois de criado.

## 2. Enviar e-mail dentro de pagar()

Isso fere o princípio da responsabilidade única. A ContaEstudantil existe para cuidar das regras da conta: saldo, limite de crédito, depósito, pagamento e transferência. Enviar e-mail é outra responsabilidade completamente diferente, e colocar isso dentro do pagar() mistura as duas coisas no mesmo método.

O certo seria tirar o envio de e-mail da ContaEstudantil e colocar numa classe separada, por exemplo um ServicoEmail ou Notificador. Aí quem usaria a conta (a Main, por exemplo) chamaria o notificador depois de ver que o pagamento foi autorizado, e a conta continuaria focada só no que ela precisa fazer.

## 3. ContaEstudantil.transferir() usando outra ContaEstudantil

Esse acoplamento é aceitável e considerado baixo. O transferir() recebe outra conta do mesmo tipo, mas não fica mexendo nos atributos dela diretamente. Ele usa os métodos públicos pagar() e depositar(), que são a forma correta de interagir com a conta de destino.

Além disso, faz sentido a conta conhecer outra conta do mesmo tipo, porque transferência é uma operação entre duas contas. Não é como depender de uma classe de fora que não tem nada a ver com o assunto. O acoplamento existe, mas é baixo e faz parte do problema.

## 4. BancoDoBrasilAPI dentro de transferir()

Se a gente criasse a classe BancoDoBrasilAPI e chamasse ela direto dentro do transferir(), o acoplamento ficaria alto. A ContaEstudantil ficaria presa a uma API específica do Banco do Brasil. Se no futuro precisasse trocar por outro banco, teria que mexer no código da conta. Também ficaria difícil de testar, porque para testar o transferir() precisaria da API de verdade.

A solução seria criar uma interface, por exemplo ValidadorTransferencia, e a conta dependesse só dela. Aí a classe BancoDoBrasilAPI seria uma implementação dessa interface, e poderia ser trocada por outra sem alterar a ContaEstudantil. Assim a implementação concreta fica escondida e o acoplamento fica baixo.
