package academy.softserve.movieuniverse.controller.util;

import academy.softserve.movieuniverse.controller.exception.LocationHeaderCreationException;
import org.springframework.hateoas.ResourceSupport;

import java.net.URI;
import java.net.URISyntaxException;

public final class ControllerHateoasUtil {
    private ControllerHateoasUtil() {
    }

    public static URI createLocationHeaderUri(ResourceSupport resource) throws LocationHeaderCreationException {
        URI locationHeaderUri;
        try {
            locationHeaderUri = new URI(resource.getId().expand().getHref());
        } catch (URISyntaxException ex) {
            throw new LocationHeaderCreationException("Failed to create genre resource location header uri", ex);
        }
        return locationHeaderUri;
    }
}
