package hello;

import org.junit.Assert;
import org.junit.Test;

public class TesteControllerTest extends AbstractControllerTest{

	
	
	@Test
	public void test() throws Exception {
		Teste teste = getForObject("coisa",Teste.class);
		Assert.assertNotNull(teste);
		Assert.assertEquals(teste.getName(), "nome");
		
	}
	
}
