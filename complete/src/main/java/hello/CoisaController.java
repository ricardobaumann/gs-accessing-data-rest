package hello;

import javax.inject.Inject;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coisa")
public class CoisaController extends CrudController<Teste>{

	@Inject
	private TesteRepository testeRepository;
	
	@Override
	public PagingAndSortingRepository<Teste, Long> getRepository() {
		return testeRepository;
	}

	
	
//	
	
}
