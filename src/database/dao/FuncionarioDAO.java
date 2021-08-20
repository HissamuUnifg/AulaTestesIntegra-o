package database.dao;

import database.SQLite;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Funcionario;

public class FuncionarioDAO {
    SQLite db;

    public FuncionarioDAO() {
        this.db = new SQLite(true);
    }
    
    public void insert(Funcionario funcionario){
        String query = "INSERT INTO funcionarios (nome, salario, conta, pago) VALUES ('"
                + funcionario.getNome() + "',"
                + funcionario.getSalario() + ","
                + funcionario.getConta() + ","
                + (funcionario.isPago() ? 1 : 0) +
                ")";
        System.out.println("database.dao.FuncionarioDAO.insert() "+query);
        try {
            db.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(Funcionario funcionario){
        String query = "UPDATE funcionarios SET "
                + "nome = '" + funcionario.getNome() + "',"
                + " salario = " + funcionario.getSalario()+ ","
                + " pago = " + (funcionario.isPago() == true ? 1 : 0)
                + " WHERE id = " + funcionario.getId();
                ;
        System.out.println("database.dao.FuncionarioDAO.insert() " + query);
        try {
            db.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Funcionario> findAll(){
        ArrayList<Funcionario> result = new ArrayList<>();
        ResultSet rs;
        String query = "SELECT * FROM funcionarios ORDER BY nome";
        try {
            rs = this.db.find(query);
            while (rs.next()) {
                result.add(new Funcionario(
                        rs.getInt("id"),
                        rs.getString("conta"),
                        rs.getString("nome"), 
                        LocalDate.now(),
                        rs.getInt("salario"),                        
                        rs.getInt("pago") == 1 ? true : false));
            }
            
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
   
}
