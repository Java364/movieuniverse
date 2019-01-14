package academy.softserve.movieuniverse.dto.movie;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = MovieDTO.class)
public interface MovieFullInfo {

	public String getTrailers();

	public void setTrailers(String trailers);

	public String getGenres();

	public void setGenres(String genres);

	public Long getId();

	public void setId(Long id);

	public String getMovieName();

	public void setMovieName(String movieName);

	public int getYear();

	public void setYear(int year);

	public String getDescription();

	public void setDescription(String description);

	public Long getDuration();

	public void setDuration(Long duration);

	public String getAgeLimitation();

	public void setAgeLimitation(String ageLimitation);

	public String getPoster();

	public void setPoster(String poster);

	public String getSelf();

	public void setSelf(String self);

	public String getGallery();

	public void setGallery(String gallery);

	public String getStars();

	public void setStars(String stars);

	public String getRoles();

	public void setRoles(String roles);

	public String getCountries();

	public void setCountries(String countries);

	public String getComments();

	public void setComments(String comments);

	public String getMovieMark();

	public void setMovieMark(String movieMark);
}