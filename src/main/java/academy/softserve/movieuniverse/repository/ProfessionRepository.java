package academy.softserve.movieuniverse.repository;

import academy.softserve.movieuniverse.entity.Profession;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProfessionRepository extends JpaRepository<Profession, Long> {
}
