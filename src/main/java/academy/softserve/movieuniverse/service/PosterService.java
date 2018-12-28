package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.Poster;
import academy.softserve.movieuniverse.exception.PosterException;
import academy.softserve.movieuniverse.repository.PosterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PosterService {

    @Autowired
    private PosterRepository posterRepository;

    public Poster save(Poster poster) {
        poster = posterRepository.save(poster);
        if (poster == null)
            throw PosterException.createSaveException("couldn't save poster", null);
        return poster;
    }

    public Poster update(Poster poster) {
        poster = posterRepository.save(poster);
        if (poster == null)
            throw PosterException.createUpdateException("couldn't update poster", null);
        return poster;
    }

    public Poster findById(Long id) {
        Optional<Poster> posterOptional = posterRepository.findById(id);
        if (!posterOptional.isPresent()) {
            throw PosterException.createSelectException("no such poster", new Exception());
        }
        Poster poster = posterOptional.get();
        return poster;
    }

    public void deleteById(Long id) {
        if (id == null || findById(id) == null)
            throw PosterException.createDeleteException("no exist such poster to delete", null);
        posterRepository.deleteById(id);
    }

    @Transactional
    public Poster remove(Long id) {
        Optional<Poster> posterOptional = posterRepository.findById(id);
        if (!posterOptional.isPresent()) {
            throw PosterException.createSelectException("There is no such poster to remove", null);
        }
        Poster poster = posterOptional.get();
        poster.setId(id);
        poster.setIsRemoved(true);
        poster = posterRepository.save(poster);
        return poster;

    }
}
