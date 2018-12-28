package academy.softserve.movieuniverse.service.mapper;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface DTOMapper<D, I, E> {
    E mapToEntity(I dto);

    D mapToDTO(E entity);



    default List<D> mapToDTOList(List<E> entities) {
        return entities.stream().map(this::mapToDTO).collect(Collectors.toList());
    }



    default List<E> mapToEntityList(List<I> dtos) {
        return dtos.stream().map(this::mapToEntity).collect(Collectors.toList());


}}
