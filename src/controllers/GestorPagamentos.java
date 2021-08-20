package controllers;

import services.BancoService;
import database.dao.FuncionarioDAO;
import java.util.ArrayList;
import models.Funcionario;

public class GestorPagamentos {
    
    FuncionarioDAO dao;
    BancoService banco;

    public GestorPagamentos(FuncionarioDAO dao, BancoService banco) {
        this.dao = dao;
        this.banco = banco;
    }    
    
    public int pagarFuncionarios(){
        ArrayList<Funcionario> funcionarios = dao.findAll();
        int pagamentos = 0;
        
        for(Funcionario funcionario : funcionarios){
            if(banco.pagarFuncionario(funcionario.getConta(), funcionario.getSalario())){                
                funcionario.setPago(true);
                pagamentos++;
            }else{
                funcionario.setPago(false);
            }
            
            dao.update(funcionario);
        }
        
        return 0;
    }
    
    public void resetarPagamentos(){
        // resetar os pagamentos a cada novo mês
    }
}
