package academy.softserve.movieuniverse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import academy.softserve.movieuniverse.entity.Trailer;

public interface TrailerRepository extends JpaRepository<Trailer, Long>{

}
