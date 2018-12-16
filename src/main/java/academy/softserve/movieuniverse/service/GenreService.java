package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.Genre;
import academy.softserve.movieuniverse.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Service
public class GenreService {
    private static final String NULL_GENRE_ENTITY_MSG = "Genre entity must not be null";

    private GenreRepository genreRepository;
    private EntityExistsValidator<Genre, Long> entityExistsValidator;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
        this.entityExistsValidator = new EntityExistsValidator<>(genreRepository, Genre.class);
    }

    @Transactional
    public Genre saveGenre(@NotNull Genre genre) throws NullPointerException {
        Objects.requireNonNull(genre, NULL_GENRE_ENTITY_MSG);
        return genreRepository.save(genre);
    }

    public List<Genre> findAllGenres() {
        return genreRepository.findAll();
    }

    public void updateGenre(@NotNull Genre updatedGenre) throws EntityNotFoundException, NullPointerException {
        Objects.requireNonNull(updatedGenre, NULL_GENRE_ENTITY_MSG);
        entityExistsValidator.checkIfEntityExists(updatedGenre.getId());
        saveGenre(updatedGenre);
    }

    @Transactional
    public void deleteGenreById(@NotNull Long id) throws EntityNotFoundException, NullPointerException {
        entityExistsValidator.checkIfEntityExists(id);
        genreRepository.deleteById(id);
    }

}
