package TAA.Movie;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Genre implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2915138969957868858L;

	@Id
	@GeneratedValue
	private long idGenre;
	
	@Column(name="genreName", length=50, nullable=false)
	private String genreName;
	
	public Genre(String genreName) {
		this.genreName = genreName;
	}

	public Genre() {
		
	}
	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public long getIdGenre() {
		return idGenre;
	}

	public void setIdGenre(long idGenre) {
		this.idGenre = idGenre;
	}
	
	
}
