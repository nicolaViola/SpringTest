package transactionalTest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import it.configuration.AutomaticReportConf;
import it.model.Elemento;
import it.servicies.JpaService;
import it.servicies.impl.ElementoService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AutomaticReportConf.class)
public class AutomaticReportTest {

	
	@Autowired
	private JpaService elementoService;
	
	@Test
	public void testElemento() {
		
		elementoService.saveElemento(new Elemento(1L, "nicola"));
		elementoService.saveElemento(new Elemento(2L, "franco"));
		
		for(Elemento element : elementoService.findElementoByNomeLike("%ic%")){
			System.out.println(element.getNome());
		}
		
		System.out.println(elementoService.getAllElemento().size());
		
	}

}
