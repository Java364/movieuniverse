package academy.softserve.movieuniverse.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import academy.softserve.movieuniverse.entity.Trailer;
import academy.softserve.movieuniverse.exception.TrailerException;
import academy.softserve.movieuniverse.repository.TrailerRepository;

@Service
public class TrailerService {
	
	@Autowired
	private TrailerRepository trailerRepository;
	
	public Trailer saveTrailer(Trailer trailer) {
		trailer = trailerRepository.save(trailer);
		if(trailer == null) throw TrailerException.createSaveException("couldn't save trailer", null);
		return trailer;
	}
	
	public Trailer updateTrailer(Long id, Trailer trailer) {
		Trailer newTrailer = this.findTrailerById(id);
		//trailer = trailerRepository.save(trailer);
		return trailer;
	}
	
	public Trailer findTrailerById(Long id) {
		Optional<Trailer> trailerOptional = trailerRepository.findById(id);
		if(!trailerOptional.isPresent()){
			throw TrailerException.createSelectException("no such trailer", new Exception());
		}
		Trailer trailer = trailerOptional.get();
		return trailer;
	}
	
	public void deleteTrailer(Long id) {
		if(id == null || findTrailerById(id) == null) throw TrailerException.createDeleteException("no exist such trailer to delete", null);
		trailerRepository.deleteById(id);
	}
	
	public List<Trailer> findAll() {
		List<Trailer> trailers = new ArrayList<>();
		trailers = trailerRepository.findAll();
		return trailers;
	}

}
