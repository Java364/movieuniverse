package academy.softserve.movieuniverse.entity;

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
    private Integer year;

    private String description;
    @Column(name = "age_limitation")
    private String ageLimitation;

    @Embedded
    private MediaContent mediaContent;

    @ManyToMany
    @JoinTable(name = "movies_genres", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres = new ArrayList<>();

    @ManyToMany
    private List<Country> countries = new ArrayList<>();

    @OneToMany(mappedBy = "movie")
    private List<StarActivityInMovies> roles = new ArrayList<StarActivityInMovies>();

    @ManyToMany
    @JoinTable(name = "star_movie", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "star_id"))
    private List<Star> stars = new ArrayList<>();

    @OneToMany(mappedBy = "commentedMovie", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

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

    public List<Star> getStars() {
        return stars;
    }

    public void setStars(List<Star> stars) {
        this.stars = stars;
    }

    public List<Genre> getGenres() {
        return genres;
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

    public Integer getYear() {
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

    public List<Comment> getComments() {
        return comments;
    }

    public Movie setComments(List<Comment> comments) {
        this.comments = comments;
        return this;
    }
}
