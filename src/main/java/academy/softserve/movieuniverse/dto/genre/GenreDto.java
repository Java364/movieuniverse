package academy.softserve.movieuniverse.dto.genre;

public class GenreDto implements  GenreEditorDto, GenreViewDto {
    private Long id;
    private String genreName;

    @Override
    public long getId() {
        return id;
    }

    @Override
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
