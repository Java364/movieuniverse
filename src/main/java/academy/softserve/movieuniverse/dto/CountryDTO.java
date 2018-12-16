package academy.softserve.movieuniverse.dto;

import java.util.ArrayList;
import java.util.List;

public class CountryDTO {
	private Long id;
	private String name;
	private List<Long> starIds = new ArrayList<>();
	private List<Long> movieIds = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Long> getStarIds() {
		return starIds;
	}

	public void setStarIds(List<Long> starIds) {
		this.starIds = starIds;
	}

	public List<Long> getMovieIds() {
		return movieIds;
	}

	public void setMovieIds(List<Long> movieIds) {
		this.movieIds = movieIds;
	}

}
