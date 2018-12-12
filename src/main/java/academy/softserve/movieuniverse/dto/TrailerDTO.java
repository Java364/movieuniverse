package academy.softserve.movieuniverse.dto;

public class TrailerDTO {
	
	private Long id;
	private String trailerUrl;
	
	public TrailerDTO() {}

	public String getTrailerUrl() {
		return trailerUrl;
	}

	public void setTrailerUrl(String trailerUrl) {
		this.trailerUrl = trailerUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
