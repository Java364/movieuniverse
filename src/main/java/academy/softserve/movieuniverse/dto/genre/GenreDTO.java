package academy.softserve.movieuniverse.dto.genre;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

@Relation(value = "genre", collectionRelation = "genres")
@JsonIgnoreProperties(ignoreUnknown = true)
public class GenreDTO extends ResourceSupport {
    private String genreName;

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
