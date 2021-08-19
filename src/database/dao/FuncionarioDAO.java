package database.dao;

import database.SQLite;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Funcionario;

public class FuncionarioDAO {
    SQLite db;

    public FuncionarioDAO() {
        this.db = new SQLite(false);
    }
    
    public void insert(Funcionario funcionario){
        String query = "INSERT INTO funcionarios (nome, salario) VALUES ('"
                + funcionario.getNome() + "',"
                + funcionario.getSalario()+ ")";
        System.out.println("database.dao.FuncionarioDAO.insert() "+query);
        try {
            db.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Vector<Funcionario> getAll(){
        Vector<Funcionario> result = new Vector<Funcionario>();
        ResultSet rs;
        String query = "SELECT * FROM funcionarios ORDER BY nome";
        try {
            rs = this.db.find(query);
            while (rs.next()) {
                result.add(new Funcionario(rs.getString("nome"), 
                        LocalDate.now() ,
                        rs.getInt("salario")));
            }
            
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
