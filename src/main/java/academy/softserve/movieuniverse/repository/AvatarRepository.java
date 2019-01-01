package academy.softserve.movieuniverse.repository;

import academy.softserve.movieuniverse.entity.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {

}
