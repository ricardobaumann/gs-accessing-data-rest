package hello;

import org.junit.Assert;
import org.junit.Test;

public class TesteControllerTest extends AbstractRestControllerTest{

	
	
	@Test
	public void testEmpty() throws Exception {
		TestPage<Teste> teste = getForObject("coisa",TestPage.class);
		Assert.assertNotNull(teste);
		System.out.println(teste);
		
		Assert.assertEquals(teste.getNumberOfElements().intValue(), 0);
		
	}
	
	
	
}
