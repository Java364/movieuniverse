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
        return genreRepository.save(genre);
    }

    public List<Genre> findAllGenres() {
        return genreRepository.findAll();
    }

    @Transactional
    public void deleteGenreById(Long id) {
        genreRepository.deleteById(id);
    }
}
