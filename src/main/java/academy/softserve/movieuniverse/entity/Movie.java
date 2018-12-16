package academy.softserve.movieuniverse.entity;

import academy.softserve.movieuniverse.dto.CountryDTO;
import academy.softserve.movieuniverse.dto.GenreDto;
import academy.softserve.movieuniverse.dto.MovieMarkDTO;
import academy.softserve.movieuniverse.dto.UserReviewDto;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie extends AbstractEntity {

    @Column(name = "movie_name")
    private String movieName;

    private Long duration;
    @Column(columnDefinition = "SMALLINT")
    private int year;

    private String description;
    @Column(name = "age_limitation")
    private String ageLimitation;

    @Embedded
    private MediaContent mediaContent;

    @ManyToMany
    @JoinTable(name = "movies_genres", joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "movies_countries", joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id"))
    private List<Country> countries = new ArrayList<>();

    @OneToMany(mappedBy = "movie")
    private List<StarActivityInMovies> roles = new ArrayList<StarActivityInMovies>();

    @ManyToMany
    @JoinTable(name = "star_movie",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "star_id"))
    private List<Long> starsId = new ArrayList<>();

    @OneToMany(mappedBy = "reviewedMovie", cascade = CascadeType.ALL)
    private List<UserReview> userReviews = new ArrayList<>();

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<MovieMark> movieMarks = new ArrayList<>();

    public Movie() {
    }

    public List<MovieMark> getMovieMarks() {
        return movieMarks;
    }

    public void setMovieMarks(List<MovieMark> movieMarks) {
        this.movieMarks = movieMarks;
    }

    public List<StarActivityInMovies> getRoles() {
        return roles;
    }

    public void setRoles(List<StarActivityInMovies> roles) {
        this.roles = roles;
    }

    public List<Long> getStars() {
        return starsId;
    }

    public void setStars(List<Long> starsId) {
        this.starsId = starsId;
    }

    public List<Genre> getGenres() {
        return genres ;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
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

    public String getAgeLimitation() {
        return ageLimitation;
    }

    public void setAgeLimitation(String ageLimitation) {
        this.ageLimitation = ageLimitation;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public MediaContent getMediaContent() {
        return mediaContent;
    }

    public void setMediaContent(MediaContent mediaContent) {
        this.mediaContent = mediaContent;
    }

    public List<UserReview> getUserReviews() {
        return userReviews;
    }

    public Movie setUserReviews(List<UserReview> userReviews) {
        this.userReviews = userReviews;
        return this;
    }
}
