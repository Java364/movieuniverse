package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.dto.genre.GenreDTO;
import academy.softserve.movieuniverse.dto.genre.GenreRequest;
import academy.softserve.movieuniverse.entity.Genre;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GenreMapper implements DTOMapper<GenreDTO, GenreRequest,  Genre> {
    private ModelMapper modelMapper;

    @Autowired
    public GenreMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public GenreDTO mapToDTO(Genre genre) {
        return modelMapper.map(genre, GenreDTO.class);
    }

    @Override
    public Genre mapToEntity(GenreRequest dto) {
        return modelMapper.map(dto, Genre.class);
    }

    public static Genre mapToEntitySelectedGenre(GenreDTO genreDTO) {
        Genre genre = new Genre();
        genre.setId(genreDTO.getId());
        genre.setName(genreDTO.getGenreName());
        return genre;
    }
}
