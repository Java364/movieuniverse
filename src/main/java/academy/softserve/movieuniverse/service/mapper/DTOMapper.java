package academy.softserve.movieuniverse.service.mapper;

import java.util.List;

public interface DTOMapper<D, E> {
    <T> E mapToEntity(T dto);

    D mapToDTO(E entity);

    <T> List<E> mapToEntityList(List<T> dtos);

    List<D> mapToDTOList(List<E> entities);
}
