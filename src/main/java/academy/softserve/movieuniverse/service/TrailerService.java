package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.Trailer;
import academy.softserve.movieuniverse.exception.TrailerException;
import academy.softserve.movieuniverse.repository.TrailerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TrailerService {

    @Autowired
    private TrailerRepository trailerRepository;

    public Trailer saveTrailer(Trailer trailer) {
        if (trailer == null || trailer.getId() != null)
            throw TrailerException.createSaveException("couldn't save trailer", null);
        trailer = trailerRepository.save(trailer);
        if (trailer == null) throw TrailerException.createSaveException("couldn't save trailer", null);
        return trailer;
    }

    public Trailer updateTrailer(Trailer trailer) {
        if (trailer == null || trailer.getId() == null || !trailerRepository.findById(trailer.getId()).isPresent())
            throw TrailerException.createUpdateException("no trailer to update", null);
        trailer = trailerRepository.save(trailer);
        if (trailer == null) throw TrailerException.createUpdateException("couldn't update trailer", null);
        return trailer;
    }

    public Trailer findTrailerById(Long id) {
        Optional<Trailer> trailerOptional = trailerRepository.findById(id);
        if (!trailerOptional.isPresent()) {
            throw TrailerException.createSelectException("no such trailer", new Exception());
        }
        Trailer trailer = trailerOptional.get();
        return trailer;
    }

    public void deleteTrailer(Long id) {
        if (id == null || !trailerRepository.findById(id).isPresent())
            throw TrailerException.createDeleteException("no exist such trailer to delete", null);
        trailerRepository.deleteById(id);
    }

    public List<Trailer> findAll() {
        List<Trailer> trailers = new ArrayList<>();
        trailers = trailerRepository.findAll();
        return trailers;
    }

}
