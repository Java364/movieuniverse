package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.Genre;
import academy.softserve.movieuniverse.exception.DuplicateEntryException;
import academy.softserve.movieuniverse.repository.GenreRepository;
import academy.softserve.movieuniverse.service.validator.EntityExistsValidator;
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
    public Genre saveGenre(@NotNull Genre genre) throws NullPointerException, DuplicateEntryException {
        Objects.requireNonNull(genre, NULL_GENRE_ENTITY_MSG);
        checkDuplicate(genre);
        return genreRepository.save(genre);
    }

    public List<Genre> findAllGenres() {
        return genreRepository.findAll();
    }

    public Genre updateGenre(@NotNull Genre updatedGenre) throws EntityNotFoundException, NullPointerException,
            DuplicateEntryException {
        Objects.requireNonNull(updatedGenre, NULL_GENRE_ENTITY_MSG);
        entityExistsValidator.checkIfEntityExists(updatedGenre.getId());
        checkDuplicate(updatedGenre);
        return saveGenre(updatedGenre);
    }

    @Transactional
    public void deleteGenreById(@NotNull Long id) throws EntityNotFoundException, NullPointerException {
        entityExistsValidator.checkIfEntityExists(id);
        genreRepository.deleteById(id);
    }

    private void checkDuplicate(Genre genre) throws DuplicateEntryException {
        Genre duplicate = genreRepository.findGenreByName(genre.getName());
        if (duplicate != null) {
            throw new DuplicateEntryException(DuplicateEntryException.createMsg("duplicate name.", Genre.class));
        }
    }

}
