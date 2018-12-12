package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.dto.TrailerDTO;
import academy.softserve.movieuniverse.entity.Trailer;

import java.util.ArrayList;
import java.util.List;

public class TrailerMapper implements ReversibleDtoMapper<Trailer, TrailerDTO> {
	/*@Autowired
	MovieService movieService;*/
	
	@Override
	public Trailer mapToEntity(TrailerDTO dto) {
		Trailer trailer = new Trailer();
		trailer.setTrailerUrl(dto.getTrailerUrl());
		trailer.setId(dto.getId());
		trailer.setIsRemoved(false);
		//trailer.setMovie(movieService.getMovie(dto.getMovieId()));
		return trailer;
	}

	@Override
	public TrailerDTO mapToDto(Trailer entity) {
		TrailerDTO trailerDTO = new TrailerDTO();
		trailerDTO.setId(entity.getId());
		trailerDTO.setTrailerUrl(entity.getTrailerUrl());
		trailerDTO.setMovieId(entity.getMovie().getId());
		return trailerDTO;
	}
	
	public List<TrailerDTO> mapListToDto(List<Trailer> trailers) {
		List<TrailerDTO> trailerDTOs = new ArrayList<>();
		for(Trailer t: trailers) {
			trailerDTOs.add(this.mapToDto(t));
		}
		return trailerDTOs;
	}

}
