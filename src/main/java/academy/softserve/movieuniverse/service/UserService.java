package academy.softserve.movieuniverse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.softserve.movieuniverse.entity.User;
import academy.softserve.movieuniverse.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User createUser(User user) {
		user = userRepository.save(user);
		return user;
	}

	public User getUser(Long id) {
		return userRepository.getOne(id);
	}
}
