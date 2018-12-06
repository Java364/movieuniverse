package academy.softserve.movieuniverse.movieuniverse.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Duration;
import java.time.Year;
import java.util.Objects;

@Entity
@Table(name="movies")
public class Movie extends AbstractEntity {

    @Column(name="movie_name")
    private String movieName;
    private Duration duration;
    @Column(columnDefinition = "SMALLINT")
    private Year year;
    private String description;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Movie() {
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieName='" + movieName + '\'' +
                ", duration=" + duration +
                ", year=" + year +
                ", description='" + description + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(movieName, movie.movieName) &&
                Objects.equals(duration, movie.duration) &&
                Objects.equals(year, movie.year) &&
                Objects.equals(description, movie.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieName, duration, year, description);
    }
}
