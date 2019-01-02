package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.Trailer;
import academy.softserve.movieuniverse.exception.ExceptionType;
import academy.softserve.movieuniverse.exception.NotFoundException;
import academy.softserve.movieuniverse.repository.TrailerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TrailerService {

    private final TrailerRepository trailerRepository;

    @Autowired
    public TrailerService(TrailerRepository trailerRepository) {
        this.trailerRepository = trailerRepository;
    }

    public Trailer save(Trailer trailer) {
        if (trailer == null || trailer.getId() != null)
            throw new NotFoundException(ExceptionType.SAVE.getMessage() + " trailer");
        trailer = trailerRepository.save(trailer);
        if (trailer == null)
            throw new NotFoundException(ExceptionType.SAVE.getMessage() + " trailer");
        return trailer;
    }

    public Trailer update(Trailer newTrailer, Long id) {
        if (newTrailer == null) {
            throw new NotFoundException(ExceptionType.UPDATE.getMessage() + " trailer");
        }
        return trailerRepository.findById(id).map(trailer -> {
            trailer.setTrailerUrl(newTrailer.getTrailerUrl());
            trailer.setEntryLastUpdate(new Date());
            return trailerRepository.saveAndFlush(trailer);
        }).orElseThrow(() -> new NotFoundException(ExceptionType.UPDATE.getMessage() + " trailer"));
    }

    public Trailer findById(Long id) {
        Optional<Trailer> trailerOptional = trailerRepository.findById(id);
        if (!trailerOptional.isPresent()) {
            throw new NotFoundException(ExceptionType.SELECT.getMessage() + "trailer with " + id.toString() + " ID");
        }
        return trailerOptional.get();
    }

    public void deleteById(Long id) {
        if (id == null || !trailerRepository.findById(id).isPresent())
            throw new NotFoundException(ExceptionType.DELETE.getMessage() + "trailer with " + id.toString() + " ID");
        trailerRepository.deleteById(id);
    }

    public List<Trailer> findAll() {
        return trailerRepository.findAll();
    }

}
