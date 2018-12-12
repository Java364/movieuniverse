package academy.softserve.movieuniverse.service.mapper;

public interface ReversableDtoMapper<E, D> {
    E mapToEntity(D dto);

    D mapToDto(E entity);
}
