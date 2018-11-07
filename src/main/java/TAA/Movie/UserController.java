package TAA.Movie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRep;
	@Autowired
	private MovieRepository movieRep;
	
	/**
	 * get all users from dataBase
	 * @return all users in the dataBase
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/allUsers", produces = "application/JSON")
	public List<TAA.Movie.User> getAllUsers(){
		return (List<User>) userRep.findAll();
	}
	
	/**
	 * get one user from dataBase, if the user doesn't exist returns null
	 * @param name
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/user",  produces = "application/JSON")
	public TAA.Movie.User getUser(@RequestParam(value = "name") String name) {
		List<User> users = userRep.findByUsername(name);
		if(users.isEmpty()) {
			//User user = userRep.save(new TAA.Movie.User(name));
			return null;
		}
		return users.get(0);
	}
	
	/**
	 * add a user to the database, if the user already exists, returns that user
	 * @param name
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/addUser", produces = "application/JSON")
	public TAA.Movie.User addUser(@RequestParam(value = "name") String name){
		
		User existing = getUser(name);
		if(existing != null) {
			return existing;
		}
		User newUser = userRep.save((new TAA.Movie.User(name)));
		return newUser;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "userAddMovie", produces = "application/JSON")
	public TAA.Movie.User userAddMovie(@RequestParam(value = "name") String name, @RequestParam(value="title") String title){
		User existing = getUser(name);
		if(existing == null) {
			return null;
		}
		List<Movie> movies = movieRep.findByTitle(title);
		if(movies.isEmpty()) {
			return null;
		}
		
		existing.addMovie(movies.get(0));
		userRep.save(existing);
		
		return existing;
		
	}
	
	
	
}
