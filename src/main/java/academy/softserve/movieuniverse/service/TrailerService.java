package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.Trailer;
import academy.softserve.movieuniverse.exception.TrailerException;
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
            throw TrailerException.createSaveException("couldn't save trailer", null);
        trailer = trailerRepository.save(trailer);
        if (trailer == null)
            throw TrailerException.createSaveException("couldn't save trailer", null);
        return trailer;
    }

    public Trailer update(Trailer newTrailer, Long id) {
        if (newTrailer == null) {
            throw TrailerException.createUpdateException("no trailer to update", null);
        }
        return trailerRepository.findById(id).map(trailer -> {
            trailer.setTrailerUrl(newTrailer.getTrailerUrl());
            trailer.setEntryLastUpdate(new Date());
            return trailerRepository.saveAndFlush(trailer);
        }).orElseThrow(() -> TrailerException.createUpdateException("no trailer to update", null));
    }

    public Trailer findById(Long id) {
        Optional<Trailer> trailerOptional = trailerRepository.findById(id);
        if (!trailerOptional.isPresent()) {
            throw TrailerException.createSelectException("no such trailer", new Exception());
        }
        return trailerOptional.get();
    }

    public void deleteById(Long id) {
        if (id == null || !trailerRepository.findById(id).isPresent())
            throw TrailerException.createDeleteException("no exist such trailer to delete", null);
        trailerRepository.deleteById(id);
    }

    public List<Trailer> findAll() {
        return trailerRepository.findAll();
    }

}
