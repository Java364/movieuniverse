package academy.softserve.movieuniverse.dto.genre;

public class GenreDto implements GenreCreateDto {
    private Long id;
    private String genreName;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
