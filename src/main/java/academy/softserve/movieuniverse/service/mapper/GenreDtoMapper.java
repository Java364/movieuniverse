package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.dto.genre.GenreDto;
import academy.softserve.movieuniverse.dto.genre.GenreEditorDto;
import academy.softserve.movieuniverse.dto.genre.GenreViewDto;
import academy.softserve.movieuniverse.entity.Genre;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GenreDtoMapper {

    private ModelMapper modelMapper;

    @Autowired
    public GenreDtoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public GenreDto mapGenreEntityToEditDto(Genre genre) {
        GenreDto editorDto = new GenreDto();
        editorDto.setId(genre.getId());
        editorDto.setGenreName(genre.getName());
        return editorDto;
    }

    public GenreDto mapGenreEntityToGenreViewDto(Genre entity) {
        GenreDto genreViewDto = new GenreDto();
        genreViewDto.setGenreName(entity.getName());
        return genreViewDto;
    }

    public Genre mapGenreEditorDtoToGenreEntity(GenreDto genreDto) {
        Genre genre = new Genre();
//        genre.setId(genre);
        return genre;
    }

}
