package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.dto.CountryDTO;
import academy.softserve.movieuniverse.dto.GenreDto;
import academy.softserve.movieuniverse.entity.Country;
import academy.softserve.movieuniverse.entity.Genre;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenreDtoMapper{

    private ModelMapper modelMapper;

    @Autowired
    public GenreDtoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Genre mapToEntity(GenreDto genreDto) {
        return modelMapper.map(genreDto, Genre.class);
    }

    public GenreDto mapToDto(Genre entity) {
        GenreDto genreDto = new GenreDto();
        genreDto.setId(entity.getId());
        genreDto.setGenreName(entity.getName());
        return genreDto;

    }

    public List<GenreDto> mapListToDto(List<Genre> genres) {
        List<GenreDto> genreDTOs = new ArrayList<>();
        for (Genre g : genres) {
            genreDTOs.add(this.mapToDto(g));
        }

        return genreDTOs;
    }

    public List<Genre> mapGenresListToEntity(List<GenreDto> genreDTOs) {
        List<Genre> genres = new ArrayList<>();
        for (GenreDto g : genreDTOs) {
            genres.add(this.mapToEntity(g));
        }
        return genres;
    }
}
