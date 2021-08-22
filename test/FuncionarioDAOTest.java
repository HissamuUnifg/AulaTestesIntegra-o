import database.SQLite;
import database.dao.FuncionarioDAO;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Funcionario;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.mockito.ArgumentMatchers;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

public class FuncionarioDAOTest {
    private FuncionarioDAO sut;
    
    @Mock
    private SQLite db;
    
    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        this.sut = new FuncionarioDAO(db);
    }
    
    @Test
    public void deveChamarOMetodoExecuteQuery(){
        try {            
            Funcionario funcionario;
            funcionario = new Funcionario("any_conta", 
                    "any_name", 
                    LocalDate.now(), 
                    1500, 
                    true);
            sut.insert(funcionario);
            Mockito.verify(db).executeQuery(anyString());
        } catch (SQLException ex) {}
    }
    
    @Test
    public void deveChamarOMetodoExecuteQueryELancarExcecao() {
        
        try { 
            Mockito.doThrow(new SQLException()).when(db).executeQuery(anyString());
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        Funcionario funcionario;
        funcionario = new Funcionario("any_conta", 
                "any_name", 
                LocalDate.now(), 
                1500, 
                true);
        int status = sut.insert(funcionario);    
        
        assertEquals(1, status);
        
    }
    
    @Test
    public void deveChamarOMetodoUpdate() {
    
    }
    
    @Test
    public void deveChamarOMetodoUpdateELancarExcecao() {
    
    }
    
    @Test
    public void deveChamarOMetodoFindAll() {
    
    }
    
    @Test
    public void deveChamarOMetodoFindAllComExcecao() {
    
    }
}
