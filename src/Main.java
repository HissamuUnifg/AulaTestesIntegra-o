
import controllers.GestorPagamentos;
import services.BancoService;
import database.dao.FuncionarioDAO;
import java.time.LocalDate;
import java.util.ArrayList;
import models.Funcionario;

public class Main {

    public static void main(String[] args) {
        System.out.println("Main.main()"); 
        
        Funcionario func = new Funcionario("12345","Wilson", LocalDate.now(), 1500, false);
        Funcionario func2 = new Funcionario("67890","Hissa", LocalDate.now(), 1500, false);
        Funcionario func3 = new Funcionario("98765","Shirado", LocalDate.now(), 1500, false);
        
        FuncionarioDAO dao = new FuncionarioDAO();
        dao.insert(func);
        dao.insert(func2);
        dao.insert(func3);
        
        ArrayList<Funcionario> funcionarios = dao.findAll();               
        for(Funcionario funcionario : funcionarios){
            System.out.println(funcionario.toString());
        }
        
        GestorPagamentos gp = new GestorPagamentos(dao, new BancoService());
        gp.pagarFuncionarios();
        
        
    }    
}
