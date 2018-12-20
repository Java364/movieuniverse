package academy.softserve.movieuniverse.service.mapper;

import java.util.List;

public interface DtoMapper<D, E> {
    <T> E mapToEntity(T dto);

    D mapToDTO(E entity);

    <T> List<E> mapToEntityList(List<T> dtos);

    List<D> mapToDtoList(List<E> entities);
}
