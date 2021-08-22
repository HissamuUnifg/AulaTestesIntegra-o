import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({BonusServiceTest.class, 
    ReajusteServiceTst.class,
    BancoServiceTest.class,
    FuncionarioDAOTest.class})
public class AllTests {
    
}
