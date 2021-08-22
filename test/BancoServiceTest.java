import controllers.GestorPagamentos;
import database.dao.FuncionarioDAO;
import java.time.LocalDate;
import java.util.ArrayList;
import models.Funcionario;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import services.BancoService;

public class BancoServiceTest {
    
    private BancoService sut;
    
    @Before
    public void init(){
        this.sut = new BancoService();
    }
    
    @Test
    public void verificaServicoDoBancoRetornaVerdadeiro() {
        Funcionario func = new Funcionario("12345","Wilson", LocalDate.now(), 1500, false);
        Funcionario func2 = new Funcionario("67890","Hissa", LocalDate.now(), 1500, false);
        Funcionario func3 = new Funcionario("98765","Shirado", LocalDate.now(), 1500, false);
        
        FuncionarioDAO dao = new FuncionarioDAO();
        dao.insert(func);
        dao.insert(func2);
        dao.insert(func3);
        
        GestorPagamentos gp = new GestorPagamentos(dao, new BancoService());
        gp.pagarFuncionarios();
        
        ArrayList<Funcionario> funcionarios = dao.findAll();               
        for(Funcionario funcionario : funcionarios){            
            assertTrue(funcionario.isPago());
        }
    }
}
