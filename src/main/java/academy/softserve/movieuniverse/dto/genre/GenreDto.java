package academy.softserve.movieuniverse.dto.genre;

import org.springframework.hateoas.core.Relation;

@Relation(value = "genre", collectionRelation = "genres")
public class GenreDto implements GenreCreateDto {
    private String genreName;

    @Override
    public String getGenreName() {
        return genreName;
    }

    @Override
    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
