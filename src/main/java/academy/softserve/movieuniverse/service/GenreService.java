package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.Genre;
import academy.softserve.movieuniverse.exception.DuplicateEntryException;
import academy.softserve.movieuniverse.exception.NoSuchEntityException;
import academy.softserve.movieuniverse.repository.GenreRepository;
import academy.softserve.movieuniverse.service.validator.EntityExistsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
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
    public Genre save(@NotNull Genre genre) throws NullPointerException, DuplicateEntryException {
        Objects.requireNonNull(genre, NULL_GENRE_ENTITY_MSG);
        checkDuplicate(genre);
        return genreRepository.save(genre);
    }

    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Transactional
    public Genre update(Long genreId, @NotNull Genre updatedGenre)
            throws EntityNotFoundException, NullPointerException, DuplicateEntryException {
        Objects.requireNonNull(updatedGenre, NULL_GENRE_ENTITY_MSG);
        entityExistsValidator.checkIfEntityExists(genreId);
        checkDuplicate(updatedGenre);
        updatedGenre.setId(genreId);
        return save(updatedGenre);
    }

    @Transactional
    public void deleteById(@NotNull Long id) throws EntityNotFoundException, NullPointerException {
        entityExistsValidator.checkIfEntityExists(id);
        genreRepository.deleteById(id);
    }

    private void checkDuplicate(Genre genre) throws DuplicateEntryException {
        Genre duplicate = genreRepository.findGenreByName(genre.getName());
        if (duplicate != null) {
            throw new DuplicateEntryException(getClass().getName() + " duplicate entry " + duplicate.getName());
        }
    }

    public Genre findById(Long id) {
        Optional<Genre> genre = genreRepository.findById(id);
        NoSuchEntityException noSuchEntityException = new NoSuchEntityException("Unable to find " + getClass().getName()
                                                                                + " with id " + id);
        return genre.orElseThrow(() -> noSuchEntityException);
    }
}
