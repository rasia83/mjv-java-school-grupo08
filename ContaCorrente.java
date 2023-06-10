public class ContaCorrente {

    // TODO
    // Número da agência
    private String  dataNascimento;
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

    public void transferir(String numeroContaDestino, double valorDeTransferencia){

        //verifica se o cliente tem saldo suficiente na conta para transferir
        if(saldoConta < valorDeTransferencia) {
            System.out.println("Saldo insuficiente!!");
        } else {
            saldoConta -= valorDeTransferencia;
            System.out.println("Transferencia para a conta:" + numeroContaDestino + " realizada com sucesso");
            System.out.println("Saldo atual:" + saldoConta);
        }
    }

}
