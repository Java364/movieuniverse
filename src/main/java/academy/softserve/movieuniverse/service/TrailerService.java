package academy.softserve.movieuniverse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.softserve.movieuniverse.entity.Trailer;
import academy.softserve.movieuniverse.repository.TrailerRepository;

@Service
public class TrailerService {
	
	@Autowired
	private TrailerRepository trailerRepository;
	
	public Trailer createTrailer(Trailer trailer) {
		trailer = trailerRepository.save(trailer);
		return trailer;
	}
	
	public Trailer getTrailer(Long id) {
		return trailerRepository.getOne(id);
	}
	
	public void deleteTrailer(Long id) {
		trailerRepository.deleteById(id);
	}
	
	public List<Trailer> findAll() {
		return trailerRepository.findAll();
	}

}
