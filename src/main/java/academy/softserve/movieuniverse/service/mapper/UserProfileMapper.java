package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.dto.UserProfileDTO;
import academy.softserve.movieuniverse.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UserProfileMapper implements ReversableDtoMapper<User, UserProfileDTO> {

    @Autowired
    ModelMapper modelMapper;

    @Override
    public User mapToEntity(UserProfileDTO dto) {

        return null;
    }

    @Override
    public UserProfileDTO mapToDto(User entity) {
        return null;
    }
}
