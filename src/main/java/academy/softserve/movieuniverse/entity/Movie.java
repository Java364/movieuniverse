package academy.softserve.movieuniverse.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private Set<Genre> genres = new HashSet<>();

    @ManyToMany
    private Set<Country> countries = new HashSet<>();

    @OneToMany(mappedBy = "movie")
    private List<Crew> roles = new ArrayList<Crew>();

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cast> cast = new ArrayList<>();

    @OneToMany(mappedBy = "commentedMovie", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<MovieMark> movieMarks = new ArrayList<>();

    @OneToOne(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Poster poster;

    public Movie() {
    }

    public Poster getPoster() {
        return poster;
    }

    public void setPoster(Poster poster) {
        this.poster = poster;
    }

    public List<MovieMark> getMovieMarks() {
        return movieMarks;
    }

    public List<Crew> getRoles() {
        return roles;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public void setRoles(List<Crew> roles) {
        this.roles = roles;
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

    public Set<Country> getCountries() {
        return countries;
    }

    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }

    public void setAgeLimitation(String ageLimitation) {
        this.ageLimitation = ageLimitation;
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

    public List<Cast> getCast() {
        return cast;
    }

    public void addStarToCast(Cast cast) {
        this.cast.add(cast);
        cast.setMovie(this);
    }

}
