package academy.softserve.movieuniverse.service.mapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import academy.softserve.movieuniverse.dto.PosterDTO;
import academy.softserve.movieuniverse.entity.Poster;
import academy.softserve.movieuniverse.service.MovieService;
@Component
public class PosterMapper {
    @Autowired
    MovieService movieService;

    public Poster mapToEntityForSave(PosterDTO dto) {
        Poster poster = new Poster();
        poster.setImageUrl(dto.getImageUrl());
        poster.setId(null);
        poster.setIsRemoved(new Boolean(false));
        poster.setName(dto.getName());
        poster.setMovie(movieService.findMovieById(dto.getMovieId()));
        return poster;
    }

    public Poster mapToEntityForUpdate(PosterDTO dto, Long posterId) {
        Poster poster = new Poster();
        poster.setImageUrl(dto.getImageUrl());
        poster.setIsRemoved(new Boolean(false));
        poster.setId(posterId);
        poster.setName(dto.getName());
        poster.setMovie(movieService.findMovieById(dto.getMovieId()));
        return poster;
    }

    public Poster mapToEntity(PosterDTO dto) {

        Poster poster = new Poster();
        poster.setName(dto.getName());
        poster.setId(dto.getId());
        poster.setName(dto.getName());
        poster.setImageUrl(dto.getImageUrl());
        poster.setMovie(movieService.findMovieById(dto.getMovieId()));
        return poster;
    }

    public PosterDTO mapToDto(Poster entity) {
        PosterDTO dto = new PosterDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setImageUrl(entity.getImageUrl());
        dto.setMovieId(entity.getMovie().getId());
        return dto;
    }


}
