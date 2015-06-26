/**
 * 
 */
package hello;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import javax.inject.Inject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.hateoas.MediaTypes;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @author ricardo
 *
 */
public class PersonRepositoryTest extends AbstractRestControllerTest{

	@Inject
	private PersonRepository personRepositoryMock;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		Mockito.reset(personRepositoryMock);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link hello.PersonRepository#findByLastName(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testFindByLastName() throws Exception {
		
	}

	/**
	 * Test method for {@link org.springframework.data.repository.PagingAndSortingRepository#findAll(org.springframework.data.domain.Sort)}.
	 */
	@Test
	public void testFindAllSort() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.springframework.data.repository.PagingAndSortingRepository#findAll(org.springframework.data.domain.Pageable)}.
	 */
	@Test
	public void testFindAllPageable() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.springframework.data.repository.CrudRepository#save(S)}.
	 */
	@Test
	public void testSaveS() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.springframework.data.repository.CrudRepository#save(java.lang.Iterable)}.
	 */
	@Test
	public void testSaveIterableOfS() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.springframework.data.repository.CrudRepository#findOne(java.io.Serializable)}.
	 * @throws Exception 
	 */
	@Test
	public void testFindOneSucess() throws Exception {
		Person person = new Person();
		person.setFirstName("first");
		person.setLastName("last");
		
		ArrayList<Long> ids = new ArrayList<Long>();
		ids.add(1L);
		
		Mockito.when(personRepositoryMock.exists(1L)).thenReturn(true);
		Mockito.when(personRepositoryMock.findAll(ids)).thenReturn(new ArrayList<Person>());
		Mockito.when(personRepositoryMock.findOne(1L)).thenReturn(person);
		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/people/1").accept(MediaTypes.HAL_JSON))
		//.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().contentType(MediaTypes.HAL_JSON))
		.andReturn();
		
		System.out.println("resultado: "+result.getResponse().getContentAsString());  
		
		Assert.assertNotNull(result.getResponse().getContentAsString());
		
		//Mockito.verify(personRepositoryMock).findOne(1L);
	}

	

	/**
	 * Test method for {@link org.springframework.data.repository.CrudRepository#findAll()}.
	 * @throws Exception 
	 */
	@Test
	public void testFindAll() throws Exception {  
		ArrayList<Person> list = new ArrayList<Person>();
		Mockito.when(personRepositoryMock.findAll()).thenReturn(list);
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/people")).andExpect(MockMvcResultMatchers.status().isOk()).
		andExpect(MockMvcResultMatchers.content().contentType(MediaTypes.HAL_JSON))
		.andReturn();
		
		System.out.println("resultado: "+result.getResponse().getContentAsString());  
		
		Assert.assertNotNull(result.getResponse().getContentAsString());
		
		Mockito.verify(personRepositoryMock).findAll();
	}

	
	/**
	 * Test method for {@link org.springframework.data.repository.CrudRepository#delete(java.io.Serializable)}.
	 * @throws Exception 
	 */
	@Test
	public void testDeleteID() throws Exception {
		
		Mockito.when(personRepositoryMock.exists(1L)).thenReturn(true);
		Mockito.doNothing().when(personRepositoryMock).delete(1L);
		
		mockMvc.perform(MockMvcRequestBuilders.delete("/people/1").accept(MediaTypes.HAL_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
	}

	
	/**
	 * Test method for {@link org.springframework.data.repository.CrudRepository#delete(java.lang.Iterable)}.
	 */
	@Test
	public void testDeleteIterableOfQextendsT() {
		fail("Not yet implemented");
	}

	

}
