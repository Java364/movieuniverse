package academy.softserve.movieuniverse.repository;

import academy.softserve.movieuniverse.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
