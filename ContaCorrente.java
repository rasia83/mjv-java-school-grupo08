import java.time.LocalDate;
import java.util.Random;
import java.util.ArrayList;

public class ContaCorrente {
    private LocalDate dataNascimento;
    private String nomeCliente;
    private double saldoConta;
    private boolean contaAtiva = true;
    private int numeroConta = new Random().nextInt(1000);
    private ArrayList<Transacao> transacoes =new ArrayList<Transacao>();

    public ContaCorrente(String nomeCliente, LocalDate dataNascimento){
        this.nomeCliente = nomeCliente;
        this.dataNascimento = dataNascimento;
        this.contaAtiva = true;
    }

    public double sacarValor(double valor) {
        transacoes.add(new Transacao(LocalDate.now(),"você sacou " + valor ));
        return saldoConta -= valor;
    }

    public double consultarSaldoAtual() {
        transacoes.add(new Transacao(LocalDate.now(),"você consultou seu saldo "));
        return saldoConta;
    }

    public void depositar(double dinheiro) {
        transacoes.add(new Transacao(LocalDate.now(),"você depositou " + dinheiro));
        this.saldoConta += dinheiro;
    }

    public int getNumeroConta() {
        return this.numeroConta;
    }

    public void cancelar(){
        transacoes.add(new Transacao(LocalDate.now(),"você cancelou sua conta"));
        contaAtiva = false;
        System.out.println("conta cancelada");
    }

    public void transferir(ContaCorrente contaDestino, double valorDeTransferencia) {
        if (saldoConta < valorDeTransferencia) {
            System.out.println("Saldo insuficiente!!");
        } else {
            this.saldoConta -= valorDeTransferencia;
            contaDestino.saldoConta += valorDeTransferencia;
            transacoes.add(
              new Transacao(
                LocalDate.now(),
                "você transferiu " + valorDeTransferencia + " para a conta " + contaDestino.getNumeroConta()
              ));
            System.out.println("Transferencia para a conta:" + contaDestino.getNumeroConta() + " realizada com sucesso");
            System.out.println("Saldo atual:" + saldoConta);
        }
    }
    
    public void consultarExtrato(LocalDate dataInicial, LocalDate dataFinal) {
        System.out.println("--------------- Extrato da conta ---------------");
        System.out.println("numero da conta " + numeroConta);
        System.out.println("nome do cliente " + nomeCliente);
        System.out.println("data de nascimento " + dataNascimento);
        System.out.println("conta esta ativa? " + contaAtiva);
        System.out.println("saldo da conta " + saldoConta);

        System.out.println("------------ Historico de transferencia ------------");

        for (Transacao transacao : transacoes) {
            if (transacao.data().isAfter(dataInicial) && transacao.data().isBefore(dataFinal)) {
                System.out.println(transacao.data() + " ----> " + transacao.descricao());
            }
        }
    }
}
