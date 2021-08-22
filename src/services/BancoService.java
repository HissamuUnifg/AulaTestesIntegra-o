package services;

public class BancoService {
    public boolean pagarFuncionario(String conta, double salario){
        System.out.println("Coletando dados do funcionário...");
        System.out.println("Validando credenciais com a API do banco via conexão https...");
        System.out.println("Aguardando validação...");
        System.out.println("verificando retorno...");
        
        if(true){
            System.out.println("Pagamento do funcionario " + conta + " efetuado. Valor: " + salario);
            return true;
        }
        System.out.println("Erro ao efetuar o pagamento.");
        return false;
    }
}
