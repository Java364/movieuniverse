package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.dto.UserRegistrationDTO;
import academy.softserve.movieuniverse.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserRegistrationMapper implements ReversableDtoMapper<User, UserRegistrationDTO> {

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public User mapToEntity(UserRegistrationDTO dto) {
        return modelMapper.map(dto, User.class);
    }

    @Override
    public UserRegistrationDTO mapToDto(User entity) {
        return modelMapper.map(entity, UserRegistrationDTO.class);
    }
}
