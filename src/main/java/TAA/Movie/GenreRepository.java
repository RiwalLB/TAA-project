package TAA.Movie;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "Genre", path = "Genre")
public interface GenreRepository extends CrudRepository<Genre, Long>{

	List<Genre> findByGenreName(String genre);
	
}
