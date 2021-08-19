package services;

import java.time.LocalDate;
import java.time.Period;
import models.Desempenho;
import models.Funcionario;

public class ReajusteService {
    public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
        double reajuste = desempenho.percentualReajuste();
        funcionario.reajustarSalario(reajuste);
    }

    public void concederReajuste(Funcionario funcionario) {
        Period period = Period.between(funcionario.getDataAdmissao(), LocalDate.now());
        System.out.print(period.getYears() + " years,");
        if(period.getYears() >= 5){
           funcionario.reajustarSalario(0.05);
        }        
    }
}
