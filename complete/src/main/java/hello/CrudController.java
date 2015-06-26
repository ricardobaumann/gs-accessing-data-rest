package hello;

import java.lang.reflect.InvocationTargetException;

import javax.websocket.server.PathParam;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public abstract class CrudController<T> {

	@RequestMapping(method=RequestMethod.GET)
	public Page<T> findAll(@RequestParam(value="sort",defaultValue="id") String sort, @RequestParam(value="page",defaultValue="1") Integer page,
			@RequestParam(value="size",defaultValue="50") Integer size,@RequestParam(value="sort_direction",defaultValue="DESC") Direction sortDirection) {
		
		PageRequest pageRequest = new PageRequest(page, size,new Sort(sortDirection, sort));
		return getRepository().findAll(pageRequest);
		
	}
	
	@RequestMapping(method=RequestMethod.GET,value="{id}")
	public T findByID(@PathVariable("id") Long id) {
		return getRepository().findOne(id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public T post(@RequestBody T entity) {
		return getRepository().save(entity);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="{id}")
	public T put(@RequestBody T entity,@PathVariable("id") Long id) throws Exception {
		entity.getClass().getMethod("setId", Long.class).invoke(entity, id);
		return getRepository().save(entity);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="{id}")
	public void delete(@PathVariable("id") Long id) {
		getRepository().delete(id);
	}
	
	public abstract PagingAndSortingRepository<T, Long> getRepository();
	
}
