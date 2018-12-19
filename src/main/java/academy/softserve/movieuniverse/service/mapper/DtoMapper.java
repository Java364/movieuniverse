package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.entity.AbstractEntity;

import java.util.List;

public interface DtoMapper<E extends AbstractEntity> {
    <D> E mapToEntity(D dto);

    <D> D mapToDTO(E entity);

    <D> List<E> mapToEntityList(List<? extends D> dtos);

    <D> List<D> mapToDtoList(List<E> entities);
}
