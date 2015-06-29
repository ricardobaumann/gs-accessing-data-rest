package hello;

import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.client.RestTemplate;

public class AbstractRestControllerTest {
	
	private RestTemplate restTemplate = new RestTemplate();
	private static ConfigurableApplicationContext r;
	private static String BASE_URL;
	
	static {
		Random foo = new Random();
		int max = 9999;
		int min = 8080;
        int randomNumber = foo.nextInt(max - min) + min;
        if(randomNumber == min) {
        	System.setProperty("server.port", String.valueOf(min+1));
        }
        else {
        	System.setProperty("server.port", String.valueOf(randomNumber));  
        }
	}
	
	@BeforeClass
	public static void beforeClass() {
		
		
		BASE_URL = "http://localhost:"+System.getProperty("server.port")+"/";
	}
	
	@AfterClass
	public static void afterClass() {
		
	}
	
	@Before
	public void before() {
		r = SpringApplication.run(Application.class);
	}
	
	@After  
	public void after() {
		r.close();  
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> T getForObject(String path,Class clazz,Object...values) {
		return (T) restTemplate.getForObject(getEntityURL(path), clazz, values);
	}
	
	
	public <T> T post(String path,T request, Class<T> responseType,Object...values) {
		return restTemplate.postForEntity(getEntityURL(path), request, responseType, values).getBody();
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
