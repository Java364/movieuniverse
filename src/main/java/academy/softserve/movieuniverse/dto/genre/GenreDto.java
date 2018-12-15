package academy.softserve.movieuniverse.dto.genre;

public class GenreDto {
    private Long id;
    private String genreName;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
