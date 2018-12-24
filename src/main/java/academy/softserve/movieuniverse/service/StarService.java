package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.Links;
import academy.softserve.movieuniverse.entity.Star;
import academy.softserve.movieuniverse.exception.StarException;
import academy.softserve.movieuniverse.repository.StarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.plugin.javascript.navig.Link;

import java.util.List;
import java.util.Optional;

@Service
public class StarService {

    @Autowired
    private StarRepository starRepository;

    @Transactional
    public Star create(Star star) {
        if (star == null) {
            throw StarException.createSaveException("Couldn't create star", null);
        }
        star = starRepository.save(star);
        return star;
    }

    @Transactional
    public Star update(Star star, Long id) {
        Optional<Star> starOptional = starRepository.findById(id);
        if (!starOptional.isPresent()) {
            throw StarException.createSelectException("There is no such star to update", null);
        }
        star.setId(id);
        star = starRepository.save(star);
        return star;
    }

    public List<Star> showAllStars() {
        return starRepository.findAll();
    }

    public Star findStarById(Long id) {
        Optional<Star> starOptional = starRepository.findById(id);
        if (!starOptional.isPresent()) {
            throw StarException.createSelectException("There is no such star", new Exception());
        }
        Star star = starOptional.get();
        return star;
    }

    @Transactional
    public void deleteById(Long id) {
        Optional<Star> starOptional = starRepository.findById(id);
        if (!starOptional.isPresent()) {
            throw StarException.createSelectException("There is no such user to delete", null);
        }
        starRepository.deleteById(id);
    }

    @Transactional
    public Star remove(Long id) {
        Optional<Star> starOptional = starRepository.findById(id);
        if (!starOptional.isPresent()) {
            throw StarException.createSelectException("There is no such star to remove", null);
        }
        Star star = starOptional.get();
        star.setId(id);
        star.setIsRemoved(true);
        star = starRepository.save(star);
        return star;
    }

    @Transactional
    public Star makeActive(Long id) {
        Optional<Star> starOptional = starRepository.findById(id);
        if (!starOptional.isPresent()) {
            throw StarException.createSelectException("There is no such star to make active again", null);
        }
        Star star = starOptional.get();
        star.setId(id);
        star.setIsRemoved(false);
        star = starRepository.save(star);
        return star;
    }
    public Star findAllByLinks(Links links) {

        return starRepository.findByLinks(links);
    }

}
