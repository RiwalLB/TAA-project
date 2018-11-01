package TAA.Movie;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "Movie", path = "Movie")
public interface MovieRepository extends CrudRepository<Movie, Long>{

	List<Movie> findByTitle(String title);
}
