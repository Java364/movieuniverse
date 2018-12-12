package academy.softserve.movieuniverse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.softserve.movieuniverse.entity.Star;
import academy.softserve.movieuniverse.repository.StarRepository;

@Service
public class StarService {
	
	@Autowired
	private StarRepository starRepository;

	public void saveStar(Star star) {
		starRepository.save(star);
	}

	public List<Star> showAllStars() {
		return starRepository.findAll();
	}

	public Optional<Star> findStarById(Long id) {
		return starRepository.findById(id);
	}

}
