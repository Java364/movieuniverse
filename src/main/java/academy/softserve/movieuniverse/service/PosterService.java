package academy.softserve.movieuniverse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.softserve.movieuniverse.entity.Poster;
import academy.softserve.movieuniverse.repository.PosterRepository;

@Service
public class PosterService {
	
	@Autowired
	private PosterRepository PosterRepository;
	
	public Poster createPoster(Poster poster) {
		poster = PosterRepository.save(poster);
		return poster;
	}
	
	public Poster getPoster(Long id) {
		return PosterRepository.getOne(id);
	}
	
	public void deletePoster(Long id) {
		PosterRepository.deleteById(id);
	}
	
	

}
