package TAA.Movie;


import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue
	private long idUser;

	@Column(name="username", length=50, nullable=false)
	private String username;
	

	private ArrayList<Movie> movieList = new ArrayList<Movie>();
	
	public User() {
		
	}
	
	public User(String username) {
		this.username = username;
	}

	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ArrayList<Movie> getMovieList() {
		return movieList;
	}
	
	public void addMovie(Movie movie) {
		movieList.add(movie);
	}
	
	public void removeMovie(Movie movie) {
		movieList.remove(movie);
	}
		


}
