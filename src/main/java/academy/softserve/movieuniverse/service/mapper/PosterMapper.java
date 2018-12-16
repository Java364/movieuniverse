package academy.softserve.movieuniverse.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import academy.softserve.movieuniverse.dto.PosterDTO;
import academy.softserve.movieuniverse.entity.Poster;
import academy.softserve.movieuniverse.service.MovieService;

public class PosterMapper {
	@Autowired
	MovieService movieService;

	public Poster mapToEntityForSave(PosterDTO dto) {
		Poster poster = new Poster();
		poster.setImageUrl(dto.getImageUrl());
		poster.setId(null);
		poster.setIsRemoved(new Boolean(false));
		poster.setMovie(movieService.findMovieById(dto.getMovieId()));
		return poster;
	}

	public  Poster mapToEntityForUpdate(PosterDTO dto, Long posterId) {
		Poster poster = new Poster();
		poster.setImageUrl(dto.getImageUrl());
		poster.setIsRemoved(new Boolean(false));
		poster.setId(posterId);
		poster.setMovie(movieService.findMovieById(dto.getMovieId()));
		return poster;
	}

	public Poster mapToEntity(PosterDTO posterDTO) {

		Poster poster = new Poster();
		poster.setId(posterDTO.getId());
		poster.setName(posterDTO.getName());
		poster.setImageUrl(posterDTO.getImageUrl());
		poster.setMovie(movieService.findMovieById(posterDTO.getMovieId()));
		return poster;
	}

	public PosterDTO mapToDto(Poster entity) {
		PosterDTO posterDTO = new PosterDTO();
		posterDTO.setId(entity.getId());
		posterDTO.setName(entity.getName());
		posterDTO.setImageUrl(entity.getImageUrl());
		posterDTO.setMovieId(entity.getMovie().getId());
		return posterDTO;
	}

}
