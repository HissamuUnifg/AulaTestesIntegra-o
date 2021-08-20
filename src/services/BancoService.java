package services;

public class BancoService {
    public boolean pagarFuncionario(String conta, double salario){
        System.out.println("Pagamento do funcionario " + conta + " efetuado. Valor: " + salario);
        return true;
    }
}
