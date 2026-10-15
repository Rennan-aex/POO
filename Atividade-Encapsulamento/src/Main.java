public class Main {

    public static void main(String[] args) {

        Aluno carlos = new Aluno("20261001", "Carlos Silva", "carlos@ifpi.edu.br");
        Aluno beatriz = new Aluno("20261002", "Beatriz Souza", "beatriz@ifpi.edu.br");

        carlos.exibirPerfil();
        System.out.println();
        beatriz.exibirPerfil();
        System.out.println();

        ContaEstudantil contaCarlos = new ContaEstudantil("001", carlos, 50.0);
        ContaEstudantil contaBeatriz = new ContaEstudantil("002", beatriz, 100.0);

        System.out.println("Conta do Carlos: " + contaCarlos.getNumeroConta());
        System.out.println("Conta da Beatriz: " + contaBeatriz.getNumeroConta());
        System.out.println();

        System.out.println("Deposito negativo de -50 na conta do Carlos...");
        contaCarlos.depositar(-50.0);
        System.out.println("Saldo do Carlos: " + contaCarlos.getSaldo());

        System.out.println("Deposito de 100 na conta do Carlos...");
        contaCarlos.depositar(100.0);
        System.out.println("Saldo do Carlos: " + contaCarlos.getSaldo());
        System.out.println();

        System.out.println("Pagamento de 130 na conta do Carlos...");
        boolean pago = contaCarlos.pagar(130.0);
        System.out.println("Pagamento autorizado: " + pago);
        System.out.println("Saldo do Carlos: " + contaCarlos.getSaldo());

        System.out.println("Pagamento de 50 na conta do Carlos...");
        boolean recusado = contaCarlos.pagar(50.0);
        System.out.println("Pagamento autorizado: " + recusado);
        System.out.println("Saldo do Carlos: " + contaCarlos.getSaldo());
        System.out.println();

        System.out.println("Transferencia de 20 da conta do Carlos para a Beatriz...");
        boolean transferiu = contaCarlos.transferir(contaBeatriz, 20.0);
        System.out.println("Transferencia realizada: " + transferiu);
        System.out.println("Saldo final do Carlos: " + contaCarlos.getSaldo());
        System.out.println("Saldo final da Beatriz: " + contaBeatriz.getSaldo());
    }
}
