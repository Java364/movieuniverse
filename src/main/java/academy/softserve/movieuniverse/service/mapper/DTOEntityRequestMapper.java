package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.entity.AbstractEntity;

public interface DTOEntityRequestMapper<D, E extends AbstractEntity, ID> {
    E fromEntityCreateRequest(D dto);

    E fromEntityUpdateRequest(D dto, ID entityId);
}
