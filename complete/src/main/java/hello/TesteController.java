package hello;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testes")
public class TesteController {

	@Inject
	private TesteRepository testeRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public Iterable<Teste> get() {
		
		return testeRepository.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Teste post(@RequestBody Teste entity) {
		return testeRepository.save(entity);
	}
	
	
}
