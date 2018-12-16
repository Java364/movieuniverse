package academy.softserve.movieuniverse.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.softserve.movieuniverse.entity.Poster;
import academy.softserve.movieuniverse.exception.PosterException;
import academy.softserve.movieuniverse.repository.PosterRepository;

@Service
public class PosterService {

	@Autowired
	private PosterRepository posterRepository;

	public Poster savePoster(Poster poster) {
		poster = posterRepository.save(poster);
		if (poster == null)
			throw PosterException.createSaveException("couldn't save poster", null);
		return poster;
	}

	public Poster updatePoster(Poster poster) {
		poster = posterRepository.save(poster);
		if (poster == null)
			throw PosterException.createUpdateException("couldn't update poster", null);
		return poster;
	}

	public Poster findPosterById(Long id) {
		Optional<Poster> posterOptional = posterRepository.findById(id);
		if (!posterOptional.isPresent()) {
			throw PosterException.createSelectException("no such poster", new Exception());
		}
		Poster poster = posterOptional.get();
		return poster;
	}

	public void deletePoster(Long id) {
		if (id == null || findPosterById(id) == null)
			throw PosterException.createDeleteException("no exist such poster to delete", null);
		posterRepository.deleteById(id);
	}

}
