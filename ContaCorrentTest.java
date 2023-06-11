public class ContaCorrentTest {
    public static void main(String[] args){
        ContaCorrente primeiraConta = new ContaCorrente();
        ContaCorrente segundaConta = new ContaCorrente();

        System.out.println(primeiraConta.getNumeroConta());

        primeiraConta.depositar(1000);
        System.out.println(primeiraConta.consultarSaldoAtual());

        primeiraConta.sacarValor(500);
        System.out.println(primeiraConta.consultarSaldoAtual());

        primeiraConta.transferir(segundaConta, 250);
        System.out.println(primeiraConta.consultarSaldoAtual());
        System.out.println(segundaConta.consultarSaldoAtual());
    }
}
