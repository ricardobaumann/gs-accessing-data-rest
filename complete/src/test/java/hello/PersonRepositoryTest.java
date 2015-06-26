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
import org.springframework.test.web.servlet.ResultActions;
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
		ArrayList<Person> list = new ArrayList<Person>();
		Mockito.when(personRepositoryMock.findAll()).thenReturn(list);
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/people")).andExpect(MockMvcResultMatchers.status().isOk()).
		andExpect(MockMvcResultMatchers.content().contentType(MediaTypes.HAL_JSON))
		.andReturn();
		
		Assert.assertNotNull(result.getResponse().getContentAsString());
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
	 */
	@Test
	public void testFindOne() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.springframework.data.repository.CrudRepository#exists(java.io.Serializable)}.
	 */
	@Test
	public void testExists() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.springframework.data.repository.CrudRepository#findAll()}.
	 */
	@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.springframework.data.repository.CrudRepository#findAll(java.lang.Iterable)}.
	 */
	@Test
	public void testFindAllIterableOfID() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.springframework.data.repository.CrudRepository#count()}.
	 */
	@Test
	public void testCount() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.springframework.data.repository.CrudRepository#delete(java.io.Serializable)}.
	 */
	@Test
	public void testDeleteID() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.springframework.data.repository.CrudRepository#delete(java.lang.Object)}.
	 */
	@Test
	public void testDeleteT() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.springframework.data.repository.CrudRepository#delete(java.lang.Iterable)}.
	 */
	@Test
	public void testDeleteIterableOfQextendsT() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.springframework.data.repository.CrudRepository#deleteAll()}.
	 */
	@Test
	public void testDeleteAll() {
		fail("Not yet implemented");
	}

}
