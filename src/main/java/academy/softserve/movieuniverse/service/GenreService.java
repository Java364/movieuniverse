package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.Genre;
import academy.softserve.movieuniverse.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GenreService {
    private GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Transactional
    public Genre saveGenre(Genre genre) {
        // TODO throw genre save exception
        return genreRepository.save(genre);
    }

    public List<Genre> findAllGenres() {
        return genreRepository.findAll();
    }

    public void updateGenre(Genre updatedGenre) {
        boolean genreExists = genreRepository.existsById(updatedGenre.getId());
        if (genreExists) {
            saveGenre(updatedGenre);
        } else {
            // TODO throw genre update exception
        }

    }

    @Transactional
    public void deleteGenreById(Long id) {
        // TODO throw genre delete exception
        genreRepository.deleteById(id);
    }
}
