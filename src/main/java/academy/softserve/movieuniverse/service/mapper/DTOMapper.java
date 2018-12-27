package academy.softserve.movieuniverse.service.mapper;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface DTOMapper<D, I, E> {
    E mapToEntity(I dto);

    D mapToDTO(E entity);

    List<E> mapToEntityList(List<I> dtos);

    List<D> mapToDTOList(List<E> entities);

    default <T> List<E> mapToEntityList(List<T> dtos, Function<T, E> mappingFunction) {
        return dtos.stream().map(mappingFunction).collect(Collectors.toList());
    }

    default List<D> mapToDTOList(List<E> entities, Function<E, D> mappingFunction) {
        return entities.stream().map(mappingFunction).collect(Collectors.toList());
    }
}
