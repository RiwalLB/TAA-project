package TAA.Movie;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

	@Autowired
	private MovieRepository movieRep;
	
	@RequestMapping(method = RequestMethod.GET, value = "/movies", produces = "application/JSON")
	public TAA.Movie.Movie getMovie(@RequestParam(value = "title") String title){
		List<Movie> movies = movieRep.findByTitle(title);
		if(movies.isEmpty()) {
			
			//Movie movie = movieRep.save(new TAA.Movie.Movie(title, new ArrayList<Genre>()));
			// TODO : try to add movie with imdb api?
			
			return null;
		}
		return movies.get(0);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/addMovie", produces = "application/JSON")
	public TAA.Movie.Movie addMovie(@RequestParam(value = "title") String title ){
		
		Movie existing = getMovie(title);
		if(existing != null) {
			return existing;
		}
		Movie newMovie = movieRep.save(new TAA.Movie.Movie(title, new ArrayList<Genre>()));
		return newMovie;
	}
	
	
	
	
}
