
public class ContaCorrente {

import java.util.Date;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class ContaCorrente {
    private Date dataNascimento;
    private String nomeCliente;
    private double saldoConta;
    private int numeroConta = new Random().nextInt(1000);

    public ContaCorrente(String nomeCliente, Date dataNascimento){
        this.nomeCliente = nomeCliente;
        this.dataNascimento = dataNascimento;
    }

    public ContaCorrente() {

    }


    public double sacarValor(double valor) {
        return saldoConta -= valor;
    }

    public double consultarSaldoAtual() {
        return saldoConta;
    }

    public void depositar(double dinheiro) {
        this.saldoConta += dinheiro;
    }

    public int getNumeroConta() {
        return this.numeroConta;
    }

    public void transferir(ContaCorrente contaDestino, double valorDeTransferencia){
        if(saldoConta < valorDeTransferencia) {
            System.out.println("Saldo insuficiente!!");
        } else {
            this.saldoConta -= valorDeTransferencia;
            contaDestino.saldoConta += valorDeTransferencia;
            System.out.println("Transferencia para a conta:" + contaDestino.getNumeroConta() + " realizada com sucesso");
            System.out.println("Saldo atual:" + saldoConta);
        }
    }
	
    public List<Transacao> consultarExtrato(Date dataInicial, Date dataFinal) {
    	List<Transacao> extrato = new ArrayList<>();
/*
    	for (Transacao transacao : historicoTransacoes) {
        	if (transacao.getData().after(dataInicial) && transacao.getData().before(dataFinal)) {
            	    extrato.add(transacao);
        } 
	//Isso seria apenas um rascunho, já que seria necessário criar algo como a classe Transacao e outros requisitos para que isso fosse excutado corretamente
*/

		return extrato;
	}
  
}
