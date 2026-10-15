public class ContaEstudantil {

    private final String numeroConta;
    private double saldo;
    private Aluno titular;
    private double limiteCredito;

    public ContaEstudantil(String numeroConta, Aluno titular, double limiteCredito) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.limiteCredito = limiteCredito;
        this.saldo = 0.0;
    }

    public String getNumeroConta() {
        return this.numeroConta;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public double getLimiteCredito() {
        return this.limiteCredito;
    }

    public Aluno getTitular() {
        return this.titular;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo = this.saldo + valor;
        }
    }

    public boolean pagar(double valor) {
        if ((this.saldo + this.limiteCredito) >= valor) {
            this.saldo = this.saldo - valor;
            return true;
        }
        return false;
    }

    public boolean transferir(ContaEstudantil destino, double valor) {
        if (this.pagar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }
}
