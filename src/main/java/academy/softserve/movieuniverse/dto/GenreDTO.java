package academy.softserve.movieuniverse.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

@Relation(value = "genre", collectionRelation = "genres")
@JsonIgnoreProperties(ignoreUnknown = true)
public class GenreDTO extends ResourceSupport implements GenreRequest {
    private Long genreId;
    private String genreName;

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }


    @Override
    public String getGenreName() {
        return genreName;
    }


    @Override
    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
