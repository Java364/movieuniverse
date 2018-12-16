package academy.softserve.movieuniverse.service;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Objects;

public class EntityExistsValidator <T, ID> {
    private JpaRepository<T, ID> jpaRepository;
    private String className;


    public EntityExistsValidator(JpaRepository<T, ID> jpaRepository, Class entity) {
        this.jpaRepository = jpaRepository;
        this.className = entity.getSimpleName();
    }

    public void checkIfEntityExists(ID id) throws EntityNotFoundException, NullPointerException {
        Objects.requireNonNull(id, "Entity id must not be null");
        boolean genreNotFound = !jpaRepository.existsById(id);
        if (genreNotFound) {
            throw new EntityNotFoundException(className + " entity with a given id: " + id + "does not exist.");
        }
    }

}
