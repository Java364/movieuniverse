package academy.softserve.movieuniverse.mapper;

import academy.softserve.movieuniverse.dto.genre.GenreDTO;
import academy.softserve.movieuniverse.dto.genre.GenreRequest;
import academy.softserve.movieuniverse.entity.Genre;
import org.springframework.stereotype.Component;

@Component
public class GenreMapper implements DTOMapper<GenreDTO, GenreRequest, Genre> {
    @Override
    public GenreDTO mapToDTO(Genre genre) {
        GenreDTO genreDTO = new GenreDTO();
        genreDTO.setId(genre.getId());
        genreDTO.setGenreName(genre.getName());
        return genreDTO;
    }

    @Override
    public Genre mapToEntity(GenreRequest dto) {
        Genre genre = new Genre();
        genre.setName(dto.getGenreName());
        return genre;
    }

    public static Genre mapToEntity(GenreDTO genreDTO) {
        Genre genre = new Genre();
        genre.setId(genreDTO.getId());
        genre.setName(genreDTO.getGenreName());
        return genre;

    }
}