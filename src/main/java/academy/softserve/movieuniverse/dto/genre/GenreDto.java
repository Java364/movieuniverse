package academy.softserve.movieuniverse.dto.genre;

import org.springframework.hateoas.core.Relation;

@Relation(value = "genre", collectionRelation = "genres")
public class GenreDto {
    private String genreName;

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
