package academy.softserve.movieuniverse.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.softserve.movieuniverse.entity.Poster;

import academy.softserve.movieuniverse.repository.PosterRepository;

@Service
public class PosterService {

	@Autowired
	private PosterRepository posterRepository;

	public Poster createPoster(Poster poster) {
		poster = posterRepository.save(poster);
		return poster;
	}

	public Poster getPoster(Long id) {
		return posterRepository.getOne(id);
	}

	public void deletePoster(Long id) {
		posterRepository.deleteById(id);
	}

	public Optional<Poster> findPosterById(Long id) {
		
		return posterRepository.findById(id);
	}

}
