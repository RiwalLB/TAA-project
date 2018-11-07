package TAA.Movie;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenreController {

	@Autowired
	private GenreRepository genreRep;
	
	@RequestMapping(method = RequestMethod.GET, value = "/allGenres", produces = "application/JSON")
	public List<Genre> getAllGenres(){
		return (List<Genre>) genreRep.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/genre", produces = "application/JSON")
	public TAA.Movie.Genre getGenre(@RequestParam(value = "genre") String genreName){
		List<Genre> genres = genreRep.findByGenreName(genreName);
		if(genres.isEmpty()) {
			return null;
		}
		return genres.get(0);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/addGenre", produces = "application/JSON")
	public TAA.Movie.Genre addGenre(@RequestParam(value = "genre") String genre ){
		
		Genre existing = getGenre(genre);
		if(existing != null) {
			return existing;
		}
		Genre newGenre = genreRep.save(new TAA.Movie.Genre(genre));
		return newGenre;
	}
	
}
