package academy.softserve.movieuniverse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import academy.softserve.movieuniverse.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
