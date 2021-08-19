package services;

import models.Desempenho;
import models.Funcionario;

public class ReajusteService {
    public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
        double reajuste = desempenho.percentualReajuste();
        funcionario.reajustarSalario(reajuste);
    }
}
