import java.time.LocalDate;

public class ContaCorrentTest {
    public static void main(String[] args){
        ContaCorrente primeiraConta = new ContaCorrente("pedro", LocalDate.parse("2000-08-15"));
        ContaCorrente segundaConta = new ContaCorrente("lucas", LocalDate.parse("1999-06-11"));

        System.out.println(primeiraConta.getNumeroConta());

        primeiraConta.depositar(1000);
        System.out.println(primeiraConta.consultarSaldoAtual());

        primeiraConta.sacarValor(500);
        System.out.println(primeiraConta.consultarSaldoAtual());

        primeiraConta.transferir(segundaConta, 250);
        System.out.println(primeiraConta.consultarSaldoAtual());
        System.out.println(segundaConta.consultarSaldoAtual());

        primeiraConta.consultarExtrato(LocalDate.parse("2023-06-10"), LocalDate.parse("2023-06-15"));
    }
}
