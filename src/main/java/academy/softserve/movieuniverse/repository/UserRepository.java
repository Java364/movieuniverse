package academy.softserve.movieuniverse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import academy.softserve.movieuniverse.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
