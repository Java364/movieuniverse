package academy.softserve.movieuniverse.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.softserve.movieuniverse.entity.Star;
import academy.softserve.movieuniverse.repository.StarRepository;
import academy.softserve.movieuniverse.service.StarService;

@Service
public class StarServiceImplementation implements StarService {
	
	@Autowired
	private StarRepository starRepository;

	@Override
	public void saveStar(Star star) {
		starRepository.save(star);
	}

	@Override
	public List<Star> showAllStars() {
		return starRepository.findAll();
	}

	@Override
	public Optional<Star> findStarById(Long id) {
		return starRepository.findById(id);
	}

}
