public class ContaCorrente {

    // TODO
    // Número da agência
    // Data de nascimento
    private String nomeCliente;
    private double saldoConta;

    private int numeroConta;
    
    // Transferir um valor para outra conta
    // Consultar o extrato entre duas datas

    public double sacarValor(double valor) {
        return saldoConta -= valor;
    }

    public double consultarSaldoAtual() {
        return saldoConta;
    }

    public int getNumeroConta() {
        return this.numeroConta;
    }

    public void cancelarConta(String justificativa) {

    }


}
