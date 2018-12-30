package academy.softserve.movieuniverse.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.softserve.movieuniverse.entity.Avatar;
import academy.softserve.movieuniverse.exception.ExceptionType;
import academy.softserve.movieuniverse.exception.NotFoundException;
import academy.softserve.movieuniverse.repository.AvatarRepository;

@Service
public class AvatarService {

	private AvatarRepository repository;

	@Autowired
	public AvatarService(AvatarRepository repository) {
		this.repository = repository;
	}

	public Avatar save(Avatar avatar) {
		avatar = repository.save(avatar);
		if (avatar == null)
			throw NotFoundException.createSaveException(ExceptionType.SAVE
					.getMessage() + " avatar");
		return avatar;
	}

	public Avatar update(Avatar avatar, Long id) {
		avatar.setId(id);
		avatar = repository.save(avatar);
		if (avatar == null)
			throw NotFoundException.createUpdateException(ExceptionType.UPDATE
					.getMessage() + " avatar");
		return avatar;
	}

	public Avatar findById(Long id) {
		Optional<Avatar> avatarOptional = repository.findById(id);
		if (!avatarOptional.isPresent()) {
			throw NotFoundException.createSelectException(ExceptionType.SELECT
					.getMessage() + "avatar with " + id.toString() + " ID");
		}
		Avatar avatar = avatarOptional.get();
		return avatar;
	}

	public void deleteById(Long id) {
		if (id == null || findById(id) == null)
			throw NotFoundException.createDeleteException(ExceptionType.DELETE
					.getMessage() + "avatar with " + id.toString() + " ID");
		repository.deleteById(id);
	}

}
