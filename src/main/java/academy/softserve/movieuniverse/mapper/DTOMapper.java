package academy.softserve.movieuniverse.mapper;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface DTOMapper<D, I, E> {
    E mapToEntity(I dto);

    D mapToDTO(E entity);

    default List<D> mapToDTOList(List<E> entities) {
        return entities.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    default <T> List<E> mapToEntityList(List<T> dtos, Function<T, E> mappingFunction) {
        return dtos.stream().map(mappingFunction).collect(Collectors.toList());
    }
}
