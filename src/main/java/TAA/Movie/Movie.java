package TAA.Movie;

import java.util.ArrayList;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Movie {

	@Id
	@GeneratedValue
	private long idMovie;
	
	@Column(name="title", length=50, nullable=false)
	private String title;
	
	private ArrayList<Genre> genreList;
	
	public Movie(String title, ArrayList<Genre> genreList) {
		this.title = title;
		if (genreList == null) {
			genreList = new ArrayList<Genre>();
		}
		else {
			this.genreList = genreList;
		}
	}
	
	public Movie() {
		
	}
	
	public long getIdMovie() {
		return idMovie;
	}

	public void setIdMovie(long idMovie) {
		this.idMovie = idMovie;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public ArrayList<Genre> getGenreList() {
		return genreList;
	}
	
	public void addGenre(Genre genre) {
		genreList.add(genre);
	}
	
	public void removeGenre(Genre genre) {
		genreList.remove(genre);
	}
	
	
}
