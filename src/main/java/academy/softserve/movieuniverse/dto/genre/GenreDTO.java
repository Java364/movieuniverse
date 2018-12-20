package academy.softserve.movieuniverse.dto.genre;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

@Relation(value = "genre", collectionRelation = "genres")
@JsonIgnoreProperties(ignoreUnknown = true)
public class GenreDTO extends ResourceSupport implements GenreRequest {
    private Long genreId;
    private String genreName;

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }
}
