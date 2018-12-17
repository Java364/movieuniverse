package academy.softserve.movieuniverse.dto;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

@Relation(value = "genre", collectionRelation = "genres")
public class GenreDto extends ResourceSupport implements GenreCreateUpdateRequest {
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
