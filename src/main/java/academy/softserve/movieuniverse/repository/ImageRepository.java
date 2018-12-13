package academy.softserve.movieuniverse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import academy.softserve.movieuniverse.entity.Image;

public interface ImageRepository extends JpaRepository<Image, Long>{

}
