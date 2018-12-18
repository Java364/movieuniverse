package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.entity.AbstractEntity;

import java.util.List;

public interface DtoMapper<D, E extends AbstractEntity> {
    E mapToEntity(D dto);

    D mapToDTO(E entity);

    List<E> mapToEntityList(List<D> dtos);

    List<D> mapToDtoList(List<E> entities);
}
