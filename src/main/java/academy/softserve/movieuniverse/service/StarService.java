package academy.softserve.movieuniverse.service;

import java.util.List;
import java.util.Optional;

import academy.softserve.movieuniverse.entity.Star;

public interface StarService {
	
	void saveStar(Star star);
	
	List<Star> showAllStars();
	
	Optional<Star> findStarById(Long id);
}
