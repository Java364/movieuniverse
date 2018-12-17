package academy.softserve.movieuniverse.controller.hateoas.userAssembler;

import academy.softserve.movieuniverse.controller.UserController;
import academy.softserve.movieuniverse.dto.user.UserShortInfo;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class UserShortInfoResourceAssembler implements ResourceAssembler<UserShortInfo, Resource<UserShortInfo>> {

    @Override
    public Resource<UserShortInfo> toResource(UserShortInfo userDTO) {
        return new Resource<>(
                userDTO,
                linkTo(methodOn(UserController.class).getUser(userDTO.getId())).withSelfRel());
    }

    public Resources<Resource<UserShortInfo>> listToResource(List<UserShortInfo> users) {
        return new Resources<>(
                users.stream().
                        map(this::toResource).
                        collect(Collectors.toList()),
                linkTo(methodOn(UserController.class).getAllUsers()).withSelfRel()
        );
    }
}
