
import java.time.LocalDate;
import junit.framework.Assert;
import models.Funcionario;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import services.BonusService;

public class BonusServiceTest {
    private BonusService service;
       
    @Before
    public void init() {
        this.service = new BonusService();
    }

    @Test
    public void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
        double bonus = service.calcularBonus(
                new Funcionario("any_conta", "any_name", LocalDate.now(), 25000.00, false));
        assertEquals(0.0, bonus, 0.001);
    }
    
    @Test
    public void bonusDeveriaSer10PorCentoDoSalario() {
        double bonus = service.calcularBonus(
                new Funcionario("any_conta", "any_name", LocalDate.now(), 2500.00, false));

        assertEquals(250.00, bonus, 0.001);
    }

    @Test
    public void bonusDeveriaSerDezPorCentoParaSalarioDeExatamente10000() {
        double bonus = service.calcularBonus(
                new Funcionario("any_conta", "any_name", LocalDate.now(), 10000, false));

        assertEquals(1000.00, bonus, 0.001);
    }

}
