package hello;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoisaController {

	@Inject
	protected CoisaRepository testeRepository;
	
	@RequestMapping("/coisa")
	public @ResponseBody Teste getAllTestes() {
		
		return new Teste("nome"); 
	}
	
//	@RequestMapping(method=RequestMethod.POST)
//	public Teste post(@RequestBody Teste entity) {
//		return testeRepository.save(entity);
//	}
//	
	
}
