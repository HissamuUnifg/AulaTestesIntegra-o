
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
        this.fulano = new Funcionario("Fulano", LocalDate.now(), 2000.00);
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
        this.fulano = new Funcionario("Fulano", LocalDate.of(2016, 8, 19), 2000.00);
        
        service.concederReajuste(fulano);
        assertEquals(2100.00, fulano.getSalario(), 0.001);
    }
}
