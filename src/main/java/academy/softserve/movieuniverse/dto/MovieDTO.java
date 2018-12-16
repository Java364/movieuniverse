package academy.softserve.movieuniverse.dto;

import academy.softserve.movieuniverse.dto.interfaces.MovieCreateDTO;
import academy.softserve.movieuniverse.dto.interfaces.MovieInfoDTO;

import java.util.ArrayList;
import java.util.List;

public class MovieDTO implements MovieInfoDTO, MovieCreateDTO {
    private String             movieName;
    private int                year;
    private String             description;
    private Long               duration;
    private MediaContentDTO    mediaContentDTO;
    private String             ageLimitation;
    private List<GenreDto>     genres      = new ArrayList<>();
    private List<CountryDTO>   countries   = new ArrayList<>();
    private List<Long>         roles       = new ArrayList<Long>();
    private List<Long>         userReviews = new ArrayList<>();
    private List<Long>         stars       = new ArrayList<Long>();
    private List<MovieMarkDTO> movieMarks  = new ArrayList<>();

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public MediaContentDTO getMediaContentDTO() {
        return mediaContentDTO;
    }

    public void setMediaContentDTO(MediaContentDTO mediaContentDTO) {
        this.mediaContentDTO = mediaContentDTO;
    }

    public String getAgeLimitation() {
        return ageLimitation;
    }

    public void setAgeLimitation(String ageLimitation) {
        this.ageLimitation = ageLimitation;
    }

    public List<GenreDto> getGenres() {
        return genres;
    }

    public void setGenres(List<GenreDto> genres) {
        this.genres = genres;
    }

    public List<CountryDTO> getCountries() {
        return countries;
    }

    public void setCountries(List<CountryDTO> countries) {
        this.countries = countries;
    }

    public List<Long> getRoles() {
        return roles;
    }

    public void setRoles(List<Long> roles) {
        this.roles = roles;
    }

    public List<Long> getStars() {
        return stars;
    }

    public void setStars(List<Long> stars) {
        this.stars = stars;
    }

    public List<Long> getUserReviews() {
        return userReviews;
    }

    public void setUserReviews(List<Long> userReviews) {
        this.userReviews = userReviews;
    }

    public List<MovieMarkDTO> getMovieMarks() {
        return movieMarks;
    }

    public void setMovieMarks(List<MovieMarkDTO> movieMarks) {
        this.movieMarks = movieMarks;
    }


}
