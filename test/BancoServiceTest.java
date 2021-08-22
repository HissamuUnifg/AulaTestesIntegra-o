import controllers.GestorPagamentos;
import database.dao.FuncionarioDAO;
import java.time.LocalDate;
import java.util.ArrayList;
import models.Funcionario;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import services.BancoService;

public class BancoServiceTest {
    
    @Mock
    private BancoService sut;
    
    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void verificaServicoDoBancoRetornaVerdadeiro() {
        Funcionario func = new Funcionario("12345","Wilson", LocalDate.now(), 1500, false);
        Funcionario func2 = new Funcionario("67890","Hissamu", LocalDate.now(), 1500, false);
        Funcionario func3 = new Funcionario("98765","Shirado", LocalDate.now(), 1500, false);
                
        FuncionarioDAO dao = new FuncionarioDAO();                
        dao.insert(func);
        dao.insert(func2);
        dao.insert(func3);
        
        // Deve passar o valor exato da chamada ou usar any caso o valor seja indiferente
        when(sut.pagarFuncionario(anyString(), anyDouble())).thenReturn(Boolean.TRUE);
        
        // Estamos passando agora para o GestorPagamento, classes MOCKADAS;
        // Assim podemos simular o comportamentos delas sem a necessidade de
        // integragar com sistemas reais.
        GestorPagamentos gp = new GestorPagamentos(dao, sut);
        gp.pagarFuncionarios();
        
        
        ArrayList<Funcionario> funcionarios = dao.findAll();               
        for(Funcionario funcionario : funcionarios){            
            assertTrue(funcionario.isPago());
        }
        
    }
    
    @Test
    public void verificaServicoDoBancoRetornaFalso() {
        Funcionario func = new Funcionario("12345","Wilson", LocalDate.now(), 1500, false);
        Funcionario func2 = new Funcionario("67890","Hissamu", LocalDate.now(), 1500, false);
        Funcionario func3 = new Funcionario("98765","Shirado", LocalDate.now(), 1500, false);
                
        FuncionarioDAO dao = new FuncionarioDAO();                
        dao.insert(func);
        dao.insert(func2);
        dao.insert(func3);
        
        // Deve passar o valor exato da chamada ou usar any caso o valor seja indiferente
        when(sut.pagarFuncionario(anyString(), anyDouble())).thenReturn(Boolean.FALSE);
        
        // Estamos passando agora para o GestorPagamento, classes MOCKADAS;
        // Assim podemos simular o comportamentos delas sem a necessidade de
        // integragar com sistemas reais.
        GestorPagamentos gp = new GestorPagamentos(dao, sut);
        gp.pagarFuncionarios();
        
        
        ArrayList<Funcionario> funcionarios = dao.findAll();               
        for(Funcionario funcionario : funcionarios){            
            assertFalse(funcionario.isPago());
        }
        
    }
    
    /*public void verificaServicoDoBancoRetornaVerdadeiro() {
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
    }*/
}
