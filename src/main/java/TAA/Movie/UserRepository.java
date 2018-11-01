package TAA.Movie;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "User", path = "User")
public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findByUsername(String username);	
	
	
}
