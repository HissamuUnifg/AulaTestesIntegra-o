
import java.time.LocalDate;
import models.Desempenho;
import models.Funcionario;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import services.ReajusteService;

public class ReajusteServiceTst {
    private ReajusteService service;
    private Funcionario fulano;

    @Before
    public void inicializar() {
        this.service = new ReajusteService();
        this.fulano = new Funcionario("any_conta", "Fulano", LocalDate.now(), 2000.00, false);
    }

    @Test
    public void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar() {
        service.concederReajuste(fulano, Desempenho.A_DESEJAR);

        assertEquals(2060.00, fulano.getSalario(), 0.001);
    }

    @Test
    public void reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoForBom() {
        service.concederReajuste(fulano, Desempenho.BOM);

        assertEquals(2300.00, fulano.getSalario(), 0.001);
    }

    @Test
    public void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForOtimo() {
        service.concederReajuste(fulano, Desempenho.OTIMO);

        assertEquals(2400.00, fulano.getSalario(), 0.001);
    } 
    
    @Test
    public void reajustePorTempoDeServiçoIgualA5Anos() {
        this.fulano = new Funcionario("any_conta", "Fulano", LocalDate.of(2016, 8, 19), 2000.00, false);
        
        service.concederReajuste(fulano);
        assertEquals(2100.00, fulano.getSalario(), 0.001);
    }
    
    @Test
    public void reajustePorTempoDeServiçoAcimaDe5Anos() {
        this.fulano = new Funcionario("any_conta", "Fulano", LocalDate.of(2015, 8, 19), 2000.00, false);
        
        service.concederReajuste(fulano);
        assertEquals(2100.00, fulano.getSalario(), 0.001);
    }
    
    @Test
    public void reajustePorTempoDeServiçoAbaixoDe5Anos() {
        this.fulano = new Funcionario("any_conta", "Fulano", LocalDate.of(2017, 8, 19), 2000.00, false);
        
        service.concederReajuste(fulano);
        assertEquals(2000.00, fulano.getSalario(), 0.001);
    }
    
    @Test
    public void reajustePorTempoDeServiçoEntre5E10Anos() {
        this.fulano = new Funcionario("any_conta", "Fulano", LocalDate.of(2011, 8, 19), 2000.00, false);
        
        service.concederReajuste(fulano);
        assertEquals(2200.00, fulano.getSalario(), 0.001);
    }
    
    @Test
    public void reajustePorTempoDeServiçoEntre10E15Anos() {
        this.fulano = new Funcionario("any_conta", "Fulano", LocalDate.of(2011, 8, 19), 2000.00, false);
        
        service.concederReajuste(fulano);
        assertEquals(2200.00, fulano.getSalario(), 0.001);
    }
    
    @Test
    public void reajustePorTempoDeServiçoEntre15E20Anos() {
        this.fulano = new Funcionario("any_conta", "Fulano", LocalDate.of(2006, 8, 19), 2000.00, false);
        
        service.concederReajuste(fulano);
        assertEquals(2300.00, fulano.getSalario(), 0.001);
    }
    
    @Test
    public void reajustePorTempoDeServiçoEntreAcima20Anos() {
        this.fulano = new Funcionario("any_conta", "Fulano", LocalDate.of(2000, 8, 19), 2000.00, false);
        
        service.concederReajuste(fulano);
        assertEquals(2400.00, fulano.getSalario(), 0.001);
    }
}
