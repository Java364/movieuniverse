package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.dto.UserProfileDTO;
import academy.softserve.movieuniverse.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserProfileMapper implements ReversableDtoMapper<User, UserProfileDTO> {

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public User mapToEntity(UserProfileDTO dto) {
        return modelMapper.map(dto, User.class);
    }

    @Override
    public UserProfileDTO mapToDto(User entity) {
        return modelMapper.map(entity, UserProfileDTO.class);
    }

    public List<UserProfileDTO> mapListToDTO(List<User> entities){
        return entities.stream().map(user -> modelMapper.map(user, UserProfileDTO.class)).collect(Collectors.toList());
    }
}
