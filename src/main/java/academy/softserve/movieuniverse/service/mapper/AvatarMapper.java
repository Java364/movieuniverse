package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.controller.AvatarController;
import academy.softserve.movieuniverse.dto.AvatarDTO;
import academy.softserve.movieuniverse.entity.Avatar;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Service
public class AvatarMapper {
    public AvatarDTO mapToDTO(Avatar avatar) {
        AvatarDTO avatarDTO = new AvatarDTO();
        avatarDTO.setId(avatar.getId());
        avatarDTO.setName(avatar.getName());
        // avatarDTO.setCreated(avatar.getEntryCreationDate().getTime());
        // avatarDTO.setUpdated(avatar.getEntryLastUpdate().getTime());
        avatarDTO.setSelf(linkTo(methodOn(AvatarController.class).showById(avatar.getId())).withSelfRel().getHref());
        avatarDTO.setImage(avatar.getImageUrl());
        return avatarDTO;
    }

    public Avatar mapToEntity(AvatarDTO avatarDto) {
        Avatar avatar = new Avatar();
        avatar.setName(avatarDto.getName());
        avatar.setImageUrl(avatarDto.getImage());
        return avatar;
    }

    public List<AvatarDTO> mapToDTOList(List<Avatar> entities) {
        return entities.stream().map(this::mapToDTO).collect(Collectors.toList());
    }
}
