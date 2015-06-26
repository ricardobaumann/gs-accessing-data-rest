package hello;

import org.junit.After;
import org.junit.Before;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.client.RestTemplate;

public class AbstractControllerTest {

	private RestTemplate restTemplate = new RestTemplate();
	private ConfigurableApplicationContext r;
	private static final String BASE_URL = "http://localhost:8080/";
	
	@Before
	public void setup() {
		r = SpringApplication.run(Application.class);
		
	}
	
	@After
	public void tearDown() {
		r.close();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> T getForObject(String path,Class clazz,Object...values) {
		return (T) restTemplate.getForObject(getEntityURL(path), clazz, values);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <T> T post(String path,T request, Class responseType,Object...values) {
		return (T) restTemplate.postForEntity(getEntityURL(path), request, responseType, values);
	}
	  
	public void put(String path,Object request, Object...values) {
		restTemplate.put(getEntityURL(path), request,values);    
	}
	
	public void delete(String path,Object id) {
		restTemplate.delete(getEntityURL(path),id);
	}

	protected String getEntityURL(String path) {
		return BASE_URL.concat(path);
	}
	
}
