package models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario {

    private int id;
    private String conta;    
    private String nome;
    private LocalDate dataAdmissao;
    private double salario;
    private boolean pago;

    public Funcionario(int id, String conta, String nome, LocalDate dataAdmissao, 
            double salario, boolean pago) {
        this.id = id;
        this.conta = conta;
        this.nome = nome;
        this.dataAdmissao = dataAdmissao;
        this.salario = salario;
        this.pago = pago;
    }
    
    public Funcionario(String conta, String nome, LocalDate dataAdmissao, 
            double salario, boolean pago) {
        
        this.id = 0;
        this.conta = conta;
        this.nome = nome;
        this.dataAdmissao = dataAdmissao;
        this.salario = salario;
        this.pago = pago;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public double getSalario() {
        return salario;
    }

    public void reajustarSalario(double percentual) {
        double aumento = calcularValorDoAumento(percentual);
        this.salario += aumento;
    }

    private double calcularValorDoAumento(double percentual) {
        return salario * percentual;
    }
    
    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public String getConta() {
        return conta;
    }

    public boolean isPago() {
        return pago;
    }

    @Override
    public String toString() {
        return "funcionario: " + this.nome + " conta: " + this.conta + " salario: " + this.salario;
    }
}
