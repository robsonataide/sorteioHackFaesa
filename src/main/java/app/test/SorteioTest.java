package app.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import app.business.AlunoBusiness;

/**
 * Classe utilitária de teste Sorteio
 * @generated
 **/
public class SorteioTest {
	 
	@Autowired
	@Qualifier("AlunoBusiness")
	private AlunoBusiness alunoBusiness;
	 
	 @Test
    public void testSorteio() {
      
      System.out.println(alunoBusiness.sorteio().getNome());
      
      //assertEquals("onetwo", result);
    }
}
