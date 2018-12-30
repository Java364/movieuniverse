package academy.softserve.movieuniverse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import academy.softserve.movieuniverse.entity.Avatar;

public interface AvatarRepository extends JpaRepository<Avatar, Long>{

}
