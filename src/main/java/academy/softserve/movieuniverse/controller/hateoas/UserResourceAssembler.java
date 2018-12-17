package academy.softserve.movieuniverse.controller.hateoas;

import academy.softserve.movieuniverse.controller.UserController;
import academy.softserve.movieuniverse.dto.user.UserDTO;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class UserResourceAssembler implements ResourceAssembler<UserDTO, Resource<UserDTO>> {
    @Override
    public Resource<UserDTO> toResource(UserDTO userDTO) {
        return new Resource<>(
                userDTO,
                linkTo(methodOn(UserController.class).getUser(userDTO.getId())).withSelfRel());
    }

    public Resources<Resource<UserDTO>> listToResource(List<UserDTO> users) {
        return new Resources<>(
                users.stream().
                        map(this::toResource).
                        collect(Collectors.toList()),
                linkTo(methodOn(UserController.class).getAllUsers()).withSelfRel()
        );
    }
}
