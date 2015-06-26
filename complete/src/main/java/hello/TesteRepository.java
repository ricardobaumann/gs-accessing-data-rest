package hello;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TesteRepository extends PagingAndSortingRepository<Teste, Long> {

}
