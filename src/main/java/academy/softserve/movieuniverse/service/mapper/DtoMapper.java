package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.entity.AbstractEntity;

import java.util.List;

public interface DtoMapper<D, R, E extends AbstractEntity> {
    E mapToEntity(R dto);

    D mapToDTO(E entity);

    List<E> mapToEntityList(List<R> dtos);

    List<D> mapToDtoList(List<E> entities);
}
