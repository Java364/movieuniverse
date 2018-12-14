package academy.softserve.movieuniverse.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.softserve.movieuniverse.dto.TrailerDTO;
import academy.softserve.movieuniverse.entity.Trailer;
import academy.softserve.movieuniverse.service.MovieService;
@Service
public class TrailerMapper {
	
	@Autowired
	MovieService movieService;
	
	public Trailer mapToEntity(TrailerDTO dto) {
		Trailer trailer = new Trailer();
		trailer.setTrailerUrl(dto.getTrailerUrl());
		trailer.setId(dto.getId());
		trailer.setIsRemoved(new Boolean(false));
		trailer.setMovie(null);
		return trailer;
	}
	
	public Trailer mapToEntityForUpdate(TrailerDTO dto) {
		Trailer trailer = new Trailer();
		trailer.setTrailerUrl(dto.getTrailerUrl());
		trailer.setIsRemoved(new Boolean(false));
		trailer.setMovie(null);
		return trailer;
	}

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
