
import database.SQLite;
import database.dao.FuncionarioDAO;
import java.time.LocalDate;
import java.util.Vector;
import models.Funcionario;

public class Main {

    public static void main(String[] args) {
        System.out.println("Main.main()"); 
        
        Funcionario func = new Funcionario("Hissa", LocalDate.now(), 1500);
        FuncionarioDAO dao = new FuncionarioDAO();
        dao.insert(func);
        
        Vector<Funcionario> funcionarios = dao.getAll();               
        System.out.println(funcionarios.get(0).getNome());
        
    }    
}
