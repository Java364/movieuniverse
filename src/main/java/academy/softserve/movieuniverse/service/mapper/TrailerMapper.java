package academy.softserve.movieuniverse.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.softserve.movieuniverse.dto.TrailerDTO;
import academy.softserve.movieuniverse.entity.Trailer;
import academy.softserve.movieuniverse.service.MovieService;
import academy.softserve.movieuniverse.service.TrailerService;
@Service
public class TrailerMapper {
	
	@Autowired
	MovieService movieService;
	@Autowired
	TrailerService trailerService;
	
	public Trailer mapToEntityForSave(TrailerDTO dto) {
		Trailer trailer = new Trailer();
		trailer.setTrailerUrl(dto.getTrailerUrl());
		trailer.setId(null);
		trailer.setIsRemoved(new Boolean(false));
		trailer.setMovie(movieService.findMovieById(dto.getMovieId()).get());
		return trailer;
	}
	
	public Trailer mapToEntityForUpdate(TrailerDTO dto, Long trailerId) {
		Trailer trailer = new Trailer();
		trailer.setId(trailerId);
		trailer.setMovie(movieService.findMovieById(dto.getMovieId()).get());
		trailer.setTrailerUrl(dto.getTrailerUrl());
		trailer.setIsRemoved(new Boolean(false));
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
	
	public TrailerDTO dtoForSave(TrailerDTO dto) {
		dto.setId(null);
		return dto;
	}

}
