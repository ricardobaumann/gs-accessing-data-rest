package hello;

import org.junit.Assert;
import org.junit.Test;

public class TesteControllerTest extends AbstractRestControllerTest{



	private Teste testeCreated;

	@Test
	public void testEmpty() throws Exception {
		TestPage<Teste> teste = get("coisa",TestPage.class);
		Assert.assertNotNull(teste);
		
		Assert.assertEquals(teste.getNumberOfElements().intValue(), 0);
		
	}
	
	public Teste create() {
		Teste teste = new Teste("test");
		testeCreated = post("coisa", teste, Teste.class);
		Assert.assertEquals(teste.getName(), testeCreated.getName());
		Assert.assertNotNull(testeCreated.getId());  
		Assert.assertEquals(testeCreated.getName(), teste.getName());
		return testeCreated;
	}
	
	@Test
	public void testListSomething() {
		
		create();
		
		TestPage<Teste> page = get("coisa",TestPage.class);
		
		Assert.assertEquals(page.getTotalElements().intValue(), 1);
	}
	
	@Test
	public void postAndPut() {
		
		Teste created = create();
		put("coisa/{id}", new Teste("updated"), created.getId());
		Teste retrieved = get("coisa/{id}", Teste.class, created.getId());
		Assert.assertNotNull(retrieved);
		Assert.assertEquals(created.getId(), retrieved.getId());
		Assert.assertEquals(retrieved.getName(),"updated");
	}
	
	@Test
	public void postAndDelete() throws Exception {
		testListSomething();
		delete("coisa/{id}", testeCreated.getId());
		testEmpty();  
	}
	
}
