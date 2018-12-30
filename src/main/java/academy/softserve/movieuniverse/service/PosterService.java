package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.Poster;
import academy.softserve.movieuniverse.exception.ExceptionType;
import academy.softserve.movieuniverse.exception.NotFoundException;

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
            throw NotFoundException.createNotFoundException(ExceptionType.SAVE.getMessage() + " poster");
        return poster;
    }

    public Poster update(Poster poster) {
        poster = posterRepository.save(poster);
        if (poster == null)
            throw NotFoundException.createNotFoundException(ExceptionType.UPDATE.getMessage() + " poster");
        return poster;
}

    public Poster findById(Long id) {
        Optional<Poster> posterOptional = posterRepository.findById(id);
        if (!posterOptional.isPresent()) {
            throw NotFoundException.createNotFoundException(ExceptionType.SELECT.getMessage() + "poster with " + id.toString() + " ID");
        }
        Poster poster = posterOptional.get();
        return poster;
    }

    public void deleteById(Long id) {
        if (id == null || findById(id) == null)
            throw NotFoundException.createNotFoundException(ExceptionType.DELETE.getMessage() + "poster with " + id.toString() + " ID");
        posterRepository.deleteById(id);
    }

    @Transactional
    public Poster remove(Long id) {
        Optional<Poster> posterOptional = posterRepository.findById(id);
        if (!posterOptional.isPresent()) {
            throw NotFoundException.createNotFoundException(ExceptionType.SELECT.getMessage() + "poster with " + id.toString() + " ID");
        }
        Poster poster = posterOptional.get();
        poster.setId(id);
        poster.setIsRemoved(true);
        poster = posterRepository.save(poster);
        return poster;

    }
}
