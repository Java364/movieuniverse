package academy.softserve.movieuniverse.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

public interface ReversableDtoMapper<E, D> {
    E mapToEntity(D dto);

    D mapToDto(E entity);

    default List<D> mapEntitiesListToDto(List<E> entities) {
        return entities.stream().map(this::mapToDto).collect(Collectors.toList());
    }
}
